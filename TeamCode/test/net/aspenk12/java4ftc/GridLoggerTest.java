package net.aspenk12.java4ftc;

import net.aspenk12.java4ftc.ps4.FileLogWriter;
import net.aspenk12.java4ftc.ps4.GridLogger;
import net.aspenk12.java4ftc.ps4.TestWriter;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GridLoggerTest {

    @Test
    public void writeLn() {
        TestWriter writer = new TestWriter();
        GridLogger gridLogger = new GridLogger(writer);
        gridLogger.setColumnHeaders(new String[]{"RobotX", "RobotY"});
        gridLogger.add("RobotX", 2.4);
        gridLogger.add("RobotY", 3.2);
        gridLogger.writeRow();

        gridLogger.add("RobotX", 5.0);
        gridLogger.add("RobotY", 6.7);
        gridLogger.writeRow();

        List<String> lines = writer.getLines();
        assertEquals("RobotX,RobotY", lines.get(0));
        assertEquals("2.4,3.2", lines.get(1));
        assertEquals("5.0,6.7", lines.get(2));
    }
    @Test
    public void writeFile() {
        FileLogWriter fileWriter = new FileLogWriter("/Desktop/GridLogTest.csv");
        GridLogger gridLogger = new GridLogger(fileWriter);
        gridLogger.setColumnHeaders(new String[]{"RobotX", "RobotY"});
        gridLogger.add("RobotX", 2.4);
        gridLogger.add("RobotY", 3.2);
        gridLogger.writeRow();

        gridLogger.add("RobotX", 5);
        gridLogger.add("RobotY", 6.7);
        gridLogger.writeRow();


    }

}