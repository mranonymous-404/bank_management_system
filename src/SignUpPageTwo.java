import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignUpPageTwo extends JFrame implements ActionListener {
    JTextField pan, aadhar, pincodeTextField;
    JButton next;
    JRadioButton Syes, Sno, Eyes, Eno;
    String formno;

    JComboBox occupation, religion, income, Education, category;

    SignUpPageTwo(String formno){
        this.formno = formno;
        setLayout(null);

        setTitle("New Account Opening Form : Page-2");


        JLabel AdditionalDetails = new JLabel("Page 2 : Additional Details");
        AdditionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        AdditionalDetails.setBounds(290, 80, 400, 40);
        add(AdditionalDetails);


        JLabel name = new JLabel("Religion : ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        //Drop down using JcomboBox
        String religionArr[] = {"Hindu", "Sikh", "Muslim", "Other"};
        religion = new JComboBox(religionArr);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.white);
        add(religion);


        JLabel fname = new JLabel("Category : ");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        String CategoryArrr[] = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(CategoryArrr);
        category.setBackground(Color.white);
        category.setBounds(300,190,400,30);
        add(category);



        JLabel dob = new JLabel("Income : ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        String incomeArr[] = {"NULL", "< 1.5Lakh", "1.5Lakh - 2.5Lakh", " > 2.5Lakh"};
        income = new JComboBox(incomeArr);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.white);
        add(income);


        JLabel gender = new JLabel("Educational ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        JLabel Email = new JLabel("Qualification : ");
        Email.setFont(new Font("Raleway", Font.BOLD, 20));
        Email.setBounds(100, 315, 200, 30);
        add(Email);

        String QualificationArr[] = {"Non-Graduation", "Graduate", "Post-Graduation", "Doctrate", "Others"};
        Education = new JComboBox(QualificationArr);
        Education.setBounds(300,305,400,30);
        Education.setBackground(Color.white);
        add(Education);


        JLabel Marital = new JLabel("Occupation : ");
        Marital.setFont(new Font("Raleway", Font.BOLD, 20));
        Marital.setBounds(100, 390, 200, 30);
        add(Marital);

        String OccupationArr[] = {"Salaried", "Self-employed", "BussenessMan", "Student", "Retiered", "Other"};
        occupation = new JComboBox(OccupationArr);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.white);
        add(occupation);

        JLabel address = new JLabel("PAN Number : ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);

        JLabel city = new JLabel("Aadhar No. : ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);

        JLabel state = new JLabel("Senior Citizen : ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        Syes = new JRadioButton("Yes");
        Syes.setBounds(300, 540, 100, 30);
        Syes.setBackground(Color.white);
        add(Syes);

        Sno = new JRadioButton("No");
        Sno.setBounds(450, 540, 100, 30);
        Sno.setBackground(Color.white);
        add(Sno);


        //adding this line because both radioButtons are selected when clicked
        // but we want only one selected at a time. so grouping both using ButtonGroup.
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(Syes);
        buttonGroup1.add(Sno);


        JLabel pincode = new JLabel("Existing Acc. : ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        Eyes = new JRadioButton("Yes");
        Eyes.setBounds(300, 590, 100, 30);
        Eyes.setBackground(Color.white);
        add(Eyes);

        Eno = new JRadioButton("No");
        Eno.setBounds(450, 590, 100, 30);
        Eno.setBackground(Color.white);
        add(Eno);


        //adding this line because both radioButtons are selected when clicked
        // but we want only one selected at a time. so grouping both using ButtonGroup.
        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(Eyes);
        buttonGroup2.add(Eno);


        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(620, 660, 80, 30);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.addActionListener(this);
        add(next);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

        getContentPane().setBackground(Color.white);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String Sreligion = (String) religion.getSelectedItem(); // typecast because it return object from gertSelectedItem().
        String Scategory = (String) category.getSelectedItem();
        String Sincome = (String) income.getSelectedItem();
        String Seducation = (String) Education.getSelectedItem();
        String Soccupation = (String) occupation.getSelectedItem();
        String SeniorCitzen = null;
        if(Syes.isSelected()){
            SeniorCitzen = "Yes";
        }else if(Sno.isSelected()){
            SeniorCitzen = "No";
        }
        String ExistingAccount = null;
        if(Eyes.isSelected()){
            ExistingAccount="Yes";
        } else if (Eno.isSelected()) {
            ExistingAccount = "No";
        }

        String panText = pan.getText();
        String aadharText = aadhar.getText();

        try {
                Conn c = new Conn();
                String query = "insert into signupTwo values ('"+formno+"','"+Sreligion+"','"+Scategory+"','"+Sincome+"','"+Seducation+"','"+Soccupation+"','"+SeniorCitzen+"','"+ExistingAccount+"','"+panText+"','"+aadharText+"')";
                c.s.executeUpdate(query);
                // SignUp 3
                setVisible(false);
                new SignUpThree(formno).setVisible(true);
        }catch (Exception en){
            System.out.println(en);
        }
    }



    public static void main(String[] args) {
        new SignUpPageTwo("");
    }


}
