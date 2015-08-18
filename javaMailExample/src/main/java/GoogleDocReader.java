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

            //workaround
            //https://docs.google.com/spreadsheets/d/1XMDoCI5f8eym6N6hrIU0PRAgqKWJyPHwZ2O__UDJbQo/gviz/tq?gid=0
            output = "google.visualization.Query.setResponse({\"version\":\"0.6\",\"reqId\":\"0\",\"status\":\"ok\",\"sig\":\"174972189\",\"table\":{\"cols\":[{\"id\":\"A\",\"label\":\"Player name\",\"type\":\"string\"},{\"id\":\"B\",\"label\":\"Skill average with reward\",\"type\":\"number\",\"pattern\":\"General\"},{\"id\":\"C\",\"label\":\"Reward\",\"type\":\"number\",\"pattern\":\"M/d/yyyy\"},{\"id\":\"D\",\"label\":\"Default skill average\",\"type\":\"number\",\"pattern\":\"General\"},{\"id\":\"E\",\"label\":\"Skill point (higher is better)\",\"type\":\"number\",\"pattern\":\"General\"},{\"id\":\"F\",\"label\":\"\",\"type\":\"number\",\"pattern\":\"General\"},{\"id\":\"G\",\"label\":\"\",\"type\":\"number\",\"pattern\":\"General\"},{\"id\":\"H\",\"label\":\"\",\"type\":\"number\",\"pattern\":\"General\"},{\"id\":\"I\",\"label\":\"\",\"type\":\"number\",\"pattern\":\"General\"},{\"id\":\"J\",\"label\":\"\",\"type\":\"string\"},{\"id\":\"K\",\"label\":\"\",\"type\":\"string\"},{\"id\":\"L\",\"label\":\"\",\"type\":\"string\"},{\"id\":\"M\",\"label\":\"\",\"type\":\"string\"},{\"id\":\"N\",\"label\":\"\",\"type\":\"string\"},{\"id\":\"O\",\"label\":\"\",\"type\":\"string\"},{\"id\":\"P\",\"label\":\"\",\"type\":\"string\"},{\"id\":\"Q\",\"label\":\"\",\"type\":\"string\"},{\"id\":\"R\",\"label\":\"\",\"type\":\"string\"},{\"id\":\"S\",\"label\":\"\",\"type\":\"string\"},{\"id\":\"T\",\"label\":\"\",\"type\":\"string\"},{\"id\":\"U\",\"label\":\"\",\"type\":\"string\"},{\"id\":\"V\",\"label\":\"\",\"type\":\"string\"},{\"id\":\"W\",\"label\":\"\",\"type\":\"string\"},{\"id\":\"X\",\"label\":\"\",\"type\":\"string\"},{\"id\":\"Y\",\"label\":\"\",\"type\":\"string\"},{\"id\":\"Z\",\"label\":\"\",\"type\":\"string\"},{\"id\":\"AA\",\"label\":\"\",\"type\":\"string\"}],\"rows\":[{\"c\":[null,null,{\"v\":42199.0,\"f\":\"7/14/2015\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"pistike \"},{\"v\":94.5,\"f\":\"94.5\"},{\"v\":14.75,\"f\":\"14.75\"},{\"v\":79.75,\"f\":\"79.75\"},{\"v\":81.0,\"f\":\"81\"},{\"v\":82.0,\"f\":\"82\"},null,{\"v\":80.0,\"f\":\"80\"},{\"v\":76.0,\"f\":\"76\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"horvathkuki \"},{\"v\":77.2,\"f\":\"77.2\"},{\"v\":3.75,\"f\":\"3.75\"},{\"v\":73.45,\"f\":\"73.45\"},{\"v\":71.0,\"f\":\"71\"},null,{\"v\":77.2,\"f\":\"77.2\"},{\"v\":77.0,\"f\":\"77\"},{\"v\":68.6,\"f\":\"68.6\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"dezsovarga \"},{\"v\":63.5,\"f\":\"63.5\"},{\"v\":-9.0,\"f\":\"-9\"},{\"v\":72.5,\"f\":\"72.5\"},{\"v\":73.0,\"f\":\"73\"},{\"v\":73.0,\"f\":\"73\"},{\"v\":70.0,\"f\":\"70\"},null,{\"v\":74.0,\"f\":\"74\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"csabesz \"},{\"v\":69.75,\"f\":\"69.75\"},{\"v\":-2.5,\"f\":\"-2.5\"},{\"v\":72.25,\"f\":\"72.25\"},{\"v\":73.0,\"f\":\"73\"},{\"v\":73.0,\"f\":\"73\"},{\"v\":70.0,\"f\":\"70\"},{\"v\":73.0,\"f\":\"73\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"Piku \"},{\"v\":74.75,\"f\":\"74.75\"},{\"v\":9.75,\"f\":\"9.75\"},{\"v\":65.0,\"f\":\"65\"},{\"v\":65.0,\"f\":\"65\"},{\"v\":69.0,\"f\":\"69\"},{\"v\":67.0,\"f\":\"67\"},{\"v\":65.0,\"f\":\"65\"},{\"v\":59.0,\"f\":\"59\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"Feri \"},{\"v\":50.5,\"f\":\"50.5\"},{\"v\":-11.5,\"f\":\"-11.5\"},{\"v\":62.0,\"f\":\"62\"},{\"v\":67.0,\"f\":\"67\"},{\"v\":60.0,\"f\":\"60\"},{\"v\":64.0,\"f\":\"64\"},{\"v\":63.0,\"f\":\"63\"},{\"v\":56.0,\"f\":\"56\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"ZoliDan \"},{\"v\":54.1,\"f\":\"54.1\"},{\"v\":-7.5,\"f\":\"-7.5\"},{\"v\":61.6,\"f\":\"61.6\"},{\"v\":66.0,\"f\":\"66\"},{\"v\":59.0,\"f\":\"59\"},{\"v\":65.0,\"f\":\"65\"},{\"v\":58.0,\"f\":\"58\"},{\"v\":60.0,\"f\":\"60\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"Istuu \"},{\"v\":71.32,\"f\":\"71.32\"},{\"v\":5.0,\"f\":\"5\"},{\"v\":66.32,\"f\":\"66.32\"},{\"v\":67.0,\"f\":\"67\"},{\"v\":70.0,\"f\":\"70\"},{\"v\":67.0,\"f\":\"67\"},{\"v\":60.0,\"f\":\"60\"},{\"v\":67.6,\"f\":\"67.6\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"Lui \"},{\"v\":55.33,\"f\":\"55.33\"},{\"v\":-6.75,\"f\":\"-6.75\"},{\"v\":62.08,\"f\":\"62.08\"},{\"v\":65.0,\"f\":\"65\"},{\"v\":63.0,\"f\":\"63\"},{\"v\":65.0,\"f\":\"65\"},{\"v\":60.0,\"f\":\"60\"},{\"v\":57.4,\"f\":\"57.4\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"kuplung(Zsolt)\"},{\"v\":57.9,\"f\":\"57.9\"},{\"v\":0.5,\"f\":\"0.5\"},{\"v\":57.4,\"f\":\"57.4\"},{\"v\":57.0,\"f\":\"57\"},{\"v\":62.0,\"f\":\"62\"},{\"v\":60.0,\"f\":\"60\"},{\"v\":52.0,\"f\":\"52\"},{\"v\":56.0,\"f\":\"56\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"Ruszkika \"},{\"v\":58.17,\"f\":\"58.17\"},{\"v\":0.5,\"f\":\"0.5\"},{\"v\":57.67,\"f\":\"57.67\"},{\"v\":55.0,\"f\":\"55\"},{\"v\":63.0,\"f\":\"63\"},{\"v\":55.0,\"f\":\"55\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"szury \"},{\"v\":51.25,\"f\":\"51.25\"},{\"v\":-5.75,\"f\":\"-5.75\"},{\"v\":57.0,\"f\":\"57\"},null,{\"v\":62.0,\"f\":\"62\"},{\"v\":60.0,\"f\":\"60\"},{\"v\":52.0,\"f\":\"52\"},{\"v\":54.0,\"f\":\"54\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"Attila \"},{\"v\":55.25,\"f\":\"55.25\"},{\"v\":-5.25,\"f\":\"-5.25\"},{\"v\":60.5,\"f\":\"60.5\"},{\"v\":54.0,\"f\":\"54\"},{\"v\":60.0,\"f\":\"60\"},{\"v\":63.0,\"f\":\"63\"},{\"v\":65.0,\"f\":\"65\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"thezolo \"},{\"v\":60.67,\"f\":\"60.67\"},{\"v\":2.0,\"f\":\"2\"},{\"v\":58.67,\"f\":\"58.67\"},{\"v\":50.0,\"f\":\"50\"},{\"v\":63.0,\"f\":\"63\"},{\"v\":63.0,\"f\":\"63\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"Lukacs \"},{\"v\":45.72,\"f\":\"45.72\"},{\"v\":-6.0,\"f\":\"-6\"},{\"v\":51.72,\"f\":\"51.72\"},{\"v\":50.0,\"f\":\"50\"},{\"v\":50.0,\"f\":\"50\"},{\"v\":48.6,\"f\":\"48.6\"},{\"v\":58.0,\"f\":\"58\"},{\"v\":52.0,\"f\":\"52\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"dezsi(andras)\"},{\"v\":45.0,\"f\":\"45\"},{\"v\":0.0,\"f\":\"0\"},{\"v\":45.0,\"f\":\"45\"},{\"v\":45.0,\"f\":\"45\"},{\"v\":45.0,\"f\":\"45\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"cslevy \"},{\"v\":39.35,\"f\":\"39.35\"},{\"v\":1.75,\"f\":\"1.75\"},{\"v\":37.6,\"f\":\"37.6\"},{\"v\":39.0,\"f\":\"39\"},{\"v\":38.0,\"f\":\"38\"},{\"v\":37.0,\"f\":\"37\"},{\"v\":27.0,\"f\":\"27\"},{\"v\":47.0,\"f\":\"47\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"berti \"},{\"v\":52.7,\"f\":\"52.7\"},{\"v\":8.5,\"f\":\"8.5\"},{\"v\":44.2,\"f\":\"44.2\"},{\"v\":35.0,\"f\":\"35\"},{\"v\":55.0,\"f\":\"55\"},{\"v\":45.0,\"f\":\"45\"},{\"v\":37.0,\"f\":\"37\"},{\"v\":49.0,\"f\":\"49\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"Karoly \"},{\"v\":32.0,\"f\":\"32\"},{\"v\":-6.0,\"f\":\"-6\"},{\"v\":38.0,\"f\":\"38\"},{\"v\":30.0,\"f\":\"30\"},{\"v\":30.0,\"f\":\"30\"},{\"v\":30.0,\"f\":\"30\"},{\"v\":60.0,\"f\":\"60\"},{\"v\":40.0,\"f\":\"40\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"sanyecki \"},{\"v\":48.25,\"f\":\"48.25\"},{\"v\":14.25,\"f\":\"14.25\"},{\"v\":34.0,\"f\":\"34\"},{\"v\":24.0,\"f\":\"24\"},{\"v\":40.0,\"f\":\"40\"},{\"v\":35.0,\"f\":\"35\"},{\"v\":34.0,\"f\":\"34\"},{\"v\":37.0,\"f\":\"37\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"Penzes Levi\"},{\"v\":68.5,\"f\":\"68.5\"},{\"v\":3.25,\"f\":\"3.25\"},{\"v\":65.25,\"f\":\"65.25\"},{\"v\":66.0,\"f\":\"66\"},{\"v\":66.0,\"f\":\"66\"},{\"v\":64.0,\"f\":\"64\"},null,{\"v\":65.0,\"f\":\"65\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"Balazs\"},{\"v\":47.83,\"f\":\"47.83\"},{\"v\":-0.5,\"f\":\"-0.5\"},{\"v\":48.33,\"f\":\"48.33\"},{\"v\":50.0,\"f\":\"50\"},{\"v\":50.0,\"f\":\"50\"},{\"v\":45.0,\"f\":\"45\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"Peter Robi\"},{\"v\":78.25,\"f\":\"78.25\"},{\"v\":1.25,\"f\":\"1.25\"},{\"v\":77.0,\"f\":\"77\"},{\"v\":77.0,\"f\":\"77\"},{\"v\":77.0,\"f\":\"77\"},{\"v\":80.0,\"f\":\"80\"},{\"v\":74.0,\"f\":\"74\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"csabarobert\"},{\"v\":63.67,\"f\":\"63.67\"},{\"v\":-3.0,\"f\":\"-3\"},{\"v\":66.67,\"f\":\"66.67\"},{\"v\":70.0,\"f\":\"70\"},{\"v\":65.0,\"f\":\"65\"},{\"v\":65.0,\"f\":\"65\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"Zsolt Rozsa\"},{\"v\":42.17,\"f\":\"42.17\"},{\"v\":-3.5,\"f\":\"-3.5\"},{\"v\":45.67,\"f\":\"45.67\"},{\"v\":40.0,\"f\":\"40\"},{\"v\":55.0,\"f\":\"55\"},{\"v\":42.0,\"f\":\"42\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"Szixi\"},{\"v\":81.83,\"f\":\"81.83\"},{\"v\":4.5,\"f\":\"4.5\"},{\"v\":77.33,\"f\":\"77.33\"},null,{\"v\":80.0,\"f\":\"80\"},{\"v\":77.0,\"f\":\"77\"},{\"v\":75.0,\"f\":\"75\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"Darthur\"},{\"v\":59.0,\"f\":\"59\"},{\"v\":-1.0,\"f\":\"-1\"},{\"v\":60.0,\"f\":\"60\"},{\"v\":55.0,\"f\":\"55\"},{\"v\":65.0,\"f\":\"65\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"DIsti\"},{\"v\":64.0,\"f\":\"64\"},{\"v\":-1.0,\"f\":\"-1\"},{\"v\":65.0,\"f\":\"65\"},null,{\"v\":65.0,\"f\":\"65\"},{\"v\":65.0,\"f\":\"65\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]},{\"c\":[{\"v\":\"Vinitor\"},{\"v\":59.67,\"f\":\"59.67\"},{\"v\":-1.0,\"f\":\"-1\"},{\"v\":60.67,\"f\":\"60.67\"},{\"v\":55.0,\"f\":\"55\"},{\"v\":65.0,\"f\":\"65\"},null,{\"v\":62.0,\"f\":\"62\"},null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,{\"v\":null}]}]}});";

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

