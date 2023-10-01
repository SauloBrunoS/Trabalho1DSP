package br.estudo.model;

import java.util.List;

import br.estudo.functions.ConverterCSVtoJSONeXML;

public class Item {
    private int id;
    private String nome;
    private String descricaoItem;
    private Categoria categoriaItem;
    private int quantidade;
    private Number valor;

    public Item() {
        this.id = generateUniqueId();
    }

    public Item(int id, String nome, String descricao_item, Categoria categoria_item, int quantidade, Number valor) {
        this.id = id;
        this.nome = nome;
        this.descricaoItem = descricao_item;
        this.categoriaItem = categoria_item;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Item(String nome, String descricao_item, Categoria categoria_item, int quantidade, Number valor) {
        this.id = generateUniqueId();
        this.nome = nome;
        this.descricaoItem = descricao_item;
        this.categoriaItem = categoria_item;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    private int generateUniqueId() {
        try {
            List<Item> items = ConverterCSVtoJSONeXML.converterParaListaItens(ConverterCSVtoJSONeXML.lerCSVItem());
            int nextId = 0;
            if (!items.isEmpty()) {
                nextId = items.get(items.size() - 1).getId() + 1;
            }
            System.out.println(nextId);
            return nextId;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Number total() {
        return this.quantidade * this.valor.doubleValue();
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", nome=" + nome + ", descricao_item=" + descricaoItem + ", categoria_item="
                + categoriaItem + ", quantidade=" + quantidade + ", valor=" + valor + "]";
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

    public String getDescricaoItem() {
        return descricaoItem;
    }

    public void setDescricaoItem(String descricaoItem) {
        this.descricaoItem = descricaoItem;
    }

    public Categoria getCategoriaItem() {
        return this.categoriaItem;
    }

    public void setCategoriaItem(Categoria categoriaItem) {
        this.categoriaItem = categoriaItem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Number getValor() {
        return valor;
    }

    public void setValor(Number valor) {
        this.valor = valor;
    }

    public enum Categoria {
        ROUPAS("Roupas"),
        ELETRONICOS("Eletrônicos"),
        LIVROS("Livros"),
        ALIMENTOS("Alimentos"),
        JOGOS("Jogos"),
        BRINQUEDOS("Brinquedos"),
        BELEZA("Beleza"),
        MOVEIS("Móveis"),
        ESPORTES("Esportes"),
        OUTROS("Outros");

        private String descricao;

        Categoria(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }
}
