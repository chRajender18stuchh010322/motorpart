import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddStock extends JFrame {
    String user;
    JTextField IDText;
    JTextField nameText;
    JTextField quantityText;
    JTextField costText;
    JTextField addressText;
    JTextField locationText;
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    public AddStock(String userClass){
        user = userClass;
        initComponents();
    }
    private void initComponents(){
        JLabel jLabel7 = new JLabel();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        JLabel  jLabel5 = new JLabel();
        JLabel jLabel6 = new JLabel();
        JButton AddToDB = new JButton();
        JButton Back = new JButton();
        IDText = new JTextField();
        nameText = new JTextField();
        quantityText = new JTextField();
        costText = new JTextField();
        addressText = new JTextField();
        JLabel jLabel8 = new JLabel();
        locationText = new JTextField();

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Add Motor Part Details");

        jLabel2.setText("ID of MotorPart");

        jLabel3.setText("Name of MotorPart");

        jLabel4.setText("Quantity");

        jLabel5.setText("Cost");

        jLabel6.setText("Retailer Address");

        AddToDB.setText("Add");
        AddToDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddToDBActionPerformed(evt);
            }
        });

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        IDText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDTextActionPerformed(evt);
            }
        });

        quantityText.setHorizontalAlignment(JTextField.CENTER);
        quantityText.setText("0");
        quantityText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                quantityTextActionPerformed(evt);
            }
        });

        costText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                costTextActionPerformed(evt);
            }
        });

        jLabel8.setText("Location");

        locationText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                locationTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(146, 146, 146)
                                                                .addComponent(jLabel1))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(25, 25, 25)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel3)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(jLabel5)
                                                                        .addComponent(jLabel6)
                                                                        .addComponent(jLabel8))
                                                                .addGap(42, 42, 42)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(IDText)
                                                                        .addComponent(nameText)
                                                                        .addComponent(quantityText, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                                                        .addComponent(costText)
                                                                        .addComponent(addressText)
                                                                        .addComponent(locationText))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(AddToDB)
                                                .addGap(26, 26, 26)))
                                .addComponent(Back)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(IDText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(quantityText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(costText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(addressText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(locationText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(AddToDB)
                                        .addComponent(Back))
                                .addContainerGap())
        );

        pack();
    }

    private void quantityTextActionPerformed(ActionEvent e){
    }
    private void costTextActionPerformed(ActionEvent e){
    }
    private void locationTextActionPerformed(ActionEvent e){
    }

    private void BackActionPerformed(ActionEvent e){
        setVisible(false);
        WelcomePage welcomePage = new WelcomePage(user);
        welcomePage.setLocationRelativeTo(AddStock.this);
        welcomePage.setVisible(true);
    }
    private void IDTextActionPerformed(ActionEvent e){

    }
    private void AddToDBActionPerformed(ActionEvent e){
        if(IDText.getText().equals("") || nameText.getText().equals("") || quantityText.getText().equals("") ||
                costText.getText().equals("") || addressText.getText().equals("") || locationText.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Invalid data entered");
        else{
            int IDVal = Integer.parseInt(IDText.getText());
            String nameVal = nameText.getText();
            int quantityVal = Integer.parseInt(quantityText.getText());
            int costVal = Integer.parseInt(costText.getText());
            String addressVal = addressText.getText();
            String locationVal = locationText.getText();

            try{
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:1527/jdbc-motor","root","");

                PreparedStatement insertStatement = connection.prepareStatement("insert into STOCK(ID,Name,Quantity,Cost,RetailerAddress,Location)values(?,?,?,?,?,?)");
                insertStatement.setInt(1,IDVal);
                insertStatement.setString(2,nameVal);
                insertStatement.setInt(3,quantityVal);
                insertStatement.setInt(4,costVal);
                insertStatement.setString(5,addressVal);
                insertStatement.setString(6,locationVal);
                int check = insertStatement.executeUpdate();
                if(check>0)
                    System.out.println("Item Added");
                PreparedStatement updateStmnt = connection.prepareStatement("insert into WEEKLYSTOCKSOLD(PartID,Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Average)values(?,?,?,?,?,?,?,?,?)");
                updateStmnt.setInt(1, IDVal);
                updateStmnt.setInt(2,0);
                updateStmnt.setInt(3,0);
                updateStmnt.setInt(4,0);
                updateStmnt.setInt(5,0);
                updateStmnt.setInt(6,0);
                updateStmnt.setInt(7,0);
                updateStmnt.setInt(8,0);
                updateStmnt.setInt(9,0);
            } catch (SQLException ex){
                Logger.getLogger(AddStock.class.getName()).log(Level.SEVERE,null,ex);
            }
            setVisible(false);
            WelcomePage welcomePage = new WelcomePage(user);
            welcomePage.setLocationRelativeTo(AddStock.this);
            welcomePage.setVisible(true);
        }
    }


}
