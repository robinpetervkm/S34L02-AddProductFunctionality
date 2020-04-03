package com.norha.app.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.norha.app.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> getProducts() {

		/* Getting session object from the Session Factory */
		Session currentSession = sessionFactory.getCurrentSession();

		/* Creating Query */
		Query<Product> theQuery = currentSession.createQuery("from products", Product.class);

		/* Getting List Of Products */
		List<Product> products = theQuery.getResultList();

		return products;
	}

	@Override
	public void addProduct(Product product) {

		/* Getting session object from the Session Factory */
		Session currentSession = sessionFactory.getCurrentSession();

		/* SaveOrUpdate Product to table */
		currentSession.saveOrUpdate(product);
	}

	@Override
	public Product getProduct(int id) {
		
		/* Getting session object from the Session Factory */
		Session currentSession = sessionFactory.getCurrentSession();
		
		/* Get a Product whos id is given*/
		Product product = currentSession.get(Product.class, id);
		
		return product;
	}

	@Override
	public void deleteProduct(int id) {
		/* Getting session object from the Session Factory */
		Session currentSession = sessionFactory.getCurrentSession();

		/* Creating Query */
		Query theQuery = currentSession.createQuery("delete from products where id=:productID");
		
		theQuery.setParameter("productID", id);
		
		theQuery.executeUpdate();
		
	}

}
