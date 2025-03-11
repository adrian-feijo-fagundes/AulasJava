import org.example.Hamburguer;
import org.example.Pedidos;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PedidosTest {
    // Teste para verificar  o total do pedido com cupom

    @Test
    public void testeCalcularTotalComCupom() {
        // Criando mocks, um mock é uma versão falsa para testar um objeto
        // Exemplo hamburguerMock

        Hamburguer hamburguerMock = Mockito.mock(Hamburguer.class);
        Hamburguer hamburguerMock2 = Mockito.mock(Hamburguer.class);

        Mockito.when(hamburguerMock.getPreco()).thenReturn(42.00);
        Mockito.when(hamburguerMock2.getPreco()).thenReturn(34.00);

        Pedidos pedidos = new Pedidos();
        pedidos.addHamburger(hamburguerMock);
        pedidos.addHamburger(hamburguerMock2);

        pedidos.aplicarDescontoCupom("CUPOM");

        double total = pedidos.calcularTotal();

        assertEquals(71, total, 0.01);
    }
}
