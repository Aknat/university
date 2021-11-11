package sample;

import java.util.Comparator;

public class StudentNameComparator implements Comparator {

    @Override
    public int compare(Object o, Object t1) {
        Student st1 = (Student) o;
        Student st2 = (Student) t1;

        String firstName1 = st1.getFirstName();
        String firstName2 = st2.getFirstName();

        if (firstName1.compareTo(firstName2) > 0){
            return 1;
        }
        if (firstName1.compareTo(firstName2) < 0){
            return -1;
        }
        return 0;
    }
}
