package amongthem.game;

import amongthem.player.Names;
import amongthem.player.Player;

import java.util.ArrayList;
import java.util.Random;

public class CreatePlayers {

    private static final int maxPlayers = 10;

    public static ArrayList<Player> createPlayers(){
        Random randomizer = new Random();
        ArrayList<Player> createdPlayers = new ArrayList<>();
        while(createdPlayers.size() < maxPlayers){
            int i = randomizer.nextInt(11);
            Player p = new Player(playerInttoEnum(i));
            boolean playerisNotInList = createdPlayers.stream().noneMatch(player -> p.getName().equals(player.getName()));
            if(playerisNotInList){
                createdPlayers.add(p);
            }

        }
        return createdPlayers;
    }

    private static Names playerInttoEnum(int i) {
        switch (i) {
            case 2:
                return Names.BLUE;
            case 3:
                return Names.BLACK;
            case 4:
                return Names.GREEN;
            case 5:
                return Names.CYAN;
            case 6:
                return Names.BROWN;
            case 7:
                return Names.LIME;
            case 8:
                return Names.ORANGE;
            case 9:
                return Names.PINK;
            case 10:
                return Names.PURPLE;
            case 11:
                return Names.YELLOW;
            case 1:
                return Names.WHITE;
            default:
                return Names.RED;
        }
    }
}


