package br.ba.senai.dao;

import java.util.ArrayList;
import java.util.List;

import br.ba.senai.mapeamento.Cliente;
import br.ba.senai.util.BDVendasHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ClienteDAO {

    BDVendasHelper bdvendas;
    private Context context;

    public ClienteDAO(Context context) {
        bdvendas = new BDVendasHelper(context);
        this.context = context;
    }

    /**
     * Adiciona cliente no banco de dados.
     */
    private void adicionar(Cliente cliente) {
        // Encapsula no objeto do tipo ContentValues os valores a serem persistidos no banco de dados
        ContentValues values = new ContentValues();
        values.put("nome", cliente.getNome());
        values.put("data_cadastro", System.currentTimeMillis());
        values.put("endereco", cliente.getEndereco());
        values.put("categoria", cliente.getCategoria().getNomecategoria());
        // Instancia uma conex�o com o banco de dados, em modo de grava��o
        SQLiteDatabase db = bdvendas.getWritableDatabase();

        // Insere o registro no banco de dados
        long id = db.insert("cliente", null, values);
        cliente.setId(id);

        // Encerra a conex�o com o banco de dados
        db.close();
    }

    /**
     * Lista todos os registros da tabela �cliente�
     */
    public List<Cliente> listaTodos(String filtro) {

        // Cria um List para guardar os objetos consultados no banco de dados
        List<Cliente> clientes = new ArrayList<Cliente>();

        // Instancia uma nova conex�o com o banco de dados em modo leitura
        SQLiteDatabase db = bdvendas.getReadableDatabase();

        String sql = "Select * from cliente";
        String[] argumentos = null;
        if (filtro != null) {
            sql += " where nome like ?";
            argumentos = new String[]{filtro};
        }
        sql += " order by nome";
        // Executa a consulta no banco de dados
        Cursor c = db.rawQuery(sql, argumentos);

        /**
         Percorre o Cursor, injetando os dados consultados em um objeto
         do tipo ObjetoEmprestado e adicionando-os na List
         */
        try {
            while (c.moveToNext()) {

                Cliente cliente = new Cliente();
                cliente.setId(c.getLong(c.getColumnIndex("id")));
                cliente.setNome(c.getString(c.getColumnIndex("nome")));
                cliente.setEndereco(c.getString(c.getColumnIndex("endereco")));
                cliente.getCategoria().setNomecategoria(c.getString(c.getColumnIndex("categoria")));
                clientes.add(cliente);
            }

        } finally {


        }

        // Encerra o Cursor
        c.close();

        // Encerra a conex�o com o banco de dados
        db.close();

        // Retorna uma lista com os objetos consultados
        return clientes;
    }

    /**
     * Alterar o registro no banco de dados.
     */
    private void atualizar(Cliente cliente) {
        // Encapsula no objeto do tipo ContentValues os valores a serem atualizados no banco de dados
        ContentValues values = new ContentValues();

        values.put("nome", cliente.getNome());
        values.put("endereco", cliente.getEndereco());
        values.put("categoria", cliente.getCategoria().getNomecategoria());

        // Instancia uma conex�o com o banco de dados, em modo de grava��o
        SQLiteDatabase db = bdvendas.getWritableDatabase();

        // Atualiza o registro no banco de dados
        db.update("cliente", values, "id=?", new String[]{cliente.getId().toString()});

        // Encerra a conex�o com o banco de dados
        db.close();
    }


    public void salvar(Cliente cliente) {

        if (cliente.getId() == null) {
            adicionar(cliente);

        } else {
            atualizar(cliente);
        }
    }

    /**
     * Remove um registro no banco de dados.
     */
    public void remover(Cliente cliente) {
        // Instancia uma conex�o com o banco de dados, em modo de grava��o
        SQLiteDatabase db = bdvendas.getWritableDatabase();

        // Remove o registro no banco de dados
        db.delete("cliente", "id=?", new String[]{cliente.getId().toString()});

        // Encerra a conex�o com o banco de dados
        db.close();
    }


}
