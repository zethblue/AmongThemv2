import amongthem.game.CreatePlayers;
import amongthem.player.Player;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class playerNamesTest {

    @Test
    public void testCreatePlayerNumber(){
        assertEquals(CreatePlayers.createPlayers().size(),10);
        assertEquals(CreatePlayers.createPlayers().size(),10);
        assertEquals(CreatePlayers.createPlayers().size(),10);
        assertEquals(CreatePlayers.createPlayers().size(),10);
        assertEquals(CreatePlayers.createPlayers().size(),10);
        assertEquals(CreatePlayers.createPlayers().size(),10);
        assertEquals(CreatePlayers.createPlayers().size(),10);
        assertEquals(CreatePlayers.createPlayers().size(),10);
        assertEquals(CreatePlayers.createPlayers().size(),10);
        assertEquals(CreatePlayers.createPlayers().size(),10);
    }

    @Test
    public void testNoSamePlayers() {
        List<Player> inputListe = CreatePlayers.createPlayers();

        for(int i = 0; i < inputListe.size(); i++){
            Player p = inputListe.get(i);

            List<Player> listeOhnePlayerp = inputListe.stream().filter(player -> p != player).collect(Collectors.toList());

            for(Player p2 : listeOhnePlayerp){
                assertNotEquals(p2.getName().toString(), p.getName().toString());
            }

        }
    }

}
