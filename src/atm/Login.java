
package atm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login(){
        
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("atm/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Label = new JLabel(i3);
        Label.setBounds( 100,10,100,100);
        add(Label);
        
        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("ALGERIAN",Font.BOLD,42));
        text.setBounds(250,50,400,40);
        add(text);
        
        JLabel cardno = new JLabel("CARD NO:");
        cardno .setFont(new Font("TIMES NEW ROMAN",Font.BOLD,28));
        cardno .setBounds(250,160,150,40);
        add(cardno );
        
        cardTextField = new JTextField();
        cardTextField.setBounds(410,165,250,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,28));
        pin.setBounds(250,250,400,40);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(410,255,250,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(410,340,110,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login .addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(542,340,118,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear .addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(410,400,250,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup .addActionListener(this);
        add(signup);
        
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        
        setSize(900,550);
        setVisible(true);
        setLocation(500,200); 
        
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if (ae.getSource()== login){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query="select * from login1 where cardnumber ='"+cardnumber+"'and pinnumber = '"+pinnumber+"'";
            try {
               ResultSet rs = conn.s.executeQuery(query);
               if(rs.next()){
                   setVisible(false);
                   new Transactions(pinnumber).setVisible(true);
               }else{
                   JOptionPane.showMessageDialog(null, "Incorrect Card number or Pin");
               }
            }catch (Exception e){
                 System.out.println(e);

            }
        }else if (ae.getSource()== signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
        
      
    public static void main(String args[]){
        new Login();
}  

    }
    
    

