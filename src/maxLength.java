import java.util.ArrayList;

public class maxLength {

    public static void main(String[] args){

        ArrayList<String> list1 = new ArrayList();

        list1.add("Hello");
        list1.add("Worldddd");
        list1.add("");

        System.out.println(maxLength(list1));
        //maxLength(list1);
    }

    public static int maxLength(ArrayList<String> list){
        int longest =0;

        for(int i=0;i<list.size();i++){
            String a = list.get(i);

            int b = a.length();
            //System.out.println(b);

            if (b > longest){
                longest =b;
            }


        }
        return longest;

    }


}
