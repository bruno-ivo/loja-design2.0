package src.br.com.alura.loja;

import java.math.BigDecimal;
import java.util.Arrays;

import src.br.com.alura.loja.pedido.GeraPedido;
import src.br.com.alura.loja.pedido.GeraPedidoHandler;
import src.br.com.alura.loja.pedido.acoes.CriarPedidoNoBanco;
import src.br.com.alura.loja.pedido.acoes.EnviarPedidoPorEmail;
import src.br.com.alura.loja.pedido.acoes.LogDePedido;

public class TestesPedidos {

	public static void main(String[] args) {
		String cliente = "Ana da Silva";
		BigDecimal valorOrcamento = new BigDecimal("745.99");
		int quantidadeItens = 3;
		
		GeraPedido gerador = new GeraPedido(cliente, valorOrcamento, quantidadeItens);
		GeraPedidoHandler handler = new GeraPedidoHandler(Arrays.asList(
				new EnviarPedidoPorEmail(),
				new CriarPedidoNoBanco(),
				new LogDePedido()));
		handler.executar(gerador);
	}

}
