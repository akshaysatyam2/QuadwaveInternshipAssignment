import javax.swing.*;

import javax.swing.table.DefaultTableModel;

import java.awt.*;

import java.awt.event.*;

import java.sql.*;

import java.util.*;

public class Quadwave {
    
    public static void main(String[] args)throws Exception 
    {

        EmpDet obj=new EmpDet();
    
    }
}

class EmpDet extends JFrame implements ActionListener
{
    
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2;
    JLabel l1,l2,l3,l4,l5,l6;


    public EmpDet(){
    
        JTextField t1=new JTextField(20);
        t1.setBounds(10, 10, 10, 50);

        JButton b1= new JButton("Search");
        b1.setBounds(20, 10, 10, 50);

        JButton b2= new JButton("Add Employee");
        b2.setBounds(10, 60, 20, 50);

       
        add(t1);

        add(b1);
        add(b2);


        b1.addActionListener(null);
        b2.addActionListener(new ActionListener());
       
       
        
        setVisible(true);
        setSize(400,400);
        setLayout(new GridLayout());//null, FlowLayout, GridLayout
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerfomed(ActionEvent ae){
        
        if(ae.getSource()==b1){

            try {
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/EmpDet","admin", "admin");
    
                PreparedStatement st = (PreparedStatement) connection.prepareStatement("Search With The Help Of EId");
    
                ResultSet rs = st.executeQuery("select * form EmpDet where EId = \" "+t1.getText()+"\"");
    
                DefaultTableModel model = new DefaultTableModel(new String[]{"EId", "EName", "DOJ", "YOE", "Designation"}, 0);
    
              
                while(rs.next())
                {
                    String a = rs.getString(1);
                    String b = rs.getString(2);
                    String c = rs.getString(3);
                    String d = rs.getString(4);
                    String e = rs.getString(5);
                    model.addRow(new Object[]{ a, b, c, d, e});
                }
    
    
                if (!rs.next()) {
                    dispose();
                    JOptionPane.showMessageDialog(b1, "EId Unavilable");
                } 
    
    
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }

        }
        else if(ae.getSource()==b2){
            new AddDetails();
            dispose();
        }

    }

    
}



class AddDetails extends JFrame implements ActionListener
{
    String id,name,doj,desig;
    int yoe;

    
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2;
    JLabel l1,l2,l3,l4,l5,l6;
    
    public AddDetails(){
       
        JLabel l1=new JLabel("Add Employee");
        l1.setBounds(10, 10, 10, 100);

        JLabel l2=new JLabel("EId");
        l2.setBounds(30, 10, 10, 100);
        JTextField t1=new JTextField();
        t1.setBounds(30, 60, 10, 100);

        JLabel l3=new JLabel("Test");
        l3.setBounds(50, 10, 10, 100);
        JTextField t2=new JTextField(20);
        t2.setBounds(50, 100, 10, 100);
        
        JLabel l4=new JLabel("Test");
        l4.setBounds(70, 10, 10, 100);
        JTextField t3=new JTextField(20);
        t3.setBounds(70, 60, 10, 100);
        
        JLabel l5=new JLabel("Test");
        l5.setBounds(90, 10, 10, 100);
        JTextField t4=new JTextField(20);
        t4.setBounds(90, 60, 10, 100);
        
        JLabel l6=new JLabel("Test");
        l6.setBounds(110, 10, 10, 100);
        JTextField t5=new JTextField(20);
        t5.setBounds(110, 60, 10, 100);
        
        
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);

        id=t1.getText();
        name=t1.getText();
        doj=t1.getText();
        yoe=Integer.parseInt(t1.getText());
        desig=t1.getText();

        add(b1);
        add(b2);
        
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        
        b1.addActionListener(null);
        b2.addActionListener(null);
        
        setVisible(true);
        setSize(400,400);
        setLayout(new GridLayout());//null, FlowLayout, GridLayout
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerfomed(ActionEvent ae){
        if(ae.getSource()==b1){

            try {
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/EmpDet","admin", "admin");
    
                PreparedStatement st = (PreparedStatement) connection.prepareStatement("Search With The Help Of EId");
    
                ResultSet rs = st.executeQuery("Insert into EmpDet Values(\""+id+"\", \""+name+"\",\""+doj+"\","+yoe+",\""+desig+"\");");
                JOptionPane.showMessageDialog(b2, "Data Inserted");
    
    
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }

        }
        else if(ae.getSource()==b2){
            
            dispose();

        }
       
    }
}
