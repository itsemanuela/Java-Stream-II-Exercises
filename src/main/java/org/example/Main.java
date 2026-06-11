package org.example;

import entities.Prodotto;
import entities.Cliente;
import entities.Ordine;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //Creo la lista, quindi il catalogo dei prodotti (libri)
        Prodotto libro1= new Prodotto(12345L,  "Harry Potter", "fantasy", 12.50);
        Prodotto libro2= new Prodotto(1232123L, "Il Signore degli Anelli premium", "fantasy", 120.0);
        Prodotto libro3= new Prodotto(345678L, "Le cronache di Narnia", "fantasy", 45.0);
        Prodotto libro4= new Prodotto(456789L, "Java Programming", "Informatica", 150.50);
        Prodotto libro5= new Prodotto (3456789L, "React Advanced", "Informatica", 115.50);



// Catalogo baby

        Prodotto baby1= new Prodotto(344583L, "Pannolini", "baby", 11.00);
        Prodotto baby2= new Prodotto(239485L, "Pastina", "baby", 3.80);
        Prodotto baby3= new Prodotto(458396L, "Triciclo", "baby", 268.60);



        //Catalogo boy
        Prodotto boy1=new Prodotto(24484L, "Fumetto", "boy" , 14.50);
        Prodotto boy2= new Prodotto(23456345L, "Profumo", "boy", 150.70);
        Prodotto boy3=new Prodotto(23456L, "Giacca Denim", "boy", 128.80);


//Creazione dei clienti

        Cliente cliente1= new Cliente(121294L, "Emanuela", 2);
        Cliente cliente2= new Cliente(124294L, "Gianluca", 4);
        Cliente cliente3 =new Cliente(248467L, "Anna", 2);
        Cliente cliente4= new Cliente(26848L, "Sara", 7);
        Cliente cliente5=new Cliente(24828L, "Giorgia", 2);

        // Creazione ordini
        Ordine ordine1= new Ordine(765403L, "SPEDITO", LocalDate.of(2026, 05, 15), LocalDate.of(2026, 05, 17), List.of(libro2, libro1, baby3), cliente3);
        System.out.println(ordine1 );

        Ordine ordine2= new Ordine(763948L, "ORDINATO", LocalDate.of(2026, 3, 12), LocalDate.of(2026, 1, 3), List.of(libro2, libro5, boy3,baby1), cliente5);
        System.out.println(ordine2 );

        Ordine ordine3= new Ordine(764335L, "COMPLETATO", LocalDate.of(2026, 6, 10), LocalDate.of(2026, 6, 12), List.of(boy2, libro2), cliente4);


        //STREAM per la prima lista di libri sopra ai 100, avvio lo stream, filtro e poi li inserisco in una lista
        List<Prodotto> catalogoLibri = List.of(libro1, libro2, libro3, libro4, libro5);
        List<Prodotto> libriCostosi= catalogoLibri.stream().filter(libro ->libro.getPrezzo() > 100).toList(); //chiudo lo stream con toList infatti mi stampa solo lista dei libri costosi.
        System.out.println("********************LIBRI COSTOSI**************************");
        libriCostosi.forEach(System.out::println);


//lista di ORDINI categoria baby

        List<Ordine> ordiniBaby= List.of(ordine1, ordine2, ordine3)
                //prima mi controllo gli ordini
                //Avvio lo stream e filtro gli ordini, mi leggo i prodotti, entro nel catologo dei prodotti
                .stream().filter(ord-> ord.getProdotti()
                        //secondo stream controllo se almeno un prodotto ha la categoria baby e con toList chiudo lo stream e stampo gli ordini baby.
                        .stream().anyMatch(prodotto -> prodotto.getCategoria().equals("baby"))).toList();
        System.out.println("************************************************************************");
        System.out.println("ORDINI CON ALMENO UNA CATEGORIA BABY");
        ordiniBaby.forEach(System.out::println);




        //Categoria Boy
        //mi creo lista di prodotti boy
        List<Prodotto> boyProdotto= List.of(boy1, boy2, boy3);
        //per ogni prod applico sconto e ritorno una lista trasformata quindi coon mtodo map.
        List<Prodotto> boySconto= boyProdotto.stream().filter(prodotto -> prodotto.getCategoria().equals("boy"))
                .map(prodottoBoy -> new Prodotto(
                        prodottoBoy.getId(),
                        prodottoBoy.getNome(),
                        prodottoBoy.getCategoria(),
                        prodottoBoy.getPrezzo() *0.9
                ) ).toList();

        //ho letto la categoria, con equals ho controllato se c'era la parola boy nella categoria, ho chiuso lo stream col toList e ho stampato i prodotti da ragazzo scontati.


        System.out.println("*++++++++++++++++BOY PRODUCTS SCONTATI DEL 10%*****************************");
        boyProdotto.forEach(System.out::println);


        System.out.println("****************ESERCIZIO STREAM II*************************");
        System.out.println("-------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------");

        //raggruppo tutti gli ordini per cliente, quindi creo prima lista di tutti gli ordini

        List<Ordine> tuttiGliOrdini= List.of(ordine1, ordine2, ordine3);
        List<Prodotto> tuttiProdotti= List.of(libro1, libro2, libro3, libro4, libro5, baby2,baby1, baby3);

//utilizzo groupingBy per raggruppare tutti gli ordini quindi apro il Map perchè groupingBy, metodo dei Collector mi restituisce sempre un map. Per raggruppare gli ordini del cliente mi prendo il cliente che diventa la key del map, la lista degli ordini diventa il valore.

        //workflow
        //map (k-v), variabile, avvio lo stream, collect, raggruppo, stampo.

        Map<Cliente, List<Ordine>> ordiniPerCliente= tuttiGliOrdini.stream().collect(Collectors.groupingBy(Ordine::getCliente));
        ordiniPerCliente.forEach((cliente, listaOrdini)->   {
            System.out.println(cliente.getId() + " " + cliente.getNome() + " " + cliente.getTier() + " " + "ORDINI" + listaOrdini);
        })  ;


        System.out.println("-------------------------SECONDO ESERCIZIO-----------------------");

        //per il secondo esercizio vado ad aggiungere il metodo calculate() nella classe degli ordini prima.
        System.out.println("---------------TOTALE SPESO PER OGNI CLIENTE------------------");

Map<Cliente, Double> totaleSpeso= tuttiGliOrdini.stream().collect(Collectors.groupingBy(Ordine::getCliente, Collectors.summingDouble(Ordine::calolaTotale))); //qua richiamo il metodo calcolaTotale messo nella Class Ordine
totaleSpeso.forEach((cliente, totaleSpesa)->{
    System.out.println("Cliente: " + cliente.getId() + " " + cliente.getNome()+ " " + "ha speso in totale: " + totaleSpesa);
});

    }

}






