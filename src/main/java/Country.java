public class Country {
    private String code;
    private String name;
    private long population;

    public Country(String code, String name, long population) {
        this.code = code;
        this.name = name;
        this.population = population;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public long getPopulation() {
        return population;
    }

}
