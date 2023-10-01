package br.estudo.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.dataformat.xml.annotation.*;

@JacksonXmlRootElement(localName = "listasCompras")
public class ListaItens {
    @JacksonXmlElementWrapper(localName = "listaCompras")
    @JacksonXmlProperty(localName = "itemLista")
    private List<Item> listaItens;

    public ListaItens(List<Item> listaItens) {
        this.listaItens = listaItens;
    }

    public ListaItens() {
        this.listaItens = new ArrayList<Item>();
    }

    @Override
    public String toString() {
        return this.listaItens.toString();
    }

    public List<Item> getListaItens() {
        return this.listaItens;
    }

    public void setListaItens(List<Item> listaItens) {
        this.listaItens = listaItens;
    }
}
