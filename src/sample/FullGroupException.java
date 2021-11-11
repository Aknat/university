package sample;

public class FullGroupException extends Exception {

    public FullGroupException(Student st) {
    }

    public String getMessage(Student st) {
        return "Full Group! Impossible to add a student: " + st.firstName + " " + st.lastName;
    }

}
