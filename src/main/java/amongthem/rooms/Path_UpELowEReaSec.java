package amongthem.rooms;

public class Path_UpELowEReaSec extends Room {

    public Path_UpELowEReaSec() {
        roomname = RoomNames.UPPER_ENGINE_SECURITY_REACTOR_LOWER_ENGINE_PATH;
        nextRooms = new RoomNames[4];
        nextRooms[0] = RoomNames.UPPER_ENGINE;
        nextRooms[1] = RoomNames.REACTOR;
        nextRooms[2] = RoomNames.SECURITY;
        nextRooms[3] = RoomNames.LOWER_ENGINE;


        vents = null;

    }
}
