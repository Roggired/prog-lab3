package activity.factory;

import activity.IActivity;

import java.util.ArrayList;
import java.util.List;

public class JSONActivityFactory implements IActivityFactory {
    private final String activitiesPackageName = "activity.";


    @Override
    public List<IActivity> create(List<String> activitiesNames) {
        return new ArrayList<IActivity>() {{
            activitiesNames.forEach(string -> {
                try {
                    IActivity activity = (IActivity) Class.forName(activitiesPackageName + string).newInstance();
                    add(activity);
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException exception) {
                    exception.printStackTrace();
                    System.exit(1);
                }
            });
        }};
    }
}
