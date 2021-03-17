package com.learnJava.ngnix;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FilesSearch {

    public static void main(String[] args) throws IOException {

      List<String> list =   Files.list(Paths.get("C:/Project/IDA"))
                .map(p -> p.getFileName().toString())
                .filter(s -> s.contains("service"))
                .collect(Collectors.toList());

        System.out.println(list);
    }
}
