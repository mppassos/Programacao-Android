package br.com.wgbn.pm_20160523_verify_connection;

import android.os.Parcel;
import android.os.Parcelable;

public class Livro implements Parcelable {
    public String titulo;
    public String categoria;
    public String autor;
    public int ano;
    public int paginas;
    public String capa;

    public Livro() { }

    public Livro(int ano, String autor, String capa, String categoria, int paginas, String titulo) {
        this.ano = ano;
        this.autor = autor;
        this.capa = capa;
        this.categoria = categoria;
        this.paginas = paginas;
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return titulo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.titulo);
        dest.writeString(this.categoria);
        dest.writeString(this.autor);
        dest.writeInt(this.ano);
        dest.writeInt(this.paginas);
        dest.writeString(this.capa);
    }

    protected Livro(Parcel in) {
        this.titulo = in.readString();
        this.categoria = in.readString();
        this.autor = in.readString();
        this.ano = in.readInt();
        this.paginas = in.readInt();
        this.capa = in.readString();
    }

    public static final Parcelable.Creator<Livro> CREATOR = new Parcelable.Creator<Livro>() {
        @Override
        public Livro createFromParcel(Parcel source) {
            return new Livro(source);
        }

        @Override
        public Livro[] newArray(int size) {
            return new Livro[size];
        }
    };
}
