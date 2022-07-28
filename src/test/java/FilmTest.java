import com.tsi.veitch.springbootdemo.film.Film;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilmTest {

    @Test
    public void test_getTitle(){
        Film testFilm = new Film();

        testFilm.setTitle("FILM_TITLE");
        assertEquals("FILM_TITLE", testFilm.getTitle(), "Returned title was not correct, either set or get not working");
    }

    @Test
    public void test_getDescription(){
        Film testFilm = new Film();

        testFilm.setDescription("FILM_DESCRIPTION");
        assertEquals("FILM_DESCRIPTION", testFilm.getDescription(), "Returned description was not correct, either set or get not working");
    }

    @Test
    public void test_getFilmId(){
        Film testFilm = new Film();

        testFilm.setFilmId(1010);
        assertEquals(1010, testFilm.getFilmId(), "Returned FilmId was not correct, either set or get not working");
    }

    @Test
    public void test_getReleaseYear(){
        Film testFilm = new Film();

        testFilm.setReleaseYear(new Date(1995));
        assertEquals(new Date(1995), testFilm.getReleaseYear(), "Returned Date was not correct, either set or get not working");
    }

    @Test
    public void test_getLanguageId(){
        Film testFilm = new Film();

        testFilm.setLanguageId(800);
        assertEquals(800, testFilm.getLanguageId(), "Returned LanguageID was not correct, either set or get not working");
    }

    @Test
    public void test_getOriginalLanguageId(){
        Film testFilm = new Film();

        testFilm.setOriginalLanguageId(880);
        assertEquals(880, testFilm.getOriginalLanguageId(), "Returned OriginalLanguageID was not correct, either set or get not working");
    }

    @Test
    public void test_getRentalDuration(){
        Film testFilm = new Film();

        testFilm.setRentalDuration(2);
        assertEquals(2, testFilm.getRentalDuration(), "Returned Rental Duration was not correct, either set or get not working");
    }

    @Test
    public void test_getRentalRate(){
        Film testFilm = new Film();

        testFilm.setRentalRate(3.59);
        assertEquals(3.59, testFilm.getRentalRate(), "Returned Rental Rate was not correct, either set or get not working");
    }

    @Test
    public void test_getLength(){
        Film testFilm = new Film();

        testFilm.setLength(3);
        assertEquals(3, testFilm.getLength(), "Returned length was not correct, either set or get not working");
    }

    @Test
    public void test_getReplacementCost(){
        Film testFilm = new Film();

        testFilm.setReplacementCost(400.99);
        assertEquals(400.99, testFilm.getReplacementCost(), "Returned replacement cost was not correct, either set or get not working");
    }

    @Test
    public void test_getRating(){
        Film testFilm = new Film();

        testFilm.setRating("SUPER VIOLENT");
        assertEquals("SUPER VIOLENT", testFilm.getRating(), "Returned rating was not correct, either set or get not working");
    }

    @Test
    public void test_getSpecialFeatures(){
        Film testFilm = new Film();

        testFilm.setSpecialFeatures("SPAWNS MONEY");
        assertEquals("SPAWNS MONEY", testFilm.getSpecialFeatures(), "Returned special features was not correct, either set or get not working");
    }
}
