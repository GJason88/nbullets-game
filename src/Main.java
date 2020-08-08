import java.util.Random;

public class Main {

  public static void main(String[] args) {
    GameWorld world;
    if (args.length > 0) {
      world = new GameWorld(new Random(), new MtList<IGamePiece>(), 0, Integer.valueOf(args[0]), 0);

    } else {
      world = new GameWorld(new Random(), new MtList<IGamePiece>(), 0, 10, 0);

    }
    world.bigBang(500, 300, 1/28.0);
    
  }

}
