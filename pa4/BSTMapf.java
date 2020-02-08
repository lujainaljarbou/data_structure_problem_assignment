
public class BSTMapf<K extends Comparable<K>, T> implements Map<K, T> {

   public BSTNode<K, T> root; // Do not change this
   public int size;
   
   public BSTMapf() {
      root = null;
   }
   
   // Return the size of the map.
   public int size(){
   
      return size;
     
   }
  
   
   // Return true if the map is full.
   public boolean full() {
      return false;
   }
   
   // Remove all elements from the map.
   public void clear(){
      root = null;
      size = 0;
   }
   
	// Update the data of the key k if it exists and return true. If k does not exist, the method returns false.
   public boolean update(K k, T e){
   
      BSTNode<K,T> p = root , q = root;
  
      if(findkey(k)){
      
         while(p != null) {
            q = p;
            if(p.key.compareTo(k) == 0) {
               p.data = e;
               return true;
            }
            else if(k.compareTo(p.key) < 0)
               p = p.left;
            else
               p = p.right;
         }
      
      
         
      }
   
      return false;
      
   }
   
	// Search for element with key k and returns a pair containing true and its data if it exists. If k does not exist, the method returns false and null.
   public Pair<Boolean, T> retrieve(K k){
   
      BSTNode<K,T> p = root , q = root;
      Pair<Boolean, T> isFound;
      
      
      if(findkey(k)) {
      
         while(p != null) {
            q = p;
            if(p.key.compareTo(k) == 0) {
               isFound = new Pair<Boolean, T>(true,p.data);
            }
            else if(k.compareTo(p.key) < 0)
               p = p.left;
            else
               p = p.right;
         }
      }
      
      
      isFound = new Pair<Boolean, T>(false,null);
   
   
      return isFound;
   }
   
   // Insert a new element if does not exist and return true. If k already exists, return false.
   public boolean insert(K k, T val) {
   
      BSTNode<K,T> newNode = new BSTNode<K,T>(k, val) , p = root ;
   	
      if(findkey(k)) {
         return false; 
      }
   	
   	
      if (root == null ) {
         root = newNode ;
         size++;
         return true;
      }
     
         boolean flag = false;
         BSTNode<K,T> q = root;
         
         while(p != null) {
            q = p;
          
            if(k.compareTo(p.key) < 0)
               p = p.left;
            else
               p = p.right;
         }
         
         if(k.compareTo(q.key) < 0)
            q.left = newNode;
         else
            q.right = newNode;
            
         size++;
         return true;
      
   	
   }
   
   // Remove the element with key k if it exists and return true. If the element does not exist return false.
   public boolean remove(K k){
   
      K k1 = k;
      BSTNode<K,T> p = root;
      BSTNode<K,T> q = null;
      while (p != null) {
         if (k1.compareTo(p.key) < 0) {
            q=p;
            p = p.left;
         } else if (k1.compareTo(p.key) > 0) {
            q = p;
            p = p.right;
         } 
         if ((p.left != null) && (p.right != null)) { 
            BSTNode<K,T> min = p.right;
            q = p;
            while (min.left != null) {
               q = min;
               min = min.left;
            }
            p.key = min.key;
            p.data = min.data;
            k1 = min.key;
            p = min;
         }
      
         if (p.left != null) {
            p = p.left;
         } else {
            p = p.right;
         }
         if (q == null) {
            root = p;
         } else {
            if (k1.compareTo(q.key) < 0) {
               q.left = p;
            } else {
               q.right = p;
            }
         }
         
         return true;
      }
      return false;
   }
      

   
   // Return the list of keys in increasing order.
   public List<K> getKeys(){
   
   
      List<K> ordered = new LinkedList<K>();
   
      getKeysR(root,ordered);
   
      return ordered;
   }
   
   private void getKeysR(BSTNode<K,T> p ,List<K> ordered){
   
   
      if(p == null)
         return; 
      
      
      getKeysR(p.left , ordered);
      ordered.insert(p.key);
      getKeysR(p.right , ordered);
      
   
    
   }
   
   
   //Find Key
   public boolean findkey(K tkey) {
      BSTNode<K,T> p = root , q = root;
   			
      if(root == null)
         return false;
   	
      while(p != null) {
         q = p;
         if(p.key==tkey) {
            return true;
         }
         else if(tkey.compareTo(p.key) < 0)
            p = p.left;
         else
            p = p.right;
      }
   	
      return false;
   }


	


}//end of class


 /*
   private int sizeR(BSTNode<K, T> root){
      if(root == null)
         return 0;
         
      if(root.left == null)
         if(root.right == null)
            return 0;
      
      return 1+sizeR(root.left)+sizeR(root.right);
   }
   */
