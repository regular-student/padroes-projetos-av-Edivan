public interface ItemFatura {
    String getDescricao();
    double getCusto();
    double getValorTotal();
    void imprimirLinhas();
    void imprimirFatura();
}
