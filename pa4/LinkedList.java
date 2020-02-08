
public class LinkedList<T> implements List<T> {
	private Node<T> head;
	private Node<T> current;
	private int size=0;
	public LinkedList() {
		head = current = null;
	}

	@Override
	public boolean empty() {
		return head == null;
	}

	@Override
	public boolean full() {

		return false;
	}

	@Override
	public void findFirst() {
		current = head;

	}

	@Override
	public void findNext() {
		current = current.next;

	}

	@Override
	public boolean last() {
		return current.next == null;
	}

	@Override
	public T retrieve() {

		return current.data;
	}

	@Override
	public void update(T e) {
		current.data = e;

	}

	@Override
	public void insert(T e) {
		Node<T> var;
		if (head == null) {
			current = head = new Node<T>(e);
			size++;
			return;
		}
		var = current.next;
		current.next = new Node<T>(e);
		current = current.next;
		current.next = var;
size++;
	}

	@Override
	public void remove() {

		if (current == head) {
			head = head.next;
		} else {
			Node<T> tmp = head;

			while (tmp.next != current)
				tmp = tmp.next;
			tmp.next = current.next;
		}
		if (current.next == null)
			current = head;

		else
			current = current.next;

		size--;
	}



	@Override
	
		public int size() {
			Node<T> q=head;
			
			if(empty()) {
				return 0;
			}
			int i =1;
			
			while(q.next!=null) {
		
				i++;	
				q=q.next;
			}
				return i;
		}
	

	@Override
	public boolean exists(T e) {
		boolean fou=false;
		Node<T> p =head;
		
		for(int i=0;i<size;i++) {
			if(p.data.equals(e)) {
				return true;
				//break;
			}
			p=p.next;
		}
		
		return false;
	}

}
