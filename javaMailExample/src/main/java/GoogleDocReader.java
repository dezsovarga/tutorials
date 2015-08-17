import jdk.nashorn.internal.parser.JSONParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class GoogleDocReader {

    public static final String clientID = "389743910122-8st9q0itn7vph6ku927drj23puhsjoli.apps.googleusercontent.com";
    public static final String clientSecret = "MijK_FMlQesgoCvJW-WYTlhj";

    private JSONObject getPlayersJson(){
        JSONObject object=null;

        try {
            // create HTTP Client
            HttpClient httpClient = HttpClientBuilder.create().build();

            // Create new getRequest with below mentioned URL
            HttpGet getRequest = new HttpGet("https://docs.google.com/spreadsheets/" +
                    "d/1XMDoCI5f8eym6N6hrIU0PRAgqKWJyPHwZ2O__UDJbQo/gviz/tq?gid=0");

            // Add additional header to getRequest which accepts application/xml data
            getRequest.addHeader("accept", "application/xml");
            //getRequest.addHeader("access_token", "ya29.0gF0IAX0S33b2bIVtMUlR7cOwYM-P3s4vd-nm6TxArhygH9LUzpTqV57yBCVTt6zOk_pmQ");

            // Execute your request and catch response
            HttpResponse response = httpClient.execute(getRequest);

            // Check for HTTP response code: 200 = success
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
            }

            // Get-Capture Complete application/xml body response
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output = br.readLine();

            int startIndex = output.indexOf("{");
            String playersJson = output.substring(startIndex, output.length()-2);
            object = new JSONObject(playersJson);

        }

        catch (ClientProtocolException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        return object;
    }

    public List<Player> getPlayersFromJson(){

        Player player;
        String playerName;
        int playerSkill;
        List<Player> playersList = new ArrayList<Player>();
        JSONObject obj = getPlayersJson();
        JSONObject table = obj.getJSONObject("table");
        JSONArray rows = table.getJSONArray("rows");
        JSONObject elements;

        for (int i=1; i< rows.length();i++){
            elements = (JSONObject)rows.get(i);
            JSONArray c = elements.getJSONArray("c");
            playerName = ((JSONObject)c.get(0)).get("v").toString();
            playerSkill = (int) (Double.parseDouble( ((JSONObject) c.get(1)).get("v").toString()) * 100) ;
            player = new Player(playerName, playerSkill);
            playersList.add(player);
           // System.out.println( ((JSONObject)c.get(0)).get("v") + "  " + ((JSONObject)c.get(1)).get("v"));
           // System.out.println( player.toString());
        }

        return playersList;
    }

    public static void main(String args[]){

        new GoogleDocReader().getPlayersFromJson();
    }

}

