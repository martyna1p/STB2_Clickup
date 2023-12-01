package pl.akademiaqa.url.propertise;

import java.util.ResourceBundle;

public class ClickUpProperties { //potrzebujemy tej klasy by móc odczytać propertisy z pliku propertisowego

    private static final String TOKEN = "clickup.token";
    private static final String TEAM_ID = "clickup.team.id";

    public static String getToken() {  //metody które zwrocą nam wartość propertisów
        return getProperty(TOKEN);

    }

    public static String getTeamId() {
        return getProperty(TEAM_ID);

    }

    private static String getProperty(String key) {
        return ResourceBundle.getBundle("clickup").getString(key); // za każdym razem będziemy musieli podac nazwę klucza a nazwą będą : clickup.token albo clickup.team.id
    }
}
