package com.zhidisoft.Taskmanagement;

import com.zhidisoft.LoginMysql.Enter;
import com.zhidisoft.entity.Industry;
import com.zhidisoft.entity.TaxOrgan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/SearchTaskServlet.do")
public class SearchTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enter en = new Enter();
        try {
            List<TaxOrgan> taxOrgans = en.selectallOrgan();
            req.setAttribute("organs",taxOrgans);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            List<Industry> industries = en.selectallIndustry();
            req.setAttribute("industrys",industries);
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/manage/jsp/searchTask.jsp").forward(req,resp);
    }
}
