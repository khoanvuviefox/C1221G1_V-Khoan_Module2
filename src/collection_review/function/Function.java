package collection_review.function;

public interface Function <E>{
    void add(E object);
    void edit();
    void remove();
    void display();
    boolean searchByName(String name);
}
