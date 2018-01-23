package VendaDePassagensAereas.servlets.utils;

import VendaDePassagensAereas.dao.api.AeronaveDaoInterface;
import VendaDePassagensAereas.dao.api.LocalidadeDaoInterface;
import VendaDePassagensAereas.dao.api.PassagemDaoInterface;
import VendaDePassagensAereas.dao.api.VooDaoInterface;
import VendaDePassagensAereas.dao.impl.relacional.AeronaveDaoRelacional;
import VendaDePassagensAereas.dao.impl.relacional.ConexaoInterface;
import VendaDePassagensAereas.dao.impl.relacional.LocalidadeDaoRelacional;
import VendaDePassagensAereas.dao.impl.relacional.PassagemDaoRelacional;
import VendaDePassagensAereas.dao.impl.relacional.VooDaoRelacional;
import VendaDePassagensAereas.dao.impl.relacional.javadb.ConexaoJavaDb;
import javax.servlet.http.HttpSession;

public class SessionUtils {
    
    public static ConexaoInterface getConexao(HttpSession session) {
        ConexaoInterface conexao = 
                (ConexaoInterface) session.getAttribute("conexaoSessao");
        if (conexao == null) {
            conexao = new ConexaoJavaDb("localhost", 1527, "passagemAerea",
                                          "app", "app");
            session.setAttribute("conexaoSessao", conexao);
        }
        return conexao;
    }
    
    public static VooDaoInterface getVooDao(HttpSession session, ConexaoInterface conexao) {
        VooDaoInterface dao = 
                (VooDaoInterface) session.getAttribute("vooDaoSessao");
        if (dao == null) {
            dao = new VooDaoRelacional(conexao);
            session.setAttribute("vooDaoSessao", dao);
        }
        return dao;
    }
    
    public static AeronaveDaoInterface getAeronaveDao(HttpSession session, ConexaoInterface conexao) {
        AeronaveDaoInterface dao = 
                (AeronaveDaoInterface) session.getAttribute("aeronaveDaoSessao");
        if (dao == null) {
            dao = new AeronaveDaoRelacional(conexao);
            session.setAttribute("aeronaveDaoSessao", dao);
        }
        return dao;
    }
    
    public static LocalidadeDaoInterface getLocalidadeDao(HttpSession session, ConexaoInterface conexao) {
        LocalidadeDaoInterface dao = 
                (LocalidadeDaoInterface) session.getAttribute("localidadeDaoSessao");
        if (dao == null) {
            dao = new LocalidadeDaoRelacional(conexao);
            session.setAttribute("localidadeDaoSessao", dao);
        }
        return dao;
    }
    
    public static PassagemDaoInterface getPassagemDao(HttpSession session, ConexaoInterface conexao) {
        PassagemDaoInterface dao = 
                (PassagemDaoInterface) session.getAttribute("passagemDaoSessao");
        if (dao == null) {
            dao = new PassagemDaoRelacional(conexao);
            session.setAttribute("passagemDaoSessao", dao);
        }
        return dao;
    }
}
