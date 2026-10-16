
public class FinallyDemo {

    static int basic() {
        try {
            System.out.println("in try");
            return 1;
        } finally {
            System.out.println("in finally");        // still runs before the method exits
        }
    }

    static int changedAfterReturn() {
        int x = 1;
        try {
            return x;                                // value 1 is saved here
        } finally {
            x = 2;                                   // changes the variable, not the saved value
        }
    }

    @SuppressWarnings("finally")
    static int overridden() {
        try {
            return 1;
        } finally {
            return 2;                                // a return in finally REPLACES the earlier one
        }
    }

    public static void main(String[] args) {
        System.out.println("basic() = " + basic());
        System.out.println("changedAfterReturn() = " + changedAfterReturn());
        System.out.println("overridden() = " + overridden());
    }
}