import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pinChange extends JFrame implements ActionListener {
    JPasswordField pin, repin;
    JButton change, back;

    String pinNo;
    pinChange(String pinNo) {
        this.pinNo = pinNo;
        setLayout(null);
        ImageIcon icn = new ImageIcon(ClassLoader.getSystemResource("iconss/atm.jpg"));
        Image img = icn.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img);
        JLabel image = new JLabel(img2);
        image.setBounds(0, 0, 900, 900);
        add(image);


        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 280, 500, 35);
        image.add(text);

        JLabel pintext = new JLabel("NEW PIN : ");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(165, 320, 180, 25);
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330, 320, 180, 25);
        image.add(pin);

        JLabel repintext = new JLabel("REENTER PIN : ");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(165, 360, 180, 25);
        image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330, 360, 180, 25);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setUndecorated(true);
        setLocation(300, 0);
        setVisible(true);

    }

    public static void main(String[] args) {
        new pinChange("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == change) {
            try {
                String newPin = pin.getText();
                String cpin = repin.getText();
                if (!newPin.equals(cpin)) {
                    JOptionPane.showMessageDialog(null, "pin and RePin doesn\'t match");
                    return;
                }
                if(newPin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter new Pin");
                    return;
                }
                if(cpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Re-Enter new Pin");
                    return;
                }
                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+cpin+"' where pin = '"+pinNo+"'";
                String query2 = "update login set pinno = '"+cpin+"' where pinno = '"+pinNo+"'";
                String query3 = "update signupthree set pinnumber = '"+cpin+"' where pinnumber = '"+pinNo+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "Pin Updated Successfully");

                setVisible(false);
                new Transacations(cpin).setVisible(true);
            } catch (Exception en) {
                System.out.println(en);
            }
        } else if (e.getSource()==back) {
            setVisible(false);
            new Transacations(pinNo).setVisible(true);
        }
    }
}
