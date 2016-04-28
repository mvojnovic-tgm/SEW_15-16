package example1;

import java.util.NoSuchElementException;

import java.util.StringTokenizer;
import static org.junit.Assert.*;
import org.junit.Test;

public class StringTokenizerTest {
	
	StringTokenizer st;
	/**
	 * nextToken() Test with Space, no Error expected
	 */
	@Test
	public void testWithSpaceDel(){
		st = new StringTokenizer("this is a test");
			assertEquals("this",st.nextToken());
	}
	
	/**
	 * nextToken() Test with \t, no Error expected
	 */
	@Test
	public void testWithTabDel(){
		st = new StringTokenizer("this\tis a test");
			assertEquals("this",st.nextToken());
	}
	
	/**
	 * nextToken() Test with \n , no Error expected
	 */
	@Test
	public void testWithNLDel(){
		st = new StringTokenizer("this\nis a test");
			assertEquals("this",st.nextToken());
	}
	
	/**
	 * nextToken() Test with \r, no Error expected
	 */
	@Test
	public void testWithCarRet(){
		st = new StringTokenizer("this\ris a test");
			assertEquals("this",st.nextToken());
	}
	
	/**
	 * nextToken() Test with \f, no Error expected
	 */
	@Test
	public void testWithFromFeed(){
		st = new StringTokenizer("this\fis a test");
			assertEquals("this",st.nextToken());
	}
	
	/**
	 * nextToken() Test with no Tokens, NoSuchElementException expected
	 */
	@Test(expected=NoSuchElementException.class)
	public void testNoSuchElement(){
		st = new StringTokenizer("");
			st.nextToken();
	}
	
	/**
	 * countToken() Test with no Tokens, no Error expected
	 */
	@Test
	public void testCountTokenWithNoTokens(){
		st = new StringTokenizer("");
			st.countTokens();
	}
	
	/**
	 * countToken() Test with 4 Tokens, no Error expected
	 */
	@Test
	public void testCountTokenWithTokens(){
		st = new StringTokenizer("this is a test");
			st.countTokens();
	}
	
	/**
	 * nextToken() test with Delimiters only, NoSuchElementException expected
	 */
	@Test(expected=NoSuchElementException.class)
	public void testOnlyWithDelimiters(){
		st = new StringTokenizer("\t\r\f");
			st.nextToken();
	}
	
	/**
	 * nextToken() Test with "_" as Delimiters, no Error expected
	 */
	@Test
	public void testWithUnderline(){
		st = new StringTokenizer("this_is_a_test");
			assertEquals("this",st.nextToken("_"));
	}
}
