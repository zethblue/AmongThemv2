package amongthem.rooms;

public class Cafeteria extends Room {

    public Cafeteria() {
        roomname = RoomNames.CAFETERIA;
        nextRooms = new RoomNames[3];
        nextRooms[0] = RoomNames.CAFETERIA_WEAPONS_PATH;
        nextRooms[1] = RoomNames.CAFETERIA_ADMIN_STORAGE_PATH;
        nextRooms[2] = RoomNames.CAFETERIA_MEDBAY_UPPER_ENGINE_PATH;

        vents = new RoomNames[2];
        vents[0] = RoomNames.WEAPONS_O2_NAVIGATION_SHIELDS_PATH;
        vents[1] = RoomNames.ADMIN;






    }
}
