import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GUI extends Application 
{
    private ArrayList<String> validFileNames = new ArrayList<String>();
    boolean isFileOpened = false;
    Stage window;
    File givenFile;
    private ArrayList<ItemData> items = new ArrayList<ItemData>();
    private ListView<ItemData> itemList = null;
    TextField searchField = new TextField();
    Button saveChangesButton = new Button("Save Struct Changes");
    HBox upperBox = new HBox();

    Image allOrNothingImage = new Image(getClass().getResource("/icons/allOrNothing.png").toExternalForm());
    Image allOrNothingPImage = new Image(getClass().getResource("/icons/allOrNothingP.png").toExternalForm());
    Image attackFXBImage = new Image(getClass().getResource("/icons/attackFXB.png").toExternalForm());
    Image attackFXGImage = new Image(getClass().getResource("/icons/attackFXG.png").toExternalForm());
    Image attackFXPImage = new Image(getClass().getResource("/icons/attackFXP.png").toExternalForm());
    Image attackFXRImage = new Image(getClass().getResource("/icons/attackFXR.png").toExternalForm());
    Image attackFXYImage = new Image(getClass().getResource("/icons/attackFXY.png").toExternalForm());
    Image audienceBoneImage = new Image(getClass().getResource("/icons/audienceBone.png").toExternalForm());
    Image audienceCanImage = new Image(getClass().getResource("/icons/audienceCan.png").toExternalForm());
    Image audienceHammerImage = new Image(getClass().getResource("/icons/audienceHammer.png").toExternalForm());
    Image audienceRockImage = new Image(getClass().getResource("/icons/audienceRock.png").toExternalForm());
    Image autographImage = new Image(getClass().getResource("/icons/autograph.png").toExternalForm());
    Image battleTrunksImage = new Image(getClass().getResource("/icons/battleTrunks.png").toExternalForm());
    Image blackKeyImage = new Image(getClass().getResource("/icons/blackKey.png").toExternalForm());
    Image blanketImage = new Image(getClass().getResource("/icons/blanket.png").toExternalForm());
    Image blimpTicketImage = new Image(getClass().getResource("/icons/blimpTicket.png").toExternalForm());
    Image blueKeyImage = new Image(getClass().getResource("/icons/blueKey.png").toExternalForm());
    Image bluePotionImage = new Image(getClass().getResource("/icons/bluePotion.png").toExternalForm());
    Image boatCurseImage = new Image(getClass().getResource("/icons/boatCurse.png").toExternalForm());
    Image boosSheetImage = new Image(getClass().getResource("/icons/boosSheet.png").toExternalForm());
    Image bootsImage = new Image(getClass().getResource("/icons/boots.png").toExternalForm());
    Image bowserMeatImage = new Image(getClass().getResource("/icons/bowserMeat.png").toExternalForm());
    Image boxImage = new Image(getClass().getResource("/icons/box.png").toExternalForm());
    Image BPEmblemCustomImage = new Image(getClass().getResource("/icons/BPEmblemCustom.png").toExternalForm());
    Image briefcaseImage = new Image(getClass().getResource("/icons/briefcase.png").toExternalForm());
    Image bumpAttackImage = new Image(getClass().getResource("/icons/bumpAttack.png").toExternalForm());
    Image cakeImage = new Image(getClass().getResource("/icons/cake.png").toExternalForm());
    Image cakeMixImage = new Image(getClass().getResource("/icons/cakeMix.png").toExternalForm());
    Image cardKey1Image = new Image(getClass().getResource("/icons/cardKey1.png").toExternalForm());
    Image cardKey2Image = new Image(getClass().getResource("/icons/cardKey2.png").toExternalForm());
    Image cardKey3Image = new Image(getClass().getResource("/icons/cardKey3.png").toExternalForm());
    Image cardKey4Image = new Image(getClass().getResource("/icons/cardKey4.png").toExternalForm());
    Image castleKeyImage = new Image(getClass().getResource("/icons/castleKey.png").toExternalForm());
    Image champsBeltImage = new Image(getClass().getResource("/icons/champsBelt.png").toExternalForm());
    Image chargeImage = new Image(getClass().getResource("/icons/charge.png").toExternalForm());
    Image chargePImage = new Image(getClass().getResource("/icons/chargeP.png").toExternalForm());
    Image chillOutImage = new Image(getClass().getResource("/icons/chillOut.png").toExternalForm());
    Image chocoCakeImage = new Image(getClass().getResource("/icons/chocoCake.png").toExternalForm());
    Image chuckolaColaImage = new Image(getClass().getResource("/icons/chuckolaCola.png").toExternalForm());
    Image closeCallImage = new Image(getClass().getResource("/icons/closeCall.png").toExternalForm());
    Image closeCallPImage = new Image(getClass().getResource("/icons/closeCallP.png").toExternalForm());
    Image cocoCandyImage = new Image(getClass().getResource("/icons/cocoCandy.png").toExternalForm());
    Image coconutImage = new Image(getClass().getResource("/icons/coconut.png").toExternalForm());
    Image coconutBombImage = new Image(getClass().getResource("/icons/coconutBomb.png").toExternalForm());
    Image cogImage = new Image(getClass().getResource("/icons/cog.png").toExternalForm());
    Image coinImage = new Image(getClass().getResource("/icons/coin.png").toExternalForm());
    Image contactLensImage = new Image(getClass().getResource("/icons/contactLens.png").toExternalForm());
    Image cookbookImage = new Image(getClass().getResource("/icons/cookbook.png").toExternalForm());
    Image couplesCakeImage = new Image(getClass().getResource("/icons/couplesCake.png").toExternalForm());
    Image courageMealImage = new Image(getClass().getResource("/icons/courageMeal.png").toExternalForm());
    Image courageShellImage = new Image(getClass().getResource("/icons/courageShell.png").toExternalForm());
    Image crystalStarImage = new Image(getClass().getResource("/icons/crystalStar.png").toExternalForm());
    Image damageDodgeImage = new Image(getClass().getResource("/icons/damageDodge.png").toExternalForm());
    Image damageDodgePImage = new Image(getClass().getResource("/icons/damageDodgeP.png").toExternalForm());
    Image dataDiskImage = new Image(getClass().getResource("/icons/dataDisk.png").toExternalForm());
    Image defendPlusImage = new Image(getClass().getResource("/icons/defendPlus.png").toExternalForm());
    Image defendPlusPImage = new Image(getClass().getResource("/icons/defendPlusP.png").toExternalForm());
    Image diamondStarImage = new Image(getClass().getResource("/icons/diamondStar.png").toExternalForm());
    Image dizzyDialImage = new Image(getClass().getResource("/icons/dizzyDial.png").toExternalForm());
    Image doubleDipImage = new Image(getClass().getResource("/icons/doubleDip.png").toExternalForm());
    Image doubleDipPImage = new Image(getClass().getResource("/icons/doubleDipP.png").toExternalForm());
    Image doublePainImage = new Image(getClass().getResource("/icons/doublePain.png").toExternalForm());
    Image driedbouquetImage = new Image(getClass().getResource("/icons/driedbouquet.png").toExternalForm());
    Image driedShroomImage = new Image(getClass().getResource("/icons/driedShroom.png").toExternalForm());
    Image dubiousPaperImage = new Image(getClass().getResource("/icons/dubiousPaper.png").toExternalForm());
    Image earthQuakeImage = new Image(getClass().getResource("/icons/earthQuake.png").toExternalForm());
    Image eggBombImage = new Image(getClass().getResource("/icons/eggBomb.png").toExternalForm());
    Image electroPopImage = new Image(getClass().getResource("/icons/electroPop.png").toExternalForm());
    Image elevatorKey1Image = new Image(getClass().getResource("/icons/elevatorKey1.png").toExternalForm());
    Image elevatorKey2Image = new Image(getClass().getResource("/icons/elevatorKey2.png").toExternalForm());
    Image elevatorKey3Image = new Image(getClass().getResource("/icons/elevatorKey3.png").toExternalForm());
    Image emeraldStarImage = new Image(getClass().getResource("/icons/emeraldStar.png").toExternalForm());
    Image feelingFineImage = new Image(getClass().getResource("/icons/feelingFine.png").toExternalForm());
    Image feelingFinePImage = new Image(getClass().getResource("/icons/feelingFineP.png").toExternalForm());
    Image fireDriveImage = new Image(getClass().getResource("/icons/fireDrive.png").toExternalForm());
    Image fireFlowerImage = new Image(getClass().getResource("/icons/fireFlower.png").toExternalForm());
    Image firePopImage = new Image(getClass().getResource("/icons/firePop.png").toExternalForm());
    Image firstAttackImage = new Image(getClass().getResource("/icons/firstAttack.png").toExternalForm());
    Image flowerImage = new Image(getClass().getResource("/icons/flower.png").toExternalForm());
    Image flowerFinderImage = new Image(getClass().getResource("/icons/flowerFinder.png").toExternalForm());
    Image flowerSaverImage = new Image(getClass().getResource("/icons/flowerSaver.png").toExternalForm());
    Image flowerSaverPImage = new Image(getClass().getResource("/icons/flowerSaverP.png").toExternalForm());
    Image FPDrainImage = new Image(getClass().getResource("/icons/FPDrain.png").toExternalForm());
    Image FPDrainPImage = new Image(getClass().getResource("/icons/FPDrainP.png").toExternalForm());
    Image FPPlusImage = new Image(getClass().getResource("/icons/FPPlus.png").toExternalForm());
    Image freshJuiceImage = new Image(getClass().getResource("/icons/freshJuice.png").toExternalForm());
    Image freshPastaImage = new Image(getClass().getResource("/icons/freshPasta.png").toExternalForm());
    Image friedEggImage = new Image(getClass().getResource("/icons/friedEgg.png").toExternalForm());
    Image frightMaskImage = new Image(getClass().getResource("/icons/frightMask.png").toExternalForm());
    Image fruitParfaitImage = new Image(getClass().getResource("/icons/fruitParfait.png").toExternalForm());
    Image galleyPotImage = new Image(getClass().getResource("/icons/galleyPot.png").toExternalForm());
    Image garnetStarImage = new Image(getClass().getResource("/icons/garnetStar.png").toExternalForm());
    Image gateHandleImage = new Image(getClass().getResource("/icons/gateHandle.png").toExternalForm());
    Image goldBarImage = new Image(getClass().getResource("/icons/goldBar.png").toExternalForm());
    Image goldBarX3Image = new Image(getClass().getResource("/icons/goldBarX3.png").toExternalForm());
    Image goldbobGuide1Image = new Image(getClass().getResource("/icons/goldbobGuide1.png").toExternalForm());
    Image goldbobGuide2Image = new Image(getClass().getResource("/icons/goldbobGuide2.png").toExternalForm());
    Image goldbobGuide3Image = new Image(getClass().getResource("/icons/goldbobGuide3.png").toExternalForm());
    Image goldCardImage = new Image(getClass().getResource("/icons/goldCard.png").toExternalForm());
    Image goldenLeafImage = new Image(getClass().getResource("/icons/goldenLeaf.png").toExternalForm());
    Image goldRingImage = new Image(getClass().getResource("/icons/goldRing.png").toExternalForm());
    Image goldStarImage = new Image(getClass().getResource("/icons/goldStar.png").toExternalForm());
    Image gradualSyrupImage = new Image(getClass().getResource("/icons/gradualSyrup.png").toExternalForm());
    Image greenPotionImage = new Image(getClass().getResource("/icons/greenPotion.png").toExternalForm());
    Image grottoKeyImage = new Image(getClass().getResource("/icons/grottoKey.png").toExternalForm());
    Image hammerImage = new Image(getClass().getResource("/icons/hammer.png").toExternalForm());
    Image hammerManImage = new Image(getClass().getResource("/icons/hammerMan.png").toExternalForm());
    Image hammerThrowImage = new Image(getClass().getResource("/icons/hammerThrow.png").toExternalForm());
    Image happyFlowerImage = new Image(getClass().getResource("/icons/happyFlower.png").toExternalForm());
    Image happyHeartImage = new Image(getClass().getResource("/icons/happyHeart.png").toExternalForm());
    Image happyHeartPImage = new Image(getClass().getResource("/icons/happyHeartP.png").toExternalForm());
    Image headRattleImage = new Image(getClass().getResource("/icons/headRattle.png").toExternalForm());
    Image healthySaladImage = new Image(getClass().getResource("/icons/healthySalad.png").toExternalForm());
    Image heartImage = new Image(getClass().getResource("/icons/heart.png").toExternalForm());
    Image heartFinderImage = new Image(getClass().getResource("/icons/heartFinder.png").toExternalForm());
    Image heartfulCakeImage = new Image(getClass().getResource("/icons/heartfulCake.png").toExternalForm());
    Image honeyCandyImage = new Image(getClass().getResource("/icons/honeyCandy.png").toExternalForm());
    Image honeyShroomImage = new Image(getClass().getResource("/icons/honeyShroom.png").toExternalForm());
    Image honeySuperImage = new Image(getClass().getResource("/icons/honeySuper.png").toExternalForm());
    Image honeySyrupImage = new Image(getClass().getResource("/icons/honeySyrup.png").toExternalForm());
    Image honeyUltraImage = new Image(getClass().getResource("/icons/honeyUltra.png").toExternalForm());
    Image horsetailImage = new Image(getClass().getResource("/icons/horsetail.png").toExternalForm());
    Image hotDogImage = new Image(getClass().getResource("/icons/hotDog.png").toExternalForm());
    Image hotSauceImage = new Image(getClass().getResource("/icons/hotSauce.png").toExternalForm());
    Image houseKeyImage = new Image(getClass().getResource("/icons/houseKey.png").toExternalForm());
    Image HPDrain1Image = new Image(getClass().getResource("/icons/HPDrain1.png").toExternalForm());
    Image HPDrain2Image = new Image(getClass().getResource("/icons/HPDrain2.png").toExternalForm());
    Image HPDrainPImage = new Image(getClass().getResource("/icons/HPDrainP.png").toExternalForm());
    Image HPPlusImage = new Image(getClass().getResource("/icons/HPPlus.png").toExternalForm());
    Image HPPlusPImage = new Image(getClass().getResource("/icons/HPPlusP.png").toExternalForm());
    Image icePowerImage = new Image(getClass().getResource("/icons/icePower.png").toExternalForm());
    Image iceSmashImage = new Image(getClass().getResource("/icons/iceSmash.png").toExternalForm());
    Image iceStormImage = new Image(getClass().getResource("/icons/iceStorm.png").toExternalForm());
    Image iciclePopImage = new Image(getClass().getResource("/icons/iciclePop.png").toExternalForm());
    Image inkPastaImage = new Image(getClass().getResource("/icons/inkPasta.png").toExternalForm());
    Image inkySauceImage = new Image(getClass().getResource("/icons/inkySauce.png").toExternalForm());
    Image innCouponImage = new Image(getClass().getResource("/icons/innCoupon.png").toExternalForm());
    Image itemHogImage = new Image(getClass().getResource("/icons/itemHog.png").toExternalForm());
    Image itemsIconImage = new Image(getClass().getResource("/icons/itemsIcon.png").toExternalForm());
    Image jamminJellyImage = new Image(getClass().getResource("/icons/jamminJelly.png").toExternalForm());
    Image jellyCandyImage = new Image(getClass().getResource("/icons/jellyCandy.png").toExternalForm());
    Image jellyShroomImage = new Image(getClass().getResource("/icons/jellyShroom.png").toExternalForm());
    Image jellySuperImage = new Image(getClass().getResource("/icons/jellySuper.png").toExternalForm());
    Image jellyUltraImage = new Image(getClass().getResource("/icons/jellyUltra.png").toExternalForm());
    Image jumpManImage = new Image(getClass().getResource("/icons/jumpMan.png").toExternalForm());
    Image keelMangoImage = new Image(getClass().getResource("/icons/keelMango.png").toExternalForm());
    Image koopaBunImage = new Image(getClass().getResource("/icons/koopaBun.png").toExternalForm());
    Image koopaCurseImage = new Image(getClass().getResource("/icons/koopaCurse.png").toExternalForm());
    Image koopastaImage = new Image(getClass().getResource("/icons/koopasta.png").toExternalForm());
    Image koopaTeaImage = new Image(getClass().getResource("/icons/koopaTea.png").toExternalForm());
    Image lastStandImage = new Image(getClass().getResource("/icons/lastStand.png").toExternalForm());
    Image lastStandPImage = new Image(getClass().getResource("/icons/lastStandP.png").toExternalForm());
    Image lEmblemImage = new Image(getClass().getResource("/icons/lEmblem.png").toExternalForm());
    Image lifeShroomImage = new Image(getClass().getResource("/icons/lifeShroom.png").toExternalForm());
    Image lotteryPickImage = new Image(getClass().getResource("/icons/lotteryPick.png").toExternalForm());
    Image lovePuddingImage = new Image(getClass().getResource("/icons/lovePudding.png").toExternalForm());
    Image luckyDayImage = new Image(getClass().getResource("/icons/luckyDay.png").toExternalForm());
    Image luckyDayPImage = new Image(getClass().getResource("/icons/luckyDayP.png").toExternalForm());
    Image luckyStartImage = new Image(getClass().getResource("/icons/luckyStart.png").toExternalForm());
    Image luckyStartPImage = new Image(getClass().getResource("/icons/luckyStartP.png").toExternalForm());
    Image magicalMap1Image = new Image(getClass().getResource("/icons/magicalMap1.png").toExternalForm());
    Image magicalMap2Image = new Image(getClass().getResource("/icons/magicalMap2.png").toExternalForm());
    Image mailboxSPImage = new Image(getClass().getResource("/icons/mailboxSP.png").toExternalForm());
    Image mangoDelightImage = new Image(getClass().getResource("/icons/mangoDelight.png").toExternalForm());
    Image mapleShroomImage = new Image(getClass().getResource("/icons/mapleShroom.png").toExternalForm());
    Image mapleSuperImage = new Image(getClass().getResource("/icons/mapleSuper.png").toExternalForm());
    Image mapleSyrupImage = new Image(getClass().getResource("/icons/mapleSyrup.png").toExternalForm());
    Image mapleUltraImage = new Image(getClass().getResource("/icons/mapleUltra.png").toExternalForm());
    Image marioWantedPosterImage = new Image(getClass().getResource("/icons/marioWantedPoster.png").toExternalForm());
    Image megaJumpImage = new Image(getClass().getResource("/icons/megaJump.png").toExternalForm());
    Image megaQuakeImage = new Image(getClass().getResource("/icons/megaQuake.png").toExternalForm());
    Image megaRushImage = new Image(getClass().getResource("/icons/megaRush.png").toExternalForm());
    Image megaRushPImage = new Image(getClass().getResource("/icons/megaRushP.png").toExternalForm());
    Image megaSmashImage = new Image(getClass().getResource("/icons/megaSmash.png").toExternalForm());
    Image meteorMealImage = new Image(getClass().getResource("/icons/meteorMeal.png").toExternalForm());
    Image miniMrMiniImage = new Image(getClass().getResource("/icons/miniMrMini.png").toExternalForm());
    Image mistakeImage = new Image(getClass().getResource("/icons/mistake.png").toExternalForm());
    Image moneyMoneyImage = new Image(getClass().getResource("/icons/moneyMoney.png").toExternalForm());
    Image moonStoneImage = new Image(getClass().getResource("/icons/moonStone.png").toExternalForm());
    Image mousseCakeImage = new Image(getClass().getResource("/icons/mousseCake.png").toExternalForm());
    Image mrsoftenerImage = new Image(getClass().getResource("/icons/mrsoftener.png").toExternalForm());
    Image multibounceImage = new Image(getClass().getResource("/icons/multibounce.png").toExternalForm());
    Image mushroomImage = new Image(getClass().getResource("/icons/mushroom.png").toExternalForm());
    Image mysteryImage = new Image(getClass().getResource("/icons/mystery.png").toExternalForm());
    Image mysticEggImage = new Image(getClass().getResource("/icons/mysticEgg.png").toExternalForm());
    Image necklaceImage = new Image(getClass().getResource("/icons/necklace.png").toExternalForm());
    Image nothingImage = new Image(getClass().getResource("/icons/nothing.png").toExternalForm());
    Image oldLetterImage = new Image(getClass().getResource("/icons/oldLetter.png").toExternalForm());
    Image omeletteMealImage = new Image(getClass().getResource("/icons/omeletteMeal.png").toExternalForm());
    Image orangePotionImage = new Image(getClass().getResource("/icons/orangePotion.png").toExternalForm());
    Image pImage = new Image(getClass().getResource("/icons/p.png").toExternalForm());
    Image palaceKey1Image = new Image(getClass().getResource("/icons/palaceKey1.png").toExternalForm());
    Image palaceKey2Image = new Image(getClass().getResource("/icons/palaceKey2.png").toExternalForm());
    Image paperCurseImage = new Image(getClass().getResource("/icons/paperCurse.png").toExternalForm());
    Image PDownDUpImage = new Image(getClass().getResource("/icons/PDownDUp.png").toExternalForm());
    Image PDownDUpPImage = new Image(getClass().getResource("/icons/PDownDUpP.png").toExternalForm());
    Image peachTartImage = new Image(getClass().getResource("/icons/peachTart.png").toExternalForm());
    Image peachyPeachImage = new Image(getClass().getResource("/icons/peachyPeach.png").toExternalForm());
    Image peekabooImage = new Image(getClass().getResource("/icons/peekaboo.png").toExternalForm());
    Image piantaImage = new Image(getClass().getResource("/icons/pianta.png").toExternalForm());
    Image piercingBlowImage = new Image(getClass().getResource("/icons/piercingBlow.png").toExternalForm());
    Image pityFlowerImage = new Image(getClass().getResource("/icons/pityFlower.png").toExternalForm());
    Image pityFlowerPImage = new Image(getClass().getResource("/icons/pityFlowerP.png").toExternalForm());
    Image planeCurseImage = new Image(getClass().getResource("/icons/planeCurse.png").toExternalForm());
    Image platinumCardImage = new Image(getClass().getResource("/icons/platinumCard.png").toExternalForm());
    Image pointSwapImage = new Image(getClass().getResource("/icons/pointSwap.png").toExternalForm());
    Image poisonedCakeImage = new Image(getClass().getResource("/icons/poisonedCake.png").toExternalForm());
    Image poisonShroomImage = new Image(getClass().getResource("/icons/poisonShroom.png").toExternalForm());
    Image powBlockImage = new Image(getClass().getResource("/icons/powBlock.png").toExternalForm());
    Image powerBounceImage = new Image(getClass().getResource("/icons/powerBounce.png").toExternalForm());
    Image powerJumpImage = new Image(getClass().getResource("/icons/powerJump.png").toExternalForm());
    Image powerPlusImage = new Image(getClass().getResource("/icons/powerPlus.png").toExternalForm());
    Image powerPlusPImage = new Image(getClass().getResource("/icons/powerPlusP.png").toExternalForm());
    Image powerPunchImage = new Image(getClass().getResource("/icons/powerPunch.png").toExternalForm());
    Image powerRushImage = new Image(getClass().getResource("/icons/powerRush.png").toExternalForm());
    Image powerRushPImage = new Image(getClass().getResource("/icons/powerRushP.png").toExternalForm());
    Image powerSmashImage = new Image(getClass().getResource("/icons/powerSmash.png").toExternalForm());
    Image presentImage = new Image(getClass().getResource("/icons/present.png").toExternalForm());
    Image prettyLuckyImage = new Image(getClass().getResource("/icons/prettyLucky.png").toExternalForm());
    Image prettyLuckyPImage = new Image(getClass().getResource("/icons/prettyLuckyP.png").toExternalForm());
    Image puniOrbImage = new Image(getClass().getResource("/icons/puniOrb.png").toExternalForm());
    Image PUpDDownImage = new Image(getClass().getResource("/icons/PUpDDown.png").toExternalForm());
    Image PUpDDownPImage = new Image(getClass().getResource("/icons/PUpDDownP.png").toExternalForm());
    Image quakeHammerImage = new Image(getClass().getResource("/icons/quakeHammer.png").toExternalForm());
    Image quickChangeImage = new Image(getClass().getResource("/icons/quickChange.png").toExternalForm());
    Image raggedDiaryImage = new Image(getClass().getResource("/icons/raggedDiary.png").toExternalForm());
    Image redKeyImage = new Image(getClass().getResource("/icons/redKey.png").toExternalForm());
    Image redPotionImage = new Image(getClass().getResource("/icons/redPotion.png").toExternalForm());
    Image refundImage = new Image(getClass().getResource("/icons/refund.png").toExternalForm());
    Image repelCapeImage = new Image(getClass().getResource("/icons/repelCape.png").toExternalForm());
    Image returnPostageImage = new Image(getClass().getResource("/icons/returnPostage.png").toExternalForm());
    Image routingSlipImage = new Image(getClass().getResource("/icons/routingSlip.png").toExternalForm());
    Image rubyStarImage = new Image(getClass().getResource("/icons/rubyStar.png").toExternalForm());
    Image ruinPowderImage = new Image(getClass().getResource("/icons/ruinPowder.png").toExternalForm());
    Image sapphireStarImage = new Image(getClass().getResource("/icons/sapphireStar.png").toExternalForm());
    Image shellEarringsImage = new Image(getClass().getResource("/icons/shellEarrings.png").toExternalForm());
    Image shineSpriteImage = new Image(getClass().getResource("/icons/shineSprite.png").toExternalForm());
    Image shootingStarImage = new Image(getClass().getResource("/icons/shootingStar.png").toExternalForm());
    Image shrinkStompImage = new Image(getClass().getResource("/icons/shrinkStomp.png").toExternalForm());
    Image shroomBrothImage = new Image(getClass().getResource("/icons/shroomBroth.png").toExternalForm());
    Image shroomCakeImage = new Image(getClass().getResource("/icons/shroomCake.png").toExternalForm());
    Image shroomCrepeImage = new Image(getClass().getResource("/icons/shroomCrepe.png").toExternalForm());
    Image shroomFryImage = new Image(getClass().getResource("/icons/shroomFry.png").toExternalForm());
    Image shroomRoastImage = new Image(getClass().getResource("/icons/shroomRoast.png").toExternalForm());
    Image shroomSteakImage = new Image(getClass().getResource("/icons/shroomSteak.png").toExternalForm());
    Image silverCardImage = new Image(getClass().getResource("/icons/silverCard.png").toExternalForm());
    Image simplifierImage = new Image(getClass().getResource("/icons/simplifier.png").toExternalForm());
    Image skullGemImage = new Image(getClass().getResource("/icons/skullGem.png").toExternalForm());
    Image sleepySheepImage = new Image(getClass().getResource("/icons/sleepySheep.png").toExternalForm());
    Image sleepyStompImage = new Image(getClass().getResource("/icons/sleepyStomp.png").toExternalForm());
    Image slowGoImage = new Image(getClass().getResource("/icons/slowGo.png").toExternalForm());
    Image slowShroomImage = new Image(getClass().getResource("/icons/slowShroom.png").toExternalForm());
    Image snowBunnyImage = new Image(getClass().getResource("/icons/snowBunny.png").toExternalForm());
    Image softStompImage = new Image(getClass().getResource("/icons/softStomp.png").toExternalForm());
    Image spaceFoodImage = new Image(getClass().getResource("/icons/spaceFood.png").toExternalForm());
    Image spaghettiImage = new Image(getClass().getResource("/icons/spaghetti.png").toExternalForm());
    Image specialCardImage = new Image(getClass().getResource("/icons/specialCard.png").toExternalForm());
    Image spicyPastaImage = new Image(getClass().getResource("/icons/spicyPasta.png").toExternalForm());
    Image spicySoupImage = new Image(getClass().getResource("/icons/spicySoup.png").toExternalForm());
    Image spikeShieldImage = new Image(getClass().getResource("/icons/spikeShield.png").toExternalForm());
    Image spitePouchImage = new Image(getClass().getResource("/icons/spitePouch.png").toExternalForm());
    Image SPOrb1Image = new Image(getClass().getResource("/icons/SPOrb1.png").toExternalForm());
    Image starKeyImage = new Image(getClass().getResource("/icons/starKey.png").toExternalForm());
    Image starPieceImage = new Image(getClass().getResource("/icons/starPiece.png").toExternalForm());
    Image stationKey1Image = new Image(getClass().getResource("/icons/stationKey1.png").toExternalForm());
    Image stationKey2Image = new Image(getClass().getResource("/icons/stationKey2.png").toExternalForm());
    Image steepleKey1Image = new Image(getClass().getResource("/icons/steepleKey1.png").toExternalForm());
    Image steepleKey2Image = new Image(getClass().getResource("/icons/steepleKey2.png").toExternalForm());
    Image stopwatchImage = new Image(getClass().getResource("/icons/stopwatch.png").toExternalForm());
    Image storageKeyImage = new Image(getClass().getResource("/icons/storageKey.png").toExternalForm());
    Image strangeSackImage = new Image(getClass().getResource("/icons/strangeSack.png").toExternalForm());
    Image sunStoneImage = new Image(getClass().getResource("/icons/sunStone.png").toExternalForm());
    Image superAppealImage = new Image(getClass().getResource("/icons/superAppeal.png").toExternalForm());
    Image superAppealPImage = new Image(getClass().getResource("/icons/superAppealP.png").toExternalForm());
    Image superbombombImage = new Image(getClass().getResource("/icons/superbombomb.png").toExternalForm());
    Image superBootsImage = new Image(getClass().getResource("/icons/superBoots.png").toExternalForm());
    Image superChargeImage = new Image(getClass().getResource("/icons/superCharge.png").toExternalForm());
    Image superChargePImage = new Image(getClass().getResource("/icons/superChargeP.png").toExternalForm());
    Image superHammerImage = new Image(getClass().getResource("/icons/superHammer.png").toExternalForm());
    Image superLuigi1Image = new Image(getClass().getResource("/icons/superLuigi1.png").toExternalForm());
    Image superLuigi2Image = new Image(getClass().getResource("/icons/superLuigi2.png").toExternalForm());
    Image superLuigi3Image = new Image(getClass().getResource("/icons/superLuigi3.png").toExternalForm());
    Image superLuigi4Image = new Image(getClass().getResource("/icons/superLuigi4.png").toExternalForm());
    Image superLuigi5Image = new Image(getClass().getResource("/icons/superLuigi5.png").toExternalForm());
    Image superShroomImage = new Image(getClass().getResource("/icons/superShroom.png").toExternalForm());
    Image tastyTonicImage = new Image(getClass().getResource("/icons/tastyTonic.png").toExternalForm());
    Image thunderBoltImage = new Image(getClass().getResource("/icons/thunderBolt.png").toExternalForm());
    Image thunderRageImage = new Image(getClass().getResource("/icons/thunderRage.png").toExternalForm());
    Image timingTutorImage = new Image(getClass().getResource("/icons/timingTutor.png").toExternalForm());
    Image tornadoJumpImage = new Image(getClass().getResource("/icons/tornadoJump.png").toExternalForm());
    Image tradeOffImage = new Image(getClass().getResource("/icons/tradeOff.png").toExternalForm());
    Image trainTicketImage = new Image(getClass().getResource("/icons/trainTicket.png").toExternalForm());
    Image trialStewImage = new Image(getClass().getResource("/icons/trialStew.png").toExternalForm());
    Image tripleDipImage = new Image(getClass().getResource("/icons/tripleDip.png").toExternalForm());
    Image tubeCurseImage = new Image(getClass().getResource("/icons/tubeCurse.png").toExternalForm());
    Image turtleyLeafImage = new Image(getClass().getResource("/icons/turtleyLeaf.png").toExternalForm());
    Image ultraBootsImage = new Image(getClass().getResource("/icons/ultraBoots.png").toExternalForm());
    Image ultraHammerImage = new Image(getClass().getResource("/icons/ultraHammer.png").toExternalForm());
    Image ultraShroomImage = new Image(getClass().getResource("/icons/ultraShroom.png").toExternalForm());
    Image ultraStoneImage = new Image(getClass().getResource("/icons/ultraStone.png").toExternalForm());
    Image unknownImage = new Image(getClass().getResource("/icons/unknown.png").toExternalForm());
    Image unsimplifierImage = new Image(getClass().getResource("/icons/unsimplifier.png").toExternalForm());
    Image unusedDefendImage = new Image(getClass().getResource("/icons/unusedDefend.png").toExternalForm());
    Image unusedDefendPImage = new Image(getClass().getResource("/icons/unusedDefendP.png").toExternalForm());
    Image upArrowImage = new Image(getClass().getResource("/icons/upArrow.png").toExternalForm());
    Image vitalPaperImage = new Image(getClass().getResource("/icons/vitalPaper.png").toExternalForm());
    Image voltShroomImage = new Image(getClass().getResource("/icons/voltShroom.png").toExternalForm());
    Image weddingRingImage = new Image(getClass().getResource("/icons/weddingRing.png").toExternalForm());
    Image wEmblemImage = new Image(getClass().getResource("/icons/wEmblem.png").toExternalForm());
    Image whackaBumpImage = new Image(getClass().getResource("/icons/whackaBump.png").toExternalForm());
    Image wrestingMagazineImage = new Image(getClass().getResource("/icons/wrestingMagazine.png").toExternalForm());
    Image zapTapImage = new Image(getClass().getResource("/icons/zapTap.png").toExternalForm());
    Image zessCookieImage = new Image(getClass().getResource("/icons/zessCookie.png").toExternalForm());
    Image zessDeluxeImage = new Image(getClass().getResource("/icons/zessDeluxe.png").toExternalForm());
    Image zessDinnerImage = new Image(getClass().getResource("/icons/zessDinner.png").toExternalForm());
    Image zessDynamiteImage = new Image(getClass().getResource("/icons/zessDynamite.png").toExternalForm());
    Image zessFrappeImage = new Image(getClass().getResource("/icons/zessFrappe.png").toExternalForm());
    Image zessSpecialImage = new Image(getClass().getResource("/icons/zessSpecial.png").toExternalForm());
    Image zessTeaImage = new Image(getClass().getResource("/icons/zessTea.png").toExternalForm());
    
    ImageView itemsIconImageView = new ImageView(itemsIconImage);
    ImageView sortOrderImageView = new ImageView(strangeSackImage);
    ImageView buyPriceImageView = new ImageView(coinImage);
    ImageView discountPriceImageView = new ImageView(coinImage);
    ImageView starPiecePriceImageView = new ImageView(starPieceImage);
    ImageView sellPriceImageView = new ImageView(coinImage);
    ImageView BPCostImageView = new ImageView(BPEmblemCustomImage);
    ImageView HPRestoredImageView = new ImageView(heartImage);
    ImageView FPRestoredImageView = new ImageView(flowerImage);
    ImageView SPRestoredImageView = new ImageView(SPOrb1Image);

    private CheckBox UseLocationShopBox = new CheckBox();
    private CheckBox UseLocationBattleBox = new CheckBox();
    private CheckBox UseLocationFieldBox = new CheckBox();
    private TextField sortOrderField = new TextField();
    private TextField buyPriceField = new TextField();
    private TextField discountPriceField = new TextField();
    private TextField starPiecePriceField = new TextField();
    private TextField sellPriceField = new TextField();
    private TextField BPCostField = new TextField();
    private TextField HPRestoredField = new TextField();
    private TextField FPRestoredField = new TextField();
    private TextField SPRestoredField = new TextField();

    @Override
    public void start(Stage primaryStage) 
    {
        String[] tempValidFileNames = {"main.dol", "Start.dol"};
        for(int i = 0; i < tempValidFileNames.length; i++)
        {
            validFileNames.add(tempValidFileNames[i]);
        }

        setRed0TextFieldFormats();

        //Window
        window = primaryStage;
        window.setTitle("Item Data Tool");

        //Menu Buttons
        HBox topMenu = new HBox();
        HBox centerMenu = new HBox();
        Button openButton = new Button("Open");
        ComboBox<File> fileSelector = new ComboBox<>();
        Button exportButton = new Button("Export");
        Button aboutButton = new Button("About");
        topMenu.getChildren().addAll(openButton, aboutButton);
        topMenu.setPadding(new Insets(5));
        topMenu.setSpacing(5);

        //Alligning Menu Buttons to Top
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);

        //Scene
        Scene emptyScene = new Scene(borderPane, 800, 600);
        window.setScene(emptyScene);

        openButton.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override public void handle(ActionEvent event)
            {
                DirectoryChooser directoryChooser = new DirectoryChooser();
                directoryChooser.setTitle("Select the root folder");
                givenFile = directoryChooser.showDialog(window);

                ArrayList<File> validFiles = Main.findMatchingFiles(givenFile, validFileNames);

                fileSelector.getItems().clear();
                topMenu.getChildren().clear();
                topMenu.getChildren().addAll(openButton, fileSelector, exportButton, aboutButton);

                for (File f : validFiles)
                {
                    fileSelector.getItems().add(f);
                }

                //Setting list names for Directory Chooser
                fileSelector.setCellFactory(lv -> new ListCell<File>() 
                {
                    @Override protected void updateItem(File item, boolean empty) 
                    {
                        super.updateItem(item, empty);
                        if (empty || item == null) 
                        {
                            setText(null);
                        } 
                        else 
                        {
                            setText(item.getName());
                        }
                    }
                });

                fileSelector.setOnAction(e -> 
                {
                    centerMenu.getChildren().clear();

                    items = Main.getTableData(fileSelector.getSelectionModel().getSelectedItem());
                    isFileOpened = true;
                    test.testUnitData(items);

                    VBox leftMenu = new VBox();

                    for(int i = 0; i < items.size(); i++)
                    {
                        items.get(i).icon = listImageSelector(i);
                    }

                    //Setting struct names for ItemData
                    itemList = new ListView<>();
                    itemList.setCellFactory(lv -> new ListCell<ItemData>() 
                    {
                        @Override protected void updateItem(ItemData item, boolean empty) 
                        {
                            super.updateItem(item, empty);
                            if (empty || item == null) 
                            {
                                setText(null);
                                setGraphic(null);
                            } 
                            else 
                            {
                                HBox imageBox = new HBox();
                                imageBox.getChildren().add(item.icon);
                                setText(item.name);
                                setGraphic(imageBox);
                            }
                        }
                    });

                    GridPane leftMenuForm = new GridPane();
                    upperBox.setPadding(new Insets(3));
                    searchField.setPromptText("Search...");
                    upperBox.getChildren().clear();
                    upperBox.getChildren().add(searchField);
                    leftMenuForm.add(upperBox, 0, 0);

                    HBox baseBox = new HBox();
                    baseBox.setPadding(new Insets(3));
                    itemsIconImageView.setFitWidth(20);
                    itemsIconImageView.setFitHeight(20);
                    baseBox.getChildren().addAll(new Label("Items:", itemsIconImageView));
                    leftMenuForm.add(baseBox, 0, 1);
                    leftMenuForm.add(itemList, 0, 2);

                    RowConstraints growingRow = new RowConstraints();
                    growingRow.setVgrow(Priority.ALWAYS);
                    leftMenuForm.getRowConstraints().addAll(new RowConstraints(), new RowConstraints(), growingRow);

                    // Make itemList fill the cell
                    GridPane.setVgrow(itemList, Priority.ALWAYS);
                    
                    borderPane.setLeft(leftMenuForm);

                    GridPane form = new GridPane();

                    ObservableList<ItemData> observableItems = FXCollections.observableArrayList(items);
                    FilteredList<ItemData> filteredItems = new FilteredList<ItemData>(observableItems, p -> true);
                    itemList.setItems(filteredItems);
                    //itemList.getItems().setAll(items);

                    searchField.textProperty().addListener((obs, oldValue, newValue) -> 
                    {
                        String filter = newValue.toLowerCase();
                        filteredItems.setPredicate(item -> 
                        {
                            if (filter == null || filter.isEmpty()) 
                            {
                                return true;
                            }
                            return item.name.toLowerCase().contains(filter);
                        });
                    });

                    saveChangesButton.setOnAction(new EventHandler<ActionEvent>() 
                    {
                        @Override public void handle(ActionEvent event)
                        {
                            saveFieldsToSelectedStruct();
                            saveChangesButton.setText("    Changes Saved     ");
                        }
                    });

                    itemList.setOnMouseClicked(e2 -> 
                    {
                        centerMenu.getChildren().clear();
                        form.getChildren().clear();

                        upperBox.getChildren().clear();
                        upperBox.getChildren().addAll(searchField, saveChangesButton);

                        ItemData selected = itemList.getSelectionModel().getSelectedItem();

                        if (selected != null) loadStructFields(selected);

                        saveChangesButton.setText("Save Struct Changes");

                        form.setVgap(5);
                        form.setHgap(10);
                        form.setPadding(new Insets(10));

                        buyPriceImageView.setFitWidth(20); buyPriceImageView.setFitHeight(20); form.add(buyPriceImageView, 0, 0);
                        form.add(new Label("Buy Price:"), 1, 0);
                        form.add(buyPriceField, 2, 0);
                        discountPriceImageView.setFitWidth(20); discountPriceImageView.setFitHeight(20); form.add(discountPriceImageView, 0, 1);
                        form.add(new Label("Discount Price:"), 1, 1);
                        form.add(discountPriceField, 2, 1);
                        sellPriceImageView.setFitWidth(20); sellPriceImageView.setFitHeight(20); form.add(sellPriceImageView, 0, 2);
                        form.add(new Label("Sell Price:"), 1, 2);
                        form.add(sellPriceField, 2, 2);
                        starPiecePriceImageView.setFitWidth(20); starPiecePriceImageView.setFitHeight(20); form.add(starPiecePriceImageView, 0, 3);
                        form.add(new Label("Star Piece Price:"), 1, 3);
                        form.add(starPiecePriceField, 2, 3);
                        BPCostImageView.setFitWidth(20); BPCostImageView.setFitHeight(20); form.add(BPCostImageView, 0, 4);
                        form.add(new Label("BP Cost:"), 1, 4);
                        form.add(BPCostField, 2, 4);
                        HPRestoredImageView.setFitWidth(20); HPRestoredImageView.setFitHeight(20); form.add(HPRestoredImageView, 0, 5);
                        form.add(new Label("HP Restored:"), 1, 5);
                        form.add(HPRestoredField, 2, 5);
                        FPRestoredImageView.setFitWidth(20); FPRestoredImageView.setFitHeight(20); form.add(FPRestoredImageView, 0, 6);
                        form.add(new Label("FP Restored:"), 1, 6);
                        form.add(FPRestoredField, 2, 6);
                        SPRestoredImageView.setFitWidth(20); SPRestoredImageView.setFitHeight(20); form.add(SPRestoredImageView, 0, 7);
                        form.add(new Label("SP Restored:"), 1, 7);
                        form.add(SPRestoredField, 2, 7);
                        sortOrderImageView.setFitWidth(20); sortOrderImageView.setFitHeight(20); form.add(sortOrderImageView, 0, 8);
                        form.add(new Label("Sort Order:"), 1, 8);
                        form.add(sortOrderField, 2, 8);
                        form.add(new Label("Can be Used in Shops:"), 1, 9);
                        form.add(UseLocationShopBox, 2, 9);
                        form.add(new Label("Can be Used in Battle:"), 1, 10);
                        form.add(UseLocationBattleBox, 2, 10);
                        form.add(new Label("Can be Used in the Field:"), 1, 11);
                        form.add(UseLocationFieldBox, 2, 11);

                        centerMenu.getChildren().add(form);
                        ScrollPane centerScroll = new ScrollPane();
                        centerScroll.setContent(centerMenu);
                        borderPane.setCenter(centerScroll);
                    });
                });
            }
        });

        exportButton.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override public void handle(ActionEvent event)
            {
                if(isFileOpened)
                {
                    byte[] newFileData = Main.buildNewFile(fileSelector.getSelectionModel().getSelectedItem(), items);
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setInitialFileName(fileSelector.getSelectionModel().getSelectedItem().getName());
                    if(fileSelector.getSelectionModel().getSelectedItem().getName().equals("main.dol") || fileSelector.getSelectionModel().getSelectedItem().getName().equals("Start.dol"))
                    {
                        FileChooser.ExtensionFilter dolFilter = new FileChooser.ExtensionFilter("Gamecube Main Executable File Format (*.dol)", "*.dol");
                        fileChooser.getExtensionFilters().addAll(dolFilter);
                    }
                    else
                    {
                        FileChooser.ExtensionFilter relFilter = new FileChooser.ExtensionFilter("Gamecube Relocatable Executable File Format (*.rel)", "*.rel");
                        fileChooser.getExtensionFilters().addAll(relFilter);
                    }
                    fileChooser.setTitle("Save As");

                    File dest = fileChooser.showSaveDialog(window);
                    if (dest != null) 
                    {
                        try 
                        {
                            FileOutputStream fos = new FileOutputStream(dest);
                            fos.write(newFileData);
                            fos.close();

                            Stage successBox = new Stage();
                            successBox.setTitle("Export");

                            VBox successMenu = new VBox();
                            Text message = new Text("Successfully Saved!");
                            message.setWrappingWidth(290);
                            message.setTextAlignment(TextAlignment.CENTER);
                            successMenu.getChildren().addAll(new Label(""), message);

                            StackPane successPane = new StackPane();
                            successPane.getChildren().add(successMenu);
                            successPane.setAlignment(Pos.CENTER);

                            Scene successScene = new Scene(successPane, 150, 50);

                            successBox.setScene(successScene);
                            successBox.initModality(Modality.APPLICATION_MODAL);
                            successBox.show();
                        } 
                        catch (IOException ex) 
                        {
                            System.out.println("There was an error creating the output file");
                        }
                    }
                }
            }
        });

        aboutButton.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override public void handle(ActionEvent event)
            {
                Stage alertBox = new Stage();
                alertBox.setTitle("About");

                VBox alertMenu = new VBox();
                alertMenu.setAlignment(Pos.CENTER);
                Text version = new Text("Written by Jemaroo     Version: 1.0.0");
                version.setWrappingWidth(290);
                version.setTextAlignment(TextAlignment.CENTER);
                Text description = new Text("TTYDItemDataTool allows you to open up the game's main dol or any rel file containing item data and edit item data fields.");
                description.setWrappingWidth(290);
                description.setTextAlignment(TextAlignment.CENTER);
                alertMenu.getChildren().addAll(new Label(""), version, new Label(""), description);

                StackPane alertPane = new StackPane();
                alertPane.getChildren().add(alertMenu);
                alertPane.setAlignment(Pos.CENTER);

                Scene alertScene = new Scene(alertPane, 350, 150);

                alertBox.setScene(alertScene);
                alertBox.initModality(Modality.APPLICATION_MODAL);
                alertBox.show();
            }
        });

        window.getIcons().add(itemsIconImage);
        window.show();
    }

    /**
     * @Author Jemaroo
     * @Function Loads ItemData Array Data into text fields
     */
    private void loadStructFields(Object struct) 
    {
        if (struct instanceof ItemData) 
        {
            ItemData b = (ItemData) struct;
            UseLocationShopBox.setSelected(b.UseLocationShop);
            UseLocationBattleBox.setSelected(b.UseLocationBattle);
            UseLocationFieldBox.setSelected(b.UseLocationField);
            sortOrderField.setText(String.valueOf(b.sortOrder));
            buyPriceField.setText(String.valueOf(b.buyPrice));
            discountPriceField.setText(String.valueOf(b.discountPrice));
            starPiecePriceField.setText(String.valueOf(b.starPiecePrice));
            sellPriceField.setText(String.valueOf(b.sellPrice));
            BPCostField.setText(String.valueOf(b.BPCost));
            HPRestoredField.setText(String.valueOf(b.HPRestored));
            FPRestoredField.setText(String.valueOf(b.FPRestored));
            SPRestoredField.setText(String.valueOf(b.SPRestored));
        } 
    }

    /**
     * @Author Jemaroo
     * @Function Saves the text fields to the loaded ItemData Data
     */
    private void saveFieldsToSelectedStruct() 
    {
        Object selected = null;
        if (itemList.getSelectionModel().getSelectedItem() != null) 
        {
            selected = itemList.getSelectionModel().getSelectedItem();
        }

        if (selected instanceof ItemData b) 
        {
            b.UseLocationShop = UseLocationShopBox.isSelected();
            b.UseLocationBattle = UseLocationBattleBox.isSelected();
            b.UseLocationField = UseLocationFieldBox.isSelected();
            b.sortOrder = Integer.parseInt(sortOrderField.getText());
            b.buyPrice = Integer.parseInt(buyPriceField.getText());
            b.discountPrice = Integer.parseInt(discountPriceField.getText());
            b.starPiecePrice = Integer.parseInt(starPiecePriceField.getText());
            b.sellPrice = Integer.parseInt(sellPriceField.getText());
            b.BPCost = Integer.parseInt(BPCostField.getText());
            b.HPRestored = Integer.parseInt(HPRestoredField.getText());
            b.FPRestored = Integer.parseInt(FPRestoredField.getText());
            b.SPRestored = Integer.parseInt(SPRestoredField.getText());
        }
    }

    public void setRed0TextFieldFormats()
    {
        sortOrderField.textProperty().addListener((obs, oldText, newText) -> { if ("0".equals(newText)) {sortOrderField.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");} else {sortOrderField.setStyle("-fx-text-fill: black;");}});
        buyPriceField.textProperty().addListener((obs, oldText, newText) -> { if ("0".equals(newText)) {buyPriceField.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");} else {buyPriceField.setStyle("-fx-text-fill: black;");}});
        discountPriceField.textProperty().addListener((obs, oldText, newText) -> { if ("0".equals(newText)) {discountPriceField.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");} else {discountPriceField.setStyle("-fx-text-fill: black;");}});
        starPiecePriceField.textProperty().addListener((obs, oldText, newText) -> { if ("0".equals(newText)) {starPiecePriceField.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");} else {starPiecePriceField.setStyle("-fx-text-fill: black;");}});
        sellPriceField.textProperty().addListener((obs, oldText, newText) -> { if ("0".equals(newText)) {sellPriceField.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");} else {sellPriceField.setStyle("-fx-text-fill: black;");}});
        BPCostField.textProperty().addListener((obs, oldText, newText) -> { if ("0".equals(newText)) {BPCostField.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");} else {BPCostField.setStyle("-fx-text-fill: black;");}});
        HPRestoredField.textProperty().addListener((obs, oldText, newText) -> { if ("0".equals(newText)) {HPRestoredField.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");} else {HPRestoredField.setStyle("-fx-text-fill: black;");}});
        FPRestoredField.textProperty().addListener((obs, oldText, newText) -> { if ("0".equals(newText)) {FPRestoredField.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");} else {FPRestoredField.setStyle("-fx-text-fill: black;");}});
        SPRestoredField.textProperty().addListener((obs, oldText, newText) -> { if ("0".equals(newText)) {SPRestoredField.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");} else {SPRestoredField.setStyle("-fx-text-fill: black;");}});
    }

    public ImageView listImageSelector(int index)
    {
        ImageView retIV;
        if(index == 0){retIV = new ImageView(nothingImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 1){retIV = new ImageView(strangeSackImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 2){retIV = new ImageView(paperCurseImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 3){retIV = new ImageView(tubeCurseImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 4){retIV = new ImageView(planeCurseImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 5){retIV = new ImageView(boatCurseImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 6){retIV = new ImageView(bootsImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 7){retIV = new ImageView(superBootsImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 8){retIV = new ImageView(ultraBootsImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 9){retIV = new ImageView(hammerImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 10){retIV = new ImageView(superHammerImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 11){retIV = new ImageView(ultraHammerImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 12){retIV = new ImageView(castleKeyImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 13){retIV = new ImageView(castleKeyImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 14){retIV = new ImageView(castleKeyImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 15){retIV = new ImageView(castleKeyImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 16){retIV = new ImageView(redKeyImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 17){retIV = new ImageView(blueKeyImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 18){retIV = new ImageView(storageKeyImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 19){retIV = new ImageView(storageKeyImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 20){retIV = new ImageView(grottoKeyImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 21){retIV = new ImageView(storageKeyImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 22){retIV = new ImageView(steepleKey1Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 23){retIV = new ImageView(steepleKey2Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 24){retIV = new ImageView(stationKey1Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 25){retIV = new ImageView(stationKey2Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 26){retIV = new ImageView(elevatorKey1Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 27){retIV = new ImageView(elevatorKey2Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 28){retIV = new ImageView(elevatorKey3Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 29){retIV = new ImageView(cardKey1Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 30){retIV = new ImageView(cardKey2Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 31){retIV = new ImageView(cardKey3Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 32){retIV = new ImageView(cardKey4Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 33){retIV = new ImageView(blackKeyImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 34){retIV = new ImageView(blackKeyImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 35){retIV = new ImageView(blackKeyImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 36){retIV = new ImageView(blackKeyImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 37){retIV = new ImageView(starKeyImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 38){retIV = new ImageView(palaceKey2Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 39){retIV = new ImageView(palaceKey2Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 40){retIV = new ImageView(palaceKey2Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 41){retIV = new ImageView(palaceKey2Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 42){retIV = new ImageView(palaceKey2Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 43){retIV = new ImageView(palaceKey2Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 44){retIV = new ImageView(palaceKey2Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 45){retIV = new ImageView(palaceKey2Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 46){retIV = new ImageView(palaceKey1Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 47){retIV = new ImageView(palaceKey1Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 48){retIV = new ImageView(palaceKey1Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 49){retIV = new ImageView(houseKeyImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 50){retIV = new ImageView(magicalMap1Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 51){retIV = new ImageView(contactLensImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 52){retIV = new ImageView(blimpTicketImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 53){retIV = new ImageView(trainTicketImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 54){retIV = new ImageView(mailboxSPImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 55){retIV = new ImageView(superLuigi1Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 56){retIV = new ImageView(superLuigi2Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 57){retIV = new ImageView(superLuigi3Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 58){retIV = new ImageView(superLuigi4Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 59){retIV = new ImageView(superLuigi5Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 60){retIV = new ImageView(cookbookImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 61){retIV = new ImageView(moonStoneImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 62){retIV = new ImageView(sunStoneImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 63){retIV = new ImageView(necklaceImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 64){retIV = new ImageView(puniOrbImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 65){retIV = new ImageView(champsBeltImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 66){retIV = new ImageView(poisonedCakeImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 67){retIV = new ImageView(superbombombImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 68){retIV = new ImageView(pImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 69){retIV = new ImageView(oldLetterImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 70){retIV = new ImageView(chuckolaColaImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 71){retIV = new ImageView(skullGemImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 72){retIV = new ImageView(gateHandleImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 73){retIV = new ImageView(weddingRingImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 74){retIV = new ImageView(galleyPotImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 75){retIV = new ImageView(goldRingImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 76){retIV = new ImageView(shellEarringsImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 77){retIV = new ImageView(autographImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 78){retIV = new ImageView(raggedDiaryImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 79){retIV = new ImageView(blanketImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 80){retIV = new ImageView(vitalPaperImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 81){retIV = new ImageView(briefcaseImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 82){retIV = new ImageView(goldbobGuide1Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 83){retIV = new ImageView(goldbobGuide2Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 84){retIV = new ImageView(goldbobGuide3Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 85){retIV = new ImageView(cogImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 86){retIV = new ImageView(dataDiskImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 87){retIV = new ImageView(shineSpriteImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 88){retIV = new ImageView(ultraStoneImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 89){retIV = new ImageView(bowserMeatImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 90){retIV = new ImageView(marioWantedPosterImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 91){retIV = new ImageView(specialCardImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 92){retIV = new ImageView(platinumCardImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 93){retIV = new ImageView(goldCardImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 94){retIV = new ImageView(silverCardImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 95){retIV = new ImageView(boxImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 96){retIV = new ImageView(magicalMap2Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 97){retIV = new ImageView(dubiousPaperImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 98){retIV = new ImageView(routingSlipImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 99){retIV = new ImageView(wrestingMagazineImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 100){retIV = new ImageView(presentImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 101){retIV = new ImageView(bluePotionImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 102){retIV = new ImageView(redPotionImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 103){retIV = new ImageView(orangePotionImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 104){retIV = new ImageView(greenPotionImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 105){retIV = new ImageView(unknownImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 106){retIV = new ImageView(lotteryPickImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 107){retIV = new ImageView(battleTrunksImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 108){retIV = new ImageView(upArrowImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 109){retIV = new ImageView(boxImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 110){retIV = new ImageView(attackFXBImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 111){retIV = new ImageView(unknownImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 112){retIV = new ImageView(unknownImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 113){retIV = new ImageView(unknownImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 114){retIV = new ImageView(diamondStarImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 115){retIV = new ImageView(emeraldStarImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 116){retIV = new ImageView(goldStarImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 117){retIV = new ImageView(rubyStarImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 118){retIV = new ImageView(sapphireStarImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 119){retIV = new ImageView(garnetStarImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 120){retIV = new ImageView(crystalStarImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 121){retIV = new ImageView(coinImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 122){retIV = new ImageView(piantaImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 123){retIV = new ImageView(heartImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 124){retIV = new ImageView(flowerImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 125){retIV = new ImageView(starPieceImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 126){retIV = new ImageView(goldBarImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 127){retIV = new ImageView(goldBarX3Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 128){retIV = new ImageView(thunderBoltImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 129){retIV = new ImageView(thunderRageImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 130){retIV = new ImageView(shootingStarImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 131){retIV = new ImageView(iceStormImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 132){retIV = new ImageView(fireFlowerImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 133){retIV = new ImageView(earthQuakeImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 134){retIV = new ImageView(boosSheetImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 135){retIV = new ImageView(voltShroomImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 136){retIV = new ImageView(repelCapeImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 137){retIV = new ImageView(ruinPowderImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 138){retIV = new ImageView(sleepySheepImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 139){retIV = new ImageView(powBlockImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 140){retIV = new ImageView(stopwatchImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 141){retIV = new ImageView(dizzyDialImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 142){retIV = new ImageView(powerPunchImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 143){retIV = new ImageView(courageShellImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 144){retIV = new ImageView(HPDrain1Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 145){retIV = new ImageView(tradeOffImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 146){retIV = new ImageView(miniMrMiniImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 147){retIV = new ImageView(mrsoftenerImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 148){retIV = new ImageView(mushroomImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 149){retIV = new ImageView(superShroomImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 150){retIV = new ImageView(ultraShroomImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 151){retIV = new ImageView(lifeShroomImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 152){retIV = new ImageView(driedShroomImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 153){retIV = new ImageView(tastyTonicImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 154){retIV = new ImageView(honeySyrupImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 155){retIV = new ImageView(mapleSyrupImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 156){retIV = new ImageView(jamminJellyImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 157){retIV = new ImageView(slowShroomImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 158){retIV = new ImageView(gradualSyrupImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 159){retIV = new ImageView(hotDogImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 160){retIV = new ImageView(cakeImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 161){retIV = new ImageView(pointSwapImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 162){retIV = new ImageView(frightMaskImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 163){retIV = new ImageView(mysteryImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 164){retIV = new ImageView(innCouponImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 165){retIV = new ImageView(whackaBumpImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 166){retIV = new ImageView(coconutImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 167){retIV = new ImageView(driedbouquetImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 168){retIV = new ImageView(mysticEggImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 169){retIV = new ImageView(goldenLeafImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 170){retIV = new ImageView(keelMangoImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 171){retIV = new ImageView(freshPastaImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 172){retIV = new ImageView(cakeMixImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 173){retIV = new ImageView(hotSauceImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 174){retIV = new ImageView(turtleyLeafImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 175){retIV = new ImageView(horsetailImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 176){retIV = new ImageView(peachyPeachImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 177){retIV = new ImageView(spitePouchImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 178){retIV = new ImageView(koopaCurseImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 179){retIV = new ImageView(shroomFryImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 180){retIV = new ImageView(shroomRoastImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 181){retIV = new ImageView(shroomSteakImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 182){retIV = new ImageView(mistakeImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 183){retIV = new ImageView(honeyShroomImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 184){retIV = new ImageView(mapleShroomImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 185){retIV = new ImageView(jellyShroomImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 186){retIV = new ImageView(honeySuperImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 187){retIV = new ImageView(mapleSuperImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 188){retIV = new ImageView(jellySuperImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 189){retIV = new ImageView(honeyUltraImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 190){retIV = new ImageView(mapleUltraImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 191){retIV = new ImageView(jellyUltraImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 192){retIV = new ImageView(spicySoupImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 193){retIV = new ImageView(zessDinnerImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 194){retIV = new ImageView(zessSpecialImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 195){retIV = new ImageView(zessDeluxeImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 196){retIV = new ImageView(zessDynamiteImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 197){retIV = new ImageView(zessTeaImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 198){retIV = new ImageView(spaceFoodImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 199){retIV = new ImageView(iciclePopImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 200){retIV = new ImageView(zessFrappeImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 201){retIV = new ImageView(snowBunnyImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 202){retIV = new ImageView(coconutBombImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 203){retIV = new ImageView(courageMealImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 204){retIV = new ImageView(shroomCakeImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 205){retIV = new ImageView(shroomCrepeImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 206){retIV = new ImageView(mousseCakeImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 207){retIV = new ImageView(friedEggImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 208){retIV = new ImageView(fruitParfaitImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 209){retIV = new ImageView(eggBombImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 210){retIV = new ImageView(inkPastaImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 211){retIV = new ImageView(spaghettiImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 212){retIV = new ImageView(shroomBrothImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 213){retIV = new ImageView(poisonShroomImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 214){retIV = new ImageView(chocoCakeImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 215){retIV = new ImageView(mangoDelightImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 216){retIV = new ImageView(lovePuddingImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 217){retIV = new ImageView(meteorMealImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 218){retIV = new ImageView(trialStewImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 219){retIV = new ImageView(couplesCakeImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 220){retIV = new ImageView(inkySauceImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 221){retIV = new ImageView(omeletteMealImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 222){retIV = new ImageView(koopaTeaImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 223){retIV = new ImageView(koopastaImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 224){retIV = new ImageView(spicyPastaImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 225){retIV = new ImageView(heartfulCakeImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 226){retIV = new ImageView(peachTartImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 227){retIV = new ImageView(electroPopImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 228){retIV = new ImageView(firePopImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 229){retIV = new ImageView(honeyCandyImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 230){retIV = new ImageView(cocoCandyImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 231){retIV = new ImageView(jellyCandyImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 232){retIV = new ImageView(zessCookieImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 233){retIV = new ImageView(healthySaladImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 234){retIV = new ImageView(koopaBunImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 235){retIV = new ImageView(freshJuiceImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 236){retIV = new ImageView(audienceCanImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 237){retIV = new ImageView(audienceRockImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 238){retIV = new ImageView(audienceBoneImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 239){retIV = new ImageView(audienceHammerImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 240){retIV = new ImageView(powerJumpImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 241){retIV = new ImageView(multibounceImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 242){retIV = new ImageView(powerBounceImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 243){retIV = new ImageView(tornadoJumpImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 244){retIV = new ImageView(shrinkStompImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 245){retIV = new ImageView(sleepyStompImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 246){retIV = new ImageView(softStompImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 247){retIV = new ImageView(powerSmashImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 248){retIV = new ImageView(quakeHammerImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 249){retIV = new ImageView(hammerThrowImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 250){retIV = new ImageView(piercingBlowImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 251){retIV = new ImageView(headRattleImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 252){retIV = new ImageView(fireDriveImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 253){retIV = new ImageView(iceSmashImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 254){retIV = new ImageView(doubleDipImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 255){retIV = new ImageView(doubleDipPImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 256){retIV = new ImageView(chargeImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 257){retIV = new ImageView(chargePImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 258){retIV = new ImageView(superAppealImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 259){retIV = new ImageView(superAppealPImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 260){retIV = new ImageView(powerPlusImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 261){retIV = new ImageView(powerPlusPImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 262){retIV = new ImageView(PUpDDownImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 263){retIV = new ImageView(PUpDDownPImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 264){retIV = new ImageView(allOrNothingImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 265){retIV = new ImageView(allOrNothingPImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 266){retIV = new ImageView(megaRushImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 267){retIV = new ImageView(megaRushPImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 268){retIV = new ImageView(powerRushImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 269){retIV = new ImageView(powerRushPImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 270){retIV = new ImageView(PDownDUpImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 271){retIV = new ImageView(PDownDUpPImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 272){retIV = new ImageView(lastStandImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 273){retIV = new ImageView(lastStandPImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 274){retIV = new ImageView(defendPlusImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 275){retIV = new ImageView(defendPlusPImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 276){retIV = new ImageView(damageDodgeImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 277){retIV = new ImageView(damageDodgePImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 278){retIV = new ImageView(HPPlusImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 279){retIV = new ImageView(HPPlusPImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 280){retIV = new ImageView(FPPlusImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 281){retIV = new ImageView(flowerSaverImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 282){retIV = new ImageView(flowerSaverPImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 283){retIV = new ImageView(icePowerImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 284){retIV = new ImageView(spikeShieldImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 285){retIV = new ImageView(feelingFineImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 286){retIV = new ImageView(feelingFinePImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 287){retIV = new ImageView(zapTapImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 288){retIV = new ImageView(doublePainImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 289){retIV = new ImageView(jumpManImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 290){retIV = new ImageView(hammerManImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 291){retIV = new ImageView(returnPostageImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 292){retIV = new ImageView(happyHeartImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 293){retIV = new ImageView(happyHeartPImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 294){retIV = new ImageView(happyFlowerImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 295){retIV = new ImageView(HPDrain2Image); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 296){retIV = new ImageView(HPDrainPImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 297){retIV = new ImageView(FPDrainImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 298){retIV = new ImageView(FPDrainPImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 299){retIV = new ImageView(closeCallImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 300){retIV = new ImageView(closeCallPImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 301){retIV = new ImageView(prettyLuckyImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 302){retIV = new ImageView(prettyLuckyPImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 303){retIV = new ImageView(luckyDayImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 304){retIV = new ImageView(luckyDayPImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 305){retIV = new ImageView(refundImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 306){retIV = new ImageView(pityFlowerImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 307){retIV = new ImageView(pityFlowerPImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 308){retIV = new ImageView(quickChangeImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 309){retIV = new ImageView(peekabooImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 310){retIV = new ImageView(timingTutorImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 311){retIV = new ImageView(heartFinderImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 312){retIV = new ImageView(flowerFinderImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 313){retIV = new ImageView(moneyMoneyImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 314){retIV = new ImageView(itemHogImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 315){retIV = new ImageView(attackFXRImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 316){retIV = new ImageView(attackFXBImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 317){retIV = new ImageView(attackFXGImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 318){retIV = new ImageView(attackFXYImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 319){retIV = new ImageView(attackFXPImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 320){retIV = new ImageView(chillOutImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 321){retIV = new ImageView(firstAttackImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 322){retIV = new ImageView(bumpAttackImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 323){retIV = new ImageView(slowGoImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 324){retIV = new ImageView(simplifierImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 325){retIV = new ImageView(unsimplifierImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 326){retIV = new ImageView(luckyStartImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 327){retIV = new ImageView(lEmblemImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 328){retIV = new ImageView(wEmblemImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 329){retIV = new ImageView(tripleDipImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 330){retIV = new ImageView(luckyStartPImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 331){retIV = new ImageView(zapTapImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 332){retIV = new ImageView(megaJumpImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 333){retIV = new ImageView(megaSmashImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 334){retIV = new ImageView(megaQuakeImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 335){retIV = new ImageView(unusedDefendImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 336){retIV = new ImageView(unusedDefendPImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 337){retIV = new ImageView(superChargeImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        if(index == 338){retIV = new ImageView(superChargePImage); retIV.setFitHeight(20); retIV.setFitWidth(20); return retIV;}
        
        return new ImageView(nothingImage);
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}