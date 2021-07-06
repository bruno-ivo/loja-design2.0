package src.br.com.alura.loja;

import java.math.BigDecimal;

import src.br.com.alura.loja.http.JavaHttpClient;
import src.br.com.alura.loja.orcamento.ItemOrcamento;
import src.br.com.alura.loja.orcamento.Orcamento;
import src.br.com.alura.loja.orcamento.RegistroDeOrcamento;

public class TestesAdapter {

	public static void main(String[] args) {
		Orcamento orc  = new Orcamento();
		orc.adicionarItem(new ItemOrcamento(new BigDecimal("10")));
		orc.aprovar();
		orc.finalizar();
		
		
		// Registrode Orçamento irá receber um adaptador, porem nesse caso ufoi usado o JavaHttpClient
		//como classe de teste de Apadter
		RegistroDeOrcamento res = new RegistroDeOrcamento(new JavaHttpClient());
		res.registrar(orc);


	}

}
