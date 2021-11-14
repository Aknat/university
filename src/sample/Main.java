package sample;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("Leia", "Organa", GenderType.FEMALE, "science", 123455);
        Student student2 = new Student("Han", "Solo", GenderType.MALE, "science", 123456);
        Student student3 = new Student("Ben", "Solo", GenderType.MALE, "science", 123457);
        Student student4 = new Student("Padme", "Amidala", GenderType.FEMALE, "science", 123458);
        Student student5 = new Student("Boba", "Fett", GenderType.NEUTRAL, "science", 123459);

        Group groupA = new Group("mars");

        try {
            groupA.addStudent(student1);
        } catch (FullGroupException e) {
            System.out.println(e.getMessage(student1));
        }
        try {
            groupA.addStudent(student2);
        } catch (FullGroupException e) {
            System.out.println(e.getMessage(student2));
        }
        try {
            groupA.addStudent(student3);
        } catch (FullGroupException e) {
            System.out.println(e.getMessage(student3));
        }
        try {
            groupA.addStudent(student4);
        } catch (FullGroupException e) {
            System.out.println(e.getMessage(student4));
        }
        try {
            groupA.addStudent(student5);
        } catch (FullGroupException e) {
            System.out.println(e.getMessage(student5));
        }
        System.out.println("group after creation:" + "\n" + groupA);

        System.out.println(student1.toCSVString());

        Student studentX = new Student().fromCSVString("Eno;Cordova; ; ;  bye  ; trololo ;");
        System.out.println(studentX);


        Group groupC = new Group("mercury");
        try {
            groupC.addStudent(new Student().fromCSVString(""));
        } catch (FullGroupException e) {
            System.out.println(e.getMessage());
        }

        try {
            groupC.addStudent(studentX);
        } catch (FullGroupException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(groupC);


//        System.out.println();
//
//        System.out.println("group after sorting by last name:" + "\n" + groupA.sortStudentsByLastName());
//
//
//        try {
//            groupA.deleteStudent(666);
//        } catch (NoStudentException e) {
//            System.out.println("\n" + e.getMessage());
//        }
//
//
//        try {
//            groupA.deleteStudent("Suvorov");
//        } catch (NoStudentException e) {
//            System.out.println("\n" + e.getMessage());
//        }
//        System.out.println("\n" + "group after member removal:" + "\n" + groupA);
//
//
//        try {
//            System.out.println("\n" + "Student is found in the group:" + groupA.searchStudent("Zoo"));
//        } catch (NoStudentException e) {
//            System.out.println("\n" + e.getMessage());
//        }
//
//        Group groupB = new Group("jupiter");
//        try {
//            groupB.addStudentFromConsole();
//        } catch (FullGroupException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println();
//        System.out.println(groupB);

    }
}
