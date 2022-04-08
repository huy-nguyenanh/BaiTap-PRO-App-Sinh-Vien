
package Manager;

import DTO.Student;
import MyLib.MyValidation;
import java.util.Scanner;

public class StudentList {
    private Student[] list;
    private int n;
    
    //cai dat cac ham cons, add, update, remove, xuat
    //tim kiem dua vao id
    //co the viet them cac ham khac neu can

    public StudentList() {
        list = new Student[100];
        n = 0;
    }
    
    public boolean addStu(Student stu){
        if(n > 100){
            System.out.println("List is full");
            return false;
        } 
        list[n] = stu;
        n++;
        return  true;
    }
  
    public Student findStu(String id)
    {
        for(int i = 0; i < n; i++)
        
            if(list[i].getId().equals(id) && list[i].isIsRemove() == true)
                return list[i];
        return null;
    
    }
    
    public boolean  updateStu(String id){
        Student tmp = findStu(id);
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
                    boolean result = MyValidation.checkString(newName, "[a-z A-Z]{1,25}");
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
    
    public boolean  removeStu(String id){
        Student tmp = findStu(id);
        if(tmp == null){
            System.out.println("Not Found");
            return false;
        } else {
            tmp.setIsRemove(false);
            return  true;
        }
        
    }
    
    public void displayAllStu(){
        int count = 0;
        for(int i = 0; i < n; i++){
            if(list[i].isIsRemove() == true){
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
