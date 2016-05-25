package br.ba.senai.mapeamento;

import java.io.Serializable;

public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nomecategoria;
	
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNomecategoria() {
		return nomecategoria;
	}
	public void setNomecategoria(String nomecategoria) {
		this.nomecategoria = nomecategoria;
		this.codigo = nomecategoria.substring(0, 4);
	}
	
	
}
