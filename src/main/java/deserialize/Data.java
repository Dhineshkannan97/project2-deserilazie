package deserialize;
import java.io.Serializable;
import java.sql.SQLException;
    public class Data implements Serializable {
        public int age;
        public int id;
        public String name;
        public float salary;
        public String address;

        public Data(int age, int id, String name, float salary, String address) throws SQLException {
            this.age = age;
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.address = address;
        }
    }
