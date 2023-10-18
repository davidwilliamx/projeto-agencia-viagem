public class Destino {
    private int id;
    private String cidade;
    private String pais;

    public Destino() {
    }

    public Destino(int id, String cidade, String pais) {
        this.id = id;
        this.cidade = cidade;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
