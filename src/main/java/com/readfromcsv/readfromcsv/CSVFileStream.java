package com.readfromcsv.readfromcsv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;


public class CSVFileStream {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src", "main", "resources", "mockData.csv");

        List<Products> storeProducts = Files.lines(path)
                .skip(1)
                .map(CSVFileStream::getProducts)
                .collect(Collectors.toList());

        System.out.println(storeProducts);// Close the stream after processing
    }

    private static Products getProducts(String line) {
        String[] fields = line.split(",");  // Corrected typo here: Changed "-" to "="
        int id = Integer.parseInt(fields[0]);
        String guid = fields[1];
        String productCategory = fields[2];
        double price = Double.parseDouble(fields[3].replace("$", "")); // Parse the price as a double
        int quantity = Integer.parseInt(fields[4]);

            if (fields.length != 5)
                throw new RuntimeException("Invalid CSV line - " + line);
        return new Products(id, guid, productCategory, price, quantity);
    }


}
