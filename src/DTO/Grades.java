/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author ADMIN
 */
public class Grades {

    private Student stu;
    private Subject sub;
    private float PE;
    private float FE;

    public Student getStu() {
        return stu;
    }

    public Subject getSub() {
        return sub;
    }

    public float getPE() {
        return PE;
    }

    public float getFE() {
        return FE;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }

    public void setSub(Subject sub) {
        this.sub = sub;
    }

    public void setPE(float PE) {
        if (PE >= 0) {
            this.PE = PE;
        }
    }

    public void setFE(float FE) {
        if (FE >= 0) {
            this.FE = FE;
        }
    }

    @Override
    public String toString() {
        return "Student\n" + stu + "\nSubject\n" + sub + "\nGrade\n" + "PE = " + PE + ", FE=" + FE;
    }

}
