import java.util.ArrayList;

public class Utilities 
{
	// This method returns a generic array list of type (T) which is kind of like a variable but not exactly
	// What this allows me to be able to do is with ease in the driver be able to use these two method
	// for the data type. Where as usually you have to design method for floats and doubles and integers, ect.
	public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list)
	{
		ArrayList<T> usedList = new ArrayList<T>();
		ArrayList<T> newList = new ArrayList<T>();
		for(int i = 0; i < list.size(); i++)
		{
			T obj = list.get(i);
			
			if(!usedList.contains(obj))
			{
				usedList.add(obj);
				newList.add(obj);
			}
		}
		return newList;
	}
	
	// I'm passing into this method a generic array and a generic key.
	// The key is what you're searching for. This also extends Comparable to compare different data types.
	public static <T extends Comparable <T>> int linearSearch(T[] searchList, T key)
	{
		System.out.println("Looking for " + key.toString());
		// I cycle through the array and if the index of the search equals the key then the value has been found.
		// Otherwise I return -1 which means it failed.
		for(int i = 0; i <searchList.length; i++)
		{
			System.out.println("Testing " + searchList[i].toString());
			if(searchList[i].equals(key))
			{
				System.out.println("It's a match!");
				System.out.println();
				return i;
			}
		}
		// -1 means that the case failed basically, 0 or 1 means it goes through.
		System.out.println("No match.");
		System.out.println();
		return -1;
	}
	
	public static <E extends Comparable<E>> void quickSort(E[] list) 
	{
		if (list == null || list.length == 0)
		{
			return;
		}
		// I'm calling for the other quickSort method, it's kind of like an overloaded method.
		quickSort(list, 0, list.length - 1);
	}
	
	// I'm passing into this method a generic array, a low point, and a high point.
	private static <E extends Comparable<E>> void quickSort(E[] list, int low, int high) 
	{
		if (low >= high)
		{
			// nothing
			return;
		}
		E pivot;
		
		if (high - low == 0 || high - low == 1)
		{
			pivot = list[low];
		}
		else
		{
			pivot = list[low + 1];
		}
		print(pivot, list, low, high);
		
		int i = low, j = high;
		
		while (i <= j) 
		{
			while (list[i].compareTo(pivot) < 0) 
			{
				i++;
			}

			while (list[j].compareTo(pivot) > 0) 
			{
				j--;
			}

			if (i <= j) 
			{
				E temp = list[i];
				list[i] = list[j];
				list[j] = temp;
				i++;
				j--;
			}
		}
		
		if (low < j)
		{
			quickSort(list, low, j);
		}

		if (high > i)
		{
			quickSort(list, i, high);
		}
	}

	private static <E extends Comparable<E>> void print(E pivot, E[] list, int low, int high) 
	{
		if (list.length == 0) // if list is empty
		{
			// nothing
			return;
		}
		System.out.println();
		System.out.print("Generic array: ");
		int i;
		
		for (i = low; i < high; ++i)
		{
			System.out.print(list[i] + ", ");
		}
		
		System.out.println(list[i]);
		System.out.println("Pivot: " + pivot);
	}
}

