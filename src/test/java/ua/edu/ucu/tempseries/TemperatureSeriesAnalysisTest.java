package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Ignore;

import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);        
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDevitaionWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        seriesAnalysis.devitation();
    }

    @Test
    public void testDevitationWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -0.0;

        double actualResult = seriesAnalysis.devitation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testDevitationWithSameElementArray() {
        double[] temperatureSeries = {-1.0, -1.0, -1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -0.0;

        double actualResult = seriesAnalysis.devitation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testDevitation() {
        double[] temperatureSeries = {-1.0, 0, 1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.666666666;

        double actualResult = seriesAnalysis.devitation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMaxWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();

        seriesAnalysis.max();

    }

    @Test
    public void testMax() {
        double[] temperatureSeries = {-1.0, 1.0, 2.0, -4.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5.0;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMinWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();

        seriesAnalysis.min();
    }

    @Test
    public void testMin() {
        double[] temperatureSeries = {-1.0, 1.0, 2.0, -4.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -4.0;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsLessThanWithOneBigger() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-1.0};

        double[] actualResult = seriesAnalysis.findTempsLessThan(0.0);

        assertArrayEquals(expResult, actualResult, 0.0);
    }

    @Test
    public void testFindTempsLessThanWithOneLess() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {};

        double[] actualResult = seriesAnalysis.findTempsLessThan(-2.0);

        assertArrayEquals(expResult, actualResult, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsLessThanWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();

        seriesAnalysis.findTempsLessThan(-1.0);
    }

    @Test
    public void testFindTempsLessThan() {
        double[] temperatureSeries = {-1.0, 1.0, 2.0, -4.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-4.0};

        double[] actualResult = seriesAnalysis.findTempsLessThan(-1.0);

        assertArrayEquals(expResult, actualResult, 0.0);
    }

    @Test
    public void testFindTempsBiggerThanWithOneBigger() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {};

        double[] actualResult = seriesAnalysis.findTempsGreaterThan(0.0);

        assertArrayEquals(expResult, actualResult, 0.0);
    }

    @Test
    public void testFindTempsBiggerThanWithOneLess() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-1.0};

        double[] actualResult = seriesAnalysis.findTempsGreaterThan(-2.0);

        assertArrayEquals(expResult, actualResult, 0.0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsBiggerThanWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();

        seriesAnalysis.findTempsGreaterThan(-1.0);

    }

    @Test
    public void testFindTempsBiggerThan() {
        double[] temperatureSeries = {-1.0, 1.0, 2.0, -4.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {1.0, 2.0, 5.0};

        double[] actualResult = seriesAnalysis.findTempsGreaterThan(-1.0);

        assertArrayEquals(expResult, actualResult, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClosestToZeroEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();

        seriesAnalysis.findTempClosestToZero();

    }

    @Test
    public void testClosestToZeroWithZeroElement() {
        double[] temperatureSeries = {0.0, 1.0, -1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double expResult = 0.0;
        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testClosestToZeroOneElement() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }


    @Test
    public void testClosestToValueWithZeroElement() {
        double[] temperatureSeries = {0.0, 1.0, -1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double expResult = 1.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(2.0);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testClosestToValueOneElement() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        double actualResult = seriesAnalysis.findTempClosestToValue(5.0);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testAddTemps() {
        double[] temperatureSeries = {-1.0};
        double[] temperatureSeries2 = {1.0, 2.0};
        double[] temperatureSeries3 = {3.0, 4.0, -5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.addTemps(temperatureSeries2);
        seriesAnalysis.addTemps(temperatureSeries3);

        assertEquals(seriesAnalysis.min(), -5.0, 0.00001);
        assertEquals(seriesAnalysis.max(), 4.0, 0.00001);
    }

    @Test(expected = InputMismatchException.class)
    public void testAddTempsWithLowerTheLowest() {
        double[] temperatureSeries = {-1.0};
        double[] temperatureSeries2 = {1.0, -280.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.addTemps(temperatureSeries2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTemperatureSeriesAnalysisEmpty() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        seriesAnalysis.max();
    }

    @Test(expected = InputMismatchException.class)
    public void testTemperatureSeriesAnalysisLowerTheLowest() {
        double[] temperatureSeries = {1.0, -280.0};
        new TemperatureSeriesAnalysis(temperatureSeries);
    }

    @Test
    public void testSummaryStatistics() {
        double[] temperatureSeries = {-1.0, 1.0, 2.0, -4.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        TempSummaryStatistics statistics = seriesAnalysis.summaryStatistics();
        assertEquals(statistics.minTemp, -4.0, 0.00001);
        assertEquals(statistics.maxTemp, 5.0, 0.00001);
        assertEquals(statistics.avgTemp, 0.6, 0.00001);
        assertEquals(statistics.devTemp, 9.04, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSummaryStatisticsEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();

        seriesAnalysis.summaryStatistics();
    }

}
