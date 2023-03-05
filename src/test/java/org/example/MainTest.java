package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.example.MaxCategory;


import java.io.IOException;
import java.security.Key;
import java.util.HashMap;

public class MainTest  {
    @Test
    public void CategorySelectTest() throws IOException {
        String title = CategorySelect.getCategories("утюг");
        Assertions.assertEquals("Другое",title);
    }
    @Test
    public void MaxCategoryTest(){
        // MaxCategory maxCategoryTest = new MaxCategory();
        HashMap<String,Long> testMap = new HashMap<>();
        testMap.put("еда",1400L);
        testMap.put("Другое",350L);
        testMap.put("акции",1200L);
        testMap.put("быт",150L);
        String actualCat = MaxCategory.maxCat(testMap).getKey();
        Long actualAmount = MaxCategory.maxCat(testMap).getValue();
        Assertions.assertEquals("еда", actualCat);
        Assertions.assertEquals(1400, actualAmount);
    }
}
