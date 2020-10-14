package amongthem.rooms;

public class Admin extends Room {

    public Admin() {
        roomname = RoomNames.ADMIN;
        nextRooms = new RoomNames[1];
        nextRooms[0] = RoomNames.CAFETERIA_ADMIN_STORAGE_PATH;

        vents = null;

    }
}
