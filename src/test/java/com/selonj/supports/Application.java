package com.selonj.supports;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by L.x on 16-2-18.
 */
public class Application {
    public static final int SERVER_PORT = 80;
    public static final String WEB_APP_DIR = "src/main/webapp";
    private final int serverPort;
    private Server server;

    public Application() {
        serverPort = SERVER_PORT;
        server = new Server(serverPort);
        server.setStopAtShutdown(true);
        server.setHandler(new WebAppContext() {{
            setWar(WEB_APP_DIR);
        }});
    }

    public void start() throws Exception {
        server.start();
    }

    public void stop() throws Exception {
        server.stop();
    }

    public URL webRootAsURL() throws MalformedURLException {
        return new URL("http", "localhost", serverPort, "");
    }
}
