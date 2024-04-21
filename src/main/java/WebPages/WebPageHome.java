package WebPages;

import HomePage.HomePage;

public class WebPageHome implements HomePage {
    @Override
    public void selectMovies() {
        System.out.println("Selected Movies from Web");
    }

    @Override
    public void searchEvents(String events) {
        System.out.println("Events selected from Web " + events);

    }
}
