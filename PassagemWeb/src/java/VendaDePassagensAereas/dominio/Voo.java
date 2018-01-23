package VendaDePassagensAereas.dominio;

/**
 *
 * Jaime Nobrega (41411633) 
 * Lucas Beda (41456963) 
 * Mateus Costa (31407595)
 *
 */

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Voo {

    private long codigo;
    private Localidade origem;
    private Localidade destino;
    private Aeronave aviao;
    private String portao;
    private LocalDateTime dataHora;
    private List<Passagem> passagens;

    public Voo() {
        passagens = new ArrayList<>();
    }

    public Voo(Localidade origem, Localidade destino, Aeronave aviao, 
               String portao, LocalDateTime dataHora) {
        this();
        this.origem = origem;
        this.destino = destino;
        this.aviao = aviao;
        this.portao = portao;
        this.dataHora = dataHora;
        this.codigo = Codigo.getNextIdVoo();
    }

    public long getCodigo() {
        return codigo;
    }
    
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }
    
    public Localidade getOrigem() {
        return origem;
    }

    public void setOrigem(Localidade origem) {
        this.origem = origem;
    }
    
    public Localidade getDestino() {
        return destino;
    }

    public void setDestino(Localidade destino) {
        this.destino = destino;
    }
    
    public Aeronave getAviao() {
        return aviao;
    }

    public void setAviao(Aeronave aviao) {
        this.aviao = aviao;
    }
    
    public String getPortao() {
        return portao;
    }

    public void setPortao(String portao) {
        this.portao = portao;
    }
    
    public LocalTime getHora(){
        return dataHora.toLocalTime();
    }
    
    public LocalDate getData(){
        return dataHora.toLocalDate();
    }
    
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public List<Passagem> getPassagens() {
        return passagens;
    }

    public void setPassagens(List<Passagem> passagens) {
        this.passagens = passagens;
    }
    
    public void addPassageiros(Passagem passageiro) {
        this.passagens.add(passageiro);
    }

    public void removePassageiro(Passagem passageiro) {
        for (Passagem p : passagens) {
            if (p.getCodigo() == passageiro.getCodigo()) {
                this.passagens.remove(passageiro);
            }
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter formatadorDia = DateTimeFormatter.ofPattern("d/M/y");
        DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("h:mm:ss");
        return ("Voo de " + this.origem.toString()
                + ", para " + this.destino.toString()
                + ", ID " + this.codigo
                + ", às " + formatadorHora.format(this.dataHora)
                + ", dia " + formatadorDia.format(this.dataHora));
    }

}
