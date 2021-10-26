package com.zhidisoft.Taskmanagement;

import com.zhidisoft.LoginMysql.Dao;
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

@WebServlet(urlPatterns = "/listTaxerServlet.do")
public class listTaxerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Dao dao = new Dao();
        PrintWriter out = resp.getWriter();
        int page = Integer.parseInt(req.getParameter("page"));
        int rows = Integer.parseInt(req.getParameter("rows"));
        String taxerName = req.getParameter("taxerName");
        List<Map<String, String>> maps = null;
        try {
            maps = dao.SelectLimitSourceF(page, rows,taxerName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        int size = maps.size();
        Map  map = new HashMap();
        map.put("total",size);
        map.put("rows",maps);
        out.write(JSONObject.fromObject(map).toString());
    }
}
