package environment;

import java.io.PrintStream;
import java.util.List;

public abstract class Environment {
    protected String name;
    protected List<Environment> environmentalObjects;


    public Environment(String name) {
        this.name = name;
    }

    public Environment(String name, List<Environment> environmentalObjects) {
        this.name = name;
        this.environmentalObjects = environmentalObjects;
    }


    public void addEnvironmentalObject(Environment environmentalObject) {
        if (environmentalObject != null) {
            environmentalObjects.add(environmentalObject);
        }
    }


    public abstract void printInfo(PrintStream printStream);
}
