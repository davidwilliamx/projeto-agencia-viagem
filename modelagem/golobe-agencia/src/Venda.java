import java.sql.Date;

public class Venda {
    private int id;
    private Double valorVenda;
    private Date dataVenda;

    public Venda() {
    }

    public Venda(int id, Double valorVenda, Date dataVenda) {
        this.id = id;
        this.valorVenda = valorVenda;
        this.dataVenda = dataVenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }
}
