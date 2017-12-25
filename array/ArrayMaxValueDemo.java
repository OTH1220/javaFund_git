class ArrayMaxValueDemo{

	public static void main(String args[]){

		int[] array1 = new int[]{4,6,8,7,1,3,9,1,36,468,98,681,1,98,89,4,198,91,91};
		int[] array2 = new int[]{-36,-468,-98,-681,-78914,-98,-89,-198,-91,-91};

		System.out.println("Largest Elemetn in the Array1 is:"+getMax(array1));
		System.out.println("Largest Element in the Array2 is:"+getMin(array2));
	}

	public static int getMax(int[] arr){
			int largestElementInArray = arr[0];

			for(int i=1; i<arr.length; i++){
				if(arr[i]>largestElementInArray)
					largestElementInArray = arr[i];
			}
			return largestElementInArray;
	}

	public static int getMin(int[] arr){
		int smallestElementIndexInArray = 0;

		for(int i=1; i<=arr.length-1; i++){
			if(arr[i]<arr[smallestElementIndexInArray])
				smallestElementIndexInArray = i;
		}

		return arr[smallestElementIndexInArray];
	}
}