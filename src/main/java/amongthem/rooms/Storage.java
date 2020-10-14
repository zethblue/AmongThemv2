package amongthem.rooms;

public class Storage extends Room {

    public Storage() {
        roomname = RoomNames.STORAGE;
        nextRooms = new RoomNames[3];
        nextRooms[0] = RoomNames.CAFETERIA_ADMIN_STORAGE_PATH;
        nextRooms[1] = RoomNames.SHIELDS_COMMUNICATION_STORAGE_PATH;
        nextRooms[2] = RoomNames.LOWER_ENGINE_ELECTRICAL_STORAGE_PATH;

        vents = null;



    }
}
