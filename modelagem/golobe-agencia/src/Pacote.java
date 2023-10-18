import java.sql.Date;

public class Pacote {
    private int id;
    private String nome;
    private Double valor;
    private Date dataPartida;
    private Date dataRetorno;

    public Pacote() {
    }

    public Pacote(int id, String nome, Double valor, Date dataPartida, Date dataRetorno) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.dataPartida = dataPartida;
        this.dataRetorno = dataRetorno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(Date dataPartida) {
        this.dataPartida = dataPartida;
    }

    public Date getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(Date dataRetorno) {
        this.dataRetorno = dataRetorno;
    }
}
