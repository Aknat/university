package sample;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static sample.GroupFileStorage.*;

public class Main {
    public static void main(String[] args) {

//        Student student1 = new Student("Leia", "Organa", GenderType.FEMALE, "science", 123455);
//        Student student2 = new Student("Han", "Solo", GenderType.MALE, "science", 123456);
//        Student student3 = new Student("Ben", "Solo", GenderType.MALE, "science", 123457);
//        Student student4 = new Student("Padme", "Amidala", GenderType.FEMALE, "science", 123458);
//        Student student5 = new Student("Boba", "Fett", GenderType.NEUTRAL, "science", 123459);
//
//        Group groupA = new Group("mars");
//
//        try {
//            groupA.addStudent(student1);
//        } catch (FullGroupException e) {
//            System.out.println(e.getMessage(student1));
//        }
//        try {
//            groupA.addStudent(student2);
//        } catch (FullGroupException e) {
//            System.out.println(e.getMessage(student2));
//        }
//        try {
//            groupA.addStudent(student3);
//        } catch (FullGroupException e) {
//            System.out.println(e.getMessage(student3));
//        }
//        try {
//            groupA.addStudent(student4);
//        } catch (FullGroupException e) {
//            System.out.println(e.getMessage(student4));
//        }
//        try {
//            groupA.addStudent(student5);
//        } catch (FullGroupException e) {
//            System.out.println(e.getMessage(student5));
//        }

//        try {
//            groupA.deleteStudent("Solo");
//        } catch (NoStudentException e) {
//            System.out.println(e.getMessage());
//        }


//        saveGroupToCSV(groupA);
//
//        System.out.println(student1.toCSVString());
//
//        Student studentX = new Student().fromCSVString("Eno;Cordova; ; trololo;  bye  ; trololo ;");
//        System.out.println(studentX);
//
//
//        Group groupC = new Group("mercury");
//        try {
//            groupC.addStudent(new Student().fromCSVString("Darth;Vader"));
//        } catch (FullGroupException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            groupC.addStudent(studentX);
//        } catch (FullGroupException e) {
//            System.out.println(e.getMessage());
//        }

//        System.out.println(groupC);
//
//

        File folder = new File("/Users/Jupiter/Documents/Development/education/java/progua/university/src/groupFiles");
        File [] files = folder.listFiles();
//        System.out.println(Arrays.toString(files));
        System.out.println(findFileByGroupName("tro", folder));

        File x = new File("/Users/Jupiter/Documents/Development/education/java/progua/university/src/groupFiles/mars.csv");
//        System.out.println(loadGroupFromCSV(x));
        Group a = new Group(x);
        System.out.println(a);

    }
}
