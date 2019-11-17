package story.characteristic;

public class Characteristic {
    private String name;


    public Characteristic(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (!(object instanceof Characteristic)) {
            return false;
        }

        if (!name.equals(((Characteristic) object).name)) {
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
