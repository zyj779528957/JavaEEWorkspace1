import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Aeyjie on 2017-05-02.
 */
public class Test {

    public static void main(String[] args){
        String s="1-2-3-4";

        String[] pids = s.split("-");
        List<String> asList = Arrays.asList(pids);
        LinkedList<String> strings = new LinkedList<>(asList);
        if(strings.contains("2")){
            System.out.println(strings);
            strings.remove("2");
        }
        strings.addFirst("6");

        System.out.println(strings);
    }
}
