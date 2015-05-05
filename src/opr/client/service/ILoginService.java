 package opr.client.service;

import java.util.List;

import opr.shared.OperatoerDTO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("loginservice")
public interface ILoginService extends RemoteService{
	
	public void createOperatoer(OperatoerDTO p)throws Exception;
	public void updateLogin(OperatoerDTO p)throws Exception;
	public void deleteOperatoer(OperatoerDTO p)throws Exception;
	public OperatoerDTO loginVerify(OperatoerDTO p)throws Exception;
	public List<OperatoerDTO> getOperatoerer() throws Exception;
	
}
