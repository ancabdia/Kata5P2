package view;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Mail;

public class MailListReaderBD {
    
    private static Connection c;
    
    private MailListReaderBD() {
    }
    
    public static MailListReaderBD getInstance() {
        return MailListReaderDHolder.INSTANCE;
    }
    
    private static class MailListReaderDHolder {

        private static final MailListReaderBD INSTANCE = new MailListReaderBD();
    }
    
    private void connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
            
        c = DriverManager.getConnection("jdbc:sqlite:./src/KATA5.db");
        c.setAutoCommit(false);
    }
    
    private void disconnect() throws SQLException {
        c.close();
    }
    
    public List<Mail> read() {
        ArrayList<Mail> res = new ArrayList<>();
        try {
            connect();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM EMAIL;");
            while(rs.next()) {
                String rowValue = rs.getString(2);
                Mail m = new Mail(rowValue);
                res.add(m);
            }
            s.close();
            rs.close();
            disconnect();
        } catch(ClassNotFoundException | SQLException ex) {
            
        }
        return res;
    }
}