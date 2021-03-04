String fancyRide(int l, double[] fares) {
    String carType = null;
    for(int i = 0; i < fares.length; i++){
        
        System.out.println(fares[i] * l);
        if((fares[i] * l) > 20){
            switch(i-1){
                case 0:
                    carType = "UberX";
                    break;
                
                case 1:
                    carType = "UberXL";
                    break;
                case 2:
                    carType = "UberPlus";
                    break;
                case 3:
                    carType = "UberBlack";
                    break;
                case 4:
                    carType = "UberSUV";
                    break;
                default:
                    carType="error";
                    break;
            }
            break;
        }
        if(i == fares.length-1 && carType == null){
            carType = "UberSUV";
        }
    }
    
    return carType;
}
