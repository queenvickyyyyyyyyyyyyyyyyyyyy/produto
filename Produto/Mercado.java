public class Mercado {
    private Produto[] produtos = new Produto[20];
    private int contador = 0;

    // Adiciona um produto (se ainda houver espaço)
    public boolean adicionarProduto(Produto p) {
        if (contador < produtos.length) {
            produtos[contador] = p;
            contador++;
            return true;
        } else {
            System.out.println("Mercado cheio! Não é possível adicionar mais produtos.");
            return false;
        }
    }

    // Pesquisa produto pelo nome
    public Produto pesquisarProduto(String nome) {
        for (int i = 0; i < contador; i++) {
            if (produtos[i].getNome().equalsIgnoreCase(nome)) {
                return produtos[i];
            }
        }
        return null; // não encontrado
    }

    // Exclui produto pelo nome
    public boolean excluirProduto(String nome) {
        for (int i = 0; i < contador; i++) {
            if (produtos[i].getNome().equalsIgnoreCase(nome)) {
                // Desloca os produtos
                for (int j = i; j < contador - 1; j++) {
                    produtos[j] = produtos[j + 1];
                }
                produtos[contador - 1] = null;
                contador--;
                return true;
            }
        }
        return false; // não encontrado
    }

    // Mostra todos os produtos
    public void listarProdutos() {
        System.out.println("Produtos no mercado:");
        for (int i = 0; i < contador; i++) {
            System.out.println(produtos[i]);
        }
    }
}
