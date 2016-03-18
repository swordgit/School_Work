import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Given a MazeRoom and a room name, the search facility of this class will
 * return a path to the desired room, if one exists.
 */
public class MazeSolver
{
	private MazeRoom start;

	public MazeSolver()
	{
		start = MazeRoom.buildMaze();
	}

	/**
	 * Provides access to the maze entrance.
	 * 
	 * @return the entrance to the maze.
	 */
	public MazeRoom getEntrance()
	{
		return start;
	}

	/**
	 * Finds a path from the current room in the maze to the room with the name
	 * provided by goal, if one exists.
	 * 
	 * @param current
	 *            the current room being searched.
	 * @param from
	 *            the room (just searched) through which this room was entered.
	 * @param goal
	 *            the name of the destination room.
	 * @return a path from the current room to the goal (e.g., "A->F->G"), or
	 *         null if no path exists.
	 */
	public String findPath(MazeRoom current, MazeRoom from, String goal)
	{
		// Your code goes here...
		// Hint: When you enter a room (i.e., current) search each connected,
		// non-null room (using goNorth(), goSouth(), goEast(), and goWest()),
		// except the one from which you just came (i.e., from). Stop when the
		// current room's name is the goal.
		if (current.getName().equals(goal))
		{
			return current.getName();
		}
		else
		{

			String path = null;

			List<MazeRoom> room = new ArrayList<MazeRoom>();
			room.add(current.goEast());
			room.add(current.goSouth());
			room.add(current.goWest());
			room.add(current.goNorth());
			
			
				for(MazeRoom r : room)
				{
					if(r != null && r!= from)
					{
						path = findPath(r, current, goal);
					}
					if(path != null)
					break;
				}
			
			return path == null ? null : (current.getName() + "->" + path);

		}
	

	}
	
	/**
	 * Used to test the functionality of this class.
	 */
	public static void main(String[] args)
	{
		PrintStream out = System.out;
		Scanner in = new Scanner(System.in);
		MazeSolver ms = new MazeSolver();
		MazeRoom start = ms.getEntrance();
		out.println("The entrance to the maze is room " + start.getName());
		out.print("Enter the destination room name: ");
		String goal = in.next();
		String path = ms.findPath(start, null, goal);
		out.print("The path from " + start.getName() + " to " + goal + " is ");
		out.println(path == null ? "non existent!" : (path + "."));
	}
}