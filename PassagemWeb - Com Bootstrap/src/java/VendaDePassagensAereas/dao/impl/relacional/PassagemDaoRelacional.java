package VendaDePassagensAereas.dao.impl.relacional;

import VendaDePassagensAereas.dao.api.PassagemDaoInterface;
import VendaDePassagensAereas.dominio.Passagem;
import VendaDePassagensAereas.dominio.Voo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PassagemDaoRelacional implements PassagemDaoInterface {

    private ConexaoInterface conexao;
    private PreparedStatement listarStatement;
    private PreparedStatement inserirStatement;
    private PreparedStatement apagarStatement;
    private PreparedStatement atualizarStatement;
    private PreparedStatement buscarStatement;
    private PreparedStatement buscarPassagemStatement;
    
    public PassagemDaoRelacional(ConexaoInterface conexao) {
        this.conexao = conexao;
        String sql;
        try {
            sql = "SELECT * FROM passagens";
            listarStatement = conexao.getConnection().prepareStatement(sql);
            
            sql = "INSERT INTO passagens (passagem_ID, mVoo, poltrona, nome, cpf) "
                    + "VALUES (?, ?, ?, ?, ?)";
            inserirStatement = conexao.getConnection().prepareStatement(sql);
            
            sql = "DELETE FROM passagens WHERE passagem_ID = ?";
            apagarStatement = conexao.getConnection().prepareStatement(sql);
            
            sql = "UPDATE passagens SET "
                  + "mVoo=?, poltrona=?, nome=? WHERE passagem_ID=?";
            atualizarStatement = conexao.getConnection().prepareStatement(sql);
            
            sql = "SELECT * FROM passagens WHERE passagem_ID=?";
            buscarStatement = conexao.getConnection().prepareStatement(sql);
            
            sql = "SELECT * FROM passagens WHERE mVoo=?";
            buscarPassagemStatement = conexao.getConnection().prepareStatement(sql);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

    @Override
    public List<Passagem> listarTudo() {
        List<Passagem> passagens = new ArrayList<>();

        try {
            ResultSet result = listarStatement.executeQuery();
            while (result.next()) {
                long cod = result.getLong("passagem_ID");
                long codVoo = result.getLong("mVoo");
                Voo v = new Voo();
                v.setCodigo(codVoo);
                long polt = result.getLong("poltrona");
                String nome = result.getString("nome");
                String cpf = result.getString("cpf");
                Passagem a = new Passagem(v, polt, nome, cpf);
                a.setCodigo(cod);
                passagens.add(a);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return passagens;
    }

    @Override
    public void inserir(Passagem p) {
        try {
            inserirStatement.setLong(1, p.getCodigo());
            inserirStatement.setLong(2, p.getVoo().getCodigo());
            inserirStatement.setLong(3, p.getPoltrona());
            inserirStatement.setString(4, p.getNome());
            inserirStatement.setString(5, p.getCpf());
            inserirStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void apagar(Passagem p) {
        try {
            apagarStatement.setLong(1, p.getCodigo());
            apagarStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void atualizar(Passagem p) {
        try {
            atualizarStatement.setLong(1, p.getVoo().getCodigo());
            atualizarStatement.setLong(2, p.getPoltrona());
            atualizarStatement.setString(3, p.getNome());
            atualizarStatement.setLong(4, p.getCodigo());
            atualizarStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Passagem buscar(long codigo) {
        Passagem pB = null;
        try {
            buscarStatement.setLong(1, codigo);
            ResultSet result = buscarStatement.executeQuery();
            if (result.next()) {
                long codVoo = result.getLong("mVoo");
                Voo v = new Voo();
                v.setCodigo(codVoo);
                long polt = result.getLong("poltrona");
                String nome = result.getString("nome");
                String cpf = result.getString("cpf");
                pB = new Passagem(v, polt, nome, cpf);
                pB.setCodigo(codigo);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return pB;
    }
    
    @Override
    public List<Passagem> buscarPassagens(long codVoo) {
        List<Passagem> lista = new ArrayList<>();
        try {
            buscarPassagemStatement.setLong(1, codVoo);
            ResultSet result = buscarPassagemStatement.executeQuery();
            while (result.next()) {
                long codigoPssgm = result.getLong("passagem_ID");
                Voo v = new Voo();
                v.setCodigo(codVoo);
                long polt = result.getLong("poltrona");
                String nome = result.getString("nome");
                String cpf = result.getString("cpf");
                Passagem pgm = new Passagem(v, polt, nome, cpf);
                pgm.setCodigo(codigoPssgm);
                
                lista.add(pgm);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
