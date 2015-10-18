package dezso.varga.teamgenerator.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


/**
 * Created by varga on 16.09.2015.
 */
public class MainRest {

   public static void main(String[] args) throws Exception {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        Server jettyServer = new Server(8082);
        jettyServer.setHandler(context);

        ServletHolder jerseyServlet = context.addServlet(
                org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);

        // Tells the Jersey Servlet which REST service/class to load.
//        jerseyServlet.setInitParameter("jersey.config.server.provider.classnames",
//                PlayersResource.class.getCanonicalName());
//        jerseyServlet.setInitParameter("jersey.config.server.provider.classnames",
//               TeamResource.class.getCanonicalName());

        jerseyServlet.setInitParameter("jersey.config.server.provider.packages",
                "dezso.varga.teamgenerator.rest.resources");

        try {
            jettyServer.start();
            jettyServer.join();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
            jettyServer.destroy();
        }
    }
}
