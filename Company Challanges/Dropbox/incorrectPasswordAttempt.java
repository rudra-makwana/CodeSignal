boolean incorrectPasscodeAttempts(String passcode, String[] attempts) {
    int count = 0;
    
    for(int i = 0; i < attempts.length; i++){
        if(passcode.equals(attempts[i])){
            count = 0;
        }
        else{
            if(count == 9){
                return true;
            }
            else{
                count++;
            }
        }
    }
    
    return false;
}
