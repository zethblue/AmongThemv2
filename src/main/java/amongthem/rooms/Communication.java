package amongthem.rooms;

public class Communication extends Room {

    public Communication() {
        roomname = RoomNames.COMMUNICATION;
        nextRooms = new RoomNames[1];
        nextRooms[0] = RoomNames.SHIELDS_COMMUNICATION_STORAGE_PATH;

        vents = null;

    }
}
