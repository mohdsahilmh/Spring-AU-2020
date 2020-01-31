package com.accolite.sahil.dao;

import static org.junit.Assert.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import static org.mockito.Mockito.when;
import com.accolite.sahil.model.EmployeeModel;
@RunWith(MockitoJUnitRunner.class)
public class EmployeeDaoTest {
	
     @Mock
     EmployeeDao employeedao;
     
     @Test
     public void emptest() {
    	 List<EmployeeModel> emplist = new ArrayList<>();
    	 EmployeeModel e = new EmployeeModel();
    	 e.setId(12);
    	 e.setFirstname("mohammed");
         e.setLastname("sahil");
         e.setPhno("878788988989");
    	 emplist.add(e);
    	 when(employeedao.getAllEmployeeModels()).thenReturn(emplist);
 		
 		Assert.assertEquals(employeedao.getAllEmployeeModels(),emplist);
     }
      
     
	}

