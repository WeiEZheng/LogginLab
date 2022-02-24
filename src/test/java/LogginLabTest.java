import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class LogginLabTest {
    private final static Logger logger = Logger.getLogger(LogginLab.class.getName());

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void thresholdExceeds() {
        Integer finalLimit = 5;

        LogginLab lab = new LogginLab();
        lab.setThreshold(finalLimit);

        for (Integer i = 1; i <= finalLimit; i++) {
            if (lab.thresholdExceeds(i)) {
                logger.log(Level.INFO, "Threshold not reached! It is "+i);
                assertTrue(lab.thresholdExceeds(i));
            } else {
                logger.log(Level.INFO, "Threshold finally reached!");
                assertFalse(lab.thresholdExceeds(i));
            }
        }
    }
    @org.junit.Test
    public void thresholdReachedTest() {
        Integer Limit = 10;
        LogginLab lab1 = new LogginLab();
        lab1.setThreshold(Limit);
        if (lab1.thresholdReached(Limit+1)) {
            logger.log(Level.INFO,"Threshold exceeded");
        }
        else{
            logger.log(Level.INFO,"Threshold not exceeded");
        }
        assertTrue(lab1.thresholdReached(Limit+1));
        //Tests with Limit+1 to assure that limit was exceeded.
    }
    @org.junit.Test
    public void thresholdReachedTest2() {
        Integer Limit = 10;
        LogginLab lab1 = new LogginLab();
        lab1.setThreshold(Limit);
        if (lab1.thresholdReached(Limit)) {
            logger.log(Level.INFO,"Threshold exceeded");
        }
        else{
            logger.log(Level.INFO,"Threshold not exceeded");
        }
        assertFalse(lab1.thresholdReached(Limit));
        //Tests with Limit to assure that limit was not exceeded.
    }
}