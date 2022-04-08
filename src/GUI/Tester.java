package GUI;

import DTO.Grades;
import DTO.Student;
import DTO.Subject;
import Manager.GradeList;
import Manager.StudentList;
import Manager.SubjectList;
import MyLib.MyValidation;
import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {
        StudentList stuList = new StudentList();
        SubjectList subList = new SubjectList();
        GradeList graList = new GradeList();
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            menu();
            choice = sc.nextInt();
            switch (choice) {
                case 1: // add Student
                    Student stu = new Student();
                    stu.inputStu();
                    if (stuList.findStu(stu.getId()) == null) {
                        if (stuList.addStu(stu) == true) {
                            System.out.println("Added");
                            System.out.println("");
                        } else {
                            System.out.println("Add fail");
                        }
                    } else {
                        System.out.println("ID student is already in list");
                        System.out.println("Please choice 1 to add student again with different ID");
                    }
                    break;

                case 2: // update Stu by id
                    if (stuList.checkList() == false) {
                        System.out.println("List is empty");
                    }
                    String updateStuID;
                    sc = new Scanner(System.in);
                    boolean continute = false;
                    do {
                        try {
                            System.out.println("Input id want to update");
                            updateStuID = sc.nextLine();
                            if (MyValidation.checkString(updateStuID, "SE\\d{3}")) {
                                stuList.updateStu(updateStuID);
                                System.out.println("Updated!");
                                System.out.println("");
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
                    break;

                case 3: // remove Stu by id
                    if (stuList.checkList() == false) {
                        System.out.println("List is empty");
                    }
                    String removeStuID;
                    sc = new Scanner(System.in);
                    continute = false;
                    do {
                        try {
                            System.out.println("Input id want to remove");
                            removeStuID = sc.nextLine();
                            if (MyValidation.checkString(removeStuID, "SE\\d{3}")) {
                                stuList.removeStu(removeStuID);
                                System.out.println("Removed");
                                System.out.println("");
                                continute = false;
                            } else {
                                throw new Exception();
                            }
                        } catch (Exception e) {
                            System.out.println("Wrong input");
                            System.out.println("Again");
                            System.out.println("");
                            continute = true;
                        }
                    } while (continute);
                    break;

                case 4: // display all stu
                    if (stuList.checkList() == false) {
                        System.out.println("List is empty");
                    }
                    stuList.displayAllStu();
                    break;

                case 5: // add sub
                    Subject sub = new Subject();
                    sub.inputSub();
                    if (subList.findSub(sub.getId()) == null) {
                        if (subList.addSub(sub) == true) {
                            System.out.println("Added");
                            System.out.println("");
                        } else {
                            System.out.println("Add fail");
                        }
                    } else {
                        System.out.println("ID subject is already in list");
                        System.out.println("Please choice 5 to add student again with different ID");
                    }
                    break;

                case 6: // update sub
                    if (subList.checkList() == false) {
                        System.out.println("List is empty");
                    }
                    String updateSubID;
                    sc = new Scanner(System.in);
                    continute = false;
                    do {
                        try {
                            System.out.println("Input id want to update");
                            updateSubID = sc.nextLine();
                            if (updateSubID.length() >= 4) {
                                subList.updateSub(updateSubID);
                                System.out.println("Updated!");
                                System.out.println("");
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
                    break;

                case 7: // remove sub
                    if (subList.checkList() == false) {
                        System.out.println("List is empty");
                    }
                    String removeSubID;
                    sc = new Scanner(System.in);
                    continute = false;
                    do {
                        try {
                            System.out.println("Input id want to remove");
                            removeSubID = sc.nextLine();
                            if (MyValidation.checkString(removeSubID, "[\\w\\d]{3,10}")) {
                                subList.removeSub(removeSubID);
                                System.out.println("Removed");
                                System.out.println("");
                                continute = false;
                            } else {
                                throw new Exception();
                            }
                        } catch (Exception e) {
                            System.out.println("Wrong input");
                            System.out.println("Again");
                            System.out.println("");
                            continute = true;
                        }
                    } while (continute);
                    break;

                case 8: // display sub
                    if (subList.checkList() == false) {
                        System.out.println("List is empty");
                    }
                    subList.displayAllSub();
                    break;

                case 9:  // input grade
                    Grades g = new Grades();
                    String idStu = "",
                     idSub = "";
                    continute = false;
                    do {
                        try {
                            sc = new Scanner(System.in);
                            System.out.println("Enter student Id want to input grade ");
                            idStu = sc.nextLine();
                            if (idStu.matches("SE\\d{3}")) {
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
                            System.out.println("Enter subject Id want to input grade ");
                            idSub = sc.nextLine();
                            if (idSub.length() >= 4) {
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

                    Student tmpStu = stuList.findStu(idStu);
                    Subject tmpSub = subList.findSub(idSub);
                    if (graList.addGrade(g, tmpStu, tmpSub)) {
                        System.out.println("Added");
                    } else {
                        System.out.println("Add fail");
                    }

                    break;
                case 10: // output grade
                    if (graList.checkList() == false) {
                        System.out.println("List is empty");
                    }
                    graList.displayGrade();
                    break;

            }
        } while (choice < 11);
    }

    public static void menu() {

        System.out.println("------------------- Menu------------------- ");
        System.out.println("----      1. Add a new student         ----");
        System.out.println("----      2. Update student by id      ----");
        System.out.println("----      3. Remove student by id      ----");
        System.out.println("----      4. Display all student       ----");
        System.out.println("----      5. Add a new subject         ----");
        System.out.println("----      6. Update subject by id      ----");
        System.out.println("----      7. Remove subject by id      ----");
        System.out.println("----      8. Display all subject       ----");
        System.out.println("----      9. Input grade               ----");
        System.out.println("----      10. Export grade             ----");
        System.out.println("----      11. Exit                     ----");
        System.out.println("Please choice");
    }
}
