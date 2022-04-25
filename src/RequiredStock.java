import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

//connect = DriverManager.getConnection("jdbc:derby://localhost:1527/MotorPartSoftware","yash","yash");

public class RequiredStock extends JFrame {
    static String  user;
    Connection connect;
    JTable stockTable;


    RequiredStock(String userClass) throws SQLException {
        user = userClass;
        this.connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-motor","root","");
        initComponents();

        DefaultTableModel model = new DefaultTableModel(new String[]{"ID","Required Stock","Address of Retailer"},0){};
        String q = "select ID,Quantity,Average,RetailerAddress from STOCK inner join WEEKLYSTOCKSOLD on STOCK.ID = WEEKLYSTOCKSOLD.PartID AND STOCK.Quantity < WEEKLYSTOCKSOLD.Average";
        PreparedStatement statement = connect.prepareStatement(q);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            int requiredQuantity = resultSet.getInt(3)-resultSet.getInt(2);
            System.out.println("ID is "+resultSet.getInt(1)+" required Quantity is "+requiredQuantity);
            model.addRow(new Object[]{resultSet.getInt(1),requiredQuantity,resultSet.getString(4)});
        }
        stockTable.setVisible(false);
        stockTable.setModel(model);
    }
    private void initComponents(){
        JLabel jLabel1 = new JLabel();
        JScrollPane scrollPane = new JScrollPane();
        stockTable = new JTable();
        JButton back = new JButton();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setText("REQUIRED STOCK");
        stockTable.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        stockTable.setToolTipText("");
        scrollPane.setViewportView(stockTable);

        back.setText("Back");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(scrollPane, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                                        .addComponent(back, GroupLayout.Alignment.TRAILING))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(33, 33, 33)
                                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                .addGap(85, 85, 85)
                                .addComponent(back)
                                .addContainerGap())
        );

        pack();
    }
    private void backButtonActionPerformed(ActionEvent e){
        setVisible(false);
        WelcomePage welcomePage = new WelcomePage(user);
        welcomePage.setLocationRelativeTo(RequiredStock.this);
        welcomePage.setVisible(true);
    }
}
