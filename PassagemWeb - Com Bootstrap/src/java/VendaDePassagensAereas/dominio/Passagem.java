package VendaDePassagensAereas.dominio;

import java.time.LocalDateTime;

/**
 *
 * Jaime Nobrega (41411633) 
 * Lucas Beda (41456963) 
 * Mateus Costa (31407595)
 *
 */

public class Passagem {

    private long codigo;
    private Voo voo;
    private long poltrona;
    private String nome;
    private String cpf;

    public Passagem() {
    }

    public Passagem(Voo voo, long poltrona, String nome, String cpf) {
        this.voo = voo;
        this.poltrona = poltrona;
        this.nome = nome;
        this.cpf = cpf;
        this.codigo = Codigo.getNextIdPassagem();
    }

    public long getCodigo() {
        return codigo;
    }
    
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }
    
    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }
    
    public long getPoltrona() {
        return poltrona;
    }

    public void setPoltrona(long poltrona) {
        this.poltrona = poltrona;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    @Override
    public String toString() {
        return ("Passagem: " + this.voo
                + "\n\t Nome: " + this.nome
                + "\n\t CPF: " + this.cpf
                + "\n\t ID voo: " + this.voo.getCodigo()
                + "\n\t Assento: " + this.poltrona
                );
    }
}
