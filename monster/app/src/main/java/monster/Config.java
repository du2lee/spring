package monster;

public class Config {
    private static Config config = new Config();

    private Config() {}

    public static Config getInstance(){
        return config;
    }

    private static String dayOrNight = "day";

    public static void setDayOrNight(String val){
        dayOrNight = val;
    }

    public static String getDayOrNight(){
        return dayOrNight;
    }
}
