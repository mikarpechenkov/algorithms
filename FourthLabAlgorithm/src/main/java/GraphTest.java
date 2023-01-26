import java.util.ArrayList;
import java.util.List;

class GraphTest {

  public static void main(String[] args) {
    int MAX = Integer.MAX_VALUE/2;
    List<List<Integer>> list = List.of(
        List.of(MAX,7,12,25,10),
        List.of(10,MAX,9,5,11),
        List.of(13,8,MAX,6,4),
        List.of(6,11,15,MAX,15),
        List.of(5,9,12,17,MAX)
    );
    new Graph(list).bfs();
  }
}
