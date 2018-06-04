package ci.codeurs.dao;

import java.util.List;

public interface IDao<T, PK> {
	
	public boolean save(T t);
	
	public boolean update(T t);
	
	public boolean delete(PK id);
	
	public T readOne(PK id);
	
	public List<T> readAll();

}
