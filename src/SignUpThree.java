import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpThree extends JFrame implements ActionListener {

    JRadioButton radio1, radio2, radio3, radio4;

    JButton Submit, cancel;

    JCheckBox check1, check2, check3, check4, check5, check6, check7;
    String formno;
    SignUpThree(String formno){
        this.formno = formno;
        setLayout(null);
        JLabel label = new JLabel("Page 3 - Account Details");
        label.setFont(new Font("RaleWay",Font.BOLD,22));
        label.setBounds(280, 40, 400, 40);
        add(label);

        //Acocunt tyep

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("RaleWay",Font.BOLD,22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        radio1 = new JRadioButton("Saving Account");
        radio1.setFont(new Font("Raleway",Font.BOLD,16));
        radio1.setBackground(Color.WHITE);
        radio1.setBounds(100, 180, 150, 20);
        add(radio1);

        radio2 = new JRadioButton("Fixed Deposit Account");
        radio2.setFont(new Font("Raleway",Font.BOLD,16));
        radio2.setBackground(Color.WHITE);
        radio2.setBounds(350, 180, 250, 20);
        add(radio2);

        radio3 = new JRadioButton("Current Account");
        radio3.setFont(new Font("Raleway",Font.BOLD,16));
        radio3.setBackground(Color.WHITE);
        radio3.setBounds(100, 220, 150, 20);
        add(radio3);

        radio4 = new JRadioButton("Reccuring Deposit Account");
        radio4.setFont(new Font("Raleway",Font.BOLD,16));
        radio4.setBackground(Color.WHITE);
        radio4.setBounds(350, 220, 250, 20);
        add(radio4);

        ButtonGroup accountDetails = new ButtonGroup();
        accountDetails.add(radio1);
        accountDetails.add(radio2);
        accountDetails.add(radio3);
        accountDetails.add(radio4);

        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);

        JLabel Number = new JLabel("XXXX-XXXX-XXXX-4134");
        Number.setFont(new Font("Raleway",Font.BOLD,22));
        Number.setBounds(330,300,300,30);
        add(Number);

        JLabel carddetails = new JLabel("Your 16 digit card number");
        carddetails.setFont(new Font("Raleway",Font.BOLD,12));
        carddetails.setBounds(100,330,300,20);
        add(carddetails);

        JLabel PIN = new JLabel("PIN Number");
        PIN.setFont(new Font("Raleway",Font.BOLD,22));
        PIN.setBounds(100,370,200,30);
        add(PIN);

        JLabel pindetails = new JLabel("Your 4 digit pin");
        pindetails.setFont(new Font("Raleway",Font.BOLD,12));
        pindetails.setBounds(100,400,300,20);
        add(pindetails);

        JLabel PINMUMBER = new JLabel("XXXX");
        PINMUMBER.setFont(new Font("Raleway",Font.BOLD,22));
        PINMUMBER.setBounds(330,370,300,30);
        add(PINMUMBER);

        JLabel servicesRequired = new JLabel("Services Required");
        servicesRequired.setFont(new Font("Raleway",Font.BOLD,22));
        servicesRequired.setBounds(100,450,200,30);
        add(servicesRequired);

        check1 = new JCheckBox("ATM CARD");
        check1.setBackground(Color.white);
        check1.setFont(new Font("Raleway", Font.BOLD, 16));
        check1.setBounds(100, 500, 200, 30);
        add(check1);

        check2 = new JCheckBox("Internet Banking");
        check2.setBackground(Color.white);
        check2.setFont(new Font("Raleway", Font.BOLD, 16));
        check2.setBounds(350, 500, 200, 30);
        add(check2);

        check3 = new JCheckBox("Mobile Banking");
        check3.setBackground(Color.white);
        check3.setFont(new Font("Raleway", Font.BOLD, 16));
        check3.setBounds(100, 550, 200, 30);
        add(check3);

        check4 = new JCheckBox("Email and SMS Alerts");
        check4.setBackground(Color.white);
        check4.setFont(new Font("Raleway", Font.BOLD, 16));
        check4.setBounds(350, 550, 200, 30);
        add(check4);

        check5 = new JCheckBox("Cheque Book");
        check5.setBackground(Color.white);
        check5.setFont(new Font("Raleway", Font.BOLD, 16));
        check5.setBounds(100, 600, 200, 30);
        add(check5);

        check6 = new JCheckBox("E-Statement");
        check6.setBackground(Color.white);
        check6.setFont(new Font("Raleway", Font.BOLD, 16));
        check6.setBounds(350, 600, 200, 30);
        add(check6);

        check7 = new JCheckBox("I do hereby declare that all the above information given by me are true to the best of my knowledge and belief.");
        check7.setBackground(Color.white);
        check7.setFont(new Font("Raleway", Font.BOLD, 13));
        check7.setBounds(100, 680, 800, 30);
        add(check7);

        Submit = new JButton("SUBMIT");
        Submit.setBackground(Color.black);
        Submit.setForeground(Color.WHITE);
        Submit.setBounds(250,720,100,30);
        Submit.setFont(new Font("Raleway",Font.BOLD,16));
        Submit.addActionListener(this);
        add(Submit);

        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(420,720,100,30);
        cancel.setFont(new Font("Raleway",Font.BOLD,16));
        cancel.addActionListener(this);
        add(cancel);

        setSize(850, 820);
        setLocation(350, 0);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SignUpThree("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Submit){
            String atype = null;
            if(radio1.isSelected()){
                atype = "Saving Account";
            }
            else if(radio2.isSelected()){
                atype = "Fixed Deposit Account";
            }
            else if(radio3.isSelected()){
                atype = "Current Account";
            }else if(radio4.isSelected()){
                atype = "Recurring Deposit Account";
            }

            Random ran = new Random();
            long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
            String cardno = "" + Math.abs(first7);

            long first3 = (ran.nextLong() % 9000L) + 1000L;
            String pin = "" + Math.abs(first3);

            String facility = "";
            if(check1.isSelected()){
                facility = facility + " ATM Card";
            }
            if(check2.isSelected()){
                facility = facility + " Internet Banking";
            }
            if(check3.isSelected()){
                facility = facility + " Mobile Banking";
            }
            if(check4.isSelected()){
                facility = facility + " EMAIL Alerts";
            }
            if(check5.isSelected()){
                facility = facility + " Cheque Book";
            }
            if(check6.isSelected()){
                facility = facility + " E-Statement";
            }

            try{

                    if(atype.equals("")){
                        JOptionPane.showMessageDialog(null, "Fill all the required fields");
                    }else{
                        Conn c1 = new Conn();
                        String q1 = "insert into signupthree values('"+formno+"','"+atype+"','"+cardno+"','"+pin+"','"+facility+"')";
                        String q2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                        c1.s.executeUpdate(q1);
                        c1.s.executeUpdate(q2);
                        JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:"+ pin);

                        setVisible(false);
                        new Deposit(pin).setVisible(true);

                    }
            }catch (Exception en){
                System.out.println(en);
            }
            
        } else if (e.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
}
