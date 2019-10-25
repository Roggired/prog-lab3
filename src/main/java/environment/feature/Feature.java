package environment.feature;

import com.google.inject.Inject;

public class Feature {
    private String name;


    @Inject
    public Feature(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
}
