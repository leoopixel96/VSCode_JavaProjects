package ticketsostaevoluto;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import ticketsosta.Tariffa;
import ticketsosta.Ticket;

public class ParcometroEvoluto {
    private Tariffa[] tariffe;

    public ParcometroEvoluto(Tariffa[] tariffeH1) {
        tariffe = tariffeH1;
    }

    public TicketEvoluto emettiTicket(LocalDateTime inizio, LocalDateTime fine) { // da soluzione (migliorata)
        double costo;
        LocalDateTime inizioEffettivo = inizio.plusMinutes(tariffe[0].getMinutiFranchigia());
        
        costo = calcolaCostoSuPiuGiorni(inizioEffettivo, fine);

        // calcola costo e restituisci ticket
        return new TicketEvoluto(inizio, fine, costo); //NB: nel ticket metto orario ufficiale, non effettivo
    }

    private double calcolaCostoSuPiuGiorni(LocalDateTime da, LocalDateTime a){
        double costoTotale = 0;

        // se inizio e fine sono nello stesso giorno, procedere come parcometro normale, altrimenti per ogni giorno applicare la tariffa corretta
        if(da.toLocalDate().isEqual(a.toLocalDate())){
            costoTotale = calcolaCosto(tariffe[da.getDayOfWeek().getValue()-1], da, a);
        }
        else{
            // 2 modo, migliore
            LocalDate curDate = da.toLocalDate();
            while(curDate.isBefore(a.toLocalDate()) || curDate.isEqual(a.toLocalDate())){
                //calcola costo
                //Se il giorno corrente non è uguale al giorno di fine, inserisci la mezzanotte come momento di fine
                //Se il giorno corrente è uguale al giorno di fine, inserisci la mattina come momento di inizio
                if(curDate.isBefore(a.toLocalDate())){
                    costoTotale += calcolaCosto(tariffe[curDate.getDayOfWeek().getValue()-1], 
                                        da, LocalDateTime.of(curDate, LocalTime.of(23, 59).plusMinutes(1)));
                }
                else if(curDate.isEqual(a.toLocalDate())){
                    costoTotale += calcolaCosto(tariffe[curDate.getDayOfWeek().getValue()-1], 
                                        LocalDateTime.of(curDate, LocalTime.of(00, 00).plusMinutes(1)), a);
                }

                //incrementa date
                curDate = curDate.plusDays(1);
            }
        }

        

        return costoTotale;
    }

    private double calcolaCosto(Tariffa tariffa, LocalDateTime da, LocalDateTime a){ // da soluzione
        double costo;
        Duration durataSosta;

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
			durataSosta = Duration.between(da, LocalDateTime.of(da.toLocalDate(), LocalTime.of(23, 59).plusMinutes(1)));
		} else {
			durataSosta = Duration.between(da, a);
		}

        if (Duration.between(da, a).toMinutes() < tariffa.getDurataMinima()) 
            costo =  tariffa.getDurataMinima() * tariffa.getTariffaOraria() / 60.0;
        else 
            costo = tariffa.getTariffaOraria()*durataSosta.toMinutes()/60.0;
        
        return costo;
    }

    @Override
    public String toString() {
        String result = "Parcometro Evoluto [";
        for(Tariffa tariffa : tariffe){
            result += "tariffa " + tariffa.getNome() + "\n";
        }
        result += "]";
        return result;
    }

    
}