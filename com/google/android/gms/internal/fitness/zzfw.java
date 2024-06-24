package com.google.android.gms.internal.fitness;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public enum zzfw {
    AEROBICS(9, "aerobics"),
    ARCHERY(119, "archery"),
    BADMINTON(10, "badminton"),
    BASEBALL(11, "baseball"),
    BASKETBALL(12, "basketball"),
    BIATHLON(13, "biathlon"),
    BIKING(1, "biking"),
    BIKING_HAND(14, "biking.hand"),
    BIKING_MOUNTAIN(15, "biking.mountain"),
    BIKING_ROAD(16, "biking.road"),
    BIKING_SPINNING(17, "biking.spinning"),
    BIKING_STATIONARY(18, "biking.stationary"),
    BIKING_UTILITY(19, "biking.utility"),
    BOXING(20, "boxing"),
    CALISTHENICS(21, "calisthenics"),
    CIRCUIT_TRAINING(22, "circuit_training"),
    CRICKET(23, "cricket"),
    CROSSFIT(113, "crossfit"),
    CURLING(106, "curling"),
    DANCING(24, "dancing"),
    DIVING(102, "diving"),
    ELEVATOR(117, "elevator"),
    ELLIPTICAL(25, "elliptical"),
    ERGOMETER(103, "ergometer"),
    ESCALATOR(118, "escalator"),
    EXITING_VEHICLE(6, "exiting_vehicle"),
    FENCING(26, "fencing"),
    FLOSSING(121, "flossing"),
    FOOTBALL_AMERICAN(27, "football.american"),
    FOOTBALL_AUSTRALIAN(28, "football.australian"),
    FOOTBALL_SOCCER(29, "football.soccer"),
    FRISBEE_DISC(30, "frisbee_disc"),
    GARDENING(31, "gardening"),
    GOLF(32, "golf"),
    GUIDED_BREATHING(122, "guided_breathing"),
    GYMNASTICS(33, "gymnastics"),
    HANDBALL(34, "handball"),
    HIGH_INTENSITY_INTERVAL_TRAINING(114, "interval_training.high_intensity"),
    HIKING(35, "hiking"),
    HOCKEY(36, "hockey"),
    HORSEBACK_RIDING(37, "horseback_riding"),
    HOUSEWORK(38, "housework"),
    ICE_SKATING(104, "ice_skating"),
    INTERVAL_TRAINING(115, "interval_training"),
    IN_VEHICLE(0, "in_vehicle"),
    JUMP_ROPE(39, "jump_rope"),
    KAYAKING(40, "kayaking"),
    KETTLEBELL_TRAINING(41, "kettlebell_training"),
    KICKBOXING(42, "kickboxing"),
    KICK_SCOOTER(107, "kick_scooter"),
    KITESURFING(43, "kitesurfing"),
    MARTIAL_ARTS(44, "martial_arts"),
    MEDITATION(45, "meditation"),
    MIXED_MARTIAL_ARTS(46, "martial_arts.mixed"),
    ON_FOOT(2, "on_foot"),
    OTHER(108, "other"),
    P90X(47, "p90x"),
    PARAGLIDING(48, "paragliding"),
    PILATES(49, "pilates"),
    POLO(50, "polo"),
    RACQUETBALL(51, "racquetball"),
    ROCK_CLIMBING(52, "rock_climbing"),
    ROWING(53, "rowing"),
    ROWING_MACHINE(54, "rowing.machine"),
    RUGBY(55, "rugby"),
    RUNNING(8, "running"),
    RUNNING_JOGGING(56, "running.jogging"),
    RUNNING_SAND(57, "running.sand"),
    RUNNING_TREADMILL(58, "running.treadmill"),
    SAILING(59, "sailing"),
    SCUBA_DIVING(60, "scuba_diving"),
    SKATEBOARDING(61, "skateboarding"),
    SKATING(62, "skating"),
    SKATING_CROSS(63, "skating.cross"),
    SKATING_INDOOR(105, "skating.indoor"),
    SKATING_INLINE(64, "skating.inline"),
    SKIING(65, "skiing"),
    SKIING_BACK_COUNTRY(66, "skiing.back_country"),
    SKIING_CROSS_COUNTRY(67, "skiing.cross_country"),
    SKIING_DOWNHILL(68, "skiing.downhill"),
    SKIING_KITE(69, "skiing.kite"),
    SKIING_ROLLER(70, "skiing.roller"),
    SLEDDING(71, "sledding"),
    SLEEP(72, "sleep"),
    SLEEP_AWAKE(112, "sleep.awake"),
    SLEEP_DEEP(110, "sleep.deep"),
    SLEEP_LIGHT(109, "sleep.light"),
    SLEEP_REM(111, "sleep.rem"),
    SNOWBOARDING(73, "snowboarding"),
    SNOWMOBILE(74, "snowmobile"),
    SNOWSHOEING(75, "snowshoeing"),
    SOFTBALL(120, "softball"),
    SQUASH(76, "squash"),
    STAIR_CLIMBING(77, "stair_climbing"),
    STAIR_CLIMBING_MACHINE(78, "stair_climbing.machine"),
    STANDUP_PADDLEBOARDING(79, "standup_paddleboarding"),
    STILL(3, "still"),
    STRENGTH_TRAINING(80, "strength_training"),
    SURFING(81, "surfing"),
    SWIMMING(82, "swimming"),
    SWIMMING_OPEN_WATER(84, "swimming.open_water"),
    SWIMMING_POOL(83, "swimming.pool"),
    TABLE_TENNIS(85, "table_tennis"),
    TEAM_SPORTS(86, "team_sports"),
    TENNIS(87, "tennis"),
    TILTING(5, "tilting"),
    TREADMILL(88, "treadmill"),
    UNKNOWN(4, "unknown"),
    VOLLEYBALL(89, "volleyball"),
    VOLLEYBALL_BEACH(90, "volleyball.beach"),
    VOLLEYBALL_INDOOR(91, "volleyball.indoor"),
    WAKEBOARDING(92, "wakeboarding"),
    WALKING(7, "walking"),
    WALKING_FITNESS(93, "walking.fitness"),
    WALKING_NORDIC(94, "walking.nordic"),
    WALKING_PACED(123, "walking.paced"),
    WALKING_STROLLER(116, "walking.stroller"),
    WALKING_TREADMILL(95, "walking.treadmill"),
    WATER_POLO(96, "water_polo"),
    WEIGHTLIFTING(97, "weightlifting"),
    WHEELCHAIR(98, "wheelchair"),
    WINDSURFING(99, "windsurfing"),
    YOGA(100, "yoga"),
    ZUMBA(101, "zumba");

    private static final zzfm zzbu;
    private static final zzfn zzbv;
    private final int zzbx;
    private final String zzby;

    static {
        zzfq zzfqVar;
        EnumSet allOf = EnumSet.allOf(zzfw.class);
        ArrayList arrayList = new ArrayList(Collections.nCopies(allOf.size(), null));
        Iterator it = allOf.iterator();
        while (it.hasNext()) {
            zzfw zzfwVar = (zzfw) it.next();
            arrayList.set(zzfwVar.zzbx, zzfwVar);
        }
        zzfk zzfkVar = zzfm.zza;
        Object[] array = arrayList.toArray();
        int length = array.length;
        for (int r2 = 0; r2 < length; r2++) {
            if (array[r2] == null) {
                throw new NullPointerException(SubMenuBuilder$$ExternalSyntheticOutline0.m("at index ", r2));
            }
        }
        if (length == 0) {
            zzfqVar = zzfq.zza;
        } else {
            zzfqVar = new zzfq(length, array);
        }
        zzbu = zzfqVar;
        zzbv = zzfn.zzk(5, Integer.valueOf(SLEEP.zzbx), Integer.valueOf(SLEEP_AWAKE.zzbx), Integer.valueOf(SLEEP_DEEP.zzbx), Integer.valueOf(SLEEP_LIGHT.zzbx), Integer.valueOf(SLEEP_REM.zzbx));
    }

    zzfw(int r3, String str) {
        this.zzbx = r3;
        this.zzby = str;
    }

    public static zzfw zza(int r2, zzfw zzfwVar) {
        if (r2 >= 0) {
            zzfm zzfmVar = zzbu;
            if (r2 < zzfmVar.size()) {
                return (zzfw) zzfmVar.get(r2);
            }
        }
        return zzfwVar;
    }

    public final boolean zzb() {
        return zzbv.contains(Integer.valueOf(this.zzbx));
    }
}
