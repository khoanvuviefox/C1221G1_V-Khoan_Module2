package casestudy_module2.function;

import casestudy_module2.items.Drink;

import java.util.List;

public interface IDrinkService {
    List<Drink> getDrinks();

    void add(Drink newDrink);

    void update();

    Drink getDrinkById(String id);

    Drink getDrinkByName(String name);

    boolean exist(String id);

    boolean checkDuplicateId(String id);

    boolean checkDuplicateName(String name);

    void remove(Drink drink);

}
