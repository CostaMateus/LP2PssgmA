package VendaDePassagensAereas.dao.api;

import VendaDePassagensAereas.dominio.Passagem;
import java.util.List;

public interface PassagemDaoInterface {
    // lista todas as passagens
    List<Passagem> listarTudo();
    
    // insere uma nova passagem
    void inserir(Passagem p);
    
    // remove uma passagem
    void apagar(Passagem p);
    
    // atualiza uma passagem
    void atualizar(Passagem p );
    
    // obtem passagem pelo codigo informado
    Passagem buscar(long codigo);
    
    // obtem lista de passagem de um voo
    List<Passagem> buscarPassagens(long codigoV);
}