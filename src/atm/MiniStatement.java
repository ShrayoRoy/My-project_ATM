
package atm;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.event.*;

public class MiniStatement extends JFrame implements ActionListener {
    
    String pinnumber;
    JButton b1;
     
    MiniStatement(String pinnumber){
        
        
        this.pinnumber = pinnumber;
        setTitle("Mini Statement");
        setLayout(null);
        
        JLabel text= new JLabel();
        add(text);
        
        JLabel bank = new JLabel("WORLD BANK");
        bank.setBounds(110,10,150,20);
        bank.setFont(new Font("Times new Roman", Font.BOLD, 20));
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,30,300,200);
        card.setFont(new Font("Times new Roman", Font.BOLD,15));
        add(card);
        
        JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);
        
        try{
            Conn conn= new Conn();
            ResultSet rs = conn.s.executeQuery("Select * from login1 where pinnumber = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        try{
            int bal = 0;
            Conn conn  = new Conn();
            ResultSet rs = conn.s.executeQuery("Select * From bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                text.setText(text.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") +  "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            l4.setText("Your total Balance is Rs "+bal);
        }catch(Exception e){
            System.out.println(e);
        }
        
        setLayout(null);
        b1 = new JButton("Exit");
        add(b1);
        
        b1.addActionListener(this);
        
        text.setBounds(20, 140, 600, 400);
        b1.setBounds(20, 500, 100, 25);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(400,500);
        setLocation(20,20);
        setVisible(true);
        
        
    }
     public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    public static void main(String args[]){
        new MiniStatement("");
    }
    
}
