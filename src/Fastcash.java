import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {

    JButton deposit,withdrawal,fastcash,pinchange,ExitScr,miniState,balanceEnq;
    String pinno;
    Fastcash(String pinno){
        this.pinno = pinno;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon icons1 = new ImageIcon(ClassLoader.getSystemResource("iconss/atm.jpg"));

        Image image1 = icons1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);

        ImageIcon imageIcon = new ImageIcon(image1);
        JLabel image = new JLabel(imageIcon);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(215,300,700,35);
        text.setFont(new Font("System", Font.BOLD,16));
        text.setForeground(Color.white);
        //because add(text) only adds the text on the frame but on the top of that there is frame.
        // so if we want to add text on the top of image. then we have to write like below.
        image.add(text);


        deposit = new JButton("Rs. 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal = new JButton("Rs. 500");
        withdrawal.setBounds(355,415,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastcash = new JButton("Rs. 1000");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        miniState = new JButton("Rs. 2000");
        miniState.setBounds(355,450,150,30);
        miniState.addActionListener(this);
        image.add(miniState);

        pinchange = new JButton("Rs. 5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceEnq = new JButton("Rs. 10000");
        balanceEnq.setBounds(355,485,150,30);
        balanceEnq.addActionListener(this);
        image.add(balanceEnq);

        ExitScr = new JButton("Back");
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
        new Fastcash("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ExitScr){
            setVisible(false);
            new Transacations(pinno).setVisible(true);
        } else {
            String amount = ((JButton)e.getSource()).getText().substring(4);
            Conn conn = new Conn();
            try {
                ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinno+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(e.getSource()!=ExitScr && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values('"+pinno+"','"+date+"','Withdrawal','"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");

                setVisible(false);
                new Transacations(pinno).setVisible(true);
            }catch (Exception en){
                System.out.println(en);
            }
        }
    }
}
