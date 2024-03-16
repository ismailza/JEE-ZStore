package ma.fstm.ilisi.zstore.backoffice.service;

import ma.fstm.ilisi.zstore.backoffice.bo.Client;
import ma.fstm.ilisi.zstore.backoffice.dao.ClientDAO;
import ma.fstm.ilisi.zstore.backoffice.dto.ClientDTO;

import java.util.Collection;

public class ClientService implements ServiceInterface<ClientDTO> {
    private ClientDAO clientDAO;

    public ClientService() {
        this.clientDAO = new ClientDAO();
    }

    @Override
    public boolean create(ClientDTO clientDTO) {
        return false;
    }

    @Override
    public Collection<ClientDTO> retrieve() {
        return this.clientDAO.retrieve().stream().map(this::mapToClientDTO).toList();
    }

    @Override
    public boolean update(ClientDTO clientDTO) {
        return this.clientDAO.update(this.mapToClient(clientDTO));
    }

    @Override
    public boolean delete(ClientDTO clientDTO) {
        return this.clientDAO.delete(this.mapToClient(clientDTO));
    }

    public ClientDTO findById(Long id) {
        Client client = this.clientDAO.findById(id);
        return this.mapToClientDTO(client);
    }

    public Client mapToClient(ClientDTO clientDTO) {
        Client client = new Client(clientDTO.getFirstname(), clientDTO.getLastname(), clientDTO.getEmail(), clientDTO.getUsername());
        client.setId(clientDTO.getId());
        return client;
    }

    public ClientDTO mapToClientDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO(client.getFirstname(), client.getLastname(), client.getEmail(), client.getUsername());
        clientDTO.setId(client.getId());
        return clientDTO;
    }
}
