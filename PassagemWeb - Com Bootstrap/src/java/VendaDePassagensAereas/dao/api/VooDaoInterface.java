package VendaDePassagensAereas.dao.api;

import VendaDePassagensAereas.dominio.Passagem;
import VendaDePassagensAereas.dominio.Voo;
import java.util.List;

public interface VooDaoInterface {
    // lista todas as aeronaves
    List<Voo> listarTudo();
    
    // insere um novo voo
    void inserir(Voo v);
    
    // remove um voo
    void apagar(Voo v);
    
    // atualiza um voo
    void atualizar(Voo v);
    
    // obtem voo pelo codigo informado
    Voo buscar(long codigo);
    
    // obtem passagens do voo pelo codigo do voo
    Voo buscarPassagens(long codigo);
}