import java.io.File;
import java.util.Scanner;

public class Recommender {

	// Return the top k recommended friends for user i using the popular nodes method. If i does not exist, return null. In case of a tie, users with the lowest id are selected.
	public static <K extends Comparable<K>> PQK<Double, K> recommendPop(Graph<K> g, K i, int k) {
		try {
	if(g.isNode(i)) {
		double count =0;
		PQKImp<Double, K> x = new PQKImp<Double, K>(k);
		List<K> l = g.getNodes();
		List<K> nig = g.neighb(i);
		boolean aa =false;
		l.findFirst();
		
		for(int ss=0;ss<l.size();ss++) {
			aa =false;
			K m = l.retrieve();
			if(nig!=null) {
			nig.findFirst();
			for(int a=0;a<nig.size();a++) {
				if(m.equals(nig.retrieve())) {
					aa=true;
					break;
				}
				nig.findNext();
			}
			}
			if(aa) {
				 l.findNext();
				 continue;
			}
			
			if(l.retrieve().equals(i)) {
				
				 l.findNext();
				 continue;
			}
			List<K> ni = g.neighb(m);
			
			if (ni!=null&&!ni.empty()) {
				ni.findFirst();
				for(int s=0;s<ni.size();s++) {
				if(ni.retrieve().equals(i)) {
					ni.findNext();
                    continue;}	
					count++;
				
				    ni.findNext();	
				}
			}
			x.enqueue(count, m);
	
		     l.findNext();
		     count =0;
		}	
		return x;
	}
		}
		catch(Exception x) {
			
			return null;
		
		}
		return null;
	}

	// Return the top k recommended friends for user i using common neighbors method. If i does not exist, return null. In case of a tie, users with the lowest id are selected.
	public static <K extends Comparable<K>> PQK<Double, K> recommendCN(Graph<K> g, K i, int k) {
		try {
		if(g.isNode(i)) {
			
			double count =0;
			PQKImp<Double, K> x = new PQKImp<Double, K>(k);
			List<K> l = g.getNodes();
			List<K> nig = g.neighb(i);
			
			boolean aa =false;
			l.findFirst();
			
			for(int ss=0;ss<l.size();ss++) {
				aa =false;
				K m = l.retrieve();
				if(nig!=null) {
				nig.findFirst();
				for(int a=0;a<nig.size();a++) {
					if(m.equals(nig.retrieve())) {
						aa=true;
						break;
					}
					nig.findNext();
				}
				}
				if(aa) {
					 l.findNext();
					 continue;
				}	
				if(l.retrieve().equals(i)) {
					 l.findNext();
					 continue;
				}
				List<K> ni = g.neighb(m);
				
				if (!ni.empty()) {
					ni.findFirst();
					for(int s=0;s<ni.size();s++) {
						K w = ni.retrieve();
						nig.findFirst();
						for(int in=0;in<nig.size();in++) {
							if(w.equals(nig.retrieve())) {
								count++;
								break;
							}
							nig.findNext();
						}
						ni.findNext();		
					}

				}
				x.enqueue(count, m);
		
			     l.findNext();
			     count =0;
			}	
			return x;
		}
	}
catch(Exception x) {
			
			return null;
		
		}
		return null;
	}

	// Read graph from file. The file is a text file where each line contains an edge. The end and start of the edge are separated by space(s) or tabs.
	public static Graph<Integer> read(String fileName) {

		try {
			Graph<Integer> g = new MGraph<Integer>();
			Scanner scanner = new Scanner(new File(fileName));
			while (scanner.hasNextInt()) {
				int i = scanner.nextInt();
				g.addNode(i);
				int j = scanner.nextInt();
				g.addNode(j);
				g.addEdge(i, j);
			}
			scanner.close();
			return g;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
