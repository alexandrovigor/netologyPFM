package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CategorySelect {
    public static String getCategories(String title) throws IOException {
        BufferedReader tsvFile =
                new BufferedReader(new FileReader("categories.tsv"));
        String dataRow = tsvFile.readLine();

        while (dataRow != null) {
            String[] dataArray = dataRow.split("\t");
            if (title.equals(dataArray[0])) {

                return dataArray[1];
            }
            dataRow = tsvFile.readLine();
        }
        return "Другое";
    }
}
