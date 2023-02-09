import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
//import org.junit.Test;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.FileReader;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;


public class RCBTeam {

    // Method to check team has valid foreign players
    public boolean checkTeamHasFourForeignPlayers() {
        boolean isValid = false;
        try {
            JSONParser parser = new JSONParser();
            try {
                Object obj = parser.parse(new FileReader("C:/Praful/ProjectRCB/TeamRCB/src/main/resources/test.json"));
                JSONObject jsonObject = (JSONObject) obj;
                JSONArray playerList = (JSONArray) jsonObject.get("player");
                Iterator<JSONObject> iterator = playerList.iterator();
                int count = 0;
                while (iterator.hasNext()) {
                    JSONObject res = iterator.next();
                    String country = (String) res.get("country");
                    if (!country.equalsIgnoreCase("India")) {
                        count++;
                    }
                }
                if (count > 4) {
                    isValid = false;
                } else {
                    isValid = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isValid;
    }

    // Method to give count of wicketkeeper in team
    public int getWicketKeeperCount() {
        int wicketKeeperCount = 0;
        try {
            JSONParser parser = new JSONParser();
            try {
                Object obj = parser.parse(new FileReader("C:/Praful/ProjectRCB/TeamRCB/src/main/resources/test.json"));
                JSONObject jsonObject = (JSONObject) obj;
                JSONArray playerList = (JSONArray) jsonObject.get("player");
                Iterator<JSONObject> iterator = playerList.iterator();
                while (iterator.hasNext()) {
                    JSONObject res = iterator.next();
                    String role = (String) res.get("role");
                    if (role.equalsIgnoreCase("Wicket-keeper")) {
                        wicketKeeperCount++;
                    }
                }
                return wicketKeeperCount;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wicketKeeperCount;
    }

    // Test Case team_should_have_one_wicket_keeper
    @Test
    public void team_should_have_one_wicket_keeper() {
        int result = getWicketKeeperCount();
        Assert.assertEquals(result,1);
  }

    // Test Case team_should_have_four_foreign_players
    @Test
    public void team_should_have_four_foreign_players() {
        boolean result = checkTeamHasFourForeignPlayers();
        Assert.assertEquals(result, true);
    }


}
