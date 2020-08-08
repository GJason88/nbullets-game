

// class to represent a Ship
class Ship extends ACircle {

  /*
   * Ship Template: FIELDS: this.x - int this.y - int this.radius - int
   * this.speedX - int this.speedY - int this.color - Color this.outOfBounds -
   * boolean this.collided - boolean
   * 
   * METHODS: this.draw(WorldScene) - WorldScene this.move() - IGamePiece
   * this.centerX() -int this.centerY() - int this.collides(IGamePiece) -
   * IGamePiece this.collidesHelp(IGamePiece) - IGamePiece this.radius() - int
   * this.sameObject(IGamePiece) - boolean this.sameObjectShip(IGamePiece) -
   * boolean this.sameObjectBullet(IGamePiece) - boolean this.explodeBullet() -
   * IList<IGamePiece> this.outOfBounds() - boolean this.collidedShip() - boolean
   * this.collidedBullet() - boolean this.distance(IGamePiece) - double
   */

  // Ship constructor
  Ship(int x, int y, int radius, int speedX, boolean outOfBounds, boolean collided) {
    // calls the super ACircle constructor
    super(x, y, radius, speedX, 0, IConstants.SHIP_COLOR, outOfBounds, collided);
  }

  // moves this Ship by (speedX,speedY)
  // see template above
  public IGamePiece move() {
    return new Ship(this.x + this.speedX, this.y, this.radius, this.speedX, this.outOfBounds,
        this.collided);
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
      return new Ship(this.x, this.y, this.radius, this.speedX, this.outOfBounds, true);
    }
    else {
      return this;
    }
  }

  // returns an IList<IGamePiece> containing all bullets exploding from this
  // see template above
  public IList<IGamePiece> explodeBullet() {
    return new MtList<IGamePiece>();
  }

  // returns if that is a Ship
  // see template above
  public boolean sameObject(IGamePiece that) {
    return that.sameObjectShip(this);
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
   * 
   * FIELDS of Parameters:
   *  that.x - int that.y - int that.radius - int that.speedX - int
   * that.speedY - int that.color - Color that.outOfBounds - boolean that.collided
   * - boolean that.consecCollisions - int
   */
  public boolean sameObjectShip(Ship that) {
    return true;
  }

  @Override
  // returns if this ship is flagged as collided
  // see template above
  public boolean collidedShip() {
    return this.collided;
  }
}
