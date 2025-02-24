package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pedidos {
    private List<Hamburguer> hamburguers = new ArrayList<>();

    private double descontoCupom;

    public void addHamburger(Hamburguer burger) {
        hamburguers.add(burger);
    }

    public void aplicarDescontoCupom(String codigoCupom) {
        switch (codigoCupom) {
            case "CUPOM":
                descontoCupom = 5;
                break;
            case "CUPOM10":
                descontoCupom = 10;
                break;
        }
    }

    public double calcularTotal() {
        double total = 0;

        for (Hamburguer hamburguer: hamburguers) {
            total += hamburguer.getPreco();
        }
        total -= descontoCupom;

        if (hamburguers.size() >= 3) {
            total -= 5;
        }

        return total;
    }

    public List<Hamburguer> getHamburguers() {
        return hamburguers;
    }

    public double getDescontoCupom() {
        return descontoCupom;
    }
}
