package amongthem.rooms;

public class Path_WeO2NavShi extends Room {

    public Path_WeO2NavShi() {
        roomname = RoomNames.WEAPONS_O2_NAVIGATION_SHIELDS_PATH;
        nextRooms = new RoomNames[4];
        nextRooms[0] = RoomNames.WEAPONS;
        nextRooms[1] = RoomNames.O2;
        nextRooms[2] = RoomNames.NAVIGATION;
        nextRooms[3] = RoomNames.SHIELDS;

        vents = new RoomNames[2];
        vents[0] = RoomNames.ADMIN;
        vents[1] = RoomNames.CAFETERIA;

    }
}
