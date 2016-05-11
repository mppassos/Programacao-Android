package br.com.wgbn.provaav2.Services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.com.wgbn.provaav2.Pojo.EdicaoPojo;

public class EdicaoService {
    private static EdicaoService ourInstance;
    private List<EdicaoPojo> edicoes;

    public static EdicaoService getInstance() {
        if (ourInstance == null)
            ourInstance = new EdicaoService();
        return ourInstance;
    }

    private EdicaoService() {
        this.edicoes = new ArrayList<EdicaoPojo>();
    }

    public List<EdicaoPojo> getEdicoes(){
        return this.edicoes;
    }

    public void mock(){
        EdicaoPojo e = new EdicaoPojo();
        e.setAno(1999);
        e.setCapa("https://upload.wikimedia.org/wikipedia/en/8/82/Spiderman1cover.jpg");
        e.setEditora("Marvel");
        e.setNumero(1);
        e.setTitulo("Spider-man");
        e.setSubtitulo("\"Torment\" part one of five");
        this.edicoes.add(e);

        e = new EdicaoPojo();
        e.setAno(1995);
        e.setCapa("http://media.comicbook.com/uploads1/2015/02/amazing-spider-man-300-cover-121155.jpg");
        e.setEditora("Marvel");
        e.setNumero(300);
        e.setTitulo("The Amazing Spider-man");
        e.setSubtitulo("Special 25th aniversary issue");
        this.edicoes.add(e);
    }
}
