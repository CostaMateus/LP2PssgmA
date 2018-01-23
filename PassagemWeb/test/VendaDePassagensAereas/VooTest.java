package VendaDePassagensAereas;

import VendaDePassagensAereas.dominio.Voo;
import VendaDePassagensAereas.dominio.Aeronave;
import VendaDePassagensAereas.dominio.Localidade;
import VendaDePassagensAereas.dominio.Localidade.SiglaUF;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

public class VooTest {

    @Test
    public void testCGS() {
        Localidade orig = new Localidade("Rio de Janeiro", Localidade.SiglaUF.RJ);
        Localidade dest = new Localidade("São Paulo", Localidade.SiglaUF.SP);
        Localidade orig2 = new Localidade();
        orig2.setCodigo(1003);
        Aeronave avi = new Aeronave("Boing-747", 300);
        
        Voo voo = new Voo(orig, dest, avi, "19A", LocalDateTime.parse("2015-09-10T15:30:00"));
        Voo voo1 = new Voo(orig, dest, avi, "19A", LocalDateTime.parse("2015-09-11T17:30:00"));
        Voo voo2 = new Voo(orig2, dest, avi, "12A", LocalDateTime.parse("2015-09-12T18:30:00"));
        Voo voo3 = new Voo(orig, dest, avi, "13A", LocalDateTime.parse("2015-09-15T20:30:00"));
        
        System.out.println(voo.getOrigem().getCodigo() + "\n" +
                           voo1.getDestino().getCodigo() + "\n" +
                           voo2.getOrigem().getCodigo());
        /*
        String cidd = "São Paulo";
        Assert.assertEquals(voo.getDestino().getNomeCidade(), cidd);
        Assert.assertTrue(voo.getCodigo() == 1000);
        
        cidd = "Guarulhos";
        Localidade dest2 = new Localidade(cidd, SiglaUF.SP);
        voo1.setDestino(dest2);
        voo3.setDestino(dest2);
        Assert.assertEquals(voo1.getDestino().getNomeCidade(), cidd);
        
        voo.setPortao("12B");
        Assert.assertTrue(voo.getPortao().equals("12B"));
        
        dest.addVoo(voo);
        dest.addVoo(voo2);
        dest2.addVoo(voo1);
        dest2.addVoo(voo3);
        
        List<Voo> vs = new ArrayList<>();
        vs.add(voo);
        vs.add(voo2);
        String v1="";
        for(Voo v2:vs) {
            v1 += v2+"\n"; }
        Assert.assertEquals(v1, dest.getVoos());
        
        vs.remove(voo);
        vs.remove(voo2);
        
        vs.add(voo1);
        vs.add(voo3);
        v1="";
        for(Voo v2:vs) {
            v1 += v2+"\n"; }
        Assert.assertEquals(v1, dest2.getVoos());
        
        
        System.out.println("Voos para " + dest.getNomeCidade() + ": ");
        System.out.println(dest.getVoos());
        System.out.println("\nVoos para " + dest2.getNomeCidade() + ": ");
        System.out.println(dest2.getVoos());
        
        dest.removeVoo(voo);
        dest2.removeVoo(voo1);
        
        System.out.println("\nVoos para " + dest.getNomeCidade() + ": ");
        System.out.println(dest.getVoos());
        System.out.println("\nVoos para " + dest2.getNomeCidade() + ": ");
        System.out.println(dest2.getVoos());
        */
    }
    
}
