package br.estudo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.dataformat.xml.annotation.*;

@JacksonXmlRootElement(localName = "lista_itens")
public class ListaItens implements Serializable{
    private int id;
    private String nome;
    List<Item> lista_itens;
    private TipoLista tipoLista;
    private static int nextId = 0;

    public void adicionarItem(Item item) {
        lista_itens.add(item);
    }

    public Item buscarItem(int id) {
        for (Item item : lista_itens) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removerItem(int id) {
        Item item_remove = buscarItem(id);
        if (item_remove != null) {
            lista_itens.remove(item_remove);
        } else {
            System.out.println("Item não encontrado");
        }
    }

    public void removeAll() {
        lista_itens.clear();
    }

    public ListaItens() {
        this.lista_itens = new ArrayList<>();
        this.id = generateUniqueId();
    }

    @Override
    public String toString() {
        return "Lista [id=" + id + ", nome=" + nome + ", lista_itens=" + lista_itens + ", tipoLista=" + tipoLista + "]";
    }

    public ListaItens(String nome, TipoLista tipoLista) {
        this.id = generateUniqueId();
        this.nome = nome;
        this.tipoLista = tipoLista;
    }

    private int generateUniqueId() {
        return nextId++;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    @JacksonXmlElementWrapper(localName = "itens")
    @JacksonXmlProperty(localName = "item")
    public List<Item> getLista_itens() {
        return lista_itens;
    }

    public void setLista_itens(List<Item> lista_itens) {
        this.lista_itens = lista_itens;
    }

    public int quantidadeLista() {
        return lista_itens.size();
    }

    public enum TipoLista {
        SUPERMERCADO("Supermercado"),
        ESCRITORIO("Escritorio"),
        MATERIAIS_CONSTRUCAO("Materias de construcao"),
        DECORACAO("Decoracao"),
        PRESENTES("Presentes"),
        TECNOLOGIA("Tecnologia"),
        OUTROS("Outros");

        private String descricao;

        TipoLista(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }
    }
}
