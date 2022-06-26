
package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.sql.*;

public class Transactions extends JFrame implements ActionListener {
    
    JLabel l1;
    JButton deposit,withdrawl,fc,ms,pc,balance,exit;
    String pinnumber;
    
    Transactions(String pinnumber){ 
         this.pinnumber = pinnumber;
         
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        l1 = new JLabel("Please Select Your Transaction");
        l1.setBounds(210,300,700,35);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Times new Roman", Font.BOLD, 20));
        image.add(l1);
        
        deposit= new JButton("Deposit");
        deposit.setBackground(Color.WHITE);
        deposit.setForeground(Color.BLACK);
        deposit.setFont(new Font("Times new Roman", Font.BOLD,17));
        deposit.setBounds(170,415,150,30);
        image.add(deposit);
        deposit.addActionListener(this);
        
        withdrawl= new JButton("Cash Withdrawl");
        withdrawl.setBackground(Color.WHITE);
        withdrawl.setForeground(Color.BLACK);
        withdrawl.setFont(new Font("Times new Roman", Font.BOLD,16));
        withdrawl.setBounds(355,415,150,30);
        image.add(withdrawl);
        withdrawl.addActionListener(this);
        
        fc= new JButton("Fast Cash");
        fc.setBackground(Color.WHITE);
        fc.setForeground(Color.BLACK);
        fc.setFont(new Font("Times new Roman", Font.BOLD,17));
        fc.setBounds(170,450,150,30);
        image.add(fc);
        fc.addActionListener(this);
        
        ms= new JButton("Mini statement");
        ms.setBackground(Color.WHITE);
        ms.setForeground(Color.BLACK);
        ms.setFont(new Font("Times new Roman", Font.BOLD,16));
        ms.setBounds(355,450,150,30);
        image.add(ms);
        ms.addActionListener(this);
        
        pc= new JButton("Pin Change");
        pc.setBackground(Color.WHITE);
        pc.setForeground(Color.BLACK);
        pc.setFont(new Font("Times new Roman", Font.BOLD,17));
        pc.setBounds(170,485,150,30);
        image.add(pc);
        pc.addActionListener(this);
        
        balance= new JButton("Balance Enquiry");
        balance.setBackground(Color.WHITE);
        balance.setForeground(Color.BLACK);
        balance.setFont(new Font("Times new Roman", Font.BOLD,16));
        balance.setBounds(355,485,150,30);
        image.add(balance);
        balance.addActionListener(this);
        
        exit= new JButton("Exit");
        exit.setBackground(Color.WHITE);
        exit.setForeground(Color.BLACK);
        exit.setFont(new Font("Times new Roman", Font.BOLD,22));
        exit.setBounds(255,520,150,30);
        image.add(exit);
        exit.addActionListener(this);
        
        setSize(900,900);
        setLocation(500,10);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()== exit) {
           System.exit(0);
       } else if(ae.getSource() == deposit){
           setVisible(false);
           new Deposit(pinnumber).setVisible(true);
       }else if(ae.getSource() == withdrawl){
           setVisible(false);
           new Withdrawl(pinnumber).setVisible(true);
       }else if(ae.getSource() == fc){
           setVisible(false);
           new FastCash(pinnumber).setVisible(true);
       }else if(ae.getSource() == pc){
           setVisible(false);
           new PinChange(pinnumber).setVisible(true);
       }else if(ae.getSource() == balance){
           setVisible(false);
           new BalanceEnquiry(pinnumber).setVisible(true);
       }else if(ae.getSource() == ms){
           setVisible(false);
           new MiniStatement(pinnumber).setVisible(true);
       
    }
    }
    
    public static void main(String args[]){
        new Transactions("");
    }
      
  
}
