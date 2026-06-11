import java.util.*;

public class Graph {

    public static void main(String[] args) {

        int n = 4;

        ArrayList<Integer>[] graph =
                new ArrayList[n];

        for(int i=0;i<n;i++){

            graph[i] =
                    new ArrayList<>();
        }

        graph[0].add(1);
        graph[1].add(0);

        graph[0].add(2);
        graph[2].add(0);

        graph[1].add(3);
        graph[3].add(1);

        graph[2].add(3);
        graph[3].add(2);

        for(int i=0;i<n;i++){

            System.out.println(
                    i + " -> "
                    + graph[i]
            );
        }
    }
}