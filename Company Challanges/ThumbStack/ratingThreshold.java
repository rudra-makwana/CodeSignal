int[] ratingThreshold(double threshold, int[][] ratings) {
    ArrayList<Integer> res = new ArrayList<>();
    
    for(int i = 0; i < ratings.length; i++){
        double avg = Arrays.stream(ratings[i]).average().getAsDouble();
        if(avg<threshold)
            res.add(i);
    }
    
    return res.stream().mapToInt(Integer::intValue).toArray();
}
