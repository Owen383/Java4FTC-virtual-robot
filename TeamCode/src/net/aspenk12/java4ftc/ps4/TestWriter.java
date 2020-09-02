package net.aspenk12.java4ftc.ps4;

import java.util.ArrayList;
import java.util.List;

public class TestWriter implements LogWriter{
    private List<String> lines = new ArrayList<>();
    public boolean stopCalled = false;

    public void writeLine(String line) {
        lines.add(line);
    }

    public void stop() {
        stopCalled = true;
    }

    public List<String> getLines() {
        return lines;
    }

}
