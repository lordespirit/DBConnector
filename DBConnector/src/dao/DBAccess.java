package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DBAccess <T>{
	
	/** 
	 * Conexi�n a la base de datos
	 * @param user	Usuario de la base de datos
	 * @param password	Contrase�a del usuario de la base de datos
	 * @return 
	 * @throws SQLException	Excepci�n en el proceso de trabajo con la base de datos.
	 * @throws ClassNotFoundException	Si el driver no est� instalado
	 */
	public void connect(String user, String password) throws SQLException, ClassNotFoundException;
	
	/**
	 * Inserta un objecto gen�rico <T> en la tabla
	 * @param Object objecto gen�rico
	 * @return
	 */
	public T insert (T Object);
	
	/**
	 * Actualiza un objeto tipo T, donde T contiene los campos de la tabla a actualizar.
	 * @param Object objecto gen�rico
	 * @return
	 */
	public T update (T Object);
	
	/**
	 * Obtiene el objeto (que son los campos de la tabla) de una 'id' pasada
	 * @param id Entero que se le pasa para obtener los valores de una tabla (objeto <T>)
	 * @return
	 */
	public T select (int id);
	
	/**
	 * Obtiene un ArrayList<T> de objetos <T> (campos de la tabla) de una consulta String pasada.
	 * @param strSQL Consulta a realizar
	 * @return Devuelve un ArrayList<T> con todos los registros encontrados.
	 */
	public ArrayList<T> select(String strSQL);
	
	/**
	 * Borra todos los registros del campo (Truncate tabla)
	 */
	public void deleteAll() throws SQLException;
	
	/**
	 * Borra el registro que coincida con la 'id' enviada.
	 * @param id Entero identificativo �nico
	 */
	public void delete(int id);
	
	/**
	 * Cierre de la conexi�n, obligatorio hacerlo despu�s de cada acci�n para ahorrar memoria.
	 */
	public void close();

}
