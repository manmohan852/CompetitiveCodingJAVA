package site.leetcode.binaryTree;
//https://leetcode.com/problems/reaching-points/
//780. Reaching Points
//https://leetcode.com/problems/reaching-points/discuss/375429/Detailed-explanation.-or-full-through-process-or-Java-100-beat
public class ReachingPoints {

    //Top Down apprach : Naive/initial thinking
    public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty)
            return true;
        if (sx > tx || sy > ty)
            return false;
        return (reachingPoints(sx + sy, sy, tx, ty) || reachingPoints(sx, sx + sy, tx, ty));
    }

    //Optimization : Bottom up
    public static boolean reachingPoints2(int sx, int sy, int tx, int ty) {
        while (sx < tx && sy < ty)
            if (tx < ty)
                ty %= tx;
            else
                tx %= ty;
        if (sx == tx && sy <= ty && (ty - sy) % sx == 0)
            return true;
        return sy == ty && sx <= tx && (tx - sx) % sy == 0;
    }

}
