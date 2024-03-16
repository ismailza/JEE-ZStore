package ma.fstm.ilisi.zstore.backoffice.service;

import ma.fstm.ilisi.zstore.backoffice.bo.Category;
import ma.fstm.ilisi.zstore.backoffice.dao.CategoryDAO;
import ma.fstm.ilisi.zstore.backoffice.dto.CategoryDTO;
import ma.fstm.ilisi.zstore.backoffice.dto.ProductDTO;
import ma.fstm.ilisi.zstore.backoffice.exception.CategoryNotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryService implements ServiceInterface<CategoryDTO> {
    private CategoryDAO categoryDAO;

    public CategoryService() {
        this.categoryDAO = new CategoryDAO();
    }

    @Override
    public Collection<CategoryDTO> retrieve() {
        return this.categoryDAO.retrieve().stream().map(this::mapToCategoryDTO).toList();
    }

    @Override
    public boolean create(CategoryDTO categoryDTO) {
        return this.categoryDAO.create(this.mapToCategory(categoryDTO));
    }

    @Override
    public boolean update(CategoryDTO categoryDTO) {
        return this.categoryDAO.update(this.mapToCategory(categoryDTO));
    }

    @Override
    public boolean delete(CategoryDTO categoryDTO) {
        return this.categoryDAO.delete(this.mapToCategory(categoryDTO));
    }

    public CategoryDTO findById(Long id) throws CategoryNotFoundException {
        Category category = this.categoryDAO.findById(id);
        if (category == null)
            throw new CategoryNotFoundException("Category not found!");
        return this.mapToCategoryDTO(category);
    }

    public Category mapToCategory(CategoryDTO categoryDTO) {
        Category category = new Category(categoryDTO.getName(), categoryDTO.getDescription());
        category.setId(categoryDTO.getId());
        return category;
    }

    public CategoryDTO mapToCategoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO(category.getName(), category.getDescription());
        categoryDTO.setId(category.getId());
        return categoryDTO;
    }
}
