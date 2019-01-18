package com.test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
* count occurences of each word in a file
*
* @author  Yan Zhao
* @version 1.0
* @since   2019-01-18
*/
public class WordCount {
  
  public static void main(String[] args) throws URISyntaxException, IOException {
      Path path = Paths.get(WordCount.class.getClassLoader().getResource("test.txt").toURI());
            
      Stream<String> lines = Files.lines(path);
      String data = lines.collect(Collectors.joining(" "));
      
      data = data.replaceAll("[^a-zA-Z0-9\\s+]", "");
      String[] words = data.split("[\\s\\n\\r]");
      
      Map<String, Integer> map = Arrays.asList(words).stream()
          .filter(t -> t.length()> 0)
          .map(String::toLowerCase)
          .collect(Collectors.toMap(w -> w, w -> 1, Integer::sum));
      
      System.out.println(map);
      lines.close(); 
  }

}
