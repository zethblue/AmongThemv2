package amongthem.rooms;

public class Shields extends Room {

    public Shields() {
        roomname = RoomNames.WEAPONS;
        nextRooms = new RoomNames[2];
        nextRooms[0] = RoomNames.WEAPONS_O2_NAVIGATION_SHIELDS_PATH;
        nextRooms[1] = RoomNames.SHIELDS_COMMUNICATION_STORAGE_PATH;

        vents = new RoomNames[1];
        vents[0] = RoomNames.NAVIGATION;


    }
}
