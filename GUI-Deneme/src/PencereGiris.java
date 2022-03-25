import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PencereGiris extends JFrame {
    private JPanel pencereGiris;
    private JLabel labelEposta;
    private JTextField textFieldEposta;
    private JLabel labelParola;
    private JButton buttonGiris;
    private JLabel girisSonuc;
    private JPasswordField passwordFieldParola;

    public PencereGiris() {
        add(pencereGiris);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setTitle("Giriş Yap");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        buttonGiris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String eposta, parola;
                eposta = textFieldEposta.getText();
                parola = passwordFieldParola.getText();
                int cevap = 0;
                try {
                    cevap = kontrolEt(eposta, parola);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                if (cevap > 0) {
                    girisSonuc.setText("Giriş başarılı");
                } else if (cevap == 0) {
                    girisSonuc.setText("Giriş başarısız");
                }
            }
        });
    }

    public int kontrolEt(String eposta, String parola) throws SQLException {
        int sonuc = 0;
        Database database = new Database();
        Statement statementDB = database.connect().createStatement();
        String sorgu = "select * from gui.hesap where eposta=\"" + eposta + "\" and parola=\"" + parola + "\";";
        ResultSet cevap = statementDB.executeQuery(sorgu);
        while (cevap.next()) {
            if (cevap.getString("eposta").equals(eposta) && cevap.getString("parola").equals(parola)) {
                sonuc = cevap.getInt("id");
            }
        }
        return sonuc;
    }

}
