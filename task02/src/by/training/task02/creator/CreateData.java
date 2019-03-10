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
import java.util.List;

public class CreateData {

    /**
     * Logger for writing in console and a file.
     */
    private static final Logger LOGGER = LogManager.getLogger();

    private DataReader dataReader = new DataReader();
    private FileValidator fileValidator = new FileValidator();
    private DataParser dataParser = new DataParser();
    private LineValidator lineValidator = new LineValidator();

    public List<Integer> createData(String path) throws ReadFileException {
        List<Integer> data = new ArrayList<>();
        File file = new File(path);
        if (fileValidator.checkFile(file)) {
            List<String> lines = dataReader.readDataFromFile(path);
            for (String line : lines) {
                if (lineValidator.checkLine(line)) {
                    data = dataParser.parseData(line);
                }
            }
        } else {
            LOGGER.warn("The file is incorrect!" + file);
        }
        return data;
    }
}
