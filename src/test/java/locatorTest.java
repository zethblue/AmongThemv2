import amongthem.game.Locator;
import amongthem.rooms.RoomNames;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class locatorTest {

    @Test
    public void whereShallIGoTest(){

        assertEquals(Locator.whereShallIGo(RoomNames.O2, RoomNames.NAVIGATION), RoomNames.WEAPONS_O2_NAVIGATION_SHIELDS_PATH);
        assertEquals(Locator.whereShallIGo(RoomNames.UPPER_ENGINE_SECURITY_REACTOR_LOWER_ENGINE_PATH, RoomNames.SHIELDS), RoomNames.LOWER_ENGINE);
        assertEquals(Locator.whereShallIGo(RoomNames.CAFETERIA, RoomNames.COMMUNICATION), RoomNames.CAFETERIA_ADMIN_STORAGE_PATH);
        assertEquals(Locator.whereShallIGo(RoomNames.CAFETERIA, RoomNames.NAVIGATION), RoomNames.CAFETERIA_WEAPONS_PATH);

    }
}
