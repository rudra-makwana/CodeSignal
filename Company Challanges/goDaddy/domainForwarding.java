String[][] domainForwarding(String[][] redirects) {
    TreeMap<String, HashSet<String>> temp = new TreeMap<>();
    
    for(int i = 0; i < redirects.length; i++){
        if(!temp.containsKey(redirects[i][1])){
            HashSet<String> cur =  new HashSet();
            cur.add(redirects[i][0]);
            temp.put(redirects[i][1], cur);
        }else{
            HashSet<String> cur = temp.get(redirects[i][1]);
            cur.add(redirects[i][0]);
            temp.put(redirects[i][1], cur);
        }
    }
    
    for(int i = 0; i < redirects.length; i++){
        if(!temp.containsKey(redirects[i][1]))
            continue;
        ArrayList<String> values = new ArrayList<String>(temp.get(redirects[i][1]));
        
        for(int j = 0; j < values.size(); j++){
            if(temp.containsKey(values.get(j))){
                values.addAll(temp.get(values.get(j)));
                temp.put(redirects[i][1], new HashSet<String>(values));
                temp.remove(values.get(j));
            }
        }
    }
    String[][] res = new String[temp.size()][];
    int i = 0;
    for(Map.Entry<String,HashSet<String>> entry: temp.entrySet()){
        ArrayList<String> val = new ArrayList<String>(entry.getValue());
        val.add(0, entry.getKey());
        Collections.sort(val);
        res[i] = val.toArray(new String[val.size()]);
        i++;
    }
    
    return res;
}
