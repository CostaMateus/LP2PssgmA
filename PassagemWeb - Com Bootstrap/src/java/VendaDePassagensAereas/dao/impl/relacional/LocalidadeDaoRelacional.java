package VendaDePassagensAereas.dao.impl.relacional;

import VendaDePassagensAereas.dao.api.LocalidadeDaoInterface;
import VendaDePassagensAereas.dominio.Localidade;
import VendaDePassagensAereas.dominio.Localidade.SiglaUF;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LocalidadeDaoRelacional implements LocalidadeDaoInterface {

    private ConexaoInterface conexao;
    private PreparedStatement listarStatement;
    private PreparedStatement inserirStatement;
    private PreparedStatement apagarStatement;
    private PreparedStatement atualizarStatement;
    private PreparedStatement buscarStatement;
    private PreparedStatement buscarNomeStatement;

    public LocalidadeDaoRelacional(ConexaoInterface conexao) {
        this.conexao = conexao;
        String sql;
        try {
            sql = "SELECT * FROM localidades";
            listarStatement = conexao.getConnection().prepareStatement(sql);
            
            sql = "INSERT INTO localidades (localidade_ID, nomeCidade, uf) "
                    + "VALUES (?, ?, ?)";
            inserirStatement = conexao.getConnection().prepareStatement(sql);
            
            sql = "DELETE FROM localidades WHERE localidade_ID = ?";
            apagarStatement = conexao.getConnection().prepareStatement(sql);
            
            sql = "UPDATE localidades SET nomeCidade=?, uf=? WHERE localidade_ID=?";
            atualizarStatement = conexao.getConnection().prepareStatement(sql);
            
            sql = "SELECT * FROM localidades WHERE localidade_ID=?";
            buscarStatement = conexao.getConnection().prepareStatement(sql);
            
            sql = "SELECT * FROM localidades WHERE nomeCidade=?";
            buscarNomeStatement = conexao.getConnection().prepareStatement(sql);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Localidade> listarTudo() {
        List<Localidade> aeronaves = new ArrayList<>();
        try {
            ResultSet result = listarStatement.executeQuery();
            while (result.next()) {
                long c = result.getLong("localidade_ID");
                String nc = result.getString("nomeCidade");
                SiglaUF uf = SiglaUF.valueOf(result.getString("uf"));
                Localidade lo = new Localidade(nc, uf);
                lo.setCodigo(c);
                aeronaves.add(lo);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return aeronaves;
    }

    @Override
    public void inserir(Localidade lo) {
        try {
            inserirStatement.setLong(1, lo.getCodigo());
            inserirStatement.setString(2, lo.getNomeCidade());
            inserirStatement.setString(3, lo.getUf().name());
            inserirStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void apagar(Localidade lo) {
        try {
            apagarStatement.setLong(1, lo.getCodigo());
            apagarStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void atualizar(Localidade lo) {
        try {
            atualizarStatement.setString(1, lo.getNomeCidade());
            atualizarStatement.setString(2, lo.getUf().name());
            atualizarStatement.setLong(3, lo.getCodigo());
            atualizarStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Localidade buscar(long codigo) {
        Localidade loB = null;
        try {
            buscarStatement.setLong(1, codigo);
            ResultSet result = buscarStatement.executeQuery();
            if (result.next()) {
                String nc = result.getString("nomeCidade");
                SiglaUF uf = SiglaUF.valueOf(result.getString("uf"));
                loB = new Localidade(nc, uf);
                loB.setCodigo(codigo);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return loB;
    }
    
    @Override
    public Localidade buscarNome(String nome) {
        Localidade loB = null;
        try {
            buscarNomeStatement.setString(1, nome);
            ResultSet result = buscarNomeStatement.executeQuery();
            if (result.next()) {
                long codigo = result.getLong("localidade_ID");
                SiglaUF uf = SiglaUF.valueOf(result.getString("uf"));
                loB = new Localidade(nome, uf);
                loB.setCodigo(codigo);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return loB;
    }
}
