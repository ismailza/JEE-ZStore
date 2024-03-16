package ma.fstm.ilisi.zstore.backoffice.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.fstm.ilisi.zstore.backoffice.dto.CategoryDTO;
import ma.fstm.ilisi.zstore.backoffice.exception.CategoryNotFoundException;
import ma.fstm.ilisi.zstore.backoffice.service.CategoryService;

import java.io.IOException;

public class CategoryController extends HttpServlet {
    private CategoryService categoryService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.categoryService = new CategoryService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getServletPath()) {
            case "/categories" -> {
                req.setAttribute("categories", this.categoryService.retrieve());
                req.getRequestDispatcher("/categories.jsp").forward(req, resp);
            }
            case "/category/new" -> {
                req.getRequestDispatcher("/categoryForm.jsp").forward(req, resp);
            }
            case "/category/edit" -> {
                try {
                    req.setAttribute("category", this.categoryService.findById(Long.parseLong(req.getParameter("id"))));
                    req.getRequestDispatcher("/categoryForm.jsp").forward(req, resp);
                } catch (NumberFormatException e) {
                    req.getSession().setAttribute("error", e.getMessage());
                    resp.sendRedirect(req.getContextPath() + "/categories");
                } catch (CategoryNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            default -> resp.sendRedirect(req.getContextPath() + "/categories");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getServletPath()) {
            case "/category/save" -> {
                if (this.categoryService.create(constructCategoryDTO(req)))
                    req.getSession().setAttribute("success", "Category created successfully");
                else
                    req.getSession().setAttribute("error", "An error occurred while creating the category");
                resp.sendRedirect(req.getContextPath() + "/categories");
            }
            case "/category/update" -> doPut(req, resp);
            case "/category/delete" -> doDelete(req, resp);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryDTO categoryDTO = constructCategoryDTO(req);
        categoryDTO.setId(Long.parseLong(req.getParameter("id")));
        if (this.categoryService.update(categoryDTO))
            req.getSession().setAttribute("success", "Category updated successfully");
        else
            req.getSession().setAttribute("error", "An error occurred while updating the category");
        resp.sendRedirect(req.getContextPath() + "/categories");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (this.categoryService.delete(this.categoryService.findById(Long.parseLong(req.getParameter("id")))))
                req.getSession().setAttribute("success", "Category deleted successfully");
            else
                req.getSession().setAttribute("error", "An error occurred while deleting the category");
        } catch (CategoryNotFoundException | NumberFormatException e) {
            req.getSession().setAttribute("error", e.getMessage());
        }
    }

    private CategoryDTO constructCategoryDTO(HttpServletRequest req) {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        return new CategoryDTO(name, description);
    }
}
