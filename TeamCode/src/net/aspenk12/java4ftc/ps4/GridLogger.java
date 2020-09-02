package net.aspenk12.java4ftc.ps4;


import java.util.ArrayList;
import java.util.HashMap;

public class GridLogger {
    private LogWriter writer;
    private HashMap<String, String> rowData = new HashMap<>();
    ArrayList<String> columnHeaders = new ArrayList<>();
    long startTime = System.currentTimeMillis();

    private boolean firstWrite = true;

    public GridLogger(LogWriter writer) {
        this.writer = writer;
    }

    public void setColumnHeaders(String[] columns) {

        for (String element : columns) {
            if(!columnHeaders.contains(element)){
                columnHeaders.add(element);
            }
        }
    }

    public void add(String column, double value) {
        if(firstWrite){
            if(!columnHeaders.contains(column)){
                columnHeaders.add(column);
            }
        }
        rowData.put(column, String.valueOf(value));

    }

    public void writeRow() {
        int i = 0;
        StringBuilder rowString = new StringBuilder();
        if(firstWrite) {
            rowString.append("Time,");
            for (String element : columnHeaders) {
                i++;
                rowString.append(element);
                if (i < columnHeaders.size()) {
                    rowString.append(",");
                }
            }
            writer.writeLine(rowString.toString());
            firstWrite = false;
        }
        i = 0;
        rowString.delete(0,200);
        String currentTime = String.valueOf(System.currentTimeMillis() - startTime);
        for(String element : columnHeaders){
            i++;
            rowString.append(currentTime);
            if(rowData.get(element) == null){
                rowString.append("null");
            }
            else{
                rowString.append(rowData.get(element));
            }

            if(i < columnHeaders.size()){
                rowString.append(",");
            }
        }
        writer.writeLine(rowString.toString());
        rowData.clear();
    }

    public void stop() {
        writer.stop();
    }

}
