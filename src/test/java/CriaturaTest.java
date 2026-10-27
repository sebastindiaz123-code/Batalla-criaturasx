import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CriaturaTest {

    @Test
    void criaturaConSaludPositivaEstaViva() {
        assertTrue(new Guerrero("G", 10, 5, "espada").estaViva());
    }

    @Test
    void criaturaConSaludCeroEstaMuerta() {
        assertFalse(new Mago("M", 0, 5, "rayo").estaViva());
    }

    @Test
    void saludNuncaEsNegativa() {
        Guerrero g = new Guerrero("G", 5, 5, "espada");
        g.defender(1000);
        assertEquals(0, g.getSalud());
        assertFalse(g.estaViva());
    }

    @Test
    void dragonAtacaConDobleDeFuerza() {
        // Fuerza 10 -> daño 20; el Guerrero bloquea la mitad -> recibe 10
        Dragon d = new Dragon("D", 100, 10, "oro");
        Guerrero g = new Guerrero("G", 100, 5, "espada");
        d.atacar(g);
        assertEquals(90, g.getSalud());
    }

    @Test
    void magoAtacaConSuFuerza() {
        // Daño 10; las escamas absorben 20% -> recibe 8
        Mago m = new Mago("M", 100, 10, "fuego");
        Dragon d = new Dragon("D", 100, 5, "oro");
        m.atacar(d);
        assertEquals(92, d.getSalud());
    }

    @Test
    void guerreroAtacaConSuFuerza() {
        // Daño 10; barrera del mago -2 -> recibe 8
        Guerrero g = new Guerrero("G", 100, 10, "espada");
        Mago m = new Mago("M", 100, 5, "fuego");
        g.atacar(m);
        assertEquals(92, m.getSalud());
    }

    @Test
    void defensaSiempreRecibeAlMenosUnDeDaño() {
        Mago m = new Mago("M", 10, 5, "fuego");
        m.defender(1);
        assertEquals(9, m.getSalud());
    }

    @Test
    void polimorfismoTrataCriaturasDeFormaGenerica() {
        Criatura a = new Dragon("D", 100, 10, "oro");
        Criatura b = new Guerrero("G", 100, 10, "espada");
        a.atacar(b);
        assertTrue(b.getSalud() < 100);
    }

    @Test
    void simularBatallaTerminaConUnaCriaturaMuerta() {
        Criatura c1 = new Dragon("D", 100, 15, "oro");
        Criatura c2 = new Mago("M", 80, 12, "fuego");
        Criatura ganador = Main.simularBatalla(c1, c2);
        assertTrue(ganador.estaViva());
        assertFalse(c1.estaViva() && c2.estaViva());
    }

    @Test
    void ganaElPrimeroSiElSegundoMueredeUnGolpe() {
        Criatura c1 = new Dragon("D", 100, 100, "oro");
        Criatura c2 = new Guerrero("G", 1, 1, "espada");
        assertSame(c1, Main.simularBatalla(c1, c2));
    }
}
