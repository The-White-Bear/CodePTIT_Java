package CodePTIT_Java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

class Player {
    String code;
    String name;
    Date startTime;
    Date endTime;

    public Player(String code, String name, String startTime, String endTime) throws ParseException {
        this.code = code;
        this.name = name;
        this.startTime = new SimpleDateFormat("HH:mm").parse(startTime);
        this.endTime = new SimpleDateFormat("HH:mm").parse(endTime);
    }

    public long getPlayTime() {
        return endTime.getTime() - startTime.getTime();
    }

    @Override
    public String toString() {
        return code + " " + name + " " + formatTime(getPlayTime());
    }

    private String formatTime(long milliseconds) {
        long minutes = milliseconds / (60 * 1000);
        long hours = minutes / 60;
        minutes %= 60;
        return String.format("%d gio %d phut", hours, minutes);
    }
}

public class J05011 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int numPlayers = Integer.parseInt(scanner.nextLine());
        Player[] players = new Player[numPlayers];

        for (int i = 0; i < numPlayers; i++) {
            String code = scanner.nextLine();
            String name = scanner.nextLine();
            String startTime = scanner.nextLine();
            String endTime = scanner.nextLine();

            players[i] = new Player(code, name, startTime, endTime);
        }

        Arrays.sort(players, Comparator.comparingLong(Player::getPlayTime).reversed());

        for (Player player : players) {
            System.out.println(player);
        }
    }
}
