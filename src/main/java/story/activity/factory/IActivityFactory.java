package story.activity.factory;

import story.activity.IActivity;

import java.util.List;

public interface IActivityFactory {
    List<IActivity> create(List<String> activitiesNames);
}
