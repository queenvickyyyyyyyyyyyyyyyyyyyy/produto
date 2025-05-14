import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Mercado mercado = new Mercado();

        System.out.print("Quantos produtos deseja adicionar? ");
        int qtd = in.nextInt();
        in.nextLine();

        for (int i = 0; i < qtd; i++) {
            Produto p = new Produto();

            System.out.print("Digite o nome do produto " + (i + 1) + ": ");
            p.setNome(in.nextLine());

            System.out.print("Digite o valor do produto " + (i + 1) + ": R$");
            p.setValor(in.nextDouble());
            in.nextLine();

            mercado.adicionarProduto(p);
        }

        System.out.println();
        mercado.listarProdutos();

        System.out.print("\nPesquisar produto pelo nome: ");
        String nomeBusca = in.nextLine();
        Produto encontrado = mercado.pesquisarProduto(nomeBusca);
        if (encontrado != null) {
            System.out.println("Produto encontrado: " + encontrado);
        } else {
            System.out.println("Produto não encontrado.");
        }

        System.out.print("\nDeseja excluir um produto? Digite o nome ou deixe em branco para pular: ");
        String nomeExcluir = in.nextLine();
        if (!nomeExcluir.isEmpty()) {
            boolean removido = mercado.excluirProduto(nomeExcluir);
            System.out.println(removido ? "Produto removido com sucesso!" : "Produto não encontrado.");
        }

        System.out.println("\nProdutos após exclusão (se houve):");
        mercado.listarProdutos();

        in.close();
    }
}
