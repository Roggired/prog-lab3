package story.characteristic;

import story.characteristic.reason.Reason;

import java.util.ArrayList;
import java.util.List;

public class Characteristic {
    private String name;
    private List<Reason> reasons;


    public Characteristic(String name) {
        this.name = name;
        reasons = null;
    }

    public Characteristic(String name,
                          List<Reason> reasons) {
        this.name = name;
        this.reasons = reasons;
    }

    public Characteristic(String name,
                          Reason reason) {
        this.name = name;
        reasons = new ArrayList<>();
        reasons.add(reason);
    }


    public String getName() {
        if (reasons == null) {
            return name;
        }

        if (!reasons.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder(name + " ");
            reasons.forEach(reason -> stringBuilder.append(reason.getDescription()).append(" "));

            return stringBuilder.toString();
        }

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
