package opr.server;

import java.util.ArrayList;
import java.util.List;

import opr.client.service.ILoginService;
import opr.shared.OperatoerDTO;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;




public class OperatoerDAO extends RemoteServiceServlet implements ILoginService {


	private static final long serialVersionUID = 1L;

	// primary key, autoincrement - not safe!
	private static int id = 0;

	private List<OperatoerDTO> pList;

	public OperatoerDAO() throws Exception {
		pList = new ArrayList<OperatoerDTO>();

		// Indset start data
		createOperatoer(new OperatoerDTO("admin","admin", id));
		createOperatoer(new OperatoerDTO("testUser1","testPass1", id));
		createOperatoer(new OperatoerDTO("testUser2","testPass2", id));
		createOperatoer(new OperatoerDTO("testUser3","testPass3", id));
	}
	/**
	 * 
	 * @param operatoerDTO add a operatoer to the database!
	 * @throws Exception
	 */
	public void createOperatoer(OperatoerDTO operatoerDTO) throws Exception {
		operatoerDTO.setId(id++);
		pList.add(operatoerDTO);

	}

	public void updateLogin(OperatoerDTO operatoerDTO) throws Exception{
		// find object with id and update it
		for (int i=0; i<pList.size();i++)
			if (pList.get(i).getId() == operatoerDTO.getId())	
				pList.set(i, operatoerDTO);


	}
	public void deleteOperatoer(OperatoerDTO operatoerDTO) throws Exception{
		// find object with id and remove it
		for (int i=0; i<pList.size();i++)
			if (pList.get(i).getId() == operatoerDTO.getId())	
				pList.remove(i);

	}
	public boolean loginVerify(OperatoerDTO operatoerDTO)throws Exception{
		for(int i  = 0; i <pList.size(); i++){
			if(pList.get(i).getUsername().equals(operatoerDTO.getUsername())){
				if(pList.get(i).getPassword().equals(operatoerDTO.getPassword())){
					return true;
				}
			}
		}		
		return false;


	}
	@Override
	public List<OperatoerDTO> getOperatoerer() throws Exception {
		return pList;
	}



}
