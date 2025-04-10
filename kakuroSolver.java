// Each cell will have a positive rightTangent and downTangent
// If they are absent and cell is still shaded, this means r == 0 and d = 0
// If cells are unshaded and do not contains numbers, than they will have r == -5000 and d = -5000
// If cells are unshaded and contains numbers, than they will have r = -1 * number, d = -5000;
import java.util.*;
import java.util.ArrayList;
public class kakuroSolver{
    static ArrayList<ArrayList<Tangent>> array = new ArrayList<ArrayList<Tangent>>();
    static HashMap<Integer, Pair> map = new HashMap<Integer, Pair>();
    static HashSet<Integer> set = new HashSet<Integer>();
    public static void main(String []args){
       // INITIALISATION OF OUR BOARD
       Scanner sc = new Scanner(System.in);
       int sizeOfBoard = sc.nextInt();
       for(int i = 0; i <= sizeOfBoard - 1; i++){
          ArrayList<Tangent> subarray = new ArrayList<Tangent>();
          for(int j = 0; j <= sizeOfBoard - 1; j++){
              int inputRightTangent = sc.nextInt();
              int inputDownTangent = sc.nextInt();
              subarray.add(new Tangent(inputRightTangent, inputDownTangent));
          }
          array.add(subarray);
       }
       //System.out.println(array);
       // SETTING UP THE ENVIRONMENT AROUND IT
       for(int i = 0; i <= array.size() - 1; i++){
           map.put(i, new Pair(array.get(0).get(i).downTangent, 0));
       }
       boolean outcome = HelperFunction(1, 1, array.get(1).get(0).rightTangent, 0);
       System.out.println(outcome);
       for(int i = 0; i <= array.size() - 1; i++){
           for(int j = 0; j <= array.size() - 1; j++){
               System.out.print(array.get(i).get(j).rightTangent);
               System.out.print(" ");
               System.out.print(array.get(i).get(j).downTangent);
               System.out.print("  ");
           }
           System.out.println("");
       }
    }

    public static boolean HelperFunction(int index1, int index2, int currentIncharge, int summation){
       if(summation > currentIncharge){
          return false;
       }
       if(index1 > array.size() - 1){
          return ((summation == currentIncharge) && (checkFinalCompletionStage() == true)) ? true : false;
       }
       if(index2 > array.size() - 1){
          return HelperFunction(index1 + 1, 0, currentIncharge, summation);
       }
       int rt = array.get(index1).get(index2).rightTangent;
       int dt = array.get(index1).get(index2).downTangent;
       int columnKey = map.get(index2).columnHeadTillNow;
       int columnSummation = map.get(index2).summationTillNow;
       if(rt >= 0 && dt >= 0 && summation != currentIncharge){
          return false;
       }
       if(rt >= 0 && dt >= 0 && columnKey != columnSummation){
          return false;
       }
       if(rt >= 0 && dt >= 0 && backtraceDuplicates(index1, index2) == true){
          return false;
       }
       if(rt < 0 && dt < 0){
          for(int i = 1; i <= 9; i++){
            if(!set.contains(i)){
                set.add(i);
                map.get(index2).summationTillNow += i;
                array.get(index1).set(index2, new Tangent(-1 * i, -5000));
                boolean answer = HelperFunction(index1, index2 + 1, currentIncharge, summation + i);
                if(answer == true){
                    return true;
                }
                set.remove(i);
                map.get(index2).summationTillNow -= i;
            }
          }
          array.get(index1).set(index2, new Tangent(rt, dt));
          return false;
       }

       if(rt >= 0 && dt >= 0){
          HashSet<Integer> set2 = set;
          set = new HashSet<Integer>();
          int storage1 = map.get(index2).columnHeadTillNow;
          int storage2 = map.get(index2).summationTillNow;
          map.get(index2).columnHeadTillNow = dt;
          map.get(index2).summationTillNow = 0;
          boolean answer = HelperFunction(index1, index2 + 1, rt, 0);
          if(answer == true){
            return true;
          }
          set = set2;
          map.get(index2).columnHeadTillNow = storage1;
          map.get(index2).summationTillNow = storage2;
          array.get(index1).set(index2, new Tangent(rt, dt));
          return false;
       }
       return true;
    }

    public static boolean backtraceDuplicates(int index1, int index2){
        HashSet<Integer> unique = new HashSet<Integer>();
        index1 = index1 - 1;
        while(array.get(index1).get(index2).rightTangent < 0 && array.get(index1).get(index2).downTangent < 0){
            if(unique.contains(array.get(index1).get(index2).rightTangent)){
                return true;
            }
            unique.add(array.get(index1).get(index2).rightTangent);
            index1--;
        }
        return false;
    }

    public static boolean checkFinalCompletionStage(){
        for(int i = 0; i <= array.size() - 1; i++){
            int row = array.size();
            if(backtraceDuplicates(row, i) == true){
                return false;
            }
            if(map.get(i).columnHeadTillNow != map.get(i).summationTillNow){
                return false;
            }
        }
        return true;
    }
}

class Tangent{
    int rightTangent;
    int downTangent;
    public Tangent(int rightTangent, int downTangent){
        this.rightTangent = rightTangent;
        this.downTangent = downTangent;
    }
}

class Pair{
    int columnHeadTillNow;
    int summationTillNow;
    public Pair(int columnHeadTillNow, int summationTillNow){
        this.columnHeadTillNow = columnHeadTillNow;
        this.summationTillNow = summationTillNow;
    }
}