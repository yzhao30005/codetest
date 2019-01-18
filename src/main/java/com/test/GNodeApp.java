package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


/**
* GNode methods, find all the nodes, all the paths
*
* @author  Yan Zhao
* @version 1.0
* @since   2019-01-18
*/

public class GNodeApp 
{
  
  /**
   * this method is used to get all the nodes and store into a list.
   * 
   * @param node - current nocde
   * result  - a list of all the nodes
   */
    public List<GNode> walkGraph(GNode node) {
      List<GNode> nodes = new ArrayList<>();
      nodes.add(node);
      
      for(GNode child : node.getChildren())
        nodes.addAll(walkGraph(child));
      
      return nodes;
    }
    
    /**
     * this method is used to navigate all node paths and store into a list.
     * 
     * @param node - current nocde
     * @param parent  - current node path, it contains all ancestors from the top level node
     * @param result  - store all node paths
     */
    public void paths(GNode node, List<GNode> parent, List<List<GNode>> result) {
      List<GNode> path = Arrays.asList(parent, Arrays.asList(node))
          .stream()
          .flatMap(Collection::stream)
          .collect(Collectors.toList());
      
      if(node.getChildren().length == 0) {
        result.add(path);
      } else {
        
        for(GNode child : node.getChildren())  {
          paths(child, path,result);
        }
        
      }
    }
    
}
