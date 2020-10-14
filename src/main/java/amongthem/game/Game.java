package amongthem.game;

import amongthem.player.Player;
import amongthem.rooms.RoomNames;

import java.util.HashMap;
import java.util.List;

public class Game {

    private List<Player> gamePlayers;
    private HashMap<Player, RoomNames> playerLocations;
    private HashMap<Player,Integer> playerMovingTimes;


    private void createNewTaskListforAllPlayers(int i){
        for(Player p : gamePlayers){
            p.setTaskList(CreateTasks.createTask(i));
        }
    }
    private void startRoundMovePlayersToCafeteria(){
        playerLocations = new HashMap<>();
        for(Player p : gamePlayers){
            playerLocations.put(p,RoomNames.CAFETERIA);
        }

    }
    private void startRoundSetPlayerMoveTimesToZero(){
        playerMovingTimes = new HashMap<>();
        for(Player p : gamePlayers){
            playerMovingTimes.put(p, 0);
        }
    }


}
