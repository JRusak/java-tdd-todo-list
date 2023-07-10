package com.booleanuk.core;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TodoListTest {
    private static String TASK1;
    private static String  TASK2;
    private static String  TASK3;
    private static TodoList TODOLIST;

    @BeforeAll
    static void testSetup() {
        TODOLIST = new TodoList();
        TASK1 = "Wash the dishes";
        TASK2 = "Walk the dog";
        TASK3 = "Drink a glass of water";
    }

    @AfterEach
    void clearTODOList() {
        TODOLIST.tasks.clear();
    }

    @Nested
    class AddTask {
        @Test
        void shouldReturnTrueIfTaskIsNotInTodoList() {
            assertTrue(TODOLIST.addTask(TASK1));
            assertTrue(TODOLIST.addTask(TASK2));
            assertTrue(TODOLIST.addTask(TASK3));
        }
        @Test
        void shouldReturnFalseIfTaskIsInTodoList() {
            assertTrue(TODOLIST.addTask(TASK1));
            assertFalse(TODOLIST.addTask(TASK1));
        }
    }

    @Nested
    class DisplayTasks {
        @Test
        void shouldReturnThreeElements() {
            TODOLIST.addTask(TASK1);
            TODOLIST.addTask(TASK2);
            TODOLIST.addTask(TASK3);
            String result = "Tasks to do: \n" +
                    "Completed: false | Wash the dishes\n" +
                    "Completed: false | Walk the dog\n" +
                    "Completed: false | Drink a glass of water\n";
            assertEquals(result, TODOLIST.displayTasks());
        }
    }

    @Nested
    class ChangeTaskStatus {
        @Test
        void shouldReturnFalse() {
            assertFalse(TODOLIST.changeTaskStatus(TASK2));
        }
        @Test
        void shouldReturnTrue() {
            TODOLIST.addTask(TASK1);
            assertTrue(TODOLIST.changeTaskStatus(TASK1));
            assertTrue(TODOLIST.tasks.get(0).isCompleted);

            assertTrue(TODOLIST.changeTaskStatus(TASK1));
            assertFalse(TODOLIST.tasks.get(0).isCompleted);
        }
    }

    @Nested
    class DisplayCompletedTasks {
        @Test
        void shouldReturnInCompleted() {
            TODOLIST.addTask(TASK1);
            TODOLIST.addTask(TASK2);
            TODOLIST.addTask(TASK3);
            assertTrue(TODOLIST.changeTaskStatus(TASK1));
            assertTrue(TODOLIST.changeTaskStatus(TASK2));

            String result = "Completed tasks: \n" +
                    "Wash the dishes\n" +
                    "Walk the dog\n";
            assertEqual(result, TODOLIST.displayCompletedTasks());
        }
    }

    @Nested
    class DisplayInCompletedTasks {
        @Test
        void shouldReturnInCompletedTasks() {
            TODOLIST.addTask(TASK1);
            TODOLIST.addTask(TASK2);
            TODOLIST.addTask(TASK3);
            assertTrue(TODOLIST.changeTaskStatus(TASK1));

            String result = "InCompleted tasks: \n" +
                    "Wash the dishes\n" +
                    "Walk the dog\n";
            assertEqual(result, TODOLIST.displayInCompletedTasks());
        }
    }

}
