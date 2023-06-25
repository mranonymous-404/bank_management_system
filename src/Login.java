import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    // settin the Jbuttons Globally as it is declared locally previously but we want it to access outside class
    JButton SignUp, login, Clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setTitle("Automated teller Machine"); //it is used to set title of the frame.

        // setting layout null because as we using custom layout named setBounds. but still it is in center
        // because by default swing java is still using it default layout which is by default centered.
        // so setting default layout to null.
        setLayout(null);

        // using ClassLoader systemresourse method because image will be loaded from system
        ImageIcon icn = new ImageIcon(ClassLoader.getSystemResource("iconss/logo.jpg"));
        // we're creating the object of Image class which will take object of the imageicon
        // and getimage will load tha getScale will scale that image
        Image icn2 = icn.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);

        // we can't add Image object directly to Jlable so we have to convert it to ImageIcon.
        ImageIcon icn3 = new ImageIcon(icn2);

        //we can't place images directly on the frame.
        // so we have to give Jlable and add that lable to the frame using add method.

        JLabel lable = new JLabel(icn3);

        // setting the location of the icon on the frame.
        lable.setBounds(70,10,100,100);

        add(lable);

        // we have to take whole frame using getContentPane and then set color using setBackground
        getContentPane().setBackground(Color.white);

        // setting the text using Jlabel on the frame

        JLabel text = new JLabel("Welcome to ATM"); //setting text to Jlable
        // changing the font of the text. that takes object of Font ( font family, font style, size).
        text.setFont(new Font("Osward",Font.BOLD,38));
        // text will not visible untill we won't set its location on the frame
        text.setBounds(200,40,400,40);
        add(text);


        JLabel cardNo = new JLabel("Card No. :");
        cardNo.setFont(new Font("Raleway",Font.BOLD,28));
        cardNo.setBounds(120,150,150,30);
        add(cardNo);

        // now setting the text field for the card number using textField but as it is swing
        // so we use JtextField

        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        JLabel PinNo = new JLabel("Pin :");
        PinNo.setFont(new Font("Osward",Font.BOLD,28));
        PinNo.setBounds(120,220,250,30);
        add(PinNo);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

        //setting the size of the Frame.

        setSize(800,480);

        // By default visibilty of frame is false.

        setVisible(true);

        // settting the location of the frame from X axis and Y axis.

        setLocation(350,200);

        // Setting the Buttons

        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this); // adding a listner that listen the clicks
        add(login);

        Clear = new JButton("CLEAR");
        Clear.setBounds(430,300,100,30);
        Clear.setBackground(Color.BLACK);
        Clear.setForeground(Color.white);
        Clear.addActionListener(this);
        add(Clear);

        SignUp = new JButton("SIGN UP");
        SignUp.setBounds(300,350,230,30);
        SignUp.setBackground(Color.BLACK);
        SignUp.setForeground(Color.white);
        SignUp.addActionListener(this);
        add(SignUp);

    }
    public static void main(String[] args) {
        // creating new constructor that will call on object creation.
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        e is object which response when event clicked.
        // and getSource will return which event is clicked.
        if(e.getSource()==Clear){
            // calling the textField (defined globally) and setting the text as i want...
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (e.getSource()==login) {
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String qry = "select * from login where cardno = '"+cardnumber+"' and pinno = '"+pinnumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(qry);
                if(rs.next()){
                    setVisible(false);
                    new Transacations(pinnumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Entered card no or pin incorrect");
                }
            }catch (Exception en){
                System.out.println(en);
            }
        } else if (e.getSource()==SignUp) {
            setVisible(false);
            // creating object of SignUp page which will automatically call constructor on object creation
            // bydefault visibility of frame is false . so settting visibilty true for the signup page.
            new SignUpOne().setVisible(true);
        }
    }
}