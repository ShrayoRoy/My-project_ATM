
package atm;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{

    long random;
    JTextField nameTextField,fnameTextField,dobTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    JRadioButton male,female,others,married,unmarried;
    JDateChooser dateChooser;
    SignupOne(){
        
        setLayout(null);
        Random ran = new Random();
        random=(Math.abs((ran.nextLong() % 9000L) + 1000L));
        
        JLabel formno = new JLabel("APPLICATION FORM NO."+ random );
        formno.setFont(new Font("Times new Roman",Font.BOLD,35));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personDetails = new JLabel("Page 1 : Personal Details");
        personDetails.setFont(new Font("Garamond",Font.BOLD,30));
        personDetails.setBounds(240,80,430,40);
        add(personDetails);
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Garamond",Font.PLAIN,30));
        name.setBounds(80,140,300,30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Garamond",Font.PLAIN,30));
        fname.setBounds(80,195,300,30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD,14));
        fnameTextField.setBounds(300,195,400,30);
        add(fnameTextField);
        
        JLabel dob= new JLabel("DOB: ");
        dob.setFont(new Font("Garamond",Font.PLAIN,30));
        dob.setBounds(80,250,300,20);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,250,400,30);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);
        
               
        JLabel gender= new JLabel("Gender:");
        gender.setFont(new Font("Garamond",Font.PLAIN,30));
        gender.setBounds(80,300,300,20);
        add(gender);
        
       male = new JRadioButton("Male");
        male.setBounds(300,290,60,35);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(400,290,70,35);
        female.setBackground(Color.WHITE);
        add(female);
        
        others = new JRadioButton("Others");
        others.setBounds(500,290,70,35);
        others.setBackground(Color.WHITE);
        add(others);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(others);
    
        JLabel email= new JLabel("E-mail:");
        email.setFont(new Font("Garamond",Font.PLAIN,30));
        email.setBounds(80,350,300,20);
        add( email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD,14));
        emailTextField.setBounds(300,350,400,30);
        add(emailTextField);
        
        JLabel marital= new JLabel("Marital Status:");
        marital.setFont(new Font("Garamond",Font.PLAIN,30));
        marital.setBounds(80,400,300,20);
        add( marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300,390,70,35);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400,390,100,35);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
                
        JLabel address= new JLabel("Address:");
        address.setFont(new Font("Garamond",Font.PLAIN,30));
        address.setBounds(80,450,300,20);
        add( address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD,14));
        addressTextField.setBounds(300,450,400,30);
        add(addressTextField);
        
        JLabel city= new JLabel("City:");
        city.setFont(new Font("Garamond",Font.PLAIN,30));
        city.setBounds(80,500,300,30);
        add( city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD,14));
        cityTextField.setBounds(300,500,400,30);
        add(cityTextField);
        
        JLabel state= new JLabel("State:");
        state.setFont(new Font("Garamond",Font.PLAIN,30));
        state.setBounds(80,550,300,20);
        add( state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD,14));
        stateTextField.setBounds(300,550,400,30);
        add(stateTextField);
        
        JLabel pin= new JLabel("Pin Code:");
        pin.setFont(new Font("Garamond",Font.PLAIN,30));
        pin.setBounds(80,600,300,20);
        add( pin);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD,14));
        pinTextField.setBounds(300,600,400,30);
        add(pinTextField);
        
        next = new JButton("Next");
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.setBounds(620,660,80,40);
        next.setFont(new Font("Times new roman",Font.BOLD,18)); 
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(500,50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String formno = "" +random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }else if(others.isSelected()){
            gender = "Others";
        }
        String email= emailTextField.getText();
        String marital= null;
        if(married.isSelected()){
            marital="marraied";
        }else if(unmarried.isSelected()){
            marital="unmarried";
        }
        String address= addressTextField.getText();
        String city= cityTextField.getText();
        String state = stateTextField.getText();
        String pin= pinTextField.getText();
        
        try{
            
        if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Required to fill");
        } else {
                Conn c= new Conn();
                String query = "Insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);
                
               
                new SignupTwo(formno).setVisible(true);
                 setVisible(false);
                }
        
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        new SignupOne();
    }
}
    
    
        
    
    
    
