/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import DTO.Subject;
import MyLib.MyValidation;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class SubjectList {

    private Subject[] list;
    private int n;

    //cai dat cac ham cons, add, update, remove, xuat
    //tim kiem dua vao id
    //co the viet them cac ham khac neu can
    public SubjectList() {
        list = new Subject[100];
        n = 0;
    }
    
    public boolean addSub(Subject sub){
        if(n > 100){
            System.out.println("List is full");
            return false;
        } 
        list[n] = sub;
        n++;
        return  true;
    }
    
     public Subject findSub(String id)
    {
        for(int i = 0; i < n; i++)
        
            if(list[i].getId().equals(id))
                return list[i];
        return null;
    }
     
     public boolean  updateSub(String id){
        Subject tmp = findSub(id);
        Scanner sc = new Scanner(System.in);
        String newName;
        if(tmp == null){
            System.out.println("Not Found");
            return false;
        } else {
            boolean continute = false;
            do {                
                try {
                    System.out.println("Input new name");
                    newName = sc.nextLine();
                    boolean result = MyValidation.checkString(newName, "[\\w\\d]{3,10}");
                    tmp.setName(newName);
                    continute = false;
                } catch (Exception e) {
                    if(e.getMessage() != null) {
                        System.out.println(e.getMessage());
                        System.out.println("Again!");
                        continute = true;
                    }
                }
            } while (continute);
            return  true;
        } 
    }
     
      public boolean  removeSub(String id){
        Subject tmp = findSub(id);
        if(tmp == null){
            System.out.println("Not Found");
            return false;
        } else {
            tmp.setIsRemove(false);
            return true;
        } 
    }
      
       public void displayAllSub(){
        int count = 0;
        for(int i = 0; i < n; i++){
            if(list[i].isIsRemove()== true){
                System.out.println(list[i].toString());
                count++;
            }
        }
        if(count == 0){
            System.out.println("List is empty");
        }     
    }
     
     public boolean checkList() {
        if (n == 0) {
            return false;
        }
        return true;
    }
}
