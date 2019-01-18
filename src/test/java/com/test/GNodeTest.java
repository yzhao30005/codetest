package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GNodeTest  {
  
  GNodeApp app;
  GNode a;
  
  @BeforeEach
  public void init() {
    app = new GNodeApp();
    
    a = new GNode("A");
    GNode b = new GNode("B");
    GNode c = new GNode("C");
    GNode d = new GNode("D");
    b.addChidren(new GNode("E"), new GNode("F"));
    c.addChidren(new GNode("G"), new GNode("H"), new GNode("I"));
    d.addChidren(new GNode("J"));
    a.addChidren(b, c, d);

  }

  
  @Test
  public void testWalkGraph() {
    List<GNode> list = app.walkGraph(a);  
    assertEquals(list.size(), 10);
    System.out.println(list);
  }
  
  @Test
  public void testPaths() {
    List<List<GNode>> list = new ArrayList<>();
    app.paths(a, new ArrayList<GNode>(), list);   
    assertEquals(list.size() , 6);
    System.out.println(list);
  }  
}
