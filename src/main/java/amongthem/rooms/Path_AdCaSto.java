package amongthem.rooms;

public class Path_AdCaSto extends Room {

    public Path_AdCaSto() {
        roomname = RoomNames.CAFETERIA_ADMIN_STORAGE_PATH;
        nextRooms = new RoomNames[3];
        nextRooms[0] = RoomNames.CAFETERIA;
        nextRooms[1] = RoomNames.STORAGE;
        nextRooms[2] = RoomNames.ADMIN;


        vents = null;

    }
}
