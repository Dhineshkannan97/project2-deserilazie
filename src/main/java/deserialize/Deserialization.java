package deserialize;
import Serial.Data;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class Deserialization implements Serializable {
    static String loc = "C:\\Users\\Dhinesh Kannan\\IdeaProjects\\project2\\src\\main\\resources\\e.txt";
    Connection conn;

    public Deserialization() {
    }

    public void deserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(loc));
        ArrayList<Data> list1 = (ArrayList<Data>) in.readObject();
        list1.forEach(
                (n) -> {
                    if (n.age >= 25) {
                        System.out.println(n.name + ":" + n.salary + ":" + n.id + ":" + n.age + ":" + n.address);
                        try {
                            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "123456");
                            Statement stmt = conn.createStatement();
                            ResultSet rs = stmt.executeQuery("SELECT * FROM yahoo;");
                            //Select count(*) wher id = Xx
                            //if count == 0 then insert else update
                            String sql1 = "INSERT INTO yahoo (ID,NAME,AGE,ADDRESS,SALARY) "
                                    + "VALUES (" + n.id + ", '" + n.name + "'," + n.age + ", '" + n.address + "'," + n.salary + " );";
                            stmt.executeUpdate(sql1);
//                            String sql2= "update yahoo\n"+
//                                    "set ID = ID- 1\n"+
//                                    "where ID > 6;";
//                            stmt.executeUpdate(sql2);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

        );
        System.out.println("deserilaize done");
        in.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Deserialization dsr = new Deserialization();
        dsr.deserialize();
    }
}
