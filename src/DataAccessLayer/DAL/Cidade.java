package DataAccessLayer.DAL;

class CidadeDTO {
    int id;
    String nome;
    int id_estado;

    public String toString() {
        String msg;
        msg = "Cidade(";
        msg += id + ",";
        msg += nome + ",";
        msg += id_estado + ")";
        return msg;
    }
}

public class Cidade extends CidadeDTO{
}
