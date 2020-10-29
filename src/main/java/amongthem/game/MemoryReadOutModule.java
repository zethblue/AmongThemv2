package amongthem.game;

import amongthem.player.Memory;
import amongthem.player.Player;
import amongthem.rooms.RoomNames;

import java.lang.reflect.Array;
import java.util.*;

public class MemoryReadOutModule {
    Player p;
    List<Memory> memoryList;


    public MemoryReadOutModule(Player player) {
        this.p = player;
        this.memoryList = p.getMemories();
    }

    public String MemoryExtractor(){
        List<Memory> cleanedMemories = new ArrayList<>();
        StringBuilder statement = new StringBuilder();
        Memory cleanMemory = null;
        List<Player> tempPlayerListSeen;
        List<Player> tempPlayerListTask;
        boolean bRoomName;
        boolean bPlayersSeen;
        boolean bPlayerDidTask;
        int infoAnzahl;
        for(Memory m : memoryList){

            bRoomName = false; bPlayerDidTask = false; bPlayersSeen = false;
            if(!(cleanMemory == null)) {
                if (cleanMemory.getRoomname() == m.getRoomname()) bRoomName = true;
                if (cleanMemory.getPlayersSeen().equals(m.getPlayersSeen())) bPlayersSeen = true;
                if (cleanMemory.getPlayersDidTask().equals(m.getPlayersDidTask())) bPlayerDidTask = true;
            }

                if(!bRoomName){

                    if(!(cleanMemory == null)){
                        cleanedMemories.add(cleanMemory);
                    }
                    cleanMemory = new Memory();
                    cleanMemory.setRoomname(m.getRoomname());
                    tempPlayerListSeen = new ArrayList<>(m.getPlayersSeen());
                    tempPlayerListTask = new ArrayList<>(m.getPlayersDidTask());
                    cleanMemory.setPlayersSeen(tempPlayerListSeen);
                    cleanMemory.forMemoryReadOutsetPlayerDidTask(tempPlayerListTask);
                }

                if(!bPlayersSeen){
                    for(Player p : m.getPlayersSeen()){
                        if(!(cleanMemory.getPlayersSeen().contains(p))){
                            cleanMemory.getPlayersSeen().add(p);
                        }
                    }
                }

                if(!bPlayerDidTask){
                    for(Player p : m.getPlayersDidTask()){
                        if(!(cleanMemory.getPlayersDidTask().contains(p))){
                            cleanMemory.getPlayersDidTask().add(p);
                        }
                    }

                }

                if(m == memoryList.get(memoryList.size()-1)){
                    if(!(cleanedMemories.get(cleanedMemories.size()-1).equals(cleanMemory))){cleanedMemories.add(cleanMemory);}

                }

        }

        for(Memory m : cleanedMemories){
            m.getPlayersSeen().remove(p);
        }

        if(cleanedMemories.size() > 5){
            infoAnzahl = 5;
        }else infoAnzahl = cleanedMemories.size();
        for(int minusMaxSize = 1; infoAnzahl > 0;minusMaxSize++){

            Memory tempMemory = cleanedMemories.get(cleanedMemories.size()-minusMaxSize);
            if(minusMaxSize == 1){
                statement.append("The last Room i was in was ");
            }
            else{
                statement.append("Before that i was in ");
            }
            statement.append(PlayerLocationStringgetter(tempMemory.getRoomname()));
            statement.append(". <br>");
            if(tempMemory.getPlayersSeen().isEmpty()){
                statement.append("I don't saw anybody there. <br>");
            }
            else{
                statement.append("I think I saw ");
                switch (tempMemory.getPlayersSeen().size()){
                    case 1: statement.append(tempMemory.getPlayersSeen().get(0).getName().toString());
                            statement.append(". ");
                            break;
                    case 2: statement.append(tempMemory.getPlayersSeen().get(0).getName().toString());
                            statement.append(" and ");
                            statement.append(tempMemory.getPlayersSeen().get(1).getName().toString());
                            break;
                    case 3: statement.append(tempMemory.getPlayersSeen().get(0).getName().toString());
                            statement.append(", ");
                            statement.append(tempMemory.getPlayersSeen().get(1).getName().toString());
                            statement.append(" and ");
                            statement.append(tempMemory.getPlayersSeen().get(2).getName().toString());
                            break;
                    case 4:
                    case 5:
                            statement.append(tempMemory.getPlayersSeen().get(0).getName().toString());
                            statement.append(", ");
                            statement.append(tempMemory.getPlayersSeen().get(1).getName().toString());
                            statement.append(", ");
                            statement.append(tempMemory.getPlayersSeen().get(2).getName().toString());
                            statement.append( " and I think one or two more. ");
                            break;
                    case 6:
                    case 7:
                    case 8:
                            statement.append(tempMemory.getPlayersSeen().get(0).getName().toString());
                            statement.append(", ");
                            statement.append(tempMemory.getPlayersSeen().get(1).getName().toString());
                            statement.append(", ");
                            statement.append(tempMemory.getPlayersSeen().get(2).getName().toString());
                            statement.append( "and I think there were many more.");
                            break;
                    default:statement.append("I think i saw everyone there.");
                            break;

                }
                statement.append("<br>");
                    }
            infoAnzahl--;
                }
        return statement.toString();
        }

    public static String PlayerLocationStringgetter(RoomNames rr){
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


}
