import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.sql.*;

public class OrderHistory extends JFrame {
    String user;
    JTable jTable1;
    public OrderHistory(String userClass) throws SQLException {
        user = userClass;
        initComponents();
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-motor", "root", "");
        PreparedStatement preparedStatement = connect.prepareStatement("select * from BILLINGINFO");
        ResultSet rs = preparedStatement.executeQuery();

        DefaultTableModel model = new DefaultTableModel(new String[]{"ID","Name","Part ID","Quantity","Amount","Date"},0);
        while(rs.next()){
            System.out.println("ID "+rs.getInt(1)+" Name "+rs.getString(2)+" Part ID "+rs.getInt(3)+" Quantity "+rs.getString(4)+" Amount "+rs.getInt(5));
            model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4), rs.getInt(5),rs.getDate(6)});
        }
        jTable1.setEnabled(false);
        jTable1.setModel(model);
    }
    private void initComponents(){
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new JTable();
        JLabel jLabel1 = new JLabel();
        JButton jButton1 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Order History");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jButton1)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(0,0,Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jButton1)
                                .addContainerGap())
        );

        pack();
    }

    private void backActionPerformed(ActionEvent e){
        setVisible(false);
        WelcomePage welcomePage = new WelcomePage(user);
        welcomePage.setLocationRelativeTo(OrderHistory.this);
        welcomePage.setVisible(true);
    }
}
