public class Main {
    public static void main(String[] args) {
        System.out.println("--- Leiloes Online ---");

        PainelLeiloeiro painel = new PainelLeiloeiro();
        AuditorLeilao auditor = new AuditorLeilao();

        Participante p1 = new Participante("1", "Joao");
        Participante p2 = new Participante("2", "Maria");
        Participante p3 = new Participante("3", "Pedro");

        Lote lote1 = new Lote(1, "Quadro antigo", "Arte", 1000.0, 1500.0, new ComissaoArte());
        Lote lote2 = new Lote(2, "Notebook gamer", "Eletrônicos", 2000.0, 3500.0, new ComissaoEletronicos());

        lote1.adicionarInteressado(painel);
        lote1.adicionarInteressado(auditor);
        lote1.adicionarInteressado(p1);
        lote1.adicionarInteressado(p2);
        lote1.adicionarInteressado(p3);

        lote2.adicionarInteressado(painel);
        lote2.adicionarInteressado(auditor);
        lote2.adicionarInteressado(p1);
        lote2.adicionarInteressado(p2);

        System.out.println("\n--- Lote 1: Arte ---");
        lote1.receberLance(new Lance(1100.0, p1));
        lote1.receberLance(new Lance(1120.0, p2));
        lote1.receberLance(new Lance(1300.0, p2));

        lote1.removerInteressado(p3);
        lote1.setRegraComissao(new ComissaoEletronicos());
        lote1.receberLance(new Lance(1600.0, p1));

        boolean vendido1 = lote1.encerrar();
        if (vendido1) {
            double comissao = lote1.calcularComissao();
            AcertoVendedor.imprimirAcerto(lote1.getNome(), lote1.getValorAtual(), comissao);

            ItemFatura fatura = new VendaLote(lote1.getNome(), lote1.getValorAtual());
            fatura = new SeguroTransporteDecorator(fatura, lote1.getValorAtual());
            fatura = new CertificadoAutenticidadeDecorator(fatura);
            fatura = new EmbalagemEspecialDecorator(fatura);
            fatura = new EmbalagemEspecialDecorator(fatura);
            fatura = new EntregaExpressaDecorator(fatura);
            fatura.imprimirFatura();
        }

        System.out.println("\n--- Lote 2: Eletronicos ---");
        lote2.receberLance(new Lance(2200.0, p1));
        lote2.encerrar();

        auditor.imprimirAuditoria();
    }
}
