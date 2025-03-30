package ua.kyrylo.bieliaiev.service;

import ua.kyrylo.bieliaiev.dao.ClientDao;
import ua.kyrylo.bieliaiev.model.Client;

import java.util.Optional;

public class ClientCrudService {

    private final ClientDao clientDao = new ClientDao();

    public void saveClient(Client client) {
        clientDao.save(client);
    }

    public Optional<Client> findClientById(Long id) {
        return clientDao.getById(id);
    }

    public void updateClient(Client client) {
        clientDao.update(client);
    }

    public void deleteClient(Client client) {
        clientDao.delete(client);
    }
}
