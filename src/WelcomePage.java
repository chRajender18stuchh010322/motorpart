import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WelcomePage extends JFrame {
    JLabel user;

    static String userClass;
    public WelcomePage(String str){
        userClass = str;
        System.out.println(userClass+" has logged in.. !!");
        initComponents();
    }
    WelcomePage(){
        throw new UnsupportedOperationException("Not supported yet");
    }

    private void initComponents(){
        user = new JLabel();
        JButton  logoutBtn = new JButton();
        JButton billing = new JButton();
        JButton currentStock = new JButton();
        JButton requiredStock = new JButton();
        JButton addStock = new JButton();
        JButton statistics = new JButton();
        JButton updateStock = new JButton();
        JButton orderHistory = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        user.setText(userClass+" Logged IN");

        logoutBtn.setText("Logout");
        logoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logoutButtonActionPerformed(e);
            }
        });

        orderHistory.setText("Order History");
        orderHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderHistoryActionPerformed(e);
            }
        });

        billing.setText("Billing");
        billing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                billingActionPerformed(e);
            }
        });
        currentStock.setText("Current Stock");
        currentStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentStockActionPerformed(evt);
            }
        });

        requiredStock.setText("Required Stock");
        requiredStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requiredStockActionPerformed(evt);
            }
        });

        addStock.setText("Add Stock");
        addStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStockActionPerformed(evt);
            }
        });

        statistics.setText("Sales Statistics");
        statistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statisticsActionPerformed(evt);
            }
        });

        updateStock.setText("Update Stock");
        updateStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStockActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                .addComponent(user, GroupLayout.PREFERRED_SIZE, 400,Short.MAX_VALUE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(logoutBtn))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(addStock)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(billing)
                                        )
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(updateStock)
                                                        .addComponent(orderHistory)
                                                        .addComponent(requiredStock)
                                                        .addComponent(currentStock)
                                                        .addComponent(statistics))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(user)
                                                .addGap(39, 39, 39)
                                                .addComponent(billing)
                                        )
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(73, 73, 73)
                                                .addComponent(addStock)
                                                .addGap(18, 18, 18)
                                                .addComponent(updateStock)))
                                .addGap(18, 18, 18)
                                .addComponent(currentStock)
                                .addGap(18, 18, 18)
                                .addComponent(statistics)
                                .addGap(18, 18, 18)
                                .addComponent(requiredStock)
                                .addGap(18, 18, 18)
                                .addComponent(orderHistory)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addComponent(logoutBtn)
                                .addContainerGap())
        );

        pack();


    }

    private void orderHistoryActionPerformed(ActionEvent e){
        setVisible(false);
        OrderHistory oh;
        try{
            oh = new OrderHistory(userClass);
            oh.setLocationRelativeTo(WelcomePage.this);
            oh.setVisible(true);
        } catch (SQLException ex){
            System.out.println(ex);
        }
    }

    private void currentStockActionPerformed(ActionEvent e) {
        setVisible(false);
        CheckStock check;
        try{
            check = new CheckStock(userClass);
            check.setLocationRelativeTo(WelcomePage.this);
            check.setVisible(true);
        } catch (SQLException ex){
            System.out.println(ex);
        }
    }
    private void logoutButtonActionPerformed(ActionEvent e){
        setVisible(false);
        Login login;
        try {
            login = new Login();
            login.setLocationRelativeTo(WelcomePage.this);
            login.setVisible(true);
        } catch (SQLException ex){
            Logger.getLogger(WelcomePage.class.getName()).log(Level.SEVERE,null,ex);
        }

    }
    private void billingActionPerformed(ActionEvent e){
        setVisible(false);
        Billing billing;
        try {
            billing = new Billing(userClass);
            billing.setLocationRelativeTo(WelcomePage.this);
            billing.setVisible(true);
        }
        catch (SQLException ex){
            Logger.getLogger(WelcomePage.class.getName()).log(Level.SEVERE,null,ex);
        }


    }
    private void requiredStockActionPerformed(ActionEvent e){
        setVisible(false);
        try {
            RequiredStock requiredStock = new RequiredStock(userClass);
            requiredStock.setLocationRelativeTo(WelcomePage.this);
            requiredStock.setVisible(true);
        }catch(SQLException ex){
            Logger.getLogger(WelcomePage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    private void addStockActionPerformed(ActionEvent e){
        setVisible(false);
        AddStock addStock = new AddStock(userClass);
        addStock.setLocationRelativeTo(WelcomePage.this);
        addStock.setVisible(true);
    }
    private void statisticsActionPerformed(ActionEvent e){
        setVisible(false);
        try {
            SalesStatistics salesStatistics = new SalesStatistics(userClass);
            salesStatistics.setLocationRelativeTo(WelcomePage.this);
            salesStatistics.setVisible(true);
        }
        catch (SQLException ex){
            Logger.getLogger(WelcomePage.class.getName()).log(Level.SEVERE,null,ex);
        }

    }
    private void updateStockActionPerformed(ActionEvent e){
        setVisible(false);
        UpdateStock updateStock = new UpdateStock(userClass);
        updateStock.setLocationRelativeTo(WelcomePage.this);
        updateStock.setVisible(true);
    }
}
