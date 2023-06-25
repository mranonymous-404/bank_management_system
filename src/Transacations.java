import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transacations extends JFrame implements ActionListener {

    JButton deposit,withdrawal,fastcash,pinchange,ExitScr,miniState,balanceEnq;
    String pinno;
    Transacations(String pinno){
        this.pinno = pinno;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon icons1 = new ImageIcon(ClassLoader.getSystemResource("iconss/atm.jpg"));

        Image image1 = icons1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);

        ImageIcon imageIcon = new ImageIcon(image1);
        JLabel image = new JLabel(imageIcon);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(215,300,700,35);
        text.setFont(new Font("System", Font.BOLD,16));
        text.setForeground(Color.white);
        //because add(text) only adds the text on the frame but on the top of that there is frame.
        // so if we want to add text on the top of image. then we have to write like below.
        image.add(text);


        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal = new JButton("Withdrawal");
        withdrawal.setBounds(355,415,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastcash = new JButton("FastCash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        miniState = new JButton("Mini-Statement");
        miniState.setBounds(355,450,150,30);
        miniState.addActionListener(this);
        image.add(miniState);

        pinchange = new JButton("Pin-Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceEnq = new JButton("Balance-Enquiry");
        balanceEnq.setBounds(355,485,150,30);
        balanceEnq.addActionListener(this);
        image.add(balanceEnq);

        ExitScr = new JButton("Exit");
        ExitScr.setBounds(355,520,150,30);
        ExitScr.addActionListener(this);
        image.add(ExitScr);


        setSize(900,900);
        setLocation(300, 0);
        //It will remove the title header of the frame
        setUndecorated(true);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Transacations("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ExitScr){
            System.exit(0);
        } else if (e.getSource()==deposit) {
            setVisible(false);
            new Deposit(pinno).setVisible(true);
        } else if (e.getSource()== withdrawal) {
            setVisible(false);
            new withdrawal(pinno).setVisible(true);
        } else if (e.getSource()==fastcash) {
            setVisible(false);
            new Fastcash(pinno).setVisible(true);
        }else if(e.getSource()==pinchange){
            setVisible(false);
            new pinChange(pinno).setVisible(true);
        }else if(e.getSource()==balanceEnq){
            setVisible(false);
            new balanceEnquiry(pinno).setVisible(true);
        } else if (e.getSource()==miniState) {
            new miniStatement(pinno).setVisible(true);
        }
    }
}
