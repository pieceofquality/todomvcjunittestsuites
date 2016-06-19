package com.pieceofquality;

import com.pieceofquality.categories.Smoke;
import com.pieceofquality.features.TodosE2ETest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Suite.SuiteClasses(TodosE2ETest.class)
@Categories.IncludeCategory(Smoke.class)

public class SmokeSuiteTest {
}
