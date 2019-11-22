package story.activity.factory;

import story.activity.Activity;

import java.util.ArrayList;
import java.util.List;

public class JSONActivityFactory implements IActivityFactory {
    private final String activitiesPackageName = "story.activity.";


    @Override
    public List<Activity> create(List<String> activitiesNames) {
        return new ArrayList<Activity>() {{
            activitiesNames.forEach(string -> {
                try {
                    Activity activity = (Activity) Class.forName(activitiesPackageName + string).newInstance();
                    add(activity);
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException exception) {
                    exception.printStackTrace();
                    System.exit(1);
                }
            });
        }};
    }
}
