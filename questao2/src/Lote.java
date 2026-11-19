import java.util.ArrayList;
import java.util.List;

public class Lote {
    private int id;
    private String nome;
    private String categoria;
    private double precoInicial;
    private double precoReserva;
    private boolean aberto;
    private double valorAtual;
    private Lance lanceVencedor;
    private List<Interessado> interessados = new ArrayList<>();
    private RegraComissao regraComissao;

    public Lote(int id, String nome, String categoria, double precoInicial, double precoReserva, RegraComissao regraComissao) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.precoInicial = precoInicial;
        this.precoReserva = precoReserva;
        this.valorAtual = precoInicial;
        this.aberto = true;
        this.regraComissao = regraComissao;
    }

    public void adicionarInteressado(Interessado interessado) {
        interessados.add(interessado);
    }

    public void removerInteressado(Interessado interessado) {
        interessados.remove(interessado);
        if (interessado instanceof Participante) {
            System.out.println("[Info] " + ((Participante) interessado).getNome() + " deixou de acompanhar o lote '" + nome + "'.");
        }
    }

    public boolean receberLance(Lance lance) {
        if (!aberto) {
            System.out.printf("[Recusado] Lote '%s' ja esta encerrado.\n", nome);
            return false;
        }

        double valorMinimo = valorAtual * 1.05;
        if (lanceVencedor == null) {
            if (lance.getValor() < precoInicial) {
                System.out.printf("[Recusado] Lance de R$ %.2f de %s recusado: menor que o preco inicial de R$ %.2f\n",
                        lance.getValor(), lance.getParticipante().getNome(), precoInicial);
                return false;
            }
        } else {
            if (lance.getValor() < valorMinimo) {
                System.out.printf("[Recusado] Lance de R$ %.2f de %s recusado: deve ser pelo menos 5%% maior que o atual de R$ %.2f (minimo: R$ %.2f)\n",
                        lance.getValor(), lance.getParticipante().getNome(), valorAtual, valorMinimo);
                return false;
            }
        }

        this.lanceVencedor = lance;
        this.valorAtual = lance.getValor();
        System.out.printf("\n[Aceito] Lance de R$ %.2f aceito para o lote '%s' (%s)\n",
                lance.getValor(), nome, lance.getParticipante().getNome());

        notificarInteressados(lance);
        return true;
    }

    private void notificarInteressados(Lance lance) {
        for (Interessado i : interessados) {
            if (i instanceof Participante) {
                Participante p = (Participante) i;
                if (p.getId().equals(lance.getParticipante().getId())) {
                    continue;
                }
            }
            i.notificarLance(nome, lance);
        }
    }

    public void setRegraComissao(RegraComissao regraComissao) {
        this.regraComissao = regraComissao;
        System.out.println("[Campanha] Regra de comissao do lote '" + nome + "' alterada para: " + regraComissao.getNomeRegra());
    }

    public double calcularComissao() {
        return regraComissao.calcularComissao(valorAtual);
    }

    public boolean encerrar() {
        this.aberto = false;
        System.out.println("\n--- Encerramento do Lote: " + nome + " ---");
        if (lanceVencedor != null && valorAtual >= precoReserva) {
            System.out.printf("Lote VENDIDO para %s por R$ %.2f (Preco de Reserva: R$ %.2f)\n",
                    lanceVencedor.getParticipante().getNome(), valorAtual, precoReserva);
            return true;
        } else {
            System.out.printf("Lote NAO VENDIDO. Maior lance: R$ %.2f | Preco de Reserva: R$ %.2f\n",
                    valorAtual, precoReserva);
            return false;
        }
    }

    public String getNome() { return nome; }
    public double getValorAtual() { return valorAtual; }
    public Lance getLanceVencedor() { return lanceVencedor; }
    public boolean isAberto() { return aberto; }
}
