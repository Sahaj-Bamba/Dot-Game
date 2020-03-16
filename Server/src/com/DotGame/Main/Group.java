package com.DotGame.Main;

/**
 * @author Sahaj
 */

import com.DotGame.Request.ClientToken;

import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * The Group class contain name and password and links to various clients
 *
 */
public class Group {

	private String password;
	private String name;
	private String leader;
	private HashMap<String,Client> clients;
	private int size;
	
	/**
	 * Creates a group using name and password
	 * @param name name of the group. Be sure that a group with that name doesn't already exists
	 * @param password the password of the group
	 */
	public Group(String name, String password, String leader){
		clients = new HashMap<String, Client>();
		this.name = name;
		this.password = password;
		this.leader = leader;
	}
	
	public String getPassword() {
		return password;
	}
	
	/**
	 * Adds the client to the group
	 * @param name the name of the client
	 * @param objectOutputStream the object output stream of the client
	 */
	public void add_client(String name, ObjectOutputStream objectOutputStream){
		clients.put(name, new Client(name,objectOutputStream));
	}
	
	/**
	 * Removes the client from the group
	 * @param name The name of client to remove
	 * @return true if the client has been successfully removed
	 */
	public boolean remove_client(String name){
		if (client_exist(name)) {
			clients.remove(name);
			return true;
		}
		return false;
	}
	
	// @TODO: 3/14/2020 Problems in logic of remove all check latter
	/**
	 *
	 * @param name
	 * @return
	 */
	public boolean remove_all(String name){
		boolean flag = true;
		Iterator client = clients.entrySet().iterator();
		while (client.hasNext()){
			Map.Entry g = (Map.Entry)client.next();
			flag = flag & this.remove_client(((Client)g.getValue()).getName());
		}
		return flag;
	}
	
	/**
	 * Tell if the given client exist in this group or not.
	 * @param name Name of client
	 * @return true if client exists
	 */
	public boolean client_exist(String name){
		return clients.containsKey(name);
	}
	
	/**
	 * Send message to the all the clients
	 * @param message The object to send
	 * @return true if message is sent to all the clients
	 */
	public boolean send_message(Object message){

		boolean flag = true;
		Iterator client = clients.entrySet().iterator();
		while (client.hasNext()){
			Map.Entry g = (Map.Entry)client.next();
			flag = flag & ((Client)g.getValue()).send_message(message);
		}

		return flag;
	}
	
	/**
	 * Send message to a particular client
	 * @param message The object to send
	 * @param clientName The name of client
	 * @return True if the message is sent successfully. False otherwise.
	 */
	public boolean send_message(Object message, String clientName){
		if (client_exist(clientName)){
			return clients.get(clientName).send_message(message);
		}
		return false;
	}
	
}






