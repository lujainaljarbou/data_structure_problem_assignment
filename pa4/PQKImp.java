public class PQKImp<P extends Comparable<P>, T> implements PQK<P, T> {
	private int size = 0;
	private pqknode<T, P> head, tail;

	private int maxsize;

	public PQKImp(int k) {
		head =tail= null;
		// tail=nodes[k];
		// maxsize=k;
		 //nodes = (pqknode<T,P>[])new Object[k];
		maxsize = k;

	}

	@Override
	public int length() {
		return size;
	}

	@Override
	public void enqueue(P pr, T e) {
	//	System.out.print("d");
		pqknode<T, P> tmp = new pqknode<T, P>(pr, e);
		 if(length()==0) {
			// System.out.print("d");
				head = tail = tmp;	
				size++;
				return;
		 }
			
//	else if(pr.compareTo(head.priority) == 0) {
//   
////		if(size <= 1){
////      tmp.next=head.next;
////			head.next=tmp;
////      }
//		
//    //  else {
//      pqknode<T, P> p = head;
//      pqknode<T, P> q = null;
//      int h=0;
//      while(h<maxsize &&pr.compareTo(p.priority)==0 ){
//      q=p;
//      p=p.next;
//      h++;
//      }
//      q.next=tmp;
//      tmp.next=p;
//      //}			
//			
//		}
				
		 else if (pr.compareTo(head.priority)>0) {
			
				tmp.next = head;
				head = tmp;
				size++;
				
			}
		 
		else {
		//	 System.out.print("s");
				pqknode<T, P> p = head;
				pqknode<T, P> q = null;
				while (p!=null && pr.compareTo(p.priority)<=0) {
				q=p;
	          p = p.next;
				}
				tmp.next = p;
     			q.next = tmp;
     			size++;
			}
//				if(p!=null && pr.compareTo(p.priority)== 0) {
//            while(p.next!=null&&pr.compareTo(p.next.priority)==0){
//            p=p.next;
//            }
//            tmp.next=p.next;
//					p.next=tmp;
//               size--;
//				}
//				else {
//				tmp.next = p;
//				q.next = tmp;
//				}
				
//			}
//         pqknode<T, P> s = head;
//         int k=1;
//         while(s.next!=null){
//         s=s.next;
//          k++;
//         }
//         tail=s;
//			size=k;
         
		if(size>maxsize) {
		//	 System.out.print("s");
			pqknode<T, P> ss = head;
			
			while(ss.next.next!=null) {
				ss=ss.next;
			}
			
			ss.next=null;
			//tail=ss;
			size--;
		}


	}

	@Override
	public Pair<P, T> serve() {
		pqknode<T, P> p = head;
		Pair<P, T> data = new Pair<P, T>(p.priority, p.data);
		head = p.next;
		size--;
		return data;
	}

}
