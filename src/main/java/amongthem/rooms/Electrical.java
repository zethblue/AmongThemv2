package amongthem.rooms;

public class Electrical extends Room {

    public Electrical() {
        roomname = RoomNames.ELECTRICAL;
        nextRooms = new RoomNames[1];
        nextRooms[0] = RoomNames.LOWER_ENGINE_ELECTRICAL_STORAGE_PATH;

        vents = new RoomNames[2];
        vents[0] = RoomNames.MEDBAY;
        vents[1] = RoomNames.SECURITY;
    }
}
