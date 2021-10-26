package com.zhidisoft.Taskmanagement;

import com.zhidisoft.LoginMysql.Dao;
import com.zhidisoft.util.EncryptUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/updatePassword.do")
public class UpdatePassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");
        int  id = (int)req.getSession().getAttribute("ID");
       // oldPassword= EncryptUtil.encryptMD5(oldPassword);
        newPassword= EncryptUtil.encryptMD5(newPassword);
        Dao dao =new Dao();
        boolean b = dao.updateUser(newPassword, id);
        PrintWriter out = resp.getWriter();
        JSONObject json = new JSONObject();
        if (b){
            json.put("success",true);
            json.put("msg","修改成功");
        }else {
            json.put("success",false);
            json.put("msg","修改失败");
        }
        out.write(JSONObject.fromObject(json).toString());
        out.flush();
        out.close();
    }
}
