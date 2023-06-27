package employee.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import employee.dto.Employee;

@Repository
public class EmployeeDao {
	
	@Autowired
	private EntityManager entitymanager;
	
	public void saveEmployee(Employee employee) {
		entitymanager.getTransaction().begin();
		entitymanager.persist(employee);
		entitymanager.getTransaction().commit();
		
	}
	
	public List<Employee> getAllEmployees(){
		Query query= entitymanager.createQuery("select e from Employee e");
		List<Employee> employees = query.getResultList();
		return employees;
	}
	
	public Employee findEmployee(int id) {
		Employee e = entitymanager.find(Employee.class,id);
		return e;
	}
	
	public void deleteEmployee(int id) {
		Employee e = findEmployee(id);
		
		if(e!=null) {
			entitymanager.getTransaction().begin();
			entitymanager.remove(e);
			entitymanager.getTransaction().commit();
		}		
	}
	
	public void updateEmployee(int id,Employee e) {
		Employee exiemp = findEmployee(id);
		if(exiemp!=null) {
			e.setId(id);
			entitymanager.getTransaction().begin();
			entitymanager.merge(e);
			entitymanager.getTransaction().commit();
		}
	}
	
	public List<Employee> allemployees(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("amit");
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select e from Employee e");
		List<Employee> ems = q.getResultList();
		return ems;
	}
}
