package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {

    private TicketRepository repository;

    public TicketManager(TicketRepository repo) {
        this.repository = repo;
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public boolean matchesFromTo(Ticket ticket, String fromAirport, String toAirport) {
        if (ticket.getFromAirport().contains(fromAirport)) {
            return true;
        }
        if (ticket.getToAirport().contains(toAirport)) {
            return true;
        } else {
            return false;
        }
    }

    public Ticket[] findAllBySort(String fromAirport, String toAirport) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matchesFromTo(ticket, fromAirport, toAirport)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}