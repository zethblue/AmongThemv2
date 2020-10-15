package amongthem.player;

import amongthem.rooms.RoomNames;
import amongthem.tasks.Task;

import java.util.List;

public class Player {

    private Names name;
    private List<Task> taskList;
    private List<Memory> Memories;
    private RoomNames playerLocation;
    private RoomNames movingLocationTarget;
    private int movingTimeTicks;
    private int killTimer;
    private boolean Impostor;
    private boolean doingATask;
    private boolean isDead;

    public Names getName() {
        return name;
    }
    public Player(Names name) {
        this.name = name;
    }
    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
    public Task getActiveTask(){
        return taskList.get(0);
    }
    public void taskFinishedgetNextTask(){
        taskList.remove(0);
    }

    public RoomNames getPlayerLocation() {
        return playerLocation;
    }
    public void setPlayerLocation(RoomNames playerLocation) {
        this.playerLocation = playerLocation;
    }
    public RoomNames getMovingLocationTarget() {
        return movingLocationTarget;
    }
    public void setMovingLocationTarget(RoomNames movingLocationTarget) {
        this.movingLocationTarget = movingLocationTarget;
    }
    public int getMovingTimeTicks() {
        return movingTimeTicks;
    }
    public void setMovingTimeTicks(int movingTimeTicks) {
        this.movingTimeTicks = movingTimeTicks;
    }
    public boolean isImpostor() {
        return Impostor;
    }
    public void setImpostor(boolean impostor) {
        Impostor = impostor;
    }

    public List<Memory> getMemories() {
        return Memories;
    }
    public void setMemories(List<Memory> memories) {
        Memories = memories;
    }

    public boolean isDoingATask() {
        return doingATask;
    }
    public void setDoingATask(boolean doingATask) {
        this.doingATask = doingATask;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public int getKillTimer() {
        return killTimer;
    }

    public void setKillTimer(int killTimer) {
        this.killTimer = killTimer;
    }

    public void addMemory(Memory m1){
        Memories.add(m1);
    }
}
