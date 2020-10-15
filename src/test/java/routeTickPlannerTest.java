
import amongthem.game.RouteTickPlanner;
import amongthem.rooms.RoomNames;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class routeTickPlannerTest {
    @Test
    public void testTicksforMovingnotMinus(){

        assertNotEquals(RouteTickPlanner.TicksForMoving(RoomNames.CAFETERIA),-1);
        assertNotEquals(RouteTickPlanner.TicksForMoving(RoomNames.ADMIN),-1);
        assertNotEquals(RouteTickPlanner.TicksForMoving(RoomNames.COMMUNICATION),-1);
        assertNotEquals(RouteTickPlanner.TicksForMoving(RoomNames.ELECTRICAL),-1);
        assertNotEquals(RouteTickPlanner.TicksForMoving(RoomNames.LOWER_ENGINE),-1);
        assertNotEquals(RouteTickPlanner.TicksForMoving(RoomNames.MEDBAY),-1);
        assertNotEquals(RouteTickPlanner.TicksForMoving(RoomNames.O2),-1);
        assertNotEquals(RouteTickPlanner.TicksForMoving(RoomNames.REACTOR),-1);
        assertNotEquals(RouteTickPlanner.TicksForMoving(RoomNames.SECURITY),-1);
        assertNotEquals(RouteTickPlanner.TicksForMoving(RoomNames.SHIELDS),-1);
        assertNotEquals(RouteTickPlanner.TicksForMoving(RoomNames.STORAGE),-1);
        assertNotEquals(RouteTickPlanner.TicksForMoving(RoomNames.UPPER_ENGINE),-1);
        assertNotEquals(RouteTickPlanner.TicksForMoving(RoomNames.WEAPONS),-1);
        assertNotEquals(RouteTickPlanner.TicksForMoving(RoomNames.UPPER_ENGINE_SECURITY_REACTOR_LOWER_ENGINE_PATH),-1);
        assertNotEquals(RouteTickPlanner.TicksForMoving(RoomNames.LOWER_ENGINE_ELECTRICAL_STORAGE_PATH),-1);
        assertNotEquals(RouteTickPlanner.TicksForMoving(RoomNames.CAFETERIA_MEDBAY_UPPER_ENGINE_PATH),-1);
        assertNotEquals(RouteTickPlanner.TicksForMoving(RoomNames.CAFETERIA_ADMIN_STORAGE_PATH),-1);
        assertNotEquals(RouteTickPlanner.TicksForMoving(RoomNames.SHIELDS_COMMUNICATION_STORAGE_PATH),-1);
        assertNotEquals(RouteTickPlanner.TicksForMoving(RoomNames.WEAPONS_O2_NAVIGATION_SHIELDS_PATH),-1);
        assertNotEquals(RouteTickPlanner.TicksForMoving(RoomNames.CAFETERIA_WEAPONS_PATH),-1);



    }
    @Test
    public void testTicksforMovingRelations(){
        assertTrue(RouteTickPlanner.TicksForMoving(RoomNames.CAFETERIA_WEAPONS_PATH) < RouteTickPlanner.TicksForMoving(RoomNames.STORAGE));
        assertTrue(RouteTickPlanner.TicksForMoving(RoomNames.ADMIN) < RouteTickPlanner.TicksForMoving(RoomNames.WEAPONS_O2_NAVIGATION_SHIELDS_PATH));
        assertTrue(RouteTickPlanner.TicksForMoving(RoomNames.SHIELDS) < RouteTickPlanner.TicksForMoving(RoomNames.CAFETERIA));

    }

}
