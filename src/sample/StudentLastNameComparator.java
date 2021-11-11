package sample;

import java.util.Comparator;

public class StudentLastNameComparator implements Comparator {

    @Override
    public int compare(Object o, Object t1) {
        Student st1 = (Student) o;
        Student st2 = (Student) t1;

        String lastName1 = st1.getLastName();
        String lastName2 = st2.getLastName();

        if (lastName1.compareTo(lastName2) > 0){
            return 1;
        }
        if (lastName1.compareTo(lastName2) < 0){
            return -1;
        }
        return 0;
    }
}
