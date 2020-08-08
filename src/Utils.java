import java.util.Random;

class Utils {

  /*
   * Ship Template: FIELDS:
   * 
   * METHODS: spawnShips(Random rand) - IList<IGamePiece> spawnListShip(int i,
   * Random rand) - IList<IGamePiece> spawnShip(Random rand) - IGamePiece
   * spawnBullet() - IList<IGamePiece> explodeBullets(IList<IGamePiece>) -
   * IList<IGamePiece>
   * 
   * METHODS FOR FIELDS:
   */

  // constructor for Utils
  Utils() {
  }

  // returns an IList<IGamePiece> of 1 to 3 Ships
  // see class template above
  IList<IGamePiece> spawnShips(Random rand) {
    return this.spawnListShip(rand.nextInt(3) + 1, rand);
  }

  // returns a IList<IGamePiece> of Ships
  // see class template above
  IList<IGamePiece> spawnListShip(int i, Random rand) {
    int side = rand.nextInt(2);
    int y = rand.nextInt((5 * IConstants.SCREEN_HEIGHT / 7)) + (IConstants.SCREEN_HEIGHT / 7);
    if (i > 0) {
      return new ConsList<IGamePiece>(this.spawnShip(side, y), this.spawnListShip(i - 1, rand));
    }
    else {
      return new MtList<IGamePiece>();
    }
  }

  // returns a single Ship at a random position
  // see class template above
  IGamePiece spawnShip(int side, int y) {
    if (side == 0) {
      return new Ship(0, y, IConstants.SHIP_SIZE, IConstants.SHIP_SPEED, false, false);
    }
    else {
      return new Ship(IConstants.SCREEN_WIDTH, y, IConstants.SHIP_SIZE, -IConstants.SHIP_SPEED,
          false, false);
    }
  }

  // returns a single Bullet at the position it shoots out
  // see class template above
  IList<IGamePiece> spawnBullet() {
    return new ConsList<IGamePiece>(new Bullet(250, 300, 2, 0, -8, false, false, 1),
        new MtList<IGamePiece>());
  }

  // returns an IList<IGamePiece> with a new number of up to 25 bullets headed in
  // designated directions
  // see class template above
  IList<IGamePiece> explodeBullets(IList<IGamePiece> list) {
    return list.fold(new ExplodeBullets(), new MtList<IGamePiece>());
  }
}
