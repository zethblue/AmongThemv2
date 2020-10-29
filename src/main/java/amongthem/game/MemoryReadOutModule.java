package amongthem.game;

import amongthem.player.Memory;
import amongthem.player.Player;
import amongthem.rooms.RoomNames;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MemoryReadOutModule {
    Random randomizer;
    Player p;
    List<Memory> memoryList;
    StringBuilder myStatement1; //actual location
    StringBuilder myStatement2; //what happened


    public MemoryReadOutModule(Player player) {
        this.p = player;
        myStatement1 = new StringBuilder();
        myStatement2 = new StringBuilder();
        if(!p.isDead()) {
            memoryList = new ArrayList<>();
            memoryList.addAll(player.getMemories());
            randomizer = new Random();

            myStatement1.append(actualLocationPhraseStringgetter());
            myStatement1.append(PlayerLocationStringgetter(p.getPlayerLocation()));
            myStatement2MemoryLoader();
        }
        else{
            myStatement1.append("THIS PLAYER IS ");
            myStatement2.append("DEAD");
        }


    }

    private String actualLocationPhraseStringgetter() {

        int i = randomizer.nextInt(4);

        switch (i) {
            case 0:
                return "Last i was in ";
            case 1:
                return "I was just in ";
            case 2:
                return "I was in ";
            case 3:
                return "My last location was ";
            case 4:
                return "My location: ";
            default:
                return "!!!Default Warning - this text should not appear !!!";

        }
    }
    private String PlayerLocationStringgetter(RoomNames rr){
        switch (rr){
            case LOWER_ENGINE: return "LOWER ENGINE";
            case REACTOR: return "REACTOR";
            case UPPER_ENGINE: return "UPPER ENGINE";
            case STORAGE: return "STORAGE";
            case COMMUNICATION: return "COMMUNICATIONS";
            case WEAPONS: return "WEAPONS";
            case CAFETERIA: return "CAFETERIA";
            case O2: return "O2";
            case NAVIGATION: return "NAVIGATION";
            case ELECTRICAL: return "ELECTRICAL";
            case SHIELDS: return "SHIELDS";
            case MEDBAY: return "MEDBAY";
            case SECURITY: return "SECURITY";
            case ADMIN: return "ADMIN";
            case UPPER_ENGINE_SECURITY_REACTOR_LOWER_ENGINE_PATH: return "PASSAGEWAY between the UPPER and LOWER ENGINE";
            case LOWER_ENGINE_ELECTRICAL_STORAGE_PATH: return "PASSAGEWAY between LOWER ENGINE and STORAGE";
            case SHIELDS_COMMUNICATION_STORAGE_PATH: return "PASSAGEWAY between STORAGE and SHIELDS";
            case CAFETERIA_ADMIN_STORAGE_PATH: return "PASSAGEWAY between CAFETERIA and STORAGE";
            case CAFETERIA_WEAPONS_PATH: return "PASSAGEWAY between CAFETERIA and WEAPONS";
            case WEAPONS_O2_NAVIGATION_SHIELDS_PATH: return "PASSAGEWAY between WEAPONS and SHIELDS";
            case CAFETERIA_MEDBAY_UPPER_ENGINE_PATH: return "PASSAGEWAY between CAFETERIA and UPPER ENGINE";
            default: return null;
        }


    }
    private void myStatement2MemoryLoader(){
        for(Memory m : memoryList){
            StringBuilder playerISee = new StringBuilder();
            for(Player p : m.getPlayersSeen()){
                playerISee.append(p.getName().toString()).append(",");
            }
            myStatement2.append("Room:").append(m.getRoomname()).append("PlayersSeenThere: ").append(playerISee).append("$$$");
        }
    }
    public String myStatement1Getter(){
        return myStatement1.toString();
    }
    public String myStatement2Getter(){
        return myStatement2.toString();
    }

}
