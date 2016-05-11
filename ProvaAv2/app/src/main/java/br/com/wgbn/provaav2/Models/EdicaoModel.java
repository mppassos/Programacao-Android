package br.com.wgbn.provaav2.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

@Table(name = "edicoes")
public class EdicaoModel extends Model implements Parcelable {
    @Column private String titulo;

    @Column private String subtitulo;

    @Column private String capa;

    @Column private String editora;

    @Column private int numero;

    @Column private int ano;

    public EdicaoModel() { }

    public EdicaoModel(int ano, String capa, String editora, int numero, String subtitulo, String titulo) {
        this.ano = ano;
        this.capa = capa;
        this.editora = editora;
        this.numero = numero;
        this.subtitulo = subtitulo;
        this.titulo = titulo;
    }

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

    protected EdicaoModel(Parcel in) {
        this.titulo = in.readString();
        this.subtitulo = in.readString();
        this.capa = in.readString();
        this.editora = in.readString();
        this.numero = in.readInt();
        this.ano = in.readInt();
    }

    public static final Parcelable.Creator<EdicaoModel> CREATOR = new Parcelable.Creator<EdicaoModel>() {
        @Override
        public EdicaoModel createFromParcel(Parcel source) {
            return new EdicaoModel(source);
        }

        @Override
        public EdicaoModel[] newArray(int size) {
            return new EdicaoModel[size];
        }
    };

    public static List<EdicaoModel> getAll() {
        return new Select()
                .from(EdicaoModel.class)
                .orderBy("titulo ASC")
                .execute();
    }
}
