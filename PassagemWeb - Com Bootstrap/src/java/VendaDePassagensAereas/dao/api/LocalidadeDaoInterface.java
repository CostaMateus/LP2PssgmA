package VendaDePassagensAereas.dao.api;

import VendaDePassagensAereas.dominio.Localidade;
import java.util.List;

public interface LocalidadeDaoInterface {
    // lista todas as aeronaves
    List<Localidade> listarTudo();
    
    // insere uma nova cidade
    void inserir(Localidade o);
    
    // remove uma cidade
    void apagar(Localidade o);
    
    // atualiza uma cidade
    void atualizar(Localidade o);
    
    // obtem cidade pelo codigo informado
    Localidade buscar(long codigo);
    
    // obtem cidade pelo nome
    Localidade buscarNome(String nome);
}    
