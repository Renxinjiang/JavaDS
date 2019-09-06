//链表基本操作

//定义结点
class Node{
	int val;    //定义一个数据域
	Node next;  //定义一个指针域
	//构造方法
	Node(int val){
		this.val = val;
		this.next = null;
	}
	//按照一定的格式打印字符串
	public String toString(){
		return String.format("Node(%d)",val);
	}
}

public class MyLinkedList{
	public static void main(String[] args){
		Node head = null;
		MyLinkedList list = new MyLinkedList();
		/*
		head = pushFront(head,4);
		head = pushFront(head,3);
		head = pushFront(head,2);
		head = pushFront(head,1);
		print(head);
		*/
		head = list.pushFront(head,3);
		head = list.pushFront(head,2);
		head = list.pushFront(head,1);
		list.print(head);
		list.pushBack(head,4);
		list.pushBack(head,5);
		list.pushBack(head,6);
		list.print(head);
		head = list.popFront(head);
		head = list.popFront(head);
		list.print(head);
		list.popBack(head);
		list.print(head);
	}
	//打印
	public static void print(Node head){
		System.out.println("打印链表：");
		for(Node cur = head; cur != null; cur = cur.next){
			System.out.print(cur + "-->");
		}
		System.out.println("null");
	}
	//头插
	public static Node pushFront(Node head,int val){
		Node node = new Node(val);
		node.next = head;
		return node;
	}
	//尾插
	public static Node pushBack(Node head,int val){
		Node node = new Node(val);
		if(head == null){
			return node;
		}else{
			Node last = head;
			while(last.next != null){
				last = last.next;
			}
			last.next = node;
			return head;
		}
	}
	//头删
	public static Node popFront(Node head){
		if(head == null){
			System.err.println("空链表无法删除");
			return null;
		}
		head = head.next;
		return head;
	}
	//尾删
	public static Node popBack(Node head){
		if(head == null){
			System.err.println("空链表无法删除");
			return null;
		}
		//只有一个节点的情况
		if(head.next == null){
			return null;
		}
		Node lastSecond = head;
		while(lastSecond.next.next != null){
			lastSecond = lastSecond.next;
		}
		lastSecond.next = null;
		return head;
	}
}