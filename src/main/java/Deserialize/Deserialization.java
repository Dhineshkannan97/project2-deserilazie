package Deserialize;
import Serial.Data;

import java.io.*;

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
    public void joinSql() throws IOException, ClassNotFoundException {
        if(age<=24){
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(loc));
            Data der = (Data) in.readObject();
            System.out.println(der.age+der.id+ der.salary+der.address+der.name);
            System.out.println("deserilaize done");
            in.close();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(loc));
       Data der = (Data) in.readObject();
        System.out.println(der.age+der.id+ der.salary+der.address+der.name);
        System.out.println("deserilaize done");
        in.close();
    }
}
