package src.br.com.alura.loja;

import java.math.BigDecimal;

import src.br.com.alura.loja.imposto.CalculadoraDeImpostos;
import src.br.com.alura.loja.imposto.ISS;
import src.br.com.alura.loja.orcamento.ItemOrcamento;
import src.br.com.alura.loja.orcamento.Orcamento;

public class TestesImposto {

	public static void main(String[] args) {
		
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
		CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
		
		System.out.println(calculadora.calcular(orcamento, new ISS(null)));

	}

}
