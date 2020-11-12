package ua.edu.ucu.tempseries;


import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    static final double lowestTemp = -273.0;
    private double[] temperatureList;
    private int numOfElements;
    private Object IllegalArgumentException;

    public TemperatureSeriesAnalysis() {
        int defaultSize = 4;
        temperatureList = new double[defaultSize];
        numOfElements = 0;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        for (double el: temperatureSeries) {
            if (el < lowestTemp) {
                throw new InputMismatchException();
            }
        }
        temperatureList = temperatureSeries;
        numOfElements = temperatureSeries.length;
    }

    public double average() {
        if (numOfElements == 0) {
            throw new IllegalArgumentException();
        }
        double sum = 0;
        for (double el: temperatureList) {
            sum += el;
        }
        return sum / numOfElements;
    }

    public double devitation() {
        if (numOfElements == 0) {
            throw new IllegalArgumentException();
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
            throw new IllegalArgumentException();
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
            throw new IllegalArgumentException();
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
        if (numOfElements == 0) {
            throw new IllegalArgumentException();
        }
        double valueDif = Math.abs(temperatureList[0] - tempValue);
        double curElement = temperatureList[0];
        for (double el: temperatureList) {
            if (Math.abs(el - tempValue) < valueDif) {
                valueDif = Math.abs(el - tempValue);
                curElement = el;
            }
        }
        return curElement;
    }

    public double[] findTempsLessThan(double tempValue) {
        if (numOfElements == 0) {
            throw new IllegalArgumentException();
        }
        double[] tempLessList = new double[numOfElements];
        int size = 0;
        for (double el: temperatureList) {
            if (el < tempValue) {
                tempLessList[size] = el;
                size += 1;
            }
        }
        return Arrays.copyOfRange(tempLessList, 0, size);
    }

    public double[] findTempsGreaterThan(double tempValue) {
        if (numOfElements == 0) {
            throw new IllegalArgumentException();
        }
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
            throw new IllegalArgumentException();
        }
        TempSummaryStatistics statistic = new TempSummaryStatistics(average(),
                                               devitation(), min(), max());

        return statistic;

    }
    
    public int addTemps(double[] temps) {
        for (double el: temps) {
            if (el < lowestTemp) {
                throw new InputMismatchException();
            }
        }
        while (temperatureList.length - numOfElements < temps.length) {
            double[] newTemperature = new double[2 * temperatureList.length];
            System.arraycopy(temperatureList, 0, newTemperature,
                      0, numOfElements);
            temperatureList = newTemperature;

        }
        for (double el: temps) {
            temperatureList[numOfElements] = el;
            numOfElements += 1;
        }

        return temps.length;
    }
}
