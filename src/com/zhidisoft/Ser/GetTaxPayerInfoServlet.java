package com.zhidisoft.Ser;

import com.zhidisoft.LoginMysql.Enter;
import com.zhidisoft.entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/getTaxPayerInfoServlet.do")
public class GetTaxPayerInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enter en = new Enter();
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        TaxPayer taxPayer = null;
        TaxOrgan taxOrgan = null;
        TaxSource taxSource = null;
        Industry industry = null;
        Taxer  taxer  =null;
        try {
            taxPayer = en.selectByIDtaxpayer(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Integer industryId = taxPayer.getIndustryId();
        Integer taxOrganId = taxPayer.getTaxOrganId();

        try {
            taxSource = en.selectByIDTaxSource(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            taxOrgan = en.selectByIDOrgan(taxOrganId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Integer recordUserId = taxOrgan.getRecordUserId();
        try {
             taxer = en.selectByIDTaxer(recordUserId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            industry = en.selectByIDIndustry(industryId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object username = req.getSession().getAttribute("username");
        req.setAttribute("payer", taxPayer);
        req.setAttribute("organ", taxOrgan);
        req.setAttribute("subOrgan", taxOrgan);
        req.setAttribute("industry", industry);
        req.setAttribute("task", taxSource);
        req.setAttribute("user",username);
        req.setAttribute("approverTaxer",taxer);
        req.setAttribute("executeTaxer",taxer);
        req.getRequestDispatcher("/manage/jsp/taskInfo.jsp").forward(req, resp);

    }
}
