package opr.server.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import opr.server.Connector;
import opr.client.service.IOperatoerService;
import opr.server.interfaces.OperatoerDAO;
import opr.shared.DALException;
import opr.shared.OperatoerDTO;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;


public class MySQLOperatoerDAO extends RemoteServiceServlet implements OperatoerDAO, IOperatoerService {
	
	/**
	 * 
	 */
	public MySQLOperatoerDAO(){
		try {
			new Connector();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
						e.printStackTrace();
		} catch (ClassNotFoundException e) {
						e.printStackTrace();
		} catch (SQLException e) {
						e.printStackTrace();
		}
	}
	
	
	private static final long serialVersionUID = 1L;

	public OperatoerDTO getOperatoer(int oprId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM operatoer WHERE opr_id = " + oprId);
	    try {
	    	if (!rs.first()) throw new DALException("Operatoeren " + oprId + " findes ikke");
	    	return new OperatoerDTO (rs.getInt("opr_id"), rs.getString("opr_navn"), rs.getString("ini"), rs.getString("cpr"), rs.getString("password"));
	    }
	    catch (SQLException e) {throw new DALException(e.getMessage()); }
		
	}
	
	public void createOperatoer(OperatoerDTO opr) throws DALException {		
			Connector.doUpdate(
				"INSERT INTO operatoer(opr_id, opr_navn, ini, cpr, password) VALUES " +
				"(" + opr.getOprId() + ", '" + opr.getOprNavn() + "', '" + opr.getIni() + "', '" + 
				opr.getCpr() + "', '" + opr.getPassword() + "')"
			);
	}
	
	public void updateOperatoer(OperatoerDTO opr) throws DALException {
		Connector.doUpdate(
				"UPDATE operatoer SET  opr_navn = '" + opr.getOprNavn() + "', ini =  '" + opr.getIni() + 
				"', cpr = '" + opr.getCpr() + "', password = '" + opr.getPassword() + "' WHERE opr_id = " +
				opr.getOprId()
		);
	}
	
	public List<OperatoerDTO> getOperatoerList() throws DALException {
		List<OperatoerDTO> list = new ArrayList<OperatoerDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM operatoer");
		try
		{
			while (rs.next()) 
			{
				list.add(new OperatoerDTO(rs.getInt("opr_id"), rs.getString("opr_navn"), rs.getString("ini"),
						rs.getString("cpr"), rs.getString("password"), rs.getInt("aktiv")));
			}
		}
		catch (SQLException e) { throw new DALException(e.getMessage()); }
		return list;
	}
	
	public OperatoerDTO loginVerify(int oprId, String pass) throws DALException{
		/*
		 *Here check if the partly filled oprDTO matches uName and pass with one in the datebase.
		 * we then return the found in the database, on failure we return the recieved oprDTO
		 * 
		 */
		OperatoerDTO opr;
		if((opr = getOperatoer(oprId)).getPassword().equals(pass) && opr.getActive() > 0){
			return opr;
		}else{
			throw new DALException("Bruger ID eller password var forkert.");
		}
	}

	@Override
	public void deleteOperatoer(OperatoerDTO opr) throws DALException {
		Connector.doUpdate(
				"UPDATE operatoer SET aktiv = 0 WHERE opr_id = " +
				opr.getOprId()
		);
	}


	

		
		
}
	
