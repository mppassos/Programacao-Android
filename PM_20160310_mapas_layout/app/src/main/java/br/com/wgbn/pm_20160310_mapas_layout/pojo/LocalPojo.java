package br.com.wgbn.pm_20160310_mapas_layout.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Walter Gandarella on 10/03/16.
 */
public class LocalPojo implements Parcelable {

    private long id;
    private String endereco;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private double latitude;
    private double longitude;

    public LocalPojo(){}

    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public String getLatLon(){
        return String.valueOf(latitude)+","+String.valueOf(longitude);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.endereco);
        dest.writeString(this.complemento);
        dest.writeString(this.bairro);
        dest.writeString(this.cidade);
        dest.writeString(this.estado);
        dest.writeDouble(this.latitude);
        dest.writeDouble(this.longitude);
    }

    protected LocalPojo(Parcel in) {
        this.id = in.readLong();
        this.endereco = in.readString();
        this.complemento = in.readString();
        this.bairro = in.readString();
        this.cidade = in.readString();
        this.estado = in.readString();
        this.latitude = in.readDouble();
        this.longitude = in.readDouble();
    }

    public static final Creator<LocalPojo> CREATOR = new Creator<LocalPojo>() {
        public LocalPojo createFromParcel(Parcel source) {
            return new LocalPojo(source);
        }

        public LocalPojo[] newArray(int size) {
            return new LocalPojo[size];
        }
    };
}
