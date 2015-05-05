package opr.client;

import java.io.Serializable;

import opr.shared.OperatoerDTO;

/**
 * not sure it has to be serializable??????
 * please provide thoughts - dont hand in this comment
 * 
 *
 *
 *This class is supposed to contain the user who has logged in.
 *since there is only supposed to be one active user, we make it static.
 */
public class ActiveUser implements Serializable {

	
private static final long serialVersionUID = 1L;
	
	private static int id;
	private static String username;
	private static String password;
	private static String navn;
	private static int alder;
	
	// default constructor - must be defined
	public ActiveUser() {
		
	}
	/**
	 * For login checks:
	 * @param username
	 * @param password
	 */
	public ActiveUser(OperatoerDTO activeUser){
		super();
		ActiveUser.id = activeUser.getId();
		ActiveUser.username = activeUser.getUsername();
		ActiveUser.password = activeUser.getPassword();
		ActiveUser.navn = activeUser.getNavn();
		ActiveUser.alder = activeUser.getAlder();
	}
	public ActiveUser(String username, String password, int id, String navn, int alder) {
		super();
		ActiveUser.username = username;
		ActiveUser.password = password;
		ActiveUser.id = id;
		ActiveUser.navn = navn;
		ActiveUser.alder = alder;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		ActiveUser.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		ActiveUser.password = password;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		ActiveUser.id = id;
	}

	
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		ActiveUser.navn = navn;
	}
	
	public int getAlder() {
		return alder;
	}
	
	public void setAlder(int alder) {
		ActiveUser.alder = alder;
	}
}
