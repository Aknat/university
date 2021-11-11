package sample;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class StudentHelper {

    public static Student readStudentFromConsole() {
        Student student = new Student();

        System.out.println("Enter new student's first name");
        Scanner sc1 = new Scanner(System.in);
        student.setFirstName(sc1.nextLine()); // student's name

        System.out.println("Enter new student's last name");
        Scanner sc2 = new Scanner(System.in);
        student.setLastName(sc2.nextLine()); // student's last name

        System.out.println("Enter new student's gender");
        Scanner sc3 = new Scanner(System.in);
        String gender = sc3.nextLine(); // student's gender
        if ((gender.equalsIgnoreCase("female"))
                || (gender.equalsIgnoreCase("f"))) student.setGender(GenderType.FEMALE);
        if ((gender.equalsIgnoreCase("male"))
                || (gender.equalsIgnoreCase("m"))) student.setGender(GenderType.MALE);
        else student.setGender(GenderType.NEUTRAL);

        System.out.println("Enter a new student's sheet id. Enter an integer, otherwise the system generates the id");
        Scanner sc4 = new Scanner(System.in);
        long id;
        try {
            id = sc4.nextLong();
        } catch (InputMismatchException e) {
            id = (long) (Math.random() * 1000000);
        }
        student.setSheetId(id); // student's sheet id

//        System.out.println("A new student [" + student.getFirstName() + " " + student.getLastName() + "] added to the group");

        return student;
    }
}
