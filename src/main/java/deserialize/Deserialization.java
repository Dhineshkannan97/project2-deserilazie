package deserialize;
import Serial.Data;
import java.io.*;
public class Deserialization implements Serializable {
    static String loc = "C:\\Users\\Dhinesh Kannan\\IdeaProjects\\project2\\src\\main\\resources\\e.txt";
    public Deserialization() {

    }
    public void deserialize() throws IOException, ClassNotFoundException {

            ObjectInputStream in = new ObjectInputStream(new FileInputStream(loc));
            Data der = (Data) in.readObject();
//        if(der.age>=25){
            System.out.println(der.age+":"+der.id+":"+ der.salary+":"+der.address+":"+der.name);
//        }
            System.out.println("deserilaize done");
            in.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Deserialization dsr = new Deserialization();
        dsr.deserialize();
    }
}
