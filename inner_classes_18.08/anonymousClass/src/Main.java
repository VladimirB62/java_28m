public class Main {
    public static void main(String[] args) {
        String str = "Hello all";
        StringTransformer t1 = new ToUpperCaseTransformer();
        StringTransformer t2 = new AddBracketsTransformer();

        StringTransformer addLineTransformer = new StringTransformer() {
            public void print(){
                System.out.println("kghgyyljkh");
            }
            {
                for (int i = 0; i < 3; i++){
                    System.out.println("Hello from addLine");
                }
            }

            @Override
            public String transform(String str) {
                return "-------"+str+"---------";
            }
        };

        str = strHandler(str,t1);
        str = strHandler(str,t2);
        str = strHandler(str,addLineTransformer);
        System.out.println(str);

        System.out.println(
                strHandler(str,new StringTransformer(){

                    @Override
                    public String transform(String str) {
                        return str.substring(5);
                    }
                })
        );
    }

    public static String strHandler(String s, StringTransformer transformer) {
        return transformer.transform((s));
    }
}
