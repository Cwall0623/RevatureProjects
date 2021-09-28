package daos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import models.Reimbursement;
import utils.ConnectionFactory;
import utils.HibernateSessionFactory;



public class ReimbursementDAO implements Dao <Reimbursement>{
	Connection connection;
	List<Reimbursement> reimbursementList;
	
	
	public ReimbursementDAO(Connection conn) {
		connection = conn;
		reimbursementList = new LinkedList();
	}
	
	public ReimbursementDAO() {
		 super();
	 }
	
	public List <Reimbursement> findByCrewNumber(int crewNumber) {
		List<Reimbursement> 
		retrievedReimbursement = null;
		
		Session s = null;
		Transaction tx = null;
		try {
			s=HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			String sql = "SELECT * FROM reinbursement  WHERE crewMember_crew_number = :crewNumber";
			
			retrievedReimbursement = s.createNativeQuery(sql,Reimbursement.class)
			.addEntity("reinbursement",Reimbursement.class).setParameter("crewNumber", crewNumber)
			.getResultList();
			
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
		finally {
			s.close();
		}
		return retrievedReimbursement;
	}
	
	
	
	public Reimbursement get(int caseNumber) throws SQLException{
		String sql = "SELECT * FROM reinbursement WHERE case_number = ?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, caseNumber);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			Reimbursement row = new Reimbursement();
			row.setCaseNumber(rs.getInt(1));
			row.setDescription(rs.getString(2));
			row.setAmount(rs.getDouble(3));
			row.setStatus(rs.getString(4));
			
			return row;
		}
		return null;
	}

	public void initializeReimbursementEmployeeForCreatingRE(Reimbursement a, int crewNumber) throws SQLException{
		String sql = "INSERT INTO reinbursement_employee (case_number,crew_number) VALUES (?,?)";
		ConnectionFactory.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, a.getCaseNumber());
		pstmt.setInt(2, crewNumber);
		pstmt.executeUpdate();
	}
	
	
	public Reimbursement createReimbursement(Reimbursement a, int caseNumber) throws SQLException{
		
	
		
		String sql2 = "INSERT into reinbursement (case_number, description, balance, status) VALUES (?,?,?,?)";
		PreparedStatement pstmt2 = connection.prepareStatement(sql2);
		pstmt2.setInt(1, a.getCaseNumber());
		pstmt2.setString(2, a.getDescription());
		pstmt2.setDouble(3, a.getAmount());
		pstmt2.setString(4, a.getStatus());
		
		if(pstmt2.executeUpdate() > 0 ) {
			List<Reimbursement> reimbursementList = getAll();
			Reimbursement temp = reimbursementList.get(reimbursementList.size() -1);
			return temp;
		}else {
	}	
	return null;
	
}
	

	
	
	
	public List<Reimbursement> getAll(int crewNumber)throws SQLException {
		
		String sql = "SELECT * FROM reinbursement WHERE crewMember_crew_number = ?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, crewNumber);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
	        Reimbursement reimbursementRow = new Reimbursement(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4));
	        reimbursementList.add(reimbursementRow);
	        
	        }
	        return reimbursementList;
			
		
	}


	
	public List<Reimbursement> findAll(){
		List<Reimbursement> reimbursement = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			reimbursement =s.createQuery("FROM Reimbursement", Reimbursement.class).getResultList();		
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
		return reimbursement;
	}
		
		
	

	@Override
	public void update(Reimbursement a) throws SQLException {
		String sql = "UPDATE reinbursement SET status = ? WHERE case_number = ?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, a.getStatus());
		pstmt.setInt(2, a.getCaseNumber());
		
		pstmt.executeUpdate();
		
	}

	public void deleteReinbursement_Employee(Reimbursement a) throws SQLException {
		String sql = "DELETE FROM reinbursement_employee WHERE case_number = ?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, a.getCaseNumber());
		pstmt.executeUpdate();
		
	}

	@Override
	public void delete(Reimbursement a) throws SQLException {
		String sql = "DELETE FROM reinbursement WHERE case_number = ? LIMIT 1";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, a.getCaseNumber());
		pstmt.executeUpdate();
		
	}

	@Override
	public void save(Reimbursement reimbursement) throws SQLException  {
		
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.save(reimbursement);
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		
	}

	@Override
	public List<Reimbursement> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}	
