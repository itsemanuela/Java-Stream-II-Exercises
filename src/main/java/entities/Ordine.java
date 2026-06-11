package entities;

import java.time.LocalDate;
import java.util.List;

public class Ordine {
    private Long id;
    private String status;
    private LocalDate dataOrdine;
    private LocalDate dataSpedizione;
    private List<Prodotto> prodotti;
    private Cliente cliente;

    //costruttore ordine
    public Ordine(Long id, String status, LocalDate dataOrdine, LocalDate dataSpedizione, List<Prodotto> prodotti, Cliente cliente) {
        this.id=id;
        this.status=status;
        this.dataOrdine=dataOrdine;
        this.dataSpedizione=dataSpedizione;
        this.prodotti=prodotti;
        this.cliente=cliente;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id=id;}

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}

    public LocalDate getDataOrdine() {return dataOrdine;}
    public void setDataOrdine(LocalDate dataOrdine) {this.dataOrdine = dataOrdine;}

    public LocalDate getDataSpedizione() {return dataSpedizione;}
    public void setDataSpedizione(LocalDate dataSpedizione) {
        this.dataSpedizione = dataSpedizione;
    }
    public List<Prodotto> getProdotti() {return prodotti;}
    public void setProdotti(List<Prodotto> prodotti) {this.prodotti = prodotti;}

    public Cliente getCliente() {return cliente;}
    public void setCliente(Cliente cliente) {this.cliente = cliente;}


    //metodo calculate per sommare tutte le cifre degli ordini

    public double calolaTotale(){
        return this.prodotti.stream().mapToDouble(Prodotto::getPrezzo).sum();
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ordine{\n");

        sb.append("id=").append(id).append("\n");
        sb.append("status='").append(status).append("'\n");
        sb.append("dataOrdine=").append(dataOrdine).append("\n");
        sb.append("dataSpedizione=").append(dataSpedizione).append("\n");

        sb.append("prodotti=\n");
        for (Prodotto p : prodotti) {
            sb.append("   - ").append(p).append("\n");
        }

        sb.append("cliente=").append(cliente).append("\n");
        sb.append("}");

        return sb.toString();
    }

}