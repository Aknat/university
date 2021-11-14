package sample;

public class FullGroupException extends Exception {

    public FullGroupException() {
    }

    public FullGroupException(Student st) {
    }

    public String getMessage(){
        return "Full Group! Impossible to add a student!";
    }

    public String getMessage(Student st) {
        return "Full Group! Impossible to add a student: " + st.getFirstName() + " " + st.getLastName();
    }
}
