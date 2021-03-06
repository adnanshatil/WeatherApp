package com.weather.app.log;

import com.weather.app.constant.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class CustomLogger {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Value("${custom.logging.file}")
    private String customLoggingFile;

    public void writeToLog(final String line) {

        if (!StringUtils.isEmpty(line)) {
            Path path = Paths.get(customLoggingFile);

            File file = new File(path.toString());

            if(!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException exp) {
                    LOG.error("Error creating file: " + exp.getMessage());
                }
            }

            try(PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(customLoggingFile, true)))) {
                printWriter.println(line);
            }catch (IOException exp) {
                LOG.error("Error writing into file: " + exp.getMessage());
            }
        }
    }

    public String readFromLog() {

        Path path = Paths.get(customLoggingFile);

        try {
            final List<String> fileLines = Files.readAllLines(path);

            if(!fileLines.isEmpty()) {
                return String.join(Constant.LINE_BREAK, fileLines);
            }
        } catch(IOException exp) {
            LOG.error("Error reading from file: " + exp.getMessage());
        }

        return Constant.EMPTY_STRING;
    }

}
