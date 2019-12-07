package story.activity;

public final class WantToGoFurther extends Activity{
    public WantToGoFurther(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result){
        result += "хотел было пройти дальше";

        return result;
    }
}
