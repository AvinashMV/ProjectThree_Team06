package server.services;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.websocket.Session;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.websocket.jsr356.server.ServerContainer;
import org.eclipse.jetty.websocket.jsr356.server.deploy.WebSocketServerContainerInitializer;

import server.controller.ServerSocketEndpoint;
import server.listener.LogListenerInterface;

public class ServerSocketService {
	Thread serverThread;
	LogListenerInterface logListener;
	Server server;
	ServerConnector connector;
	ServletContextHandler context;

	public void startServer() {
		final ExecutorService clientProcessingPool = Executors.newFixedThreadPool(10);
		Runnable serverTask = new Runnable() {
			@Override
			public void run() {
				server = new Server();
				connector = new ServerConnector(server);
				connector.setPort(8080);
				server.addConnector(connector);
				// Setup the basic application "context" for this application at "/"
				// This is also known as the handler tree (in jetty speak)
				context = new ServletContextHandler(ServletContextHandler.SESSIONS);
				context.setContextPath("/");
				server.setHandler(context);
				try {
					// Initialize javax.websocket layer
					ServerContainer wscontainer = WebSocketServerContainerInitializer.configureContext(context);
					// Add server end point to the server
					wscontainer.addEndpoint(ServerSocketEndpoint.class);
					server.start();
					server.dump(System.err);
				} catch (Throwable t) {
					t.printStackTrace(System.err);
				}
			}
		};
		serverThread = new Thread(serverTask);
		serverThread.start();
	}

	public void stopServer() {
		try {
			context.stop();
			connector.close();
			server.stop();
			serverThread.join();
			ServerSocketEndpoint.queue = new ConcurrentLinkedQueue<Session>();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}