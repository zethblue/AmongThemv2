package amongthem.player;

import amongthem.rooms.RoomNames;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Memory {

    private RoomNames roomname;
    private List<Player> playersSeen;
    private List<Player> playersDidTask;
    private MemoryEnums moveOrDidTask;

    public Memory() {
        playersDidTask = new ArrayList<>();
        playersSeen = new ArrayList<>();
    }

    public RoomNames getRoomname() {
        return roomname;
    }
    public void setRoomname(RoomNames roomname) {
        this.roomname = roomname;
    }
    public List<Player> getPlayersSeen() {
        return playersSeen;
    }
    public void setPlayersSeen(List<Player> playersSeen) {
        this.playersSeen = playersSeen;
    }
    public List<Player> getPlayersDidTask() {
        return playersDidTask;
    }
    public void setPlayersDidTaskAddOnePlayer(Player pDidTask) {
        playersDidTask.add(pDidTask);
    }
    public void forMemoryReadOutsetPlayerDidTask(List<Player> p){
        playersDidTask = p;
    }
    public MemoryEnums getMoveOrDidTask() {
        return moveOrDidTask;
    }
    public void setMoveOrDidTask(MemoryEnums moveOrDidTask) {
        this.moveOrDidTask = moveOrDidTask;
    }

    //this method may not work correctly - List-equaling doesnt work ??
    public static boolean compareMyMemories(Memory m1, Memory m2){
        boolean sameRoom = false;
        boolean samePlayersseen = false;
        boolean sameplayersDidTask = false;
        if(m1.getRoomname().equals(m2.getRoomname())) sameRoom = true;


        if(m1.getPlayersSeen().equals(m2.getPlayersSeen())) samePlayersseen = true;
        if(m1.getPlayersDidTask().equals(m2.getPlayersDidTask())) sameplayersDidTask = true;

        return sameRoom & samePlayersseen & sameplayersDidTask;

    }


    @Override
    public String toString() {
        StringBuilder playerIhaveSeen = new StringBuilder();
        StringBuilder playerswhoDidTasks = new StringBuilder();
        for(Player x : playersSeen){
            playerIhaveSeen.append(x.getName());
        }
        for(Player x : playersDidTask){
            playerswhoDidTasks.append(x.getName());
        }
        return "I was in" + roomname +
                "\n and have seen " + playerIhaveSeen.toString() +
                "\nthis players I did see doing  tasks: " + playerswhoDidTasks.toString() +
                "\nand I did " + moveOrDidTask;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Memory memory = (Memory) o;
        return roomname == memory.roomname &&
                playersSeen.equals(memory.playersSeen) &&
                playersDidTask.equals(memory.playersDidTask) &&
                moveOrDidTask == memory.moveOrDidTask;
    }

    public boolean arePlayersSeenTheSame(Memory m){
        return m.getPlayersSeen().equals(playersSeen);
    }
    public boolean arePlayersDidTasksTheSame(Memory m) {
        return m.getPlayersDidTask().equals(playersDidTask);
    }
    public boolean isMoveOrDidTaskTheSame(Memory m) {
        return m.getMoveOrDidTask().equals(moveOrDidTask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomname, playersSeen, playersDidTask, moveOrDidTask);
    }
}
