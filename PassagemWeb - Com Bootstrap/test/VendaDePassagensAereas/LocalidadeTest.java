package VendaDePassagensAereas;

import VendaDePassagensAereas.dominio.Localidade;
import VendaDePassagensAereas.dominio.Localidade.SiglaUF;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class LocalidadeTest {

    @Test
    public void testCGS() {
        String nomeC = "São Paulo";
        
        Localidade orig = new Localidade (nomeC, SiglaUF.SP);
        Localidade dest = new Localidade (nomeC, SiglaUF.SP);
        
        Assert.assertEquals(orig.getNomeCidade(), nomeC);
        Assert.assertEquals(orig.getUf(), SiglaUF.SP);
        
        orig.setNomeCidade("Cuiabá");
        orig.setUf(SiglaUF.MT);
        
        Assert.assertEquals(orig.getNomeCidade(), "Cuiabá");
        Assert.assertTrue(orig.getUf().equals(SiglaUF.MT));
        /*
        System.out.println("Origem: " + orig.toString());
        System.out.println("Destino: " + dest.toString());
        */
    }
    
}
