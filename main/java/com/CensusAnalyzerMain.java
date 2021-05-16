package com;

import java.io.IOException;

public class CensusAnalyzerMain {
    public static void main(String[] args) throws IOException {
        StateCensusAnalyzer stateCensusAnalyzer = new StateCensusAnalyzer();
        stateCensusAnalyzer.readCSVData();
    }
}
