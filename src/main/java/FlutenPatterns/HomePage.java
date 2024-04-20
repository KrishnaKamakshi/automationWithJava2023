package FlutenPatterns;

public class HomePage {
    public HomePage search(String search){
        System.out.println("Searched" + search);
        return this;
    }

    public HomePage applyBrandFiler(String brand){
        System.out.println("Filter applied" + brand);
        return this;
    }
}
