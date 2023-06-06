import java.util.ArrayList;
public class apcsarequirements {
    public void callItself(){
        callItself();
    }
    public int callItself(int x){
        if(x == 0 || x == 1){
            return x;
        }
        return callItself(x);
    }
    public void recursivelyTraversesString(String s){
        if(s.length() == 0){
            return;
        }
        System.out.println(s.charAt(0));
        recursivelyTraversesString(s.substring(1));
    }
    public void recursivelyTraverseArrayList(ArrayList<String> a){
        if(a.size() == 0){
            return;
        }
        System.out.println(a.get(0));
        a.remove(0);
        recursivelyTraverseArrayList(a);
    }
    public void sortArrayUsingMergeSort(int[] a){
        if(a.length == 1){
            return;
        }
        int[] left = new int[a.length/2];
        int[] right = new int[a.length - left.length];
        for(int i = 0; i < left.length; i++){
            left[i] = a[i];
        }
        for(int i = 0; i < right.length; i++){
            right[i] = a[i + left.length];
        }
        sortArrayUsingMergeSort(left);
        sortArrayUsingMergeSort(right);
        merge(left, right, a);
    }
    public void merge(int[] left, int[] right, int[] a){
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                a[k] = left[i];
                i++;
            }
            else{
                a[k] = right[j];
                j++;
            }
            k++;
        }
        while(i < left.length){
            a[k] = left[i];
            i++;
            k++;
        }
        while(j < right.length){
            a[k] = right[j];
            j++;
            k++;
        }
    }
    public int binarySearch(){
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int x = 5;
        int low = 0;
        int high = a.length - 1;
        while(low <= high){
            int mid = (low + high)/2;
            if(a[mid] == x){
                return mid;
            }
            else if(a[mid] < x){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
    public void createBeauty(){
        System.out.println("Beauty");
    }
}
