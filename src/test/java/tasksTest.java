import amongthem.game.CreateTasks;
import amongthem.tasks.Task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.stream.Collectors;

public class tasksTest {


    @Test
    public void testCreateTasks5(){

        List<Task> testTaskList =
        CreateTasks.createTask(5);
        assertEquals(testTaskList.size(),5);

        for(int i = 0; i < testTaskList.size();i++){
            Task t = testTaskList.get(i);
            List<Task> testTaskListFiltered = testTaskList.stream().filter(task -> t != task).collect(Collectors.toList());
            for(Task t2 : testTaskListFiltered){
                assertNotEquals(t, t2);
            }

        }
    }

    @Test
    public void testCreateTasks9(){

        List<Task> testTaskList =
                CreateTasks.createTask(9);
        assertEquals(testTaskList.size(),9);

        for(int i = 0; i < testTaskList.size();i++){
            Task t = testTaskList.get(i);
            List<Task> testTaskListFiltered = testTaskList.stream().filter(task -> t != task).collect(Collectors.toList());
            for(Task t2 : testTaskListFiltered){
                assertNotEquals(t, t2);
            }

        }
    }

    @Test
    public void testCreateTasks15(){

        List<Task> testTaskList =
                CreateTasks.createTask(15);
        assertEquals(testTaskList.size(),15);

        for(int i = 0; i < testTaskList.size();i++){
            Task t = testTaskList.get(i);
            List<Task> testTaskListFiltered = testTaskList.stream().filter(task -> t != task).collect(Collectors.toList());
            for(Task t2 : testTaskListFiltered){
                assertNotEquals(t, t2);
            }

        }
    }

    @Test
    public void testCreateTasksMinus3(){

        List<Task> testTaskList =
                CreateTasks.createTask(-3);
        assertEquals(testTaskList.size(),1);

        for(int i = 0; i < testTaskList.size();i++){
            Task t = testTaskList.get(i);
            List<Task> testTaskListFiltered = testTaskList.stream().filter(task -> t != task).collect(Collectors.toList());
            for(Task t2 : testTaskListFiltered){
                assertNotEquals(t, t2);
            }

        }
    }

    @Test
    public void testCreateTasksMaxTasksPlus1(){

        List<Task> testTaskList =
                CreateTasks.createTask(CreateTasks.maxTasks+1);
        assertEquals(testTaskList.size(),CreateTasks.maxTasks);

        for(int i = 0; i < testTaskList.size();i++){
            Task t = testTaskList.get(i);
            List<Task> testTaskListFiltered = testTaskList.stream().filter(task -> t != task).collect(Collectors.toList());
            for(Task t2 : testTaskListFiltered){
                assertNotEquals(t, t2);
            }

        }
    }


}