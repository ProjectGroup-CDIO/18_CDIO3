 package opr.client.service;

import java.util.List;

import opr.shared.OperatoerDTO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("loginservice")
public interface IOperatoerService extends RemoteService{
	
	public void createOperatoer(OperatoerDTO p)throws Exception;
	public void updateOperatoer(OperatoerDTO p)throws Exception;
	public void deleteOperatoer(OperatoerDTO p)throws Exception;
	public OperatoerDTO loginVerify(int oprId, String pass)throws Exception;
	public List<OperatoerDTO> getOperatoerList() throws Exception;
	
}
