package amongthem.rooms;

public class Weapons extends Room {

    public Weapons() {
        roomname = RoomNames.WEAPONS;
        nextRooms = new RoomNames[2];
        nextRooms[0] = RoomNames.CAFETERIA_WEAPONS_PATH;
        nextRooms[1] = RoomNames.WEAPONS_O2_NAVIGATION_SHIELDS_PATH;

        vents = new RoomNames[1];
        vents[0] = RoomNames.NAVIGATION;


    }
}
