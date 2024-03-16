package ma.fstm.ilisi.zstore.backoffice.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.fstm.ilisi.zstore.backoffice.dto.ProductDTO;
import ma.fstm.ilisi.zstore.backoffice.exception.CategoryNotFoundException;
import ma.fstm.ilisi.zstore.backoffice.exception.ProductNotFoundException;
import ma.fstm.ilisi.zstore.backoffice.service.CategoryService;
import ma.fstm.ilisi.zstore.backoffice.service.ProductService;

import java.io.IOException;

public class ProductController extends HttpServlet {
    private ProductService productService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getServletPath()) {
            case "/products" -> {
                req.setAttribute("products", this.productService.retrieve());
                req.getRequestDispatcher("/products.jsp").forward(req, resp);
            }
            case "/product/new" -> {
                req.setAttribute("categories", new CategoryService().retrieve());
                req.getRequestDispatcher("/productForm.jsp").forward(req, resp);
            }
            case "/product/edit" -> {
                try {
                    req.setAttribute("categories", new CategoryService().retrieve());
                    req.setAttribute("product", this.productService.findById(Long.parseLong(req.getParameter("id"))));
                    req.getRequestDispatcher("/productForm.jsp").forward(req, resp);
                } catch (ProductNotFoundException | NumberFormatException e) {
                    req.getSession().setAttribute("error", e.getMessage());
                    resp.sendRedirect(req.getContextPath() + "/products");
                }
            }
            default -> resp.sendRedirect(req.getContextPath() + "/products");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getServletPath()) {
            case "/product/save" -> {
                try {
                    if (this.productService.create(constructProductDTO(req)))
                        req.getSession().setAttribute("success", "Product added successfully");
                    else
                        req.getSession().setAttribute("error", "Product not added");
                } catch (CategoryNotFoundException | NumberFormatException e) {
                    req.getSession().setAttribute("error", e.getMessage());
                }
                resp.sendRedirect(req.getContextPath() + "/products");
            }
            case "/product/update" -> doPut(req, resp);
            case "/product/delete" -> doDelete(req, resp);
            default -> resp.sendRedirect(req.getContextPath() + "/products");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long id = Long.parseLong(req.getParameter("id"));
            ProductDTO productDTO = constructProductDTO(req);
            productDTO.setId(id);
            if (this.productService.update(productDTO))
                req.getSession().setAttribute("success", "Product updated successfully");
            else
                req.getSession().setAttribute("error", "Product not updated");
        } catch (CategoryNotFoundException | NumberFormatException e) {
            req.getSession().setAttribute("error", e.getMessage());
        }
        resp.sendRedirect(req.getContextPath() + "/products");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (this.productService.delete(this.productService.findById(Long.parseLong(req.getParameter("id")))))
                req.getSession().setAttribute("success", "Product deleted successfully");
            else
                req.getSession().setAttribute("error", "Product not deleted");
        } catch (ProductNotFoundException | NumberFormatException e) {
            req.getSession().setAttribute("error", e.getMessage());
        }
        resp.sendRedirect(req.getContextPath() + "/products");
    }

    private ProductDTO constructProductDTO(HttpServletRequest req) throws CategoryNotFoundException, NumberFormatException {
        String name = req.getParameter("name");
        Long categoryId = Long.parseLong(req.getParameter("category"));
        String description = req.getParameter("description");
        String photo = req.getParameter("photo");
        float price = Float.parseFloat(req.getParameter("price"));
        int stock = Integer.parseInt(req.getParameter("stock"));
        return new ProductDTO(name, new CategoryService().findById(categoryId), description, photo, price, stock);
    }

}
