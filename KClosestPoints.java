

import java.util.*;

class Point {
	double x;
	double y;
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}

public class KClosestPoints {
	public static Point[] getKNearestPoints(Point[] points, int k) {
		// write your code here
		if (points == null || points.length == 0) return points;
		if (k < 0) return null;
		Point o = new Point(0, 0);
		PriorityQueue<Point> sort = new PriorityQueue<Point>(new Comparator<Point>() {
					public int compare(Point a, Point b){
						return Double.compare(distance(b, o), distance(a, o));
					}
		});
		for (Point p : points) {
			sort.offer(p);
			if (sort.size() > k) sort.poll();
		}
		Point[] res;
		if (points.length <= k) {
			int len = points.length;
			res = new Point[len];
			while (!sort.isEmpty()) res[--len] = sort.poll();
		}
		else {		
			res = new Point[k];
			while (!sort.isEmpty()) res[--k] = sort.poll();
		}
		return res;
	}
	
	private static double distance(Point a, Point b) {
		return (a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y);
	}
	
	public static void main(String[] args) {
		KClosestPoints s = new KClosestPoints();
		
		// Test case 1
		Point[] test1 = new Point[5];
		test1[0] = new Point(0, 1);
		test1[1] = new Point(7, 8);
		test1[2] = new Point(2, 6);
		test1[3] = new Point(3, 7);
		test1[4] = new Point(-2, 8);
		Point[] results = s.getKNearestPoints(test1, 3);
		if(results[0] == test1[0] && results[1] == test1[2] && results[2] == test1[3]) {
			System.out.println("test case 1 correct!");
		} else {
			System.out.println("test case 1 wrong!");
			System.out.println(results[0].x + " " + results[0].y);
			System.out.println(results[1].x + " " + results[1].y);
			System.out.println(results[2].x + " " + results[2].y);
		}
		// s.print(results);
		
		// Test case 2
		Point[] test2 = new Point[4];
		test2[0] = new Point(0, 4);
		test2[1] = new Point(4, 0);
		test2[2] = new Point(0, -4);
		test2[3] = new Point(-4, 0);
		results = s.getKNearestPoints(test2, 3);
		if(results[0] == test2[1] && results[1] == test2[2] && results[2] == test2[3]) {
			System.out.println("test case 2 correct!");
		} else {
			System.out.println("test case 2 wrong!");
		}
		// s.print(results);
		
		// Test case 3
		Point[] test3 = new Point[3];
		test3[0] = new Point(0, 4);
		test3[1] = new Point(0, 2);
		test3[2] = new Point(0, 1);
		results = s.getKNearestPoints(test3, 5);
		if(results[0] == test3[2] && results[1] == test3[1] && results[2] == test3[0]) {
			System.out.println("test case 3 correct!");
		} else {
			System.out.println("test case 3 wrong!");
			System.out.println(results[0].x + " " + results[0].y);
			System.out.println(results[1].x + " " + results[1].y);
			System.out.println(results[2].x + " " + results[2].y);
		}
		// s.print(results);
		
		// Test case 4
		Point[] test4 = new Point[0];
		results = s.getKNearestPoints(test4, 8);
		if(results.length == 0) {
			System.out.println("test case 4 correct!");
		} else {
			System.out.println("test case 4 wrong!");
		}
		// s.print(results);
		
		// Test case 5
		Point[] test5 = new Point[2];
		test5[0] = new Point(0, 1);
		test5[1] = new Point(1, 0);
		results = s.getKNearestPoints(test5, 0);
		if(results.length == 0) {
			System.out.println("test case 5 correct!");
		} else {
			System.out.println("test case 5 wrong!");
		}
		// s.print(results);
		
//		// Test case 6
//		Point[] test6 = new Point[3];
//		test6[0] = new Point(Double.MIN_VALUE, Double.MAX_VALUE);
//		test6[1] = new Point(Double.MIN_VALUE, Double.MIN_VALUE);
//		test6[1] = new Point(Double.MAX_VALUE, Double.MAX_VALUE);
//		results = s.getKNearestPoints(test5, 2);
//		if(results[0] == test6[0] && results[1] == test6[1]) {
//			System.out.println("test case 6 correct!");
//		} else {
//			System.out.println("test case 6 wrong!");
//		}
//		// s.print(results);
		
	}
	
//	private void print(Point[] ps) {
//		for(Point p : ps) {
//			System.out.println("[x: " + p.x + " y: " + p.y + "]");
//		}
//		System.out.println("Done!");
//	}
}
