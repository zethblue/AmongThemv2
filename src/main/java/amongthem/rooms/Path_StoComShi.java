package amongthem.rooms;

public class Path_StoComShi extends Room {

    public Path_StoComShi() {
        roomname = RoomNames.SHIELDS_COMMUNICATION_STORAGE_PATH;
        nextRooms = new RoomNames[3];
        nextRooms[0] = RoomNames.STORAGE;
        nextRooms[1] = RoomNames.COMMUNICATION;
        nextRooms[2] = RoomNames.SHIELDS;

        vents = null;

    }
}
