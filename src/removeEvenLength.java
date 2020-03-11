import java.util.ArrayList;

public class removeEvenLength {

    public static void main(String[] args){

        ArrayList<String> list1 = new ArrayList();

        list1.add("Did");
        list1.add("You");
        list1.add("Solve");
        list1.add("it");
        list1.add("or");
        list1.add("what?");

        removeEvenLength(list1);
        //maxLength(list1);
    }
    public static void removeEvenLength(ArrayList<String> list){


        for(int i=0;i<list.size();i++){
            String a = list.get(i);

            int b = a.length();

            if(b % 2 ==0){
                a = list.remove(i);

            }else {

                System.out.println(a);
            }


        }

    }
}
