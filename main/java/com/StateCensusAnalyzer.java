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

    /*TC 1.2
    * Given state census csv file
    * if incorrect returns exception*/
    public int readCSVData(String filePath) throws IOException , StateAnalyzerException{
        try {
            Files.newBufferedReader(Paths.get(filePath));
        } catch (IOException e) {
            throw new StateAnalyzerException("Invalid Path Name",
                    StateAnalyzerException.ExceptionType.INVALID_FILE_PATH);
        }
        Reader reader = Files.newBufferedReader(Paths.get(filePath));
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