import java.awt.Point;

public class Maze {

    // The Maze has an entrance, an exit and a grid.

    // The grid represents the maze.  It is a two dimensional array of zeros and ones.  If a location, or coordinate,
    // on the grid is a wall, then its value will be 1.  Otherwise, its value with be 0.

    // A path through the maze is a list of coordinates that lead from the entrance to the exit.  Each coordinate in the
    // path will have a zero value in the grid.

    Point entrance;
    Point exit;
    int[][] grid;

    public Maze(Point entrance, Point exit, int[][] grid) {
        this.entrance = entrance;
        this.exit = exit;
        this.grid = grid;
    }

    public int getMazeHeight (){
        return this.grid.length;
    }

    public int getMazeHWidth (){
        return this.grid[0].length;
    }

}
