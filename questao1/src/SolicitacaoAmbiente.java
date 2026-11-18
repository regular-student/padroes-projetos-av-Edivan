public class SolicitacaoAmbiente {
    private String nomeAmbiente;
    private String provedor;
    private int qtdMaquinas;
    private double gbArmazenamento;

    public SolicitacaoAmbiente(String nomeAmbiente, String provedor, int qtdMaquinas, double gbArmazenamento) {
        this.nomeAmbiente = nomeAmbiente;
        this.provedor = provedor;
        this.qtdMaquinas = qtdMaquinas;
        this.gbArmazenamento = gbArmazenamento;
    }

    public String getNomeAmbiente() {
        return nomeAmbiente;
    }

    public String getProvedor() {
        return provedor;
    }

    public int getQtdMaquinas() {
        return qtdMaquinas;
    }

    public double getGbArmazenamento() {
        return gbArmazenamento;
    }
}
