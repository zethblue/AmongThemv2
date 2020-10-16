package start;

import amongthem.game.Game;
import amongthem.player.Memory;
import amongthem.player.Player;

public class Start {

    public static void main(String[] args) {

        int tickerAnzahl = 0;
        Game g = new Game();
        g.startGamegetPlayerList();
        g.startGameCreateNewTaskListforAllPlayers(15);
        g.startGameSetImposters();
        g.setKillTimers();
        g.startRoundMovePlayersToCafeteria();
        g.startRoundSetPlayerMoveTimesAndRoute();
        g.startRoundInitializeMemories();

        while(!g.isFoundDeadBodyREPORT()){
            g.ticker();
            System.out.println("TICK COUNTER: " + tickerAnzahl++);
            for(Player p : g.getGamePlayersAlive()){
                System.out.println(p.getName());
                System.out.println("MemorySize: " + p.getMemories().size());
                System.out.println("Location: " + p.getPlayerLocation());
                System.out.println("MovingTicker: " + p.getMovingTimeTicks());
                System.out.println("MovingTargetLocation: " + p.getMovingLocationTarget());
                System.out.println("KillTimer: " + p.getKillTimer());
                System.out.println("TaskLocation: " + p.getActiveTask().getTaskIsInRoom());
            }
        }
        System.out.println("DEAD BODY FOUND:" +  g.getDeadBodyfound().getName());
        System.out.println("PLAYER WHO REPORTET: " + g.getReportingPlayer().getName());

        System.out.println("MEMORIES!!!\n\n\n");

        for(Player p: g.getGamePlayersAlive()){
            System.out.println(p.getName());
            System.out.println("Memory List Size: " + p.getMemories().size());
            for(Memory m : p.getMemories()){
                System.out.println(m);
            }
        }

        for(Player p: g.getGamePlayersDead()){
            System.out.println(p.getName() + " died");
        }

        for(Player p: g.getGamePlayersAlive()){
            if(p.isImpostor()){
                System.out.println("Impostor: " + p.getName());
            }
        }

    }
}
