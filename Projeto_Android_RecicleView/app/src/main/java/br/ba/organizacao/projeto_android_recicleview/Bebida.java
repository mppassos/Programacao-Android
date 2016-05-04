package br.ba.organizacao.projeto_android_recicleview;

/**
 * Created by andre on 25/04/16.
 */
public class Bebida {
    private String marca;
    private String modelo;

    public Bebida() {
    }

    public Bebida(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
