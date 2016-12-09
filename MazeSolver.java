import java.awt.Point;
import java.util.LinkedList;

public class MazeSolver {

    private Maze mazeToSolve;
    private LinkedList pathsToExit = new LinkedList();

    public LinkedList<Point> solveMaze(Maze maze) {

        // Solve the maze by finding the shortest path through it.
        // If the maze cannot be solved, then there will be no paths.

        mazeToSolve = maze;
        LinkedList<Point> path = new LinkedList<>();
        Point currentLocation = maze.entrance;

        // Find the paths through the maze.
        findMazePaths(path, currentLocation);

        // Output the number of paths.
        // (Usually a Logger would be used.  For this example, System.out.println will be ok.)
        System.out.println("The number of paths:  " + pathsToExit.size());

        // Get the shortest path through the maze.
        LinkedList<Point> shortestPath = new LinkedList<>();
        if (!pathsToExit.isEmpty()) {
            shortestPath = getShortestPath(pathsToExit);
            outputShortestPathLengthAndCoordinates(shortestPath);
        }

        return shortestPath;
    }


    private void findMazePaths(LinkedList<Point> path, Point currentLocation) {

        // Find all the possible paths through the maze.

        // If the current location isn't already in the path, then continue.
        if (!path.contains(currentLocation)) {

            path.add(currentLocation);

            if (currentLocation.equals(mazeToSolve.exit)) {
                // The exit has been reached.  Add the path to the list of successful paths.
                pathsToExit.add(path);
            } else {
                // If we can go up, down, left or right then do so.  Create a new path for each turn.
                if ((currentLocation.y > 0) &&
                        (mazeToSolve.grid[currentLocation.x][currentLocation.y - 1] == 0)) {
                    // Go up.
                    findMazePaths(createNewPath(path), new Point(currentLocation.x, currentLocation.y - 1));
                }
                if ((currentLocation.y < mazeToSolve.getMazeHeight() - 1) &&
                        (mazeToSolve.grid[currentLocation.x][currentLocation.y + 1] == 0)) {
                    // Go down.
                    findMazePaths(createNewPath(path), new Point(currentLocation.x, currentLocation.y + 1));
                }
                if ((currentLocation.x > 0) &&
                        (mazeToSolve.grid[currentLocation.x - 1][currentLocation.y] == 0)) {
                    // Go left.
                    findMazePaths(createNewPath(path), new Point(currentLocation.x - 1, currentLocation.y));
                }
                if ((currentLocation.x < mazeToSolve.getMazeHWidth() - 1) &&
                        (mazeToSolve.grid[currentLocation.x + 1][currentLocation.y] == 0)) {
                    // Go right.
                    findMazePaths(createNewPath(path), new Point(currentLocation.x + 1, currentLocation.y));
                }
            }
        }
    }

    private LinkedList<Point> createNewPath(LinkedList<Point> path) {
        LinkedList<Point> newPath = new LinkedList<>();
        newPath.addAll(path);
        return newPath;
    }

    private LinkedList<Point> getShortestPath(LinkedList pathsToExit) {
        LinkedList<Point> shortestPath = new LinkedList<>();
        if (!pathsToExit.isEmpty()) {
            shortestPath = (LinkedList<Point>) pathsToExit.get(0);
            for (int i = 1; i < pathsToExit.size(); i++) {
                if (((LinkedList<Point>) pathsToExit.get(i)).size() < shortestPath.size()) {
                    shortestPath = (LinkedList<Point>) pathsToExit.get(i);
                }
            }
        }
        return shortestPath;
    }

    private void outputShortestPathLengthAndCoordinates(LinkedList<Point> shortestPath) {
        System.out.println("The shortest path length is :  " + shortestPath.size());
        System.out.println("The shortest path coordinates:  ");
        for (Point point: shortestPath) {
            System.out.println("x, y: " + point.x + "," + point.y);
        }
    }

}
