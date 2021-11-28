package sample;

import java.io.*;

public abstract class GroupFileStorage {

    public static void saveGroupToCSV(Group group) {

        File file = new File("/Users/Jupiter/Documents/Development/education/java/progua/university/src/groupFiles/" + group.getName() + ".csv");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < group.getStudents().length; i++) {
            if (group.getStudents()[i] != null) {
                try (PrintWriter pw = new PrintWriter(new FileWriter(file, true))) // дозапись
                {
                    pw.println(group.getStudents()[i].toCSVString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static Group loadGroupFromCSV(File file) {
        Group group = new Group(file.getName());

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String studentString = null;

        for (; ; ) {
            try {
                studentString = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (studentString == null) break;
            Student student = new Student().fromCSVString(studentString);
            try {
                group.addStudent(student);
            } catch (FullGroupException e) {
                System.out.println(e.getMessage());
            }
        }

        return group;
    }


    public static File findFileByGroupName(String groupName, File workFolder) {
        File file = null;
        File[] allFiles = workFolder.listFiles();

        for (File f : allFiles) {
            if (groupName.equalsIgnoreCase(f.getName().replaceAll("\\.[^.]+$", ""))) file = f;
        }

        return file;

    }


}
