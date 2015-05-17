import java.lang.System;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.xml.transform.sax.SAXSource;

public class SendMail
{
	public static void main(String [] args){


//        pistike 	94.75
//        horvathkuki 	78.45
//        dezsovarga 	66.5
//        csabesz 	68
//        Piku 	75.05
//        Feri 	56.97
//        ZoliDan 	54.1
//        Istuu 	68.17
//        Lui 	55.93
//        kuplung(Zsolt)	62.15
//        Ruszkika 	56.17
//        szury 	54
//        Attila 	54.5
//        thezolo 	59.67
//        Lukacs 	50.97
//        dezsi(andras)	45
//        cslevy 	38.6
//        berti 	43.45
//        Karoly 	37.5
//        sanyecki 	39.25
//        Penzes Levi	68.5
//        Balazs	47.83
//        Peter Robi	78.25
//        csabarobert	62.5
//        Zsolt Rozsa	41.5
//        Szixi	74

        ArrayList<Player> players = new ArrayList<Player>();

        players.add(new Player("pistike", 9475));
        players.add(new Player("horvathkuki",7845));
        players.add(new Player("dezsovarga",6650));
        players.add(new Player("csabesz",6800));

        players.add(new Player("Piku",7505));
        players.add(new Player("Feri",5697));
        players.add(new Player("Istuu",6817));
        players.add(new Player("Lui",5593));

        players.add(new Player("kuplung",6215));
        players.add(new Player("szury",5400));
        players.add(new Player("Lukacs",5097));
        players.add(new Player("Attila",5450));

        /*players.add(new Player("berti",4345));
        players.add(new Player("sanyecki",3925));
        players.add(new Player("Lukacs",5097));
        players.add(new Player("Zsolt Rozsa",4150));*/

        Team team1 = Utils.generateRandomTeam(players,players.size()/2,"team1");
        Team team2 = Utils.generateRandomTeam(players,players.size(),"team2");

        /*Player randomPlayer = team1.getRandomPlayer();
        System.out.println("Random player from team 1: " + randomPlayer);
        System.out.println("Weaker Player from team 2: " + team2.getPlayerWeakerThan(randomPlayer));*/

        Utils.equalizeTeams(team1, team2);

        System.out.println(team1);
        System.out.println(team2);

        /*Utils.switchPlayer(randomPlayer, team1, team2);

        System.out.println(team1);
        System.out.println(team2);*/


		/*// Recipient's email ID needs to be mentioned.
		String to = "dezso.varga.vd@gmail.com";

		// Sender's email ID needs to be mentioned
		String from = "dezso.varga.vd@gmail.com";

		// Assuming you are sending email from localhost
		String host = "smtp.gmail.com";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.user", "dezso.varga.vd");
		properties.setProperty("mail.password", "v@rg@d3zs05");
		properties.setProperty("mail.smtp.host", host);

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try{
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO,
					new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("This is the Subject Line!");

			// Now set the actual message
			message.setText("This is actual message");

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		}catch (MessagingException mex) {
			mex.printStackTrace();
		}
		System.out.println("It works");*/

	}
}