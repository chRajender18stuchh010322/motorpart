import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateStock extends JFrame {

    String user;
    JTextField IDText;
    JTextField quantityText;
    UpdateStock(String userClass){
        user = userClass;
        initComponents();

    }
    private void initComponents(){
        JLabel jLabel1 = new javax.swing.JLabel();
        JLabel jLabel2 = new javax.swing.JLabel();
        JLabel jLabel3 = new javax.swing.JLabel();
        IDText = new javax.swing.JTextField();
        quantityText = new javax.swing.JTextField();
        JButton updateButton = new javax.swing.JButton();
        JButton backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Update Motor Part Stock");

        jLabel2.setText("ID of MotorPart");

        jLabel3.setText("Quantity Added");

        quantityText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quantityText.setText("0");

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(quantityText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                                .addComponent(IDText, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addContainerGap(143, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(updateButton)
                                .addGap(29, 29, 29)
                                .addComponent(backButton)
                                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(IDText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(quantityText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(updateButton)
                                        .addComponent(backButton))
                                .addGap(28, 28, 28))
        );

        pack();
    }
    private void updateButtonActionPerformed(ActionEvent e){
        if(IDText.getText().equals("") || quantityText.getText().equals("0"))
            JOptionPane.showMessageDialog(null, "Invalid data entered..!!");
        else{
            int ID =Integer.parseInt(IDText.getText());
            int quantity = Integer.parseInt(quantityText.getText());

            try{
                Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-motor", "root", "");
                PreparedStatement select = connect.prepareStatement("select * from STOCK where ID=?");
                select.setInt(1,ID);

                ResultSet rs = select.executeQuery();
                while (rs.next()){
                    System.out.println(rs.getInt(3));
                    quantity += rs.getInt(3);
                }

                PreparedStatement update = connect.prepareStatement("update STOCK set Quantity=? where ID=?");
                update.setInt(1,quantity);
                update.setInt(2,ID);
                int check = update.executeUpdate();
                if(check>0){
                    System.out.println("Stock of MotorPart having ID "+ID+" is "+quantity+" now..!!");
                    JOptionPane.showMessageDialog(null, "Updated stock successfully");
                }


            }catch(SQLException ex){
                Logger.getLogger(UpdateStock.class.getName()).log(Level.SEVERE, null, ex);
            }
            setVisible(false);
            WelcomePage welcomePage = new WelcomePage(user);
            welcomePage.setLocationRelativeTo(UpdateStock.this);
            welcomePage.setVisible(true);
        }
    }
    private void backButtonActionPerformed(ActionEvent e){
        setVisible(false);
        WelcomePage welcomePage = new WelcomePage(user);
        welcomePage.setLocationRelativeTo(UpdateStock.this);
        welcomePage.setVisible(true);
    }

}
