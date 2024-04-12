package javaPrograms;

public class ThirdLargestNumberInAnArray {
    public static void main(String args[]){
        int temp, size;
        int array[] = {10, 2, 5, 6333, 16, 37};
        size = array.length;

        for(int i = 0; i<size; i++ ){
            for(int j = i+1; j<size; j++){
                if(array[i]>array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println("Third second largest number is:: "+array[size-2]);
    }
}