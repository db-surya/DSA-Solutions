class MyQueue {

    int front, rear;
    int N = 100005;
	int arr[] = new int[N];

    MyQueue()
	{
		front=0;
		rear=0;
	}
	
	//Function to push an element x in a queue.
	void push(int x)
	{
	    // Your code here
	    if(rear==N-1) return;
	    arr[rear++] = x;
	} 

    //Function to pop an element from queue and return that element.
	int pop()
	{
		// Your code here
		if(front==rear && front==0) return -1;
		else if(front == rear){
            front = rear = 0;
		    return -1;
		} 
		else return arr[front++];
		
	} 
}