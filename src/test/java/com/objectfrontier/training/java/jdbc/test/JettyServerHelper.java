package com.objectfrontier.training.java.jdbc.test;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import com.objectfrontier.training.java.jdbc.exception.AppException;
import com.objectfrontier.training.java.jdbc.exception.ExceptionCode;

public class JettyServerHelper {

	Server server;
	WebAppContext appContext;

	public JettyServerHelper(String webConfig, String webDirLocation, String contextPath) {
		try {
			server = new Server(8081);
			appContext = new WebAppContext();
			appContext.setDescriptor(webConfig);
			appContext.setResourceBase(webDirLocation);
			appContext.setContextPath(contextPath);
			appContext.setParentLoaderPriority(true);
			appContext.setThrowUnavailableOnStartupException(true);
			
			server.setHandler(appContext);
		} catch (Exception e) {
			throw new AppException(ExceptionCode.INTERNAL_SERVER_ERROR);
		}
	}

	public void start() throws Exception {
		server.start();
	}

	public void stop() throws Exception {
		server.stop();
		server.destroy();
	}
}
