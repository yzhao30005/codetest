package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GNode {
  
  private final String name;
  private List<GNode> children = new ArrayList<>();
  
  public GNode(final String name, final GNode[] children) {
    this.name = Objects.requireNonNull(name, "name can't be null");   
    
    if(children != null)
      this.children = Arrays.asList(children);
    
  }
  
  public GNode(final String name) {
    this(name, null) ; 
  }
  
  public String getName() {

    return name;
  }

  public GNode[] getChildren() {
    return (GNode[]) children.toArray(new GNode[children.size()]);
  }

  public void setChildren(GNode[] children) {
    this.children = Arrays.asList(children);
  }

  public void addChidren(GNode... children) {
    this.children.addAll(Arrays.asList(children));
  }
  
  @Override
  public String toString() {
    return name;
  }

}
