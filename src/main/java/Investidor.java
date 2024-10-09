package src.main.java;

import java.util.Observable;
import java.util.Observer;

public class Investidor implements Observer {
    private String nome;

    public Investidor(String nome) {
        this.nome = nome;
    }

    @Override
    public void update(Observable acao, Object preco) {
        if (acao instanceof Acao) {
            Acao acaoObservada = (Acao) acao;
            System.out.println("Notificação para " + nome + ": O preço da ação " +
                    acaoObservada.getSimbolo() + " mudou para " + preco);
        }
    }
}

