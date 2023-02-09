package BaseTeam;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;

public class TeamRCB {


        public static void main(String[] args) {
            String jsonPath = "C:\\Praful\\ProjectRCB\\TeamRCB\\src\\main\\resources\\test.json";

            readJson(jsonPath);

        }
// TODO Auto-generated method stub

        public static void readJson(String jsonPath) {
            JSONParser parser = new JSONParser();
            try {
                Object obj = parser.parse(new FileReader(jsonPath));
                JSONObject jsonObject = (JSONObject) obj;
                String name = (String) jsonObject.get("name");
                String location = (String) jsonObject.get("location");
                JSONArray players = (JSONArray) jsonObject.get("player");
                System.out.println("Name: " + name);
                System.out.println("Location: " + location);
                validatePlayers(players);
                validateWicketPlayer(players);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public static void validatePlayers(JSONArray players) {
            int countryCount = 0;
            for (int i = 0; i < players.length(); i++) {
                JSONObject jo = (JSONObject) players.get(i);
                String country = (String) jo.get("country");
                if (!country.equalsIgnoreCase("India")) {
                    countryCount++;
                }

            }
            if (countryCount == 4) {
                System.out.println("Foreign Player test case is passed!");
            }
        }

        public static void validateWicketPlayer(JSONArray players) {
            int roleCount = 0;
            for (int i = 0; i < players.length(); i++) {
                JSONObject jo = (JSONObject) players.get(i);
                String country = (String) jo.get("role");
                if (country.equalsIgnoreCase("Wicket-keeper")) {
                    roleCount++;
                }

            }
            if (roleCount >= 1) {
                System.out.println("Wicket Keeper test case is passed!");
            }

        }


}
