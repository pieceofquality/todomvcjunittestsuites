package com.pieceofquality.features;

import com.pieceofquality.categories.Buggy;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static com.pieceofquality.pages.ToDoMVC.TaskType.ACTIVE;
import static com.pieceofquality.pages.ToDoMVC.TaskType.COMPLETED;
import static com.pieceofquality.pages.ToDoMVC.*;

public class TodosOperationsAtAllFilterTest extends BaseTest{

    @Test
    public void testAddAtAll(){
        given();
        add("1");
        assertTasks("1");
        assertItemsLeft(1);
    }

    @Test
    public void testDeleteAtAll(){
        givenAtAll(aTask("1", ACTIVE), aTask("2", COMPLETED));

        delete("1");
        assertTasks("2");
        assertItemsLeft(0);
    }

    @Test
    @Category(Buggy.class)
    public void testEditAtAll(){
        givenAtAll(aTask("1", ACTIVE), aTask("2", COMPLETED));

        startEdit("2", "2 edited").pressEnter();
        assertVisibleTasks("1", "2 edited");
        assertItemsLeft(1);
    }

    @Test
    public void testCompleteAtAll(){
        givenAtAll(ACTIVE, "1");

        toggle("1");
        assertTasks("1");
        assertItemsLeft(0);
    }

    @Test
    public void testCompleteAllAtAll(){
        givenAtAll(ACTIVE, "1", "2");

        toggleAll();
        assertTasks("1", "2");
        assertItemsLeft(0);
    }

    @Test
    public void testClearCompletedAtAll(){
        givenAtAll(aTask("1", ACTIVE), aTask("2", COMPLETED));

        clearCompleted();
        assertTasks("1");
        assertItemsLeft(1);
    }

    @Test
    public void testReopenAtAll(){
        givenAtAll(aTask("1", ACTIVE), aTask("2", COMPLETED));

        toggle("2");
        assertTasks("1", "2");
        assertItemsLeft(2);
    }

    @Test
    public void testDeleteByEmptyAtAll() {
        givenAtAll(ACTIVE, "1");

        startEdit("1", "").pressEnter();
        assertNoTasks();
    }
}
