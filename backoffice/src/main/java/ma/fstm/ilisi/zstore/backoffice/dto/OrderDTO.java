package ma.fstm.ilisi.zstore.backoffice.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {
    private Long id;
    private LocalDateTime date;
    private List<OrderItemDTO> orderItems;

    public OrderDTO() {
        this.orderItems = new ArrayList<>();
        this.date = LocalDateTime.now();
    }

    public OrderDTO(Long id, LocalDateTime date, List<OrderItemDTO> orderItems) {
        this.id = id;
        this.date = date;
        this.orderItems = orderItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }

}
