package com.pieceofquality.features;

import com.pieceofquality.categories.Smoke;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static com.codeborne.selenide.Selenide.open;
import static com.pieceofquality.pages.ToDoMVCPage.*;

/**
 * Created by piece on 19.06.2016.
 */
public class TodosE2ETest extends BaseTest {

    @Test
    @Category(Smoke.class)
    public void testTasksFlow() {
        open("https://todomvc4tasj.herokuapp.com/");

        add("1");

        toggle("1");
        assertTasks("1");

        filterActive();
        assertNoVisibleTasks();

        filterCompleted();
        assertVisibleTasks("1");

        //reopen
        toggle("1");
        assertNoVisibleTasks();
        assertItemsLeft(1);

        filterAll();
        assertTasks("1");

        toggleAll();

        clearCompleted();
        assertNoTasks();
    }
}
