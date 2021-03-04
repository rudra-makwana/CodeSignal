int allianceHelp(int t, int allianceSize) {
    if(allianceSize>=10){
        if(t*0.1<60){
            t=t-600;
        }else{
            t=t - (10*((int)(t*0.1)));
        }
    }else{
        if(t*0.1<60){
            t=t-(60*allianceSize);
        }else{
            t=t-allianceSize*((int)(t*0.1));
        }
    }
    if(t<=0){
        t = 0;
    }
    return t;
}
