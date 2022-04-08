/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import MyLib.MyValidation;
import java.util.Scanner;


public class Subject {
    private String id;// length >= 4, gồm chữ và số
    private String name;// 3 <= name <= 10
    private boolean isRemove = true;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        if(id.length() >= 4 || id.isEmpty() == false)
            this.id = id;
    }

    public void setName(String name) {
        if((name.length() >= 3 && name.length() <= 10) || name.isEmpty() == false)
             this.name = name;
    }

    public boolean isIsRemove() {
        return isRemove;
    }

    public void setIsRemove(boolean isRemove) {
        this.isRemove = isRemove;
    }
    
    
    
    public void inputSub() {
        boolean continute = false;
        Scanner sc = new Scanner(System.in);

        do {
            try {
                
                System.out.println("Input subject id");
                id = sc.nextLine();
                if(id.length() >= 4)
                    continute = false;
                else throw new Exception();
            } catch (Exception e) {
                System.out.println("Wrong input");
                System.out.println("Again!");
                continute = true;
            }
        } while (continute);
        
        do {            
            try {
                System.out.println("Input subject name");
                name = sc.nextLine();
                boolean result = MyValidation.checkString(name, "[a-z A-Z 0-9]{3,10}");
                continute = false;
            } catch (Exception e) {
                if(e.getMessage() != null){
                    System.out.println(e.getMessage());
                    System.out.println("Again!");
                }
                continute = true;
            }
        } while (continute);
    }

    @Override
    public String toString() {
        return "ID= " + id + ", Name= " + name;
    }
    
}
