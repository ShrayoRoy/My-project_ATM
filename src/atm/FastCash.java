
package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    
    JLabel l1;
    JButton deposit,withdrawl,fc,mc,pc,balance,exit;
    String pinnumber;
    
    FastCash(String pinnumber){ 
        
        setLayout(null);
        this.pinnumber = pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
        l1.setBounds(190,300,700,35);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Times new Roman", Font.BOLD, 20));
        image.add(l1);
        
        deposit= new JButton("Rs 100");
        deposit.setBackground(Color.WHITE);
        deposit.setForeground(Color.BLACK);
        deposit.setFont(new Font("Times new Roman", Font.BOLD,17));
        deposit.setBounds(170,415,150,30);
        image.add(deposit);
        deposit.addActionListener(this);
        
        withdrawl= new JButton("Rs 500");
        withdrawl.setBackground(Color.WHITE);
        withdrawl.setForeground(Color.BLACK);
        withdrawl.setFont(new Font("Times new Roman", Font.BOLD,16));
        withdrawl.setBounds(355,415,150,30);
        image.add(withdrawl);
        withdrawl.addActionListener(this);
        
        fc= new JButton("Rs 1000");
        fc.setBackground(Color.WHITE);
        fc.setForeground(Color.BLACK);
        fc.setFont(new Font("Times new Roman", Font.BOLD,17));
        fc.setBounds(170,450,150,30);
        image.add(fc);
        fc.addActionListener(this);
        
        mc= new JButton("Rs 2000");
        mc.setBackground(Color.WHITE);
        mc.setForeground(Color.BLACK);
        mc.setFont(new Font("Times new Roman", Font.BOLD,16));
        mc.setBounds(355,450,150,30);
        image.add(mc);
        mc.addActionListener(this);
        
        pc= new JButton("Rs 5000");
        pc.setBackground(Color.WHITE);
        pc.setForeground(Color.BLACK);
        pc.setFont(new Font("Times new Roman", Font.BOLD,17));
        pc.setBounds(170,485,150,30);
        image.add(pc);
        pc.addActionListener(this);
        
        balance= new JButton("Rs 10000");
        balance.setBackground(Color.WHITE);
        balance.setForeground(Color.BLACK);
        balance.setFont(new Font("Times new Roman", Font.BOLD,16));
        balance.setBounds(355,485,150,30);
        image.add(balance);
        balance.addActionListener(this);
        
        exit= new JButton("BACK");
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
          setVisible(false);
          new Transactions(pinnumber).setVisible(true);
       } else {
           try{   
               String amount = ((JButton)ae.getSource()).getText().substring(3);
               Conn c = new Conn();
               ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pinnumber+"'");
               int balance = 0;
               while(rs.next()){
                   if(rs.getString("type").equals("Deposit")){
                       balance += Integer.parseInt(rs.getString("amount"));
                   }else {
                       balance -= Integer.parseInt(rs.getString("amount"));
                   }
               }
               
               if(ae.getSource()!= exit && balance < Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null,"Insufficient Balance");
                   return;
               }
               
               Date date = new Date();
               String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Rs  "+ amount + "Debited Successfully");
               
               setVisible(false);
                new Transactions(pinnumber).setVisible(true);
           }catch(Exception e){
               System.out.println(e);
           }
       }
    }
    
    public static void main(String args[]){
        new FastCash("");
    }
      
  
}

