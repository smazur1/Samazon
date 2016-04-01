package customcode;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.DBUtil;
import model.Product;

public class ProcessProducts {

	public static List<Product> getAllProducts() {
		//
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select p from Product p";
		TypedQuery<Product> q = em.createQuery(qString, model.Product.class);

		List<Product> products = null;

		try {

			products = q.getResultList();
			if (products == null || products.isEmpty())
				products = null;

		} catch (Exception e) {
			System.out.println(e);
		} finally {

			em.close();
			System.out.println("Finished");
			return products;
		}

	}

	public static List<Product> getProductByCode(int _productcode) {
		//
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select p from Product p where p.productcode = :productcode";
		TypedQuery<Product> q = em.createQuery(qString, model.Product.class);
		q.setParameter("productcode", _productcode);

		List<Product> products = null;

		try {

			products = q.getResultList();
			if (products == null || products.isEmpty())
				products = null;

		} catch (Exception e) {
			System.out.println(e);
		} finally {

			em.close();
			System.out.println("Finished");
			return products;
		}
	}

	public static Product getSingleProductByCode(int _productcode) {
		//
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select p from Product p where p.productcode = :productcode";
		TypedQuery<Product> q = em.createQuery(qString, model.Product.class);
		q.setParameter("productcode", _productcode);
		Product product = null;
		List<Product> products = null;

		try {

			products = q.getResultList();
			product = products.get(0);
			if (products == null || products.isEmpty())
				products = null;
			product = null;

		} catch (Exception e) {
			System.out.println(e);
		} finally {

			em.close();
			System.out.println("Finished");
			return product;
		}

	}

	public static int updateGrade(int _id, int _grade) {
		//
		Date today = new Date();
		System.out.println("today " + today);
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		String qString = "Update Product s set s.assigndate = :assigndate, "
				+ "s.grade = :grade " + "where s.id = :id";
		TypedQuery<Product> q = em.createQuery(qString, model.Product.class);
		q.setParameter("assigndate", today);
		q.setParameter("grade", _grade);
		q.setParameter("id", _id);
		int count = 0;

		try {
			trans.begin();
			count = q.executeUpdate();
			trans.commit();

		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {

			em.close();
			System.out.println("Finished");
			return count;
		}

	}

}
