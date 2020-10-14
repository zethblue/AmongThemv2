package amongthem.rooms;

public class Path_LoEElecSto extends Room {

    public Path_LoEElecSto() {
        roomname = RoomNames.LOWER_ENGINE_ELECTRICAL_STORAGE_PATH;
        nextRooms = new RoomNames[3];
        nextRooms[0] = RoomNames.LOWER_ENGINE;
        nextRooms[1] = RoomNames.ELECTRICAL;
        nextRooms[2] = RoomNames.STORAGE;

        vents = null;

    }
}
