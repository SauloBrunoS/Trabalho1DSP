package br.estudo.model;

public class Item {
    private int id;
    private String nome;
    private String descricao_item;
    private Categoria categoria_item;
    private int quantidade;
    private Number valor;
    private static int nextId = 0;

    public Item() {
        this.id = generateUniqueId();
    }

    public Item(String nome, String descricao_item, Categoria categoria_item, int quantidade, Number valor) {
        this.id = generateUniqueId();
        this.nome = nome;
        this.descricao_item = descricao_item;
        this.categoria_item = categoria_item;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    private int generateUniqueId() {
        return nextId++;
    }

    public Number total() {
        return this.quantidade * this.valor.doubleValue();
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", nome=" + nome + ", descricao_item=" + descricao_item + ", categoria_item="
                + categoria_item + ", quantidade=" + quantidade + ", valor=" + valor + "]";
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

    public String getDescricao_item() {
        return descricao_item;
    }

    public void setDescricao_item(String descricao_item) {
        this.descricao_item = descricao_item;
    }

    public Categoria getCategoria_item() {
        return categoria_item;
    }

    public void setCategoria_item(Categoria categoria_item) {
        this.categoria_item = categoria_item;
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
}
