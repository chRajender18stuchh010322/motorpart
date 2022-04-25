import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Billing extends JFrame {
    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-motor", "root", "");
    String user;
    int stockQuantity;
    JTextField partIDText;
    JTextField billIDText;
    JTextField dateText;
    JTextField customerNameText;
    JTextField quantityText;
    JTextField amountText;

    public Billing(String userClass) throws SQLException {
        user = userClass;
        stockQuantity = 0;
        initComponents();


        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/LLLL/yyyy");
        String dateString = localDate.format(formatter);
        dateText.setText(dateString);

        PreparedStatement stmnt = connect.prepareStatement("select count(*) from BILLINGINFO");
        ResultSet rs = stmnt.executeQuery();
        int count = 0;
        while (rs.next())
            count = rs.getInt(1);
        billIDText.setText(Integer.toString(count + 1));

    }

    private void initComponents() {

        JTextField jTextField1 = new javax.swing.JTextField();
        JLabel jLabel1 = new javax.swing.JLabel();
        JLabel jLabel2 = new javax.swing.JLabel();
        JLabel jLabel3 = new javax.swing.JLabel();
        JLabel jLabel4 = new javax.swing.JLabel();
        JLabel jLabel5 = new javax.swing.JLabel();
        JLabel jLabel6 = new javax.swing.JLabel();
        JLabel jLabel7 = new javax.swing.JLabel();
        amountText = new javax.swing.JTextField();
        quantityText = new javax.swing.JTextField();
        partIDText = new javax.swing.JTextField();
        customerNameText = new javax.swing.JTextField();
        billIDText = new javax.swing.JTextField();
        dateText = new javax.swing.JTextField();
        JButton submitButton = new javax.swing.JButton();
        JButton backButton = new javax.swing.JButton();
        JButton getAmountButton = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("BILLING");

        jLabel2.setText("Bill ID");

        jLabel3.setText("Customer Name");

        jLabel4.setText("Part ID");

        jLabel5.setText("Quantity");

        jLabel6.setText("Amount");

        jLabel7.setText("Date");

        amountText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        amountText.setText("0");
        amountText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountTextActionPerformed(evt);
            }
        });

        quantityText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quantityText.setText("0");
        quantityText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityTextActionPerformed(evt);
            }
        });

        dateText.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        getAmountButton.setText("Get Amount");
        getAmountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getAmountButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel7))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(quantityText, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                        .addComponent(partIDText)
                                        .addComponent(customerNameText)
                                        .addComponent(billIDText)
                                        .addComponent(dateText)
                                        .addComponent(amountText))
                                .addGap(18, 18, 18)
                                .addComponent(getAmountButton)
                                .addContainerGap(98, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(180, 180, 180))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(submitButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(backButton)
                                                .addGap(7, 7, 7))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(23, 23, 23)
                                                .addComponent(jLabel2)
                                                .addGap(23, 23, 23)
                                                .addComponent(jLabel3)
                                                .addGap(23, 23, 23)
                                                .addComponent(jLabel4)
                                                .addGap(23, 23, 23)
                                                .addComponent(jLabel5)
                                                .addGap(23, 23, 23)
                                                .addComponent(jLabel6))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(billIDText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(customerNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(partIDText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(quantityText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(amountText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(getAmountButton))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(submitButton)
                                        .addComponent(backButton))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void amountTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountTextActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_amountTextActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        WelcomePage welcomePage = new WelcomePage(user);
        welcomePage.setLocationRelativeTo(Billing.this);
        welcomePage.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void quantityTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityTextActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_quantityTextActionPerformed

    private void getAmountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getAmountButtonActionPerformed
        // TODO add your handling code here:
        if (partIDText.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Invalid ID entered..!!");
        else {
            PreparedStatement stmnt;
            try {
                stmnt = connect.prepareStatement("select * from STOCK where ID=?");
                stmnt.setInt(1, Integer.parseInt(partIDText.getText()));

                ResultSet rs = stmnt.executeQuery();
                int price = 0;
                while (rs.next()) {
                    price = rs.getInt(4);
                    stockQuantity = rs.getInt(3);
                }
                int quantity = Integer.parseInt(quantityText.getText());
                amountText.setText(Integer.toString(price * quantity));
            } catch (SQLException ex) {
                Logger.getLogger(Billing.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_getAmountButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed

        if (customerNameText.getText().equals("") || partIDText.getText().equals("") || quantityText.getText().equals("0"))
            JOptionPane.showMessageDialog(null, "Invalid data entered..!!");
        else {
            try {
                // TODO add your handling code here:

                PreparedStatement stmnt = connect.prepareStatement("insert into BILLINGINFO(ID,Date,CNAME,PartID,Quantity,Amount)values(?,?,?,?,?,?)");
                stmnt.setInt(1, Integer.parseInt(billIDText.getText()));
                LocalDate localDate = LocalDate.now();
                stmnt.setDate(2, java.sql.Date.valueOf(localDate)); //convert localDate type to Date type
                stmnt.setString(3, customerNameText.getText());
                stmnt.setInt(4, Integer.parseInt(partIDText.getText()));
                stmnt.setInt(5, Integer.parseInt(quantityText.getText()));
                stmnt.setInt(6, Integer.parseInt(amountText.getText()));

                int check = stmnt.executeUpdate();
                if (check > 0)
                    System.out.println("Bill with ID " + billIDText + " has been processed successfully..!!");
            } catch (SQLException ex) {
                Logger.getLogger(Billing.class.getName()).log(Level.SEVERE, null, ex);
            }


            try {
                PreparedStatement updateStmnt = connect.prepareStatement("update STOCK set Quantity=? where ID=?");
                System.out.println(stockQuantity);
                System.out.println(quantityText.getText());
                updateStmnt.setInt(1, stockQuantity - Integer.parseInt(quantityText.getText()));
                updateStmnt.setInt(2, Integer.parseInt(partIDText.getText()));
                String quantityVal = Integer.toString(stockQuantity - Integer.parseInt(quantityText.getText()));
                int check = updateStmnt.executeUpdate();
                if (check > 0)
                    System.out.println("Stock of MotorPart having ID " + partIDText.getText() + " is " + quantityVal + " now..!!");
            } catch (SQLException ex) {
                System.out.println(ex);
                Logger.getLogger(Billing.class.getName()).log(Level.SEVERE, null, ex);
            }



            String weekDays[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
            Calendar clndr = Calendar.getInstance();
            int dayNum = clndr.get(Calendar.DAY_OF_WEEK) - 1;
            String presentDay = weekDays[dayNum];
            PreparedStatement updateDailySalesStmnt;
            try {
                String getQuery = "select " + presentDay + " from WEEKLYSTOCKSOLD where partID=?";
                PreparedStatement getPrevQuantityStmnt = connect.prepareStatement(getQuery);
                getPrevQuantityStmnt.setInt(1, Integer.parseInt(partIDText.getText()));
                ResultSet rs = getPrevQuantityStmnt.executeQuery();
                int salesTillNow = 0;
                while (rs.next())
                    salesTillNow = rs.getInt(1);
                String queryStatement = "update WEEKLYSTOCKSOLD set " + presentDay + "=? where partID=?";
                updateDailySalesStmnt = connect.prepareStatement(queryStatement);
                updateDailySalesStmnt.setInt(1, salesTillNow + Integer.parseInt(quantityText.getText()));
                updateDailySalesStmnt.setInt(2, Integer.parseInt(partIDText.getText()));
                int updateCheck = updateDailySalesStmnt.executeUpdate();
                if (updateCheck > 0)
                    System.out.println("Daily Sales is updated on the WEEKLYSTOCKSOLD db..!!");
            } catch (SQLException ex) {
                System.out.println(ex);
                Logger.getLogger(Billing.class.getName()).log(Level.SEVERE, null, ex);
            }


            setVisible(false);
            WelcomePage welcomePage = new WelcomePage(user);
            welcomePage.setLocationRelativeTo(Billing.this);
            welcomePage.setVisible(true);
        }
    }
}