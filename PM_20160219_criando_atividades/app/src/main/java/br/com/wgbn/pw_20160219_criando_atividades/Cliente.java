package br.com.wgbn.pw_20160219_criando_atividades;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Walter on 29/02/2016.
 */
public class Cliente implements Parcelable {
    private String nome;
    private String idade;

    public Cliente(String nome, String idade) {
        this.nome = nome;
        this.idade = idade;
    }

    private Cliente(Parcel cliente){
        nome = cliente.readString();
        idade = cliente.readString();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public  static final Parcelable.Creator<Cliente> CREATOR = new Parcelable.Creator<Cliente>(){
        public Cliente createFromParcel(Parcel in){
            return new Cliente(in);
        }
        public Cliente[] newArray(int size){
            return new Cliente[size];
        }
    };

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(idade);
    }
}
