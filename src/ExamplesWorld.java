
// imports the tester class to test the file
import tester.*;
// imports Colors for drawing images
import java.awt.Color;
// imports that Random class
import java.util.Random;
// imports the worldImages library
import javalib.worldimages.*;
// imports the funWorld WorldScene class
import javalib.funworld.WorldScene;

class RunGameWorld {

  // default constructor
  RunGameWorld() {
  }

  // example Bullets, Ships, Randoms, GameWorlds, Utils, and IList<IGamePieces>
  IGamePiece bullet1 = new Bullet(100, 200, 2, 8, 0, false, false, 2);
  IGamePiece bullet2 = new Bullet(-100, 200, 2, 8, 0, false, false, 3);
  IGamePiece bullet3 = new Bullet(700, 200, 2, 8, 0, false, false, 2);
  IGamePiece bullet4 = new Bullet(100, -200, 2, 8, 0, false, false, 2);
  IGamePiece bullet5 = new Bullet(100, 500, 2, 8, 0, false, false, 2);
  IGamePiece bullet6 = new Bullet(600, 200, 10, 8, 0, true, false, 2);
  IGamePiece bullet7 = new Bullet(100, 200, 2, 8, 0, false, true, 2);
  Bullet bullet8 = new Bullet(100, 200, 2, 8, 0, false, false, 2);
  Bullet bullet9 = new Bullet(-100, 200, 2, 8, 0, false, false, 2);
  Bullet bullet10 = new Bullet(700, 200, 2, 8, 0, false, false, 2);
  Bullet bullet11 = new Bullet(100, 200, 12, 8, 0, false, false, 2);
  Bullet bullet12 = new Bullet(100, 200, 10, 8, 0, false, true, 2);

  IGamePiece ship1 = new Ship(100, 200, IConstants.SHIP_SIZE, 4, false, false);
  IGamePiece ship2 = new Ship(400, 100, IConstants.SHIP_SIZE, 4, false, false);
  IGamePiece ship3 = new Ship(100, 200, IConstants.SHIP_SIZE, -4, false, false);
  IGamePiece ship4 = new Ship(100, 200, IConstants.SHIP_SIZE, -4, false, true);
  IGamePiece ship6 = new Ship(100, 200, IConstants.SHIP_SIZE, 4, false, false);
  Ship ship5 = new Ship(100, 200, IConstants.SHIP_SIZE, 4, false, false);
  Ship ship7 = new Ship(400, 100, IConstants.SHIP_SIZE, 4, false, false);
  IGamePiece ship8 = new Ship(100, -200, IConstants.SHIP_SIZE, 4, false, false);
  IGamePiece ship9 = new Ship(-100, 200, IConstants.SHIP_SIZE, 4, false, false);
  IGamePiece ship10 = new Ship(700, 200, IConstants.SHIP_SIZE, 4, true, false);
  IGamePiece ship11 = new Ship(100, 500, IConstants.SHIP_SIZE, 4, false, false);
  Random rand = new Random(10);
  GameWorld testWorld = new GameWorld(this.rand, new MtList<IGamePiece>(), 0, 10, 0);
  GameWorld testWorld2 = new GameWorld(this.rand,
      new ConsList<IGamePiece>(this.bullet1, new MtList<IGamePiece>()), 0, 10, 0);
  GameWorld testWorld3 = new GameWorld(this.rand,
      new ConsList<IGamePiece>(this.bullet1, new MtList<IGamePiece>()), 0, 0, 0);
  GameWorld testWorld4 = new GameWorld(this.rand, new MtList<IGamePiece>(), 0, 0, 0);
  GameWorld testWorld5 = new GameWorld(this.rand,
      new ConsList<IGamePiece>(this.bullet1, new ConsList<IGamePiece>(this.ship9,
          new ConsList<IGamePiece>(this.ship10, new MtList<IGamePiece>()))),
      0, 10, 0);
  GameWorld testWorld6 = new GameWorld(this.rand, new ConsList<IGamePiece>(this.bullet1,
      new ConsList<IGamePiece>(this.ship1, new MtList<IGamePiece>())), 0, 10, 0);
  GameWorld testWorld7 = new GameWorld(this.rand,
      new ConsList<IGamePiece>(
          new Ship(0, 100, IConstants.SHIP_SIZE, IConstants.SHIP_SPEED, false, true),
          new MtList<IGamePiece>()),
      0, 10, 0);
  GameWorld testWorld20 = new GameWorld(this.rand, new ConsList<IGamePiece>(this.bullet7,
      new ConsList<IGamePiece>(this.ship4, new MtList<IGamePiece>())), 0, 10, 0);

  GameWorld testWorld21 = new GameWorld(this.rand,
      new ConsList<IGamePiece>(this.bullet6, new ConsList<IGamePiece>(this.ship9,
          new ConsList<IGamePiece>(this.ship10, new MtList<IGamePiece>()))),
      0, 10, 0);
  GameWorld actualWorld = new GameWorld(new Random(), new MtList<IGamePiece>(), 0, 10, 0);
  WorldScene scene = this.testWorld.getEmptyScene();
  Utils utils = new Utils();

  IList<IGamePiece> mtList = new MtList<IGamePiece>();
  IList<IGamePiece> list1 = new ConsList<IGamePiece>(ship1,
      new ConsList<IGamePiece>(bullet12, new MtList<IGamePiece>()));
  IList<IGamePiece> list2 = new ConsList<IGamePiece>(ship1, new MtList<IGamePiece>());
  IList<IGamePiece> list3 = new ConsList<IGamePiece>(ship1,
      new ConsList<IGamePiece>(bullet1, new MtList<IGamePiece>()));
  IList<IGamePiece> list4 = new ConsList<IGamePiece>(this.ship1,
      new ConsList<IGamePiece>(this.bullet12, new MtList<IGamePiece>()));

  // runs the testWorld
  boolean testGo(Tester t) {
    return this.actualWorld.bigBang(500, 300, 1.0 / 28.0);
  }

  // Tests for IGamePiece methods
  // tests the draw() method
  boolean testDraw(Tester t) {
    return t.checkExpect(this.bullet1.draw(this.scene),
        this.scene.placeImageXY(new CircleImage(2, OutlineMode.SOLID, Color.PINK), 100, 200))
        && t.checkExpect(this.ship1.draw(this.scene),
            this.scene.placeImageXY(new CircleImage(10, OutlineMode.SOLID, Color.PINK), 100, 200));
  }

  // tests the Bullet move() method
  boolean testMove(Tester t) {
    return t.checkExpect(this.bullet1.move(), new Bullet(108, 200, 2, 8, 0, false, false, 2))
        && t.checkExpect(this.bullet2.move(), new Bullet(-92, 200, 2, 8, 0, false, false, 3))
        && t.checkExpect(this.ship1.move(),
            new Ship(104, 200, IConstants.SHIP_SIZE, 4, false, false))
        && t.checkExpect(this.ship3.move(),
            new Ship(96, 200, IConstants.SHIP_SIZE, -4, false, false));
  }

  // tests the centerX() method
  boolean testCenterX(Tester t) {
    return t.checkExpect(this.bullet1.centerX(), 100) && t.checkExpect(this.ship1.centerX(), 100);
  }

  // tests the centerY() method
  boolean testCenterY(Tester t) {
    return t.checkExpect(this.bullet1.centerY(), 200) && t.checkExpect(this.ship1.centerY(), 200);
  }

  // tests the collides() method
  boolean testCollides(Tester t) {
    return t.checkExpect(this.bullet1.collides(this.ship1),
        new Bullet(100, 200, 2, 8, 0, false, true, 2))
        && t.checkExpect(this.bullet1.collides(this.ship2), this.bullet1)
        && t.checkExpect(this.bullet1.collides(this.bullet1), this.bullet1)
        && t.checkExpect(this.ship1.collides(this.bullet1),
            new Ship(100, 200, IConstants.SHIP_SIZE, 4, false, true))
        && t.checkExpect(this.ship2.collides(this.bullet1), this.ship2)
        && t.checkExpect(this.ship2.collides(this.ship2), this.ship2);
  }

  // tests the collidesHelp() method
  boolean testCollidesHelp(Tester t) {
    return t.checkExpect(this.bullet1.collidesHelp(this.ship1),
        new Bullet(100, 200, 2, 8, 0, false, true, 2))
        && t.checkExpect(this.bullet1.collidesHelp(this.ship2), this.bullet1)
        && t.checkExpect(this.ship1.collidesHelp(this.bullet2), this.ship1)
        && t.checkExpect(this.ship1.collidesHelp(this.bullet1),
            new Ship(100, 200, IConstants.SHIP_SIZE, 4, false, true));
  }

  // tests the radius() method
  boolean testRadius(Tester t) {
    return t.checkExpect(this.bullet1.radius(), 2) && t.checkExpect(this.bullet6.radius(), 10)
        && t.checkExpect(this.ship1.radius(), 10);
  }

  // tests the sameObject() method
  boolean testSameObject(Tester t) {
    return t.checkExpect(this.bullet1.sameObject(this.bullet2), true)
        && t.checkExpect(this.bullet1.sameObject(this.ship1), false)
        && t.checkExpect(this.ship1.sameObject(this.ship2), true)
        && t.checkExpect(this.ship1.sameObject(this.bullet8), false);
  }

  // tests the sameObjectShip() method
  boolean testSameObjectShip(Tester t) {
    return t.checkExpect(this.bullet1.sameObjectShip(this.ship5), false)
        && t.checkExpect(this.ship1.sameObjectShip(this.ship5), true);
  }

  // tests the sameObjectBullet() method
  boolean testSameObjectBullet(Tester t) {
    return t.checkExpect(this.bullet1.sameObjectBullet(this.bullet9), true)
        && t.checkExpect(this.ship1.sameObject(this.bullet9), false);
  }

  // tests the explodeBullet() method
  boolean testExplodeBullet(Tester t) {
    return t.checkExpect(this.bullet8.explodeBullet(),
        new ConsList<IGamePiece>(new Bullet(100, 200, 4, 8, 0, false, false, 3),
            new ConsList<IGamePiece>(new Bullet(100, 200, 4, -4, -6, false, false, 3),
                new ConsList<IGamePiece>(new Bullet(100, 200, 4, -3, 6, false, false, 3),
                    new MtList<IGamePiece>()))))
        && t.checkExpect(this.ship1.explodeBullet(), new MtList<IGamePiece>());
  }

  // tests the outOfBounds() method
  boolean testOutOfBounds(Tester t) {
    return t.checkExpect(this.bullet1.outOfBounds(), false)
        && t.checkExpect(this.bullet2.outOfBounds(), true)
        && t.checkExpect(this.bullet3.outOfBounds(), true)
        && t.checkExpect(this.bullet4.outOfBounds(), true)
        && t.checkExpect(this.bullet5.outOfBounds(), true)
        && t.checkExpect(this.ship1.outOfBounds(), false)
        && t.checkExpect(this.ship8.outOfBounds(), true)
        && t.checkExpect(this.ship9.outOfBounds(), true)
        && t.checkExpect(this.ship10.outOfBounds(), true)
        && t.checkExpect(this.ship11.outOfBounds(), true);
  }

  // tests the collidedBullet() method
  boolean testCollidedBullet(Tester t) {
    return t.checkExpect(this.bullet1.collidedBullet(), false)
        && t.checkExpect(this.bullet7.collidedBullet(), true)
        && t.checkExpect(this.ship1.collidedBullet(), false);
  }

  // tests the collidedShip() method
  boolean testCollidedShip(Tester t) {
    return t.checkExpect(this.bullet1.collidedShip(), false)
        && t.checkExpect(this.ship2.collidedShip(), false)
        && t.checkExpect(this.ship4.collidedShip(), true);
  }

  // tests the distance() method
  boolean testDistance(Tester t) {
    return Math.abs(this.bullet1.distance(this.ship1) - 0.0) < 0.001
        && Math.abs(this.ship1.distance(this.bullet1) - 0.0) < 0.001
        && Math.abs(this.ship2.distance(this.bullet1) - 0.0) > 0.001
        && Math.abs(this.bullet2.distance(this.ship3) - 0.0) > 0.001;
  }

  // tests the nBullets() method
  boolean testNBullets(Tester t) {
    return t.checkExpect(this.bullet8.nBullets(3.0, 120.0, 3),
        new ConsList<IGamePiece>(new Bullet(100, 200, 4, 8, 0, false, false, 3),
            new ConsList<IGamePiece>(new Bullet(100, 200, 4, -4, -6, false, false, 3),
                new ConsList<IGamePiece>(new Bullet(100, 200, 4, -3, 6, false, false, 3),
                    new MtList<IGamePiece>()))))
        && t.checkExpect(this.bullet9.nBullets(1.0, 120.0, 3),
            new ConsList<IGamePiece>(new Bullet(-100, 200, 4, -3, 6, false, false, 3),
                new MtList<IGamePiece>()))
        && t.checkExpect(this.bullet10.nBullets(3.0, 120.0, 3),
            new ConsList<IGamePiece>(new Bullet(700, 200, 4, 8, 0, false, false, 3),
                new ConsList<IGamePiece>(new Bullet(700, 200, 4, -4, -6, false, false, 3),
                    new ConsList<IGamePiece>(new Bullet(700, 200, 4, -3, 6, false, false, 3),
                        new MtList<IGamePiece>()))));
  }

  // tests the nextRadius() method
  boolean testNextRadius(Tester t) {
    return t.checkExpect(this.bullet8.nextRadius(), 4)
        && t.checkExpect(this.bullet11.nextRadius(), 10)
        && t.checkExpect(this.bullet12.nextRadius(), 10);
  }

  // Tests for GameWorld methods
  // tests the onKeyEvent() method
  boolean testOnKeyEvent(Tester t) {
    return t.checkExpect(this.testWorld.onKeyEvent(" "),
        new GameWorld(new Random(10), new ConsList<IGamePiece>(
            new Bullet(250, 300, 2, 0, -8, false, false, 1), new MtList<IGamePiece>()), 0, 9, 0));
  }

  // tests the makeScene() method
  boolean testMakeScene(Tester t) {
    return t.checkExpect(this.testWorld.makeScene(),
        this.testWorld.getEmptyScene()
            .placeImageXY(new TextImage("bullets left: " + 10 + "; ships destroyed: " + 0,
                IConstants.TEXT_COLOR), 110, IConstants.SCREEN_HEIGHT - 5))
        && t.checkExpect(this.testWorld2.makeScene(),
            this.bullet1.draw(this.testWorld2.getEmptyScene())
                .placeImageXY(new TextImage("bullets left: " + 10 + "; ships destroyed: " + 0,
                    IConstants.TEXT_COLOR), 110, IConstants.SCREEN_HEIGHT - 5));
  }

  // this test fails because it switches the actual depending on what I put as the
  // expected
  // tests the onTick() method
  boolean testOnTick(Tester t) {
    Random rand1 = new Random(10);
    return t.checkExpect(new GameWorld(rand1, new MtList<IGamePiece>(), 0, 10, 0).onTick(),
        new GameWorld(rand1,
            new ConsList<IGamePiece>(new Ship(0,
                rand1.nextInt((5 * IConstants.SCREEN_HEIGHT / 7)) + (IConstants.SCREEN_HEIGHT / 7),
                IConstants.SHIP_SIZE, IConstants.SHIP_SPEED, false, false),
                new MtList<IGamePiece>()),
            0, 10, 1));
  }

  // tests the worldEnds() method
  boolean testWorldEnds(Tester t) {
    return t.checkExpect(this.testWorld.worldEnds(),
        new WorldEnd(false, this.testWorld.makeScene()))
        && t.checkExpect(this.testWorld3.worldEnds(),
            new WorldEnd(false, this.testWorld3.makeScene()))
        && t.checkExpect(this.testWorld4.worldEnds(),
            new WorldEnd(true, this.testWorld4.getEmptyScene()));
  }

  // tests the checkBounds() method
  boolean testCheckBounds(Tester t) {
    return t.checkExpect(this.testWorld.checkBounds(), this.testWorld)
        && t.checkExpect(this.testWorld5.checkBounds(), new GameWorld(this.rand,
            new ConsList<IGamePiece>(this.bullet1, new MtList<IGamePiece>()), 0, 10, 0));
  }

  // tests the spawnShips() method
  // this test fails because it switches the actual depending on what I put as the
  // expected
  boolean testGWSpawnShips(Tester t) {
    Random rand1 = new Random(10);
    Random rand2 = new Random(10);
    return t
        .checkExpect(new GameWorld(rand1, new MtList<IGamePiece>(), 0, 10, 0).spawnShips(rand1),
            new GameWorld(rand2,
                new ConsList<IGamePiece>(
                    new Ship(500, 211, IConstants.SHIP_SIZE, -IConstants.SHIP_SPEED, false, false),
                    new ConsList<IGamePiece>(new Ship(500, 251, IConstants.SHIP_SIZE,
                        -IConstants.SHIP_SPEED, false, false), new MtList<IGamePiece>())),
                0, 10, 0));
  }

  // tests the movePieces() method
  boolean testMovePieces(Tester t) {
    return t.checkExpect(this.testWorld.movePieces(),
        new GameWorld(this.rand, new MtList<IGamePiece>(), 0, 10, 1))
        && t.checkExpect(this.testWorld5.movePieces(), new GameWorld(this.rand,
            new ConsList<IGamePiece>(new Bullet(108, 200, 2, 8, 0, false, false, 2),
                new ConsList<IGamePiece>(new Ship(-96, 200, IConstants.SHIP_SIZE, 4, false, false),
                    new ConsList<IGamePiece>(
                        new Ship(704, 200, IConstants.SHIP_SIZE, 4, true, false),
                        new MtList<IGamePiece>()))),
            0, 10, 1));
  }

  // tests the checkCollisions() method
  boolean testCheckCollisions(Tester t) {
    return t.checkExpect(this.testWorld.checkCollisions(), this.testWorld)
        && t.checkExpect(this.testWorld6.checkCollisions(),
            new GameWorld(this.rand,
                new ConsList<IGamePiece>(new Bullet(100, 200, 2, 8, 0, false, true, 2),
                    new ConsList<IGamePiece>(new Ship(100, 200, 10, 4, false, true),
                        new MtList<IGamePiece>())),
                0, 10, 0));
  }

  // tests the countShips() method
  boolean testCountShips(Tester t) {
    return t.checkExpect(this.testWorld.countShips(), this.testWorld)
        && t.checkExpect(this.testWorld7.countShips(),
            new GameWorld(this.rand,
                new ConsList<IGamePiece>(
                    new Ship(0, 100, IConstants.SHIP_SIZE, IConstants.SHIP_SPEED, false, true),
                    new MtList<IGamePiece>()),
                1, 10, 0));
  }

  // Tests for Utils methods
  // tests the explodeBullets() method
  boolean testexplodeBullets(Tester t) {
    return t.checkExpect(this.utils.explodeBullets(this.list4),
        new ConsList<IGamePiece>(new Bullet(100, 200, 10, 8, 0, false, false, 3),
            new ConsList<IGamePiece>(new Bullet(100, 200, 10, -4, -6, false, false, 3),
                new ConsList<IGamePiece>(new Bullet(100, 200, 10, -3, 6, false, false, 3),
                    new MtList<IGamePiece>()))));
  }

  //tests the explode() method in GameWorld class
  boolean testExplode(Tester t) {
    return t.checkExpect(this.testWorld.explode(), this.testWorld)
        && t.checkExpect(this.testWorld5.explode(), this.testWorld5)
        && t.checkExpect(this.testWorld21.explode(), this.testWorld21)
        && t.checkExpect(this.testWorld20.explode(),
            new GameWorld(this.rand,
                new ConsList<IGamePiece>(this.bullet7, new ConsList<IGamePiece>(this.ship4,
                    new ConsList<IGamePiece>(new Bullet(100, 200, 4, 8, 0, false, false, 3),
                        new ConsList<IGamePiece>(new Bullet(100, 200, 4, -4, -6, false, false, 3),
                            new ConsList<IGamePiece>(
                                new Bullet(100, 200, 4, -3, 6, false, false, 3),
                                new MtList<IGamePiece>()))))),
                0, 10, 0));
  }

  // tests the filterShips() method in the GameWorld class
  boolean testFilterShips(Tester t) {
    return t.checkExpect(this.testWorld.filterShips(),
        new GameWorld(this.rand, new MtList<IGamePiece>(), 0, 10, 0))
        && t.checkExpect(this.testWorld6.filterShips(),
            new GameWorld(this.rand,
                new ConsList<IGamePiece>(this.bullet1,
                    new ConsList<IGamePiece>(this.ship1, new MtList<IGamePiece>())),
                0, 10, 0))
        && t.checkExpect(this.testWorld20.filterShips(), new GameWorld(this.rand,
            new ConsList<IGamePiece>(this.bullet7, new MtList<IGamePiece>()), 0, 10, 0));
  }

  // tests the filterBullets() method in the GameWorld class
  boolean testFilterBullets(Tester t) {
    return t.checkExpect(this.testWorld.filterBullets(),
        new GameWorld(this.rand, new MtList<IGamePiece>(), 0, 10, 0))
        && t.checkExpect(this.testWorld6.filterBullets(),
            new GameWorld(this.rand,
                new ConsList<IGamePiece>(this.bullet1,
                    new ConsList<IGamePiece>(this.ship1, new MtList<IGamePiece>())),
                0, 10, 0))
        && t.checkExpect(this.testWorld20.filterBullets(), new GameWorld(this.rand,
            new ConsList<IGamePiece>(this.ship4, new MtList<IGamePiece>()), 0, 10, 0));
  }

  //tests the spawnShips utility method
  boolean testUSpawnShips(Tester t) {
    return t.checkExpect(this.utils.spawnShips(new Random(3)),
        new ConsList<IGamePiece>(new Ship(500, 224, IConstants.SHIP_SIZE, -4, false, false),
            new ConsList<IGamePiece>(new Ship(500, 112, IConstants.SHIP_SIZE, -4, false, false),
                new ConsList<IGamePiece>(new Ship(500, 143, IConstants.SHIP_SIZE, -4, false, false),
                    new MtList<IGamePiece>()))));
  }

  // tests the spawnListShips utility method
  boolean testSpawnListShips(Tester t) {
    return t.checkExpect(this.utils.spawnListShip(2, new Random(3)),
        new ConsList<IGamePiece>(new Ship(500, 132, IConstants.SHIP_SIZE, -4, false, false),
            new ConsList<IGamePiece>(new Ship(0, 99, IConstants.SHIP_SIZE, 4, false, false),
                new MtList<IGamePiece>())))
        && t.checkExpect(this.utils.spawnListShip(0, new Random(3)), new MtList<IGamePiece>());

  }

  // tests the spawnShip utility method
  boolean testSpawnShip(Tester t) {
    return t.checkExpect(this.utils.spawnShip(1, 132), new Ship(500, 132, 10, -4, false, false));
  }

  // tests the spawnBullet utility method
  boolean testSpawnBullet(Tester t) {
    return t.checkExpect(this.utils.spawnBullet(), new ConsList<IGamePiece>(
        new Bullet(250, 300, 2, 0, -8, false, false, 1), new MtList<IGamePiece>()));
  }

  // Tests for the Function<T,U>, BiFunction<T,U,V>, and Predicate<T> classes
  // tests the test() method in CheckBounds class
  boolean testCBTest(Tester t) {
    return t.checkExpect(new CheckBounds().test(bullet1), true)
        && t.checkExpect(new CheckBounds().test(bullet6), false)
        && t.checkExpect(new CheckBounds().test(ship1), true)
        && t.checkExpect(new CheckBounds().test(ship10), false);
  }

  // tests the apply() method in ExplodeBullets class
  boolean testEBApply(Tester t) {
    return t.checkExpect(new ExplodeBullets().apply(bullet1, list2), list2)
        && t.checkExpect(new ExplodeBullets().apply(bullet7, list3), new ConsList<IGamePiece>(ship1,
            new ConsList<IGamePiece>(new Bullet(100, 200, 2, 8, 0, false, false, 2),
                new ConsList<IGamePiece>(new Bullet(100, 200, 4, 8, 0, false, false, 3),
                    new ConsList<IGamePiece>(new Bullet(100, 200, 4, -4, -6, false, false, 3),
                        new ConsList<IGamePiece>(new Bullet(100, 200, 4, -3, 6, false, false, 3),
                            new MtList<IGamePiece>()))))))
        && t.checkExpect(new ExplodeBullets().apply(ship1, list3), list3)
        && t.checkExpect(new ExplodeBullets().apply(ship10, list3), list3);
  }

  // tests the test() method in FilterBullets class
  boolean testFBTest(Tester t) {
    return t.checkExpect(new FilterBullets().test(this.ship1), true)
        && t.checkExpect(new FilterBullets().test(this.ship4), true)
        && t.checkExpect(new FilterBullets().test(this.bullet1), true)
        && t.checkExpect(new FilterBullets().test(this.bullet7), false);

  }

  // tests the test() method in FilterShips class
  boolean testFSTest(Tester t) {
    return t.checkExpect(new FilterShips().test(this.ship1), true)
        && t.checkExpect(new FilterShips().test(this.ship4), false)
        && t.checkExpect(new FilterShips().test(this.bullet1), true)
        && t.checkExpect(new FilterShips().test(this.bullet7), true);

  }

  // tests the apply() method in CountShips class
  boolean testCSApply(Tester t) {
    return t.checkExpect(new CountShips().apply(this.ship1, 0), 0)
        && t.checkExpect(new CountShips().apply(this.ship4, 0), 1)
        && t.checkExpect(new CountShips().apply(this.bullet1, 0), 0)
        && t.checkExpect(new CountShips().apply(this.bullet7, 0), 0);

  }

  // tests the test() method in OutOfBounds class
  boolean testOOBTest(Tester t) {
    return t.checkExpect(new OutOfBounds().test(this.ship1), false)
        && t.checkExpect(new OutOfBounds().test(this.ship10), true)
        && t.checkExpect(new OutOfBounds().test(this.bullet1), false)
        && t.checkExpect(new OutOfBounds().test(this.bullet6), true);
  }

  // tests the apply() method in Collision class
  boolean testCollisionApply(Tester t) {
    return t.checkExpect(new Collision(list3).apply(this.bullet2), this.bullet2)
        && t.checkExpect(new Collision(list3).apply(this.ship2), this.ship2)
        && t.checkExpect(new Collision(list4).apply(this.bullet7), this.bullet7)
        && t.checkExpect(new Collision(list4).apply(this.ship10), this.ship10)
        && t.checkExpect(new Collision(list3).apply(this.bullet1),
            new Bullet(100, 200, 2, 8, 0, false, true, 2))
        && t.checkExpect(new Collision(list3).apply(this.ship1),
            new Ship(100, 200, IConstants.SHIP_SIZE, 4, false, true));
  }

  // tests the apply() method in Collides class
  boolean testCollidesApply(Tester t) {
    return t.checkExpect(new Collides().apply(this.bullet1, this.ship1),
        new Ship(100, 200, IConstants.SHIP_SIZE, 4, false, true))
        && t.checkExpect(new Collides().apply(this.ship1, this.bullet1),
            new Bullet(100, 200, 2, 8, 0, false, true, 2))
        && t.checkExpect(new Collides().apply(this.ship1, this.bullet5), this.bullet5)
        && t.checkExpect(new Collides().apply(this.bullet5, this.ship1), this.ship1);
  }

  // tests the apply() method in the MovePiece class
  boolean testMPApply(Tester t) {
    return t.checkExpect(new MovePiece().apply(ship1),
        new Ship(104, 200, IConstants.SHIP_SIZE, 4, false, false))
        && t.checkExpect(new MovePiece().apply(bullet1),
            new Bullet(108, 200, 2, 8, 0, false, false, 2));
  }

  // tests the apply() method in the DrawWorld class
  boolean testDWApply(Tester t) {
    return t.checkExpect(new DrawWorld().apply(ship1, scene),
        scene.placeImageXY(new CircleImage(IConstants.SHIP_SIZE, OutlineMode.SOLID, Color.CYAN),
            100, 200))
        && t.checkExpect(new DrawWorld().apply(bullet1, scene),
            scene.placeImageXY(new CircleImage(2, OutlineMode.SOLID, Color.PINK), 100, 200));
  }

}
