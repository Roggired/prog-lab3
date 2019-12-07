package story.teller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Injector;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import repository.configuration.ConfigurationReader;
import story.activity.*;
import story.activity.exception.ActivityException;
import story.characteristic.Characteristic;
import story.creator.Creator;
import story.reason.*;
import story.environment.Environment;
import story.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Lab4StoryTeller extends StoryTeller {
    private ConfigurationReader configurationReader;
    private Creator creator;
    private StringBuilder story;


    @AssistedInject
    public Lab4StoryTeller(@Assisted ConfigurationReader configurationReader,
                           @Assisted Creator creator) {
        this.configurationReader = configurationReader;
        this.creator = creator;
        story = new StringBuilder("И теперь ");
    }


    @Override
    public String tellStory(Injector injector, ObjectMapper objectMapper) throws ActivityException {
        Pokemon karlson = creator.createPokemon(configurationReader.readID("karlson"));
        Pokemon frekenBok = creator.createPokemon(configurationReader.readID("frekenBok"));
        Pokemon uncleUlius = creator.createPokemon(configurationReader.readID("uncleUlius"));
        Pokemon witches = creator.createPokemon(configurationReader.readID("witches"));
        Pokemon storyTeller = creator.createPokemon(configurationReader.readID("storyTeller"));
        Pokemon brownies = creator.createPokemon(configurationReader.readID("brownies"));
        Pokemon kid = creator.createPokemon(configurationReader.readID("kid"));
        Pokemon viewOfUncleUlius = creator.createPokemon(configurationReader.readID("viewOfUncleUlius"));
        Pokemon bimbo = creator.createPokemon(configurationReader.readID("bimbo"));
        Pokemon kristor = creator.createPokemon(configurationReader.readID("kristor"));
        Pokemon gunill = creator.createPokemon(configurationReader.readID("gunill"));
        Pokemon bigDog = creator.createPokemon(configurationReader.readID("dog"));
        Pokemon humans = creator.createPokemon(configurationReader.readID("humans"));
        Pokemon menPair = creator.createPokemon(configurationReader.readID("menPair"));
        Pokemon fille = creator.createPokemon(configurationReader.readID("fille"));
        Pokemon rulle = creator.createPokemon(configurationReader.readID("rulle"));
        Pokemon something = creator.createPokemon(configurationReader.readID("something"));
        Pokemon detectives = creator.createPokemon(configurationReader.readID("detectives"));
        Pokemon bear = creator.createPokemon(configurationReader.readID("bear"));
        Pokemon thisFool = creator.createPokemon(configurationReader.readID("thisFool"));

        Environment bakeryKuroschenie = creator.createEnvironment(configurationReader.readID("bakeryKuroschenie"));
        Environment frekenBokHand = creator.createEnvironment(configurationReader.readID("frekenBokHand"));
        Environment thoughts = creator.createEnvironment(configurationReader.readID("thoughts"));
        Environment doctor = creator.createEnvironment(configurationReader.readID("doctor"));
        Environment frontRoom = creator.createEnvironment(configurationReader.readID("frontRoom"));
        Environment hat = creator.createEnvironment(configurationReader.readID("hat"));
        Environment coat = creator.createEnvironment(configurationReader.readID("coat"));
        Environment quote1 = creator.createEnvironment(configurationReader.readID("quote1"));
        Environment shoulder = creator.createEnvironment(configurationReader.readID("shoulder"));
        Environment kitchen = creator.createEnvironment(configurationReader.readID("kitchen"));
        Environment note = creator.createEnvironment(configurationReader.readID("note"));
        Environment vasePark = creator.createEnvironment(configurationReader.readID("vasePark"));
        Environment dogs = creator.createEnvironment(configurationReader.readID("dogs"));
        Environment quote2 = creator.createEnvironment(configurationReader.readID("quote2"));
        Environment bench = creator.createEnvironment(configurationReader.readID("bench"));
        Environment cornerOfPark = creator.createEnvironment(configurationReader.readID("cornerOfPark"));
        Environment bearBottle = creator.createEnvironment(configurationReader.readID("bearBottle"));
        Environment hand = creator.createEnvironment(configurationReader.readID("hand"));
        Environment detectiveNovels = creator.createEnvironment(configurationReader.readID("detectiveNovels"));
        Environment criminals = creator.createEnvironment(configurationReader.readID("criminals"));
        Environment dialog = creator.createEnvironment(configurationReader.readID("dialog"));
        Environment houseOnRoof = creator.createEnvironment(configurationReader.readID("houseOnRoof"));
        Environment fists = creator.createEnvironment(configurationReader.readID("fists"));

        List<Reason> reasons = new ArrayList<>();
        frekenBok.withCharacteristic(new Characteristic("этого и"));
        ReasonAsActivityResult reasonAsActivityResult = new ReasonAsActivityResult(frekenBok.doActivity(NotUnderstand.class));
        reasons.add(reasonAsActivityResult);

        karlson.withReasons("хотя и", reasons);
        doWithEnvironments(karlson, Make.class, bakeryKuroschenie);

        doWithCharacteristic(uncleUlius, NotUnderstand.class, "тоже");

        doWithEnvironmentsAndCharacteristic(uncleUlius,
                                            NotNotice.class,
                                            "несмотря на всю его дъявольскую силу",
                                            bakeryKuroschenie);

        doWithEnvironmentsAndCharacteristic(uncleUlius, ThinkAbout.class, "а только все", something);

        story.append("но ");

        doWithEnvironmentsAndCharacteristic(uncleUlius, Grab.class, "вдруг", frekenBokHand);

        doWithEnvironmentsAndCharacteristic(uncleUlius,
                                            Squeeze.class,
                            "крепко, словно прося о помощи",
                                            frekenBokHand);

        doWithCharacteristic(frekenBok, OpenEyes.class, "широко");

        doWithEnvironments(uncleUlius, BendOver.class, frekenBok);

        story.append("и ");

        doWithEnvironments(uncleUlius, LookIntoEyes.class, frekenBok);

        frekenBok.withCharacteristic(new Characteristic("никак"));
        reasonAsActivityResult = new ReasonAsActivityResult(frekenBok.doActivity(NotWantSeemPachyderms.class));

        reasons = new ArrayList<>();
        reasons.add(reasonAsActivityResult);
        frekenBok.withReasons("потому что", reasons);
        story.append(frekenBok.doActivity(HarryConfirm.class))
                .append(System.lineSeparator());

        story.append(" что ");

        doWithCharacteristic(witches, Meet.class, "куда чаще, чем предполагаешь");

        List<ReasonBasedOnCharacterisedActivity.ActivityNameCharacteristicPair> activityNameCharacteristicPairs =
                new ArrayList<>();
        Characteristic characteristic = new Characteristic("как следует");
        activityNameCharacteristicPairs.add(
                new ReasonBasedOnCharacterisedActivity.ActivityNameCharacteristicPair(ThinkAbout.NAME, characteristic));

        storyTeller.withCharacteristic(new Characteristic("как следует"));
        reasonAsActivityResult = new ReasonAsActivityResult(storyTeller.doActivity(Think.class));
        reasons = new ArrayList<>();
        reasons.add(reasonAsActivityResult);
        storyTeller.withReasons("если", reasons);
        story.append(storyTeller.doActivity(BecomeClear.class))
               .append(System.lineSeparator());

        story.append(" что и ");

        doActivity(brownies, Be.class);

        story.append("Но ");

        reasons = new ArrayList<>();

        uncleUlius.withCharacteristic(new Characteristic("заранее"));
        uncleUlius.withEnvironments(doctor);
        reasonAsActivityResult = new ReasonAsActivityResult(uncleUlius.doActivity(Agreed.class));
        reasons.add(reasonAsActivityResult);

        uncleUlius.withCharacteristic(new Characteristic("уже"));
        reasonAsActivityResult = new ReasonAsActivityResult(uncleUlius.doActivity(TimeToGo.class));
        reasons.add(reasonAsActivityResult);

        uncleUlius.withCharacteristic(new Characteristic("тут"));
        thoughts.addCharacteristic(new Characteristic("свои"));
        uncleUlius.withEnvironments(thoughts);
        uncleUlius.withReasons("потому что", reasons);
        story.append(uncleUlius.doActivity(HaveToAbort.class))
                .append(System.lineSeparator());

        doWithEnvironmentsAndCharacteristic(kid, Held.class, "мило", uncleUlius, frontRoom);

        story.append("и ");
        story.append(frekenBok.getName());
        story.append(" тоже");
        story.append(System.lineSeparator());

        doWithEnvironments(kid, Give.class, hat, uncleUlius);

        story.append("a ");

        doWithEnvironments(frekenBok, HelpPutOn.class, coat, uncleUlius);

        doActivity(viewOfUncleUlius, ArousedCompassion.class);

        doWithEnvironments(kid, ThinkQuote.class, quote1);

        doWithEnvironmentsAndCharacteristic(kid, Clap.class, "робко", shoulder, uncleUlius);

        doActivity(frekenBok, WasConcerned.class);

        story.append("и ");

        doActivity(frekenBok, AskWithWorry.class);

        story.append("после ухода ");
        story.append(uncleUlius.getName());
        story.append(" ");

        doWithEnvironments(kid, Return.class, kitchen);
        doWithEnvironments(frekenBok, Return.class, kitchen);

        story.append("В МИРИ ЗКАЗОК ТОЖИ ЛЮБИ БУЛОЧКЫ ГНУМ ");

        doWithEnvironments(frekenBok, Read.class, note);

        story.append("и ");

        doWithCharacteristic(frekenBok, Frowned.class, "мрачно");

        reasons = new ArrayList<>();
        kid.withEnvironments(karlson);
        reasonAsActivityResult = new ReasonAsActivityResult(kid.doActivity(NotWantToSupportDialog.class));
        reasons.add(reasonAsActivityResult);

        kid.withCharacteristic(new Characteristic("в ответ только"));
        kid.withReasons("потому что", reasons);
        doActivity(kid, Say.class);

        doWithEnvironmentsAndCharacteristic(kid, Walk.class, "каждое утро", bimbo, vasePark);

        story.append("и ");

        reasons = new ArrayList<>();
        bimbo.withCharacteristic(new Characteristic("много"));
        bimbo.withEnvironments(dogs, vasePark);
        reasonAsActivityResult = new ReasonAsActivityResult(bimbo.doActivity(MeetOther.class));
        reasons.add(reasonAsActivityResult);

        storyTeller.withReasons("потому что", reasons);
        reasonAsActivityResult = new ReasonAsActivityResult(storyTeller.doActivity(IsTheBestHourOfAllDay.class));
        reasons = new ArrayList<>();
        reasons.add(reasonAsActivityResult);
        bimbo.withReasons("что", reasons);
        doActivity(bimbo, Believe.class);

        doWithEnvironmentsAndCharacteristic(kid, Play.class, "обычно", kristor, vasePark);
        doWithEnvironmentsAndCharacteristic(kid, Play.class, "обычно", gunill, vasePark);

        story.append("но сегодня ");

        doWithEnvironmentsAndCharacteristic(kid, NotFind.class, "так и", kristor);
        doWithEnvironmentsAndCharacteristic(kid, NotFind.class, "так и", gunill);

        doWithEnvironments(kid, ThinkQuote.class, quote2);

        story.append("Ну что ж пусть ");

        reasons = new ArrayList<>();
        kid.withEnvironments(karlson);
        reasonAsActivityResult = new ReasonAsActivityResult(kid.doActivity(BeWith.class));
        reasons.add(reasonAsActivityResult);

        kid.withEnvironments(bimbo);
        reasonAsActivityResult = new ReasonAsActivityResult(kid.doActivity(BeWith.class));
        reasons.add(reasonAsActivityResult);

        kid.withReasons("пока", reasons);
        doActivity(kid, DontCare.class);

        story.append("тут ");
        doWithEnvironmentsAndCharacteristic(bigDog, RunTo.class, "с явным намерением напасть на него", bimbo);

        reasons = new ArrayList<>();
        bimbo.withEnvironments(bigDog);
        reasonAsActivityResult = new ReasonAsActivityResult(bimbo.doActivity(ThinkAbout.class));
        reasons.add(reasonAsActivityResult);

        storyTeller.withReasons("что", reasons);
        storyTeller.withEnvironments(bigDog);
        reasonAsActivityResult = new ReasonAsActivityResult(storyTeller.doActivity(Show.class));
        reasons = new ArrayList<>();
        reasons.add(reasonAsActivityResult);

        bimbo.withReasons("чтобы", reasons);
        doActivity(bimbo, WantToRushIntoBattle.class);

        story.append("но ");

        doWithEnvironments(kid, Kept.class, bimbo);

        doWithEnvironments(kid, GrabIntoHugs.class, bimbo);

        story.append("и ");

        reasons = new ArrayList<>();
        reasonAsActivityResult = new ReasonAsActivityResult(bimbo.doActivity(CalmDown.class));
        reasons.add(reasonAsActivityResult);

        kid.withReasons("пока", reasons);
        reasonAsActivityResult = new ReasonAsActivityResult(kid.doActivity(Sit.class));
        reasons = new ArrayList<>();
        reasons.add(reasonAsActivityResult);

        kid.withReasons("чтобы", reasons);
        doWithEnvironments(kid, LookFor.class, bench);

        story.append("но ");
        doActivity(storyTeller, AllWasBusy.class);

        story.append("-- ");
        doActivity(humans, BaskInSun.class);

        doWithEnvironmentsAndCharacteristic(kid, Wandered.class, "в поисках свободного местечка", cornerOfPark);

        reasons = new ArrayList<>();
        storyTeller.withEnvironments(bearBottle, hand);
        reasonAsActivityResult = new ReasonAsActivityResult(storyTeller.doActivity(Hold.class));
        reasons.add(reasonAsActivityResult);

        menPair.withReasons("причем каждый", reasons);
        reasons = new ArrayList<>();
        reasonAsActivityResult = new ReasonAsActivityResult(menPair.doActivity(Place.class));
        reasons.add(reasonAsActivityResult);

        kid.withReasons("на которой", reasons);
        doWithEnvironments(kid, Discover.class, bench, cornerOfPark);

        doWithEnvironmentsAndCharacteristic(kid, Recognise.class, "тут же", fille);
        doWithEnvironmentsAndCharacteristic(kid, Recognise.class, "тут же", rulle);

        doActivity(kid, Scare.class);

        story.append("и ");

        doActivity(kid, WantToGoFurther.class);

        story.append("но вместе с тем ");

        doWithEnvironmentsAndCharacteristic(something, Attract.class, "именно", kid, bench);

        doWithCharacteristic(kid, NeedToKnow.class, "ведь");

        doWithEnvironments(fille, Hunt.class, karlson);
        doWithEnvironments(rulle, Hunt.class, karlson);

        doWithCharacteristic(storyTeller, WillTalkAboutIt.class, "возможно, они");

        story.append("и ");

        doWithCharacteristic(kid, ScareOf.class, "собственно говоря");

        doWithEnvironments(fille, NeverSee.class, kid);
        doWithEnvironments(rulle, NeverSee.class, kid);

        story.append("и ");

        doWithEnvironmentsAndCharacteristic(storyTeller, DontKnow.class, "следовательно", kid);

        story.append("Вот и прекрасно!");
        story.append(System.lineSeparator());

        story.append("Значит ");
        doActivity(kid, MaySitAsLongAsWant.class);

        story.append("так ведь ");

        reasons = new ArrayList<>();
        storyTeller.withEnvironments(criminals);
        reasonAsActivityResult = new ReasonAsActivityResult(storyTeller.doActivity(TrackDown.class));
        reasons.add(reasonAsActivityResult);

        detectives.withReasons("когда", reasons);
        doWithEnvironments(detectives, Act.class, detectiveNovels);

        story.append("-- ");
        doActivity(storyTeller, SitSilently.class);
        story.append("и ");
        doWithEnvironments(storyTeller, Hear.class, dialog);

        story.append("итак ");
        doWithEnvironments(kid, HaveSit.class, bench);
        story.append("и ");
        doActivity(kid, BecomeRumor.class);
        story.append("но в то же время ");

        reasons = new ArrayList<>();
        kid.withEnvironments(fille);
        reasonAsActivityResult = new ReasonAsActivityResult(kid.doActivity(HaveInterest.class));
        reasons.add(reasonAsActivityResult);

        kid.withEnvironments(rulle);
        reasonAsActivityResult = new ReasonAsActivityResult(kid.doActivity(HaveInterest.class));
        reasons.add(reasonAsActivityResult);

        List<Reason> tempList = new ArrayList<>(reasons);

        reasons = new ArrayList<>();
        fille.withReasons("что", tempList);
        reasonAsActivityResult = new ReasonAsActivityResult(fille.doActivity(DontThink.class));
        reasons.add(reasonAsActivityResult);

        rulle.withReasons("что", tempList);
        reasonAsActivityResult = new ReasonAsActivityResult(rulle.doActivity(DontThink.class));
        reasons.add(reasonAsActivityResult);

        kid.withReasons("чтобы", reasons);
        doWithEnvironmentsAndCharacteristic(kid, Address.class, "иногда", bimbo);

        story.append("однако было похоже, что ");
        doActivity(kid, WillNotFindOut.class);

        doWithCharacteristic(fille, DrinkBear.class, "молча");
        doWithCharacteristic(rulle, DrinkBear.class, "молча");

        story.append("наконец ");

        doActivity(bear, WasDrunk.class);

        story.append("но они все ");

        doActivity(storyTeller, ContinueNotSpeak.class);

        story.append("и ");

        doWithCharacteristic(fille, Say.class, "вдруг");

        reasons = new ArrayList<>();
        storyTeller.withCharacteristic(new Characteristic("едва"));
        reasonAsActivityResult = new ReasonAsActivityResult(storyTeller.doActivity(WasAbleToTakeBreath.class));
        reasons.add(reasonAsActivityResult);

        kid.withReasons("что", reasons);
        doWithCharacteristic(kid, Scare.class, "так");

        doWithCharacteristic(kid, WasDesperate.class, "просто");

        story.append("теперь ");

        doActivity(karlson, IndulgesInFishingRods.class);

        doWithEnvironments(fille, Notice.class, houseOnRoof);
        doWithEnvironments(rulle, Notice.class, houseOnRoof);

        story.append("да ");

        doWithCharacteristic(storyTeller, EverythingWillEnd.class, "теперь");

        doWithEnvironmentsAndCharacteristic(kid, Squeeze.class, "пытаясь сдержать слезы", fists);

        story.append("и в тот самый момент когда ");

        reasons = new ArrayList<>();
        reasonAsActivityResult = new ReasonAsActivityResult(kid.doActivity(HardWork.class));
        reasons.add(reasonAsActivityResult);

        storyTeller.withReasons("хотя", reasons);
        doActivity(storyTeller, StoppedWorking.class);

        doActivity(kid, HaveHeard.class);

        story.append("как ");

        doActivity(rulle, Say.class);

        doActivity(kid, EyesBecomeRound.class);

        story.append("может он ослышался?")
               .append(System.lineSeparator());

        story.append("неужели ");

        doActivity(fille, ReallyThink.class);

        reasons = new ArrayList<>();
        reasonAsActivityResult = new ReasonAsActivityResult(karlson.doActivity(LiveWithServantes.class));
        reasons.add(reasonAsActivityResult);

        rulle.withReasons("что", reasons);
        doActivity(rulle, ReallyThink.class);

        story.append("Какое счастье!");
        story.append("Это ведь значит что ");

        doWithCharacteristic(karlson, MayHideHome.class, "всегда");

        story.append("и ");

        doActivity(storyTeller, BeHereInSafity.class);

        doWithEnvironments(fille, NotHaveTrackedDown.class, karlson);
        doWithEnvironments(rulle, NotHaveTrackedDown.class, karlson);

        story.append("да это и не так легко")
                .append(System.lineSeparator());
        story.append("Ведь никто кроме трубочиста ");
        doActivity(storyTeller, DontClimbRoofs.class);

        story.append("итак, ");
        doWithEnvironments(fille, NotSniffed.class, houseOnRoof);
        doWithEnvironments(rulle, NotSniffed.class, houseOnRoof);
        story.append("и тем не менее все это ужасно ")
                .append(System.lineSeparator());

        story.append("Бедняга Карлсон, каково ему придется, если ");
        doWithEnvironmentsAndCharacteristic(storyTeller, StartHunt.class, "всерьез", karlson);

        doActivity(thisFool, NeverCanHide.class);

        doWithCharacteristic(fille, KeepSilent.class, "снова долго");
        doWithCharacteristic(rulle, KeepSilent.class, "снова долго");

        story.append("а потом ");

        doWithCharacteristic(rulle, Say.class, "шепотом");

        story.append("(Малыш едва расслышал)")
               .append(System.lineSeparator());

        story.append("вот тут-то ");

        reasons = new ArrayList<>();
        storyTeller.withEnvironments(bench);
        reasonAsActivityResult = new ReasonAsActivityResult("они " + storyTeller.doActivity(SitNotAlong.class));
        reasons.add(reasonAsActivityResult);

        fille.withReasons("что", reasons);
        doWithCharacteristic(fille, CaughtOn.class, "и");

        doWithEnvironments(fille, LookAt.class, kid);
        story.append("и ");
        doWithCharacteristic(fille, Say.class, "очень громко");

        return story.toString();
    }

    private void doActivity(Pokemon pokemon,
                            Class<?> activityClass) throws ActivityException {
        story.append(pokemon.doActivity(activityClass))
                .append(System.lineSeparator());
    }
    private void doWithEnvironments(Pokemon pokemon,
                               Class<?> activityClass,
                               Environment... environments) throws ActivityException {
        pokemon.withEnvironments(environments);
        story.append(pokemon.doActivity(activityClass))
                .append(System.lineSeparator());
    }

    private void doWithCharacteristic(Pokemon pokemon,
                                      Class<?> activityClass,
                                      String characteristicString) throws ActivityException {
        Characteristic characteristic = new Characteristic(characteristicString);
        pokemon.withCharacteristic(characteristic);
        story.append(pokemon.doActivity(activityClass))
                .append(System.lineSeparator());
    }

    private void doWithEnvironmentsAndCharacteristic(Pokemon pokemon,
                                                     Class<?> activityClass,
                                                     String characteristicString,
                                                     Environment... environments) throws ActivityException {
        Characteristic characteristic = new Characteristic(characteristicString);
        pokemon.withCharacteristic(characteristic);
        pokemon.withEnvironments(environments);
        story.append(pokemon.doActivity(activityClass))
                .append(System.lineSeparator());
    }
}
