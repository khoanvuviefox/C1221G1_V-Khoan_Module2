package casestudy_module2.items;

public class Drink {
    private String drink_id;
    private String drink_name;
    private double price;
    private DrinkType drinkType;

    public Drink() {
    }

    public Drink(String drink_id, String drink_name, double price) {
        this.drink_id = drink_id;
        this.drink_name = drink_name;
        this.price = price;
    }

    public Drink (String draw) {
        String[] fields = draw.split(",");
        drink_id = fields[0];
        drink_name = fields[1];
        price = Double.parseDouble(fields[2]);
        drinkType = DrinkType.parseDrinkType(fields[3]);
    }

    public String getDrink_id() {
        return drink_id;
    }

    public void setDrink_id(String drink_id) {
        this.drink_id = drink_id;
    }

    public String getDrink_name() {
        return drink_name;
    }

    public void setDrink_name(String drink_name) {
        this.drink_name = drink_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "drink_id='" + drink_id + '\'' +
                ", drink_name='" + drink_name + '\'' +
                ", price=" + price +
                ", drink_type=" + drinkType +
                '}';
    }
}
