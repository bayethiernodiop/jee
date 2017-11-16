package client;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@ManagedBean
@SessionScoped
public class ClientBean {
	private DataSource dataSource;
	private Client client = new Client();
	private List<Client> clients;
	private ClientDao clientDao;
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	public ClientBean() throws NamingException{
		dataSource = (DataSource)new InitialContext().lookup("java:comp/env/jdbc/dic3");
		clientDao = new ClientDao(dataSource);
		
	}
	
	public String list(){
		clients = clientDao.listClient();
		return "/client/";
	}
	
	public String save(){
		clientDao.save(client);
		client = new Client();
		return list();
	}

}
