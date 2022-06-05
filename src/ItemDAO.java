//FILL YOUR CODE
import org.hibernate.SessionFactory;

import java.util.List;

import org.hibernate.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
public class ItemDAO {
	private SessionFactory sessionFactory=null;
	public ItemDAO() {
		sessionFactory=HibernateUtil.getSessionFactory();
	}
	public Item findItem(Integer id) {
		Session session=sessionFactory.openSession();
		Item item=(Item)session.get(Item.class, id);
		session.close();
		return  item;
	}
	
	public void update(Item item) {
		//FILL YOUR CODE
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Item it=(Item) session.get(Item.class,item.getId());
		it.setCategory(item.getCategory());
		it.setId(item.getId());
		it.setName(item.getName());
		it.setPrice(item.getPrice());
		it.setQuantity(item.getQuantity());
		session.save(it);
		transaction.commit();
		session.close();
	}
	
	public List<Item> list(){
		//FILL YOUR CODE
		Session session=sessionFactory.openSession();
		Query q=session.createQuery("from Item");
		List<Item> userlist=q.list();
		session.close();
		return userlist;
	}

}
