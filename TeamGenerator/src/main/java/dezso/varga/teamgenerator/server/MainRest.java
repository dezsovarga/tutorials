package dezso.varga.teamgenerator.server;

import dezso.varga.teamgenerator.server.resources.PlayersResource;
import dezso.varga.teamgenerator.server.resources.TeamResource;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


/**
 * Created by varga on 16.09.2015.
 */
public class MainRest {

    /*public static void main(String[] args) throws Exception {
        ServletHolder sh = new ServletHolder(ServletContainer.class);
        sh.setInitParameter("com.sun.jersey.config.property.resourceConfigClass", "com.sun.jersey.api.core.PackagesResourceConfig");
        sh.setInitParameter("com.sun.jersey.config.property.packages", "dezso.varga.teamgenerator.rest");//Set the package where the services reside
        sh.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");

        Server server = new Server(9999);
        ServletContextHandler context = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
        context.addServlet(sh, "*//*");
        server.start();
        server.join();
    }*/

    public static void main(String[] args) throws Exception {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        Server jettyServer = new Server(8082);
        jettyServer.setHandler(context);

        ServletHolder jerseyServlet = context.addServlet(
                org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);

        // Tells the Jersey Servlet which REST service/class to load.
        jerseyServlet.setInitParameter(
                "jersey.config.server.provider.classnames",
                TeamResource.class.getCanonicalName());
        //jerseyServlet.setInitParameter("com.sun.jersey.config.property.packages", "dezso.varga.teamgenerator.rest");

        try {
            jettyServer.start();
//            jettyServer.dumpStdErr();
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
