package br.com.wgbn.pm_20160310_mapas_layout.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Walter Gandarella on 10/03/16.
 */
public class DonoPojo implements Parcelable {

    private long id;
    private String nome;
    private String celular;
    private boolean whatsapp;
    private boolean telefone;

    public DonoPojo() {}

    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
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
    public boolean isTelefone() {
        return telefone;
    }
    public void setTelefone(boolean telefone) {
        this.telefone = telefone;
    }
    public boolean isWhatsapp() {
        return whatsapp;
    }
    public void setWhatsapp(boolean whatsapp) {
        this.whatsapp = whatsapp;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.nome);
        dest.writeString(this.celular);
        dest.writeByte(whatsapp ? (byte) 1 : (byte) 0);
        dest.writeByte(telefone ? (byte) 1 : (byte) 0);
    }

    protected DonoPojo(Parcel in) {
        this.id = in.readLong();
        this.nome = in.readString();
        this.celular = in.readString();
        this.whatsapp = in.readByte() != 0;
        this.telefone = in.readByte() != 0;
    }

    public static final Parcelable.Creator<DonoPojo> CREATOR = new Parcelable.Creator<DonoPojo>() {
        public DonoPojo createFromParcel(Parcel source) {
            return new DonoPojo(source);
        }

        public DonoPojo[] newArray(int size) {
            return new DonoPojo[size];
        }
    };
}
