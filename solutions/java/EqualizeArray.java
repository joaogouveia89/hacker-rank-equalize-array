public class EqualizeArray{
	static int equalizeArray(int[] arr) {
        Arrays.sort(arr);
        int lastEl = 0; // as the lower constraint is 1 we can set the first to 0
        int biggerCount = 0;
        int currentCount = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(i == 0){
                lastEl = arr[i];
                currentCount = 1;
                continue;
            }
            
            if(arr[i] == lastEl){
                currentCount++;
                if(i == arr.length - 1 && biggerCount < currentCount){
                    biggerCount = currentCount;
                }
            }else{
                if(biggerCount < currentCount){
                    biggerCount = currentCount;
                }
                lastEl = arr[i];
                currentCount = 1;
            }
        }
        return arr.length - biggerCount;
    }
}