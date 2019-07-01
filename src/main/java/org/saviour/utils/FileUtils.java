package org.saviour.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

  public static String getFileAsString(String filePath) throws IOException {
    return new String(Files.readAllBytes(Paths.get(filePath)));
  }

}
