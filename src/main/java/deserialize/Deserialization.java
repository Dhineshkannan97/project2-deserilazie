package deserialize;

import Serial.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class Deserialization implements Serializable {
    static String loc = "C:\\Users\\Dhinesh Kannan\\IdeaProjects\\project2\\src\\main\\resources\\e.txt";

    public Deserialization() {
    }

    public void deserialize() throws IOException, ClassNotFoundException {

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(loc));
        ArrayList<Data> list1 = (ArrayList<Data>) in.readObject();
        list1.forEach(
                (n) -> {
                    if (n.age >= 25) {
                        System.out.println(n.name + ":" + n.salary + ":" + n.id + ":" + n.age + ":" + n.address);
                    }
                }
        );
        System.out.println("deserilaize done");
        in.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Deserialization dsr = new Deserialization();
        dsr.deserialize();
    }
}
