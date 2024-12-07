package com.kindred.sports.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {
    public static List<String> readSportsFromFile(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }
}
