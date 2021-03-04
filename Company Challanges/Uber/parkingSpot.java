boolean parkingSpot(int[] carDimensions, int[][] parkingLot, int[] luckySpot) {
    
    int i1 = luckySpot[0], j1 = luckySpot[1], i2 = luckySpot[2], j2 = luckySpot[3];
    
    System.out.println((i2-i1+1)+"  "+(j2-j1+1));
    
    if((i2-i1+1)<carDimensions[0] && (i2-i1+1) < carDimensions[1]){
        return false;
    }
    if((j2-j1+1) < carDimensions[1] && (j2-j1+1) < carDimensions[0]){
        return false;
    }
    
    for(int i = i1; i <= i2; i++){
        for(int j = j1; j <= j2; j++){
            if(parkingLot[i][j]==1){
                return false;
            }
        }
    }
    
    
    
    boolean[] check = {true, true, true, true};
    
    for(int i = i1; i <= i2; i++){
        for(int j = 0; j < j1; j++){
            if(parkingLot[i][j] != 0){
                check[0] = false;
                break;
            }
        }
        if(!check[0])
            break;
    }
    
    for(int i = i1; i <= i2; i++){
        for(int j = j2+1; j < parkingLot[0].length; j++){
            if(parkingLot[i][j] != 0){
                check[1] = false;
                break;
            }
        }
        if(!check[1])
            break;
    }
    
    for(int i = 0; i < i1; i++){
        for(int j = j1; j <= j2; j++){
            if(parkingLot[i][j] != 0){
                check[2] = false;
                break;
            }
        }
        if(!check[2])
            break;
    }
    
    for(int i = i2+1; i < parkingLot.length; i++){
        for(int j = j1; j <= j2; j++){
            if(parkingLot[i][j] != 0){
                check[3] = false;
                break;
            }
        }
        if(!check[3])
            break;
    }
    
    if((i2-i1+1) == carDimensions[1] && (check[0] || check[1])){
        return true;
    }
    
    if((j2-j1+1)==carDimensions[1] && (check[2] || check[3])){
        return true;
    }
        
    return false;
}
