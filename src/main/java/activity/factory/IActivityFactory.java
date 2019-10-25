package activity.factory;

import activity.IActivity;

import java.util.List;

public interface IActivityFactory {
    List<IActivity> create(List<String> activitiesNames);
}
