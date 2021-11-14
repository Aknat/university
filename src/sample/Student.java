package sample;

import java.util.Arrays;
import java.util.InputMismatchException;

public class Student extends Human implements CSVConverter {
    private String groupName;
    private long sheetId;

    public Student(String firstName, String lastName, GenderType gender, String groupName, long sheetId) {
        super(firstName, lastName, gender);
        this.groupName = groupName;
        this.sheetId = sheetId;
    }

    public Student() {
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public long getSheetId() {
        return sheetId;
    }

    public void setSheetId(long sheetId) {
        this.sheetId = sheetId;
    }

    @Override
    public String toString() {
        return "\n" + "Student{" +
                "groupName='" + groupName + '\'' +
                ", sheetId=" + sheetId +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                ", gender=" + super.getGender() +
                '}';
    }

    @Override
    public String toCSVString() {
        String delimiter = ";";

        return getFirstName() + delimiter +
                getLastName() + delimiter +
                sheetId + delimiter +
                groupName + delimiter +
                getGender();
    }

    @Override
    public Student fromCSVString(String str) {

//        requirements to CSV string:
//        expected delimiter - semi-colon
//        the 1st element should contain Student's first name, otherwise it is set to default (unknown)         / 0
//        the 2nd element should contain Student's last name, otherwise it is set to default (unknown)          / 1
//        the 3rd element should contain Student's sheet id, otherwise the system generates the random id       / 2
//        the 4th element should contain Student's group id, otherwise it is set to default (unknown)           / 3
//        the 5th element should contain Student's gender name, otherwise it is set to default (NEUTRAL)         / 4

        String[] initSubStr = str.split(";");
        String[] subStr = Arrays.copyOf(initSubStr, 5);

        Student student = new Student();

        for (int i = 0; i < subStr.length; i++) {
            if (subStr[i] == null) subStr[i] = "unknown";
            else if (!subStr[i].trim().isEmpty()) subStr[i] = subStr[i].trim();
            else subStr[i] = "unknown";
        }

        student.setFirstName(subStr[0]);
        student.setLastName(subStr[1]);

        long id; // student's sheet id
        try {
            id = Long.parseLong(subStr[2]);
        } catch (NumberFormatException e) {
            id = (long) (Math.random() * 1000000);
        }
        student.setSheetId(id);

        student.setGroupName(subStr[3]);

        String gender = subStr[4]; // student's gender

        if ((gender.equalsIgnoreCase("female"))
                || (gender.equalsIgnoreCase("f"))) student.setGender(GenderType.FEMALE);
        else if ((gender.equalsIgnoreCase("male"))
                || (gender.equalsIgnoreCase("m"))) student.setGender(GenderType.MALE);
        else student.setGender(GenderType.NEUTRAL);

        return student;
    }
}
