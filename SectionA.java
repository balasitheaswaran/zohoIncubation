class WordObject {
	String word;
	WordObject next;
	
	WordObject() {
		this.word = "";
		this.next = null;
	}
	
	WordObject(String word) {
		this.word = word;
		this.next = null;
	}	
}

class WordIndex {
	int indexValue;
	WordObject head;
	WordObject lastWord;
	
	WordIndex(int idx) {
		this.indexValue = idx;
		this.head = new WordObject("");
		this.lastWord = head;
	}
}


class SectionA{
    static char arr[];
    static WordIndex indices[];
	static int maxLimit;
    public static void main(String[] args) {
        //I have given the input statically instead of scanner input
        System.out.println("question1 => "+"racecar");
        question1("racecar");
        System.out.println("question1 =>"+"football");
        question1("football");
        System.out.println("question3 =>"+"abdf");
        question3("abdf");
        System.out.println("question3 =>"+"hafd");
        question3("hafd");
        System.out.println("question5 => "+"abcdefg");
        question5("abcdefg");
        System.out.println("question5 => "+"adxz");
        question5("adxz");
        System.out.println("question6 => "+"madameaga");
        question6("madameaga");
        System.out.println("question6 => "+"abcdefghfgbeadc");
        question6("madameaga");
        System.out.println("question7 => "+" This is Zoho and Zoho is good");
        question7("This is Zoho and Zoho is good");
        System.out.println("question7 => "+"we develop software we craft software");
        question7("we develop software we craft software");

    }
    public static boolean isPalindrome(String a){  
        boolean flag = true;  
        for(int iterI = 0; iterI < a.length()/2; iterI++){  
            if(a.charAt(iterI) != a.charAt(a.length()-iterI-1)){  
                flag = false;  
                break;  
            }  
        }  
        return flag;  
    }  

    private static void question5(String string) {
        int val=string.charAt(1)-string.charAt(0);
        for(int iterI=2;iterI<string.length()-1;iterI++){
            if(string.charAt(iterI)-string.charAt(iterI-1)!=val){
                System.out.println("Unequal difference");
                return;
            }
        }
        System.out.println("Equal difference.");
        return;
    }

    public static void initializeGlobals() {
		maxLimit = 8450;
		indices = new WordIndex[maxLimit+1];
		int i1 = 0;
		for(i1 = 1;i1 < indices.length;i1++) {
			indices[i1] = new WordIndex(i1);
		}
	}
	
	public static boolean compareWords(String s1, String s2) {
		boolean match = false;
		int i1 = 0;
		char c1 = ' ';
		char c2 = ' ';
		int diff = 0;
		if(s1.length() == s2.length()) {
			match = true;
			for(i1 = 0;(i1 < s1.length() && match);i1++) {
				diff = (int)s1.charAt(i1) - (int)s2.charAt(i1);
				match = (diff == 0 || (diff == 32 || diff == -32));
			}
		}
		return match;
	}
	
	public static boolean searchWordIndex(WordIndex wordIndex, String word) {
		WordObject iterWordObject = wordIndex.head.next;
		boolean hit = false;
		while(!hit && null != iterWordObject) {
			hit = compareWords(iterWordObject.word, word);
			iterWordObject = iterWordObject.next;
		}
		return hit;
	}
	
	public static void insertIntoWordIndex(WordIndex wordIndex, WordObject wordObject) {
		wordIndex.lastWord.next = wordObject;
		wordIndex.lastWord = wordIndex.lastWord.next;
	}

	public static String getDistinctWords(String sentence) {
		String word = "";
		int i1 = 0;
		char delimiter = ' ';
		int currentWordIndex = 0;
		char c = ' ';
		int currentCharValue = 0;
		int currentCharPosition = 0;
		boolean hit = false;
		String distinctWords = "";
		for(i1 = 0;i1 < sentence.length();i1++) {
			c = sentence.charAt(i1);
			if(delimiter != c) {
				word += c;
				currentCharPosition++;
				currentCharValue = (((int)c >= 97 && (int)c <= 122) ? (int)c - 96 : (int)c - 64);
				currentWordIndex += (currentCharValue * currentCharPosition);
			} else {
				//System.out.print("\nCurrent Word: " + word);
				if(!("".equals(word)) && currentWordIndex > 0) {
					hit = searchWordIndex(indices[currentWordIndex], word);
					if(!hit) {
						WordObject wordObject = new WordObject(word);
						insertIntoWordIndex(indices[currentWordIndex], wordObject);
						distinctWords += (" " + word);
					}
					currentWordIndex = 0;currentCharPosition = 0;word = "";
				}
			}
		}
		if(!("".equals(word))) {
			hit = searchWordIndex(indices[currentWordIndex], word);
			if(!hit) {
				WordObject wordObject = new WordObject(word);
				insertIntoWordIndex(indices[currentWordIndex], wordObject);
				distinctWords += (" " + word);
			}
			currentWordIndex = 0;currentCharPosition = 0;
		}
		return distinctWords;
	}

    private static void question6(String string) {
        String[] words = new String[100]; 
        String word = "", bigPalin="";  ;
        int temp = 0, count = 0;  
        for(int i = 0; i < string.length(); i++){  
            if(string.charAt(i) != ' '){  
                word = word + string.charAt(i);  
            }  
            else{  
                words[temp] = word;  
                temp++;  
                word = "";  
            }  
        }
        
        for(int i = 0; i< temp; i++){  
            if(isPalindrome(words[i])){  
                count++;   
                if(count == 1)  
                   bigPalin = words[i];  
                else{   
                    if(bigPalin.length() < words[i].length())  
                        bigPalin = words[i];  
                }  
            }  
        }
        if(count == 0)  
            System.out.println("No palindrome found");  
        else{  
            System.out.println(bigPalin);  
        }  
        
        
    }

    public static void merge(char arr[], int first, int mid, int last)
    	{
    		//System.out.print("\nFirst: " + first + " Mid: " + mid + " Last: " + last);
       
        	int l1 = mid - first + 1;
        	int l2 = last - mid;
  		int i1,i2;
  		i1 = i2 = 0;
        	
        	char arr1[] = new char[l1];
        	char arr2[] = new char[l2];
  
        	
        	for (i1 = 0; i1 < l1; i1++)
            		arr1[i1] = arr[first + i1];
        	for (i2 = 0; i2 < l2; i2++)
            		arr2[i2] = arr[mid + 1 + i2];

       	 int idx = first;i1 = i2 = 0;
        	while (i1 < l1 && i2 < l2) {
            		if (arr1[i1] >= arr2[i2]) {
                		arr[idx] = arr1[i1];
                		i1++;
            		}
            		else {
                		arr[idx] = arr2[i2];
                		i2++;
            		}
            		idx++;
        	}
  
        	
        	while (i1 < l1) {
            		arr[idx] = arr1[i1];
            		i1++;
            		idx++;
        	}
  
        	
        	while (i2 < l2) {
            		arr[idx] = arr2[i2];
            		i2++;
            		idx++;
        	}
    	}

        public static void mergeSort(char arr[], int first, int last) {
            if(first < last) {
                int mid = first + (last - first)/2;
                mergeSort(arr, first, mid);
                mergeSort(arr, mid + 1, last);
                merge(arr, first, mid, last);
            }
        }
    
        public static String getLargestString(String str) {
            arr = new char[str.length()];
            String ret = "";
            int i1 = 0;
            for(i1 = 0;i1 < str.length();i1++) {
                arr[i1] = str.charAt(i1);
            }
            mergeSort(arr, 0, arr.length - 1);
            for(i1	= 0;i1 < arr.length;i1++) {
                ret += arr[i1];
            }
            return ret;
        }
    private static void question3(String string) {
        String ans = getLargestString(string);
		System.out.print("\nLargest possible String: " + ans + "\n");
    }

    private static void question7(String strInput2) {
        initializeGlobals();
        System.out.println("The distinct words are :"+getDistinctWords(strInput2));
    }

    public static void question1(String input){
        int len=input.length();
        if(len%2==0){
            System.out.println("Not Possible");
            return;
        }
        int leftSpace=len/2,midSpace=0,temp,mid=len/2,index=0;
        for(int row=0;row<len/2;row++){
            temp=leftSpace;
            while(temp>0){
                 System.out.print(" ");
                temp--;
            }
            System.out.print(input.charAt(mid-index));   
            leftSpace--;
            temp=midSpace;
            if(temp!=0){
                while(temp>0){
                     System.out.print(" ");
                    temp--;
                }
                System.out.print(input.charAt(mid+index));  
                midSpace+=2;  
        }
        else
            midSpace+=1;
        System.out.println();
        index++;
        }
        System.out.print(input.charAt(0));
        temp=len-1;
        while(temp!=0){
             System.out.print(" ");
            temp--;
        }
        System.out.print(input.charAt(len-1));
        System.out.println();
        index=1;
        midSpace=mid;
        for(int row=0;row<len/2;row++){
            leftSpace=row+1;
            
            temp=leftSpace;
            while(temp!=0){
                 System.out.print(" ");
                temp--;
            }
            leftSpace++;
            System.out.print(input.charAt(index));
            temp=midSpace;
            if(index<len/2){
            while(temp!=0){
                 System.out.print(" ");
                temp--;
            }
            System.out.print(input.charAt((len-index)-1));
        }
        index++;
        midSpace-=2;
        System.out.println();
        }
    }
    public static void question2(int n){
        int row=0,col=0;
        int temp=n*2;
        while(temp>0){
            
        }
    }
}