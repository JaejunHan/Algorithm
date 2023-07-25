import java.io.*;
import java.util.*;

class B16940 {
	static int n;
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	static int[] arr;
	static boolean[] visited;
    public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		arr = new int[n];
		visited = new boolean[n+1];
		for (int i=0; i<=n; i++) {
			adj.add(new ArrayList<>());
		}

		int from, to;
		for (int i=0; i < n-1; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			adj.get(from).add(to);
			adj.get(to).add(from);
		}

		for (int i=0; i < n; i++) {
			arr[i] = sc.nextInt();
		}


		if (arr[0] != 1) {
			System.out.println(0);
			return;
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(arr[0]);
		visited[arr[0]] = true;
		HashSet<Integer> set = new HashSet<>();
		int idx = 1;

		while (!q.isEmpty()) {
			int f = q.poll();
			set.clear();

			for (int ele: adj.get(f)) {
				if (visited[ele]) {
					continue;
				}
				set.add(ele);
				visited[ele] = true;
			}
			int size = set.size();
			for (int i=idx; i<idx+size; i++) {
				if (set.contains(arr[i])) {
					q.add(arr[i]);
				} else {
					System.out.println(0);
					return;
				}
			}

			idx += size;
		}


		System.out.println(1);
    }
}
