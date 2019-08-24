import java.util.Scanner;

public class GenericsDriver 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		// The Integer class is a wrapper class that wraps the primitive ints as objects.
		// Integer test
		Integer[] nums = new Integer[4];
		nums[0] = 6;
		nums[1] = 4;
		nums[2] = 3;
		nums[3] = 1;
		
		// Before performing linear search on the Integer array
		System.out.println("I will now perform the Integer test.");
		System.out.println("------------------------------------ \n");
		System.out.println("Before I search this array of Integers the current array is.");
		print(nums);
		System.out.println();
		int search = requestInt("What number do you wish to search for?");
		
		Utilities.linearSearch(nums,search);
		
		//String test
		String[] people = new String[4];
		people[0] = "Jim Gaffigan";
		people[1] = "Ezekiel Burk";
		people[2] = "Isaac Hartzell";
		people[3] = "Jeff Somer";
		
		// Before performing linear search on the String array.
		System.out.println("I will now perform the String test.");
		System.out.println("------------------------------------ \n");
		System.out.println("Before I search this array of strings.");
		print(people);
		System.out.println();
		String strSearch = requestString("What name do you wish to search for?");
		
		Utilities.linearSearch(people, strSearch);
		
		//Facebook user objects test.
		FacebookUser[] fbUsers = new FacebookUser[4];
		fbUsers[0] = new FacebookUser("Jeff", "password");
		fbUsers[1] = new FacebookUser("Isaac", "password");
		fbUsers[2] = new FacebookUser("Calvin", "housing");
		fbUsers[3] = new FacebookUser("Zed", "hidden blade");
		
		//Before performing linear search on the facebook user objects array.
		System.out.println("I will now perform the facebook user object test.");
		System.out.println("------------------------------------------------- \n");
		System.out.println("Before I search this array of facebook user objects.");
		System.out.println("Rather than having you choose who to search for I will search for Calvin.");
		print(fbUsers);
		System.out.println();
		FacebookUser testUser2 = fbUsers[2];
		
		Utilities.linearSearch(fbUsers, testUser2);
		
		//Before shuffling the three data type arrays.
		System.out.println("I will now show the three arrays I have. \n");
		print(nums);
		print(people);
		print(fbUsers);
		System.out.println();
		
		// Shuffling the three arrays.
		System.out.println("I will now shuffle all three of the arrays. \n");
		shuffle(nums);
		shuffle(people);
		shuffle(fbUsers);
		System.out.println();
		
		//After shuffling the three arrays.
		System.out.println("I will now reprint the arrays after they've been shuffled. \n");
		print(nums);
		print(people);
		print(fbUsers);
		System.out.println();
		
		// Quick sorting test.
		System.out.println("I will now perform the quick sort tests on the three arrays.");
		Utilities.quickSort(nums);
		print(nums);
		Utilities.quickSort(people);
		print(people);
		Utilities.quickSort(fbUsers);
		print(fbUsers); 
	}	// End of main method.
	
	// This just make input throughout the program cleaner instead of having to keep writing int number1 = userInput.nextInt() and then
	// some Console String output.
	public static int requestInt(String request)
	{
		Scanner userInput = new Scanner(System.in);
		System.out.print(request);
		
		return userInput.nextInt();
	}
	// Same thing as the above method.
	public static String requestString(String stringRequest)
	{
		Scanner userInput = new Scanner(System.in);
		System.out.print(stringRequest);
		
		return userInput.next();
	}
	// I'm passing into this method a general array of type E, where this method prints out my array of 
	// Strings, Integers, and FacebookUser objects.
	public static <E extends Comparable<E>> void print(E[] list) 
	{
		if (list.length == 0)
		{
			return;
		}
		
		int i;
		
		for (i = 0; i < list.length - 1; ++i)
		{
			System.out.print(list[i] + ", ");
		}
		System.out.println(list[i]);
	}
	// I'm passing into this method again a generic array and I shuffle the array
	public static <E extends Comparable<E>> void shuffle(E[] list) 
	{
		// I'm cycling through the array and I assign the element of the list that's passed into the function
		// a generic variable temp.
		// I assign this list to the randomized list j which is the list, or array of whatever data type I'm using
		// Then this list with element j is assignined to the generic variable temp.
		for (int i = 0; i < list.length; i++) 
		{
			
			int j = (int) (Math.random() * list.length);
			E temp = list[i];
			list[i] = list[j];
			list[j] = temp;
		}
	}	
}	// End of driver class.
