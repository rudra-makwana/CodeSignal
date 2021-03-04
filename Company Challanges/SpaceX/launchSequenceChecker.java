boolean launchSequenceChecker(String[] systemNames, int[] stepNumbers) {
    HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    
    for(int i = 0; i < systemNames.length; i++){
        if(map.containsKey(systemNames[i])){
            ArrayList<Integer> seq = new ArrayList<>(map.get(systemNames[i]));
            if(seq.contains(stepNumbers[i])){
                return false;
            }
            seq.add(stepNumbers[i]);
            ArrayList<Integer> temp = new ArrayList<>(seq);
            Collections.sort(temp);
            if(!temp.equals(seq)){
                return false;
            }
            map.put(systemNames[i], seq);
        }
        else{
            ArrayList<Integer> seq = new ArrayList<>();
            seq.add(stepNumbers[i]);
            map.put(systemNames[i], seq);
        }
    }
    
    return true;
}
