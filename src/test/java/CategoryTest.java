import com.tsi.veitch.springbootdemo.category.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryTest {

    @Test
    void test_getId(){
        Category testCategory = new Category();

        testCategory.setCategoryId(1234);
        assertEquals(1234, testCategory.getCategoryId(), "Returned category_id not correct, check getter and setter");
    }

    @Test
    void test_getName(){
        Category testCategory = new Category();

        testCategory.setName("TOO HOT FOR TV");
        assertEquals("TOO HOT FOR TV", testCategory.getName(), "Returned name not correct, check getter and setter");
    }
}
