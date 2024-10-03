package main.java.com.example.project;

public class QueueStackTester {
    public static <T> void split(Queue<T> q, Queue<T> oq, Queue<T> eq)
    {        
        int indexCount = oq.length() + eq.length() ;
        
        if (indexCount == q.length())
        	return;
        
        T e = q.serve();
        if (indexCount%2 == 0) {
        	if(!oq.full())
        	   oq.enqueue(e);
        }
        else { 
        	if(!eq.full())
        	   eq.enqueue(e);
        }	
        q.enqueue(e);
        
        split(q, oq, eq);
        
        
    }
    public static <T> void remove(LinkedPQ<T> pq, int p)
    {
       if (pq.length() == 0)
    	   return;
        
       PQElement<T> e = null;
       LinkedPQ<T> temp = new LinkedPQ<T>();
       
        for(int i = pq.length(); i>0; i--) {
            e = pq.serve();
        	if(e.p >= p) {
        	    temp.enqueue(e.data, e.p);
        	}
        }
        
        if(temp.length() == 0)
        	return;
        
        for(int i = temp.length(); i>0; i--) {
        	e = temp.serve();
        	pq.enqueue(e.data, e.p);
        }
    }
    public static <T> boolean search(Stack<T> st, T e)
    {
        if (st.empty())
        	return false;
        boolean check = false;
        T temp = st.pop();
        if (temp.equals(e))
        	check = true;
        check = check || search(st, e);
        st.push(temp);
        return check;
        
        
    }
}