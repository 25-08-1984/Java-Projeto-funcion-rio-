package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;
import entidades.Funcionario;

public class Progarma {

	public static void main(String[] args) {
		Locale ptBR = Locale.forLanguageTag("pt-Br");
		Locale.setDefault(ptBR);
		Scanner sc = new Scanner(System.in);
		
	List<Funcionario> lista = new ArrayList<>();
		
		// PART 1 - LENDO OS DADOS DO FUNCIONARIO:
		
		System.out.print("Quantos funcionários você deseja registrar? ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println();
			System.out.println("Funcionário #" + i + ": ");

			System.out.print("Id: ");
			int id = sc.nextInt();
			
			while (existeId(lista, id)) {
				System.out.print("Id digitado Existente. Digite novamente: ");
				id = sc.nextInt();
			}
			
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salario: ");
			double salario = sc.nextDouble();
			
			lista.add(new Funcionario(id, nome, salario));
		}

		// PART 2 - ALTERANDO O SALARIO DO FUNCIONARIO:
		
		System.out.println();
		System.out.print("Entre com o Id do funcionário para aumentar o Salário: ");
		int id = sc.nextInt();
		Funcionario emp = lista.stream().filter(x -> x.getid() == id).findFirst().orElse(null);
		if (emp == null) {
			System.out.println("Este Id não Existe!");
		}
		else {
			System.out.print("Entre com a porcentagem: ");
			double porcentagem = sc.nextDouble();
			emp.alteraSalario(porcentagem);
		}
		
		// PART 3 - LISTA DOS FUNCIONARIOS:
		
		System.out.println();
		System.out.println("Lista dos Funcionários:");
		
		for (Funcionario obj : lista) {
			System.out.println(obj);
		}
				
		sc.close(); 
	}
	
	public static boolean existeId(List<Funcionario> lista, int id) {
		Funcionario emp = lista.stream().filter(x -> x.getid() == id).findFirst().orElse(null);
		return emp != null;

	}

}
