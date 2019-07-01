package org.saviour.utils;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.Test;

public class FileUtilsTest {

  @Test
  public void getFileAsString() throws IOException, URISyntaxException {
    assertEquals(FileUtils.getFileAsString("test-file.txt"), "this is a test file");
  }
}