import java.util.ArrayList;

public class ArrayListMystery2 {

    public static void main(String[] args){

        ArrayList<Integer> list1 = new ArrayList();

        list1.add(8);
        list1.add(2);
        list1.add(9);
        list1.add(7);
        list1.add(4);

        mystery2(list1);

    }

    public static void mystery2(ArrayList<Integer> list){
        for(int i = list.size() -1 ;i>=0; i--){
            if(i%2 ==0){
                list.add(list.get(i));
            }else{
                list.add(0,list.get(i));
            }
        }
        System.out.println(list);
    }


}
