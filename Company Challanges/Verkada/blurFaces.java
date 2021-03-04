double[][] blurFaces(int[][] img) {
    double [][] res = new double[img.length][img[0].length];
    
    for(int i = 0; i < img.length; i++){
        for(int j = 0; j < img[0].length; j++){
            if(i == 0 && i != img.length-1){
                if(j == 0 && j != img[0].length-1){
                    res[i][j] = (double)(img[i][j+1] + img[i+1][j] + img[i+1][j+1])/3;
                }
                else if(j == 0 && j == img[0].length-1){
                    res[i][j] = (double)img[i+1][j];
                }
                else if(j == img[0].length-1){
                    res[i][j] = (double)(img[i][j-1] + img[i+1][j] + img[i+1][j-1])/3;
                }
                else{
                    res[i][j] = (double)(img[i][j-1] + img[i+1][j-1] + img[i+1][j] + img[i+1][j+1] + img[i][j+1])/5;
                }
            }
            else if(i ==0 && i == img.length-1){
                if(j == 0 && j != img[0].length-1){
                    res[i][j] = (double)img[i][j+1];
                }
                else if(j == 0 && j == img[0].length-1){
                    res[i][j] = 0;
                }
                else if(j == img[0].length-1){
                    res[i][j] = (double)img[i][j-1];
                }
                else{
                    res[i][j] = (double)(img[i][j-1] + img[i][j+1])/2;
                }
            }
            else if(i == img.length-1){
                if(j == 0 && j != img[0].length-1){
                    res[i][j] = (double)(img[i][j+1] + img[i-1][j] + img[i-1][j+1])/3;
                }
                else if(j == 0 && j == img[0].length-1){
                    res[i][j] = (double)img[i-1][j];
                }
                else if(j == img[0].length-1){
                    res[i][j] = (double)(img[i][j-1] + img[i-1][j] + img[i-1][j-1])/3;
                }
                else{
                    res[i][j] = (double)(img[i][j-1] + img[i-1][j-1] + img[i-1][j] + img[i-1][j+1] + img[i][j+1])/5;
                }
            }
            else{
                if(j == 0 && j != img[0].length-1){
                    res[i][j] = (double)(img[i-1][j] + img[i-1][j+1] + img[i][j+1] + img[i+1][j] + img[i+1][j+1])/5;
                }
                else if(j == 0 && j == img[0].length-1){
                    res[i][j] = (double)(img[i-1][j] + img[i+1][j])/2;
                }
                else if(j == img[0].length-1){
                    res[i][j] = (double)(img[i-1][j] + img[i-1][j-1] + img[i][j-1] + img[i+1][j] + img[i+1][j-1])/5;
                }
                else{
                    res[i][j] = (double)(img[i-1][j] + img[i-1][j-1] + img[i][j-1] + img[i+1][j-1] + img[i+1][j] + img[i+1][j+1] + img[i][j+1] + img[i-1][j+1])/8;
                }
            }
        }    
    }
    return res;
}
