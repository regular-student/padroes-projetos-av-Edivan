import java.util.ArrayList;
import java.util.List;

public class MontadorAmbiente {
    private ProvedorNuvemFactory factory;

    public MontadorAmbiente(ProvedorNuvemFactory factory) {
        this.factory = factory;
    }

    public Ambiente montarAmbiente(SolicitacaoAmbiente solicitacao) {
        Configuracao config = Configuracao.getInstance();
        HistoricoAuditoria historico = HistoricoAuditoria.getInstance();

        double custoTotal = factory.calcularCustoEstimado(
                solicitacao.getQtdMaquinas(),
                solicitacao.getGbArmazenamento()
        );

        if (custoTotal > config.getOrcamentoMaximo()) {
            String motivo = String.format("Custo R$ %.2f ultrapassa o orcamento maximo de R$ %.2f",
                    custoTotal, config.getOrcamentoMaximo());
            historico.registrar(new RegistroAuditoria(
                    solicitacao.getNomeAmbiente(),
                    factory.getNomeProvedor(),
                    "RECUSADO",
                    motivo
            ));
            System.out.println("\n[Recusado] " + solicitacao.getNomeAmbiente() + ": " + motivo);
            return null;
        }

        List<MaquinaVirtual> maquinas = new ArrayList<>();
        for (int i = 1; i <= solicitacao.getQtdMaquinas(); i++) {
            maquinas.add(factory.criarMaquinaVirtual(i));
        }

        Armazenamento armazenamento = factory.criarArmazenamento(1, solicitacao.getGbArmazenamento());
        Fila fila = factory.criarFila(1);

        Ambiente ambiente = new Ambiente(
                solicitacao.getNomeAmbiente(),
                factory.getNomeProvedor(),
                config.getRegiaoPadrao(),
                maquinas,
                armazenamento,
                fila,
                custoTotal
        );

        historico.registrar(new RegistroAuditoria(
                solicitacao.getNomeAmbiente(),
                factory.getNomeProvedor(),
                "ACEITO",
                "Provisionamento realizado com sucesso"
        ));

        ambiente.imprimirResumo();
        return ambiente;
    }
}
