package com.zhidisoft.Ser;

import com.zhidisoft.LoginMysql.Enter;
import com.zhidisoft.entity.Industry;
import com.zhidisoft.entity.TaxOrgan;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/toAddTaxPayerServlet.do")
public class ToAddTaxPayerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enter en =new Enter();
        try {
            List<Industry> industries = en.selectallIndustry();
            System.out.println(industries.toString());
            req.setAttribute("industrys",industries);
            List<TaxOrgan> taxOrgans = en.selectallOrgan();
            System.out.println(taxOrgans.toString());
            req.setAttribute("organs",taxOrgans);

        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/manage/jsp/addTaxPayer.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String payerCode = req.getParameter("payerCode");
        String payerName = req.getParameter("payerName");
        String bizAddressPhone = req.getParameter("bizAddressPhone");
        int taxOrganId = Integer.parseInt(req.getParameter("taxOrganId"));
        int industryId = Integer.parseInt(req.getParameter("industryId"));
        String bizScope = req.getParameter("bizScope");
        String invoiceType = req.getParameter("invoiceType");
        String bizAddress = req.getParameter("bizAddress");
        String legalPerson = req.getParameter("legalPerson");
        String legalIdCard = req.getParameter("legalIdCard");
        String finaceName = req.getParameter("finaceName");
        String finaceIdCard = req.getParameter("finaceIdCard");
        String recordDate = req.getParameter("recordDate");
        Enter tpd=new Enter();
        boolean aa= tpd.selectaddbyall(payerCode,payerName,bizAddressPhone,bizAddress,taxOrganId,industryId,bizScope,invoiceType,legalPerson,legalIdCard,finaceName,finaceIdCard,recordDate);
        PrintWriter writer = resp.getWriter();
        JSONObject jo=new JSONObject();
        if (aa){
            jo.put("success",true);
            jo.put("msg","添加成功");
        }else {
            jo.put("success",false);
            jo.put("msg","添加失败");
        }
        writer.write(jo.toString());
        writer.flush();
        writer.close();
    }
}
