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
    public void givenCSV_WhenRead_ShouldReturnCorrectRecordCount() {
        try {
            int result = stateCensusAnalyzer.readCSVData();
            Assertions.assertEquals(29, result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

