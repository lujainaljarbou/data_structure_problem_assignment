public class MGraph<K extends Comparable<K>> implements Graph<K> {
	public Map<K, List<K>> adj; // Do not change this
	
	public MGraph() {
		adj=new BSTMap<K, List<K>>();
	}
	@Override
	public boolean addNode(K i) {
		LinkedList<K> e = new LinkedList<K>();
	if(isNode(i)) {
		
	return false;
	}
		return adj.insert(i, e);
	}
	@Override
	public boolean isNode(K i) {
		Pair<Boolean, List<K>> h=adj.retrieve(i);
		
	
		return h.first;
	}
	@Override
	public boolean addEdge(K i, K j) {
		if(!isNode(i)) {
			return false;
		}
		if(!isNode(j)) {
			return false;	
		}
		if(isEdge(i,j)) {
			return false;
		}
		
		Pair<Boolean, List<K>> h =adj.retrieve(i);
		Pair<Boolean, List<K>> m =adj.retrieve(j);

//			LinkedList<K> b =(LinkedList<K>)h.second;
//			LinkedList<K> s =(LinkedList<K>)m.second;
			
		adj.retrieve(i).second.insert(j);
		adj.retrieve(j).second.insert(i);
			return true;
		
		//return false;
	}
	@Override
	public boolean isEdge(K i, K j) {

	if(isNode(i)&&isNode(j)) {
		Pair<Boolean, List<K>> h=adj.retrieve(i);
		Pair<Boolean, List<K>> m=adj.retrieve(j);
		
		if(h.second.exists(j)&& m.second.exists(i)) {
			return true;
		}
		
		
	}
		return false;
	}
	@Override
	public List<K> neighb(K i) {
		if(isNode(i)) {
		Pair<Boolean, List<K>> h =adj.retrieve(i);
	//	if(h.first) {
			return h.second;
	//	}
		}
		return null;
	}
	@Override
	public int deg(K i) {
		
		Pair<Boolean, List<K>> h =adj.retrieve(i);
				
		if(h.first) {
			return h.second.size();
			
		}
		return -1;
		
	}
	@Override
	public List<K> getNodes() {
	
		return adj.getKeys();
	}
	
}
