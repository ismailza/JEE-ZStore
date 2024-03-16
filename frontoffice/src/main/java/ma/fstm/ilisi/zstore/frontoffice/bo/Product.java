package ma.fstm.ilisi.zstore.frontoffice.bo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String description;
    private String photo;
    private float price;
    private int stock;
    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;

    public Product() {

    }

    public Product(String name, Category category, String description, String photo, float price, int stock) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.photo = photo;
        this.price = price;
        this.stock = stock;
    }

    public Product(Long id, String name, Category category, String description, String photo, float price, int stock) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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
