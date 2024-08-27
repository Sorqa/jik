package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //db다룰거임
public class EmpDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Emp> empList(){
        String sql = "SELECT * FROM emp";
        List<Emp> list = jdbcTemplate.query(sql, (rs,i)->{
            Emp emp = new Emp();
            emp.setEname(rs.getString("ENAME"));
            emp.setEmpno(rs.getInt("EMPNO"));
            emp.setSal(rs.getInt("SAL"));
            emp.setJob(rs.getString("JOB"));
            emp.setHiredate(rs.getString("HIREDATE"));
            return emp;
        });
        return list;
    }



}
