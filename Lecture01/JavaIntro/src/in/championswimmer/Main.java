package in.championswimmer;

public class Main {

    static class Fruit {
        private String getOrigin () {
            return "Lucknow";
        }
    }
    static class Mango extends Fruit {
        String getTaste () {
            return "sweet";
        }
    }

    class One {
        One (int a) {}
    }

    class Two extends One {

        Two() {
            super(2);

        }
    }

    class Three extends Two {
    }

    public static void main(String[] args) {
	// write your code here
    }
}
