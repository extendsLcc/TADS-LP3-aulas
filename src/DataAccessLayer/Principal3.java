package DataAccessLayer;

import DataAccessLayer.DAL.Cidade;
import DataAccessLayer.DAL.CidadeDAO;

import java.sql.SQLException;


class DBExceptionManager {
    public void handle_exception(SQLException ex) {
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }
}

public class Principal3 {
    public void run() {
        try {
            CidadeDAO cidadedao = new CidadeDAO();
            Cidade cidade = cidadedao.get(2);

            System.out.println(cidade);

        } catch(SQLException ex) {
            DBExceptionManager myexmanager = new DBExceptionManager();
            myexmanager.handle_exception(ex);
        }
    }

    public static void main(String[] args) {
        Principal3 principal = new Principal3();
        principal.run();
    }
}
