package amongthem.rooms;

public class Path_CaWeap extends Room {

    public Path_CaWeap() {
        roomname = RoomNames.CAFETERIA_WEAPONS_PATH;
        nextRooms = new RoomNames[2];
        nextRooms[0] = RoomNames.CAFETERIA;
        nextRooms[1] = RoomNames.WEAPONS;

        vents = null;

    }
}
