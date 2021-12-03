package sample;

import java.io.File;
import java.util.*;

import static sample.StudentHelper.readStudentFromConsole;

public class Group {
    private final int groupCapacity = 10;
    private String name;
    private List<Student> students = new ArrayList<>();

    public Group(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public Group(File file) {
        this.name = file.getName().replaceAll("\\.[^.]+$", "");
        this.students = GroupFileStorage.loadGroupFromCSV(file).getStudents();

    }

    public Group(String name) {
        this.name = name;
    }

    public Group() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    public void addStudent(Student st) throws FullGroupException {
        if (students.size() < groupCapacity) {
            st.setGroupName(name);
            students.add(st);
        } else throw new FullGroupException(st);
    }


    public void addStudentCheckForDuplicates(Student st) throws FullGroupException, EqualStudentException {
        if (isStudentInGroup(st)) throw new EqualStudentException(st.getLastName());
        else {
            if (students.size() < groupCapacity) {
                st.setGroupName(name);
                students.add(st);
            } else throw new FullGroupException(st);
        }
    }

    public boolean isStudentInGroup(Student st) {
        boolean result = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).equals(st)) {
                result = true;
                break;
            }
        }
        return result;

    }

    public void addStudentFromConsole() throws FullGroupException {
        final Student student = readStudentFromConsole();
        addStudent(student);
    }


    public void deleteStudent(long id) throws NoStudentException {
        boolean isAbsent = true;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getSheetId() == id) {
                students.remove(i);
                isAbsent = false;
                break;
            }
        }
        if (isAbsent) throw new NoStudentException(Long.toString(id));
    }


    public void deleteStudent(String lastName) throws NoStudentException {
        boolean isAbsent = true;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getLastName().equalsIgnoreCase(lastName)) {
                students.remove(i);
                isAbsent = false;
            }
        }
        if (isAbsent) throw new NoStudentException(lastName);
    }


    public List<Student> searchStudent(String lastName) throws NoStudentException {
        List<Student> foundStudents = new ArrayList();
        Student foundStudent = null;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getLastName().equalsIgnoreCase(lastName)) {
                foundStudent = students.get(i);
                foundStudents.add(foundStudent);
            }
        }
        if (foundStudents.size() == 0) throw new NoStudentException(lastName);
        else return foundStudents;
    }


    public void saveGroup() {
    }


    public String sortStudentsByLastName() {
        Collections.sort(students, Comparator.nullsLast(new StudentLastNameComparator()));
        return "Current Group {" +
                "name='" + name + '\'' + ", students=" + students + '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name) && students.equals(group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupCapacity, name, students);
    }

    @Override
    public String toString() {
        Collections.sort(students, Comparator.nullsLast(new StudentNameComparator()));
        return "Current Group {" +
                "name='" + name + '\'' + ", students=" + students + '}';
    }
}
