package DTO;

import MyLib.MyValidation;
import java.util.Scanner;

public class Student {

    private String id; // formatted: SExxx, x is digit
    private String name; // kí tự, length >=  10
    private  boolean  isRemove = true;

    public Student() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        if(id.isEmpty() == false || id.matches("SE\\d{3}"))
            this.id = id;
    }

    public void setName(String name) {
        if(name.isEmpty() == false || name.length() >= 10)
            this.name = name;
    }

    public void setIsRemove(boolean isRemove) {
        this.isRemove = isRemove;
    }

    public boolean isIsRemove() {
        return isRemove;
    }

    public void inputStu() {
        boolean continute = false;
        Scanner sc = new Scanner(System.in);

        do {
            try {
                
                System.out.println("Input student id");
                id = sc.nextLine();
                boolean result = MyValidation.checkString(id, "SE[0-9]{3}");
                continute = false;
            } catch (Exception e) {
                if (e.getMessage() != null) {
                    System.out.println(e.getMessage());
                    System.out.println("Again!");
                }
                continute = true;
            }
        } while (continute);
        
        do {            
            try {
                System.out.println("Input student name");
                name = sc.nextLine();
                boolean result = MyValidation.checkString(name, "[a-z A-Z]{1,25}");
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
        return  "ID: " + id + "\nName: " + name;
    }
    
}
