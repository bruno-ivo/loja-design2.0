package src.br.com.alura.loja.orcamento.situacao;

import java.math.BigDecimal;

import src.br.com.alura.loja.DomainException;
import src.br.com.alura.loja.orcamento.Orcamento;

public class Finalizado extends SituacaoOrcamento {

	@Override
	public BigDecimal calcularDescontoExtra(Orcamento orcamento) {
		throw new DomainException("Orcamento finalizado nao pode ter desconto extra!");
	}

}
