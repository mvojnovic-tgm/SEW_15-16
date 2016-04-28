package vojnovic;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.awt.List;
import java.util.LinkedList;
import java.util.List.*;
import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.mockito.hamcrest.MockitoHamcrest.*;
import static org.mockito.ArgumentMatcher.*;

public class MockTestList {

	LinkedList mockedList;

	
	@Before
	public void setUp(){
		mockedList = mock(LinkedList.class);
	}
	
	@Test
	public void testBehavior(){
		List mockedList = mock(List.class);
		
		mockedList.add("one");
		mockedList.removeAll();
		
		verify(mockedList).add("one");
		verify(mockedList).removeAll();
	}
	
	@Test(expected=RuntimeException.class)
	public void stubbing(){
		LinkedList mockedList = mock(LinkedList.class);
		
		when(mockedList.get(0)).thenReturn("first");
		when(mockedList.get(1)).thenThrow(new RuntimeException());
		
		System.out.println(mockedList.get(0));
		System.out.println(mockedList.get(1));
		
		System.out.println(mockedList.get(999));
		
		verify(mockedList).get(1);
	}
	
	/*@Test
	public void testArgumentMatcher(){	
		when(mockedList.get(anyInt())).thenReturn("element");
		
		//when(mockedList.contains(argThat(isValid()))).thenReturn("element");
		
		System.out.println(mockedList.get(999));
		
		verify(mockedList).get(anyInt());
	}*/
	
	@Test
	public void testNumberOfInnocations(){
		mockedList.add("once");
		mockedList.add("twice");
		mockedList.add("twice");
		mockedList.add("three times");
		mockedList.add("three times");
		mockedList.add("three times");
		
		verify(mockedList).add("once");
		verify(mockedList, times(1)).add("once");
		
		verify(mockedList, times(2)).add("twice");
		verify(mockedList, times(3)).add("three times");
		
		verify(mockedList, never()).add("never happened");
		
		verify(mockedList, atLeastOnce()).add("three times");
		verify(mockedList, atLeast(2)).add("twice");
		verify(mockedList, atLeast(3)).add("three times");
		
	}
	
	@Test
	public void verificationInOrderSingleMock(){
	
		 // A. Single mock whose methods must be invoked in a particular order
		 List singleMock = mock(List.class);

		 //using a single mock
		 singleMock.add("was added first");
		 singleMock.add("was added second");

		 //create an inOrder verifier for a single mock
		 InOrder inOrder = inOrder(singleMock);

		 //following will make sure that add is first called with "was added first, then with "was added second"
		 inOrder.verify(singleMock).add("was added first");
		 inOrder.verify(singleMock).add("was added second");
		
	}
	
	
	@Test
	public void verificationInOrderMultipleMock(){
		
		// B. Multiple mocks that must be used in a particular order
		 List firstMock = mock(List.class);
		 List secondMock = mock(List.class);

		 //using mocks
		 firstMock.add("was called first");
		 secondMock.add("was called second");

		 //create inOrder object passing any mocks that need to be verified in order
		 InOrder inOrder = inOrder(firstMock, secondMock);

		 //following will make sure that firstMock was called before secondMock
		 inOrder.verify(firstMock).add("was called first");
		 inOrder.verify(secondMock).add("was called second");

		 // Oh, and A + B can be mixed together at will
		
	}
	

}
