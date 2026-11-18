import java.util.List;

public class Ambiente {
    private String nome;
    private String provedor;
    private String regiao;
    private List<MaquinaVirtual> maquinas;
    private Armazenamento armazenamento;
    private Fila fila;
    private double custoTotalEstimado;

    public Ambiente(String nome, String provedor, String regiao, List<MaquinaVirtual> maquinas,
                    Armazenamento armazenamento, Fila fila, double custoTotalEstimado) {
        this.nome = nome;
        this.provedor = provedor;
        this.regiao = regiao;
        this.maquinas = maquinas;
        this.armazenamento = armazenamento;
        this.fila = fila;
        this.custoTotalEstimado = custoTotalEstimado;
    }

    public void imprimirResumo() {
        System.out.println("\nAmbiente: " + nome);
        System.out.println("Provedor: " + provedor);
        System.out.println("Regiao: " + regiao);
        System.out.print("Maquinas: ");
        for (int i = 0; i < maquinas.size(); i++) {
            System.out.print(maquinas.get(i).getId());
            if (i < maquinas.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println("Armazenamento: " + armazenamento.getId());
        System.out.println("Fila: " + fila.getId());
        System.out.printf("Custo Mensal Estimado: R$ %.2f\n", custoTotalEstimado);
    }

    public double getCustoTotalEstimado() {
        return custoTotalEstimado;
    }
}
