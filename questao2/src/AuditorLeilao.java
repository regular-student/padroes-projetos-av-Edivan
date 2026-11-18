import java.util.ArrayList;
import java.util.List;

public class AuditorLeilao implements Interessado {
    private List<String> registros = new ArrayList<>();

    @Override
    public void notificarLance(String nomeLote, Lance lance) {
        String log = String.format("[%s] Lance aceito no lote '%s': R$ %.2f por %s",
                lance.getDataHoraFormatada(), nomeLote, lance.getValor(), lance.getParticipante().getNome());
        registros.add(log);
        System.out.println("[Auditoria] " + log);
    }

    public void imprimirAuditoria() {
        System.out.println("\n--- Auditoria dos Lances ---");
        for (String r : registros) {
            System.out.println(r);
        }
    }
}
