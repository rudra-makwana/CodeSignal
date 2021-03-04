double[] fareEstimator(int ride_time, int ride_distance, double[] cost_per_minute, double[] cost_per_mile) 
{
    int n;
    n=cost_per_minute.length;
    double a[]=new double[n];
    for(int i=0;i<n;i++){
        a[i]=(ride_time * cost_per_minute[i]) + (ride_distance * cost_per_mile[i]);
    }
    return a;
}
