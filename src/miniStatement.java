import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class miniStatement extends JFrame {

    String pinnumber;
    miniStatement(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        setTitle("MINI STATEMENT");

        JLabel mini = new JLabel();
        add(mini);

        JLabel bankname = new JLabel("State Bank Of India");
        bankname.setBounds(130,20,200,20);
        add(bankname);


        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel bal = new JLabel();
        bal.setBounds(20,400,320,20);
        add(bal);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pinno='"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number : "+ rs.getString("cardno").substring(0,4) +"-XXXX-XXXX-"+ rs.getString("cardno").substring(12));
            }

        }catch (Exception en){
            System.out.println(en);
        }

        try{
            Conn conn = new Conn();
            int balan = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>"+ rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    balan+=Integer.parseInt(rs.getString("amount"));
                }else{
                    balan-=Integer.parseInt(rs.getString("amount"));
                }
            }
            bal.setText("Your Current Account Balance is Rs. : " + balan);
        }catch (Exception en){
            System.out.println(en);
        }
        mini.setBounds(20,140,400,200);

        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);

    }
    public static void main(String[] args) {
        new miniStatement("");
    }
}
