package com.accolite.sahil.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.accolite.sahil.model.EmployeeModel;

public class EmployeeDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public void save(EmployeeModel p) {

//String sql="insert into world.EmployeeModel(firstName,lastName,sex,dob,email,section,country,firstAttempt,subjects) values('"+p.getFirstName()+"','"+p.getLastName()+"','"+p.getSex()+"','"+p.getDob()+"','"+p.getEmail()+"','"+p.isFirstAttempt()+"','"+p.getCountry()+"',true,'"+convertListToDelimitedString(p.getSubjects())+"')"; 

		String sql = "insert into employee values('" + p.getId() + "','" + p.getFirstname() + "','" + p.getLastname()
				+ "','" + p.getPhno() + "')";
		System.out.println(sql);
		template.update(sql);
	}
	
    @Test
	public List<EmployeeModel> getAllEmployeeModels() {
        String checkname = "sahil";
		return template.query("select * from employee", new ResultSetExtractor<List<EmployeeModel>>() {

			public List<EmployeeModel> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<EmployeeModel> list = new ArrayList<EmployeeModel>();
				while (rs.next()) {
					EmployeeModel e = new EmployeeModel();
					e.setId(rs.getInt(1));
					e.setFirstname(rs.getString(2));
					assertEquals(checkname, rs.getString(2));
					e.setLastname(rs.getString(3));
					e.setPhno(rs.getString(4));
					list.add(e);
				}
				return list;
			}
		});

	}
  
	public EmployeeModel getStudentById(int id) {
		// TODO Auto-generated methoString checkname="sahil";
		return template.query("select * from employee where ID=" + id, new ResultSetExtractor<EmployeeModel>() {

			public EmployeeModel extractData(ResultSet rs) throws SQLException, DataAccessException {

				EmployeeModel e = new EmployeeModel();
				while (rs.next()) {

					e.setId(rs.getInt(1));
					e.setFirstname(rs.getString(2));
					e.setLastname(rs.getString(3));
				}
				return e;
			}
		});
	}

	
	 public void update(EmployeeModel p) {
		 
    String sql="update employee set id='"+p.getId()+"',firstname='"+p.getFirstname()+"',lastname='"+p.getLastname()+"',phno='"+p.getPhno()+"' where Id="+p.getId()+"";
    System.out.println(sql); 
    template.update(sql);
	 }
	 
	@Test 
	public void delete(int id) {
		// TODO Auto-generated method stub
		
		String sql = "delete from employee where ID=" + id + "";
		template.update(sql);

	}

	public void delete() {
		// TODO Auto-generated method stub
		String sql = "delete from employee where ID>0";
		template.update(sql);
	}
}