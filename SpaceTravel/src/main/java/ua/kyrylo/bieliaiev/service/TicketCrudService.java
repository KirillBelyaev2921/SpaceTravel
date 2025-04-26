package ua.kyrylo.bieliaiev.service;

import ua.kyrylo.bieliaiev.dao.TicketDao;
import ua.kyrylo.bieliaiev.model.Ticket;

import java.util.Optional;

public class TicketCrudService {

    private final TicketDao ticketDao = new TicketDao();
    private final ClientCrudService clientCrudService = new ClientCrudService();
    private final PlanetCrudService planetCrudService = new PlanetCrudService();

    public void saveTicket(Ticket ticket) {
        validateTicket(ticket);
        ticketDao.save(ticket);
    }

    public Optional<Ticket> findTicketById(Long id) {
        return ticketDao.getById(id);
    }

    public void updateTicket(Ticket ticket) {
        validateTicket(ticket);
        ticketDao.update(ticket);
    }

    public void deleteTicket(Ticket ticket) {
        ticketDao.delete(ticket);
    }

    private void validateTicket(Ticket ticket) {
        if (ticket.getClient() == null || ticket.getClient().getId() == null) {
            throw new IllegalArgumentException("Client is null");
        } else if (clientCrudService.findClientById(ticket.getClient().getId()).isEmpty()) {
            throw new IllegalArgumentException("Client with id " + ticket.getClient().getId() + " not found");
        }
        if (ticket.getFromPlanet() == null || ticket.getFromPlanet().getId() == null) {
            throw new IllegalArgumentException("From planet is null");
        } else if (planetCrudService.findPlanetById(ticket.getFromPlanet().getId()).isEmpty()) {
            throw new IllegalArgumentException("From planet with id " + ticket.getFromPlanet().getId() + " not found");
        }
        if (ticket.getToPlanet() == null || ticket.getToPlanet().getId() == null) {
            throw new IllegalArgumentException("To planet is null");
        } else if (planetCrudService.findPlanetById(ticket.getToPlanet().getId()).isEmpty()) {
            throw new IllegalArgumentException("To planet with id " + ticket.getToPlanet().getId() + " not found");
        }
    }
}
