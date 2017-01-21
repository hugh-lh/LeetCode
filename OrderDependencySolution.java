

import java.util.*;

class Order {
	String order = "";
	public Order(String order) {
		this.order = order;
	}
}
class OrderDependency {
	Order current;
	Order depend;
	public OrderDependency(Order current, Order depend) {
		this.current = current;
		this.depend = depend;
	}
}

public class OrderDependencySolution {
	public List<Order> getOrderList(List<OrderDependency> orders) {
		// write your code here
		List<Order> res = new ArrayList<>();
		if (orders == null || orders.size() == 0) return res;
		Map<String, Set<String>> graph = new HashMap<>();
		Map<String, Integer> degree = new HashMap<>();
		Map<String, Order> record = new HashMap<>();
		
		for (OrderDependency od : orders) {
			Order cur = od.current;
			Order dep = od.depend;
			String curName = cur.order;
			String depName = dep.order;
			
			record.putIfAbsent(curName, cur);
			record.putIfAbsent(depName, dep);
			
			degree.putIfAbsent(depName, 0);
			if (degree.containsKey(curName)) degree.put(curName, degree.get(curName)+1);
			else degree.put(curName, 1);
			
			Set<String> temp = new HashSet<>();
			if (graph.containsKey(depName)) temp = graph.get(depName);
			temp.add(curName);
			graph.put(depName, temp);
			if (!graph.containsKey(curName)) graph.put(curName, new HashSet<String>());
		}
		
		Queue<String> queue = new LinkedList<>();
		for (String s : graph.keySet()) {
			int in = degree.get(s);
			if (in == 0) queue.offer(s);
		}
		while (!queue.isEmpty()) {
			String tp = queue.poll();
			res.add(record.get(tp));
			Set<String> out = graph.get(tp);
			if (out == null || out.size() == 0) continue;
			for (String next : out) {
				degree.put(next, degree.get(next)-1);
				if (degree.get(next) == 0) queue.offer(next);
			}
		}
		if (degree.size() != res.size()) return new ArrayList<>();;
		return res;
	}
	
	public static void main(String[] argc) {
		OrderDependencySolution solution = new OrderDependencySolution();
		Order a = new Order("A");
		Order b = new Order("B");
		Order c = new Order("C");
		Order d = new Order("D");
		Order e = new Order("E");
		Order f = new Order("F");
		Order g = new Order("G");
		Order h = new Order("H");
		
		// Test case 1
		List<OrderDependency> test1 = new ArrayList<>();
		OrderDependency ab = new OrderDependency(b, a);
		OrderDependency ac = new OrderDependency(c, a);
		OrderDependency be = new OrderDependency(e, b);
		OrderDependency ce = new OrderDependency(e, c);
		OrderDependency bd = new OrderDependency(d, b);
		OrderDependency ef = new OrderDependency(f, e);
		OrderDependency df = new OrderDependency(f, d);
		OrderDependency gh = new OrderDependency(h, g);
		test1.addAll(Arrays.asList(ab, ac, be, ce, bd, ef, df, gh));
		List<Order> result = solution.getOrderList(test1);
		System.out.println("Test case 1: ");
		print(result);

		// Test case 2
		List<OrderDependency> test2 = new ArrayList<>();
		OrderDependency bc = new OrderDependency(c, b);
		OrderDependency af = new OrderDependency(f, a);
		OrderDependency dh = new OrderDependency(h, d);
		OrderDependency eg = new OrderDependency(g, e);
		OrderDependency cd = new OrderDependency(d, c);
		OrderDependency fc = new OrderDependency(c, f);
		test2.addAll(Arrays.asList(ab, af, bc, be, fc, eg, cd, gh, dh));
		result = solution.getOrderList(test2);
		System.out.println("Test case 2: ");
		print(result);

		// Test case 3
		List<OrderDependency> test3 = new ArrayList<>();
		OrderDependency eh = new OrderDependency(h, e);
		test3.addAll(Arrays.asList(ab, eh, cd));
		result = solution.getOrderList(test3);
		System.out.println("Test case 3: ");
		print(result);
		
		// Test case 4
		List<OrderDependency> test4 = new ArrayList<>();
		OrderDependency fg = new OrderDependency(g, f);
		OrderDependency cf = new OrderDependency(f, c);
		OrderDependency hg = new OrderDependency(g, h);
		test4.addAll(Arrays.asList(eg, fg, cd, cf, ab, bc, ce, dh, hg));
		result = solution.getOrderList(test4);
		System.out.println("Test case 4: ");
		print(result);
				
		// Test case 5 (with circle)
		List<OrderDependency> test5 = new ArrayList<>();
		OrderDependency ca = new OrderDependency(a, c);
		test5.addAll(Arrays.asList(ab, bc, ca, ce));
		result = solution.getOrderList(test5);
		System.out.println("Test case 5: ");
		print(result);
				
		// Test case 6
		result = solution.getOrderList(new ArrayList<OrderDependency>());
		System.out.println("Test case 6: ");
		print(result);
				
		// Test case 7
		result = solution.getOrderList(Arrays.asList(ab, bc, cd, df));
		System.out.println("Test case 7: ");
		print(result);
				
		// Test case 8
		result = solution.getOrderList(Arrays.asList(ab, bc, bd, df, ce, fg, eh ));
		System.out.println("Test case 8: ");
		print(result);
	}
	
	private static void print(List<Order> orders) {
		if (orders == null || orders.size() == 0) System.out.print("circle graph");
		for(Order i : orders) {
			System.out.print(i.order + " ");
		}
		System.out.println();
	}
}
