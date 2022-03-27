package hw4;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        Trains t = new Trains();

        String dep = "Astana";
        String dest = "Oral";

        t.readConnections();
        if(t.canReach(dep, dest) == true) {
            System.out.println("You may reach " + dest + " from " + dep);
        } else {
            System.out.println("Ooops! There is no such route");
        }
    }
}
