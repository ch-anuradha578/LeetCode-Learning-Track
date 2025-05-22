package Day18;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that determines if all rooms in a building can be visited, given keys
 * to other rooms inside each room.
 */
public class KeysAndRooms {

    /**
     * Checks if all rooms can be visited starting from room 0.
     *
     * @param rooms A list where each index represents a room, and each value is a
     *              list of keys to other rooms.
     * @return true if all rooms can be visited; false otherwise.
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(0, rooms, visited);  // Start DFS from room 0

        // Check if all rooms are visited
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    /**
     * Depth-First Search (DFS) helper function to visit rooms.
     *
     * @param currentRoom The current room being visited.
     * @param rooms       The list of rooms and their keys.
     * @param visited     Array keeping track of visited rooms.
     */
    private void dfs(int currentRoom, List<List<Integer>> rooms, boolean[] visited) {
        visited[currentRoom] = true;  // Mark the current room as visited

        // Visit each room for which we have a key
        for (int key : rooms.get(currentRoom)) {
            if (!visited[key]) {  // If the room hasn't been visited yet
                dfs(key, rooms, visited);  // Visit the room
            }
        }
    }

    /**
     * Main method to test the canVisitAllRooms function.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        KeysAndRooms solution = new KeysAndRooms();

        // Define the rooms and keys inside each room
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(List.of(1, 3));         // Room 0 has key to room 1,3
        rooms.add(List.of(3, 0, 1));      // Room 1 has key to room 3,0,1
        rooms.add(List.of(2));            // Room 2 has key to room 2
        rooms.add(List.of(0));            // Room 3 has key to room 0

        // Print the input
        System.out.println("Input Rooms and Keys:");
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println("Room " + i + " contains keys: " + rooms.get(i));
        }

        // Call the method and print result
        boolean result = solution.canVisitAllRooms(rooms);
        System.out.println("\nCan visit all rooms: " + result);
    }
}
