package amongthem.rooms;

public class Medbay extends Room {

    public Medbay() {
        roomname = RoomNames.MEDBAY;
        nextRooms = new RoomNames[1];
        nextRooms[0] = RoomNames.CAFETERIA_MEDBAY_UPPER_ENGINE_PATH;

        vents = new RoomNames[2];
        vents[0] = RoomNames.ELECTRICAL;
        vents[1] = RoomNames.SECURITY;

    }
}
