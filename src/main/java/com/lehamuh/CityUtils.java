package com.lehamuh;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CityUtils {
    private static final String FILE_PATH = "src/main/resources/city_ru.csv";

    public static List<City> parse() {
        List<City> catalog = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(FILE_PATH));
            while (scanner.hasNextLine()) {
                String city = scanner.nextLine();
                String[] cityParam = city.split(";");
                if (cityParam.length < 6) {
                    cityParam = Arrays.copyOf(cityParam, 6);
                    cityParam[5] = null;
                }
                catalog.add(new City(cityParam[1], cityParam[2], cityParam[3],
                        Integer.parseInt(cityParam[4]), cityParam[5]));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return catalog;
    }

    public static void printCatalog(List<City> catalog) {
        catalog.forEach(System.out::println);
    }
}
