package amongthem.game;

import amongthem.rooms.RoomNames;
import amongthem.tasks.Task;

import java.util.ArrayList;
import java.util.Random;

public class CreateTasks {

    private static final ArrayList<Task> allTasks;
    public static final int maxTasks;
    static{
        allTasks = new ArrayList<>();
        allTasks.add(new Task(10, RoomNames.CAFETERIA));
        allTasks.add(new Task(15, RoomNames.CAFETERIA));
        allTasks.add(new Task(5, RoomNames.CAFETERIA));
        allTasks.add(new Task(10, RoomNames.WEAPONS));
        allTasks.add(new Task(15, RoomNames.WEAPONS));
        allTasks.add(new Task(5, RoomNames.WEAPONS));
        allTasks.add(new Task(10, RoomNames.O2));
        allTasks.add(new Task(15, RoomNames.O2));
        allTasks.add(new Task(5, RoomNames.O2));
        allTasks.add(new Task(25, RoomNames.NAVIGATION));
        allTasks.add(new Task(10, RoomNames.NAVIGATION));
        allTasks.add(new Task(10, RoomNames.SHIELDS));
        allTasks.add(new Task(15, RoomNames.SHIELDS));
        allTasks.add(new Task(10, RoomNames.COMMUNICATION));
        allTasks.add(new Task(15, RoomNames.COMMUNICATION));
        allTasks.add(new Task(5, RoomNames.COMMUNICATION));
        allTasks.add(new Task(20, RoomNames.STORAGE));
        allTasks.add(new Task(15, RoomNames.STORAGE));
        allTasks.add(new Task(10, RoomNames.STORAGE));
        allTasks.add(new Task(10, RoomNames.ELECTRICAL));
        allTasks.add(new Task(15, RoomNames.ELECTRICAL));
        allTasks.add(new Task(25, RoomNames.ELECTRICAL));
        allTasks.add(new Task(10, RoomNames.ELECTRICAL));
        allTasks.add(new Task(5, RoomNames.ELECTRICAL));
        allTasks.add(new Task(5, RoomNames.LOWER_ENGINE));
        allTasks.add(new Task(10, RoomNames.LOWER_ENGINE));
        allTasks.add(new Task(15, RoomNames.LOWER_ENGINE));
        allTasks.add(new Task(20, RoomNames.LOWER_ENGINE));
        allTasks.add(new Task(25, RoomNames.REACTOR));
        allTasks.add(new Task(10, RoomNames.REACTOR));
        allTasks.add(new Task(20, RoomNames.REACTOR));
        allTasks.add(new Task(15, RoomNames.REACTOR));
        allTasks.add(new Task(10, RoomNames.SECURITY));
        allTasks.add(new Task(15, RoomNames.SECURITY));
        allTasks.add(new Task(15, RoomNames.UPPER_ENGINE));
        allTasks.add(new Task(10, RoomNames.UPPER_ENGINE));
        allTasks.add(new Task(20, RoomNames.UPPER_ENGINE));
        allTasks.add(new Task(5, RoomNames.UPPER_ENGINE));
        allTasks.add(new Task(25, RoomNames.MEDBAY));
        allTasks.add(new Task(5, RoomNames.MEDBAY));

        maxTasks = allTasks.size()-5;

    }
    public static ArrayList<Task> createTask(int anzahlTasks){

        if(anzahlTasks > maxTasks){ anzahlTasks = maxTasks;}
        if(anzahlTasks < 1){ anzahlTasks = 1;}

        ArrayList<Task> createdTasks = new ArrayList<>();
        Random randomizer = new Random();

        while(createdTasks.size() < anzahlTasks){
            Task createTask = allTasks.get(randomizer.nextInt(allTasks.size()));
            boolean checkIfTaskIsNotInList = createdTasks.stream().noneMatch(task -> task.equals(createTask));
            if(checkIfTaskIsNotInList){
                createdTasks.add(createTask);
            }

        }



        return createdTasks;
    }

}
