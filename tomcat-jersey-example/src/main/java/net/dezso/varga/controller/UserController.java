package net.dezso.varga.controller;

import net.dezso.varga.listener.LocalEntityManagerFactory;
import net.dezso.varga.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;  
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("user")
public class UserController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String read(@PathParam("id") long id) {
        long start = System.currentTimeMillis();
        System.out.println("EmployeeController.read() started");
//        EntityManager em = LocalEntityManagerFactory.createEntityManager();
        User user = new User();
        user.setId(id);
        user.setFirstName("first");
        user.setLastName("last");
        try {
            //return em.find(User.class, id);

            return user.getFirstName();
        } finally {
//            em.close();
            System.out.println("Getting data took " + (System.currentTimeMillis() - start) + "ms.");
        }
    }

    public static void main(String ...args) {
        Map props = new HashMap();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePU", props);
        User emp = emf.createEntityManager().find(User.class, new Long(23411));
        if (emp != null) {
            System.out.println("Your user is: " + emp.getFirstName() + " " + emp.getLastName());
        }
        emf.close();
    }
}