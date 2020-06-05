/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hellomegha.hasher;

/**
 * Use the  Honors code of hashing and performed quadratic probing for partial 
 * cluster or say collision
 * @author wanu
 */
public class HashPassword {
    //to equally distribute the key value
    private int hashValue=10007;
    public int hash(String password){
       int hashvalue=0;
        for(int i=0;i<password.length();i++){
        hashvalue = password.charAt(i) + 37*hashvalue; 
        }
        
        hashvalue %=hashValue;
        if(hashvalue <0){
        hashvalue = hashValue;
        }
        return hashvalue;
    }
    
    //collision detection and quadratic probing
    public void checkValue(String userenteredPass, String storedCode){
    int storedValue=Integer.parseInt(storedCode); 
    //have to work a little here will comeback to soon
    
    }
}
