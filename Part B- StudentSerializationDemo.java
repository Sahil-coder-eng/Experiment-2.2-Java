import java.io.*;
import java.util.Scanner;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;  

    private int studentID;
    private String name;
    private double grade;

    public Student(int studentID, String name, double grade) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "StudentID: " + studentID +
               ", Name: " + name +
               ", Grade: " + grade;
    }
}

public class StudentSerializationDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ---- Collect Student Details from User ----
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Grade: ");
        double grade = sc.nextDouble();

        Student student = new Student(id, name, grade);
        String filename = "student.ser";

        // ---- Serialize the object ----
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(student);
            System.out.println("\nStudent object serialized to file: " + filename);
        } catch (IOException e) {
            System.err.println("Serialization failed: " + e.getMessage());
        }

        // ---- Deserialize the object ----
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Student deserialized = (Student) in.readObject();
            System.out.println("Deserialized Student Object:");
            System.out.println(deserialized);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Deserialization failed: " + e.getMessage());
        }

        sc.close();
    }
}
