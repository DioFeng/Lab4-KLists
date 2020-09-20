import java.util.ArrayList;
public class KLists
{
  private ArrayList<ArrayList<Double>> sample = new ArrayList<ArrayList<Double>>();
  //function
  public KLists(double[][] input)
  {
    for(int i = 0; i<input.length;i++)
    {
        sample.add(new ArrayList<Double>());
    
      for (int j = 0; j<input[i].length;j++)
      {
        System.out.println(input[i][j]);
        
        sample.get(i).add(input[i][j]);      
      
      }
    }
    System.out.println(sample);
  }
  public double [] mergeKLists (double [][] outerArray)
  {
  //code
    return null;
  }
  public String toString()
  {
    
    String result = "";
    for(int i = 0; i<sample.size();i++)
      result+=sample.get(i);
    return result;

  }
  public static void main(String[] args)
  {
  double[][] inputArray1 = {{1.1,4.4,5.5},{1.1,3.3,4.4},{2.2,6.6}};
  //Expected output: [1.1, 1.1, 2.2, 3.3, 4.4, 4.4, 5.5, 6.6]
  double[][] inputArray2={};
  //Expected output: []
  double[][] inputArray3 ={{}};
  //Expected output: [[]]
  double[][] inputArray4 = {{9.7,17.1},{15.8},{12.7, 18.5, 21.27}};
  //Expected output: [9.7, 12.7, 15.8, 17.1, 18.5, 21.27]
  KLists kl = new KLists(inputArray1);
  System.out.println(kl);
  KLists kl1 = new KLists(inputArray4);
  System.out.println(kl1);
  //System.out.println();
  }
  
}