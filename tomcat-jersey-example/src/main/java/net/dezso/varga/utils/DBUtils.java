package net.dezso.varga.utils;

import net.dezso.varga.model.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by dezso.varga on 3/9/2015.
 */
public class DBUtils {

	public static User populateUsersFromXml(File xmlFile){
		User user = null;
		try{

			JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
			Unmarshaller jaxBUnmarshaller = jaxbContext.createUnmarshaller();
			user = (User)jaxBUnmarshaller.unmarshal(xmlFile);
		}
		catch (JAXBException e){
			e.printStackTrace();
		}
		return user;
	}
}
