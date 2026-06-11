package entities;

public class Prodotto {
    private Long id;
    private String nome;
    private String categoria;
    private Double prezzo;


//costruttore prodotto

    public Prodotto(Long id, String nome, String categoria, Double prezzo){
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.prezzo = prezzo;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id){this.id = id;}

    public String getNome() {
        return nome;
    }
    public void setNome(String nome){this.nome = nome;}
    public String getCategoria() {return categoria;  }
    public void setCategoria(String categoria){this.categoria = categoria;}
    public Double getPrezzo() {return prezzo;}
    public void setPrezzo(Double prezzo){this.prezzo = prezzo;}


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Prodotto{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", categoria='").append(categoria).append('\'');
        sb.append(", prezzo=").append(prezzo);
        sb.append('}');
        return sb.toString();
    }
}