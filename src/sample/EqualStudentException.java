package sample;

public class EqualStudentException extends Exception{
    String input;

    public EqualStudentException(String input) {
        this.input = input;
    }

    @Override
    public String getMessage() {
        return "Student: [" + input + "] already in the group";
    }
}
