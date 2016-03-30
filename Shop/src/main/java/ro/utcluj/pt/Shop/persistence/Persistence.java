package ro.utcluj.pt.Shop.persistence;

import java.sql.SQLException;
import java.util.List;

public interface Persistence<T> {
	
	public List<T> getAll() throws SQLException ;
	public void update(T element ) throws SQLException ;
	public void delete(T element) throws SQLException ;
	public int insert(T element) throws SQLException;
	
}
