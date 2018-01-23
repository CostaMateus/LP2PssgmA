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

public class Localidade {

    public enum SiglaUF {
        AC, AL, AP, AM, BA, CE, DF, ES, GO,
        MA, MT, MS, MG, PA, PB, PR, PE, PI,
        RJ, RN, RS, RO, RR, SC, SP, SE, TO
    };
    private long codigo;
    private String nomeCidade;
    private SiglaUF uf;
    private List<Voo> voos;

    public Localidade() {
        voos = new ArrayList<>();
    }

    public Localidade(String nomeCidade, SiglaUF uf) {
        this();
        this.nomeCidade = nomeCidade;
        this.uf = uf;
        this.codigo = Codigo.getNextIdDestino();
    }
    
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public SiglaUF getUf() {
        return uf;
    }

    public void setUf(SiglaUF uf) {
        this.uf = uf;
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
                this.voos.remove(v);
            }
        }
    }

    @Override
    public String toString() {
        return (nomeCidade + "-" + uf);
    }
}
