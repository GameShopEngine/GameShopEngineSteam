/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameShopEngine.LanguageProcessor;

import java.util.Arrays;

/**
 *
 * @author lynden
 */
public class GameShopLanguageProcessor {
    
    public String command;
    
    //object reference????
    
    public String methodName;
    public String[] args;
    
    public GameShopLanguageProcessor(String command){
    
        this.command = command;
        this.methodName = "";
        this.args = new String[1];
        this.args[0] = "";
        
    }
    
    public void process(){
    
        
        int i = 0;
        
        int parenthesisCount = 0;
        
        int argCount = 0;
        
        for (char c: this.command.toCharArray()){
        
            if (c == '('){
            
                parenthesisCount++;
                i++;
                argCount++;
                continue;
            }
            if (i > 0){
            
                  if (parenthesisCount == 1){
                
                    if (c == ','){
                    
                        argCount++;
                    }
                }
                  
                if (c == '('){
                
                    parenthesisCount++;
                    
                }
                
                if (c == ')'){
                
                    parenthesisCount--;
                }
                
              
            }
        }
        
        System.out.println(argCount);
        this.args = new String[argCount];
        
        for (int arg = 0; arg < this.args.length; arg++){
        
            this.args[arg] = "";
        }
        
        i = 0;
        parenthesisCount = 0;
        
        for (char c: this.command.toCharArray()){
        
            if (c == '('){
            
                parenthesisCount++;
                
                if (i == 0){
                i++;
                }
                continue;
            }
            
            if (c == ')'){
                parenthesisCount--;
                //i++;
                continue;
            }
            if (i == 0){
            
                this.methodName += c;
            } else {
            
                 if (parenthesisCount == 1){
                
                    if (c == ','){
                    
                        i++;
                        continue;
                    }  
                }
                
                this.args[i - 1] += c;
                
               
            }
             
        }
        System.out.println(this.methodName + Arrays.toString(args));
       // return new String[1];
    }
    
    public String[] parseArg(String arg){
    
        return arg.split(",");
    }
}
