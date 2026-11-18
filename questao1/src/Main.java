public class Main {
    public static void main(String[] args) {
        System.out.println("--- Provisionamento de Ambientes ---");

        ProvedorNuvemFactory aws = new AwsFactory();
        ProvedorNuvemFactory azure = new AzureFactory();

        MontadorAmbiente montadorAws = new MontadorAmbiente(aws);
        MontadorAmbiente montadorAzure = new MontadorAmbiente(azure);

        SolicitacaoAmbiente sol1 = new SolicitacaoAmbiente("Ambiente-Dev-Aws", "Aws", 2, 500.0);
        montadorAws.montarAmbiente(sol1);

        SolicitacaoAmbiente sol2 = new SolicitacaoAmbiente("Ambiente-Prod-Aws", "Aws", 3, 1000.0);
        SolicitacaoAmbiente sol3 = new SolicitacaoAmbiente("Ambiente-Hml-Azure", "Azure", 2, 800.0);

        Thread t1 = new Thread(() -> {
            montadorAws.montarAmbiente(sol2);
        });

        Thread t2 = new Thread(() -> {
            montadorAzure.montarAmbiente(sol3);
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        SolicitacaoAmbiente sol4 = new SolicitacaoAmbiente("Ambiente-Grande-Azure", "Azure", 8, 2000.0);
        montadorAzure.montarAmbiente(sol4);

        HistoricoAuditoria.getInstance().imprimirHistorico();
    }
}
