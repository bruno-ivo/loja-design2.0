package src.br.com.alura.loja.orcamento;

import java.util.Map;

import src.br.com.alura.loja.DomainException;
import src.br.com.alura.loja.http.HttpAdapter;

public class RegistroDeOrcamento {
	
	private HttpAdapter http;
	
	public RegistroDeOrcamento (HttpAdapter http) {
		this.http = http;
	}
	
	public void registrar(Orcamento orcamento) {
		
		if (!orcamento.isFinalizado()) {
			throw new DomainException("Orçamento Não Finalizado");
		}
		String url = "http://api.externa/orcamento";
		//Cria um mapa com esses itens
		Map<String, Object> dados = Map.of(
				"valor", orcamento.getValor(),
				"quantidadeItens", orcamento.getQuantidadeItens()
				);
		//Metodo da classe HttpAdapter
		http.post(url, dados);
		
	}


}

