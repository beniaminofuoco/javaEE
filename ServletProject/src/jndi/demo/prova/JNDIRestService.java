package jndi.demo.prova;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("info")
public class JNDIRestService {
	
	/**
	 * Meteodo con le annotation più semplice ed elegante.
	 * Da notare che abbiamo specificato anche lo Scope per la classe
	 */
	@Resource(lookup="jdbc/Utenti")
	private DataSource dataBase;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getInfo() throws NamingException, SQLException {
		// Meteodo OLD STYLE per recuperare una risorsa dal Server
		// Utilizzando l'oggetto InitialContext
		// InitialContext ctx = new InitialContext();
		// return (String) ctx.lookup("ProvaString");
		
		StringBuilder sb = new StringBuilder();
		try(Connection con = dataBase.getConnection();
				Statement sta = con.createStatement();
				ResultSet rs = sta.executeQuery("SELECT * FROM UTENTE")){
		
			while(rs.next()) {
				int id = rs.getInt("ID");
				String user= rs.getString("USERNAME");
				
				sb.append("ID = ");
				sb.append(id);
				sb.append(", Username = ");
				sb.append(user);
				sb.append("\n");
			}
		}
		
		return sb.toString();
		
	}

}
