package VendaDePassagensAereas.dao.api;

import VendaDePassagensAereas.dominio.Aeronave;
import java.util.List;

public interface AeronaveDaoInterface {
    // lista todas as aeronaves
    List<Aeronave> listarTudo();
    
    // insere uma nova aeronava
    void inserir(Aeronave a);
    
    // remove uma aeronave
    void apagar(Aeronave a);
    
    // atualiza uma aeronave
    void atualizar(Aeronave a);
    
    // obtem aeronave pelo codigo informado
    Aeronave buscar(long codigo);
    
    // obtem aeronave pelo modelo informado
    Aeronave buscarNome(String modelo);
}
