package com.pieceofquality;

import com.pieceofquality.features.TodosE2ETest;
import com.pieceofquality.features.TodosOperationsAtAllFilterTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

    @RunWith(Categories.class)
    @Suite.SuiteClasses({TodosOperationsAtAllFilterTest.class, TodosE2ETest.class})

    public class AllSuiteTest {
    }