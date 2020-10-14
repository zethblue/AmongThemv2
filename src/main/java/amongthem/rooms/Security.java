package amongthem.rooms;

public class Security extends Room {

    public Security() {
        roomname = RoomNames.SECURITY;
        nextRooms = new RoomNames[1];
        nextRooms[0] = RoomNames.UPPER_ENGINE_SECURITY_REACTOR_LOWER_ENGINE_PATH;

        vents = new RoomNames[2];
        vents[0] = RoomNames.ELECTRICAL;
        vents[1] = RoomNames.MEDBAY;

    }
}
