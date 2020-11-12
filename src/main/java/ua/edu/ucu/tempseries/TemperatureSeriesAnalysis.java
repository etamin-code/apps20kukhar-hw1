package ua.edu.ucu.tempseries;


import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    static final double LowestTemp = -273.0;
    private double[] temperatureList;
    private int numOfElements;
    private Object IllegalArgumentException;

    public TemperatureSeriesAnalysis() {
        int DefaultSize = 4;
        temperatureList = new double[DefaultSize];
        numOfElements = 0;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        for (double el: temperatureSeries) {
            if (el < LowestTemp) {
                throw new InputMismatchException();
            }
        }
        temperatureList = temperatureSeries;
        numOfElements = temperatureSeries.length;
    }

    public double average() {

        double sum = 0;
        for (double el: temperatureList) {
            sum += el;
        }
        return sum / numOfElements;
    }

    public double devitation() {
        if (numOfElements == 0) {
            return 0.0;
        }
        double avr = average();
        double sumSquaredDevitaion = 0.0;
        for (double el: temperatureList) {
            sumSquaredDevitaion += (avr - el) * (avr - el);
        }
        return sumSquaredDevitaion / numOfElements;

    }

    public double min() {
        if (numOfElements == 0) {
            return 0;
        }
        double minValue = temperatureList[0];
        for (double el: temperatureList) {
            if (el < minValue) {
                minValue = el;
            }
        }
        return minValue;
    }

    public double max() {
        if (numOfElements == 0) {
            return 0;
        }
        double maxValue = temperatureList[0];
        for (double el: temperatureList) {
            if (el > maxValue) {
                maxValue = el;
            }
        }
        return maxValue;
    }


    public double findTempClosestToZero() {
        return findTempClosestToValue(0.0);
    }

    public double findTempClosestToValue(double tempValue) {
        double valueDif = Math.abs(temperatureList[0] - tempValue);
        for (double el: temperatureList) {
            if (Math.abs(el - tempValue) < valueDif) {
                valueDif = Math.abs(el - tempValue);
            }
        }
        return valueDif;
    }

    public double[] findTempsLessThan(double tempValue) {
        double[] tempLessList = new double[numOfElements];
        int size = 0;
        for (double el: temperatureList){
            if (el < tempValue) {
                tempLessList[size] = el;
                size += 1;
            }
        }
        return Arrays.copyOfRange(tempLessList, 0, size);
    }

    public double[] findTempsGreaterThan(double tempValue) {
        double[] tempGreaterList = new double[numOfElements];
        int size = 0;
        for (double el: temperatureList) {
            if (el > tempValue) {
                tempGreaterList[size] = el;
                size += 1;
            }
        }
        return Arrays.copyOfRange(tempGreaterList, 0, size);
    }

    TempSummaryStatistics summaryStatistics() {
        if (this.numOfElements == 0) {
            return (TempSummaryStatistics) IllegalArgumentException;
        }
        TempSummaryStatistics statistic = new TempSummaryStatistics(average(),
                                               devitation(), min(), max());

        return statistic;

    }
    
    public int addTemps(double[] temps) {
        for (double el: temps) {
            if (el < LowestTemp) {
                throw new InputMismatchException();
            }
        }
        while (temperatureList.length - numOfElements < temps.length) {
            double[] newTemperatureList = new double[2 * numOfElements];
            System.arraycopy(temperatureList, 0, newTemperatureList,
                      0, numOfElements);
            temperatureList = newTemperatureList;
        }
        System.arraycopy(temps, 0, temperatureList, numOfElements,
                   numOfElements + temps.length);

        numOfElements += temps.length;
        return numOfElements;
    }
}
