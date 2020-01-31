package com.accolite.sahil.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.accolite.sahil.dao.EmployeeDao;
import com.accolite.sahil.model.EmployeeModel;



@Controller

public class EmployeeController {
	
	 @Autowired
	private EmployeeDao employeeDao;
	
	@RequestMapping(value ="/enroll",method = RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		EmployeeModel emp = new EmployeeModel();
		model.addAttribute("emp", emp);
		return "enroll";
	}
	
	@RequestMapping(value ="/save",method = RequestMethod.POST)
	public String saveRegistration(@Valid EmployeeModel emp,
			BindingResult result, ModelMap model,RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "enroll";//will redirect to viewemp request mapping  
		}
		employeeDao.save(emp);		
		//redirectAttributes.addFlashAttribute("message", "Student " + student.getFirstName()+" "+student.getLastName() + " saved");
		return "redirect:/viewemployee";//will redirect to viewemp request mapping  
	}

	@RequestMapping("/viewemployee")  
    public ModelAndView viewstudents(){  
        List<EmployeeModel> list=employeeDao.getAllEmployeeModels();
        return new ModelAndView("viewemployee","list",list);  
    } 
	
	
//	/* It opens the record for the given id in editstudent page */
	 @RequestMapping(value="/editemp/{id}")  
	    public String edit(@PathVariable int id,ModelMap model){  
		 EmployeeModel emp=employeeDao.getStudentById(id);  
	       model.addAttribute("emp", emp);
			return "editemp";
	    } 
//	 
	 /* It updates record for the given id in editstudent page and redirects to /viewstudents */  
	 @RequestMapping(value="/editsave",method = RequestMethod.POST)  
	    public ModelAndView editsave(@ModelAttribute("emp") EmployeeModel emp){  
	    	System.out.println("id is"+emp.getId());
	    	employeeDao.update(emp);  
	        return new ModelAndView("redirect:/viewemployee");  
	    }  
//	 
	 /* It deletes record for the given id  and redirects to /viewstudents */  
	    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)  
	    public ModelAndView delete(@PathVariable int id){  
	    	employeeDao.delete(id);  
	        return new ModelAndView("redirect:/viewemployee");  
	    }  
//	    
	    /* It deletes record for the given id  and redirects to /viewstudents */  
	    @RequestMapping(value="/delete",method = RequestMethod.GET)  
	    public ModelAndView delete(){  
	    	employeeDao.delete();  
	        return new ModelAndView("redirect:/enroll");  
	    }  

}


