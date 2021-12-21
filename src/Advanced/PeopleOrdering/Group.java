package Advanced.PeopleOrdering;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Group<T> {

    List<T> group = new ArrayList<>();
    private Class<T> genericClass;

    public Group(Class<T> cls) {
        this.genericClass = cls;
    }

    public void add(T item) {
        this.group.add(item);
    }

    public void orderBy(String attribute) throws NoSuchFieldException, NonComparableFieldType {
        if (this.group.isEmpty()) return;
        Field comparingField = this.getClassField(attribute);
        Class<?> fieldType = comparingField.getType();
        if (fieldType.isAssignableFrom(Comparable.class)) throw new NonComparableFieldType();
        this.group = this.group.stream()
            .sorted((itemA, itemB) -> {
                try {
                    Comparable valueA = (Comparable) comparingField.get(itemA);
                    var valueB = comparingField.get(itemB);
                    return valueA.compareTo(valueB);
                } catch (IllegalAccessException e) {
                    return 0;
                }
            })
            .collect(Collectors.toList());
    }

    private Field getClassField(String fieldName) throws NoSuchFieldException {
        return this.genericClass.getDeclaredField(fieldName);
    }

}

class NonComparableFieldType extends Exception {

    public NonComparableFieldType() {
        super("Given field type is not Comparable");
    }
}
