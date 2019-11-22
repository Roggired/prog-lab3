package story.reason;

import story.characteristic.Characteristic;

import java.util.List;

public class ReasonBasedOnCharacterisedActivity extends Reason {
    private List<ActivityNameCharacteristicPair> activityNameCharacteristicPairs;


    public ReasonBasedOnCharacterisedActivity(List<? extends IReasonProducer> reasonProducers,
                                              String preposition,
                                              List<ActivityNameCharacteristicPair> activityNameCharacteristicPairs) {
        super(reasonProducers, preposition);
        this.activityNameCharacteristicPairs = activityNameCharacteristicPairs;
    }

    @Override
    public String getDescription() {
        return preposition + " " + createReasonProducersDescription() + " " + createActivitiesDescription();
    }

    private String createActivitiesDescription() {
        StringBuilder stringBuilder = new StringBuilder();
        activityNameCharacteristicPairs.forEach(activityNameCharacteristicPair -> {
            stringBuilder.append(activityNameCharacteristicPair.characteristic.getName());
            stringBuilder.append(" ");
            stringBuilder.append(activityNameCharacteristicPair.activityName);
            stringBuilder.append(" ");
        });

        return stringBuilder.toString();
    }

    public static class ActivityNameCharacteristicPair {
        private String activityName;
        private Characteristic characteristic;

        public ActivityNameCharacteristicPair(String activityName,
                                              Characteristic characteristic) {
            this.activityName = activityName;
            this.characteristic = characteristic;
        }
    }
}
