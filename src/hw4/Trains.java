package hw4;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Trains {

    private Map<String, Set<String>> connections;

    public Trains() {
        connections = new HashMap<String, Set<String>>();
   }


    public void readConnections() throws IOException {

        File infile = new File("connections.txt");
        Scanner scanner = new Scanner(infile);
        while (scanner.hasNext()) {
            String departure = scanner.next();
            String destination = scanner.next();

            //System.out.println("Dep: " + departure + " Dest: " + destination);

            if (!connections.containsKey(departure)) {
                Set<String> set = new LinkedHashSet<String>();
                set.add(destination);
                connections.put(departure, set);
            }

            if (connections.containsKey(departure)) {
                connections.get(departure).add(destination);
            }
        }
        scanner.close();
    }

    public boolean canReach(String source, String finish) {
        if(connections.get(source) == null) {
            return false;
        }

        List<String> q = new ArrayList<String>();
        q.add(source);

        Set<String> used = new LinkedHashSet<String>();

        boolean visit = false;

        while(!q.isEmpty()) {
            String v = q.remove(0);
            used.add(v);
            if(connections.containsKey(v)) {
                for(String vertex : connections.get(v)) {
                    if(!used.contains(vertex)) {
                        if(vertex.equals(finish)) {
                            visit = true;
                            break;
                        }
                        q.add(vertex);
                    }
                }
            }
        }
        return visit;
    }

    public void print() {
        System.out.println(connections);
    }


}
