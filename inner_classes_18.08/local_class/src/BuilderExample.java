public class BuilderExample {
    private final int param1;//nessesary
    private final int param2;//nessesary
    private final int param3;
    private final int param4;
    private final int param5;
    private final int param6;

    public static class Builder{
        private int param1;
        private int param2;
        private int param3 = 0;
        private int param4 = 0;
        private int param5 = 0;
        private int param6 = 0;

        public Builder(int param1, int param2) {
            this.param1 = param1;
            this.param2 = param2;
        }

        public Builder param3(int param3){
            this.param3 = param3;
            return this;
        }

        public Builder param4(int param4){
            this.param4 = param4;
            return this;
        }

        public Builder param5(int param5){
            this.param5 = param5;
            return this;
        }

        public Builder param6(int param6){
            this.param6 = param6;
            return this;
        }

        public BuilderExample build() {return new BuilderExample(this);}
    }

    private BuilderExample(Builder builder) {
        this.param1 = builder.param1;
        this.param2 = builder.param2;
        this.param3 = builder.param3;
        this.param4 = builder.param4;
        this.param5 = builder.param5;
        this.param6 = builder.param6;
    }

    @Override
    public String toString() {
        return "BuilderExample{" +
                "param1=" + param1 +
                ", param2=" + param2 +
                ", param3=" + param3 +
                ", param4=" + param4 +
                ", param5=" + param5 +
                ", param6=" + param6 +
                '}';
    }
}
