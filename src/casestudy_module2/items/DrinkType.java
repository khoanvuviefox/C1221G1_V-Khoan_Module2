package casestudy_module2.items;

public enum DrinkType {
    CAFE("CAFE"),
    TEA("TEA"),
    YOGURT("YOGURT"),
    JUICE("JUICE"),
    OTHER("OTHER");

    private String value;

    DrinkType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static DrinkType parseDrinkType(String value) {
        DrinkType[] values = values();
        for (DrinkType drinkType : values) {
            if (drinkType.value.equals(value))
                return drinkType;
        }
        throw new IllegalArgumentException("invalid");
    }
}
