int packageBoxing(int[] pkg, int[][] boxes) {
    int c = -1, vol = -1;
    
    Arrays.sort(pkg);
    
    for(int i = 0; i < boxes.length; i++){
        Arrays.sort(boxes[i]);
    }
    
    for(int i = 0; i < boxes.length; i++){
        if(boxes[i].length < pkg.length){
            continue;
        }
        boolean check = false;
        int temp = 1;
        for(int j = 0; j < pkg.length; j++){
            if(pkg[j] > boxes[i][j]){
                check = false;
                break;
            }
            else{
                check = true;
                temp = temp * boxes[i][j];
            }
        }
        if((vol > temp || vol == -1) && check){
            vol = temp;
            c = i;
        }
    }
    
    return c;
}
