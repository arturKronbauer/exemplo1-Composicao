package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.ContratoHora;
import entidades.Departamento;
import entidades.Trabalhador;
import entidades.enumeradas.NivelTrabalhador;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  // objeto para formatar a data para dia/mês/ano
		System.out.print("Insira o nome do departamento: ");
		String nomeDepartamento = sc.nextLine();
		System.out.println("Insira os dados do trabalhador:");
		System.out.print("Nome: ");
		String nomeTrabalhador = sc.nextLine();
		System.out.print("Nível: ");
		String nivel = sc.nextLine();
		System.out.print("Salário base: ");
		double salarioBase = sc.nextDouble();
		Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, NivelTrabalhador.valueOf(nivel), salarioBase, new Departamento(nomeDepartamento));

		System.out.print("Quantos contratos para este trabalhador? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Insira os dados do contrato #" + i);
			System.out.print("Data (DD/MM/YYYY): ");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valorHora = sc.nextDouble();
			System.out.print("Duração (horas): ");
			int horas = sc.nextInt();
			ContratoHora contrato = new ContratoHora(dataContrato, valorHora, horas);
			trabalhador.addContrato(contrato);
		}

		System.out.println();
		System.out.print("Digite o mês e o ano para calcular o rendimento (MM/AAAA): ");
		String mesAno = sc.next();
		int mes = Integer.parseInt(mesAno.substring(0, 2));   // pega os dois primeiros caracteres da string 
		int ano = Integer.parseInt(mesAno.substring(3));   //pega os caracteres da string a partir do terceiro até o final  
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome()); // pega o nome do departamento saindo da classe Trabalhador e chegando em Departamento
		System.out.println("Renda de " + mesAno + ": " + String.format("%.2f", trabalhador.salario(ano, mes)));

		sc.close();

	}

}
