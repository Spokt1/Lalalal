package projectBFS;

import java.util.*;

/**
 * Created by slava on 21.05.2017.
 */
public class NewBfs {
    private static final int n = 5;
    private boolean[] visited;
    private int[][] matrix;
    public NewBfs() {
        visited = new boolean[n];
        Arrays.fill(visited,false);
        matrix = new int[][]{
                {0, 1, 1, 0,0},
                {1, 0, 0, 1,0},
                {1, 0, 0, 0,1},
                {0, 1, 0, 0,1},
                {0, 0, 1, 1,0}
        };
    }

    public void setMatrix(int[][] a){
        matrix = a;
        visited = new boolean[matrix.length];
    }

    private boolean isCorrectMatrixDemention(int [][]matr){
        for (int i = 0; i < matr.length; i++) {
            if(matr.length != matr[i].length){
                return false;
            }
        }
        return true;
    }

    private boolean isCorrectInpurValues(Integer start_point,Integer search_point){
        if (start_point <1 || start_point > matrix.length) return false;
        if (search_point <1 || start_point > matrix.length) return false;
        return true;
    }

    /**
     * @param start_point - начальная точка для поиска пути.
     * @param search_point - конечная точка в поиске пути.
     * @return возвращается строка, представляющая собой кратчайщий путь от start_point до search_point.
     */

    public String run(Integer start_point,Integer search_point, TypeOutput typeOutput){

        if(!isCorrectMatrixDemention(matrix)) return "invalid size of matrix";
        if(!isCorrectInpurValues(start_point,search_point)) return "invalid input values";

        int counter=0;
        Queue<Integer> queue = new LinkedList<>();
        List<String> list = new LinkedList<>();
        list.add(start_point.toString());
        start_point--;
        queue.add(start_point);
        visited[start_point] = true;
        while(!queue.isEmpty()){
            int index = queue.poll();
            for (int i = 0; i < matrix[index].length; i++) {
                if(index == search_point-1){break;} // отсечение обхода всех путей
                if (matrix[index][i] == 0  || (visited[i] && i!=search_point-1)) continue;
                queue.add(i);
                list.add(list.get(counter)+"-"+Integer.toString(i+1));
                visited[i] = true;
            }
            counter++;
        }
        String temp = "";
        Deque<Route> ans = new ArrayDeque<>();
        for (String s : list) {
            if (s.contains(search_point.toString())){
                Route r = new Route();
                r.setRoute(s);
                r.setWeight(getWeight(s));
                if(ans.peekFirst() == null || r.getWeight()<ans.peekFirst().getWeight()){
                    ans.addFirst(r);
                }
                else ans.addLast(r);
            }
        }
        if (typeOutput == TypeOutput.MINROUTE){
            if(!ans.isEmpty())
                temp = ans.getFirst().toString();
        }
        else if (typeOutput == TypeOutput.PRINTALLROUTES) {
            for (Route r : ans) {
                temp += r + "\n";
            }
        }
        return temp;
    }

    private int getWeight(String route){
        int weight = 0;
        String[] strings = route.split("-");
        for (int i = 0; i < strings.length-1; i++) {
            weight += matrix[Integer.parseInt(strings[i])-1][Integer.parseInt(strings[i+1])-1];
        }
        return weight;
    }
}
