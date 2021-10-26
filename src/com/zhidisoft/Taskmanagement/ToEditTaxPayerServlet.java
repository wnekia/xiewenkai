package com.zhidisoft.Taskmanagement;

import com.zhidisoft.LoginMysql.Enter;
import com.zhidisoft.entity.TaxOrgan;
import com.zhidisoft.entity.Taxer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/toEditTaxPayerServlet.do")
public class ToEditTaxPayerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enter en = new Enter();
        int id = Integer.parseInt(req.getParameter("id"));
        Taxer   taxer = null;
        try {
            taxer = en.selectByIDTaxer(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            List<TaxOrgan> taxOrgans = en.selectallOrgan();
            req.setAttribute("organs", taxOrgans);
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("taxer", taxer);
        req.getRequestDispatcher("/manage/jsp/editTaxer.jsp").forward(req,
                resp);
    }
}
