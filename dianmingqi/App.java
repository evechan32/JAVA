package dianmingqi;

import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) {
        new Login();

    }

    public static void dianming()
    {
        ArrayList<String> dm = new name().namelist();

        ArrayList<Integer> weight = new ArrayList<>();
        List list = new ArrayList();
        weight.add(1);

        for (int i = 0; i < 149; i++) {
            weight.add(2);
        }

       list.addAll(dm);
        Random r = new Random();
        int index = r.nextInt(dm.size());
        System.out.println(dm.get(index));
        int temp = index;

        Collections.swap(list,0,index);

        for (int i = 0; i < 4; i++) {

                index= random(weight);

                System.out.println(list.get(index));
                Collections.swap(list,temp,index);
                temp = index;
            }

    }
    public static int binarysearch(int[] arr, int number) {
        int min = 0;
        int max = arr.length-1;
        int mid = (min+max)/2;
        while (true)
        {
            if (min>max) return -1;
            if (arr[mid]<number)
            {
                min = mid +1 ;
            }
            else if(arr[mid]>number)
            {
                max = mid -1;
            }
            else return min;
            mid = (min+max)/2;
            System.out.println(min+" "+max);
        }
    }
    /**
     * 权重随机数
     * @param weight [15,568,4181,2]
     * @return 索引值
     */
    public static int random(List<Integer> weight){
        List<Integer> weightTmp = new ArrayList<Integer>(weight.size()+1);
        weightTmp.add(0);
        Integer sum = 0;
        for( Integer d : weight ){
            sum += d;//
            weightTmp.add(sum);//1,3,5,7,9,11 0-1,1-3,3-5,5-7,7-9,9-11,
        }
        Random random = new Random();
        int rand = random.nextInt(sum);
        int index = 0;
        /*  rand =4
            rand >weightTmp.get(1) index = 1
            rand =3
            rand =weightTmp.get(1) index =1
            rand = 1
            rand = weightTmp.get(0) index = 0
        */
        for(int i = weightTmp.size()-1; i >0; i--){
            if( rand >= weightTmp.get(i)){
                index = i;
                break;
            }
        }
        return index;
    }

}
