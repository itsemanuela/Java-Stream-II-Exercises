package entities;

public class Cliente {
    private Long id;
    private String nome;
    private int tier;

    //costruttore cliente

    public Cliente(Long id, String nome, int tier) {
        this.id = id;
        this.nome = nome;
        this.tier = tier;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {this.id=id;
    };
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public int getTier() {return tier;}
    public void setTier(int tier) {this.tier = tier;}


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cliente{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", tier=").append(tier);
        sb.append('}');
        return sb.toString();
    }
}