import java.util.StringJoiner;

public class test {
    public static void main(String[] args) {
        String test = "cd ..; ls -al";
        String input = "cd ..; ls -al";
        StringJoiner sj = new StringJoiner("###");
        for (char c : input.toCharArray()) {
            sj.add(String.valueOf(c));
        }
        System.out.println(sj);

        input = sj.toString().replace("###","").trim();
        System.out.println(input);

        if(test.equals(input)){
            System.out.println("test is equal");
        }


    }
}
