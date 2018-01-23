package VendaDePassagensAereas.dominio;

/**
 *
 * Jaime Nobrega (41411633) 
 * Lucas Beda (41456963) 
 * Mateus Costa (31407595)
 *
 */

import java.util.ArrayList;
import java.util.List;

public class Aeronave {

    private long codigo;
    private String modelo;
    private long capacidade;
    private List<Voo> voos;

    public Aeronave() {
        voos = new ArrayList<>();
    }

    public Aeronave(String modelo, long capacidade) {
        this();
        this.modelo = modelo;
        this.capacidade = capacidade;
        this.codigo = Codigo.getNextIdAeronave();
    }
    
    public long getCodigo() {
        return codigo;
    }
    
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public long getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(long capacidade) {
        this.capacidade = capacidade;
    }

    public String getVoos() {
        String vs = "";
        for (Voo v : voos) {
            vs += v + "\n";
        }
        return vs;
    }

    public void addVoo(Voo voo) {
        this.voos.add(voo);
    }

    public void removeVoo(Voo voo) {
        for (Voo v : voos) {
            if (v.getCodigo() == voo.getCodigo()) {
                this.voos.remove(voo);
            }
        }
    }

    @Override
    public String toString() {
        return (modelo + " (" + capacidade + " lugares)");
    }
}
