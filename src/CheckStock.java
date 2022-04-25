import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CheckStock extends JFrame {
    String userClass;
    JTable table;

    public CheckStock(String user) throws SQLException {
        userClass = user;
        initComponents();
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID","Name","Quantity","Location"},0);
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-motor", "root", "");
        PreparedStatement preparedStatement = connect.prepareStatement("select * from STOCK");
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()){
            System.out.println("ID "+rs.getInt(1)+" Name "+rs.getString(2)+" Quantity "+rs.getInt(4)+" Location "+rs.getString(6));
            model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(6)});
        }
        table.setEnabled(false);
        table.setModel(model);

    }
    private void initComponents(){
        JLabel label1 = new JLabel();
        JButton backButton = new JButton();
        JScrollPane scrollPane = new JScrollPane();
        table = new JTable();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        label1.setFont(new Font("Ink Free",1,11));
        label1.setText("Stock in inventory");

        backButton.setText("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backActionPerformed(e);
            }
        });
        table.setModel(new DefaultTableModel(
                new Object[][]{
                        {null,null,null,null},
                        {null,null,null,null},
                        {null,null,null,null},
                        {null,null,null,null}
                },
                new String []{
                        "Title 1","Title 2","Title 3","Title 4"
                }
        ));
        scrollPane.setViewportView(table);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(25, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(label1)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
                                                .addGap(42, 42, 42))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(backButton)
                                                .addContainerGap())))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(backButton)
                                .addGap(28, 28, 28))
        );
        pack();
    }
    private void backActionPerformed(ActionEvent e){
        setVisible(false);
        WelcomePage welcomePage = new WelcomePage(userClass);
        welcomePage.setLocationRelativeTo(CheckStock.this);
        welcomePage.setVisible(true);
    }
}
