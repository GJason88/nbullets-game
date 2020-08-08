import java.awt.Color;

// interface to represent the constants in this GameWorld
interface IConstants {
  int SCREEN_HEIGHT = 300;
  int SCREEN_WIDTH = 500;
  int BULLET_SPEED = 8;
  int SHIP_SIZE = SCREEN_HEIGHT / 30;
  int SHIP_SPEED = BULLET_SPEED / 2;
  Color TEXT_COLOR = Color.BLACK;
  Color BULLET_COLOR = Color.PINK;
  Color SHIP_COLOR = Color.CYAN;
}
