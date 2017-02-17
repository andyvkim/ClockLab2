import Kim.Andy.ClockConverterToWords;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClockTest {

    ClockConverterToWords clockConverterToWords;
    String[] timeArray = {"1", "30"};

    @Before
    public void setUp(){
        clockConverterToWords = new ClockConverterToWords();
    }

    @Test
    public void militaryTimeTest(){
        boolean expected = false;
        boolean actual = clockConverterToWords.isMilitaryTime("12:30Pm");
        Assert.assertEquals("I expect this to tell if parameter is military time", expected, actual);
    }

    @Test
    public void getMeridianWhenExpectingAmTest(){
        String expected = "am";
        String actual = clockConverterToWords.getMeridien("5:45am");
        Assert.assertEquals("I am expecting am",expected,actual);
    }

    @Test
    public void getMeridianWhenExpectingPmTest(){
        String expected = "pm";
        String actual = clockConverterToWords.getMeridien("5:45pm");
        Assert.assertEquals("I am expecting pm",expected,actual);
    }
    @Test
    public void removePMMeridiensTest(){
        String expected = "12:30";
        String actual = clockConverterToWords.removeMeridiens("12:30pm");
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void removeAMMeridiensTest(){
        String expected = "12:30";
        String actual = clockConverterToWords.removeMeridiens("12:30am");
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void splitByColonTest(){
        String[] expected = {"12","34"};
        String [] actual = clockConverterToWords.splitByColon("12:34");
        Assert.assertArrayEquals(expected, actual);
    }
    @Test
    public void convertTimeToStringTest(){
        String expected = "one thirty";
        String actual = clockConverterToWords.convertTimeToString(timeArray);
        Assert.assertEquals(expected, actual);
    }

}
