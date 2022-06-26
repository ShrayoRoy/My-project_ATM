
package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PinChange extends JFrame implements ActionListener {
    
    JPasswordField pin1,repin1;
    JButton change,back;
    JLabel text,Pintext,repintext;
    String pinnumber;
    
    PinChange(String pinnumber){
        
        
        this.pinnumber = pinnumber;
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        text = new JLabel("Change Your Pin");
        text.setBounds(230,260,500,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Times new Roman", Font.BOLD, 23));
        image.add(text);
        
        Pintext = new JLabel("New Pin: ");
        Pintext.setBounds(160,320,180,25);
        Pintext.setForeground(Color.WHITE);
        Pintext.setFont(new Font("Times new Roman", Font.BOLD, 20));
        image.add(Pintext);
        
        pin1 = new JPasswordField();
        pin1.setFont(new Font("Times new roman",Font.BOLD, 25));
        pin1.setBounds(320,320,180,25);
        image.add(pin1);
        
        repintext = new JLabel("Re-Enter new Pin: ");
        repintext.setBounds(160,360,180,25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("Times new Roman", Font.BOLD, 20));
        image.add(repintext);
        
        repin1 = new JPasswordField();
        repin1.setFont(new Font("Times new roman",Font.BOLD, 25));
        repin1.setBounds(320,355,180,25);
        image.add(repin1);
        
        change = new JButton("CHANGE");
        change.setBounds(355,460,150,33);
        change.setFont(new Font("Times new roman",Font.BOLD, 18));
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(355,490,150,33);
        back.setFont(new Font("Times new roman",Font.BOLD, 18));
        back.addActionListener(this);
        image.add(back);
       
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== change){
        try{
            String npin = pin1.getText();
            String rpin = repin1.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"PIN does not match ");
                return;
            }
            
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter PIN.");
                return;
            }
            
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null,"Please re-enter your new PIN.");
                return;
            }
            Conn c1 = new Conn();
                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
                String q2 = "update login1 set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"' ";
                String q3 = "update Signup3 set Pinnumber = '"+rpin+"' where Pinnumber = '"+pinnumber+"' ";

                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                c1.s.executeUpdate(q3);
                
                JOptionPane.showMessageDialog(null,"PIN Changed Successfully.");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
                 
        }catch(Exception e){
            System.out.println(e);
        }
    }else{
          setVisible(false);
          new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }
}
