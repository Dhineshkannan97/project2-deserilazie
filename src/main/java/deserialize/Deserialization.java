package deserialize;

import Serial.Data;

import java.io.*;
import java.util.ArrayList;

public class Deserialization implements Serializable {
    static String loc = "C:\\Users\\Dhinesh Kannan\\IdeaProjects\\project2\\src\\main\\resources\\e0.txt";

    public Deserialization() {

    }
    public void deserialize() throws IOException, ClassNotFoundException {

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(loc));
        ArrayList<Data> list1 = (ArrayList<Data>) in.readObject();
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).age >= 25)
                System.out.println(list1.get(i).name + ":" + list1.get(i).age + ":" + list1.get(i).id + ":" + list1.get(i).address + ":" + list1.get(i).salary);
        }
        System.out.println("deserilaize done");
        in.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Deserialization dsr = new Deserialization();
        dsr.deserialize();
    }
}
