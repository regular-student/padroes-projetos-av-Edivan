public class PainelLeiloeiro implements Interessado {
    private double maiorLance;
    private int totalLances;

    @Override
    public void notificarLance(String nomeLote, Lance lance) {
        this.totalLances++;
        this.maiorLance = lance.getValor();
        System.out.printf("[Painel] Lote: %s | Maior lance: R$ %.2f | Total lances: %d\n",
                nomeLote, maiorLance, totalLances);
    }

    public double getMaiorLance() {
        return maiorLance;
    }

    public int getTotalLances() {
        return totalLances;
    }
}
