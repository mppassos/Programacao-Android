package br.ba.senai.mapeamento;

import java.io.Serializable;
import java.util.Calendar;

public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id; 
	private String nome;
	private String endereco;
	private Categoria categoria;
	private Calendar data_cadastro;

	public Cliente() {
		categoria = new Categoria();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Calendar getData_cadastro() {
		return data_cadastro;
	}
	public void setData_cadastro(Calendar data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
