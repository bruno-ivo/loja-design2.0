package src.br.com.alura.loja.pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import src.br.com.alura.loja.orcamento.ItemOrcamento;
import src.br.com.alura.loja.orcamento.Orcamento;
import src.br.com.alura.loja.pedido.acoes.AcaoAposGerarPedido;

public class GeraPedidoHandler {

	private List<AcaoAposGerarPedido> acoesAposGerarPedido;
	
	// injecao de dependencias para servicos de infra
	public GeraPedidoHandler(List<AcaoAposGerarPedido> acoesAposGerarPedidos) {
		acoesAposGerarPedido = acoesAposGerarPedidos;
	}
	//Padrão de projeto Facade, metodo de faxada 
	public void executar(GeraPedido geraPedido) {
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("200")));
		Pedido pedido = new Pedido(geraPedido.getCliente(), LocalDateTime.now(), orcamento);

		this.acoesAposGerarPedido.forEach(a -> a.executarAcao(pedido));
	}
	
}
