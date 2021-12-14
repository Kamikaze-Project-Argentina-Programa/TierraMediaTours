package persistence.commons;

import java.util.List;

public interface GenericDAO<T, A, B, C> {
	public T find(Integer id);
	
	public List<T> findOrderByType(Integer id);

	public List<T> findItinerary(Integer id);
	
	public List<T> findAll();

	public int countAll();

	public int insert(T t);

	public int insert(T t, A a, B b, C c);
	
	public int update(T t);

	public int delete(T t);
	
	
}
