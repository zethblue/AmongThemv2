package amongthem.rooms;

public class Upper_Engine extends Room {

    public Upper_Engine() {
        roomname = RoomNames.UPPER_ENGINE;
        nextRooms = new RoomNames[2];
        nextRooms[0] = RoomNames.UPPER_ENGINE_SECURITY_REACTOR_LOWER_ENGINE_PATH;
        nextRooms[1] = RoomNames.CAFETERIA_MEDBAY_UPPER_ENGINE_PATH;

        vents = new RoomNames[1];
        vents[0] = RoomNames.REACTOR;
    }
}
