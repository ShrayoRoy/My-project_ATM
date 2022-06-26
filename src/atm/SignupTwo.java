
package atm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{

    JTextField nameTextField,fnameTextField,qualificationTextField,panTextField,adharnoTextField,seniorTextField,exTextField;
    JButton next;
    JRadioButton seniorcitizen,notseniorcitizen,existacc,noexistacc;
    JComboBox religion,category,educationqualification,occupations,incomes;
    String formno;
    
    SignupTwo(String formno){
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM-PAGE 2");
        
        JLabel additinalDetails = new JLabel("Page 2 : Additinal  Details");
        additinalDetails.setFont(new Font("Garamond",Font.BOLD,30));
        additinalDetails.setBounds(240,80,430,40);
        add(additinalDetails);
        
        JLabel name = new JLabel("Religion");
        name.setFont(new Font("Garamond",Font.PLAIN,30));
        name.setBounds(80,140,300,35);
        add(name);
        
        String valReligion[]={"Hindu","Muslim","Sikh","Christan","Others"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        JLabel fname = new JLabel("Category");
        fname.setFont(new Font("Garamond",Font.PLAIN,30));
        fname.setBounds(80,195,300,35);
        add(fname);
        
        String valCategory[]={"Gneneral","SC","ST","OBC","Others"};
        category = new JComboBox(valCategory);
        category.setBounds(300,195,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel income = new JLabel("Income ");
        income.setFont(new Font("Garamond",Font.PLAIN,30));
        income.setBounds(80,250,300,20);
        add(income);
        
        String valIncome[]={"Null","<1.5lac","<2.5lac","<5 lac","upto 10 lac"};
        incomes = new JComboBox(valIncome);
        incomes.setBounds(300,250,400,30);
        incomes.setBackground(Color.WHITE);
        add(incomes);
              
        JLabel education= new JLabel("Educational");
        education.setFont(new Font("Garamond",Font.PLAIN,30));
        education.setBounds(80,300,300,20);
        add(education);
    
        JLabel qualification= new JLabel("Qualifination:");
        qualification.setFont(new Font("Garamond",Font.PLAIN,30));
        qualification.setBounds(80,330,300,30);
        add( qualification);
        
        String valEducationQ[]={"Non-graduate","Graduate","Post Graduate","Doctorate","Others"};
        educationqualification = new JComboBox(valEducationQ);
        educationqualification.setBounds(300,330,400,30);
        educationqualification.setBackground(Color.WHITE);
        add(educationqualification);
       
        
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Garamond",Font.PLAIN,30));
        occupation.setBounds(80,400,300,30);
        add( occupation);
        
        String valOccupation[]={"Business","Self-employed","Service","Student","Housewife","Retired","6Others"};
        occupations = new JComboBox(valOccupation);
        occupations.setBounds(300,400,400,30);
        occupations.setBackground(Color.WHITE);
        add(occupations);
      
                
        JLabel pan= new JLabel("PAN No:");
        pan.setFont(new Font("Garamond",Font.PLAIN,28));
        pan.setBounds(80,450,300,20);
        add( pan);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD,14));
        panTextField.setBounds(300,450,400,30);
        add(panTextField);
        
        JLabel adharno= new JLabel("Addhar no:");
        adharno.setFont(new Font("Garamond",Font.PLAIN,30));
        adharno.setBounds(80,500,300,30);
        add( adharno);
        
        adharnoTextField = new JTextField();
        adharnoTextField.setFont(new Font("Raleway", Font.BOLD,14));
        adharnoTextField.setBounds(300,500,400,30);
        add(adharnoTextField);
        
        JLabel senior= new JLabel("Senior Citizen:");
        senior.setFont(new Font("Garamond",Font.PLAIN,30));
        senior.setBounds(80,560,300,20);
        add( senior);
        
        seniorcitizen = new JRadioButton("YES");
        seniorcitizen.setBounds(300,550,100,35);
        seniorcitizen.setBackground(Color.WHITE);
        add(seniorcitizen);
        
        notseniorcitizen = new JRadioButton("NO");
        notseniorcitizen.setBounds(450,550,100,35);
        notseniorcitizen.setBackground(Color.WHITE);
        add(notseniorcitizen);

        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(seniorcitizen);
        seniorgroup.add(notseniorcitizen);
                
      
        
        JLabel ex= new JLabel("Existing Account:");
        ex.setFont(new Font("Garamond",Font.PLAIN,30));
        ex.setBounds(80,600,300,34);
        add( ex);
        
        existacc = new JRadioButton("Yes");
        existacc.setBounds(300,600,100,35);
        existacc.setBackground(Color.WHITE);
        add(existacc);
        
        noexistacc = new JRadioButton("NO");
        noexistacc.setBounds(450,600,100,35);
        noexistacc.setBackground(Color.WHITE);
        add(noexistacc);

        ButtonGroup exgroup = new ButtonGroup();
        exgroup.add(existacc);
        exgroup.add(noexistacc);
       
        
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
        
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)incomes.getSelectedItem();
        String seducation=(String)educationqualification.getSelectedItem();
        String soccupation = (String)occupations.getSelectedItem();
        String senior = null;
        if(seniorcitizen.isSelected()){
            senior = "YES";
        }else if(notseniorcitizen.isSelected()){
            senior = "NO";
        }
        String ex = null;
        if(existacc.isSelected()){
            ex="Yes";
        }else if(noexistacc.isSelected()){
            ex="No";
        }
        String pan = panTextField.getText();
        String adharno = adharnoTextField.getText();
        
        try{
                Conn c= new Conn();
                String query = "Insert into Signup2 values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+pan+"','"+adharno+"','"+senior+"','"+ex+"')";
                c.s.executeUpdate(query);
                
        //signup3 object
        setVisible(false);
        new SignupThree(formno).setVisible(true);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        new SignupTwo("");
    }
}

