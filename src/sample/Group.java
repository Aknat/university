package sample;

import java.util.Arrays;
import java.util.Comparator;

import static sample.StudentHelper.readStudentFromConsole;

public class Group {
    String name;
    Student[] students = new Student[6];

    public Group(String name, Student[] students) {
        this.name = name;
        this.students = students;
    }

    public Group(String name) {
        this.name = name;
    }

    public Group() {
    }


    public void addStudent(Student st) throws FullGroupException {

        boolean fullGroup = true;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) continue;
            else {
                students[i] = st;
                fullGroup = false;
                break;
            }
        }
        if (fullGroup) throw new FullGroupException(st);
    }


    public void addStudentFromConsole() throws FullGroupException {
        final Student student = readStudentFromConsole();
        boolean fullGroup = true;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) continue;
            else {
                students[i] = student;
                fullGroup = false;
                break;
            }
        }
        if (fullGroup) throw new FullGroupException(student);
    }


    public void deleteStudent(long id) throws NoStudentException {
        boolean isAbsent = true;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) continue;
            else {
                if (students[i].sheetId == id) {
                    students[i] = null;
                    isAbsent = false;
                    break;
                }
            }
        }
        if (isAbsent) throw new NoStudentException(Long.toString(id));
    }


    public void deleteStudent(String lastName) throws NoStudentException {
        boolean isAbsent = true;
        for (int i = 0; i < students.length; i++) {

            if (students[i] == null) continue;
            else {
                if (students[i].lastName.equalsIgnoreCase(lastName)) {
                    students[i] = null;
                    isAbsent = false;
                }
            }
        }
        if (isAbsent) throw new NoStudentException(lastName);
    }


    public Student searchStudent(String lastName) throws NoStudentException {
        Student foundStudent = null;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) continue;
            else {
                if (students[i].lastName.equalsIgnoreCase(lastName)) {
                    foundStudent = students[i];
                    break;
                }
            }
        }
        if (foundStudent == null) throw new NoStudentException(lastName);
        else return foundStudent;
    }

    
    public String sortStudentsByLastName() {
        Arrays.sort(students, Comparator.nullsLast(new StudentLastNameComparator()));
        return "Current Group{" +
                "name='" + name + '\'' + ", students=" + Arrays.toString(students) +
                '}';
    }


    @Override
    public String toString() {
        Arrays.sort(students, Comparator.nullsLast(new StudentNameComparator()));
        return "Current Group{" +
                "name='" + name + '\'' + ", students=" + Arrays.toString(students) +
                '}';
    }
}
