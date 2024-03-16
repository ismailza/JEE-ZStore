package ma.fstm.ilisi.zstore.backoffice.service;

import ma.fstm.ilisi.zstore.backoffice.bo.Category;
import ma.fstm.ilisi.zstore.backoffice.bo.Product;
import ma.fstm.ilisi.zstore.backoffice.dao.ProductDAO;
import ma.fstm.ilisi.zstore.backoffice.dto.CategoryDTO;
import ma.fstm.ilisi.zstore.backoffice.dto.ProductDTO;
import ma.fstm.ilisi.zstore.backoffice.exception.ProductNotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService implements ServiceInterface<ProductDTO> {
    private ProductDAO productDAO;

    public ProductService() {
        this.productDAO = new ProductDAO();
    }

    @Override
    public Collection<ProductDTO> retrieve() {
        return this.productDAO.retrieve().stream().map(this::mapToProductDTO).toList();
    }

    public List<ProductDTO> retrieve(CategoryDTO category) {
        return this.productDAO.retrieve(new CategoryService().mapToCategory(category)).stream().map(this::mapToProductDTO).toList();
    }

    @Override
    public boolean create(ProductDTO productDTO) {
        return this.productDAO.create(this.mapToProduct(productDTO));
    }

    @Override
    public boolean update(ProductDTO productDTO) {
        return this.productDAO.update(this.mapToProduct(productDTO));
    }

    @Override
    public boolean delete(ProductDTO productDTO) {
        return this.productDAO.delete(this.mapToProduct(productDTO));
    }

    public ProductDTO findById(Long id) throws ProductNotFoundException {
        Product product = this.productDAO.findById(id);
        if (product == null)
            throw new ProductNotFoundException("Product not found!");
        return this.mapToProductDTO(product);
    }

    public ProductDTO mapToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO(product.getName(), new CategoryService().mapToCategoryDTO(product.getCategory()), product.getDescription(), product.getPhoto(), product.getPrice(), product.getStock());
        productDTO.setId(product.getId());
        return productDTO;
    }

    public Product mapToProduct(ProductDTO productDTO) {
        Product product = new Product(productDTO.getName(), new CategoryService().mapToCategory(productDTO.getCategory()), productDTO.getDescription(), productDTO.getPhoto(), productDTO.getPrice(), productDTO.getStock());
        product.setId(productDTO.getId());
        return product;
    }
}
