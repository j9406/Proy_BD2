 package conexion;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class LoginDAOImpl implements LoginDAO {
		
//	@Override
//	public void createLogin(Login student) throws Exception {		
//		Connection con = null; // Declare Resources
//		PreparedStatement pstmt = null;
//		try {
//			con = Conexion.getConnection(); // Open Connection
//			String sql = "INSERT INTO STUDENT(id, name, age) VALUES(?, ?, ?)";
//			pstmt = con.prepareStatement(sql); // Create Statement
//			pstmt.setLong(1, student.getId()); // Set Parameters
//	        pstmt.setString(2, student.getName());
//	        pstmt.setInt(3, student.getAge());
//	        Conexion.beginTransaction(); // Begin Transaction
//	        int result = pstmt.executeUpdate(); // Execute Statement
//	        if (result != 0) {
//	            Conexion.commit(); // Commit Transaction
//	        } else {
//	            Conexion.rollback(); // Roleback Transaction
//	        }
//		} finally {
//			Conexion.closeDBUtil(null, pstmt, con);  // Cleanup Resources	
//		}            
//	}
//
//	
//	@Override
//	public void updateLogin(Login student) throws Exception {
//		// Declare Resources
//		Connection con = null; 
//		PreparedStatement pstmt = null;
//		try {
//			con = Conexion.getConnection(); // Open Connection
//			String sql = "UPDATE STUDENT SET name=?, age=? WHERE id =?";	        
//			pstmt = con.prepareStatement(sql); // Create Statement 
//			pstmt.setString(1, student.getName()); // Set Parameters
//		    pstmt.setInt(2, student.getAge());
//		    pstmt.setLong(3, student.getId());
//	        Conexion.beginTransaction(); // Begin Transaction
//	        int result = pstmt.executeUpdate(); // Execute Statement
//	        if (result != 0) {
//	            Conexion.commit(); // Commit Transaction
//	        } else {
//	            Conexion.rollback(); // Roleback Transaction
//	        }
//		} finally {
//			Conexion.closeDBUtil(null, pstmt, con); // Cleanup Resources	
//		}            
//	}
	
	public Login getLogin(String id) throws Exception {	
		String sql = "SELECT * FROM login WHERE usuario = '" + id + "'";
                
        Connection con = Conexion.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Conexion.beginTransaction();
        
        Login login = null;
        if (rs.next()) {
            login = new Login();
            
            login.setId_user(rs.getInt(1));
            login.setT_usuario(rs.getInt(2));
            login.setNombre(rs.getString(3));
            login.setApellido(rs.getString(4));
            login.setUsuario(rs.getString(5));
            login.setContrasena(rs.getString(6));
            
            Conexion.commit();
        } else {
            Conexion.rollback();
        }
        Conexion.closeDBUtil(rs, stmt, con);
        return login;		
	}

//	@Override
//	public void deleteLogin(Login student) throws Exception {		
//		Connection con = Conexion.getConnection();
//        String sql = "DELETE FROM STUDENT WHERE id = ?";
//        PreparedStatement pstmt = con.prepareStatement(sql);
//        pstmt.setLong(1, student.getId());
//        Conexion.beginTransaction();
//        int res = pstmt.executeUpdate();
//        if (res != 0) {
//            Conexion.commit();
//        } else {
//            Conexion.rollback();
//        }
//        Conexion.closeDBUtil(null, pstmt, con);
//	}
//
//	@Override
//	public List<Login> getAllLogin() throws Exception {
//		String sql = "SELECT * FROM STUDENT";
//        Connection con = Conexion.getConnection();
//        Statement stmt = con.createStatement();
//        ResultSet rs = stmt.executeQuery(sql);
//        List<Login> students = new ArrayList<Login>();         
//        while(rs.next()) {
//        	Login student = new Login();
//            student.setId(rs.getLong(1));
//            student.setName(rs.getString(2));
//            student.setAge(rs.getInt(3));
//            students.add(student);            
//        }         
//        Conexion.closeDBUtil(rs, stmt, con);
//        return students;		
//	}	

    @Override
    public void createLogin(Login student) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateLogin(Login student) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteLogin(Login student) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Login> getAllLogin() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}