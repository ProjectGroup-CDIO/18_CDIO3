package opr.client.service;

import java.util.List;

import opr.shared.OperatoerDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;




public interface ILoginServiceAsync {
	
	void loginVerify(OperatoerDTO p, AsyncCallback<OperatoerDTO> callback);
	void updateLogin(OperatoerDTO p, AsyncCallback<Void> callback)throws Exception;
	void deleteOperatoer(OperatoerDTO p, AsyncCallback<Void> callback)throws Exception;
	void createOperatoer(OperatoerDTO p, AsyncCallback<Void> callback)throws Exception;
	void getOperatoerer(AsyncCallback<List<OperatoerDTO>> callback) throws Exception;

}
