import tester.Tester;
import java.awt.Color;
import javalib.worldimages.*;
 
class BouncingBall {
  Posn pos;
  Color color;
  int size;
  int dx; // how fast is the ball moving to the right?
  int dy; // how fast is the ball moving downward?
 
  BouncingBall(Posn pos, Color color, int size, int dx, int dy) {
    this.pos=pos;
    this.color=color;
    this.size=size;
    this.dx=dx;
    this.dy=dy;
  }
 
  // Returns a new BouncingBall that's just like this BouncingBall, but moved
  // by this BouncingBall's dx and dy
  BouncingBall move() {
    // TODO: FILL IN YOUR CODE HERE
    int newX = this.pos.x + this.dx;
    int newY = this.pos.y + this.dy;
    return new BouncingBall(new Posn(newX, newY), this.color, this.size, this.dx, this.dy); 
  }
 
  // Returns a new BouncingBall that represents this BouncingBall just after
  // it has bounced off a side wall. Does not actually move the ball.
  // This method will be called automatically when `collidesX` returns true
  BouncingBall bounceX() {
    // TODO: FILL IN YOUR CODE HERE
    return new BouncingBall(this.pos, this.color, this.size, -this.dx, this.dy);
  }
 
  // Like bounceX, except for using the top or bottom walls
  BouncingBall bounceY() {
    // TODO: FILL IN YOUR CODE HERE
    return new BouncingBall(this.pos, this.color, this.size, this.dx, -this.dy);
  }
 
  // Detects whether the ball is colliding with a side wall.
  boolean collidesX(Posn topLeft, Posn botRight) {
    // TODO: FILL IN YOUR CODE HERE
     return this.pos.x - this.size / 2 <= topLeft.x || this.pos.x + this.size / 2 >= botRight.x;
  }
 
  // Detects whether the ball is colliding with a top or bottom wall.
  boolean collidesY(Posn topLeft, Posn botRight) {
    // TODO: FILL IN YOUR CODE HERE
     return this.pos.y - this.size / 2 <= topLeft.y || this.pos.y + this.size / 2 >= botRight.y;
  }
}
 
class ExamplesBouncingBalls {
  int WIDTH = 300;
  int HEIGHT = 300;
 
  // NOTE: We have provided BouncingWorld for you, in the starter code.
  // We'll see how it works in a few lectures
  boolean testBigBang(Tester t) {
    BouncingWorld w = new BouncingWorld(WIDTH, HEIGHT);
    return w.bigBang(WIDTH, HEIGHT, 0.1);
  }
}