package amongthem.rooms;

public class Navigation extends Room {

    public Navigation() {
        roomname = RoomNames.NAVIGATION;
        nextRooms = new RoomNames[1];
        nextRooms[0] = RoomNames.WEAPONS_O2_NAVIGATION_SHIELDS_PATH;

        vents = new RoomNames[2];
        vents[0] = RoomNames.WEAPONS;
        vents[1] = RoomNames.SHIELDS;

    }
}
