import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class balanceEnquiry extends JFrame implements ActionListener {


    JButton back;
    String pinnumber;
    balanceEnquiry(String pinchange){
        setLayout(null);
        this.pinnumber=pinchange;

        ImageIcon icn = new ImageIcon(ClassLoader.getSystemResource("iconss/atm.jpg"));
        Image img = icn.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(img);
        JLabel imgg = new JLabel(image);
        imgg.setBounds(0,0,900,900);
        add(imgg);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        imgg.add(back);

        Conn conn = new Conn();
        int balance = 0;
        try {
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");

            while(rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception en){
            System.out.println(en);
        }

        JLabel bn = new JLabel("Your Current Account Balance is Rs. : "+balance);
        bn.setForeground(Color.white);
        bn.setBounds(170,300,400,20);
        imgg.add(bn);

        setSize(900,900);
        setUndecorated(true);
        setLocation(300,0);
        setVisible(true);
    }


    public static void main(String[] args) {
        new balanceEnquiry("");
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==back){
            setVisible(false);
            new Transacations(pinnumber).setVisible(true);
        }
    }

}
