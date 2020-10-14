package amongthem.tasks;

import amongthem.rooms.RoomNames;

public class Task {

    private int ticksUsed;
    private RoomNames taskIsInRoom;

    public Task(int ticksUsed, RoomNames taskIsInRoom) {
        this.ticksUsed = ticksUsed;
        this.taskIsInRoom = taskIsInRoom;
    }
    public int getTicksUsed() {
        return ticksUsed;
    }
    public RoomNames getTaskIsInRoom() {
        return taskIsInRoom;
    }

}
