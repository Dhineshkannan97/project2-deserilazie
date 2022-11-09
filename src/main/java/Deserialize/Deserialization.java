package Deserialize;
import Serial.TestSerial;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Deserialization implements Serializable {
     int age;
     int id;
     String name;
     float salary;
     String address;
    static String loc = "C:\\Users\\Dhinesh Kannan\\IdeaProjects\\project2\\src\\main\\resources\\e.txt";
    public Deserialization(int age, int id, String name, float salary, String address) throws IOException, ClassNotFoundException {
        super();
        this.age = age;
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.address = address;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(loc));
       TestSerial der = (TestSerial) in.readObject();
        System.out.println("deserilaize done");
        in.close();
    }
}
