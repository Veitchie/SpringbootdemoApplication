import com.tsi.veitch.springbootdemo.category.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryTest {

    @Test
    public void test_getId(){
        Category testCategory = new Category();

        testCategory.setCategory_id(1234);
        assertEquals(1234, testCategory.getCategory_id(), "Returned category_id not correct, check getter and setter");
    }

    @Test
    public void test_getName(){
        Category testCategory = new Category();

        testCategory.setName("TOO HOT FOR TV");
        assertEquals("TOO HOT FOR TV", testCategory.getName(), "Returned name not correct, check getter and setter");
    }
}
