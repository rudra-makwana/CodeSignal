String[][][] proCategorization(String[] pros, String[][] preferences) {
    TreeMap<String, ArrayList<String>> map = new TreeMap();
    
    
    for(int i = 0; i < preferences.length; i++){
        for(int j = 0; j < preferences[i].length; j++){
            if(!map.containsKey(preferences[i][j])){
                ArrayList<String> temp = new ArrayList<>();
                temp.add(pros[i]);
                map.put(preferences[i][j], temp);
            }
            else{
                ArrayList<String> temp = map.get(preferences[i][j]);
                temp.add(pros[i]);
                map.replace(preferences[i][j], temp);
            }
        }
    }
    
    int i = 0;
    String[][][] res = new String[map.size()][2][];
    for(Map.Entry<String, ArrayList<String>> mEntry: map.entrySet()){
        ArrayList<String> tempP = new ArrayList<>();
        tempP.add(mEntry.getKey());
        res[i][0] = tempP.toArray(new String[0]);
        ArrayList<String> temp = mEntry.getValue();
        res[i][1] = temp.toArray(new String[0]);
        i++;
    }
    
    return res;
}
