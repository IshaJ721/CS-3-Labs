import java.io.*;
import java.util.*;

public class WorstFit {
	static int totalSize = 0;

	public static Queue worstFit(String fileName) {
		Queue<Disk> pq = new PriorityQueue<Disk>();
		try {
			Scanner input = new Scanner(new File(fileName));
			int id = 0;
			while (input.hasNext()) {
				int x = input.nextInt();
				totalSize += x;
				if (pq.size() < 1) {
					Disk d = new Disk(id++);
					d.add(x);
					pq.offer(d);
					continue;
				}
				if (pq.peek().getSpace() < x) {
					Disk d = new Disk(id++);
					d.add(x);
					pq.offer(d);
				} else {
					Disk d = pq.poll();
					d.add(x);
					pq.offer(d);
				}
			}
		} catch (FileNotFoundException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pq;
	}

	public static Queue worstFitDecreasing(String fileName) {
		Queue<Disk> pq = new PriorityQueue<Disk>();
		PriorityQueue<Double> files = new PriorityQueue<>(new Comparator<Double>() {
			@Override
			public int compare(Double o1, Double o2) {
				 if(o1<o2) return 1;
	                return -1;
			}
        });
		try {
			Scanner input = new Scanner(new File(fileName));
			while (input.hasNext())
				files.offer((double)input.nextInt());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int id = 0;
		while (!files.isEmpty()) {
			int x = files.poll().intValue();
			if (pq.size() < 1) {
				Disk d = new Disk(id++);
				d.add(x);
				pq.offer(d);
				continue;
			}
			if (pq.peek().getSpace() < x) {
				Disk d = new Disk(id++);
				d.add(x);
				pq.offer(d);
			} else {
				Disk d = pq.poll();
				d.add(x);
				pq.offer(d);
			}
		}
		return pq;
	}

	public static void main(String[] args) {
		// Worst Fit
		Queue<Disk> pq = worstFit("input20.txt");
		System.out.println("Total size = " + (double) totalSize / 1000000 + "GB");
		System.out.println("Disks req'd = " + pq.size());
		Queue<Disk> temp = new PriorityQueue<Disk>();
		temp.addAll(pq);
		while (!temp.isEmpty()) {
			Disk d = temp.poll();
			System.out.println(d.getId() + " " + d.getSpace() + ": " + d.listToString());
		}
		System.out.println();
		// Worst Fit Decreasing
		pq = worstFitDecreasing("input20.txt");
		System.out.println("Total size = " + (double) totalSize / 1000000 + "GB");
		System.out.println("Disks req'd = " + pq.size());
		temp = new PriorityQueue<Disk>();
		temp.addAll(pq);
		while (!temp.isEmpty()) {
			Disk d = temp.poll();
			System.out.println(d.getId() + " " + d.getSpace() + ": " + d.listToString());
		}
	}

}
