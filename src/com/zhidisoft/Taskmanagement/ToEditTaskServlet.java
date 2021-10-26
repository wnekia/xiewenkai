package com.zhidisoft.Taskmanagement;

import com.zhidisoft.LoginMysql.Dao;
import com.zhidisoft.LoginMysql.Enter;
import com.zhidisoft.entity.*;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/toEditTaskServlet.do")
public class ToEditTaskServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Dao dao = new Dao();
        TaxSource taxSource = null;
        TaxOrgan taxOrgan = null;
        Industry industry = null;
        Taxer taxer  =null;
        try {
            taxSource = dao.selectByIDTaxSourceDao(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Integer payerId = taxSource.getPayerId();
        Enter en = new Enter();
        TaxPayer payer = null;
        try {
            payer = en.selectByIDtaxpayer(payerId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Integer taxOrganId = payer.getTaxOrganId();
        Integer industryId = payer.getIndustryId();
        try {
            taxOrgan = en.selectByIDOrgan(taxOrganId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            industry = en.selectByIDIndustry(industryId);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        System.out.println(recordUserId);
        try {
            List<TaxOrgan> taxOrgans = en.selectallOrgan();
            req.setAttribute("organs", taxOrgans);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            List<Taxer> list = en.selectalltaxer();
            req.setAttribute("taxers",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Integer recordUserId = taxOrgan.getRecordUserId();
        try {
            taxer = en.selectByIDTaxer(recordUserId);
            req.setAttribute("user",taxer);
            //System.out.println(taxer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("subOrgan", taxOrgan);
        req.setAttribute("organ", taxOrgan);
        req.setAttribute("industry", industry);
        req.setAttribute("payer", payer);
        req.setAttribute("task", taxSource);

        req.getRequestDispatcher("/manage/jsp/editTask.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enter en = new Enter();
        int id = Integer.parseInt(req.getParameter("id"));
        String payerCode = req.getParameter("payerCode");
        String payerName = req.getParameter("payerName");
        String legalPerson = req.getParameter("legalPerson");
        String legalIdCard = req.getParameter("legalIdCard");
        String finaceName = req.getParameter("finaceName");
        String finaceIdCard = req.getParameter("finaceIdCard");
        String recordDate = req.getParameter("recordDate");
        TaxPayer tp = new TaxPayer(payerCode, payerName, legalPerson, legalIdCard, finaceName, finaceIdCard, recordDate);
        boolean b = en.updatetaxpayer(tp, id);
        Map<String, Object> m = new HashMap<>();
        PrintWriter out = resp.getWriter();
        if (b) {
            m.put("success", true);
            m.put("msg", "修改成功");
        } else {
            m.put("success", false);
            m.put("msg", "修改失败");
        }
        out.write(JSONObject.fromObject(m).toString());
        out.flush();
        out.close();
        req.getRequestDispatcher("/manage/jsp/listTaxer.jsp").forward(req, resp);
    }
}
