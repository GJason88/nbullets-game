
// class to represent a Bullet
class Bullet extends ACircle {

  /*
   * Bullet Template:
   * 
   * FIELDS: this.x - int this.y - int this.radius - int this.speedX - int
   * this.speedY - int this.color - Color this.outOfBounds - boolean this.collided
   * - boolean this.consecCollisions - int
   * 
   * METHODS: this.draw(WorldScene) - WorldScene this.move() - IGamePiece
   * this.centerX() -int this.centerY() - int this.collides(IGamePiece) -
   * IGamePiece this.collidesHelp(IGamePiece) - IGamePiece this.radius() - int
   * this.sameObject(IGamePiece) - boolean this.sameObjectShip(IGamePiece) -
   * boolean this.sameObjectBullet(IGamePiece) - boolean this.explodeBullet() -
   * IList<IGamePiece> this.outOfBounds() - boolean this.collidedShip() - boolean
   * this.collidedBullet() - boolean this.distance(IGamePiece) - double
   * this.nBullets(double ,double, int) - IList<IGamePiece> this.nextRadius() -
   * int
   */

  int consecCollisions;

  // constructor for Bullet
  Bullet(int x, int y, int radius, int speedX, int speedY, boolean outOfBounds, boolean collided,
      int consecCollisions) {
    // calls the super ACircle constructor
    super(x, y, radius, speedX, speedY, IConstants.BULLET_COLOR, outOfBounds, collided);
    this.consecCollisions = consecCollisions;
  }

  // moves this Bullet by (speedX,speedY)
  // see template above
  public IGamePiece move() {
    return new Bullet(this.x + this.speedX, this.y + this.speedY, this.radius, this.speedX,
        this.speedY, this.outOfBounds, this.collided, this.consecCollisions);
  }

  // returns whether this bullet collides with that IGamePiece
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
  public IGamePiece collidesHelp(IGamePiece that) {
    if (this.distance(that) <= (this.radius + that.radius())) {
      return new Bullet(this.x, this.y, this.radius, this.speedX, this.speedY, this.outOfBounds,
          true, this.consecCollisions);
    }
    else {
      return this;
    }
  }

  // returns if that is a Bullet
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
  public boolean sameObject(IGamePiece that) {
    return that.sameObjectBullet(this);
  }

  @Override
  // returns true
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
    return true;
  }

  @Override
  // returns if this is collided
  // see template above
  public boolean collidedBullet() {
    return this.collided;
  }

  // explodes this Bullet into (consecutive collisions + 1) new bullets
  // see template above
  public IList<IGamePiece> explodeBullet() {
    if (this.consecCollisions >= 25) {
      return this.nBullets(25, 360.0 / 25, 25);
    }
    else {
      return this.nBullets(this.consecCollisions + 1.0, 360.0 / (this.consecCollisions + 1),
          this.consecCollisions + 1);
    }
  }

  // creates a list of n + 1 new bullets
  // see template above
  public IList<IGamePiece> nBullets(double n, double angle, int newConsec) {
    if (n > 0) {
      return new ConsList<IGamePiece>(new Bullet(this.x, this.y, this.nextRadius(),
          ((int) (IConstants.BULLET_SPEED * Math.cos(Math.toRadians(n * angle)))),
          ((int) (IConstants.BULLET_SPEED * Math.sin(Math.toRadians(n * angle)))), false, false,
          newConsec), this.nBullets(n - 1, angle, newConsec));
    }
    else {
      return new MtList<IGamePiece>();
    }
  }

  // returns the radius for this bullet's explosion bullets
  // see template above
  int nextRadius() {
    if (this.radius >= 10) {
      return 10;
    }
    else {
      return this.radius + 2;
    }
  }

}