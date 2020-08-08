import java.util.Random;

import javalib.funworld.World;
import javalib.funworld.WorldScene;
import javalib.worldimages.TextImage;
import javalib.worldimages.WorldEnd;

// class that represents World state
class GameWorld extends World {

  /*
   * GameWorld Template:
   * 
   * FIELDS: this.rand - Random this.totalCollisions - int this.bulletsLeft - int
   * this.tick - int
   * 
   * METHODS: this.makeScene() - WorldScene this.onTick() - World
   * this.checkBounds() - GameWorld this.spawnShips() - GameWorld
   * this.movePieces() - GameWorld this.checkCollisions() - GameWorld
   * this.countShips() - GameWorld this.explode() - GameWorld this.filterShips() -
   * GameWorld this.onKeyEvent() - GameWorld
   */
  IList<IGamePiece> list;
  Random rand;
  int totalCollisions;
  int bulletsLeft;
  int tick;

  // instance of Utils class
  Utils u = new Utils();

  // The constructor for use in "real" games
  GameWorld(Random rand, IList<IGamePiece> list, int totalCollisions, int bulletsLeft, int tick) {
    this.rand = rand;
    this.list = list;
    this.totalCollisions = totalCollisions;
    this.bulletsLeft = bulletsLeft;
    this.tick = tick;
  }

  // the constructor used for testing
  GameWorld(IList<IGamePiece> list, int totalCollisions, int bulletsLeft, int tick) {
    this(new Random(), list, totalCollisions, bulletsLeft, tick);
  }

  // draws the IList<IGamePiece> on the scene
  public WorldScene makeScene() {
    WorldScene scene = this.getEmptyScene();
    return this.list.fold(new DrawWorld(), scene)
        .placeImageXY(new TextImage(
            "bullets left: " + this.bulletsLeft + "; ships destroyed: " + this.totalCollisions,
            IConstants.TEXT_COLOR), 110, IConstants.SCREEN_HEIGHT - 5);
  }

  @Override
  // returns a new GameWorld after moving, checking bounds, checking collisions,
  // counting collided ships,
  // filtering collided ships, exploding collided bullets, and spawning new
  // ships(only if it is a multiple of 1.0 second)
  // see template above
  public World onTick() {
    if (this.tick % 28 == 0) {
      return this.movePieces().checkBounds().checkCollisions().countShips().filterShips().explode()
          .filterBullets().spawnShips(this.rand);
    }
    else {
      return this.movePieces().checkBounds().checkCollisions().countShips().filterShips().explode()
          .filterBullets();
    }
  }

  @Override
  // returns a new GameWorld depending on if all the Bullets are fired and off the
  // screen or not
  // see template above
  public WorldEnd worldEnds() {
    if (this.bulletsLeft == 0 && this.list.fold(new NoBullets(), true)) {
      return new WorldEnd(true, this.makeScene());
    }
    else {
      return new WorldEnd(false, this.makeScene());
    }
  }

  // returns a new GameWorld with all the IGamePieces that are off the screen
  // removed
  // see template above
  GameWorld checkBounds() {
    return new GameWorld(this.rand, this.list.filter(new CheckBounds()), this.totalCollisions,
        this.bulletsLeft, this.tick);
  }

  // returns a new GameWorld with new Ships spawned
  // see template above
  GameWorld spawnShips(Random rand) {
    return new GameWorld(this.rand, this.list.append(u.spawnShips(this.rand)), this.totalCollisions,
        this.bulletsLeft, this.tick);
  }

  // returns a new GameWorld with all the existing IGamePieces moved by their
  // speed components
  // see template above
  GameWorld movePieces() {
    return new GameWorld(this.rand, this.list.map(new MovePiece()), this.totalCollisions,
        this.bulletsLeft, this.tick + 1);
  }

  // returns a new GameWorld with all the collided IGamePieces with their collided
  // flag == true
  // see template above
  GameWorld checkCollisions() {
    return new GameWorld(this.rand, this.list.map(new Collision(this.list)), this.totalCollisions,
        this.bulletsLeft, this.tick);
  }

  // returns a new GameWorld with a count of all Ships with their collided flag ==
  // true
  // see template above
  GameWorld countShips() {
    return new GameWorld(this.rand, this.list,
        this.totalCollisions + this.list.fold(new CountShips(), 0), this.bulletsLeft, this.tick);
  }

  // returns a new GameWorld with new Bullets spawned from the existing Bullets
  // with their collided flag == true
  // see template above
  GameWorld explode() {
    return new GameWorld(this.rand, this.list.append(u.explodeBullets(this.list)),
        this.totalCollisions, this.bulletsLeft, this.tick);
  }

  // returns a new GameWorld with all Ships with their collided flag == true
  // removed from the
  // IList<IGamePiece>
  // see template above
  GameWorld filterShips() {
    return new GameWorld(this.rand, this.list.filter(new FilterShips()), this.totalCollisions,
        this.bulletsLeft, this.tick);
  }

  // returns a new GameWorld with all Bullets with their collided flag == true
  // removed from the IList<IGamePiece>
  // see template above
  GameWorld filterBullets() {
    return new GameWorld(this.rand, this.list.filter(new FilterBullets()), this.totalCollisions,
        this.bulletsLeft, this.tick);
  }

  @Override
  // returns a new GameWorld with a new Bullet spawned at the bottom center of the
  // screen after the space bar is pressed
  // see template above
  public GameWorld onKeyEvent(String key) {
    if (key.equals(" ") && this.bulletsLeft >= 1) {
      return new GameWorld(this.rand, this.list.append(u.spawnBullet()), this.totalCollisions,
          this.bulletsLeft - 1, this.tick);
    }
    else {
      return this;
    }
  }
}
