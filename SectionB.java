class SectionB{
    static int minPathCost(int []startPos,
    int []homePos,
    int []rowCosts,
    int []colCosts)
{
int ans = 0;
int rmin = Math.min(startPos[0], homePos[0]);
int rmax = Math.max(startPos[0], homePos[0]);
int cmin = Math.min(startPos[1], homePos[1]);
int cmax = Math.max(startPos[1], homePos[1]);
for (int i = rmin; i <= rmax; i++)
    ans += rowCosts[i];
for (int i = cmin; i <= cmax; i++)
    ans += colCosts[i];
ans -= rowCosts[startPos[0]];
ans -= colCosts[startPos[1]];

return ans;
}
    public static void main(String[] args) {
        question1();
    }
    private static void question1() {
        int []startpos = { 4, 0 };
        int []homepos = { 0,3};
        int []roscost = { 1,1,1,1,1 };
        int []colcst = { 1,1,1,1};
        System.out.println("Minimum number of steps:"+minPathCost(startpos, homepos,
                                        roscost, colcst));
    }
}







package shortestpath;

public class Gold1 {
	
	public static void main(String[] args) {
		
		int m = 5, n = 4;
		int queue1[] = new int[100];
		int queue2[] = new int[100];
		int monster1[] = new int[100];
		int monster2[] = new int[100];
		
		int arr[][] = {{-1,-1,-1,-1},{-1,-1,-1,-1},{-1,-1,-1,-1},{-1,-1,-1,-1},{-1,-1,-1,-1}};
		
		int M1 = 2, M2 = 0;
		int G1 = 3, G2 = 2;
		int A1 = 4, A2 = 0;
		
		queue1[0] = A1;
		queue2[0] = A2;
		
		monster1[0] = M1;
		monster2[0] = M2;
		
		int i = 0;
		int k = 0;
		int flag = 1;
		
		arr[A1][A2] = 0;
		while(true) {
			System.out.println("Go "+ k +" \nm : " + queue1[k] + "  n : " + queue2[k]);
			
			//Monster
//			if(monster1[i] == G1 && monster2[i] == G2) {
//				flag = 0;
//				break;
//			}
			
			//Adventurer
			if(queue1[i] == G1 && queue2[i] == G2) {
				flag = 1;
				break;
			}
			
			//Adventurer 
			if(queue1[k] - 1 < m && queue2[k] < n && queue1[k] - 1 >= 0 && queue2[k] >= 0 && arr[queue1[k] - 1][queue2[k]] == -1) {
				i++;
				arr[queue1[k] - 1][queue2[k]] = arr[queue1[k]][queue2[k]] + 1;
				queue1[i] = queue1[k] - 1;
				queue2[i] = queue2[k];
				System.out.println("1  i : " + queue1[i] + "  j : " + queue2[i]);
			}
			if(queue1[k] + 1 < m && queue2[k] < n && queue1[k] + 1 >= 0 && queue2[k] >= 0 && arr[queue1[k] + 1][queue2[k]] == -1) {
				i++;
				arr[queue1[k] + 1][queue2[k]] = arr[queue1[k]][queue2[k]] + 1;
				queue1[i] = queue1[k] + 1;
				queue2[i] = queue2[k];
				System.out.println("2  i : " + queue1[i] + "  j : " + queue2[i]);
			}
			if(queue1[k] < m && queue2[k] - 1 < n && queue1[k] >= 0 && queue2[k] - 1 >= 0 && arr[queue1[k]][queue2[k] - 1] == -1) {
				i++;
				arr[queue1[k]][queue2[k] - 1] = arr[queue1[k]][queue2[k]] + 1;
				queue1[i] = queue1[k];
				queue2[i] = queue2[k] - 1;
				System.out.println("3  i : " + queue1[i] + "  j : " + queue2[i]);
			}
			if(queue1[k] < m && queue2[k] + 1 < n && queue1[k] >= 0 && queue2[k] + 1 >= 0 && arr[queue1[k]][queue2[k] + 1] == -1) {
				i++;
				arr[queue1[k]][queue2[k] + 1] = arr[queue1[k]][queue2[k]] + 1;
				queue1[i] = queue1[k];
				queue2[i] = queue2[k] + 1;
				System.out.println("4  i : " + queue1[i] + "  j : " + queue2[i]);
			}
			k++;
		}
		
		int countA = arr[G1][G2];
//		if(flag == 1)
			System.out.println("Shortest Path is  : " + arr[G1][G2]);
//		else
//			System.out.println("No possible solutions.");
		
		
		for(i = 0;i<m;i++) {
			for(int j = 0;j<n;j++) {
				System.out.print(arr[i][j] + " ");
				arr[i][j] = -1;
			}
			System.out.println();
		}
		
		
		
		i = 0;
		k = 0;
		queue1[0] = M1;
		queue2[0] = M2;
		
		arr[M1][M2] = 0;
		while(true) {
			System.out.println("Go "+ k +" \nm : " + queue1[k] + "  n : " + queue2[k]);
			
			//Monster
//			if(monster1[i] == G1 && monster2[i] == G2) {
//				flag = 0;
//				break;
//			}
			
			//Adventurer
			if(queue1[i] == G1 && queue2[i] == G2) {
				break;
			}
			
			//Adventurer 
			if(queue1[k] - 1 < m && queue2[k] < n && queue1[k] - 1 >= 0 && queue2[k] >= 0 && arr[queue1[k] - 1][queue2[k]] == -1) {
				i++;
				arr[queue1[k] - 1][queue2[k]] = arr[queue1[k]][queue2[k]] + 1;
				queue1[i] = queue1[k] - 1;
				queue2[i] = queue2[k];
				System.out.println("1  i : " + queue1[i] + "  j : " + queue2[i]);
			}
			if(queue1[k] + 1 < m && queue2[k] < n && queue1[k] + 1 >= 0 && queue2[k] >= 0 && arr[queue1[k] + 1][queue2[k]] == -1) {
				i++;
				arr[queue1[k] + 1][queue2[k]] = arr[queue1[k]][queue2[k]] + 1;
				queue1[i] = queue1[k] + 1;
				queue2[i] = queue2[k];
				System.out.println("2  i : " + queue1[i] + "  j : " + queue2[i]);
			}
			if(queue1[k] < m && queue2[k] - 1 < n && queue1[k] >= 0 && queue2[k] - 1 >= 0 && arr[queue1[k]][queue2[k] - 1] == -1) {
				i++;
				arr[queue1[k]][queue2[k] - 1] = arr[queue1[k]][queue2[k]] + 1;
				queue1[i] = queue1[k];
				queue2[i] = queue2[k] - 1;
				System.out.println("3  i : " + queue1[i] + "  j : " + queue2[i]);
			}
			if(queue1[k] < m && queue2[k] + 1 < n && queue1[k] >= 0 && queue2[k] + 1 >= 0 && arr[queue1[k]][queue2[k] + 1] == -1) {
				i++;
				arr[queue1[k]][queue2[k] + 1] = arr[queue1[k]][queue2[k]] + 1;
				queue1[i] = queue1[k];
				queue2[i] = queue2[k] + 1;
				System.out.println("4  i : " + queue1[i] + "  j : " + queue2[i]);
			}
			k++;
		}
		
		int countM = arr[G1][G2];
//		if(flag == 1)
			System.out.println("Shortest Path is  : " + arr[G1][G2]);
//		else
//			System.out.println("No possible solutions.");
		
		
		for(i = 0;i<m;i++) {
			for(int j = 0;j<n;j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		if(countM >= countA)
			System.out.println("Shortest Path is  : " + countA);
		else
			System.out.println("No possible solutions.");
	}

}
