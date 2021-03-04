import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

// Main class should be named 'Solution'
class Solution {
    public static ArrayList<String> filePath = new ArrayList<>();
    public static ArrayList<String> ipAddresses = new ArrayList<>();
    
    public static void getFilesPath(File[] file, String path){        
        for(File f: file){
            if(f.isFile()){
                filePath.add(path+"/"+f.getName());
            }
            if(f.isDirectory()){
                getFilesPath(f.listFiles(), path+"/"+f.getName());
            }
        }
    }
    
    public static void getFilesPathArray(String rootPath){
        File mainDir = new File(rootPath);
        File[] file = null;
        if(mainDir.exists() && mainDir.isDirectory()){
            file = mainDir.listFiles();
        }
        
        getFilesPath(file, rootPath);
    }
    
    public static void checkForIpAddresses(String fileName){
        String input = "";
        
        File file = new File(fileName);
        
        try{
            Scanner scn = new Scanner(file);
            while(scn.hasNextLine()){
                input += scn.nextLine() + " ";
            }
        }
        catch(FileNotFoundException exception){
            exception.printStackTrace();
        }
        
        Pattern pattern = 
        Pattern.compile("(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)");
        
        Matcher match = pattern.matcher(input);
        
        while(match.find()){
            ipAddresses.add(match.group());
        }
    }
    
    public static void main(String[] args) {
        String mainDirPath = "/root/data";
        
        getFilesPathArray(mainDirPath);
        for(String s: filePath){
            checkForIpAddresses(s);
        }
        
        Set<String> ipAddreSet = new HashSet<String>(ipAddresses);
        
        List<String> ips = new ArrayList<>(ipAddreSet);
        
        Collections.sort(ips);
                
        for(String ip: ips){
            System.out.println(ip);
        }
    }
}
