package net.dezso.varga.controller;

import net.dezso.varga.listener.LocalEntityManagerFactory;
import net.dezso.varga.model.User;
import net.dezso.varga.utils.DBUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;  
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Path("user")
public class UserController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public User read(@PathParam("id") long id) {
        long start = System.currentTimeMillis();
        System.out.println("EmployeeController.read() started");
        EntityManager em = LocalEntityManagerFactory.createEntityManager();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("mockData/users.xml").getFile());
        User user = DBUtils.populateUsersFromXml(file);

        try {
            //return em.find(User.class, id);
            return user;

//            return user;
        } finally {
//            em.close();
            System.out.println("Getting data took " + (System.currentTimeMillis() - start) + "ms.");
        }
    }

    public static void main(String ...args) {
        Map props = new HashMap();
        ClassLoader classLoader = UserController.class.getClassLoader();
        File file = new File(classLoader.getResource("mockData/users.xml").getFile());
        DBUtils.populateUsersFromXml(file);
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example",props);
//        User emp = emf.createEntityManager().find(User.class, new Long(3));
//        if (emp != null) {
//            System.out.println("Your user is: " + emp.getFirstName() + " " + emp.getLastName());
//        }
//        emf.close();
    }
}