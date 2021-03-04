int[] tasksTypes(int[] deadlines, int day) {
    int[] res = new int[3];
    for(int i = 0; i < deadlines.length; i++){
        if(deadlines[i] <= day)
            res[0]++;
        else if(deadlines[i]>day && deadlines[i] <= day+7)
            res[1]++;
        else
            res[2]++;
    }
    return res;
}
