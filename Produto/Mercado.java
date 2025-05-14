public class Mercado {
    private Produto[] produtos = new Produto[20];
    private int contador = 0;

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

    public Produto pesquisarProduto(String nome) {
        for (int i = 0; i < contador; i++) {
            if (produtos[i].getNome().equalsIgnoreCase(nome)) {
                return produtos[i];
            }
        }
        return null;
    }

 
    public boolean excluirProduto(String nome) {
        for (int i = 0; i < contador; i++) {
            if (produtos[i].getNome().equalsIgnoreCase(nome)) {
                for (int j = i; j < contador - 1; j++) {
                    produtos[j] = produtos[j + 1];
                }
                produtos[contador - 1] = null;
                contador--;
                return true;
            }
        }
        return false;

    public void listarProdutos() {
        System.out.println("Produtos no mercado:");
        for (int i = 0; i < contador; i++) {
            System.out.println(produtos[i]);
        }
    }
}
