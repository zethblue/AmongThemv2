
import amongthem.game.Game;
import amongthem.player.Player;
import amongthem.rooms.RoomNames;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class gameTests {

    Game testGame;


    public gameTests(){
        testGame = new Game();
    }

    @Test
    public void gameTestCreation(){

        testGame.startGamegetPlayerList();

        assertEquals(testGame.getGamePlayersAlive().size(),10);

        testGame.startGameSetImposters();

        int imposter = 0;
        for(Player p : testGame.getGamePlayersAlive()){
            if(p.isImpostor()) imposter++;
        }
        assertEquals(2,imposter);

        testGame.setKillTimers();

        for(Player p : testGame.getGamePlayersAlive()){
            assertTrue(p.getKillTimer() > 39 & p.getKillTimer() < 81);
        }

        testGame.startGameCreateNewTaskListforAllPlayers(15);

        for(Player p : testGame.getGamePlayersAlive()){
            assertNotNull(p.getActiveTask());
        }

        testGame.startRoundMovePlayersToCafeteria();

        for(Player p : testGame.getGamePlayersAlive()){
            assertNotNull(p.getPlayerLocation());
        }

        testGame.startRoundSetPlayerMoveTimesAndRoute();

        for(Player p : testGame.getGamePlayersAlive()){
            assertEquals(10,p.getMovingTimeTicks());
            assertNotNull(p.getMovingLocationTarget());
        }

    }
    @Test
    public void testIsAnotherPlayerInMyRoom(){

        testGame.startGamegetPlayerList();

        List<Player> players = testGame.getGamePlayersAlive();
        players.get(0).setPlayerLocation(RoomNames.ADMIN);
        players.get(1).setPlayerLocation(RoomNames.ADMIN);
        players.get(2).setPlayerLocation(RoomNames.O2);
        players.get(3).setPlayerLocation(RoomNames.COMMUNICATION);
        players.get(4).setPlayerLocation(RoomNames.MEDBAY);
        players.get(5).setPlayerLocation(RoomNames.MEDBAY);
        players.get(6).setPlayerLocation(RoomNames.MEDBAY);
        players.get(7).setPlayerLocation(RoomNames.CAFETERIA_WEAPONS_PATH);
        players.get(8).setPlayerLocation(RoomNames.LOWER_ENGINE_ELECTRICAL_STORAGE_PATH);
        players.get(9).setPlayerLocation(RoomNames.LOWER_ENGINE_ELECTRICAL_STORAGE_PATH);

        List<Player> testPlayerList = testGame.isAnotherPlayerInMyRoom(players.get(0));
        assertNotNull(testPlayerList);
        assertEquals(2,testPlayerList.size());
        assertEquals(testPlayerList.get(0),players.get(0));
        assertEquals(testPlayerList.get(1),players.get(1));
        testPlayerList = testGame.isAnotherPlayerInMyRoom(players.get(4));
        assertEquals(3,testPlayerList.size());
        assertEquals(testPlayerList.get(0),players.get(4));
        assertEquals(testPlayerList.get(1),players.get(5));
        assertEquals(testPlayerList.get(2),players.get(6));






    }


}
