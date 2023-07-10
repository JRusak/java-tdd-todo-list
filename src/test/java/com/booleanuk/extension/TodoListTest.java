package com.booleanuk.extension;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoListTest {
    private static TodoList TODOLIST;

    private static String TASK1;
    private static String TASK2;
    private static String TASK3;

    @BeforeAll
    static void setup() {
        TODOLIST = new TodoList();
        TASK1 = "Wash the dishes";
        TASK2 = "Walk the dog";
        TASK3 = "Drink a glass of water";
    }
    @Nested
    class addTask {
        @Test
        public void shouldAddTask() {
            TODOLIST.addTask(TASK1);
            assertEquals(1, TODOLIST.tasks.keySet().size());

            TODOLIST.addTask(TASK2);
            assertEquals(2, TODOLIST.tasks.keySet().size());
        }
    }

}
