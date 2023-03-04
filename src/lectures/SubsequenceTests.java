package lectures;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class SubsequenceTests {
	
	 @Test 
		public void testlcss() {
		 String s= "abab";
		 String ss= "bcdad";
		 Subsequence testCaseA= new Subsequence(s, ss);
		 assertEquals(testCaseA.lcss(0,0), 2);
	 
		 s= "abab";
		 ss= "zz";
		 Subsequence testCaseB= new Subsequence(s, ss);
		 assertEquals(testCaseB.lcss(0,0), 0);
		 
		 s= "abababa";
		 ss= "zazaaza";
		 Subsequence testCaseC= new Subsequence(s, ss);
		 assertEquals(testCaseC.lcss(0,0), 4);
		 
		 assertEquals(testCaseC.lcss(1,0), 3);
		 
		 assertEquals(testCaseC.lcss(1,1), 3);
		 
	 }
	 
	 @Test 
		public void testfindCommon() {
		 String s= "abab";
		 String ss= "bcdad";
		 Subsequence testCaseA= new Subsequence(s, ss);
		 assertEquals(testCaseA.findCommon(0, 0), "ba");
	 
		 s= "abab";
		 ss= "zz";
		 Subsequence testCaseB= new Subsequence(s, ss);
		 assertEquals(testCaseB.findCommon(0, 0), "");
		 
		 s= "abababa";
		 ss= "zazaaza";
		 Subsequence testCaseC= new Subsequence(s, ss);
		 assertEquals(testCaseC.findCommon(0, 0), "aaaa");
		 
		 assertEquals(testCaseC.findCommon(1, 0), "aaa");
		 assertEquals(testCaseC.findCommon(1, 1), "aaa");
		 
	 }
	 

}
