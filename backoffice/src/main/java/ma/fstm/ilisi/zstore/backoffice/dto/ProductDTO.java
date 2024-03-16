package ma.fstm.ilisi.zstore.backoffice.dto;

import java.util.List;

public class ProductDTO {
    private Long id;
    private String name;
    private CategoryDTO category;
    private String description;
    private String photo;
    private float price;
    private int stock;
    private List<OrderItemDTO> orderItems;

    public ProductDTO() {

    }

    public ProductDTO(String name, CategoryDTO category, String description, String photo, float price, int stock) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.photo = photo;
        this.price = price;
        this.stock = stock;
    }

    public ProductDTO(Long id, String name, CategoryDTO category, String description, String photo, float price, int stock) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.photo = photo;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
