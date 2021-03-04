String smartAssigning(String[] names, boolean[] statuses, int[] projects, int[] tasks) {
    String s = null;
    ArrayList<String> namesA = new ArrayList<>(Arrays.asList(names));
    ArrayList<Integer> prj = new ArrayList<>(Arrays.stream(projects).boxed().collect(Collectors.toList()));
    ArrayList<Integer> tsk = new ArrayList<>(Arrays.stream(tasks).boxed().collect(Collectors.toList()));
    for(int i = 0; i < projects.length; i++){
        if(statuses[i]){
            namesA.remove(i);
            prj.remove(i);
            tsk.remove(i);
        }
    }
    String[] nm = namesA.toArray(new String[0]);
    int[] p = prj.stream().mapToInt(Integer::intValue).toArray();
    int[] t = tsk.stream().mapToInt(Integer::intValue).toArray();
    for(int i = 0; i < p.length-1; i++){
        if(t[i] < t[i+1]){
            s = nm[i];
        }
        else if(t[i] > t[i+1]){
            s = nm[i+1];
        }else{
            if(p[i] < p[i+1]){
                s = nm[i];
            }
            else if(p[i] > p[i+1]){
                s = nm[i+1];
            }
            else{
                s = nm[i];
            }
        }
    }
    if(s == null)
        s = nm[0];
    return s;
}
