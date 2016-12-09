import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.Point;
import java.util.LinkedList;

public class MazeTest {

    MazeSolver mazeSolver;

    @Before
    public void setup() {
        mazeSolver = new MazeSolver();
    }

    @Test
    public void testSolveMazeWithOnePath() throws Exception {
        Maze mazeWithOnePath = createMazeWithOnePath();
        LinkedList<Point> shortestPath = mazeSolver.solveMaze(mazeWithOnePath);

        Assert.assertEquals(9, shortestPath.size());

        // Instead of just checking the shortest path length, we could also verify all the coordinates,
        // or locations, on the path.
    }

    @Test
    public void testSolveMazeWithTwoNonOverlappingPaths(){
        Maze mazeWithTwoNonOverlappingPaths = createMazeWithTwoNonOverlappingPaths();
        LinkedList<Point> shortestPath = mazeSolver.solveMaze(mazeWithTwoNonOverlappingPaths);

        Assert.assertEquals(5, shortestPath.size());
    }

    @Test
    public void testSolveMazeWithNoPaths() {
        Maze mazeWithNoPaths = createMazeWithNoPaths();
        LinkedList<Point> shortestPath = mazeSolver.solveMaze(mazeWithNoPaths);

        Assert.assertTrue(shortestPath.isEmpty());
    }

    @Test
    public void testSolveMazeWFromCodeChallengeWithOnePath() throws Exception {
        Maze mazeFromCodeChallengeWithOnePath = createMazeFromCodeChallengeWithOnePath();
        LinkedList<Point> shortestPath = mazeSolver.solveMaze(mazeFromCodeChallengeWithOnePath);

        Assert.assertEquals(38, shortestPath.size());
    }

    @Test
    public void testSolveMazeWFromCodeChallengeWithMultiplePaths() throws Exception {
        Maze mazeFromCodeChallengeWithMultiplePaths = createMazeFromCodeChallengeWithMultiplePaths();
        LinkedList<Point> shortestPath = mazeSolver.solveMaze(mazeFromCodeChallengeWithMultiplePaths);

        Assert.assertEquals(38, shortestPath.size());
    }

    private Maze createMazeWithOnePath() {

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

    private Maze createMazeWithTwoNonOverlappingPaths() {

        Point entrance = new Point(0, 1);
        Point exit = new Point(4, 1);

        int[][] grid = new int[5][5];

        grid[0][0] = 1;
        grid[0][1] = 0;
        grid[0][2] = 0;
        grid[0][3] = 0;
        grid[0][4] = 0;

        grid[1][0] = 1;
        grid[1][1] = 0;
        grid[1][2] = 1;
        grid[1][3] = 1;
        grid[1][4] = 0;

        grid[2][0] = 1;
        grid[2][1] = 0;
        grid[2][2] = 1;
        grid[2][3] = 1;
        grid[2][4] = 0;

        grid[3][0] = 1;
        grid[3][1] = 0;
        grid[3][2] = 1;
        grid[3][3] = 1;
        grid[3][4] = 0;

        grid[4][0] = 1;
        grid[4][1] = 0;
        grid[4][2] = 0;
        grid[4][3] = 0;
        grid[4][4] = 0;


        Maze maze = new Maze(entrance, exit, grid);

        return maze;
    }

    private Maze createMazeWithNoPaths() {

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
        grid[4][2] = 1;
        grid[4][3] = 0;
        grid[4][4] = 1;


        Maze maze = new Maze(entrance, exit, grid);

        return maze;
    }


    private Maze createMazeFromCodeChallengeWithOnePath() {

        int mazeWidth = 16;
        int mazeHeight = 16;
        Point entrance = new Point(0, 2);
        Point exit = new Point(15, 12);

        int[][] grid = new int[16][16];

        // First, make every position in the maze grid a wall.
        for (int i = 0; i < mazeWidth; i++) {
            for (int j = 0; j < mazeHeight; j++) {
                grid[i][j] = 1;
            }

        }

        // Then, set the possible paths through the maze.
        grid[0][2] = 0;
        grid[1][2] = 0;
        grid[2][2] = 0;
        grid[2][1] = 0;
        grid[3][1] = 0;
        grid[4][1] = 0;
        grid[4][2] = 0;
        grid[4][3] = 0;
        grid[4][4] = 0;
        grid[3][4] = 0;
        grid[2][4] = 0;
        grid[5][1] = 0;
        grid[6][1] = 0;
        grid[6][2] = 0;
        grid[6][3] = 0;
        grid[6][4] = 0;
        grid[6][5] = 0;
        grid[6][6] = 0;
        grid[6][7] = 0;
        grid[5][7] = 0;
        grid[4][7] = 0;
        grid[4][8] = 0;
        grid[7][3] = 0;
        grid[8][3] = 0;
        grid[8][2] = 0;
        grid[8][1] = 0;
        grid[9][1] = 0;
        grid[10][1] = 0;
        grid[10][2] = 0;
        grid[10][3] = 0;
        grid[10][4] = 0;
        grid[11][4] = 0;
        grid[11][5] = 0;
        grid[11][6] = 0;
        grid[10][6] = 0;
        grid[9][6] = 0;
        grid[8][6] = 0;
        grid[8][7] = 0;
        grid[8][8] = 0;
        grid[8][9] = 0;
        grid[7][9] = 0;
        grid[9][8] = 0;
        grid[10][8] = 0;
        grid[11][8] = 0;
        grid[11][9] = 0;
        grid[11][10] = 0;
        grid[11][11] = 0;
        grid[11][12] = 0;
        grid[12][8] = 0;
        grid[13][8] = 0;
        grid[14][8] = 0;
        grid[14][9] = 0;
        grid[14][10] = 0;
        grid[14][11] = 0;
        grid[14][12] = 0;
        grid[15][12] = 0;

        Maze maze = new Maze(entrance, exit, grid);

        return maze;
    }


    private Maze createMazeFromCodeChallengeWithMultiplePaths () {

        int mazeWidth = 16;
        int mazeHeight = 16;
        Point entrance = new Point(0, 2);
        Point exit = new Point(15, 12);

        int[][] grid = new int[16][16];

        // First, make every position in the maze grid a wall.
        for (int i = 0; i < mazeWidth; i++) {
            for (int j = 0; j < mazeHeight; j++) {
                grid[i][j] = 1;
            }

        }

        // Then, set the possible paths through the maze.
        grid[0][2] = 0;
        grid[1][1] = 0;
        grid[1][2] = 0;
        grid[2][2] = 0;
        grid[2][1] = 0;
        grid[3][1] = 0;
        grid[4][1] = 0;
        grid[4][2] = 0;
        grid[4][3] = 0;
        grid[4][4] = 0;
        grid[3][4] = 0;
        grid[2][4] = 0;
        grid[5][1] = 0;
        grid[6][1] = 0;
        grid[6][2] = 0;
        grid[6][3] = 0;
        grid[6][4] = 0;
        grid[6][5] = 0;
        grid[6][6] = 0;
        grid[6][7] = 0;
        grid[5][7] = 0;
        grid[4][7] = 0;
        grid[4][8] = 0;
        grid[7][3] = 0;
        grid[8][3] = 0;
        grid[8][2] = 0;
        grid[8][1] = 0;
        grid[9][1] = 0;
        grid[10][1] = 0;
        grid[10][2] = 0;
        grid[10][3] = 0;
        grid[10][4] = 0;
        grid[11][4] = 0;
        grid[11][5] = 0;
        grid[11][6] = 0;
        grid[10][6] = 0;
        grid[9][6] = 0;
        grid[8][6] = 0;
        grid[8][7] = 0;
        grid[8][8] = 0;
        grid[8][9] = 0;
        grid[7][9] = 0;
        grid[9][8] = 0;
        grid[10][8] = 0;
        grid[11][8] = 0;
        grid[11][9] = 0;
        grid[11][10] = 0;
        grid[11][11] = 0;
        grid[11][12] = 0;
        grid[11][13] = 0;
        grid[12][13] = 0;
        grid[13][13] = 0;
        grid[14][13] = 0;
        grid[12][8] = 0;
        grid[13][8] = 0;
        grid[14][8] = 0;
        grid[14][9] = 0;
        grid[14][10] = 0;
        grid[14][11] = 0;
        grid[14][12] = 0;
        grid[15][12] = 0;

        Maze maze = new Maze(entrance, exit, grid);

        return maze;
    }
}
