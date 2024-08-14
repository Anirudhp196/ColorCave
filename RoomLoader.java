public class RoomLoader extends AbstractRoomLoader{

    //private Room start, end;

   public RoomLoader(){
        cave = new CaveData();
        //load();
        //deserialize("Sheerios.ser"); //RED, PINK, BLUE, YELLOW, PINK, GREEN, BLUE
		//deserialize("fiends.ser"); //BLUE, PINK, RED, YELLOW, BLUE, PINK, YELLOW
		//deserialize("Flowstones.ser"); //PINK, GREEN, BLUE, RED, YELLOW, BLUE, GREEN, YELLOW, GREEN, RED, PINK, YELLOW
		deserialize("JOSA.ser"); // BLUE, GREEN, PINK, YELLOW, BLUE, YELLOW, GREEN, RED
		//deserialize("RuntimeTerror.ser"); // RED, GREEN, YELLOW, RED
		//deserialize("AbstractColorPencil.ser"); // RED, BLUE, GREEN, YELLOW, RED, BLUE, PINK, RED, PINK, YELLOW, GREEN
       // deserialize("HashBrowns.ser"); // YELLOW, PINK, RED, YELLOW, PINK, YELLOW, GREEN, PINK, GREEN, PINK, GREEN
   }

   /*public RoomLoader(Room start, Room end){
        cave = new CaveData();
        this.start = start;
        this.end = end;
   }*/


    @Override
    public void load() {
        //Room start = new Room("start", "starter");
        Room room1 = new Room("room 1", "room1");
        Room room2 = new Room("room 2", "room2");
        Room room3 = new Room("room 3", "room3");
        Room room4 = new Room("room 4", "room4");
        Room room5 = new Room("room 5", "room5");
        Room room6 = new Room("room 6", "room6");
        Room room7 = new Room("room 7", "room7");
        Room room8 = new Room("room 8", "room8");
        Room room9 = new Room("room 9", "room9");
        Room room10 = new Room("room 10", "room10");
        Room room11 = new Room("room 11", "room11");
        Room room12 = new Room("room 12", "room12");
        Room room13 = new Room("room 13", "room13");
        Room room14 = new Room("room 14", "room14");
        Room room15 = new Room("room 15", "room15");
        Room room16 = new Room("room 16", "room16");
        Room room17 = new Room("room 17", "room17");
        Room room18 = new Room("room 18", "room18");
        Room room19 = new Room("room 19", "room19");
        Room room20 = new Room("room 20", "room20");
        Room room21 = new Room("room 21", "room21");
        Room room22 = new Room("room 22", "room22");
        Room room23 = new Room("room 23", "room23");
        Room room24 = new Room("room 24", "room24");
        Room room25 = new Room("room 25", "room25");
        Room room26 = new Room("room 26", "room26");
        Room room27 = new Room("room 27", "room27");
        Room room28 = new Room("room 28", "room28");
        Room room29 = new Room("room 29", "room29");
        Room room30 = new Room("room 30", "room30");
        //Room end = new Room("end", "ender");
     
        room1.addDoor(Door.RED, room2);
        room1.addDoor(Door.GREEN, room3);
        room2.addDoor(Door.RED, room1);
        room2.addDoor(Door.BLUE, room3);
        room2.addDoor(Door.PINK, room13);
        room3.addDoor(Door.RED, room4);
        room3.addDoor(Door.BLUE, room2);
        room3.addDoor(Door.GREEN, room1);
        room4.addDoor(Door.RED, room3);
        room4.addDoor(Door.BLUE, room5);
        room4.addDoor(Door.YELLOW, room6);
        room5.addDoor(Door.RED, room11);
        room5.addDoor(Door.BLUE, room4);
        room5.addDoor(Door.PINK, room6);
        room6.addDoor(Door.GREEN, room7);
        room6.addDoor(Door.PINK, room5);
        room6.addDoor(Door.YELLOW, room4);
        room7.addDoor(Door.RED, room9);
        room7.addDoor(Door.BLUE, room8);
        room7.addDoor(Door.GREEN, room6);
        room8.addDoor(Door.BLUE, room7);
        room8.addDoor(Door.PINK, room9);
        room8.addDoor(Door.YELLOW, room18);
        room9.addDoor(Door.RED, room7);
        room9.addDoor(Door.PINK, room8);
        room9.addDoor(Door.YELLOW, room10);
        room10.addDoor(Door.BLUE, room14);
        room10.addDoor(Door.PINK, room11);
        room10.addDoor(Door.YELLOW, room9);
        room11.addDoor(Door.RED, room5);
        room11.addDoor(Door.GREEN, room12);
        room11.addDoor(Door.PINK, room10);
        room12.addDoor(Door.RED, room14);
        room12.addDoor(Door.GREEN, room11);
        room12.addDoor(Door.YELLOW, room13);
        room13.addDoor(Door.BLUE, room27);
        room13.addDoor(Door.PINK, room2);
        room13.addDoor(Door.YELLOW, room12);
        room14.addDoor(Door.RED, room12);
        room14.addDoor(Door.BLUE, room10);
        room14.addDoor(Door.GREEN, room15);
        room15.addDoor(Door.RED, room27);
        room15.addDoor(Door.BLUE, room16);
        room15.addDoor(Door.GREEN, room14);
        room16.addDoor(Door.BLUE, room15);
        room16.addDoor(Door.PINK, room17);
        room16.addDoor(Door.YELLOW, room27);
        room17.addDoor(Door.BLUE, room19);
        room17.addDoor(Door.GREEN, room23);
        room17.addDoor(Door.PINK, room16);
        room18.addDoor(Door.GREEN, room26);
        room18.addDoor(Door.PINK, room22);
        room18.addDoor(Door.YELLOW, room8);
        room19.addDoor(Door.RED, room21);
        room19.addDoor(Door.BLUE, room17);
        room19.addDoor(Door.YELLOW, room20);
        room20.addDoor(Door.BLUE, room22);
        room20.addDoor(Door.GREEN, room21);
        room20.addDoor(Door.YELLOW, room19);
        room21.addDoor(Door.RED, room19);
        room21.addDoor(Door.GREEN, room20);
        room21.addDoor(Door.PINK, room23);
        room22.addDoor(Door.RED, room24);
        room22.addDoor(Door.BLUE, room20);
        room22.addDoor(Door.PINK, room18);
        room23.addDoor(Door.BLUE, room30);
        room23.addDoor(Door.GREEN, room17);
        room23.addDoor(Door.PINK, room21);
        room24.addDoor(Door.RED, room22);
        room24.addDoor(Door.BLUE, room25);
        room24.addDoor(Door.GREEN, room28);
        room25.addDoor(Door.RED, room26);
        room25.addDoor(Door.BLUE, room24);
        room25.addDoor(Door.PINK, room29);
        room26.addDoor(Door.RED, room25);
        room26.addDoor(Door.GREEN, room18);
        room27.addDoor(Door.RED, room15);
        room27.addDoor(Door.BLUE, room13);
        room27.addDoor(Door.YELLOW, room16);
        room28.addDoor(Door.GREEN, room24);
        room28.addDoor(Door.YELLOW, room29);
        room29.addDoor(Door.PINK, room25);
        room29.addDoor(Door.YELLOW, room28);
        room30.addDoor(Door.BLUE, room23);
     
        cave.addRoom(room1);
        cave.addRoom(room2);
        cave.addRoom(room3);
        cave.addRoom(room4);
        cave.addRoom(room5);
        cave.addRoom(room6);
        cave.addRoom(room7);
        cave.addRoom(room8);
        cave.addRoom(room9);
        cave.addRoom(room10);
        cave.addRoom(room11);
        cave.addRoom(room12);
        cave.addRoom(room13);
        cave.addRoom(room14);
        cave.addRoom(room15);
        cave.addRoom(room16);
        cave.addRoom(room17);
        cave.addRoom(room18);
        cave.addRoom(room19);
        cave.addRoom(room20);
        cave.addRoom(room21);
        cave.addRoom(room22);
        cave.addRoom(room23);
        cave.addRoom(room24);
        cave.addRoom(room25);
        cave.addRoom(room26);
        cave.addRoom(room27);
        cave.addRoom(room28);
        cave.addRoom(room29);
        cave.addRoom(room30);
     
        cave.setStart(room1);
        cave.setEnd(room30);
        

        
    }
    public static void main(String [] args){
        new RoomLoader(); 
    }
    
}
