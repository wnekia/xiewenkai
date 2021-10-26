package com.zhidisoft.Taskmanagement;

import com.zhidisoft.LoginMysql.Dao;
import com.zhidisoft.entity.Taxer;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(urlPatterns = "/editTaxerServlet.do")
public class EditTaxerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        JSONObject json = new JSONObject();
       // HttpSession session = req.getSession();
        Taxer taxer = new Taxer();
        String id = req.getParameter("sid");
      //  System.out.println(id);
        taxer.setId(Integer.parseInt(id));
        String taxerCode = req.getParameter("taxerCode");
        taxer.setTaxerCode(taxerCode);
        String taxerName = req.getParameter("taxerName");
        taxer.setTaxerName(taxerName);
        String mobile = req.getParameter("mobile");
        taxer.setMobile(mobile);
        String address = req.getParameter("address");
        taxer.setAddress(address);
        String sex = req.getParameter("sex");
        taxer.setSex(sex);
        String birthday = req.getParameter("birthday");
        if(StringUtils.isNotEmpty(birthday))
            taxer.setBirthday(birthday);
        String email = req.getParameter("email");
        taxer.setEmail(email);
        String organId = req.getParameter("organId");
        if ("-1".equals(organId)) {
            taxer.setOrganId(null);
        } else {
            taxer.setOrganId(Integer.parseInt(organId));
        }
        Date date = new Date();
        taxer.setRecordDate(FormatDate.format(date));
//        User user = (User) session.getAttribute("user");
//        taxer.setRecordUserId(user.getId());
        boolean b = Dao.updateTaxer(taxer, Integer.parseInt(id));
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
