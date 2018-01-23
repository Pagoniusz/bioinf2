import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tswed on 20.01.2018.
 */
public class Main {
    public static void main(String [] args)
    {
        int k=3;
        ArrayList<String> L = lectureExaple();
        ArrayList<Node> nodes = convertToNode(L);
        ArrayList<DigraphEdge> edges = buildGraph(nodes);
        printEdges(edges,nodes);
        ArrayList<String> newNodes = rebuildNodes(edges,nodes);
        ArrayList<DigraphEdge> newEdges = rebuildGraph(edges,nodes,newNodes);
        EulerianPath tmp = new EulerianPath();
        ArrayList<String> path = tmp.getEulerianPath(newNodes,newEdges);
        printCompleteResult(path);

        System.out.println("Done");
    }

    public static ArrayList<String> lectureExaple(){
        ArrayList<String> L = new ArrayList<>();
        L.add("AAA");
        L.add("AAC");
        L.add("ACA");
        L.add("CAC");
        L.add("CAA");
        L.add("ACG");
        L.add("CGC");
        L.add("GCA");
        L.add("ACT");
        L.add("CTT");
        L.add("TTA");
        L.add("TAA");
        return L;
    }

    public static ArrayList<Node>convertToNode(ArrayList<String> L){
        ArrayList<Node> result = new ArrayList<>();
        for (String s:L) {
            result.add(new Node(s,s.substring(0,s.length()-1),s.substring(1,s.length()),Character.toString(s.charAt(s.length()-1))));
        }
        return result;
    }

    public static int findConnection(String word, ArrayList<Node> nodes){
        for (Node n: nodes) {
            if (n.getPrefix().equals(word)) {
                int fg=nodes.indexOf(n);
                return fg;
            }
        }
        return -1;
    }

    public static ArrayList<DigraphEdge>buildGraph(ArrayList<Node> nodes){
        ArrayList<DigraphEdge> edges = new ArrayList<>();
        for (Node n:nodes) {
            int index = findConnection(n.getSuffix(),nodes);
            if (index != -1){
                edges.add(new DigraphEdge(nodes.indexOf(n),index,n.getLastChar()));
            }
        }
        return edges;
    }

    public static void printEdges(ArrayList<DigraphEdge> edges, ArrayList<Node> nodes){
        for (DigraphEdge e:edges) {
            System.out.println(nodes.get(e.getPrefixIndex()).getPrefix() + " -----" + e.getLetter() + "----> " + nodes.get(e.getSuffixIndex()).getPrefix());
        }
    }

    public static ArrayList<String> rebuildNodes(ArrayList<DigraphEdge> edges, ArrayList<Node> nodes){
        Set<String> set = new HashSet<>();
        for (DigraphEdge e:edges) {
            set.add(nodes.get(e.getPrefixIndex()).getPrefix());
            set.add(nodes.get(e.getPrefixIndex()).getSuffix());
        }
        ArrayList<String> result = new ArrayList<>();
        result.addAll(set);
        return result;
    }

    public static ArrayList<DigraphEdge> rebuildGraph(ArrayList<DigraphEdge> edges, ArrayList<Node> nodes, ArrayList<String> newNodes){
        ArrayList<DigraphEdge> result = new ArrayList<>();
        for (DigraphEdge e: edges) {
            DigraphEdge newEdge = new DigraphEdge();
            newEdge.setLetter(e.getLetter());
            newEdge.setPrefixIndex(findNewNodeIndex(nodes.get(e.getPrefixIndex()).getPrefix(),newNodes));
            newEdge.setSuffixIndex(findNewNodeIndex(nodes.get(e.getPrefixIndex()).getSuffix(),newNodes));
            result.add(newEdge);
        }
        return result;
    }

    public static int findNewNodeIndex(String node, ArrayList<String> nodes){
        for (String s:nodes) {
            if (s.equals(node))
                return nodes.indexOf(s);
        }
        return -1;
    }

    public static void printCompleteResult(ArrayList<String> result){
        System.out.println("Path: ");
        for(int i = 0; i<result.size() - 1; i++)
        {
            System.out.print(result.get(i));
            System.out.print(" --> ");
        }
        System.out.print(result.get(result.size() - 1)); // ostatni brakuj¹cy node
        
        System.out.println();
        System.out.println("Spektrum:");
        String spectrum="";
        
        spectrum+=result.get(0);  
        for (int i = 1; i < result.size(); i++) {
            String s = result.get(i);
            spectrum+=s.substring(s.length()-1,s.length());
        }
        System.out.println(spectrum);
    }
}
