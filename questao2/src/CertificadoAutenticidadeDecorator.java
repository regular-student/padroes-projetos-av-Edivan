public class CertificadoAutenticidadeDecorator extends ServicoDecorator {
    public CertificadoAutenticidadeDecorator(ItemFatura itemDecorado) {
        super(itemDecorado);
    }

    @Override
    public String getDescricao() {
        return "Certificado de Autenticidade";
    }

    @Override
    public double getCusto() {
        return 300.0;
    }
}
