package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import io.javalin.http.Context;
import models.Employee;
import utils.HibernateSessionFactory;

public class EmployeeDAO implements Dao<Employee>{
	Connection connection;
	List<Employee> employeeList = new LinkedList<>();
	
	
	
	public EmployeeDAO(Connection conn) {
		connection = conn;
	}

	public EmployeeDAO() {
		super();
	}
	@Override
	public Employee get(int crewNumber) throws SQLException{
		String sql = "SELECT * FROM employee WHERE crew_number = ?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, crewNumber);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			Employee row = new Employee();
			row.setCrewNumber(rs.getInt(1));
			row.setCrewEmail(rs.getString(2));
			row.setPassword(rs.getString(3));
			row.setManager(rs.getString(4));
			
			return row;
			
		}
			return null;
	}
	
	
	public Employee findUser(String crewEmail, String password) {
		Session session = null;
		Transaction tx = null;
		
		Employee retrievedEmployee = null;
		
		try {
			System.out.println(crewEmail);
			System.out.println(password);
			
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			
			CriteriaBuilder cb = session.getCriteriaBuilder();
			
			CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
			
			Root<Employee> root = cq.from(Employee.class);
			
			cq.select(root).where(cb.equal(root.get("crewEmail"), crewEmail));
			
			Query<Employee> query = session.createQuery(cq);
			
			retrievedEmployee = query.uniqueResult();
			
			tx.commit();
			
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			session.close();
		}
		return retrievedEmployee;
	}
		
	
	
	

	@Override
	public List<Employee> getAll() throws SQLException {
		String sql = "SELECT * FROM employee";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Employee employeeRow = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4));
			employeeList.add(employeeRow);
		}
		
		
		
		return employeeList;
	}

	
	
	
	
	
	
	
	
	@Override
	public void save(Employee t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Employee t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Employee t) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
	

