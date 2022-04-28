package monster;


import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import monster.goblin.Goblin;
import monster.goblin.GoblinCreator;
import monster.golem.Golem;
import monster.golem.GolemCreator;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class App {
    private static Collection<String> loadFileFromS3() {
        String ACCESS_KEY = "AKIATVXVV3NXQV6JQIMZ";
        String SECRET_KEY = "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";
        String bucketName = "great-hoon-bucket";
        String keyName = "dayOrNight.json";

        AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);

        AmazonS3 s3 = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.AP_NORTHEAST_2)
                .build();

        try (final S3Object s3Object = s3.getObject(bucketName, keyName);
             final InputStreamReader streamReader = new InputStreamReader(s3Object.getObjectContent(), StandardCharsets.UTF_8);
             final BufferedReader reader = new BufferedReader(streamReader)) {
            System.out.println("\n\n\n⬇⬇⬇⬇⬇⬇⬇⬇ 🚀s 3️⃣ 에서 값을 가져옵니다. ⬇⬇⬇⬇⬇⬇⬇⬇️\n\n\n");
            return reader.lines().collect(Collectors.toSet());
        } catch (final IOException e) {
            System.out.println(e.getMessage());
            return Collections.emptySet();
        }
    }

    private static String getSlotFromS3() {
        HashSet s3Val = (HashSet) loadFileFromS3();
        Iterator iter = s3Val.iterator();
        String jsonStr = "";
        while (iter.hasNext()) {
            jsonStr += iter.next().toString();
        }

        ObjectMapper mapper = new ObjectMapper();
        String json = jsonStr;

        Map<String, String> map = null;
        try {
            map = mapper.readValue(json, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String slot = map.get("dayOrNight");
        return slot;
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("🗡 ENTER TO FIELD ⛰");
        Random random = new Random();
        String golemType = "fire";
        GolemCreator golemFactory = new GolemCreator();

        String goblinType = "archer";
        GoblinCreator goblinFactory = new GoblinCreator();

        int sec = 5;
        int i = 0;
        while (true) {
            golemType = random.nextBoolean() ? "fire" : "ice";
            Golem golem = golemFactory.createGolem(golemType);

            goblinType = random.nextBoolean() ? "archer" : "thief";
            Goblin goblin = goblinFactory.createGoblin(goblinType);

            if ((i / 60) % 2 == 0) {
                Config.setDayOrNight("day");
            } else {
                if (!Config.getDayOrNight().equals("night")) {
                    Config.setDayOrNight(getSlotFromS3());
                }
            }

            String slot = Config.getDayOrNight();
            System.out.println("\nSTART################## " + i);
            if (slot.equals("day")) {
                System.out.println("🗿골렘이 출현하는 🌞낮 시간대 입니다.");
                System.out.println(golem.toString());
            } else if (slot.equals("night")) {
                System.out.println("😈고블린이 출현하는 🌜밤 시간대 입니다.");
                System.out.println(goblin.toString());
            }
            System.out.println("END################## " + i);

            i += sec;
            Thread.sleep(sec * 1000);
        }
    }
}
