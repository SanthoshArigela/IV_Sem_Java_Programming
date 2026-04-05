
import java.sql.*;

class JDBC{
    public static void main(String[] args)  throws SQLException {
        String url="jdbc:mysql://localhost:3306/jdbcdb";
                    // jdbc:mysql://localhost:3306/jdbcdb
        String u="root";
        String p="root";
        Connection con=DriverManager.getConnection(url, u, p);
        System.out.println("Connection Established..!");
        Statement st=con.createStatement();
        st.executeUpdate("insert into employee value (1,'Alice',29)");
        System.out.println("Data added successfully");
        ResultSet rs=st.executeQuery("select * from employee");
        while(rs.next())
        {
            System.out.println(rs.getInt("id")+'|'+rs.getString("name")+'|'+rs.getInt("age")+'|');
        }
        System.out.println("The table printed successfully");

    }
}