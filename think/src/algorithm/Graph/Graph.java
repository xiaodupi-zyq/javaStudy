package algorithm.Graph;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 16:23 2020/2/8
 * @Modified By:
 */


import java.util.*;

class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};

/**
 *无向图
 */
public class Graph {
    private int v;
    private LinkedList<Integer> adj[];
    private boolean found = false;

    /**
     * 构造函数
     * @param v 无向图中顶点个数
     */
    public Graph(int v){
        this.v = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++){
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 无向图中增加一条边。需要存储两次
     * @param s 两个顶点之一
     * @param t 两个顶点之二
     */
    public void addEdge(int s,int t){
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 广度优先搜索
     * @param s
     * @param t
     */
    public void bfs(int s,int t){
        if(s == t) {
            return;
        }
        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[v];
        for(int i = 0; i < v; ++i){
            prev[i] = -1;
        }
        while(queue.size() != 0){
            int w = queue.poll();
            for(int i = 0; i < adj[w].size();++i){
                int q = adj[w].get(i);
                if(!visited[q]){
                    prev[q] = w;
                    if(q == t){
                        print(prev,s,t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    /**
     * 打印路径
     * @param prev
     * @param s
     * @param t
     */
    private void print(int[] prev,int s,int t){
        if(prev[t] != -1 && t != s){
            print(prev,s,prev[t]);
        }
        System.out.println(t + " ");
    }

    /**
     * 深度优先搜索
     * @param s
     * @param t
     */
    public void dfs(int s,int t){
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for(int i = 0; i < v; i++){
            prev[i] = -1;
        }
        recurDfs(s,t,visited,prev);
        print(prev,s,t);
    }

    /**
     * 递归搜索该顶点的所有下层顶点，直到搜索到目标节点。
     * @param w
     * @param t
     * @param visited
     * @param prev
     */
    private void recurDfs(int w,int t,boolean[] visited,int[] prev){
        if(found == true){
            return;
        }
        visited[w] = true;
        if(w == t){
            found = true;
            return;
        }
        for(int i = 0; i < adj[w].size();++i){
            int q = adj[w].get(i);
            if(!visited[q]){
                prev[q] = w;
                recurDfs(q,t,visited,prev);
            }
        }
    }

    /**
     * 深度复制图，（采用bfs广度优先遍历复制）
     * @param node
     * @return
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return null;
        }
        Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode p = queue.poll();
            for(UndirectedGraphNode item : p.neighbors){
                if(!map.containsKey(item)){
                    queue.add(item);
                }
            }
            UndirectedGraphNode q = new UndirectedGraphNode(p.label);
            map.put(p,q);
        }
        for(UndirectedGraphNode item : map.keySet()){
            UndirectedGraphNode tmp = map.get(item);
            for(UndirectedGraphNode neighbor : item.neighbors){
                tmp.neighbors.add(map.get(neighbor));
            }
        }
        UndirectedGraphNode newNode = map.get(node);
        return newNode;
    }



}
