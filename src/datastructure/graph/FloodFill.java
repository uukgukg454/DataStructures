package datastructure.graph;

import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class FloodFill {
    public static void main(String[] args) {
        int[][] screen = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };
        int x = 4;
        int y = 4;
        int newColour = 5;
        int m = screen.length;
        int n = screen[0].length;
        int prevColour = screen[x][y];
        System.out.println("Before::\n" + Arrays.deepToString(screen));
        fillBFS(screen, x, y, m, n, prevColour, newColour);
//        if(prevColour!=newColour) {
//            fillRecursiveOrDFS(x, y, m, n, screen, prevColour, newColour);
//        }
        System.out.println("After::\n" + Arrays.deepToString(screen));
    }

    static void fillRecursiveOrDFS(int x, int y, int m, int n, int[][] screen, int prevColour, int newColour) {
        if (x < 0 || x >= m || y < 0 || y > n)
            return;
        if (screen[x][y] != prevColour)
            return;
        screen[x][y] = newColour;
        fillRecursiveOrDFS(x - 1, y, m, n, screen, prevColour, newColour);
        fillRecursiveOrDFS(x, y - 1, m, n, screen, prevColour, newColour);
        fillRecursiveOrDFS(x + 1, y, m, n, screen, prevColour, newColour);
        fillRecursiveOrDFS(x, y + 1, m, n, screen, prevColour, newColour);
    }

    static void fillBFS(int[][] screen, int x, int y, int m, int n, int prevColour, int newColour) {
        Stack<Pair> stack = new Stack<>();
        stack.add(new Pair(x, y));
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            screen[p.x][p.y] = newColour;
            neighbours(m, n, screen, p, stack, prevColour, newColour);
        }
    }

    static void neighbours(int m, int n, int[][] screen, Pair p, Stack<Pair> stack, int prevColour, int newColour) {
        int[] rowCoordinate = {-1, 0, 1, 1, 1, 0, -1, -1};
        int[] colCoordinate = {-1, -1, -1, 0, 1, 1, 1, 0};
        for (int i = 0; i < rowCoordinate.length; i++) {
            int newNeighbourX = p.x + rowCoordinate[i];
            int newNeighbourY = p.y + colCoordinate[i];
            if (newNeighbourX < m
                    && newNeighbourX >= 0
                    && newNeighbourY < n
                    && newNeighbourY >= 0
                    && screen[newNeighbourX][newNeighbourY] == prevColour
                    && screen[newNeighbourX][newNeighbourY] != newColour) {
                stack.add(new Pair(newNeighbourX, newNeighbourY));
            }
        }
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
