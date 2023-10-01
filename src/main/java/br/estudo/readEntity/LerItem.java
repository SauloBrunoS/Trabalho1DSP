package br.estudo.readEntity;

import java.util.Scanner;

import br.estudo.model.Item;

public class LerItem {
    public Item lerItem() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Novo Item de Compras");
        System.out.println("Nome: ");
        String nome = scan.nextLine();

        System.out.println("Descrição: ");
        String descricao = scan.nextLine();

        System.out.println(
                "Categoria:\n [Roupas, Eletronicos, Livros, Alimentos, Jogos, Brinquedos, Beleza, Moveis, Esportes, Outros] ");
        String categoria = scan.nextLine();
        Item.Categoria categoria_item = Item.Categoria.valueOf(categoria.toUpperCase());

        System.out.println("Quantidade: ");
        int quantidade = scan.nextInt();

        System.out.println("Valor: ");
        Number valor = scan.nextDouble();

        Item item = new Item(nome, descricao, categoria_item, quantidade, valor);
        return item;
    }

    public String[] dadosItem(Item item) {
        String[] dados = {
                String.valueOf(item.getId()),
                item.getNome(),
                item.getDescricao_item(),
                String.valueOf(item.getCategoria_item()),
                String.valueOf(item.getQuantidade()),
                String.valueOf(item.getValor()),
        };
        return dados;
    }
}
