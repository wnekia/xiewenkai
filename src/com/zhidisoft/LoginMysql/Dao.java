package com.zhidisoft.LoginMysql;

import com.zhidisoft.entity.TaxPayer;
import com.zhidisoft.entity.TaxSource;
import com.zhidisoft.entity.Taxer;
import com.zhidisoft.util.DBUtil;
import org.apache.commons.beanutils.BeanUtils;

import java.util.List;
import java.util.Map;

public class Dao {
    public List<Map<String, String>> SelectLimitSource(int pageNum, int pagesize  ) throws Exception {
        String sql = "select a.id,a.taskName,b.payerCode,b.payerName,c.industryName,b.bizScope,a.executeTime," +
                "a.recordTaskDate, IFNULL(timestampdiff(day,executeTime,recordTaskDate),0) as timeOut from" +
                " tb_tax_source a,tb_tax_payer b,tb_industry c,tb_tax_organ d where a.payerId=b.id and b.industryId=c.id" +
                " and b.taxOrganId=d.id and a.removeState!=1 ";
//        if (payerCode!=null){
//            sql = sql + " and b.payerCode= " + payerCode;
//        }
//        if (payerName!=null){
//            sql = sql + " and b.payerName= " + payerName;
//        }
        sql = sql + "limit ?,?";
        List<Map<String, String>> list = DBUtil.query(sql, (pageNum - 1) * pagesize, pagesize);
        return list;
    }
    public List<Map<String, String>> SelectLimitSourceNull(int pageNum, int pagesize  ) throws Exception {
        String sql = "SELECT * FROM  tb_tax_source s LEFT JOIN tb_tax_payer r ON  s.payerId = r.id  LEFT JOIN " +
                "tb_industry y ON r.industryId = y.id LEFT JOIN tb_tax_organ n ON r.taxOrganId = n.id  " +
                "LEFT JOIN tb_taxer e ON n.recordUserId = e.id WHERE s.idea = 0 ";
//        if (payerCode!=null){
//            sql = sql + " and b.payerCode= " + payerCode;
//        }
//        if (payerName!=null){
//            sql = sql + " and b.payerName= " + payerName;
//        }
        sql = sql + "limit ?,?";
        List<Map<String, String>> list = DBUtil.query(sql, (pageNum - 1) * pagesize, pagesize);
        return list;
    }
    public int selectAll(){
        String sql = "select * from tb_tax_source";
        List<Map<String, String>> query = DBUtil.query(sql);
        int size = query.size();
        return size;
    }
    public TaxSource selectByIDTaxSourceDao(int id) throws Exception {
        String sql = "select * from tb_tax_source where id=?";
        List<Map<String, String>> list = DBUtil.query(sql, id);
        TaxSource user = null;
        for (Map<String, String> map : list) {
            user = new TaxSource();
            BeanUtils.populate(user, map);
        }
        return user;
    }
    public boolean  deleteSource(int id) {
        String sql = "delete from tb_tax_source where id=?";
        boolean b = DBUtil.update(sql, id);
        return b;
    }
    public TaxPayer selectTaxpayer(String id) throws Exception {
        String sql = "select * from tb_tax_payer where payerCode=?";
        List<Map<String, String>> list = DBUtil.query(sql, id);
        TaxPayer user = null;
        for (Map<String, String> map : list) {
            user = new TaxPayer();
            BeanUtils.populate(user, map);
        }
        return user;
    }
    public List<Map<String, String>> SelectLimitSourceF(int pageNum, int pagesize ,String name) throws Exception {
        String sql = "select * from tb_taxer ";
        if (name!=null){
            sql=sql+"where taxerName like '%"+name+"%' ";
        }
        sql = sql + " limit ?,?";
        List<Map<String, String>> list = DBUtil.query(sql, (pageNum - 1) * pagesize, pagesize);
        return list;
    }
    public boolean  deleteTaxer(int id) {
        String sql = "delete from tb_taxer where id=?";
        boolean b = DBUtil.update(sql, id);
        return b;
    }
    public static boolean updateTaxer(Taxer taxer, Integer id) {
        int rows = DBUtil.edit(taxer, "tb_taxer", id);
        return rows==1;
    }
    public static boolean addTaxer(Taxer taxer ){
        int row = DBUtil.add(taxer,"tb_taxer");
        return row==1;
    }
    public boolean updateUser(String password, int id) {
        String sql = "update tb_user set password=? where id=?";
        String[] ss = {password, String.valueOf(id)};
        boolean update = DBUtil.update(sql, ss);
        return update;
    }
}
