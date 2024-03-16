package ma.fstm.ilisi.zstore.backoffice.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.fstm.ilisi.zstore.backoffice.service.ClientService;

import java.io.IOException;

public class ClientController extends HttpServlet {
    private ClientService clientService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.clientService = new ClientService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getServletPath()) {
            case "/clients" -> {
                req.setAttribute("clients", this.clientService.retrieve());
                req.getRequestDispatcher("/clients.jsp").forward(req, resp);
            }
            case "/client/new" -> {
                req.getRequestDispatcher("/clientForm.jsp").forward(req, resp);
            }
            case "/client/edit" -> {
                try {
                    req.setAttribute("client", this.clientService.findById(Long.parseLong(req.getParameter("id"))));
                    req.getRequestDispatcher("/clientForm.jsp").forward(req, resp);
                } catch (NumberFormatException e) {
                    req.getSession().setAttribute("error", e.getMessage());
                    resp.sendRedirect(req.getContextPath() + "/clients");
                }
            }
            default -> resp.sendRedirect(req.getContextPath() + "/clients");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }


}
