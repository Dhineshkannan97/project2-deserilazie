package deserialize;

import Serial.Data;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;

public class TestSerial implements Serializable {
    static ArrayList<Serial.Data> list = new ArrayList();
    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "123456");
    Statement stmt;

    public TestSerial() throws SQLException {
        this.stmt = this.conn.createStatement();
    }

    public void insert() throws SQLException {
        this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "123456");
        ResultSet rs = this.stmt.executeQuery("SELECT * FROM Google;");

        while (rs.next()) {
            list.add(new Data(rs.getInt("age"), rs.getInt("id"), rs.getString("name"), rs.getFloat("salary"), rs.getString("address")));
        }

    }

    public void convertFile() throws Exception {
        String loc = "C:\\Users\\Dhinesh Kannan\\IdeaProjects\\project2\\src\\main\\resources\\e.txt";
        System.out.println(loc);
        FileOutputStream file = new FileOutputStream(loc);
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(list);
        System.out.println(list);
        out.flush();
        out.close();
        System.out.println("success");
    }

    public static void main(String[] args) throws Exception {
        Serial.TestSerial ser = new Serial.TestSerial();
        ser.insert();
        ser.convertFile();
    }
}

