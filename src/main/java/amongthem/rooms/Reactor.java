package amongthem.rooms;

public class Reactor extends Room {

    public Reactor() {
        roomname = RoomNames.REACTOR;
        nextRooms = new RoomNames[1];
        nextRooms[0] = RoomNames.UPPER_ENGINE_SECURITY_REACTOR_LOWER_ENGINE_PATH;

        vents = new RoomNames[2];
        vents[0] = RoomNames.UPPER_ENGINE;
        vents[1] = RoomNames.LOWER_ENGINE;

    }
}
