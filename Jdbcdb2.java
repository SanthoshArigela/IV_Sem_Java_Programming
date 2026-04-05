import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
 class Jdbcdb2{

    static Connection con;
    public static void main(String[] args) throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String u,p,url;
        url="jdbc:mysql://localhost:3306/jdbcdb";
        u="root";
        p="root";
        Jdbcdb2.con=DriverManager.getConnection(url,u,p);
        if(con!=null)
        {
            System.out.println("Connnection established successfully");
        }
        else{
            System.out.println("Connection failed");
        }

        JFrame frame=new JFrame("Student Data Entry");
        frame.setSize(520,520);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Font font=new Font("comic sans Ms",Font.BOLD,18);
        //===Label===
        JLabel roll=new JLabel("Enter your rollnumber");
        roll.setBounds(10,20,250,30);
        roll.setFont(font);
        frame.add(roll);

        JLabel name=new JLabel("Enter your name");
        name.setBounds(10,70,250,30);
        name.setFont(font);
        frame.add(name);

        JLabel college=new JLabel("Enter your college");
        college.setBounds(10,120,250,30);
        college.setFont(font);
        frame.add(college);


        JLabel branch=new JLabel("Enter your branch");
        branch.setBounds(10,170,250,30);
        branch.setFont(font);
        frame.add(branch);


        JLabel age=new JLabel("Enter your age");
        age.setBounds(10,220,250,30);
        age.setFont(font);
        frame.add(age);


        JLabel gender=new JLabel("Enter your gender");
        gender.setBounds(10,270,250,30);
        gender.setFont(font);
        frame.add(gender);

        JTextField tf=new JTextField();
        tf.setBounds(270,20,220,30);
        frame.add(tf);

        JTextField tf1=new JTextField();
        tf1.setBounds(270,70,220,30);
        frame.add(tf1);

        JTextField tf2=new JTextField();
        tf2.setBounds(270,120,220,30);
        frame.add(tf2);

        JTextField tf3=new JTextField();
        tf3.setBounds(270,220,220,30);
        frame.add(tf3);

        String branchs[]={"CSE","AIML","ECE","DS","IT"};
        JComboBox<String> combobox=new JComboBox<>(branchs);
        combobox.setBounds(270,170,220,30);
        frame.add(combobox);

        JRadioButton male=new JRadioButton("Male");
        male.setBounds(270,270,60,30);
        JRadioButton female=new JRadioButton("Female");
        female.setBounds(330,270,80,30);
        JRadioButton chitti=new JRadioButton("Chitti");
        chitti.setBounds(410,270,80,30);
        ButtonGroup gp=new ButtonGroup();
        gp.add(male);
        gp.add(female);
        gp.add(chitti);
        frame.add(male);
        frame.add(female);
        frame.add(chitti);

        JButton button=new JButton("Submit");
        button.setBounds(320,350,160,50);
        button.setFont(new Font("comic sans MS",Font.BOLD,26));
        button.setFocusable(false);
        frame.add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent k)
            {
                String a=tf.getText().trim();
                String b=tf1.getText().trim();
                String c=tf2.getText().trim();
                String d=combobox.getSelectedItem().toString();
                String e=tf3.getText().trim();
                String f = male.isSelected() ? "Male" : female.isSelected() ? "Female" : chitti.isSelected() ? "Chitti" : "";
                if(a.isEmpty()||b.isEmpty()||c.isEmpty()||e.isEmpty())
                {
                    JOptionPane.showMessageDialog(frame,"Plaese enter the value","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                insertDataToDB(a,b,c,d,e,f);
                    tf.setText("");
                    tf1.setText("");
                    tf2.setText("");
                    tf3.setText("");
                    combobox.setSelectedIndex(0);
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