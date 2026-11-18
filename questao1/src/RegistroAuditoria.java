import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroAuditoria {
    private LocalDateTime dataHora;
    private String nomeAmbiente;
    private String provedor;
    private String resultado;
    private String motivo;

    public RegistroAuditoria(String nomeAmbiente, String provedor, String resultado, String motivo) {
        this.dataHora = LocalDateTime.now();
        this.nomeAmbiente = nomeAmbiente;
        this.provedor = provedor;
        this.resultado = resultado;
        this.motivo = motivo;
    }

    public String formatar() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String texto = "[" + dataHora.format(formato) + "] " + nomeAmbiente +
                       " | " + provedor +
                       " | " + resultado;
        if (motivo != null && !motivo.isEmpty()) {
            texto += " (" + motivo + ")";
        }
        return texto;
    }
}
