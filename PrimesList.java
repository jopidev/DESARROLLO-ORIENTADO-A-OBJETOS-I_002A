import java.util.ArrayList;

public class PrimesList extends ArrayList<Integer> {
    public boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }

    @Override
    public boolean add(Integer number) {
        if (!isPrime(number)) {
            throw new IllegalArgumentException("Número no primo: " + number);
        }
        return super.add(number);
    }

    @Override
    public Integer remove(int index) {
        return super.remove(index);
    }

    public int getPrimesCount() {
        return size();
    }
}
