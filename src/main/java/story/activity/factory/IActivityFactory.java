package story.activity.factory;

import story.activity.Activity;

import java.util.List;

public interface IActivityFactory {
    List<Activity> create(List<String> activitiesNames);
}
