/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import DTO.Grades;
import DTO.Student;
import DTO.Subject;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class GradeList {

    private Grades[] list;
    private int n;

    //cai dat cac ham cons, add, update, remove, xuat
    //tim kiem dua vao id
    //co the viet them cac ham khac neu can
    public GradeList() {
        list = new Grades[100];
        n = 0;
    }

    public Grades[] getList() {
        return list;
    }

    public int getN() {
        return n;
    }

    public void setList(Grades[] list) {
        this.list = list;
    }

    public void setN(int n) {
        this.n = n;
    }

    public boolean addGrade(Grades g, Student tmpStu, Subject tmpSub) {
        Scanner sc = new Scanner(System.in);
        boolean continute = false;
        
        if (tmpStu == null) {
            System.out.println("List student is empty");
            return false;
        } else if (tmpSub == null) {
            System.out.println("List subject is empty");
            return false;
        } else {
            g.setStu(tmpStu);
            g.setSub(tmpSub);

            do {
                try {
                    sc = new Scanner(System.in);
                    System.out.println("Input PE");
                    float tmpPE = sc.nextFloat();
                    if (tmpPE >= 0) {
                        g.setPE(tmpPE);
                        continute = false;
                    } else {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    System.out.println("Wrong input");
                    System.out.println("Again");
                    continute = true;
                }
            } while (continute);

            do {
                try {
                    sc = new Scanner(System.in);
                    System.out.println("Input FE");
                    float tmpFE = sc.nextFloat();
                    if (tmpFE >= 0) {
                        g.setFE(tmpFE);
                        continute = false;
                    } else {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    System.out.println("Wrong input");
                    System.out.println("Again");
                    continute = true;
                }
            } while (continute);
            list[n] = g;
            n++;
            return true;
        }

    }

    public void displayGrade() {
        for(int i = 0; i < n; i++){
            System.out.println(list[i].toString());
        }

    }
    
     public boolean checkList() {
        if (n == 0) {
            return false;
        }
        return true;
    }
}
