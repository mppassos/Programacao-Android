package br.com.wgbn.pm_20160328_trabalho_prova.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

@Table(name = "clientes")
public class ClientePojo extends Model implements Parcelable {

    @Column(index = true)
    private String  cpf;

    @Column
    private String  nome;

    @Column
    private String  endereco;

    @Column
    private String  telefone;

    @Column
    private char    sexo;

    @Column
    private boolean ativo;

    public ClientePojo(){
        super();
    }

    public ClientePojo(boolean ativo, String cpf, String endereco, String nome, char sexo, String telefone) {
        super();
        this.ativo = ativo;
        this.cpf = cpf;
        this.endereco = endereco;
        this.nome = nome;
        this.sexo = sexo;
        this.telefone = telefone;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.cpf);
        dest.writeString(this.nome);
        dest.writeString(this.endereco);
        dest.writeString(this.telefone);
        dest.writeInt(sexo);
        dest.writeByte(ativo ? (byte) 1 : (byte) 0);
    }

    protected ClientePojo(Parcel in) {
        this.cpf = in.readString();
        this.nome = in.readString();
        this.endereco = in.readString();
        this.telefone = in.readString();
        this.sexo = (char) in.readInt();
        this.ativo = in.readByte() != 0;
    }

    public static final Parcelable.Creator<ClientePojo> CREATOR = new Parcelable.Creator<ClientePojo>() {
        public ClientePojo createFromParcel(Parcel source) {
            return new ClientePojo(source);
        }

        public ClientePojo[] newArray(int size) {
            return new ClientePojo[size];
        }
    };

    public static List<ClientePojo> getAll() {
        return new Select()
                .from(ClientePojo.class)
                .orderBy("nome ASC")
                .execute();
    }

    public static ClientePojo getByCpf(String cpf) {
        return (ClientePojo) new Select()
                .from(ClientePojo.class)
                .where("cpf = ?", cpf)
                .executeSingle();
    }
}
