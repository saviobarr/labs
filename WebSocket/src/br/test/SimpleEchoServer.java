package br.test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/mybe")
public class SimpleEchoServer {
	
	private static Set<Session> openedSessions = new HashSet<>(); 
	
	@OnOpen
	public void sessionOpened(Session session){
		openedSessions.add(session);
	}
	
	@OnMessage
	public void onOpen(String msg){
		System.out.println("######## - MSG: "+msg);
		
		try{
			for(Session session : openedSessions){
				
				session.getBasicRemote().sendText("Your Message BACK");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

}
