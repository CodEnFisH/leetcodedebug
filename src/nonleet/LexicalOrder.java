package nonleet;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by codefish on 2/15/15.
 */
public class LexicalOrder {
    class GraphNode {
        char k;
        List<GraphNode> nb = new LinkedList<GraphNode>();
        GraphNode(char c) {k = c;}
    }
    public List<Character> getOrder(String[] dict){
        GraphNode[] nodes = new GraphNode[26];
        for(int i = 0; i < dict.length - 1; i++){
            int j = i + 1, k = 0;
            while(k < Math.min(dict[i].length(), dict[j].length()) && dict[i].charAt(k) ==
                    dict[j].charAt(k)) k++;
            if(nodes[dict[i].charAt(k) - 'a'] == null) nodes[dict[i].charAt(k) - 'a'] = new
                    GraphNode(dict[i].charAt(k));
            if(nodes[dict[j].charAt(k) - 'a'] == null) nodes[dict[j].charAt(k) - 'a'] = new
                    GraphNode(dict[j].charAt(k));
            nodes[dict[j].charAt(k) - 'a'].nb.add(nodes[dict[i].charAt(k) - 'a']);
        }
        List<Character> ret = new LinkedList<Character>();
        boolean[] visited = new boolean[26];
        for(GraphNode node: nodes){
            if(!visited[node.k - 'a']) dfs(node, visited, ret);
        }
        return ret;
    }
    public void dfs(GraphNode node, boolean[] visited, List<Character> ret){
        visited[node.k - 'a'] = true;
        for(GraphNode n: node.nb){
            if(!visited[n.k - 'a']) dfs(n, visited, ret);
        }
        ret.add(node.k);
    }
}
