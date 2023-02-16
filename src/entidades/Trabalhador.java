package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enumeradas.NivelTrabalhador;

public class Trabalhador {
	private String nome;
	private NivelTrabalhador nivel;
	private Double salarioBase;
	
	private Departamento departamento;
	private List<ContratoHora> contratos = new ArrayList<>();
	
	public Trabalhador() {
		
	}

	public Trabalhador(String nome, NivelTrabalhador nivel, Double salarioBase, Departamento departamento) {
		super();
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public List<ContratoHora> getContratos(){
		return contratos;
	}
	
	public void addContrato(ContratoHora contrato) {
		contratos.add(contrato);
	}
	
	public void removeContrato(ContratoHora contrato) {
		contratos.remove(contrato);
	}
	
	public Double salario(int ano, int mes) {
		double soma = salarioBase;
		Calendar calendario = Calendar.getInstance(); // instancia um objeto de calendário 
		for (ContratoHora c : contratos) {
			calendario.setTime(c.getData());   // ajusta o calendario com a data do contrato
			int c_ano = calendario.get(Calendar.YEAR);  // pega o ano do contrato através do calendário
			int c_mes = 1 + calendario.get(Calendar.MONTH); // pega o mês do contrato através do calendário
			// soma 1 no mês porque o Calendar retorna a partir de 0;
			if ((c_ano == ano) && (c_mes == mes)) {   //testa se o ano e o mês do contrato são iguais aos parâmetros passados para o método
				soma += c.valorTotal();    // soma o valor dos contratos do trabalhador que correspondem ao mês e ano passados como parâmetro   
			}
		}
		return soma;
	}
}
