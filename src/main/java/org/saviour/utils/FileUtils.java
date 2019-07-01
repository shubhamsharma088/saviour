package org.saviour.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

  public static String getFileAsString(String resourceName) throws IOException, URISyntaxException {
    return new String(
        Files.readAllBytes(Paths.get(ClassLoader.getSystemResource(resourceName).toURI())));
  }

}
