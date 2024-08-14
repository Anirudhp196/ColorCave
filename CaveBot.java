import java.util.*;

public class CaveBot {

	//Breadth-first search
    private Room currRoom;
	private AbstractRoomLoader loader;
	private Queue<Room> order = new LinkedList<Room>();
	private Set<Room> visitedRooms = new HashSet<Room>();
	private Map<Room, Room> roomOrderUp = new HashMap<>();
	private Map<String, Door> routes = new HashMap<>();

	public void load(){
		loader = new RoomLoader();
		//loader.load();
		//loader.deserialize("Sheerios.ser");
		//loader.deserialize("fiends.ser");
		//loader.deserialize("Flowstones.ser");
		//loader.deserialize("JOSA.ser");
		//loader.deserialize("RuntimeTerror.ser");
		//loader.deserialize("AbstractColorPencil.ser");
		//loader.deserialize("HashBrowns.ser");
		currRoom = loader.getStart();
	}

	public void run(){
		order.add(currRoom);
		visitedRooms.add(currRoom);
		while(!order.isEmpty()){
			currRoom = goTo(order.poll());
			if(currRoom.equals(loader.getEnd())){
				numOfMoves(loader.getEnd());
				shortestPath(loader.getEnd());
				break;
			}
			ArrayList<Room> adjacentRooms = getAdjacentRooms(currRoom);
			for(Room r: adjacentRooms){
				if(!(visitedRooms.contains(r))){
					roomOrderUp.put(r, currRoom);
					order.add(r);
					visitedRooms.add(r);
				}
			}
			//System.out.println("Room Order Up: " + roomOrderUp); //System.out.println("Visited Rooms: " + visitedRooms);
			//System.out.println("Current Queue: " + order + "\n"); //System.out.println(currRoom.getNumMoves() + "\n");
		}
	}

	public void numOfMoves(Room finalRoom){
		System.out.println("PFS: " + finalRoom.getNumMoves());
	}

	public Room goToStartNode(){
		while(!currRoom.equals(loader.getStart())){ //going up
			Room rightBefore = roomOrderUp.get(currRoom); //currRoom is the adjacentRoom(start)
			currRoom = currRoom.enter(findDoor(currRoom, rightBefore));
		}

		return loader.getStart();
	}

	public Room goTo(Room destination){
		//System.out.println("Entered goTo"); //System.out.println("Destination: " + destination);
		//System.out.println("Current Room: " + currRoom);

		//room order - map {adjacent, curr}
		currRoom = goToStartNode();
		ArrayList<Door> destinationToStart = new ArrayList<Door>();
		ArrayList<Door> startToDestination = new ArrayList<Door>();
		currRoom = destination;
		while(!currRoom.equals(loader.getStart())){
			Room rightBefore = roomOrderUp.get(currRoom);
			Door connectDoor = findDoor(currRoom, rightBefore);
			destinationToStart.add(connectDoor);
			currRoom = currRoom.enter(connectDoor);
		}
		for(int i = destinationToStart.size() - 1; i >= 0; i--){
			startToDestination.add(destinationToStart.get(i));
		}
		for(int i = 0; i < startToDestination.size(); i++){
			currRoom = currRoom.enter(startToDestination.get(i));
		}
		destinationToStart.clear();
		startToDestination.clear();
		return destination;
	}

	public ArrayList<Room> getAdjacentRooms(Room currRoom){
		ArrayList<Room> adjacentRooms = new ArrayList<Room>();
		for(Door d: currRoom.getDoors()){
			Room adjacentRoom = currRoom.enter(d);
			adjacentRoom.enter(d);
			String key = adjacentRoom.getID() + "-" + currRoom.getID();
			routes.put(key, d);
			adjacentRooms.add(adjacentRoom);
		}
		//System.out.println("Made Paths: " + routes);
		return adjacentRooms;
	}

	public Door findDoor(Room adjacent, Room curr){
		for(String str: routes.keySet()){
			String[] rooms = str.split("-");
			if((rooms[0].equals(String.valueOf(adjacent.getID())) && rooms[1].equals(String.valueOf(curr.getID()))) || 
			(rooms[0].equals(String.valueOf(curr.getID())) && rooms[1].equals(String.valueOf(adjacent.getID())))){
				//System.out.println("Found Route: " + routes.get(str));
				return routes.get(str);
			}
		}
		System.out.println("Didn't find route");
		return null;
	}

	public void shortestPath(Room end){
		ArrayList<Room> roomPath = new ArrayList<Room>();
		ArrayList<Door> doorPath = new ArrayList<Door>();
		currRoom = end;
		while(currRoom != null){
			roomPath.add(currRoom);
			currRoom = roomOrderUp.get(currRoom);
		}
		for(int i = 0; i < roomPath.size() - 1; i++){
			String route = roomPath.get(i).getID() + "-" + roomPath.get(i+1).getID();
			if(routes.containsKey(route)){
				doorPath.add(routes.get(route));
			}
		}
		String finalPath = "";
		for(int i = doorPath.size() - 1; i >= 0; i--){
			finalPath += doorPath.get(i) + ", ";
		}
		finalPath = finalPath.substring(0, finalPath.length()-2);
		System.out.println("Final Path: " + finalPath);
		System.out.println("Shortest Path Found(Size): " + doorPath.size());
	}
	public static void main(String[]args){
		CaveBot bot = new CaveBot();
		bot.load();
		bot.run();
	}
}
