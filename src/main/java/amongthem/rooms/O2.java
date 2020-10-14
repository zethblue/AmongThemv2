package amongthem.rooms;

public class O2 extends Room {

    public O2() {
        roomname = RoomNames.O2;
        nextRooms = new RoomNames[1];
        nextRooms[0] = RoomNames.WEAPONS_O2_NAVIGATION_SHIELDS_PATH;

        vents = null;

    }
}

