import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;


public class Login extends JFrame {

    JTextField usernameText;
    JPasswordField passwordField;
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    //Login Page

    public Login() throws SQLException {
        System.out.println("Running Login");
        setLocationRelativeTo(null);
        initComponents();

        usernameText.setText("");
        passwordField.setText("");


        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-motor", "root", "");


        int pastSunday = 0;
        Calendar calendar = Calendar.getInstance();
        if (calendar.get(Calendar.DAY_OF_WEEK) == 1)
            pastSunday = 1;
        if (calendar.get(Calendar.DAY_OF_WEEK) == 2 && pastSunday == 1) {
            PreparedStatement avgUpdateStmt = connection.prepareStatement("update WEEKLYSTOCKSOLD set Average=(Sunday+Monday+Tuesday+Wednesday+Thursday+Friday+Saturday)/7");
            int avgUpdateCheck = avgUpdateStmt.executeUpdate();
            if(avgUpdateCheck>0){
                System.out.println("AVG Updated");

                PreparedStatement dailyVals = connection.prepareStatement("update WEEKLYSTOCKSOLD set Sunday=?,Monday=?,Tuesday=?,Wednesday=?,Thursday=?,Friday=?,Saturday=?");
                dailyVals.setInt(1,0);
                dailyVals.setInt(2,0);
                dailyVals.setInt(3,0);
                dailyVals.setInt(4,0);
                dailyVals.setInt(5,0);
                dailyVals.setInt(6,0);
                dailyVals.setInt(7,0);
                int dailyValsCheck = dailyVals.executeUpdate();
                if(dailyValsCheck>0)
                    System.out.println("Updated the daily sales to 0..!!");
                pastSunday = 0;
            }
        }

    }

    private void initComponents(){
        JButton login = new JButton();
        usernameText = new JTextField();
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        passwordField = new JPasswordField();
        JButton reset = new JButton();
        JButton exit = new JButton();
        JLabel label3 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        login.setText("Login");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginActionPerformed(e);
            }
        });


        label1.setText("Username");
        label2.setText("Password");

        reset.setText("Reset");
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetActionPerformed(e);
            }
        });
        exit.setText("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitActionPerformed(e);
            }
        });
        label3.setFont( new Font("Ink Free",1,15));
        label3.setText("REDWAREHOUSE - 18STUCHH010195 ");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(40,40,40)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, 60,Short.MAX_VALUE)
                                                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(20,20,20)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING,false)
                                                        .addComponent(usernameText, GroupLayout.DEFAULT_SIZE , 140 , Short.MAX_VALUE)
                                                        .addComponent(passwordField)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(66,66,66)
                                                .addComponent(login)
                                                .addGap(31,31,31)
                                                .addComponent(reset)
                                                .addGap(32,32,32)
                                                .addComponent(exit)
                                                .addContainerGap(102,Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(label3)
                                                .addGap(0,0,Short.MAX_VALUE)
                                        ))
                        )
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(usernameText, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                .addGap(8, 8, 8))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(login)
                                        .addComponent(reset)
                                        .addComponent(exit))
                                .addGap(75, 75, 75))
        );

        pack();

    }
    private void loginActionPerformed(ActionEvent e){
        if(usernameText.getText().equals("owner") && passwordField.getText().equals("owner")){
            JOptionPane.showMessageDialog(null, "Owner login...");
            setVisible(false);
            welcomePageFunction("Owner");
        }else if(usernameText.getText().equals("keeper") && passwordField.getText().equals("keeper")) {
            JOptionPane.showMessageDialog(null, "Shop Keeper login...");
            setVisible(false);
            welcomePageFunction("Keeper");
        }else if(usernameText.getText().equals("sales") && passwordField.getText().equals("sales")){
            JOptionPane.showMessageDialog(null, "Sales Exec login...");
            setVisible(false);
            welcomePageFunction("Sales Executive");
        }else{
            JOptionPane.showMessageDialog(null, "Wrong login attempt...");
            usernameText.setText("");
            passwordField.setText("");
        }
    }
    private void resetActionPerformed(ActionEvent e){
        usernameText.setText("");
        passwordField.setText("");
    }
    private void exitActionPerformed(ActionEvent e){
        System.exit(0);
    }
    public void welcomePageFunction(String userClass){
        WelcomePage wp = new WelcomePage(userClass);
        wp.setLocationRelativeTo(Login.this);
        //wp.setLocation(dim.getSize().width/2 - wp.getSize().width/2,dim.getSize().height/2 - wp.getSize().height/2);
        wp.setVisible(true);

    }


}
