package customcode;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.DBUtil;


public class ProcessUser {

	public static long getUser(String _username, String _password) {
		//
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select count(u) from Samazonuser u "
				+ "where u.username = :username and u.userpassword = :userpassword";
		
		Query q = em.createQuery(qString, model.Samazonuser.class);
		
		q.setParameter("username", _username);
		q.setParameter("userpassword", _password);
        long count = 0;
		try {
		
		count = (long) q.getSingleResult();
		
System.out.println("count = " + count);		
		
		
		

		

		

			
		} catch (Exception e) {
			System.out.println(e);
		} finally {

			em.close();
			System.out.println("Finished");
			return count;
		}

	}
	
	
}
