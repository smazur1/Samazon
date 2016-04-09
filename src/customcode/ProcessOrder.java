package customcode;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.DBUtil;
import model.Samazonorder;


public class ProcessOrder {

	public ProcessOrder() {
		// TODO Auto-generated constructor stub
	}


	public static long getNewOrderId() {

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select (max(s.orderid) + 1) from Samazonorder s";


		Query q = em.createQuery(qString, model.Samazonorder.class);
		long newId = 0;

		try {
			//		trans.begin();
			newId = (long) q.getSingleResult();
			//			trans.commit();

		} catch (Exception e) {
			System.out.println(e);
			//			trans.rollback();
		} finally {

			em.close();
			System.out.println("Finished");
			return newId;
		}
	}

	
	public static long getNewCartId() {

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select (max(s.cartid) + 1) from Samazonorder s";


		Query q = em.createQuery(qString, model.Samazonorder.class);
		long newId = 0;

		try {
			//		trans.begin();
			newId = (long) q.getSingleResult();
			//			trans.commit();

		} catch (Exception e) {
			System.out.println(e);
			//			trans.rollback();
		} finally {

			em.close();
			System.out.println("Finished");
			return newId;
		}
	}
	
	public static void insertSamazonOrder(long _orderid, long _cartid, long _userid, long _productcode,
			String _productname, double _price) {
		//
		

		Samazonorder so = new Samazonorder();
			
		
					
		so.setOrderid(_orderid);			
		so.setCartid(_cartid);
		so.setUserid(_userid);
		so.setProductcode(_productcode);
		so.setProductname(_productname);
		so.setPrice(_price);
		
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();


		int count = 0;

		try {
			trans.begin();
			em.persist(so);

			trans.commit();

		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {

			em.close();
			System.out.println("Finished");

		}

	}
	
	
	
}
