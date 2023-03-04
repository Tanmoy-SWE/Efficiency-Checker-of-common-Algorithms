package lectures;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

 class Subsequence {
	 String s1;  // The first string.
	 String s2;  // The second string.
	 int[][] LookUp;  // LookUp[i][j] == longest common subsequence of s1.Subsequence(i, s1.length()-i) and
	                  // s2.subSequence(j, s2.length()-j)

		 Subsequence(String s, String ss){ // Initialises the strings; and
		s1= s; s2= ss;	 
		 LookUp= new int[s1.length() +1][s2.length()+1];  
		 // the LookUp table.  The strings must have
		 for (int i= 0; i< s1.length(); i++)
			   for (int j= 0; j< s2.length(); j++)
			    LookUp[i][j]= -1;
		  }                               

		  int lcss( int i, int j ){
		  //PRE: 0 <= i <= L1; 0 <= j <= L2
		  //POST: returns the length of the longest common subsequence of s1.subSequence(i, L1-1), s2.subSequence(j, L2-1).
		  //      where L1 and L2 are the lengths respectively of L1 and L2.
			  if (LookUp[i][j] == -1 ) { // ... if LookUp[i][j] has not been computed, compute it ...
			       if (i >= s1.length() || j >= s2.length()) LookUp[i][j] = 0;  // Apply Rule (1).
			       else {
			          if (s1.charAt(i) == s2.charAt(j)) { int t= lcss(i+1, j+1);  // Apply Rule (2)... but look up lcss(i+1, j+1)
			                                 LookUp[i][j]= t+1;
			                               }

			          else { int t1= lcss(i+1, j);  // Apply Rule (3) ... but look up lcss(i+1, j)
			                 int t2= lcss(i, j+1);  // lookup lcss(i, j+1)...
			                 if (t1 > t2) LookUp[i][j]= t1;
			                 else LookUp[i][j]= t2;
			          } 
			       }
			   }
			  return LookUp[i][j]; // In either case, just return the computed value of LookUp[i][j]
		  }
		  
		String findCommon(int i, int j) {
			 //PRE: 0 <= i <= L1; 0 <= j <= L2
			  //POST: returns the longest common subsequence of s1.subSequence(i, L1-1), s2.subSequence(j, L2-1).
			  //      where L1 and L2 are the lengths respectively of L1 and L2.
			
			lcss(i,j); // Make sure that the array is defined.
			if (LookUp[i][j]==0) return ""; // Rule 1
			else if (s1.charAt(i) == s2.charAt(j))  return s2.charAt(j) + findCommon(i+1, j+1);	 // Rule 2	
			 else { 
				  int t1= lcss(i+1, j);  // Rule (3) 
                  int t2= lcss(i, j+1);  // 
                    if (t1 > t2)   return findCommon(i+1, j); // Select the larger of the two options
                    else  return findCommon(i, j+1);
                    }			
          }


		
			
 }

class TryIt{
 public static void main(String[] args) {	
		// Test it on small sequences...
		String s= "abdebcbb";
		String ss= "adacbcb";
		Subsequence compare= new Subsequence(s, ss);
		System.out.println("The length of the longest sequence is " + compare.lcss(0, 0));		
		System.out.println("The  longest sequence is " + compare.findCommon(0, 0));
		}
 }

 