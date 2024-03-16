package ma.fstm.ilisi.zstore.backoffice.service;

import ma.fstm.ilisi.zstore.backoffice.dto.OrderDTO;

import java.util.Collection;

public class OrderService implements ServiceInterface<OrderDTO> {
    @Override
    public Collection<OrderDTO> retrieve() {
        return null;
    }

    @Override
    public boolean create(OrderDTO orderDTO) {
        return false;
    }

    @Override
    public boolean update(OrderDTO orderDTO) {
        return false;
    }

    @Override
    public boolean delete(OrderDTO orderDTO) {
        return false;
    }
}
