
package atm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    
    JLabel  l1,type,card,number,ndetail,pinno,pnumber,pdetail,service;
    JRadioButton r1, r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit, cancel;
    String formno;
    
    SignupThree( String formno) {
        
    
       this.formno = formno;
       setLayout(null); 
        
        l1= new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Times new Roman",Font.BOLD,30));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        type= new JLabel(" Account Type:");
        type.setFont(new Font("Times new Roman",Font.BOLD,23));
        type.setBounds(100,100,300,30);
        add(type);
        
        r1= new JRadioButton("Saving Account");
        r1.setFont(new Font("Times new Roman",Font.BOLD,15));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,140,200,20);
        add(r1);
        
        r2= new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Times new Roman",Font.BOLD,15));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,140,200,20);
        add(r2);
        
        r3= new JRadioButton("Current Account");
        r3.setFont(new Font("Times new Roman",Font.BOLD,15));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,180,200,20);
        add(r3);
        
        r4= new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Times new Roman",Font.BOLD,15));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,180,250,20);
        add(r4);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        card= new JLabel(" Card Number :");
        card.setFont(new Font("Times new Roman",Font.BOLD,22));
        card.setBounds(100,250,300,30);
        add(card);
        
        number= new JLabel("XXXX-XXXX-XXX-9988");
        number.setFont(new Font("Times new Roman",Font.BOLD,20));
        number.setBounds(350,250,300,30);
        add(number);
        
        ndetail= new JLabel(" Your 16 digits card number.");
        ndetail.setFont(new Font("Times new Roman",Font.BOLD,12));
        ndetail.setBounds(105,270,300,30);
        add(ndetail);
        
        pinno= new JLabel(" Pin Number :");
        pinno.setFont(new Font("Times new Roman",Font.BOLD,22));
        pinno.setBounds(100,310,300,30);
        add(pinno);
        
        pnumber= new JLabel("XXXX");
        pnumber.setFont(new Font("Times new Roman",Font.BOLD,20));
        pnumber.setBounds(350,310,300,30);
        add(pnumber);
        
        pdetail= new JLabel(" Your 4 digits pin number.");
        pdetail.setFont(new Font("Times new Roman",Font.BOLD,12));
        pdetail.setBounds(105,330,300,30);
        add(pdetail);
        
        service= new JLabel(" Services Required :");
        service.setFont(new Font("Times new Roman",Font.BOLD,24));
        service.setBounds(100,390,300,35);
        add(service);
        
        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Times new Roman",Font.BOLD,20));
        c1.setBounds(100,430,200,30);
        add(c1);
        
        c2 = new JCheckBox("Cheque Book");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Times new Roman",Font.BOLD,20));
        c2.setBounds(350,430,150,30);
        add(c2);
        
        c3 = new JCheckBox("Internet Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Times new Roman",Font.BOLD,20));
        c3.setBounds(530,430,300,30);
        add(c3);
        
        c4 = new JCheckBox("Mobile Banking");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Times new Roman",Font.BOLD,20));
        c4.setBounds(100,490,150,30);
        add(c4);
        
        c5 = new JCheckBox("Email and sms Alerts");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Times new Roman",Font.BOLD,20));
        c5.setBounds(530,490,250,30);
        add(c5);
        
        c6 = new JCheckBox("E- statements");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Times new Roman",Font.BOLD,20));
        c6.setBounds(350,490,200,30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declares that the above entered details are corrected to the best of my knowledge ");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Times new Roman",Font.BOLD,16));
        c7.setBounds(100,550,700,30);
        add(c7);
        
        submit= new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Times new Roman", Font.BOLD,22));
        submit.setBounds(250,700,150,30);
        add(submit);
        submit.addActionListener(this);
        
        cancel= new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Times new Roman", Font.BOLD,22));
        cancel.setBounds(410,700,150,30);
        add(cancel);
        cancel.addActionListener(this);
    
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(840,840);
        setLocation(500,120);
        setVisible(true);
 
    }
    
    public void actionPerformed(ActionEvent ae){
        String accountType = null;
        
        Random random = new Random();
            String cardnumber = ""+ Math.abs(random.nextLong()% 900000000L + 5040936000000000L);
            
            
            String pinnumber = ""+ Math.abs((random.nextLong())% 9000L + 1000L);
      
            String facility = "";
            
                
            if(ae.getSource() == submit){
            
            if(r1.isSelected()){
                accountType = "Savings Account";
            }else if(r2.isSelected()){
                accountType = "Fixed Deposit Account";
            }else if(r3.isSelected()){
                accountType = "Current Account";
            }else if(r4.isSelected()){
                accountType = "Reccuring Deposit Account";
            }
  
         
            if(c1.isSelected()){
                facility =facility +"ATM card";
            }else if(c2.isSelected()){
                facility = facility + "Cheque Book";
            }else if(c3.isSelected()){
                facility = facility + "Internet Banking";
            }else if(c4.isSelected()){
                facility = facility + "Mobile Banking";
            }else if(c5.isSelected()){
                facility = facility + "Email and sms Alerts";
            }else if(c6.isSelected()){
                facility = facility + "E-Statements";
            }else if(c7.isSelected()){
                facility = facility + "I hereby declares that the above entered details are corrected to the best of my knowledge";
            }
        
        else if(ae.getSource() == cancel){
          System.exit(0);
        }
            try {
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                }else  {
                    Conn conn = new Conn();
                    String query1 = "insert into Signup3 values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2 = "insert into login1 values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null,"Card number: "+ cardnumber +"\n Pin no: " + pinnumber);

                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);
                        
                }  
                } catch (Exception e){
                System.out.println(e);
            }
            }else if(ae.getSource()== cancel){
                        setVisible(false);
                        new Login().setVisible(true);
        }
            
    }
                     
                   
    public static void main(String args[]){
        new SignupThree("");
    }
}

