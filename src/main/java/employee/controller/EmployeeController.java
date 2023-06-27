package employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import employee.dao.EmployeeDao;
import employee.dto.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeDao dao;
	
	@RequestMapping("/reg")
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("register.jsp");
		modelAndView.addObject("employee",new Employee());
		return modelAndView;
	}
	
	@RequestMapping("/save")
	public ModelAndView save(@ModelAttribute Employee e) {
		ModelAndView modelAndView = new ModelAndView();
		if(e.getId()!=0) {
			dao.saveEmployee(e);
			List<Employee> employees = dao.getAllEmployees();
			modelAndView.addObject("employees", employees);
			modelAndView.setViewName("display.jsp");
			return modelAndView;
		}else {
			List<Employee> employees = dao.getAllEmployees();
			modelAndView.addObject("employees", employees);
			modelAndView.setViewName("display.jsp");
			return modelAndView;
		}
	}
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam int id) {
		dao.deleteEmployee(id);
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.setViewName("display.jsp");
		List<Employee> employees = dao.getAllEmployees();
		modelAndView.addObject("employees",employees);
		return modelAndView;
		
	}
	@RequestMapping("/edit")
	public ModelAndView updateEmployee(@RequestParam int id) {
		Employee e = dao.findEmployee(id);
		ModelAndView andView = new ModelAndView();
		andView.setViewName("edit.jsp");
		andView.addObject("employee", e);
		return andView;
	}
	@RequestMapping("/update")
	public ModelAndView updateEmployee(@ModelAttribute Employee e) {
		ModelAndView andView = new ModelAndView();
		dao.updateEmployee(e.getId(), e);
		List<Employee> emps = dao.getAllEmployees();
		andView.setViewName("display.jsp");
		andView.addObject("employees", emps);
		return andView;
	}

}