package com;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class StateCensusAnalyzerTest {
    private StateCensusAnalyzer stateCensusAnalyzer;

    @Before
    public void init() {
        stateCensusAnalyzer = new StateCensusAnalyzer();
    }

    @Test
    public void givenCSV_WhenRead_ShouldReturnCorrectRecordCount() throws StateAnalyzerException, IOException {
        String CSV_PATH = "C:\\Users\\irg\\IdeaProjects\\IndianStateCencusProblem\\StateCensusData.csv";

        int result = stateCensusAnalyzer.readCSVData(CSV_PATH);
            Assertions.assertEquals(29, result);
    }

    @Test
    public void givenCSVFilePath_WhenIncorrect_ShouldThrowStateAnalyzerException() {
        try {
            String INCORRECT_CSV_PATH = "C:\\Users\\irg\\IdeaProjects\\IndianStateCencusProblem\\StateCensusData.csv";
            stateCensusAnalyzer.readCSVData(INCORRECT_CSV_PATH);
        } catch (StateAnalyzerException e) {
            e.printStackTrace();
            Assertions.assertEquals(StateAnalyzerException.ExceptionType.INVALID_FILE_PATH,
                    e.type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

