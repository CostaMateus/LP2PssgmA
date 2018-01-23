package VendaDePassagensAereas.dao.impl.relacional;

import VendaDePassagensAereas.dao.api.VooDaoInterface;
import VendaDePassagensAereas.dominio.Aeronave;
import VendaDePassagensAereas.dominio.Localidade;
import VendaDePassagensAereas.dominio.Passagem;
import VendaDePassagensAereas.dominio.Voo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VooDaoRelacional implements VooDaoInterface {

    private ConexaoInterface conexao;
    private PreparedStatement listarStatement;
    private PreparedStatement inserirStatement;
    private PreparedStatement apagarStatement;
    private PreparedStatement atualizarStatement;
    private PreparedStatement buscarStatement;
    private PreparedStatement buscarPassagensStatement;
    
    public VooDaoRelacional(ConexaoInterface conexao) {
        this.conexao = conexao;
        String sql;
        try {
            sql = "SELECT * FROM voos";
            listarStatement = conexao.getConnection().prepareStatement(sql);
            
            sql = "INSERT INTO voos (voo_ID, mLocalOrigem, "
                  + "mLocalDestino, mAeronave, portao, horario) "
                  + "VALUES (?, ?, ?, ?, ?, ?)";
            inserirStatement = conexao.getConnection().prepareStatement(sql);
            
            sql = "DELETE FROM voos WHERE voo_ID = ?";
            apagarStatement = conexao.getConnection().prepareStatement(sql);
            
            sql = "UPDATE voos SET "
                  + "mLocalOrigem=?, mLocalDestino=?, "
                  + "portao=?, horario=? WHERE voo_ID=?";
            atualizarStatement = conexao.getConnection().prepareStatement(sql);
            
            sql = "SELECT * FROM voos WHERE voo_ID=?";
            buscarStatement = conexao.getConnection().prepareStatement(sql);
            
            sql = "SELECT * FROM passagens WHERE mVoo=?";
            buscarPassagensStatement = conexao.getConnection().prepareStatement(sql);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Voo> listarTudo() {
        List<Voo> voos = new ArrayList<Voo>();
        try {
            ResultSet result = listarStatement.executeQuery();
            while (result.next()) {
                long c = result.getLong("voo_ID");
                
                long idOri = result.getLong("mLocalOrigem");
                Localidade ori = new Localidade();
                ori.setCodigo(idOri);
                
                long idDes = result.getLong("mLocalDestino");
                Localidade des = new Localidade();
                des.setCodigo(idDes);
                
                long idAer = result.getLong("mAeronave");
                Aeronave ae = new Aeronave();
                ae.setCodigo(idAer);
                
                String p = result.getString("portao");
                LocalDateTime dh = result.getTimestamp("horario").toLocalDateTime();
                
                Voo v = new Voo(ori, des, ae, p, dh);
                v.setCodigo(c);
                voos.add(v);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return voos;
    }

    @Override
    public void inserir(Voo v) {
        try {
            inserirStatement.setLong(1, v.getCodigo());
            inserirStatement.setLong(2, v.getOrigem().getCodigo());
            inserirStatement.setLong(3, v.getDestino().getCodigo());
            inserirStatement.setLong(4, v.getAviao().getCodigo());
            inserirStatement.setString(5, v.getPortao());
            inserirStatement.setTimestamp(6, Timestamp.valueOf(v.getDataHora()));
            inserirStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void apagar(Voo v) {
        try {
            apagarStatement.setLong(1, v.getCodigo());
            apagarStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void atualizar(Voo v) {
        try {
            atualizarStatement.setLong(1, v.getOrigem().getCodigo());
            atualizarStatement.setLong(2, v.getDestino().getCodigo());
            atualizarStatement.setString(3, v.getPortao());
            atualizarStatement.setTimestamp(4, Timestamp.valueOf(v.getDataHora()));
            atualizarStatement.setLong(5, v.getCodigo());
            atualizarStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Voo buscar(long codigo) {
        Voo vB = null;
        try {
            buscarStatement.setLong(1, codigo);
            ResultSet result = buscarStatement.executeQuery();
            while (result.next()) {
                long idOri = result.getLong("mLocalOrigem");
                Localidade ori = new Localidade();
                ori.setCodigo(idOri);

                long idDes = result.getLong("mLocalDestino");
                Localidade des = new Localidade();
                des.setCodigo(idDes);

                long idAer = result.getLong("mAeronave");
                Aeronave ae = new Aeronave();
                ae.setCodigo(idAer);

                String p = result.getString("portao");
                LocalDateTime dh = result.getTimestamp("horario").toLocalDateTime();

                Voo v = new Voo(ori, des, ae, p, dh);
                v.setCodigo(codigo);
                vB = v;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return vB;
    }

    @Override
    public Voo buscarPassagens(long codigo) {
        Voo v= null;
        List<Passagem> pgns = new ArrayList<>();
        try {
            buscarPassagensStatement.setLong(1, codigo);
            ResultSet result = buscarPassagensStatement.executeQuery();
            while (result.next()) {
                long codP = result.getLong("passagem_ID");
                int polt = result.getInt("poltrona");
                String nome = result.getString("nome");
                String cpf = result.getString("cpf");
                
                Passagem p = new Passagem(v, polt, nome, cpf);
                p.setCodigo(codP);
                pgns.add(p);
            }
            v = this.buscar(codigo);
            v.setPassagens(pgns);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return v;
    }
    
}
