import java.awt.*;
import java.sql.SQLException;

public class RedWarehouse {
    public static void main(String[] args) throws SQLException {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        Login login = new Login();
        login.setLocation(dim.getSize().width/2 -login.getWidth()/2 ,dim.getSize().height/2 - login.getHeight()/2);
        login.setVisible(true);
        System.out.println("Called Login");
    }
}
