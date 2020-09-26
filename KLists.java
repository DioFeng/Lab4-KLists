import java.util.ArrayList;
import java.util.*;
public class KLists
{
  private ArrayList<Double> sample;
  private static ArrayList<ArrayList<Double>> nullArr;
  private double[] output;

  public double[] mergeKLists (double [][] outerArray)
  {
      nullArr = new ArrayList<ArrayList<Double>>();
      for(int i=0;i<outerArray.length;i++)
      {
        nullArr.add(new ArrayList<Double>());
        for(int j =0; j<outerArray[i].length;j++)
        {
          nullArr.get(i).add(outerArray[i][j]);
        }
      }

  	merge(combineList(outerArray));// return a list of all number put in(without sort)
  	return output;
  	
  }
  public double[] combineList(double [][] input)
  {
    //change 2d double array into a single double array
    sample = new ArrayList<Double>();
  	for(int i = 0; i<input.length;i++)
    {
      for (int j = 0; j<input[i].length;j++)
      {       
        sample.add(input[i][j]);      
      }
    }

    double[] list = new double[sample.size()];
    System.out.println("Input: "+sample);

  	for(int h =0; h<sample.size();h++)
  		list[h]=sample.get(h);

  	return list;
  }

  public void merge(double[] list)
  {
  	int length = list.length;

  	if(length<=1)
  		return;

  	double[] first = Arrays.copyOfRange(list,0,length/2);
  	double[] second = Arrays.copyOfRange(list,length/2,length);

  	merge(first);//divide
  	merge(second);//divide
  	mergeSortLists(first, second, list); //merge
  }
  
  public void mergeSortLists(double[]first,double[]second,double[]list)
  {
  	int fir = 0;//element in first array
  	int sec = 0;//element in second array
  	int position = 0;//index of the altering array

      while(fir<first.length && sec<second.length)//compare elements
      {

      	if(first[fir]<second[sec])
      	{
      		list[position++]=first[fir++];
      	}
      	else
      	{
      		list[position++]=second[sec++];
      	}	
      }

      while(fir<first.length) //paste rest of the remain elements in first array
      {
      	list[position++]=first[fir++];	
      }

      while(sec<second.length)// //paste rest of the remain elements in second array
      {
      	list[position++]=second[sec++];
      }

      output = Arrays.copyOfRange(list,0,list.length);//copy array

      }

  public static void toString(double[] arr)
  {
    //check input if is null
    if(nullArr.isEmpty()||nullArr.get(0).isEmpty())
    {
      System.out.println("No Output: "+nullArr);
    }
  
    else
    {
      String result = "[";
      for(int i = 0; i<arr.length;i++)
      {
        result+=arr[i]+" ";
      }
      result+="]";
      System.out.println("Output: "+result);
    }
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

  KLists kl = new KLists();
  toString(kl.mergeKLists(inputArray1));
  toString(kl.mergeKLists(inputArray2));
  toString(kl.mergeKLists(inputArray3));
  toString(kl.mergeKLists(inputArray4));
  //kl1.doThis(mergeKLists(inputArray3));
   //System.out.println("Output: "+kl1.mergeKLists(inputArray3).toString());
  //System.out.println("Output: "+kl1.toString());
  // KLists kl1 = new KLists(inputArray4);
  // System.out.println(kl1);
  //System.out.println();
  }
  
}