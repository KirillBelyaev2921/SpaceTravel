package ua.kyrylo.bieliaiev.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import ua.kyrylo.bieliaiev.dao.DataProcessingException;
import ua.kyrylo.bieliaiev.db.HibernateUtil;
import ua.kyrylo.bieliaiev.model.Client;
import ua.kyrylo.bieliaiev.model.Planet;
import ua.kyrylo.bieliaiev.model.Ticket;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TicketCrudServiceTest {
    private final ClientCrudService clientService = new ClientCrudService();
    private final PlanetCrudService planetService = new PlanetCrudService();
    private final TicketCrudService ticketService = new TicketCrudService();

    @Test
    @Transactional
    void saveTicketWhenCorrect() {
        Client client = clientService.findClientById(1L).orElseThrow();
        Planet fromPlanet = planetService.findPlanetById("EARTH").orElseThrow();
        Planet toPlanet = planetService.findPlanetById("MARS").orElseThrow();

        Ticket ticket = new Ticket(client, fromPlanet, toPlanet);

        ticketService.saveTicket(ticket);

        assertNotNull(ticket.getId());
    }

    @Test
    @Transactional
    void saveTicketWhenIncorrect() {
        Ticket ticket = new Ticket(null, null, null);

        assertThrows(DataProcessingException.class, () -> ticketService.saveTicket(ticket));
    }

    @Test
    @Transactional
    void findTicketByIdWhenCorrect() {
        Ticket ticket = ticketService.findTicketById(2L).orElseThrow();

        assertEquals(2, ticket.getClient().getId());
        assertEquals("MARS", ticket.getFromPlanet().getId());
        assertEquals("VEN", ticket.getToPlanet().getId());
    }

    @Test
    @Transactional
    void findTicketByIdWhenNotFound() {
        Optional<Ticket> ticket = ticketService.findTicketById(-1L);

        assertTrue(ticket.isEmpty());
    }

    @Test
    @Transactional
    void updateTicketWhenCorrect() {
        Ticket ticket = ticketService.findTicketById(1L).orElseThrow();

        Client newClient = clientService.findClientById(2L).orElseThrow();

        ticket.setClient(newClient);

        ticketService.updateTicket(ticket);

        assertEquals(newClient.getId(), ticket.getClient().getId());
    }

    @Test
    @Transactional
    void updateTicketWhenIncorrect() {
        Ticket ticket = ticketService.findTicketById(1L).orElseThrow();

        ticket.setClient(null);

        assertThrows(DataProcessingException.class, () -> ticketService.updateTicket(ticket));
    }

    @Test
    @Transactional
    void deleteTicketWhenCorrect() {
        Client client = clientService.findClientById(1L).orElseThrow();
        Planet fromPlanet = planetService.findPlanetById("EARTH").orElseThrow();
        Planet toPlanet = planetService.findPlanetById("MARS").orElseThrow();

        Ticket ticket = new Ticket(client, fromPlanet, toPlanet);

        ticketService.saveTicket(ticket);
        assertNotNull(ticket.getId());

        ticketService.deleteTicket(ticket);
        Optional<Ticket> deletedTicket = ticketService.findTicketById(ticket.getId());
        assertTrue(deletedTicket.isEmpty());
    }

    @AfterAll
    static void afterAll() {
        HibernateUtil.getInstance().close();
    }
}