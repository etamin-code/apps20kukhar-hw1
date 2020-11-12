package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    public double avgTemp;
    public double devTemp;
    public double minTemp;
    public double maxTemp;

    public TempSummaryStatistics(){

    }

    public TempSummaryStatistics(double avgTemp, double devTemp, double minTemp, double maxTemp){
        this.avgTemp = avgTemp;
        this.devTemp = devTemp;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }
}
