package com;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;


/*T.C.1.1
* GIVING the state census file
* checking the number of record matches*/
public class StateCensusAnalyzer{
    private static int count=0;
    private final String CSV_PATH = "C:\\Users\\irg\\IdeaProjects\\IndianStateCencusProblem\\StateCensusData.csv";

    public int readCSVData() throws IOException{
        Reader reader = Files.newBufferedReader(Paths.get(CSV_PATH));
        CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader)
                .withIgnoreLeadingWhiteSpace(true)
                .withSkipLines(1)
                .withType(CSVStateCensus.class).build();
        Iterator<CSVStateCensus> csvIterator = csvToBean.iterator();
        while (csvIterator.hasNext()) {
            count++;
            CSVStateCensus csvData = csvIterator.next();
            System.out.println(csvData);
        }

        return count;

        }
}