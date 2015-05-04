package opr.shared;

import java.io.Serializable;

public class OperatoerDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String username;
	private String password;
	private String navn;
	private int alder;
	
	// default constructor - must be defined
	public OperatoerDTO() {
		
	}
	/**
	 * For login checks:
	 * @param username
	 * @param password
	 */
	public OperatoerDTO(String username, String password){
		super();
		this.username = username;
		this.password = password;
		
	}
	public OperatoerDTO(String username, String password, int id){
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		
	}


	public OperatoerDTO(String username, String password, int id, String navn, int alder) {
		super();
		this.username = username;
		this.password = password;
		this.id = id;
		this.navn = navn;
		this.alder = alder;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	public int getAlder() {
		return alder;
	}
	
	public void setAlder(int alder) {
		this.alder = alder;
	}
}
