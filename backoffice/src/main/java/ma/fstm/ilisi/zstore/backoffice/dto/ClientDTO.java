package ma.fstm.ilisi.zstore.backoffice.dto;

import java.util.List;
import java.util.Set;

public class ClientDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private List<AddressDTO> addresses;
    private Set<OrderDTO> orders;

    public ClientDTO() {
    }

    public ClientDTO(String firstname, String lastname, String email, String username) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
    }

    public ClientDTO(Long id, String firstname, String lastname, String email, String username, List<AddressDTO> addresses, Set<OrderDTO> orders) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.addresses = addresses;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<AddressDTO> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDTO> addresses) {
        this.addresses = addresses;
    }

    public Set<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderDTO> orders) {
        this.orders = orders;
    }

    public void addAddress(AddressDTO address) {
        this.addresses.add(address);
    }

    public void addOrder(OrderDTO order) {
        this.orders.add(order);
    }

}
