int[] longestUncorruptedSegment(int[] sourceArray, int[] destinationArray) {
    int[][] temp = new int[sourceArray.length][2];
    int count = 0;
    for(int i = 0; i < sourceArray.length; i++){
        temp[i][1] = i;
        for(int j = i; j < sourceArray.length; j++){
            if(sourceArray[j] != destinationArray[j]){
                temp[i][0] = count;
                count = 0;
                break;
            }
            else{
                count++;
            }
            
            if(j == sourceArray.length - 1){
                temp[i][0] = count;
                count = 0;
            }
        }
    }
    Arrays.sort(temp, (a, b) -> b[0] - a[0]);
    return temp[0];
}