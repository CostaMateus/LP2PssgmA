package VendaDePassagensAereas.dao.impl.relacional;

import VendaDePassagensAereas.dao.api.AeronaveDaoInterface;
import VendaDePassagensAereas.dominio.Aeronave;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AeronaveDaoRelacional implements AeronaveDaoInterface {

    private ConexaoInterface conexao;
    private PreparedStatement listarStatement;
    private PreparedStatement inserirStatement;
    private PreparedStatement apagarStatement;
    private PreparedStatement atualizarStatement;
    private PreparedStatement buscarStatement;
    private PreparedStatement buscarNomeStatement;

    public AeronaveDaoRelacional(ConexaoInterface conexao) {
        this.conexao = conexao;
        String sql;
        try {
            sql = "SELECT * FROM aeronaves";
            listarStatement = conexao.getConnection().prepareStatement(sql);
            
            sql = "INSERT INTO aeronaves (aeronave_ID, modelo, capacidade) "
                    + "VALUES (?, ?, ?)";
            inserirStatement = conexao.getConnection().prepareStatement(sql);
            
            sql = "DELETE FROM aeronaves WHERE aeronave_ID=?";
            apagarStatement = conexao.getConnection().prepareStatement(sql);
            
            sql = "UPDATE aeronaves SET modelo=?, capacidade=? WHERE aeronave_ID=?";
            atualizarStatement = conexao.getConnection().prepareStatement(sql);
            
            sql = "SELECT * FROM aeronaves WHERE aeronave_ID=?";
            buscarStatement = conexao.getConnection().prepareStatement(sql);
            
            sql = "SELECT * FROM aeronaves WHERE modelo=?";
            buscarNomeStatement = conexao.getConnection().prepareStatement(sql);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Aeronave> listarTudo() {
        List<Aeronave> aeronaves = new ArrayList<>();
        try {
            ResultSet result = listarStatement.executeQuery();
            while (result.next()) {
                long c = result.getLong("aeronave_id");
                String m = result.getString("modelo");
                long cp = result.getLong("capacidade");
                Aeronave a = new Aeronave(m, cp);
                a.setCodigo(c);
                aeronaves.add(a);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return aeronaves;
    }

    @Override
    public void inserir(Aeronave a) {
        try {
            inserirStatement.setLong(1, a.getCodigo());
            inserirStatement.setString(2, a.getModelo());
            inserirStatement.setLong(3, a.getCapacidade());
            inserirStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void apagar(Aeronave a) {
        try {
            apagarStatement.setLong(1, a.getCodigo());
            apagarStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void atualizar(Aeronave a) {
        try {
            atualizarStatement.setString(1, a.getModelo());
            atualizarStatement.setLong(2, a.getCapacidade());
            atualizarStatement.setLong(3, a.getCodigo());
            atualizarStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Aeronave buscar(long codigo) {
        Aeronave aB = null;
        try {
            buscarStatement.setLong(1, codigo);
            ResultSet result = buscarStatement.executeQuery();
            if (result.next()) {
                String mod = result.getString("modelo");
                long cap = result.getLong("capacidade");
                aB = new Aeronave(mod, cap);
                aB.setCodigo(codigo);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return aB;
    }
    
    @Override
    public Aeronave buscarNome(String modelo) {
        Aeronave aB = null;
        try {
            buscarStatement.setString(1, modelo);
            ResultSet result = buscarStatement.executeQuery();
            if (result.next()) {
                long codigo = result.getLong("aeronave_ID");
                long cap = result.getLong("capacidade");
                aB = new Aeronave(modelo, cap);
                aB.setCodigo(codigo);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return aB;
    }
}
