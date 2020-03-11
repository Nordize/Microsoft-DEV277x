import java.util.ArrayList;

public class test2 {

    public static void main(String []args){
        System.out.println("Hello World");

        ArrayList<Integer> list1 = new ArrayList();
        list1.add(72);
        list1.add(20);

        ArrayList<Integer> list2 = new ArrayList();
        list2.add(1);  //0
        list2.add(2); //1
        list2.add(3); //2
        list2.add(4); //3
        list2.add(5); //4
        list2.add(6); //5


        mystery3(list2);


    }

    public static void mystery3(ArrayList<Integer> list){
        for(int i =list.size() -2;i>0;i--){
            int a= list.get(i);
            int b = list.get(i+1);
            list.set(i,a+b);
        }
        System.out.println(list);
    }
}
