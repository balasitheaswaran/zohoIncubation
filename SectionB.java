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