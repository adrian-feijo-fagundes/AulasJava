package org.example;

import java.util.List;

public class Hamburgueria {
    public static void main(String[] args) {
        Hamburguer hamburguer = new Hamburguer(42, "X-tudo");
        Hamburguer hamburguer2 = new Hamburguer(34, "Bacon");
        Hamburguer hamburguer3 = new Hamburguer(27,"Carne");
        Hamburguer hamburguer4 = new Hamburguer(32, "Picanha");
        Hamburguer hamburguer5 = new Hamburguer(27, "X-Salada");
        Hamburguer hamburguer6 = new Hamburguer(28, "Duplo de carne");
        Hamburguer hamburguer7 = new Hamburguer(42, "X-Costela");

        Pedidos pedido = new Pedidos();

        pedido.addHamburger(hamburguer);
        pedido.addHamburger(hamburguer4);
        pedido.addHamburger(hamburguer5);

        pedido.aplicarDescontoCupom("CUPOM");
    }
}
