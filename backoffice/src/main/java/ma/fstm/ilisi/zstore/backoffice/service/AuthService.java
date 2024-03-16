package ma.fstm.ilisi.zstore.backoffice.service;

import ma.fstm.ilisi.zstore.backoffice.bo.Client;
import ma.fstm.ilisi.zstore.backoffice.dao.ClientDAO;
import ma.fstm.ilisi.zstore.backoffice.dto.ClientDTO;
import ma.fstm.ilisi.zstore.backoffice.exception.ClientNotFoundException;

public class AuthService {
    private ClientDAO clientDAO;

    public AuthService() {
        this.clientDAO = new ClientDAO();
    }

    public boolean create(ClientDTO clientDTO, String password) {
        if (this.clientDAO.checkEmailAndUsername(clientDTO.getEmail(), clientDTO.getUsername()) == null)
            return false;
        Client client = new ClientService().mapToClient(clientDTO);
        client.setPassword(password);
        return this.clientDAO.create(client);
    }

    public ClientDTO authenticate(String login, String password) throws ClientNotFoundException {
        Client client = this.clientDAO.checkEmailAndUsername(login, login);
        if (client == null)
            throw new ClientNotFoundException("Invalid credential, verify your login");
        if (client.getPassword().equals(password))
            return new ClientService().mapToClientDTO(client);
        return null;
    }

}
