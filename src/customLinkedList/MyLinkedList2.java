package customLinkedList;

public class MyLinkedList2 {

	int size = 0;
	MyNode head;
	MyNode tail;
	
	public int myGetSize()
	{
		return this.size;
	}
	
	public void myAdd(int data)
	{
		MyNode node = new MyNode(data);
		
		if (tail == null)
		{
			head = node;
			tail = node;
		}
		
		else
		{
			tail.nextNode = node;
			tail = node;
		}
		
		size++;
	}
	
	public MyNode myDelete(int data)
	{
		MyNode nodeToReturn = null;
		
		if (size == 0)
			return null;
		
		if (size == 1)
		{
			nodeToReturn = head;
			head = null;
			tail = null;
			size--;
			return nodeToReturn;
		}
		
		MyNode nodeBeforeNodeToDelete = myFindNodeBefore(data);
		
		if (nodeBeforeNodeToDelete.data == 0)
		{
			 head = head.nextNode;
			 size--; 
		}
		
		else if (nodeBeforeNodeToDelete != null)
		{
			if (tail.data == data)
			{
				nodeBeforeNodeToDelete.nextNode = null;
				tail = nodeBeforeNodeToDelete;
			}
			
			else 
			{
				nodeBeforeNodeToDelete.nextNode = nodeBeforeNodeToDelete.nextNode.nextNode; 
			}
			
			size--;	
		}
		
		return null;
	}
	
	public MyNode myFindNodeBefore(int data)
	{
				
		if (head.data == data)
		{
			return new MyNode();
		}
		
		MyNode node = head;
		
		while (node.nextNode != null)
		{
			if (node.nextNode.data == data)
			{
				return node; 
			}
			
			node = node.nextNode;		
			
		}
		
		return null;
	}
	
	public MyNode myFind(int data)
	{
		if (head == null)
			return null;
		
		if (head.data == data)
		{
			return head;
		}
		
		MyNode node = head;
		
		while (node.nextNode != null)
		{
			node = node.nextNode;
			
			if (node.data == data)
				return node;
		}
		
		return null;
	}
	
	public void myTraverse()
	{
		if (head != null)
		{
			MyNode node = head;
			System.out.println(node);
			while(node.nextNode != null)
			{
				node = node.nextNode;
				System.out.println(node);
			}
		}
	}
	
}
