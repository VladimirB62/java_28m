public class Main {
    public static void main(String[] args) {
        BuilderExample test = new BuilderExample.Builder(10,20)
                .param3(30)
                .param5(50)
                .build();

        System.out.println(test);
    }
}
