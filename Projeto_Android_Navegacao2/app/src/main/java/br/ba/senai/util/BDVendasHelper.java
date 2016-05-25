package br.ba.senai.util;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDVendasHelper extends SQLiteOpenHelper {

	// Nome do banco de dados
	private static final String NOME_DO_BANCO = "bdvendas";

	private static final int VERSAO_DO_BANCO = 1;

	public BDVendasHelper(Context context)
	{
	   super(context, NOME_DO_BANCO, null, VERSAO_DO_BANCO);
	}

	/**
	* Cria a tabela no banco de dados, caso ela nao exista.
	*/
	@Override
	public void onCreate(SQLiteDatabase db) {
	String sql = "CREATE TABLE cliente (" +
	"id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT" + 
	",nome TEXT NOT NULL" +
	",endereco TEXT NOT NULL" +
	",categoria TEXT NOT NULL" + 
	",data_cadastro INTEGER NOT NULL" + ");";
	db.execSQL(sql);

	}

	/**
	* Atualiza a estrutura da tabela no banco de dados, caso sua versao tenha mudado.
	*/
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { 
		String sql = "DROP TABLE IF EXISTS cliente"; 
		db.execSQL(sql);
	    onCreate(db);
	}
}
