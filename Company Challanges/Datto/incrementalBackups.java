int[] incrementalBackups(int lastBackupTime, int[][] changes) {
    ArrayList<Integer> res = new ArrayList<>();
    
    for(int i = 0; i < changes.length; i++){
        if(changes[i][0] > lastBackupTime){
            res.add(changes[i][1]);
        }
    }
    TreeSet<Integer> s = new TreeSet<>(res);
    
    
    return (s.stream().mapToInt(Integer::intValue).toArray());
}
