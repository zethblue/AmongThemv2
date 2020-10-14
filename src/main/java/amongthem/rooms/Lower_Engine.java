package amongthem.rooms;

public class Lower_Engine extends Room {

    public Lower_Engine() {
        roomname = RoomNames.LOWER_ENGINE;
        nextRooms = new RoomNames[2];
        nextRooms[0] = RoomNames.UPPER_ENGINE_SECURITY_REACTOR_LOWER_ENGINE_PATH;
        nextRooms[1] = RoomNames.LOWER_ENGINE_ELECTRICAL_STORAGE_PATH;

        vents = new RoomNames[1];
        vents[0] = RoomNames.REACTOR;

    }
}
