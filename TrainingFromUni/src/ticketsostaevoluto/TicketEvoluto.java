package ticketsostaevoluto;

import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Locale;


public class TicketEvoluto {
    private double costo;
    private LocalDateTime fine;
    private LocalDateTime inizio;

    public TicketEvoluto(LocalDateTime inizio, LocalDateTime fine, double costo) {
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

    public LocalDateTime getFine() {
        return fine;
    }

    public LocalDateTime getInizio() {
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
