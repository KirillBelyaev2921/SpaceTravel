package ua.kyrylo.bieliaiev.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import ua.kyrylo.bieliaiev.dao.DataProcessingException;
import ua.kyrylo.bieliaiev.db.HibernateUtil;
import ua.kyrylo.bieliaiev.model.Client;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClientCrudServiceTest {
    private final ClientCrudService clientService = new ClientCrudService();

    @Test
    @Transactional
    void saveClientWhenCorrect() {
        Client client = new Client("Kyrylo");

        clientService.saveClient(client);

        assertNotNull(client.getId());
    }
    @Test
    @Transactional
    void saveClientWhenInCorrect() {
        Client client = new Client("");

        assertThrows(DataProcessingException.class, () -> clientService.saveClient(client));
    }

    @Test
    @Transactional
    void findClientByIdWhenCorrect() {
        Client client = clientService.findClientById(2L).orElseThrow();

        assertEquals("Bob Smith", client.getName());
    }
    @Test
    @Transactional
    void findClientByIdWhenNotFound() {
        Optional<Client> client = clientService.findClientById(-1L);

        assertTrue(client.isEmpty());
    }

    @Test
    @Transactional
    void updateClient() {
        Client client = clientService.findClientById(1L).orElseThrow();
        client.setName("Kyrylo");

        clientService.updateClient(client);

        Client savedClient = clientService.findClientById(1L).orElseThrow();

        assertEquals("Kyrylo", savedClient.getName());
    }

    @Test
    @Transactional
    void deleteClient() {
        Client client = new Client("Kyrylo");

        clientService.saveClient(client);
        clientService.deleteClient(client);

        Optional<Client> deletedClient = clientService.findClientById(client.getId());

        assertTrue(deletedClient.isEmpty());

    }

    @AfterAll
    static void afterAll() {
        HibernateUtil.getInstance().close();
    }
}