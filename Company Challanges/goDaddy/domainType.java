String[] domainType(String[] domains) {
    String[] types = new String[domains.length];
    
    for(int i = 0 ; i < domains.length; i++){
        String[] temp = domains[i].split("\\.");
        if(temp[temp.length-1].equals("com")){
            types[i] = "commercial";
        }
        else if(temp[temp.length-1].equals("org")){
            types[i] = "organization";
        }
        else if(temp[temp.length-1].equals("net")){
            types[i] = "network";
        }
        else if(temp[temp.length-1].equals("info")){
            types[i] = "information";
        }
    }
    
    return types;
}
