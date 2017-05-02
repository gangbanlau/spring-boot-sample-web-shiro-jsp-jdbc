package my.mycompany.myapp.repository;

import java.util.List;

public interface IBaseDao<T, ID> {

	public boolean exists(ID id);
	
	/**
	 * @return the number of entities available.
	 */
	public long count();
		
	public T findOne(ID id);

	public List<T> findAll();

	public T insert(T entity);
	
	public void update(T entity);

	public void delete(ID id);	
}
