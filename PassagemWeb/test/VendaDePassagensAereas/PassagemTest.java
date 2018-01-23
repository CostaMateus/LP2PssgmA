package VendaDePassagensAereas;

import VendaDePassagensAereas.dominio.Voo;
import VendaDePassagensAereas.dominio.Aeronave;
import VendaDePassagensAereas.dominio.Localidade;
import VendaDePassagensAereas.dominio.Passagem;
import VendaDePassagensAereas.dominio.Localidade.SiglaUF;
import java.time.LocalDateTime;
import org.junit.Test;

public class PassagemTest {

    @Test
    public void testCGS() {
        String cdd1 = "São Paulo";
        String cdd2 = "Cuiabá";
        String mod = "Boing-747";
        Localidade orig1 = new Localidade(cdd1, SiglaUF.SP);
        Localidade dest1 = new Localidade(cdd2, SiglaUF.MT);
        Aeronave av1 = new Aeronave(mod, 300);
        Voo voo1 = new Voo(orig1, dest1, av1, "19A", LocalDateTime.parse("2015-09-10T15:30:00"));
        //System.out.println(voo1.toString()+"\n");
        
        cdd1 = "Brasilia";
        cdd2 = "Guarulhos";
        mod = "Boing-707";
        Localidade orig2 = new Localidade(cdd1, SiglaUF.DF);
        Localidade dest2 = new Localidade(cdd2, SiglaUF.SP);
        Aeronave av2 = new Aeronave(mod, 200);
        Voo voo2 = new Voo(orig2, dest2, av2, "1B", LocalDateTime.parse("2015-09-10T23:30:00"));
        //System.out.println(voo2.toString()+"\n");
        
        int assento = 0;
        String nome = "Mateus";
        String cpf = "12345";
        Passagem pas1 = new Passagem(voo1, assento+10, nome+" L.", cpf+" L.");
        Passagem pas2 = new Passagem(voo1, assento+20, nome+" C.", cpf+" C.");
        Passagem pas3 = new Passagem(voo2, assento+30, nome+" K.", cpf+" K.");
        Passagem pas4 = new Passagem(voo2, assento+40, nome+" T.", cpf+" T.");
        
        voo1.addPassageiros(pas1);
        voo1.addPassageiros(pas2);
        /*
        System.out.println(voo1.getDataHora());
        System.out.println(voo1.getDestino());
        System.out.println(voo1.getAviao());
        System.out.println(voo1.getPassagens());
        */
        voo2.addPassageiros(pas3);
        voo2.addPassageiros(pas4);
        /*
        System.out.println(voo2.getDataHora());
        System.out.println(voo2.getDestino());
        System.out.println(voo2.getAviao());
        System.out.println(voo2.getPassagens());
        */
    }
    
}
