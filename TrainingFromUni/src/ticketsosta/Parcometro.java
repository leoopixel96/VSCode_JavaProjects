package ticketsosta;

import java.time.Duration;
import java.time.LocalTime;

public class Parcometro {
    private Tariffa tariffa;

    public Parcometro(Tariffa tariffaH1) {
        tariffa = tariffaH1;
    }

    public Ticket emettiTicket(LocalTime inizio, LocalTime fine) { // da soluzione (migliorata)
        double costo;
        LocalTime inizioEffettivo = inizio.plusMinutes(tariffa.getMinutiFranchigia());
        
        costo = calcolaCosto(inizioEffettivo, fine);

        // calcola costo e restituisci ticket
        return new Ticket(inizio, fine, costo); //NB: nel ticket metto orario ufficiale, non effettivo
    }

    private double calcolaCosto(LocalTime da, LocalTime a){ // da soluzione (migliorata)
        
        Duration durataSosta;
        double costo;

        /* mia versione
         * 
        */
        //calcola e restituisci il costo della corsa
        // if(a.isBefore(da) || LocalTime.of(0, 0).equals(a)){
        //     costo = (double) costoOrario * Duration.between(da, LocalTime.of(23, 59)).plusMinutes(1).toHours();
        // }

       
        // if(durataSosta.toMinutes() < tariffa.getDurataMinima()){
        //     costo = costoOrario;
        // }
        // else
        //     costo = (double) costoOrario * minutiSosta.toHours();

        /*  da soluzione (migliorata)
         * 
        */
        if (a.isBefore(da) || LocalTime.of(0, 0).equals(a)) {
			durataSosta = Duration.between(da, LocalTime.of(23, 59)).plusMinutes(1);
		} else {
			durataSosta = Duration.between(da, a);
		}

        if (durataSosta.toMinutes() < tariffa.getDurataMinima()) 
            costo =  tariffa.getDurataMinima() * tariffa.getTariffaOraria() / 60.0;
        else 
            costo = tariffa.getTariffaOraria()*durataSosta.toMinutes()/60.0;
        
        return costo;
    }

    @Override
    public String toString() {
        return "Parcometro [tariffa=" + tariffa + "]";
    }

    

}