package src.main.java.test;

import org.junit.jupiter.api.Test;
import src.main.java.Acao;
import src.main.java.Investidor;

import static org.junit.jupiter.api.Assertions.*;

class AcaoTest {

    @Test
    void deveNotificarUmInvestidor() {
        Acao acao = new Acao("PETRA", 28.00);

        Investidor investidor = new Investidor("Investidor 1");

        acao.addObserver(investidor);
        acao.setPreco(30.00);

        assertEquals(30.00, acao.getPreco());
    }

    @Test
    void deveNotificarMultiplosInvestidores() {
        Acao acao = new Acao("BRAHMA", 95.00);

        Investidor investidor1 = new Investidor("Investidor 1");
        Investidor investidor2 = new Investidor("Investidor 2");

        acao.addObserver(investidor1);
        acao.addObserver(investidor2);
        acao.setPreco(100.00);

        assertEquals(100.00, acao.getPreco());
    }

    @Test
    void naoDeveNotificarInvestidorSemAlteracaoDePreco() {
        Acao acao = new Acao("STELLA", 16.00);

        Investidor investidor = new Investidor("Investidor 1");

        acao.addObserver(investidor);
        acao.setPreco(16.00);

        assertEquals(16.00, acao.getPreco());
    }

    @Test
    void deveNotificarApenasInvestidoresObservandoUmaAcaoEspecifica() {
        Acao acao1 = new Acao("HEINEKEN", 25.00);
        Acao acao2 = new Acao("SKOL", 32.00);

        Investidor investidor1 = new Investidor("Investidor 1");
        Investidor investidor2 = new Investidor("Investidor 2");

        acao1.addObserver(investidor1);
        acao2.addObserver(investidor2);

        acao1.setPreco(27.00);

        assertEquals(27.00, acao1.getPreco());
        assertEquals(32.00, acao2.getPreco());
    }
}

