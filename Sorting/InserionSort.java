public class InserionSort{
    public static void main(String[] args) {
        int i=0,j=i+1;
        int a[] = {2,3,4,1,5};
        while(j!=a.length-1){
            for(;i>0;i--){
                if(a[j]>a[i]){
                    int k=i+1;
                    while(k==j){
                        int temp = a[k+1];
                        a[k+1] = a[k];
                        a[k] = temp;
                        k++;
                    }
                    break;
                }
            }
        }
    }
}