
// imports the funWorld WorldScene class
import javalib.funworld.WorldScene;
// imports BiFunction functional interface
import java.util.function.BiFunction;
// imports Function functional interface
import java.util.function.Function;
// imports Predicate functional interface
import java.util.function.Predicate;

// Predicate<T> class used to check the IGamePiece is in bounds
class CheckBounds implements Predicate<IGamePiece> {

  /* CheckBounds Template:
   * 
   * Method:
   * this.test(IGamePiece) - boolean
   * 
   */

  // default constructor
  CheckBounds() {
  }

  /*
   * METHODS on Parameters: t.draw(WorldScene) - WorldScene t.move() -
   * IGamePiece t.centerX() -int t.centerY() - int t.collides(IGamePiece)
   * - IGamePiece t.collidesHelp(IGamePiece) - IGamePiece t.radius() - int
   * t.sameObject(IGamePiece) - boolean t.sameObjectShip(Ship) -
   * boolean t.sameObjectBullet(Bullet) - boolean t.explodeBullets() -
   * IList<IGamePiece> t.outOfBounds() - boolean t.collidedShip() - boolean
   * t.collidedBullet() - boolean t.distance(IGamePiece) - double
   */
  // returns the opposite of t's outOfBounds flag
  // see template above
  public boolean test(IGamePiece t) {
    return !t.outOfBounds();
  }

}

// BiFunction<T,U,V> class that returns if the IGamePiece is a boolean
class NoBullets implements BiFunction<IGamePiece, Boolean, Boolean> {

  /* NoBullets Template:
   * 
   * Method:
   * this.apply(IGamePiece, Boolean) - Boolean
   * 
   */

  // default constructor
  NoBullets() {
  }

  /*
   * METHODS on Parameters: t.draw(WorldScene) - WorldScene t.move() -
   * IGamePiece t.centerX() -int t.centerY() - int t.collides(IGamePiece)
   * - IGamePiece t.collidesHelp(IGamePiece) - IGamePiece t.radius() - int
   * t.sameObject(IGamePiece) - boolean t.sameObjectShip(Ship) -
   * boolean t.sameObjectBullet(Bullet) - boolean t.explodeBullets() -
   * IList<IGamePiece> t.outOfBounds() - boolean t.collidedShip() - boolean
   * t.collidedBullet() - boolean t.distance(IGamePiece) - double
   */
  // returns whether t is the same object as the supplied Ship
  // see template above
  public Boolean apply(IGamePiece t, Boolean u) {
    return t.sameObject(
        new Ship(100, 200, IConstants.SHIP_SIZE, IConstants.SHIP_SPEED, false, false)) && u;
  }

}

//BiFunction<T,U,V> class that returns if the an IList<IGamePiece> with all the Bullets from
// the IGamePiece exploding
class ExplodeBullets implements BiFunction<IGamePiece, IList<IGamePiece>, IList<IGamePiece>> {
  /* ExplodeBullets Template:
   * 
   * Method:
   * this.apply(IGamePiece, IList<IGamePiece>) - IList<IGamePiece>
   * 
   */

  // default constructor
  ExplodeBullets() {
  }

  /*
   * METHODS on Parameters: t.draw(WorldScene) - WorldScene t.move() -
   * IGamePiece t.centerX() -int t.centerY() - int t.collides(IGamePiece)
   * - IGamePiece t.collidesHelp(IGamePiece) - IGamePiece t.radius() - int
   * t.sameObject(IGamePiece) - boolean t.sameObjectShip(Ship) -
   * boolean t.sameObjectBullet(Bullet) - boolean t.explodeBullets() -
   * IList<IGamePiece> t.outOfBounds() - boolean t.collidedShip() - boolean
   * t.collidedBullet() - boolean t.distance(IGamePiece) - double
   * 
   * list.fold(BiFunction<T, U, U> converter, U initial) - U
   * list.map(Function<T, U> converter) - U
   * list.append(IList<T>) - IList<T>
   * list.filter(Predicate<T>) - IList<T>
   */
  // returns an updated IList<IGamePiece> of t exploding
  // see template above
  public IList<IGamePiece> apply(IGamePiece t, IList<IGamePiece> list) {
    if (t.collidedBullet()) {
      return list.append(t.explodeBullet());
    }
    else {
      return list;
    }
  }

}

// Predicate class that returns not if the IGamePiece is a Bullet
class FilterBullets implements Predicate<IGamePiece> {
  /* FilterBullets Template:
   * 
   * Method:
   * this.test(IGamePiece) - boolean
   * 
   */

  // default constructor
  FilterBullets() {
  }

  /*
   * METHODS on Parameters: t.draw(WorldScene) - WorldScene t.move() -
   * IGamePiece t.centerX() -int t.centerY() - int t.collides(IGamePiece)
   * - IGamePiece t.collidesHelp(IGamePiece) - IGamePiece t.radius() - int
   * t.sameObject(IGamePiece) - boolean t.sameObjectShip(Ship) -
   * boolean t.sameObjectBullet(Bullet) - boolean t.explodeBullets() -
   * IList<IGamePiece> t.outOfBounds() - boolean t.collidedShip() - boolean
   * t.collidedBullet() - boolean t.distance(IGamePiece) - double
   */
  // see template above

  public boolean test(IGamePiece t) {
    return !t.collidedBullet();
  }

}

//Predicate class that returns not if the IGamePiece is a Bullet
class FilterShips implements Predicate<IGamePiece> {
  /* FilterShips Template:
   * 
   * Method:
   * this.test(IGamePiece) - boolean
   */

  // default constructor
  FilterShips() {
  }

  /*
   * METHODS on Parameters: t.draw(WorldScene) - WorldScene t.move() -
   * IGamePiece t.centerX() -int t.centerY() - int t.collides(IGamePiece)
   * - IGamePiece t.collidesHelp(IGamePiece) - IGamePiece t.radius() - int
   * t.sameObject(IGamePiece) - boolean t.sameObjectShip(Ship) -
   * boolean t.sameObjectBullet(Bullet) - boolean t.explodeBullets() -
   * IList<IGamePiece> t.outOfBounds() - boolean t.collidedShip() - boolean
   * t.collidedBullet() - boolean t.distance(IGamePiece) - double
   */
  // see template above
  public boolean test(IGamePiece t) {
    return !t.collidedShip();
  }

}

//BiFunction class that returns a total of all Ships with their collided flag == true
class CountShips implements BiFunction<IGamePiece, Integer, Integer> {
  /* CountShips Template:
   * 
   * Method:
   * this.apply(IGamePiece, Integer) - Integer
   * 
   */

  // default constructor
  CountShips() {
  }

  /*
   * METHODS on Parameters: t.draw(WorldScene) - WorldScene t.move() -
   * IGamePiece t.centerX() -int t.centerY() - int t.collides(IGamePiece)
   * - IGamePiece t.collidesHelp(IGamePiece) - IGamePiece t.radius() - int
   * t.sameObject(IGamePiece) - boolean t.sameObjectShip(Ship) -
   * boolean t.sameObjectBullet(Bullet) - boolean t.explodeBullets() -
   * IList<IGamePiece> t.outOfBounds() - boolean t.collidedShip() - boolean
   * t.collidedBullet() - boolean t.distance(IGamePiece) - double
   */
  // see template above
  public Integer apply(IGamePiece t, Integer u) {
    if (t.collidedShip()) {
      return u = 1 + u;
    }
    else {
      return u;
    }
  }
}

// Predicate<T> class that returns if the IGamePiece is ! out of bounds
class OutOfBounds implements Predicate<IGamePiece> {
  /* OutOfBounds Template:
   * 
   * Method:
   * this.test(IGamePiece) - Boolean
   * 
   */

  // default constructor
  OutOfBounds() {
  }

  /*
   * METHODS on Parameters: t.draw(WorldScene) - WorldScene t.move() -
   * IGamePiece t.centerX() -int t.centerY() - int t.collides(IGamePiece)
   * - IGamePiece t.collidesHelp(IGamePiece) - IGamePiece t.radius() - int
   * t.sameObject(IGamePiece) - boolean t.sameObjectShip(Ship) -
   * boolean t.sameObjectBullet(Bullet) - boolean t.explodeBullets() -
   * IList<IGamePiece> t.outOfBounds() - boolean t.collidedShip() - boolean
   * t.collidedBullet() - boolean t.distance(IGamePiece) - double
   */
  // see template above
  public boolean test(IGamePiece t) {
    return t.outOfBounds();
  }

}

// Function<T,T> class that returns if IGamePiece1 collides with IGamePiece2
class Collision implements Function<IGamePiece, IGamePiece> {
  /*Collision Template:
   * 
   * Method:
   * this.apply(IGamePiece) - IGamePiece
   * 
   */
  IList<IGamePiece> list;

  // constructor that takes in the IList<IGamePiece> of the GameWorld
  Collision(IList<IGamePiece> list) {
    this.list = list;
  }

  /*
   * METHODS on Parameters: that.draw(WorldScene) - WorldScene that.move() -
   * IGamePiece that.centerX() -int that.centerY() - int that.collides(IGamePiece)
   * - IGamePiece that.collidesHelp(IGamePiece) - IGamePiece that.radius() - int
   * that.sameObject(IGamePiece) - boolean that.sameObjectShip(Ship) -
   * boolean that.sameObjectBullet(Bullet) - boolean that.explodeBullets() -
   * IList<IGamePiece> that.outOfBounds() - boolean that.collidedShip() - boolean
   * that.collidedBullet() - boolean that.distance(IGamePiece) - double
   */
  // see template above
  public IGamePiece apply(IGamePiece that) {
    return this.list.fold(new Collides(), that);
  }
}

// BiFunction class that returns an IGamePiece with an updated collided flag
class Collides implements BiFunction<IGamePiece, IGamePiece, IGamePiece> {

  /* Collides Template:
   * 
   * Method:
   * this.apply(IGamePiece, IGamePiece) - IGamePiece
   * 
   */

  // default constructor
  Collides() {
  }

  /*
   * METHODS on Parameters: t.draw(WorldScene) - WorldScene t.move() -
   * IGamePiece t.centerX() -int t.centerY() - int t.collides(IGamePiece)
   * - IGamePiece t.collidesHelp(IGamePiece) - IGamePiece t.radius() - int
   * t.sameObject(IGamePiece) - boolean t.sameObjectShip(Ship) -
   * boolean t.sameObjectBullet(Bullet) - boolean t.explodeBullets() -
   * IList<IGamePiece> t.outOfBounds() - boolean t.collidedShip() - boolean
   * t.collidedBullet() - boolean t.distance(IGamePiece) - double
   *
   * that.draw(WorldScene) - WorldScene that.move() -
   * IGamePiece that.centerX() -int that.centerY() - int that.collides(IGamePiece)
   * - IGamePiece that.collidesHelp(IGamePiece) - IGamePiece that.radius() - int
   * that.sameObject(IGamePiece) - boolean that.sameObjectShip(Ship) -
   * boolean that.sameObjectBullet(Bullet) - boolean that.explodeBullets() -
   * IList<IGamePiece> that.outOfBounds() - boolean that.collidedShip() - boolean
   * that.collidedBullet() - boolean that.distance(IGamePiece) - double
   */
  // see template above
  public IGamePiece apply(IGamePiece t, IGamePiece that) {
    return that.collides(t);
  }

}

// Function<T,T> class that returns an updated IGamePiece with a changed position
class MovePiece implements Function<IGamePiece, IGamePiece> {

  /* MovePiece Template:
   * 
   * Method:
   * this.apply(IGamePiece) - IGamePiece
   * 
   */

  // default constructor
  MovePiece() {
  }

  /*
   * METHODS on Parameters: t.draw(WorldScene) - WorldScene t.move() -
   * IGamePiece t.centerX() -int t.centerY() - int t.collides(IGamePiece)
   * - IGamePiece t.collidesHelp(IGamePiece) - IGamePiece t.radius() - int
   * t.sameObject(IGamePiece) - boolean t.sameObjectShip(Ship) -
   * boolean t.sameObjectBullet(Bullet) - boolean t.explodeBullets() -
   * IList<IGamePiece> t.outOfBounds() - boolean t.collidedShip() - boolean
   * t.collidedBullet() - boolean t.distance(IGamePiece) - double
   */
  // see template above
  public IGamePiece apply(IGamePiece t) {
    return t.move();
  }
}

// BiFunction<T,U,V> class that returns a WorldScene with the IGamePiece drawn
class DrawWorld implements BiFunction<IGamePiece, WorldScene, WorldScene> {

  /* DrawWorld Template:
   * 
   * Method:
   * this.apply(IGamePiece, WorldScene) - WorldScene
   * 
   */

  // default constructor
  DrawWorld() {
  }

  /*
   * METHODS on Parameters: t.draw(WorldScene) - WorldScene t.move() -
   * IGamePiece t.centerX() -int t.centerY() - int t.collides(IGamePiece)
   * - IGamePiece t.collidesHelp(IGamePiece) - IGamePiece t.radius() - int
   * t.sameObject(IGamePiece) - boolean t.sameObjectShip(Ship) -
   * boolean t.sameObjectBullet(Bullet) - boolean t.explodeBullets() -
   * IList<IGamePiece> t.outOfBounds() - boolean t.collidedShip() - boolean
   * t.collidedBullet() - boolean t.distance(IGamePiece) - double
   */
  // see template above
  public WorldScene apply(IGamePiece t, WorldScene u) {
    return t.draw(u);
  }
}