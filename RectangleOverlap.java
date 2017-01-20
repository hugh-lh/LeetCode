

import java.util.*;

class RectanglePoint {
	int x; 
	int y;
	public RectanglePoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
class Rectangle {
	RectanglePoint topLeft; 
	RectanglePoint bottomRight;
	public Rectangle(RectanglePoint topLeft, RectanglePoint bottomRight) {
		this.topLeft = topLeft;
		this.bottomRight = bottomRight;
	}
}

public class RectangleOverlap {
	public boolean isOverlap(Rectangle rect1, Rectangle rect2) {
		// write your code in here
		int aleft = Math.min(rect1.topLeft.x, rect1.bottomRight.x);
		int aright = Math.max(rect1.topLeft.x, rect1.bottomRight.x);
		int atop = Math.max(rect1.topLeft.y, rect1.bottomRight.y);
		int abottom = Math.min(rect1.topLeft.y, rect1.bottomRight.y);
		int bleft = Math.min(rect2.topLeft.x, rect2.bottomRight.x);
		int bright = Math.max(rect2.topLeft.x, rect2.bottomRight.x);
		int btop = Math.max(rect2.topLeft.y, rect2.bottomRight.y);
		int bbottom = Math.min(rect2.topLeft.y, rect2.bottomRight.y);
		if (aleft > bright || aright < bleft) return false;
		if (atop < bbottom || abottom > btop) return false;
	
		//if (rect1.bottomRight.x < rect2.topLeft.x || rect1.topLeft.x > rect2.bottomRight.x) return false;
		//if (rect1.bottomRight.y > rect2.topLeft.y || rect1.topLeft.y < rect2.bottomRight.y) return false;
		return true;
	}
	
	public static void main(String[] args) {
		RectangleOverlap r = new RectangleOverlap();
		
		// test case 1 true
		RectanglePoint l1 = new RectanglePoint(1, 5);
		RectanglePoint r1 = new RectanglePoint(5, 2);
		RectanglePoint l2 = new RectanglePoint(4, 3);
		RectanglePoint r2 = new RectanglePoint(8, 1);
		boolean b = r.isOverlap(new Rectangle(l1, r1), new Rectangle(l2, r2));
		System.out.println(b);
		
		// test case 2 true
		l2 = new RectanglePoint(1, 7);
		r2 = new RectanglePoint(4, 4);
		l1 = new RectanglePoint(4, 6);
		r1 = new RectanglePoint(8, 2);
		b = r.isOverlap(new Rectangle(l1, r1), new Rectangle(l2, r2));
		System.out.println(b);
		
		// test case 3 true
		l2 = new RectanglePoint(0, 7);
		r2 = new RectanglePoint(6, 10);
		l1 = new RectanglePoint(0, 7);
		r1 = new RectanglePoint(6, 0);
		b = r.isOverlap(new Rectangle(l1, r1), new Rectangle(l2, r2));
		System.out.println(b);
		
		// test case 4 true
		l2 = new RectanglePoint(0, 6);
		r2 = new RectanglePoint(6, 0);
		l1 = new RectanglePoint(4, 10);
		r1 = new RectanglePoint(10, 4);
		b = r.isOverlap(new Rectangle(l1, r1), new Rectangle(l2, r2));
		System.out.println(b);
		
		// test case 5 false
		l2 = new RectanglePoint(0, 6);
		r2 = new RectanglePoint(3, 3);
		l1 = new RectanglePoint(6, 4);
		r1 = new RectanglePoint(10, 7);
		b = r.isOverlap(new Rectangle(l1, r1), new Rectangle(l2, r2));
		System.out.println(b);
		
		// test case 6 true
		l2 = new RectanglePoint(0, 6);
		r2 = new RectanglePoint(8, 0);
		l1 = new RectanglePoint(2, 2);
		r1 = new RectanglePoint(4, 4);
		b = r.isOverlap(new Rectangle(l1, r1), new Rectangle(l2, r2));
		System.out.println(b);
		
		// test case 7 true
		l2 = new RectanglePoint(0, 6);
		r2 = new RectanglePoint(4, 2);
		l1 = new RectanglePoint(0, 6);
		r1 = new RectanglePoint(6, 0);
		b = r.isOverlap(new Rectangle(l1, r1), new Rectangle(l2, r2));
		System.out.println(b);
		
		// test case 8 false
		l2 = new RectanglePoint(0, 0);
		r2 = new RectanglePoint(4, 4);
		l1 = new RectanglePoint(5, 4);
		r1 = new RectanglePoint(8, 0);
		b = r.isOverlap(new Rectangle(l1, r1), new Rectangle(l2, r2));
		System.out.println(b);

		// test case 9 false
		l2 = new RectanglePoint(0, 5);
		r2 = new RectanglePoint(4, 10);
		l1 = new RectanglePoint(5, 0);
		r1 = new RectanglePoint(8, 6);
		b = r.isOverlap(new Rectangle(l1, r1), new Rectangle(l2, r2));
		System.out.println(b);
		
		// test case 10 true
		l2 = new RectanglePoint(0, 0);
		r2 = new RectanglePoint(5, 5);
		l1 = new RectanglePoint(3, 10);
		r1 = new RectanglePoint(4, -2);
		b = r.isOverlap(new Rectangle(l1, r1), new Rectangle(l2, r2));
		System.out.println(b);			
	}
}
