import java.awt.Color;

import javalib.funworld.WorldScene;
import javalib.worldimages.CircleImage;
import javalib.worldimages.OutlineMode;

// abstract class for Ships and Bullets
abstract class ACircle implements IGamePiece {
  /*
   * ACircle Template: Fields: this.x - int this.y - int this.radius - int
   * this.speedX - int this.speedY - int this.color - Color this.outOfBounds -
   * boolean this.collided - boolean
   * 
   * METHODS: this.draw(WorldScene) - WorldScene this.move() - IGamePiece
   * this.centerX() -int this.centerY() - int this.collides(IGamePiece) -
   * IGamePiece this.collidesHelp(IGamePiece) - IGamePiece this.radius() - int
   * this.sameObject(IGamePiece) - boolean this.sameObjectShip(IGamePiece) -
   * boolean this.sameObjectBullet(IGamePiece) - boolean this.explodeBullets() -
   * IList<IGamePiece> this.outOfBounds() - boolean this.collidedShip() - boolean
   * this.collidedBullet() - boolean this.distance(IGamePiece) - double
   */

  int x;
  int y;
  int radius;
  int speedX;
  int speedY;
  Color color;
  boolean outOfBounds;
  boolean collided;

  // ACircle constructor
  ACircle(int x, int y, int radius, int speedX, int speedY, Color color, boolean outOfBounds,
      boolean collided) {
    this.x = x;
    this.y = y;
    this.speedX = speedX;
    this.speedY = speedY;
    this.radius = radius;
    this.color = color;
    this.outOfBounds = outOfBounds;
    this.collided = collided;
  }

  // draws a WorldScene with a CircleImage with this ACircle's values placed at
  // this ACircle's (x,y) position
  // see template above
  public WorldScene draw(WorldScene scene) {
    return scene.placeImageXY(new CircleImage(this.radius, OutlineMode.SOLID, this.color), this.x,
        this.y);
  }

  // returns if this has collided with that
  // see template above
  /*
   * METHODS on Parameters: this.draw(WorldScene) - WorldScene this.move() -
   * IGamePiece this.centerX() -int this.centerY() - int this.collides(IGamePiece)
   * - IGamePiece this.collidesHelp(IGamePiece) - IGamePiece this.radius() - int
   * this.sameObject(IGamePiece) - boolean this.sameObjectShip(Ship) -
   * boolean this.sameObjectBullet(Bullet) - boolean this.explodeBullets() -
   * IList<IGamePiece> this.outOfBounds() - boolean this.collidedShip() - boolean
   * this.collidedBullet() - boolean this.distance(IGamePiece) - double
   */
  public IGamePiece collides(IGamePiece that) {
    if (this.sameObject(that)) {
      return this;
    }
    else {
      return this.collidesHelp(that);
    }
  }

  // returns the Euclidean distance between this and that
  // see template above
  /*
   * METHODS on Parameters: this.draw(WorldScene) - WorldScene this.move() -
   * IGamePiece this.centerX() -int this.centerY() - int this.collides(IGamePiece)
   * - IGamePiece this.collidesHelp(IGamePiece) - IGamePiece this.radius() - int
   * this.sameObject(IGamePiece) - boolean this.sameObjectShip(Ship) -
   * boolean this.sameObjectBullet(Bullet) - boolean this.explodeBullets() -
   * IList<IGamePiece> this.outOfBounds() - boolean this.collidedShip() - boolean
   * this.collidedBullet() - boolean this.distance(IGamePiece) - double
   */
  public double distance(IGamePiece that) {
    return Math.sqrt(Math.pow(this.x - that.centerX(), 2) + Math.pow(this.y - that.centerY(), 2));
  }

  // returns this radius
  // see template above
  public int radius() {
    return this.radius;
  }

  // returns this x-coordinate
  // see template above
  public int centerX() {
    return this.x;
  }

  // returns this y-coordinate
  // see template above
  public int centerY() {
    return this.y;
  }

  // returns if this is a Bullet
  // see template above
  /*
   * METHODS on Parameters: this.draw(WorldScene) - WorldScene this.move() -
   * IGamePiece this.centerX() -int this.centerY() - int this.collides(IGamePiece)
   * - IGamePiece this.collidesHelp(IGamePiece) - IGamePiece this.radius() - int
   * this.sameObject(IGamePiece) - boolean this.sameObjectShip(Ship) -
   * boolean this.sameObjectBullet(Bullet) - boolean this.explodeBullets() -
   * IList<IGamePiece> this.outOfBounds() - boolean this.collidedShip() - boolean
   * this.collidedBullet() - boolean this.distance(IGamePiece) - double
   * this.nBullets(double, double, int) - IList<IGamePiece>
   * this.nextRadius() - int
   * 
   * FIELDS of Parameters:
   *  that.x - int that.y - int that.radius - int that.speedX - int
   * that.speedY - int that.color - Color that.outOfBounds - boolean that.collided
   * - boolean that.consecCollisions - int
   */
  public boolean sameObjectBullet(Bullet that) {
    return false;
  }

  // returns if this is a Ship
  // see template above
  /*
   * METHODS: this.draw(WorldScene) - WorldScene this.move() - IGamePiece
   * this.centerX() -int this.centerY() - int this.collides(IGamePiece) -
   * IGamePiece this.collidesHelp(IGamePiece) - IGamePiece this.radius() - int
   * this.sameObject(IGamePiece) - boolean this.sameObjectShip(IGamePiece) -
   * boolean this.sameObjectBullet(IGamePiece) - boolean this.explodeBullets() -
   * IList<IGamePiece> this.outOfBounds() - boolean this.collidedShip() - boolean
   * this.collidedBullet() - boolean this.distance(IGamePiece) - double
   * FIELDS of Parameters:
   *  that.x - int that.y - int that.radius - int that.speedX - int
   * that.speedY - int that.color - Color that.outOfBounds - boolean that.collided
   * - boolean
   */
  public boolean sameObjectShip(Ship that) {
    return false;
  }

  // returns if this is out of the screens bounds
  // see template above
  public boolean outOfBounds() {
    return this.x > 500 || this.x < 0 || this.y > 300 || this.y < 0;
  }

  // returns this collided flag
  // see template above
  public boolean collided() {
    return this.collided;
  }

  // returns false
  // see template above
  public boolean collidedShip() {
    return false;
  }

  // returns false
  // see template above
  public boolean collidedBullet() {
    return false;
  }
}