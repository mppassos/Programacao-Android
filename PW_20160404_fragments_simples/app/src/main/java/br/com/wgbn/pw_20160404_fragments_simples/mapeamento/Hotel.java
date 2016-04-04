package br.com.wgbn.pw_20160404_fragments_simples.mapeamento;

import android.os.Parcel;
import android.os.Parcelable;

public class Hotel implements Parcelable {
    private String nome;
    private String endereco;
    private float estrelas;

    public Hotel(){}

    public Hotel(String nome, String endereco, float estrelas) {
        this.endereco = endereco;
        this.estrelas = estrelas;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nome);
        dest.writeString(this.endereco);
        dest.writeFloat(this.estrelas);
    }

    protected Hotel(Parcel in) {
        this.nome = in.readString();
        this.endereco = in.readString();
        this.estrelas = in.readFloat();
    }

    public static final Parcelable.Creator<Hotel> CREATOR = new Parcelable.Creator<Hotel>() {
        @Override
        public Hotel createFromParcel(Parcel source) {
            return new Hotel(source);
        }

        @Override
        public Hotel[] newArray(int size) {
            return new Hotel[size];
        }
    };
}
