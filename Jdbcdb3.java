import java.awt.Color;
import java.awt.Font; 
import java.sql.*;
import javax.swing.*; 

class Jdbcdb3 {

    static Connection con;

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String u, p, url;
        url = "jdbc:mysql://localhost:3306/jdbcdb";
        u = "root";
        p = "root";
        Jdbcdb3.con = DriverManager.getConnection(url, u, p);

        if (con != null) {
            System.out.println("Connection Established Successfully..!!");
        } else {
            System.out.println("Connection Failed");
        }

        JFrame frame = new JFrame("Application form");
        frame.setSize(720,500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color customColor = new Color(128, 180, 207);
        frame.getContentPane().setBackground(customColor);

        Font font = new Font("Times New Roman", Font.BOLD, 20);

        JLabel name = new JLabel("Enter the name of the Applicant:");
        name.setBounds(10, 20, 600, 30);
        name.setFont(font);
        frame.add(name);

        JLabel f_name = new JLabel("Father's Name:");
        f_name.setBounds(10, 60, 250, 30);
        f_name.setFont(font);
        frame.add(f_name);

        JLabel DoB = new JLabel("Date of Birth:");
        DoB.setBounds(10, 100, 250, 30);
        DoB.setFont(font);
        frame.add(DoB);

        JLabel P = new JLabel("Mobile Number:");
        P.setBounds(10, 140, 250, 30);
        P.setFont(font);
        frame.add(P);

        JLabel E = new JLabel("Email:");
        E.setBounds(10, 180, 250, 30);
        E.setFont(font);
        frame.add(E);

        JLabel g = new JLabel("Gender: ");
        g.setBounds(10, 220, 250, 30);
        g.setFont(font);
        frame.add(g);

        JTextField tf=new JTextField("Enter Name..");
        tf.setBounds(330,20,220,30);
        frame.add(tf);

        JTextField tf1=new JTextField("Father's name..");
        tf1.setBounds(330,60,220,30);
        frame.add(tf1);

        JTextField tf2=new JTextField("Date of Birth..");
        tf2.setBounds(330,100,220,30);
        frame.add(tf2);

        JTextField tf3=new JTextField("Phone number..");
        tf3.setBounds(330,140,220,30);
        frame.add(tf3);
        frame.setVisible(true); 

         JTextField tf4=new JTextField("Email address..");
        tf4.setBounds(330,180,220,30);
        frame.add(tf4);
        frame.setVisible(true); 

        JRadioButton male=new JRadioButton("Male");
        male.setBounds(330,220,60,30);
        JRadioButton female=new JRadioButton("Female");
        female.setBounds(400,220,80,30);
        ButtonGroup gp=new ButtonGroup();
        gp.add(male);
        gp.add(female);
         frame.add(male);
        frame.add(female);

        JButton button=new JButton("Submit");
        button.setBounds(450,260,160,50);
        button.setFont(new Font("comic sans MS",Font.BOLD,26));
        button.setFocusable(false);
        frame.add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent k)
            {
                String a=tf.getText().trim();
                String b=tf1.getText().trim();
                String c=tf2.getText().trim();
                String d=tf3.getText().trim();
                String e=tf4.getText().trim();
                String f = male.isSelected() ? "Male" : female.isSelected() ? "Female" :"";
                if(a.isEmpty()||b.isEmpty()||c.isEmpty()||e.isEmpty())
                {
                    JOptionPane.showMessageDialog(frame,"Plaese enter the value","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                insertDataToDB(a, b, c, d, e);
                    tf.setText("");
                    tf1.setText("");
                    tf2.setText("");
                    tf3.setText("");
                    tf4.setText("");
                    gp.clearSelection();
                }
            });
    }
    public static void insertDataToDB(String roll, String name, String college, String branch, String age, String gender){
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO data VALUES(?,?,?,?,?,?)");            
            pst.setString(1,roll);
            pst.setString(2,name);
            pst.setString(3,college);
            pst.setString(4,branch);
            pst.setString(5,age);
            pst.setString(6,gender);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data inserted successfully !!");
            
        } 
        catch (Exception k) {
            k.printStackTrace();
        }
    }


}