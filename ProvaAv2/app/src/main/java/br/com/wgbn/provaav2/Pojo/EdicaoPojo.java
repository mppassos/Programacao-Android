package br.com.wgbn.provaav2.Pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class EdicaoPojo implements Parcelable {
    private String titulo;
    private String subtitulo;
    private String capa;
    private String editora;
    private int numero;
    private int ano;

    public EdicaoPojo() { }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.titulo);
        dest.writeString(this.subtitulo);
        dest.writeString(this.capa);
        dest.writeString(this.editora);
        dest.writeInt(this.numero);
        dest.writeInt(this.ano);
    }

    protected EdicaoPojo(Parcel in) {
        this.titulo = in.readString();
        this.subtitulo = in.readString();
        this.capa = in.readString();
        this.editora = in.readString();
        this.numero = in.readInt();
        this.ano = in.readInt();
    }

    public static final Parcelable.Creator<EdicaoPojo> CREATOR = new Parcelable.Creator<EdicaoPojo>() {
        @Override
        public EdicaoPojo createFromParcel(Parcel source) {
            return new EdicaoPojo(source);
        }

        @Override
        public EdicaoPojo[] newArray(int size) {
            return new EdicaoPojo[size];
        }
    };
}
