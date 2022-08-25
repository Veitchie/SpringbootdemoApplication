import com.tsi.veitch.springbootdemo.language.Language;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LanguageTest {

    @Test
    void test_getLanguageId(){
        Language lang = new Language();

        lang.setLanguageId(666);
        assertEquals(666, lang.getLanguageId());
    }

    @Test
    void test_getName(){
        Language lang = new Language();

        lang.setName("French");
        assertEquals("French", lang.getName());
    }
}
