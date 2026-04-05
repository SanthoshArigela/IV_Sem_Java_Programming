import java.sql.*;
public class JdbcConnection1{
    public static void main(String args[]) throws Exception{
        //register the driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        //get connection
        String url,username,password;
        //create database--->create database jdbcdb;
        url="jdbc:mysql://localhost:3306/jdbcdb";
        username="root";
        password="root";
        Connection con=DriverManager.getConnection(url,username,password);
        if(con!=null){
            System.out.println("Connection established successfully.");
        }
        else{
            System.out.println("Connection failed.");
        }
        Statement st=con.createStatement();
        // String query="CREATE TABLE student("+"id int,"+"name varchar(150),"+"branch varchar(10))";
        // st.executeUpdate(query);
        // System.out.println("Table created");
        // String query1="insert into student values (1,'Santhosh','AIML')";
        // String query2="insert into student values (2,'Harshith','AIML')";
        // String query3="insert into student values (3,'Chitti','AIML')";
        // System.out.println("Insert
        // 
        // ed rows");
        // String query="drop table students";
        // System.out.println("Dropped succesfully");
        // con.close();
        // String query = "select * from students";
        // Resultset res=st.executeQuery(query);
        // System.out.println("ID\tName\tBranch");
        // System.out.println("------------------------");
        // while()
    }
}