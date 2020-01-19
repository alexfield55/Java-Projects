package test;

public class LinkedStackApp
{

    public static void main(String[] args)
    {
	LinkedStack<String> newStack = new LinkedStack();
	
	newStack.push("a");
	newStack.push("b");
	newStack.push("c");
	
	for(String el: newStack)
	{
	    System.out.println(el);
	}
	
	

    }

}
