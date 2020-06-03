import java.util.*;

public class Graph {

    private Map<String, Vertex> vertices;

    public Graph(){
        vertices = new HashMap<>();
    }

    public void addVertex(String name){
        Vertex v = new Vertex();
        v.name = name;
        v.adjacent = new ArrayList<>();
        vertices.put(name, v);
    }

    public void addLink(String n1, String n2){
        Vertex v1 = vertices.get(n1);
        Vertex v2 = vertices.get(n2);
        v1.adjacent.add(new Edge(v2));
        v2.adjacent.add(new Edge(v1));
    }

    public static void main(String[] args){
        Graph g = new Graph();
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addLink("A", "B");
        g.addLink("B", "C");
        g.addLink("C", "D");
        g.addLink("D", "A");
        //g.addLink("D", "B");
        System.out.println("Bipartite result = " + g.isBipartite());
    }

    // Solution Begins here v

    public boolean isBipartite(){
        clearAll();
        String start = vertices.keySet().iterator().next();
        vertices.get(start).scratch = COLOR_2;
        return bipartiteHelper(true, start);
    }

    private static final int COLOR_1 = 1;
    private static final int COLOR_2 = -1;
    public boolean bipartiteHelper(boolean color, String currName){
        Vertex curr = vertices.get(currName);
        int adjColor = color ? COLOR_1 : COLOR_2;
        for(Edge e : curr.adjacent){
            Vertex dest = e.dest;
            if(dest.scratch == 0){
                dest.scratch = adjColor;
                if(!bipartiteHelper(!color, dest.name))
                    return false;
            }
            else if(dest.scratch != adjColor){
                return false;
            }
            // If vertex's color is already correct, perfect, keep checking!
        }
        return true;
    }

    // Solution ends here ^

    private void clearAll(){
        for(String name : vertices.keySet()){
            vertices.get(name).scratch = 0;
        }
    }

    private static class Vertex {
        private String name;
        private List<Edge> adjacent;
        private int scratch;
        //private Vertex prev;
    }

    private static class Edge {
        private Vertex dest;
        private Edge(Vertex d){
            dest = d;
        }

       // private double cost;
    }
}