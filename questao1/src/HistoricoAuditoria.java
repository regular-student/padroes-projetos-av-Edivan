import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HistoricoAuditoria {
    private static HistoricoAuditoria instancia;
    private List<RegistroAuditoria> registros = Collections.synchronizedList(new ArrayList<>());

    private HistoricoAuditoria() {
    }

    public static synchronized HistoricoAuditoria getInstance() {
        if (instancia == null) {
            instancia = new HistoricoAuditoria();
        }
        return instancia;
    }

    public void registrar(RegistroAuditoria registro) {
        registros.add(registro);
    }

    public void imprimirHistorico() {
        System.out.println("\n--- Historico de Auditoria ---");
        synchronized (registros) {
            for (RegistroAuditoria r : registros) {
                System.out.println(r.formatar());
            }
        }
    }
}
