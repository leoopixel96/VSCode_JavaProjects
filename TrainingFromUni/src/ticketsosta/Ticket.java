package ticketsosta;

import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Locale;


public class Ticket {
    private double costo;
    private LocalTime fine;
    private LocalTime inizio;

    public Ticket(LocalTime inizio, LocalTime fine, double costo) {
        this.costo = costo;
        this.fine = fine;
        this.inizio = inizio;
    }

    public double getCosto() {
        return costo;
    }

    public String getCostoAsString() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.ITALY);
        return formatter.format(costo);
    }

    public LocalTime getFine() {
        return fine;
    }

    public LocalTime getInizio() {
        return inizio;
    }

    @Override
    public String toString() {
        return "Ticket [costo=" + costo + ", fine=" + fine + ", inizio=" + inizio + "]";
    }

    public String toStringDuration(Duration duration) {
        return "Durata Ticket [durata=" + duration.toHours() + ":" + duration.toMinutes() + "]";
    }
    
}
