package story.characteristic;

import story.characteristic.reason.Reason;

public class Characteristic {
    private String name;
    private Reason reason;


    public Characteristic(String name,
                          Reason reason) {
        this.name = name;
        this.reason = reason;
    }


    public String getName() {
        if (reason == null) {
            return name;
        }

        return name + ", " + reason.getDescription();
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
