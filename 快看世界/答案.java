public class test {
    public static void main(String[] args) {
        int[] L = {7,0,1,2,3,4,5,6};
        int p = 3;
        System.out.println(findIndex(L, p));
    }
    public static int findIndex(int[] L, int x){
        int bt = 0;
        int h = 0;
        int t = L.length - 1;
        while(t - h != 1){
            //判断是不是第一个元素
            if(L[h] == x){
                return h;
            }
            //判断是不是最后一个元素
            if(L[t] == x){
                return t;
            }
            bt = (h+t)/2;
            //拐点在下面
            if(L[bt] < L[t] && L[h] > L[t]){
                if(x > L[t] || x < L[bt]){
                    t = bt;
                }else{
                    h = bt;
                }
            }else if((L[bt] > L[h] && L[h] < L[t]) || (L[bt] < L[t] && L[h] < L[t])){ // 递增的情况
                if(x > L[bt]){
                    h = bt;
                }else if(x < L[bt]){
                    t = bt;
                }else{
                    break;
                }
            }else if(L[bt] >L[h] && L[h] > L[t]){ //拐点在上面
                if(x <= L[t] || x > L[bt]){
                    h = bt;
                }else if(x == L[bt]){
                    break;
                }else{
                    t = bt;
                }
            }
        }
        if(L[bt] != x){
            return -1;
        }
        return bt;
    }
}