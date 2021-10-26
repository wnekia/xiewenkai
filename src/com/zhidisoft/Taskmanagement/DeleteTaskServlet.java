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
import java.util.Map;

@WebServlet(urlPatterns = "/deleteTaskServlet.do")
public class DeleteTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Dao  dao = new Dao();
        PrintWriter out = resp.getWriter();
        int  id = Integer.parseInt(req.getParameter("id"));
        Map<String,Object> m=new HashMap<>();
        boolean b = dao.deleteSource(id);
        if (b){
            m.put("success",true);
            m.put("msg","删除成功");
        }else {
            m.put("success",false);
            m.put("msg","删除失败");
        }
        out.write(JSONObject.fromObject(m).toString());
        out.flush();
        out.close();
        req.getRequestDispatcher("/manage/jsp/.jsp").forward(req,resp);
    }
}