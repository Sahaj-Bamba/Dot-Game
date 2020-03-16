package com.DotGame.Main;
/**
 * @author Sahaj
 *
 */

import com.DotGame.Constant.Request;
import com.DotGame.Constant.Responses;
import com.DotGame.Other.GameGlobalVariables;
import com.DotGame.Request.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HandleClient implements Runnable{

	private String clientName;
	private String groupName;
	private Socket socket;
	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;
	
	private boolean goBack;
	
	/**
	 * It accepts the socket and create object input and output streams from it.
	 *
	 * @param socket The socket of the accepted client
	 */
	public HandleClient(Socket socket) {
		this.socket = socket;
		try {
			objectInputStream = new ObjectInputStream(socket.getInputStream());
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("Streams created");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * The method where indirectly all the processing of Objects sent and receive occur.
	 */
	@Override
	public void run() {
		
		do {
			goBack=true;
			groupInit();
		}while(goBack);
		while (startWait());
	}
	
	/**
	 * Initialises the group of the client.
	 * After this method is successfully completed the group of the client is decided.
	 */
	private void groupInit(){
		System.out.println("Group Initialising");
		try{
			
			GroupDetails groupDetails = (GroupDetails) objectInputStream.readObject();
			groupName = groupDetails.get_group_name();
			clientName = groupDetails.get_client_name();
			if (groupDetails.toString().equals(String.valueOf(Request.CREATEGROUP))) {
				objectOutputStream.writeObject(createGroup(groupDetails));
			}else if (groupDetails.toString().equals(String.valueOf(Request.JOINGROUP))) {
				objectOutputStream.writeObject(joinGroup(groupDetails));
			}
			
		} catch (Exception e) {
			System.out.println("Client Disconnected");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Creates a new group and adds the client in it.
	 * @param groupDetails The details of client and group
	 * @return The response to send back to client
	 */
	private Object createGroup(GroupDetails groupDetails){
		
		if (GameGlobalVariables.getInstance().getGAMER().group_exist(groupDetails.get_group_name())){
			return new Response(Responses.ERROR,"Group already exists.");
		}
		GameGlobalVariables.getInstance().getGAMER().add_group(groupDetails.get_group_name(),groupDetails.get_password(),groupDetails.get_client_name());
		GameGlobalVariables.getInstance().getGAMER().add_client(groupDetails.get_group_name(),groupDetails.get_client_name(),this.objectOutputStream);
		goBack = false;
		return new Response(Responses.OK,"Group Created");
	}
	
	/**
	 * Adds the client to the specified group .
	 * @param groupDetails The details of client and group
	 * @return The response to send back to client
	 */
	private Object joinGroup(GroupDetails groupDetails){
		
		if (!GameGlobalVariables.getInstance().getGAMER().group_exist(groupDetails.get_group_name())){
			return new Response(Responses.ERROR,"Group doesnot exists.");
		}
		
		if (!GameGlobalVariables.getInstance().getGAMER().check_pass(groupDetails.get_group_name(),groupDetails.get_password())){
			return new Response(Responses.ERROR,"Password doesnot match.");
		}
		
		GameGlobalVariables.getInstance().getGAMER().add_client(groupDetails.get_group_name(),groupDetails.get_client_name(),this.objectOutputStream);
		goBack = false;
		return new Response(Responses.OK,"Group Joined");
	}
	
	public boolean startWait(){
		
		return true;
	}

}









//		boolean flag;
//
//		try {
//
//			WhoIAm ob1 = (WhoIAm) objectInputStream.readObject();
//			GAMER.add_client("extra", ob1.getName(),objectOutputStream);
//			System.out.println("Client Got and name set");
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//
//
//		while (true) {
//			try {
//				Object message = (Object) objectInputStream.readObject();
//				System.out.println("Message received");
//
//
//				/*      If Else for server handelling           */
//
//				String req = (String) message.toString();
//
//				if (req.equals(Request.GROUPPASS)  ){
//
//					System.out.println("Group creation request");
//
//					do {
//						GroupPass ob2 = (GroupPass) message;
//						if(GAMER.add_group(ob2.get_group_name(),ob2.get_password())){
//							GAMER.send_message(new Response(0,""),ob2.get_group_name(),ob2.get_client_name());
//							flag = false;
//							GAMER.remove_client("extra",ob2.get_client_name());
//							GAMER.add_client(ob2.get_group_name(),ob2.get_client_name(),objectOutputStream);
//							System.out.println("Client successfully added to the specified group");
//						}
//						else{
//							flag = true;
//							GAMER.send_message(new Response(1,"Group already exist please try a new name."),ob2.get_group_name(),ob2.get_client_name());
//							System.out.println("There was a problem retrying");
//						}
//					}while(flag);
//
//				}else if (req.equals(Request.GROUPLIST)){
//
//					System.out.println("Group list com.DotGame.Request");
//
//					GroupList ob3 = (GroupList)(message);
//					GAMER.send_message((Object)GAMER.get_group_list(),ob3.getter());
//
//				}
//









/*  Do Rest of processing on the object here    */
