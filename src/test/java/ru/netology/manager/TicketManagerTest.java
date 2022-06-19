package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.manager.TicketManager;
import ru.netology.repository.TicketRepository;

public class TicketManagerTest {

    Ticket ticket1 = new Ticket(1, 2500, "ABA", "BAX", 200);
    Ticket ticket2 = new Ticket(2, 4500, "FRA", "MUR", 300);
    Ticket ticket3 = new Ticket(3, 6800, "SIS", "JUK", 170);
    Ticket ticket4 = new Ticket(4, 9300, "KIM", "RIM", 400);
    Ticket ticket5 = new Ticket(5, 1400, "MUN", "FRA", 250);

    @Test
    public void test() {

        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.findAllBySort("A", "A");
        Ticket[] expected = {ticket5, ticket1, ticket2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test1() {

        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.findAllBySort("J", "C");
        Ticket[] expected = {};
        assertArrayEquals(expected, actual);
    }


}