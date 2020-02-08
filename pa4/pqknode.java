
public class pqknode<T,P extends Comparable<P>> {
	public T data;
	public P priority;
	public pqknode<T,P> next;
	
	public pqknode() {
		next = null;
	}
	public pqknode(P s , T e) {
		data = e;
		priority=s;
		next = null;
	}
	

}
