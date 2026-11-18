public class AcertoVendedor {
    public static void imprimirAcerto(String nomeLote, double valorVenda, double comissao) {
        double valorLiquido = valorVenda - comissao;
        System.out.println("\n--- Acerto com o Vendedor ---");
        System.out.println("Lote: " + nomeLote);
        System.out.printf("Valor da Venda: R$ %.2f\n", valorVenda);
        System.out.printf("Comissao Cobrada: R$ %.2f\n", comissao);
        System.out.printf("Valor Liquido a Repassar: R$ %.2f\n", valorLiquido);
    }
}
