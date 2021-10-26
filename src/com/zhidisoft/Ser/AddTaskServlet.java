package com.zhidisoft.Ser;

import com.zhidisoft.LoginMysql.Enter;
import com.zhidisoft.entity.TaxOrgan;
import com.zhidisoft.entity.TaxPayer;
import com.zhidisoft.entity.TaxSource;
import com.zhidisoft.entity.Taxer;
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

@WebServlet(urlPatterns = "/addTaskServlet.do")
public class AddTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Enter en=new Enter();
        TaxPayer payer=null;
        try {
            List<Taxer> taxers = en.selectalltaxer();
            List<TaxOrgan> organs = en.selectallOrgan();
            req.setAttribute("organs",organs);
            req.setAttribute("taxers",taxers);
            payer = (TaxPayer) en.selectByIDtaxpayer(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("payer",payer);
        req.getRequestDispatcher("/manage/jsp/addTask.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enter en=new Enter();
        int  payerId = Integer.parseInt(req.getParameter("payerId"));
        String taskName = req.getParameter("taskName");
       int  subOrganId = Integer.parseInt(req.getParameter("subOrganId"));
        int approverId = Integer.parseInt(req.getParameter("approverId"));
       int  executeId = Integer.parseInt(req.getParameter("executeId"));
        String executeTime = req.getParameter("executeTime");
        String taskState = req.getParameter("taskState");
        TaxSource ts=new TaxSource(payerId,taskName,subOrganId,approverId,executeId,executeTime,taskState);

        boolean b = en.inserttaxpayer(ts);
        Map<String,Object> m=new HashMap<>();
        PrintWriter out = resp.getWriter();
        if (b){
            m.put("success",true);
            m.put("msg","添加成功");
        }else {
            m.put("success",false);
            m.put("msg","添加失败");
        }
        out.write(JSONObject.fromObject(m).toString());
        out.flush();
        out.close();
        req.getRequestDispatcher("/manage/jsp/listTaxer.jsp").forward(req,resp);

    }
}
