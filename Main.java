import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addlast(10);
        list.addlast(20);
        list.addlast(30);
        list.addfirst(23);
        /*System.out.println(list.indexOf(23));
        System.out.println(list.contains(23));*/

        //list.removefirst();
        //list.removelast();
        System.out.println(list.size());
        int[] array = list.toArray(list);

        System.out.println(Arrays.toString(array));
        //list.reverse();
        //array = list.toArray(list);
        System.out.println(Arrays.toString(array));
        System.out.println(list.getKthFromTheEnd(5));
    }
}
