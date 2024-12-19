import java.util.*;

// Користувацька узагальнена колекція, яка реалізує інтерфейс Set
// і використовує двозв'язний список як внутрішню структуру.
// з параметром <E> - тип елементів, що зберігаються в цій колекції

public class CustomLinkedSet<E> implements Set<E> {

    // Внутрішній двозв'язний список для зберігання елементів.
    private final LinkedList<E> elements;

    // Конструктор за замовчуванням, який створює порожній CustomLinkedSet.
    public CustomLinkedSet() {
        this.elements = new LinkedList<>();
    }

    // Конструктор, який ініціалізує CustomLinkedSet одним елементом.
// з параметром element - початковий елемент для додавання
    public CustomLinkedSet(E element) {
        this();
        add(element);
    }

    // Конструктор, який ініціалізує CustomLinkedSet колекцією елементів.
// з параметром collection - колекція елементів для додавання
    public CustomLinkedSet(Collection<? extends E> collection) {
        this();
        addAll(collection);
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return elements.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return elements.iterator();
    }

    @Override
    public Object[] toArray() {
        return elements.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return elements.toArray(a);
    }

    @Override
    public boolean add(E e) {
        if (!elements.contains(e)) {
            elements.add(e);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return elements.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return elements.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c) {
            if (add(e)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return elements.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return elements.removeAll(c);
    }

    @Override
    public void clear() {
        elements.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Set)) return false;
        Set<?> other = (Set<?>) o;
        return elements.containsAll(other) && other.containsAll(elements);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (E e : elements) {
            hash += (e == null ? 0 : e.hashCode());
        }
        return hash;
    }


    // Головний метод для демонстрації та тестування
    public static void main(String[] args) {
        // Створення порожнього CustomLinkedSet
        CustomLinkedSet<Integer> set1 = new CustomLinkedSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("Set 1: " + set1);

        // Створення CustomLinkedSet з одним елементом
        CustomLinkedSet<String> set2 = new CustomLinkedSet<>("Hello");
        System.out.println("Set 2: " + set2);

        // Створення CustomLinkedSet з колекції
        List<Integer> initialList = Arrays.asList(3, 4, 5, 6);
        CustomLinkedSet<Integer> set3 = new CustomLinkedSet<>(initialList);
        System.out.println("Set 3: " + set3);

        // Демонстрація операцій над множинами
        set3.add(7);
        set3.remove(4);
        System.out.println("Modified Set 3: " + set3);
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
