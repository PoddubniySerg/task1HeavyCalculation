package server;

public class FibCalculator {
    public long getFibValue(int index) {
        switch (index) {
            case 0:
                return 0;
            case 1:
            case -1:
                return 1;
            default:
                int absIndex = index < 0 ? Math.abs(index) : index;
                long pre = 0;
                long post = 1;
                long result = 0;
                for (int i = 2; i <= absIndex; i++) {
                    result = pre + post;
                    pre = post;
                    post = result;
                }
                if (index < 0 & index % 2 == 0) return (-1) * result;
                return result;
        }
    }
}
