import java.util.ArrayList;

public class PrimesList extends ArrayList<Integer> {

    @Override
    public boolean add(Integer number) {
        if (!isPrime(number)) {
            throw new IllegalArgumentException("Solo se permiten números primos.");
        }
        return super.add(number);
    }

    @Override
    public void add(int index, Integer number) {
        if (!isPrime(number)) {
            throw new IllegalArgumentException("Solo se permiten números primos.");
        }
        super.add(index, number);
    }

    @Override
    public boolean addAll(java.util.Collection<? extends Integer> c) {
        for (Integer number : c) {
            if (!isPrime(number)) {
                throw new IllegalArgumentException("Todos los elementos deben ser primos.");
            }
        }
        return super.addAll(c);
    }

    @Override
    public boolean addAll(int index, java.util.Collection<? extends Integer> c) {
        for (Integer number : c) {
            if (!isPrime(number)) {
                throw new IllegalArgumentException("Todos los elementos deben ser primos.");
            }
        }
        return super.addAll(index, c);
    }

    @Override
    public Integer set(int index, Integer number) {
        if (!isPrime(number)) {
            throw new IllegalArgumentException("Solo se permiten números primos.");
        }
        return super.set(index, number);
    }

    @Override
    public boolean remove(Object o) {
        if (o instanceof Integer) {
            return super.remove(o);
        }
        return false;
    }

    public boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number <= 3) return true;
        if (number % 2 == 0 || number % 3 == 0) return false;
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) return false;
        }
        return true;
    }

    public int getPrimesCount() {
        return this.size();
    }
}

