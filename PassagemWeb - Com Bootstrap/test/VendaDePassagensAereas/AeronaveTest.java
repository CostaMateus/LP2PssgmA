package VendaDePassagensAereas;

import VendaDePassagensAereas.dominio.Voo;
import VendaDePassagensAereas.dominio.Aeronave;
import VendaDePassagensAereas.dominio.Localidade;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class AeronaveTest {
    
    @Test
    public void testCGS() {
        
        String mod = "Boing-747";
        long cap = 300;
        
        Aeronave av = new Aeronave(mod, cap);
        Aeronave av1 = av;
        Aeronave av2 = new Aeronave(mod+".9", cap+50);
        Aeronave av3 = new Aeronave(mod, cap);
        
        Localidade orig = new Localidade("São Paulo", Localidade.SiglaUF.SP);
        Localidade dest = new Localidade("Rio de Janeiro", Localidade.SiglaUF.RJ);
        
        Voo voo = new Voo(orig, dest, av, "19A", LocalDateTime.parse("2015-09-10T15:30:00"));
        Voo voo1 = new Voo(orig, dest, av2, "19A", LocalDateTime.parse("2015-09-11T17:30:00"));
        Voo voo2 = new Voo(orig, dest, av, "1A", LocalDateTime.parse("2015-09-12T18:30:00"));
        Voo voo3 = new Voo(orig, dest, av2, "13A", LocalDateTime.parse("2015-09-15T20:30:00"));
        
        Assert.assertEquals(av, av1);
               
        Assert.assertEquals(av.getModelo(), mod);
        Assert.assertTrue(av.getCapacidade() == cap);
        
        String mod2 = "Boing-747.9";
        Assert.assertEquals(av2.getModelo(), mod2);
        Assert.assertTrue(av2.getCodigo() == 1001);
        
        av3.setCapacidade(200);
        mod = "Boing-727";
        av3.setModelo(mod);
        Assert.assertFalse(av3.getCapacidade() == cap);
        Assert.assertEquals(av3.getModelo(), mod);
        Assert.assertTrue(av3.getCodigo() == 1002);
        
        /*
        System.out.println(av.toString());
        System.out.println(av2.toString());
        System.out.println(av3.toString());
        */
        
        dest = new Localidade("Guarulhos", Localidade.SiglaUF.SP);
        voo2.setDestino(dest);
        voo3.setDestino(dest);
        
        av.addVoo(voo);
        av.addVoo(voo2);
        av2.addVoo(voo1);
        av2.addVoo(voo3);
        
        List<Voo> vs = new ArrayList<>();
        vs.add(voo);
        vs.add(voo2);
        String v1="";
        for(Voo v2:vs) {
            v1 += v2+"\n"; }
        Assert.assertEquals(v1, av.getVoos());
        
        vs.remove(voo);
        vs.remove(voo2);
        
        vs.add(voo1);
        vs.add(voo3);
        v1="";
        for(Voo v2:vs) {
            v1 += v2+"\n"; }
        Assert.assertEquals(v1, av2.getVoos());
        /*
        System.out.println("\nVoos da aeronave " + av.toString());
        System.out.println(av.getVoos());
        
        System.out.println("\nVoos da aeronave " + av2.toString());
        System.out.println(av2.getVoos());
        
        av.removeVoo(voo);
        System.out.println("\nVoos da aeronave " + av.toString());
        System.out.println(av.getVoos());
        */
    }
    
}
