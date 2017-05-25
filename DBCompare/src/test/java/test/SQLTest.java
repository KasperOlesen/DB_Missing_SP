
package test;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import src.SQLControl;

/**
 *
 * @author kAlex
 */
public class SQLTest {
  private SQLControl sql;
    private float[] times = new float[20];
    private Random rand = new Random();

    @Before
    public void setup() {
        sql = new SQLControl();
    }
    
    public float calcMedian(float[]arr){
        float median = 0;
        Arrays.sort(arr);
        int middle = arr.length/2;
        if (arr.length%2 == 1) {
            median = arr[middle];
        } else {
            median = (arr[middle-1] + arr[middle]) / 2;
        }
            return median;
    }

    @Test
    public void getEndorsesDepthOneTest() {
        float avg = 0;
        for (int i = 0; i < 20; i++) {
            int id = rand.nextInt(500000);
            long startTime = System.currentTimeMillis();
            ResultSet result = sql.getEndorsesDepthOne(id);
            long endTime = System.currentTimeMillis();
            float timeEst = (endTime - startTime) / 1000.0f;
            times[i] = timeEst;
        }
        System.out.println("Depth One: ");
        for (Float timeEst : times) {
            System.out.println(timeEst);
            avg += timeEst;
        }
        System.out.println("Depth One avg: " + (avg / 20));
        System.out.println("Depth One median: " + calcMedian(times));
    }

    @Test
    public void getEndorsesDepthTwoTest() {
        float avg = 0;
        for (int i = 0; i < 20; i++) {
            int id = rand.nextInt(500000);
            long startTime = System.currentTimeMillis();
            ResultSet result = sql.getEndorsesDepthTwo(id);
            long endTime = System.currentTimeMillis();
            float timeEst = (endTime - startTime) / 1000.0f;
            times[i] = timeEst;
        }
        System.out.println("Depth Two: ");
        for (Float timeEst : times) {
            System.out.println(timeEst);
            avg += timeEst;
        }
        System.out.println("Depth Two avg: " + (avg / 20));
        System.out.println("Depth Two median: " + calcMedian(times));
    }

    @Test
    public void getEndorsesDepthThreeTest() {
        float avg = 0;
        for (int i = 0; i < 10; i++) {
            int id = rand.nextInt(500000);
            long startTime = System.currentTimeMillis();
            sql.getEndorsesDepthThree(id);
            long endTime = System.currentTimeMillis();
            float timeEst = (endTime - startTime) / 1000.0f;
            times[i] = timeEst;
        }
        System.out.println("Depth Three: ");
        for (Float timeEst : times) {
            System.out.println(timeEst);
            avg += timeEst;
        }
        System.out.println("Depth Three avg: " + (avg / 20));
        System.out.println("Depth Three median: " + calcMedian(times));
    }

    @Test
    public void getEndorsesDepthFourTest() {
        float avg = 0;
        for (int i = 0; i < 10; i++) {
            int id = rand.nextInt(500000);
            long startTime = System.currentTimeMillis();
            sql.getEndorsesDepthFour(id);
            long endTime = System.currentTimeMillis();
            float timeEst = (endTime - startTime) / 1000.0f;
            times[i] = timeEst;
        }
        System.out.println("Depth Four: ");
        for (Float timeEst : times) {
            avg += timeEst;
            System.out.println(timeEst);
        }
        System.out.println("Depth Four avg: " + (avg / 20));
        System.out.println("Depth Four median: " + calcMedian(times));
    }

    @Test
    public void getEndorsesDepthFiveTest() {
        float avg = 0;
        for (int i = 0; i < 10; i++) {
            int id = rand.nextInt(500000);
            long startTime = System.currentTimeMillis();
            sql.getEndorsesDepthFive(id);
            long endTime = System.currentTimeMillis();
            float timeEst = (endTime - startTime) / 1000.0f;
            times[i] = timeEst;
        }
        System.out.println("Depth Five: ");
        for (Float timeEst : times) {
            avg += timeEst;
            System.out.println(timeEst);
        }
        System.out.println("Depth Five avg: " + (avg / 20));
        System.out.println("Depth Five median: " + calcMedian(times));
    }
}
