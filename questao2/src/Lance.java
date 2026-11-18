import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Lance {
    private double valor;
    private LocalDateTime dataHora;
    private Participante participante;

    public Lance(double valor, Participante participante) {
        this.valor = valor;
        this.participante = participante;
        this.dataHora = LocalDateTime.now();
    }

    public double getValor() {
        return valor;
    }

    public Participante getParticipante() {
        return participante;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getDataHoraFormatada() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dataHora.format(fmt);
    }
}
