package amongthem.game;

import amongthem.player.Memory;
import amongthem.player.MemoryEnums;
import amongthem.player.Player;
import amongthem.rooms.RoomNames;
import amongthem.tasks.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Game {

    private List<Player> gamePlayersAlive;
    private List<Player> gamePlayersDead;
    private HashMap<RoomNames,Player> deadBodies;
    boolean foundDeadBodyREPORT = false;
    private Player reportingPlayer;
    private Player deadBodyfound;

    public Game() {
        gamePlayersDead = new ArrayList<>();
        deadBodies = new HashMap<>();
    }

    public void startGamegetPlayerList(){
        gamePlayersAlive = CreatePlayers.createPlayers();
    }
    public void startGameSetImposters(){
        Random randomizer = new Random();
        while (true) {
            int randomPlayer1 = randomizer.nextInt(gamePlayersAlive.size() - 1);
            int randomPlayer2 = randomizer.nextInt(gamePlayersAlive.size() - 1);
            if (randomPlayer1 != randomPlayer2) {
                gamePlayersAlive.get(randomPlayer1).setImpostor(true);
                gamePlayersAlive.get(randomPlayer2).setImpostor(true);
                break;
            }
        }



    }
    public void setKillTimers(){
        for(Player p : gamePlayersAlive){
            Random randomizer = new Random();
            p.setKillTimer(40 + randomizer.nextInt(40));
        }
    }
    public void startGameCreateNewTaskListforAllPlayers(int i){
        for(Player p : gamePlayersAlive){
            p.setTaskList(CreateTasks.createTask(i));
        }
    }
    public void startRoundMovePlayersToCafeteria(){
        for(Player p: gamePlayersAlive)
            p.setPlayerLocation(RoomNames.CAFETERIA);
    }
    public void startRoundSetPlayerMoveTimesAndRoute(){
        for(Player p : gamePlayersAlive){
            RoomNames setRoute = Locator.whereShallIGo(p.getPlayerLocation(),p.getActiveTask().getTaskIsInRoom());
            p.setMovingLocationTarget(setRoute);
            p.setMovingTimeTicks(RouteTickPlanner.TicksForMoving(p.getPlayerLocation()));
        }
    }
    public void setFoundDeadBodyREPORTnReportingPlayerndeadBodyfoundtoNULL(){
        foundDeadBodyREPORT = false;
        reportingPlayer = null;
        deadBodyfound = null;
    }
    public void startRoundInitializeMemories(){
        for(Player p : gamePlayersAlive){
            p.setMemories(new ArrayList<>());
        }
    }
    public List<Player> isAnotherPlayerInMyRoom(Player p){
        RoomNames myRoom = p.getPlayerLocation();
        return gamePlayersAlive.stream().filter(player -> player.getPlayerLocation().equals(myRoom)).collect(Collectors.toList());
    }

    public void ticker(){
        for(Player p : gamePlayersAlive){
            Player dead = null;
            Random randomizer = new Random();
            RoomNames actualRoom = p.getPlayerLocation();
            RoomNames roomWhereIHaveMyTask = Locator.whereShallIGo(p.getPlayerLocation(),p.getActiveTask().getTaskIsInRoom());
            boolean doingATask = p.isDoingATask();
            boolean reporting = false;
            boolean Impostor = p.isImpostor();
            int playerTicker = p.getMovingTimeTicks();
            int killTimer = p.getKillTimer();
            boolean myTaskIsInThisRoom = (roomWhereIHaveMyTask == actualRoom);
            List<Player> playerInMyRoomList = isAnotherPlayerInMyRoom(p);
            Memory tickMemory = new Memory();

            //ticking
            p.setMovingTimeTicks(p.getMovingTimeTicks()-1);


            //create Memory in actual Room
            tickMemory.setRoomname(actualRoom);
            tickMemory.setPlayersSeen(playerInMyRoomList);
            if(myTaskIsInThisRoom){tickMemory.setMoveOrDidTask(MemoryEnums.DIDTASK); }
            else tickMemory.setMoveOrDidTask(MemoryEnums.MOVING);

            //did another player here do a task?
            for(Player others : playerInMyRoomList){
                if(others != p){
                    if(others.isDoingATask()){
                        tickMemory.setPlayersDidTask(others);
                    }
                }
            }


            //Player sees dead Body
            if(!deadBodies.isEmpty()){
                if(deadBodies.get(actualRoom) != null){
                    dead = deadBodies.get(actualRoom);
                    if(Impostor){
                        if(killTimer < 5){
                            if(randomizer.nextBoolean()){
                                reporting = true;
                            }
                        }
                    }
                    else reporting = true;
                }


            }

            //Player has Task elsewhere and moves
            if(actualRoom != roomWhereIHaveMyTask){
                if(playerTicker > 0){
                    p.setMovingTimeTicks(p.getMovingTimeTicks()-1);
                }
                else{
                    RoomNames futureRoom = Locator.whereShallIGo(actualRoom,roomWhereIHaveMyTask);
                    p.setPlayerLocation(futureRoom);
                    p.setMovingTimeTicks(RouteTickPlanner.TicksForMoving(futureRoom));

                }
            }

            //Player has Task in this Room
            if(actualRoom == roomWhereIHaveMyTask){
                if(doingATask){
                    if(playerTicker > 0){
                        p.setMovingTimeTicks(p.getMovingTimeTicks()-1);
                    }else{
                        p.setDoingATask(false);
                        p.taskFinishedgetNextTask();
                        p.setMovingLocationTarget(Locator.whereShallIGo(actualRoom,p.getActiveTask().getTaskIsInRoom()));
                        if(p.getActiveTask().getTaskIsInRoom() != actualRoom){
                            p.setMovingTimeTicks(RouteTickPlanner.TicksForMoving(actualRoom));
                        }

                    }
                }
                else{
                        p.setMovingTimeTicks(p.getActiveTask().getTicksUsed());
                        p.setDoingATask(true);
                    }

            }

            //Player is Imposter
            if(Impostor){
                p.setKillTimer(p.getKillTimer()-1);

                // and alone with someone + timer is gone
                if(playerInMyRoomList.size() == 2 & killTimer <= 0){
                    if(!playerInMyRoomList.get(1).isImpostor() ){
                        playerInMyRoomList.get(1).setDead(true);
                        deadBodies.put(actualRoom,playerInMyRoomList.get(1));
                        p.setKillTimer(40);
                    }
                }
            }

            //Save reporting Player
            if(reporting){
                reportingPlayer = p;
                deadBodyfound = dead;
                foundDeadBodyREPORT = true;

            }

            //is memory the same as before? then no save. if not then save
            Memory checkMe = p.getMemories().get(p.getMemories().size()-1);
            boolean sameMemoryAgain = Memory.compareMyMemories(checkMe,tickMemory);
            if(!sameMemoryAgain){
                p.addMemory(checkMe);
            }

        }
        //check Dead Players in Alive List
        for(Player p : gamePlayersAlive){
            if(p.isDead()){
                gamePlayersDead.add(p);
                gamePlayersAlive.remove(p);
            }
        }
    }
    public boolean checkifGameIsLost(){
        int size = 0;
        int imposterCount = 0;
        for(Player p : gamePlayersAlive){
            size++;
            if(p.isImpostor()) imposterCount++;
        }
        return size*2 > imposterCount;
    }
    public boolean checkIfGameIsWon(){
        int imposterCount = 0;
        for(Player p : gamePlayersAlive){
            if(p.isImpostor()){
                imposterCount++;
            }
        }
        return imposterCount == 0;

    }
    public void voteOutPlayer(Player p){
        gamePlayersDead.add(p);
        gamePlayersAlive.remove(p);
    }




    public List<Player> getGamePlayersAlive() {
        return gamePlayersAlive;
    }
    public List<Player> getGamePlayersDead() {
        return gamePlayersDead;
    }







}
