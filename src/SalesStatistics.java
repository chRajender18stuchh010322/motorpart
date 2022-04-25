import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;

public class SalesStatistics extends JFrame {
    static String user;
    int presentDayCustomerCount = 0;
    JLabel revenueText;
    JTable saleTable;
    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-motor", "root", "");
    public SalesStatistics(String userClass) throws SQLException {
        user = userClass;
        presentDayCustomerCount = 0;

        initComponents();

        DefaultTableModel defaultTableModel = new DefaultTableModel(new String[]{"Bill ID","Customer Name","Part ID","Quantity","Amount"},0);
        LocalDate localDate = LocalDate.now();
        PreparedStatement statement = connect.prepareStatement("select * from BILLINGINFO where Date=?");
        statement.setDate(1, Date.valueOf(localDate));

        ResultSet rs = statement.executeQuery();
        int revenueAmount = 0;
        while(rs.next()){
            revenueAmount += rs.getInt(5);
            presentDayCustomerCount += 1;
            System.out.println("Bill ID"+rs.getInt(1)+" Customer "+rs.getString(2)+" PartID "+rs.getInt(3)+" Quantity "+rs.getInt(4)+" Amount "+rs.getInt(5));
            defaultTableModel.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5)});
        }
        revenueText.setText("₹ "+Integer.toString(revenueAmount));
        saleTable.setEnabled(false);
        saleTable.setModel(defaultTableModel);
    }
    private void initComponents(){
        JTextField jTextField1 = new javax.swing.JTextField();
        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new javax.swing.JLabel();
        JLabel jLabel2 = new javax.swing.JLabel();
        revenueText = new javax.swing.JLabel();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        saleTable = new javax.swing.JTable();
        JLabel jLabel3 = new javax.swing.JLabel();
        JButton backButton = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Sales Statistics");

        jLabel2.setText("Total revenue for the day - ");

        saleTable.setModel(new DefaultTableModel(
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
        jScrollPane1.setViewportView(saleTable);

        jLabel3.setText("Sales for the day");

        backButton.setText("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addGap(30, 30, 30)
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(revenueText)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel1)
                                                                .addGap(0,0, Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 21, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jScrollPane1,GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE))))
                                .addGap(19, 19, 19))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(backButton)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(revenueText))
                                .addGap(21, 21, 21)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1,GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                                .addComponent(backButton)
                                .addContainerGap())
        );

        pack();
    }
    private void backButtonActionPerformed(ActionEvent e){
        setVisible(false);
        WelcomePage welcomePage = new WelcomePage(user);
        welcomePage.setLocationRelativeTo(SalesStatistics.this);
        welcomePage.setVisible(true);
    }
}
