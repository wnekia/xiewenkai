package com.zhidisoft.Taskmanagement;

import com.zhidisoft.LoginMysql.Dao;
import com.zhidisoft.LoginMysql.Enter;
import com.zhidisoft.entity.Industry;
import com.zhidisoft.entity.TaxOrgan;
import com.zhidisoft.entity.TaxPayer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/toAddTaskServlet.do")
public class ToAddTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String payerCode = req.getParameter("payerCode");
       if (payerCode!=null){
           Dao dao = new Dao();
           Enter en = new Enter() ;
           TaxPayer taxPayer= null;
           try {
               taxPayer = dao.selectTaxpayer(payerCode);
               req.setAttribute("payer",taxPayer);
               Integer taxOrganId = taxPayer.getTaxOrganId();
               Integer industryId = taxPayer.getIndustryId();
               TaxOrgan taxOrgan = en.selectByIDOrgan(taxOrganId);
               Industry industry = en.selectByIDIndustry(industryId);
               req.setAttribute("organ",taxOrgan);
               req.setAttribute("industry",industry);
           } catch (Exception e) {
               e.printStackTrace();
           }
           req.getRequestDispatcher("/manage/jsp/addTask.jsp").forward(req, resp);
       }else {
           req.getRequestDispatcher("/manage/jsp/addTask.jsp").forward(req, resp);
       }
    }
}
