
package atm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener  {
    
    JButton back;
    String pinnumber;
    JLabel text;
    
    BalanceEnquiry(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
     
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        back = new JButton("BACK");
        back.setBounds(357,510,150,30);
        back.setFont(new Font("Times new roman",Font.BOLD, 15));
        back.addActionListener(this);
        image.add(back);
        
        
        Conn c = new Conn();
        int balance = 0;
        try{   
               
               
               ResultSet rs = c.s.executeQuery("Select * from bank where pin= '"+pinnumber+"'");
               while(rs.next()){
                   if(rs.getString("type").equals("Deposit")){
                       balance += Integer.parseInt(rs.getString("amount"));
                   }else {
                       balance -= Integer.parseInt(rs.getString("amount"));
                   }
               }
        }catch(Exception e){
            System.out.println(e);
        }
        
        text = new JLabel("Your current Account Balance is Rs."+ balance);
        text.setBounds(180,300,400,25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Times new Roman", Font.BOLD, 18));
        image.add(text);
        
        setSize(900,900);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
         new Transactions(pinnumber).setVisible(true);
    }
        
        public static void main(String args[]){
        new BalanceEnquiry("");
        }           
}
                