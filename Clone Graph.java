/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        UndirectedGraphNode nodecopy = new UndirectedGraphNode(node.label);
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> cloned = 
        	new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        cloned.put(node, nodecopy);
        while(!queue.isEmpty()) {
        	UndirectedGraphNode cur = queue.poll();
        	UndirectedGraphNode curcopy = cloned.get(cur);
        	for(int i = 0; i < cur.neighbors.size(); i++) {
        		UndirectedGraphNode neighbor = cur.neighbors.get(i);
        		UndirectedGraphNode neighborcopy = cloned.get(neighbor);
        		if(neighborcopy == null) {
        			neighborcopy = new UndirectedGraphNode(neighbor.label);
        			cloned.put(neighbor, neighborcopy);
        			queue.offer(neighbor);
        		}
        		curcopy.neighbors.add(neighborcopy);
        	}
        }
        return nodecopy;
    }
}