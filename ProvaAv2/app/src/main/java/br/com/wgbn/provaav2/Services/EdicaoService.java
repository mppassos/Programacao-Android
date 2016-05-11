package br.com.wgbn.provaav2.Services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.com.wgbn.provaav2.Models.EdicaoModel;
import br.com.wgbn.provaav2.Pojo.EdicaoPojo;

public class EdicaoService {
    private static EdicaoService ourInstance;
    private List<EdicaoModel> edicoes;

    public static EdicaoService getInstance() {
        if (ourInstance == null)
            ourInstance = new EdicaoService();
        return ourInstance;
    }

    private EdicaoService() {
        this.edicoes = new ArrayList<EdicaoModel>();
    }

    public List<EdicaoModel> getEdicoes(){
        //return this.edicoes;
        return EdicaoModel.getAll();
    }

    public void add(EdicaoModel e){
        this.edicoes.add(e);
        e.save();
    }
}
