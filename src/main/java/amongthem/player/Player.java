package amongthem.player;

import amongthem.tasks.Task;

import java.util.List;

public class Player {

    private Names name;
    private List<Task> taskList;

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

}
