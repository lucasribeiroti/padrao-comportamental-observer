package src.main.java;

import java.util.Observable;

public class Acao extends Observable {
    private String simbolo;
    private double preco;

    public Acao(String simbolo, double precoInicial) {
        this.simbolo = simbolo;
        this.preco = precoInicial;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double novoPreco) {
        if (this.preco != novoPreco) {
            this.preco = novoPreco;
            setChanged();
            notifyObservers(novoPreco);
        }
    }

    @Override
    public String toString() {
        return "Acao{" +
                "simbolo='" + simbolo + '\'' +
                ", preco=" + preco +
                '}';
    }
}
