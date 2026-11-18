import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Configuracao {
    private static Configuracao instancia;
    private String regiaoPadrao;
    private double orcamentoMaximo;

    private Configuracao() {
        Properties props = new Properties();
        try {
            InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
            if (input == null) {
                input = new FileInputStream("config.properties");
            }
            props.load(input);
            this.regiaoPadrao = props.getProperty("regiao.padrao", "us-east-1");
            this.orcamentoMaximo = Double.parseDouble(props.getProperty("orcamento.maximo", "500.0"));
        } catch (Exception e) {
            this.regiaoPadrao = "us-east-1";
            this.orcamentoMaximo = 500.0;
        }
    }

    public static synchronized Configuracao getInstance() {
        if (instancia == null) {
            instancia = new Configuracao();
        }
        return instancia;
    }

    public String getRegiaoPadrao() {
        return regiaoPadrao;
    }

    public double getOrcamentoMaximo() {
        return orcamentoMaximo;
    }
}
