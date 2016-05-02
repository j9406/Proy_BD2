package conexion;

import java.util.List;


public interface LoginDAO {
	public void createLogin(Login student) throws Exception;
	public Login getLogin(String id) throws Exception;
	public void updateLogin(Login student) throws Exception;
	public void deleteLogin(Login student) throws Exception;
	public List<Login> getAllLogin() throws Exception;
}
