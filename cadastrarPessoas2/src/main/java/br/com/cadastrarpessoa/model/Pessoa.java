package br.com.cadastrarpessoa.model;

import java.util.Date;

public class Pessoa {

	private long id;
	private String nome;
	private int idade;
	private String sexo;
	private Date dataCadastro = new java.sql.Date(System.currentTimeMillis());
	
	public Pessoa() { }

	public Pessoa(long id, String nome, int idade, String sexo, Date dataCadastro) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.dataCadastro = dataCadastro;
	}
	
	
	
	@Override
	public String toString() {
		return id + " " + nome + " " + idade + " " + sexo + " "
				+ dataCadastro;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}
