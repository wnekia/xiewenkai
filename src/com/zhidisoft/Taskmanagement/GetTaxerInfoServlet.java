package com.zhidisoft.Taskmanagement;

import com.zhidisoft.LoginMysql.Enter;
import com.zhidisoft.entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/getTaxerInfoServlet.do")
public class GetTaxerInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enter en = new Enter();
        int id = Integer.parseInt(req.getParameter("id"));
        TaxOrgan taxOrgan = null;
        Taxer  taxer  =null;
        try {
            taxer = en.selectByIDTaxer(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Integer organId = taxer.getOrganId();
        try {
            taxOrgan = en.selectByIDOrgan(organId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("organ", taxOrgan);
        req.setAttribute("taxer",taxer);

        req.getRequestDispatcher("/manage/jsp/taxerInfo.jsp").forward(req, resp);

    }
}
