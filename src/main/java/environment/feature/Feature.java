package environment.feature;

import java.util.Objects;

public class Feature {
    private String name;

    public Feature(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (!Objects.equals(this, object)) {
            return false;
        }

        if (!name.equals(((Feature) object).name)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return this.getClass().toString() + name;
    }
}
