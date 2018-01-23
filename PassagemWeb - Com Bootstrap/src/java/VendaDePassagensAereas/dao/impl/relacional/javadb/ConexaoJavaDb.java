package VendaDePassagensAereas.dao.impl.relacional.javadb;

import VendaDePassagensAereas.dao.impl.relacional.ConexaoInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoJavaDb implements ConexaoInterface {

    private String hostname;
    private int porta;
    private String nomeDb;
    private String usuario;
    private String senha;
    private Connection conexao;

    public ConexaoJavaDb(String hostname, int porta, String nomeDb, 
                         String usuario, String senha) {
        this.hostname = hostname;
        this.porta = porta;
        this.nomeDb = nomeDb;
        this.usuario = usuario;
        this.senha = senha;
    }

    
    
    @Override
    public Connection getConnection() {
        if (conexao == null) {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                String url = "jdbc:derby://" + hostname + ":" + porta + "/" + nomeDb;
                conexao = DriverManager.getConnection(url, usuario, senha);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return conexao;
    }

    @Override
    public void close() {
        try {
            conexao.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        conexao = null;
    }
}
