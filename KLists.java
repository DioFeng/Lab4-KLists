import java.util.ArrayList;
import java.util.*;
public class KLists
{
  private ArrayList<Double> sample = new ArrayList<Double>();
  private ArrayList<ArrayList<Double>> nullArr = new ArrayList<ArrayList<Double>>();
 // private double[] nullArr = {};
  private double[] output;


  public double[] mergeKLists (double [][] outerArray)
  {
  	doThis(outerArray);
  	merge(combineList(outerArray));// return a list of all number put in(without sort)
  	return output;
  	
  }
  public boolean ifEmpty()
  {
  	
  	return nullArr.isEmpty();
  }
  public void doThis(double[][]arr)
  {
  	for(int i = 0; i<arr.length;i++)
    {
        nullArr.add(new ArrayList<Double>());
    
      for (int j = 0; j<arr[i].length;j++)
      { 
        nullArr.get(i).add(arr[i][j]); 
      }
  	}
  }
  public double[] combineList(double [][] input)
  {
  	for(int i = 0; i<input.length;i++)
    {
      for (int j = 0; j<input[i].length;j++)
      {       
        sample.add(input[i][j]);      
      }
    }

    double[] list = new double[sample.size()];
    System.out.println(sample);

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

  	merge(first);
  	merge(second);
  	mergeSortLists(first, second, list);
  }
  
  public void mergeSortLists(double[]first,double[]second,double[]list)
  {
  	int fir = 0;
  	int sec = 0;
  	int position = 0;
  	//output = new double[list.length];
	while(fir<first.length && sec<second.length)
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

	while(fir<first.length)
	{
		list[position++]=first[fir++];	
	}

	while(sec<second.length)
	{
		list[position++]=second[sec++];
	}

	output = Arrays.copyOfRange(list,0,list.length);

  }

  public String toString()
  {
    if(ifEmpty())
    {
    	System.out.println("1");
    }
    String result = "[";
    for(int i = 0; i<output.length;i++)
      result+=output[i]+" ";
  	result+="]";
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

  KLists kl = new KLists();
  kl.mergeKLists(inputArray1);
  System.out.println("Output: "+kl.toString());
  
  KLists kl1 = new KLists();
  kl1.mergeKLists(inputArray3);
  //System.out.println("Output: "+kl1.toString());
  // KLists kl1 = new KLists(inputArray4);
  // System.out.println(kl1);
  //System.out.println();
  }
  
}