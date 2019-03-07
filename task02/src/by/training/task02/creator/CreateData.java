package by.training.task02.creator;

import by.training.task02.exception.ReadFileException;
import by.training.task02.parser.DataParser;
import by.training.task02.reader.DataReader;
import by.training.task02.validator.FileValidator;
import by.training.task02.validator.LineValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateData {
    /**
     * Logger for writing in console and a file.
     */
    private static final Logger LOGGER = LogManager.getLogger();

    DataReader dataReader = new DataReader();
    FileValidator fileValidator = new FileValidator();
    DataParser dataParser = new DataParser();
    LineValidator lineValidator = new LineValidator();

    public List<Integer> createData(String path) throws ReadFileException {
        List<Integer> dataReady = new ArrayList<>();
        File file = new File(path);
        if (fileValidator.checkFile(file)) {
            List<String> lines = dataReader.readDataFromFile(path);
            List<List<Integer>> data = dataParser.parseData(lines);
            for (List<Integer> line : data) {
                dataReady = Arrays.asList(line.get(0), line.get(1), line.get(2),
                        line.get(3));
            }

        } else {
            LOGGER.warn("The file is incorrect!" + file);

        }
        return dataReady;
    }


}
