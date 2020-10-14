package amongthem.rooms;

public class Path_UpEMedCaf extends Room {

    public Path_UpEMedCaf() {
        roomname = RoomNames.CAFETERIA_MEDBAY_UPPER_ENGINE_PATH;
        nextRooms = new RoomNames[3];
        nextRooms[0] = RoomNames.UPPER_ENGINE;
        nextRooms[1] = RoomNames.CAFETERIA;
        nextRooms[2] = RoomNames.MEDBAY;

        vents = null;

    }
}
