package casestudy_module2.function;

import casestudy_module2.items.Drink;
import casestudy_module2.ulits.CSVUtils;

import java.util.ArrayList;
import java.util.List;

public class DrinkService implements IDrinkService {
        List<Drink> drinks = new ArrayList<>();
        public static String path = "CS2/data/drinks.csv";

        public DrinkService() {
            getDrinks();
        }

        @Override
        public List<Drink> getDrinks() {
            List<Drink> newDrinks = new ArrayList<>();
            List<String> records = CSVUtils.read(path);
            for (String record : records) {
                newDrinks.add(new Drink(record));
            }
            return drinks = newDrinks;
        }

        @Override
        public void add(Drink newDrink) {
            drinks.add(newDrink);
            CSVUtils.write(path, drinks);
        }

        @Override
        public void update() {
            CSVUtils.write(path, drinks);
        }

        @Override
        public Drink getDrinkById(String id) {
            for (Drink drink : drinks) {
                if (drink.getDrink_id().equalsIgnoreCase(id))
                    return drink;
            }
            return null;
        }

        @Override
        public Drink getDrinkByName(String name) {
            for (Drink drink : drinks) {
                if (drink.getDrink_name().equalsIgnoreCase(name))
                    return drink;
            }
            return null;
        }

        @Override
        public boolean exist(String id) {
            return getDrinkById(id) != null;
        }

        @Override
        public boolean checkDuplicateId(String id) {
            for (Drink drink : drinks) {
                if (drink.getDrink_id().equalsIgnoreCase(id))
                    return true;
            }
            return false;
        }

        @Override
        public boolean checkDuplicateName(String name) {
            for (Drink drink : drinks) {
                if (drink.getDrink_name().equals(name))
                    return true;
            }
            return false;
        }

        @Override
        public void remove(Drink drink) {
            drinks.remove(drink);
            update();
        }
    }
