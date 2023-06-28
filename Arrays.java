public class Arrays {
    public static void main(String[] args) {
        int[] a={1,2,5,5,5,2,1,5,5} ;
        System.out.println(Majorelement(a));
    }

    static int Majorelement(int a[]){
        int j=0,c=1;
        for (int i = 0; i < a.length; i++) {
            if(a[i]==a[j]) c++;
            else c--;
            if(c==0){
                j=a[i];
                c=1;
            }
        }
        return j;
    }
}
