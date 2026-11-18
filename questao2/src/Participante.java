public class Participante implements Interessado {
    private String id;
    private String nome;

    public Participante(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void notificarLance(String nomeLote, Lance lance) {
        System.out.printf("[%s] Lote '%s' recebeu lance de R$ %.2f de %s\n",
                nome, nomeLote, lance.getValor(), lance.getParticipante().getNome());
    }
}
