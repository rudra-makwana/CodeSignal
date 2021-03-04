int[] priceSuggestion(int[] contractData) {
    int[] res = new int[2];
    if(contractData.length == 0)
        return contractData;
    if(contractData.length == 2)
        return contractData;
        
    Arrays.sort(contractData);
    
    if(contractData.length%4 != 0){
        res[0] = contractData[contractData.length/4];
        res[1] = contractData[3*contractData.length/4];
    }
    else{
        System.out.println(contractData[(3*contractData.length/4)-1]+"    "+contractData[3*contractData.length/4]+"  "+(int) Math.ceil((contractData[(3*contractData.length/4)-1]+contractData[3*contractData.length/4])/2));
        res[0] = (int)Math.floor(((double)contractData[(contractData.length/4)-1]+(double)contractData[(contractData.length/4)])/2);
        res[1] = (int) Math.ceil(((double)contractData[(3*contractData.length/4)-1]+(double)contractData[3*contractData.length/4])/2);
    }

    return res;
}
