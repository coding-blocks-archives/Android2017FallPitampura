package in.championswimmer;

/**
 * Created by championswimmer on 13/08/17.
 */
public class Interfaces {

    interface EdibleInterface {
        String howToEat();
        String howToCook();
    }


    static class Mango {
        private EdibleInterface ei;
        public EdibleInterface getEi () {
            return ei;
        }

        public void setEi(EdibleInterface edInt) {
            this.ei = edInt;
        }
    }

    public static void main(String[] args) {

        EdibleInterface pickledInterface = new EdibleInterface() {
            @Override
            public String howToEat() {
                return "raw";
            }

            @Override
            public String howToCook() {
                return "pickle";
            }
        };

        Mango m = new Mango();
//        m.setEi(pickledInterface);
//
//        m.getEi().howToCook();


    }
}
