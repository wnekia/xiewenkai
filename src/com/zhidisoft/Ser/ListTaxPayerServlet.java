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
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/listTaxPayerServlet.do")
public class ListTaxPayerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enter en=new Enter();
        String payerCode = req.getParameter("payerCode");
        //System.out.println(payerCode);
        String payerName = req.getParameter("payerName");
        int page = Integer.parseInt(req.getParameter("page"));
        int rows = Integer.parseInt(req.getParameter("rows"));
        List<Map<String, String>> list =null;
        List<TaxPayer> list1=null;
        try {
            list = en.selectlimittaxpayer(page, rows,payerCode,payerName);
            list1 = en.selectalltaxpayer();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String,Object> m=new HashMap<>();

        m.put("total",list1.size());
        m.put("rows",list);
        PrintWriter out = resp.getWriter();
        out.write(JSONObject.fromObject(m).toString());
        out.flush();
        out.close();
    }
}
