package AndroidPage;

import HomePage.HomePage;

public class AndroidPageHome implements HomePage {
    @Override
    public void selectMovies() {
        System.out.println("Android Selected Movies");
    }

    @Override
    public void searchEvents(String events) {
        System.out.println("Android Events selected " + events);

    }
}
