package com.zhidisoft.Ser;

import com.zhidisoft.LoginMysql.Enter;
import com.zhidisoft.entity.TaxPayer;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/editTaxPayerServlet.do")
public class EditTaxPayerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Enter en=new Enter();
        TaxPayer payer=null;
        try {
             payer = (TaxPayer) en.selectByIDtaxpayer(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("payer",payer);
      req.getRequestDispatcher("/manage/jsp/editTaxPayer.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enter en=new Enter();
        int id = Integer.parseInt(req.getParameter("id"));
        String payerCode = req.getParameter("payerCode");
        String payerName = req.getParameter("payerName");
        String legalPerson = req.getParameter("legalPerson");
        String legalIdCard = req.getParameter("legalIdCard");
        String finaceName = req.getParameter("finaceName");
        String finaceIdCard = req.getParameter("finaceIdCard");
        String recordDate = req.getParameter("recordDate");
        TaxPayer tp=new TaxPayer(payerCode,payerName,legalPerson,legalIdCard,finaceName, finaceIdCard,recordDate);
        boolean b = en.updatetaxpayer(tp,id);
        Map<String,Object> m=new HashMap<>();
        PrintWriter out = resp.getWriter();
           if (b){
               m.put("success",true);
               m.put("msg","修改成功");
           }else {
               m.put("success",false);
               m.put("msg","修改失败");
           }
        out.write(JSONObject.fromObject(m).toString());
        out.flush();
        out.close();
        req.getRequestDispatcher("/manage/jsp/listTaxer.jsp").forward(req,resp);
    }
}
