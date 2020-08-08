import javalib.funworld.WorldScene;

// interface to represent a game piece
interface IGamePiece {
  /*
   * METHODS for PARAMETERS this.draw(WorldScene) - WorldScene this.move(int, int,
   * int, int) - IGamePiece this.centerX() - int this.centerY() - int
   * this.collides(IGamePiece) - IGamePiece this.collidesHelp(IGamePiece) -
   * IGamePiece this.radius() - int this.sameObject(IGamePiece) - boolean
   * this.sameObjectShip(Ship) - boolean this.sameObjectBullet(Bullet) - boolean
   * this.explode() - boolean this.explodeBullets() - IList<IGamePiece>
   * this.nBullets() - IList<IGamePiece> this.outOfBounds() - boolean
   * this.collidedShip() - boolean this.collidedBullet() - boolean
   */
  // draws the world scene
  WorldScene draw(WorldScene u);

  // moves a game piece
  IGamePiece move();

  // gets the x position of a circle
  int centerX();

  // gets the y position of a circle
  int centerY();

  // checks for collision
  IGamePiece collides(IGamePiece that);

  // checks if this collides with that
  IGamePiece collidesHelp(IGamePiece that);

  // gets the radius of a circle
  int radius();

  // determines if this and that are the same object type
  boolean sameObject(IGamePiece that);

  // returns if this is a Ship
  public boolean sameObjectShip(Ship that);

  // returns if this is a Bullet
  public boolean sameObjectBullet(Bullet that);

  // returns an IList<IGamePiece> of Bullets that explode from this
  IList<IGamePiece> explodeBullet();

  // returns if this is out of bounds
  boolean outOfBounds();

  // returns if this is a Ship with its collided flag == true
  boolean collidedShip();

  // returns if this is a Bullet with its collided flag == true
  boolean collidedBullet();

  // returns Euclidean distance between this and that
  double distance(IGamePiece that);
}