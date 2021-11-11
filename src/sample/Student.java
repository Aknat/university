package sample;

import java.util.Arrays;

public class Student extends Human {
    String groupName;
    long sheetId;

    public Student(String firstName, String lastName, GenderType gender, String groupName, long sheetId) {
        super(firstName, lastName, gender);
        this.groupName = groupName;
        this.sheetId = sheetId;
    }

    public Student(String firstName) {
        super(firstName);
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
        return "\n"+ "Student{" +
                "groupName='" + groupName + '\'' +
                ", sheetId=" + sheetId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                '}';
    }
}
