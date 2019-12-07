package story.activity.factory;

import story.activity.Activity;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActivityFactory implements IActivityFactory {
    private final String activitiesPackageName = "story.activity.";


    @Override
    public List<Activity> create(List<String> activitiesNames, String... requirements) {
        return new ArrayList<Activity>() {{
            activitiesNames.forEach(activityName -> {
                try {
                    Class<?> clazz = Class.forName(activitiesPackageName + activityName);
                    Constructor<?> constructor = clazz.getConstructor(String.class, String[].class);
                    add((Activity) constructor.newInstance(activityName, requirements));
                } catch (InvocationTargetException | NoSuchMethodException |
                        ClassNotFoundException | IllegalAccessException | InstantiationException exception) {
                    exception.printStackTrace();
                    System.exit(1);
                }
            });
        }};
    }
}
