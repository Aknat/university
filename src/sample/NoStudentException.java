package sample;

public class NoStudentException extends Exception {
    String input;

    public NoStudentException(String input) {
        this.input = input;
    }

    public NoStudentException() {
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getMessage() {
        return "Student: [" + input + "] not found in the group";
    }

}
