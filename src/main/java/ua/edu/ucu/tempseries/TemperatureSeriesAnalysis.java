package ua.edu.ucu.tempseries;

import jdk.javadoc.internal.doclets.toolkit.util.DocFinder;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private double[] temperatureList;
    private int numOfElements;
    private Object IllegalArgumentException;

    public TemperatureSeriesAnalysis(){
        double[] temperatureList = new double[4];
        int numOfElements = 0;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        for (double el: temperatureSeries)
            if (el < -273)
                throw new InputMismatchException();
        double[] temperatureList = temperatureSeries;
        int numOfElements = temperatureSeries.length;
    }

    double average(){
        if (numOfElements == 0)
            return 0.0;
        double sum = 0;
        for (double el: temperatureList){
            sum += el;
        }
        return sum / numOfElements;
    }

    double deviation(){
        if (numOfElements == 0)
            return 0.0;
        double avr = average();
        double sumSquaredDevitaion = 0.0;
        for (double el: temperatureList){
            sumSquaredDevitaion += (avr - el) * (avr - el);
        }
        return sumSquaredDevitaion / numOfElements;

    }

    double min(){
        double minValue = temperatureList[0];
        for (double el: temperatureList){
            if (el < minValue)
                minValue = el;
        }
        return minValue;
    }

    double max(){
        double maxValue = -273.0;
        for (double el: this.temperatureList){
            if (el < maxValue)
                maxValue = el;
        }
        return maxValue;
    }


    double findTempClosestToZero(){
        return findTempClosestToValue(0.0);
    }

    double findTempClosestToValue(double tempValue){
        double valueDif = Math.abs(temperatureList[0] - tempValue);
        for (double el: temperatureList){
            if (Math.abs(el - tempValue) < valueDif)
                valueDif = Math.abs(el - tempValue);
        }
        return valueDif;
    }

    double[] findTempsLessThan(double tempValue){
        double[] tempLessList = new double[numOfElements];
        int size = 0;
        for (double el: temperatureList){
            if (el < tempValue){
                tempLessList[size] = el;
                size += 1;
            }
        }
        return tempLessList;
    }

    double[] findTempsGreaterThan(double tempValue){
        double[] tempGreaterList = new double[numOfElements];
        int size = 0;
        for (double el: temperatureList){
            if (el > tempValue){
                tempGreaterList[size] = el;
                size += 1;
            }
        }
        return tempGreaterList;
    }

    TempSummaryStatistics summaryStatistics(){
        if (this.numOfElements == 0)
            return (TempSummaryStatistics) IllegalArgumentException;
        TempSummaryStatistics statistic = new TempSummaryStatistics(average(), deviation(), min(), max());

        return statistic;

    }
    
    int addTemps(double[] temps){
        for (double el: temps)
            if (el < -273)
                throw new InputMismatchException();
        while (numOfElements - temperatureList.length < temps.length){
            double[] newTemperatureList = new double[2 * numOfElements];
            System.arraycopy(temperatureList, 0, newTemperatureList, 0, numOfElements);
            temperatureList = newTemperatureList;
        }
        System.arraycopy(temps, 0, temperatureList, numOfElements, numOfElements + temps.length);

        numOfElements += temps.length;
        return numOfElements;
    }
}
