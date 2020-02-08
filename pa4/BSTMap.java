public class BSTMap<K extends Comparable<K>, T> implements Map<K, T> {
	boolean flag = false;
	public BSTNode<K, T> root;
	private int size;

	public BSTMap() {
		root = null;
	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public boolean full() {
		return false;
	}

	@Override
	public void clear() {
		root = null;
		size = 0;
	}

	@Override
	public boolean update(K k, T e) {

		@SuppressWarnings("unused")
		BSTNode<K, T> p = root, q = root;
		if (size == 0) {
			return false;
		}
		while (p != null) {
			q = p;
			if (p.key.compareTo(k) == 0) {
				p.data = e;// update
				return true;
			} else if (k.compareTo(p.key) < 0)
				p = p.left;
			else
				p = p.right;

		}
		return false;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Pair<Boolean, T> retrieve(K k) {
		// Pair<Boolean, T> h;
		@SuppressWarnings("unused")
		BSTNode<K, T> p = root, q = root;
		if (size == 0) {
			return new Pair(false, null);
		}
		while (p != null) {
			q = p;
			if (p.key.compareTo(k) == 0) {

				return new Pair(true, p.data);
			} else if (k.compareTo(p.key) < 0)
				p = p.left;
			else
				p = p.right;

		}
		return new Pair(false, null);
	}

	@Override
	public boolean insert(K k, T e) {

		BSTNode<K, T> p = root, q = root;

		BSTNode<K, T> s = new BSTNode<K, T>(k, e);
		if (size == 0) {
			root = s;
			size++;
			return true;
		}
		while (p != null) {
			q = p;
			if (p.key.compareTo(k) == 0) {
				return false;
			} else if (k.compareTo(p.key) < 0)
				p = p.left;
			else
				p = p.right;
		}

		if (k.compareTo(q.key) < 0) {
			q.left = s;
		} else
			q.right = s;

		size++;
		return true;
	}

//	@Override
	public boolean remove(K k) {
		
		      // Search for k
		K k1 = k;
		BSTNode<K, T> p = root,current;
		BSTNode<K, T> q = null; // Parent of p 
		while (p != null) {
		if (k.compareTo(p.key) < 0) { q =p;
		p = p.left;
		} else if (k.compareTo(p.key) > 0) {
		q = p;
		p = p.right; 
	
		}
		else { // Found the key
            // Check the three cases
if ((p.left != null) && (p.right != null)) {
// Case 3: two children
// Search for the min in the right subtree
	BSTNode<K, T> min = p.right;
q = p;
while (min.left != null) {
q = min;
min = min.left; }
p.key = min.key; p.data = min.data;
k1 = min.key;
p = min;
               // Now fall back to either case 1 or 2
}
if (p.left != null) { // One child
p = p.left;
} 
else { // One or no children
p = p.right; }
if (q == null) { // No parent for p, root must change
	root = p;
} 
else {
if (k.compareTo(q.key) < 0) {
q.left = p; } else {
q.right = p; }}
current = root; 
return true;
} 
		}		
	return false; // Not found
		
		
}

	
//		flag=false;
//		
//		BSTNode<K, T> p;
//		p = remove_aux(k, root,flag);
//		 root = p;
//    size=getKeys().size();
//		return flag;
//	}
//	private BSTNode<K, T> remove_aux(K k, BSTNode<K, T> p,boolean flag) {
//		BSTNode<K, T> q, child = null;
//		if(p == null)
//			return null;
//		if(k.compareTo(p.key) <0  )
//			p.left = remove_aux(k, p.left, flag); //go left
//		else if(k.compareTo(p.key) > 0)
//			p.right = remove_aux(k, p.right, flag); //go right
//		else {
//			flag=true;
//			if (p.left != null && p.right != null){ //two children
//				q = find_min(p.right);
//				p.key = q.key;
//				p.data = q.data;
//				p.right = remove_aux(q.key, p.right, flag);
//			}
//			
//			else {
//				if (p.right == null) //one child
//					child = p.left;
//				else if (p.left == null) //one child
//					child = p.right;
//				return child;
//			}
//		}
//		return p;
//
//		
//		
//	}
//	private BSTNode<K, T> find_min(BSTNode<K, T> p){
//		if(p == null)
//			return null;
//		
//		while(p.left != null){
//			p = p.left;
//		}
//		
//		return p;
//	}

	@Override
	public List<K> getKeys() {
		LinkedList<K> j = new LinkedList<K>();
		getKeys(j, root);
		return j;
	}

	private void getKeys(LinkedList<K> j, BSTNode<K, T> p) {
		if (p == null)
			return;
		getKeys(j, p.left);

		j.insert(p.key);
		getKeys(j, p.right);
		return;
	}

}
