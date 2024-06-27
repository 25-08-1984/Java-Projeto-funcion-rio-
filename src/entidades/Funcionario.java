package entidades;

public class Funcionario {
	private int id;
	private String nome;
	private double salario;
	
	public Funcionario() {
		
	}
	
	public Funcionario(int id, String nome, double salario) {
		setid(id);
		setnome(nome);
		setsalario(salario);
	}
	
	public int getid() {
		return id;
	}
	
	public String getnome() {
		return nome;
	}
	
	public double getsalario() {
		return salario;
	}
	
	public void setid(int id) {
		this.id = id;
	}
	
	public void setnome(String nome) {
		this.nome = nome;
	}
	
	public void setsalario(double salario) {
		this.salario = salario;
	}
	
	public void alteraSalario(double valor) {
		salario = salario + salario*(valor/100.0);
	}
	
	public String toString() {
		return "Funcionário : "
				+ nome
				+  " Número: "
				+ id
				+ " Salário: "
				+ String.format(" %.2f",salario) ;
	}
}
