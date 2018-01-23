package VendaDePassagensAereas.dominio;

public class Codigo {

    private static long idAeronave = 2000;
    private static long idPassagem = 2000;
    private static long idVoo = 2000;
    private static long idDestino = 2000;
    private static long idOrigem = 2000;
    
    public static long getNextIdAeronave() {
        return idAeronave++;
    }

    public static long getNextIdPassagem() {
        return idPassagem++;
    }
    
    public static long getNextIdVoo() {
        return idVoo++;
    }
    
    public static long getNextIdDestino() {
        return idDestino++;
    }
    
    public static long getNextIdOrigem() {
        return idOrigem++;
    }
}
