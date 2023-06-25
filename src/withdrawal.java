import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class withdrawal extends JFrame implements ActionListener {

    JButton withdrawal, back;

    JTextField amount;

    String PinNo;
    withdrawal(String pinNo){
        this.PinNo = pinNo;
        setLayout(null);

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("iconss/atm.jpg"));
        Image im = ic.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon reic = new ImageIcon(im);
        JLabel myimg = new JLabel(reic);
        myimg.setBounds(0, 0, 900, 900);
        add(myimg);

        JLabel text = new JLabel("Enter a amount you want to WithDraw");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        myimg.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        myimg.add(amount);

        withdrawal = new JButton("Withdraw");
        withdrawal.setBounds(355, 485, 150, 30);
        withdrawal.addActionListener(this);
        myimg.add(withdrawal);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        myimg.add(back);





        setSize(900,900);
        setLocation(300, 0);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }



    public static void main(String[] args) {
        new withdrawal("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==withdrawal){
            String amt = amount.getText();
            Date date = new Date();
            if(amt.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter any amount to withdraw");
            }else {
                try{
                    int balance = 0;
                    Conn conn = new Conn();
                    ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+PinNo+"'");
                    while(rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                            balance+=Integer.parseInt(rs.getString("amount"));
                        }else{
                            balance-=Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if(balance < Integer.parseInt(amt)){
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    }else {
                        String query = "insert into bank values('"+PinNo+"','"+date+"','Withdraw','"+amt+"')";
                        conn.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"Rupees "+amt+" Withdraw Successfully");

                    }
                }catch (Exception en){
                    System.out.println(en);
                }

            }
        }else if(e.getSource()==back){
            setVisible(false);
            new Transacations(PinNo).setVisible(true);
        }
    }
}
