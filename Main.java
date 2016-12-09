import java.awt.Point;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        MazeSolver mazeSolver = new MazeSolver();

        Maze mazeWithOnePath = createMazeWithOnePath();
        LinkedList<Point> shortestPath = mazeSolver.solveMaze(mazeWithOnePath);;
    }

    private static Maze createMazeWithOnePath() {

        Point entrance = new Point(0, 1);
        Point exit = new Point(4, 1);

        int[][] grid = new int[5][5];

        grid[0][0] = 1;
        grid[0][1] = 0;
        grid[0][2] = 1;
        grid[0][3] = 1;
        grid[0][4] = 1;

        grid[1][0] = 1;
        grid[1][1] = 0;
        grid[1][2] = 1;
        grid[1][3] = 1;
        grid[1][4] = 1;

        grid[2][0] = 1;
        grid[2][1] = 0;
        grid[2][2] = 0;
        grid[2][3] = 0;
        grid[2][4] = 1;

        grid[3][0] = 1;
        grid[3][1] = 1;
        grid[3][2] = 1;
        grid[3][3] = 0;
        grid[3][4] = 1;

        grid[4][0] = 1;
        grid[4][1] = 0;
        grid[4][2] = 0;
        grid[4][3] = 0;
        grid[4][4] = 1;

        Maze maze = new Maze(entrance, exit, grid);

        return maze;
    }

}
