package br.com.wgbn.pm_20160310_mapas_layout.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Walter Gandarella on 10/03/16.
 */
public class VagaPojo implements Parcelable {

    public static final int CARTAO = 1;
    public static final int DINHEIRO = 2;
    public static final int PAYPAL = 3;

    private long id;
    private String foto;
    private int tempo;
    private float valor;
    private boolean livre;
    private int tipoPagamento;
    private DonoPojo dono;
    private LocalPojo local;

    public DonoPojo getDono() {
        return dono;
    }
    public void setDono(DonoPojo dono) {
        this.dono = dono;
    }
    public LocalPojo getLocal() {
        return local;
    }
    public void setLocal(LocalPojo local) {
        this.local = local;
    }
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public boolean isLivre() {
        return livre;
    }
    public void setLivre(boolean livre) {
        this.livre = livre;
    }
    public int getTempo() {
        return tempo;
    }
    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
    public int getTipoPagamento() {
        return tipoPagamento;
    }
    public void setTipoPagamento(int tipo_pagamento) {
        this.tipoPagamento = tipo_pagamento;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }

    public VagaPojo() {}


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.foto);
        dest.writeInt(this.tempo);
        dest.writeFloat(this.valor);
        dest.writeByte(livre ? (byte) 1 : (byte) 0);
        dest.writeInt(this.tipoPagamento);
        dest.writeParcelable(this.dono, 0);
        dest.writeParcelable(this.local, 0);
    }

    protected VagaPojo(Parcel in) {
        this.id = in.readLong();
        this.foto = in.readString();
        this.tempo = in.readInt();
        this.valor = in.readFloat();
        this.livre = in.readByte() != 0;
        this.tipoPagamento = in.readInt();
        this.dono = in.readParcelable(DonoPojo.class.getClassLoader());
        this.local = in.readParcelable(LocalPojo.class.getClassLoader());
    }

    public static final Creator<VagaPojo> CREATOR = new Creator<VagaPojo>() {
        public VagaPojo createFromParcel(Parcel source) {
            return new VagaPojo(source);
        }

        public VagaPojo[] newArray(int size) {
            return new VagaPojo[size];
        }
    };
}
