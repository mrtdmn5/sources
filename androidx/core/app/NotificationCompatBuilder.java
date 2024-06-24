package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.LocusId;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.RemoteViews;
import androidx.collection.ArraySet;
import androidx.core.app.Person;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.IconCompat;
import com.animaconnected.secondo.screens.details.bottomdialog.DetailBottomDialog;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class NotificationCompatBuilder {
    public final Notification.Builder mBuilder;
    public final NotificationCompat$Builder mBuilderCompat;
    public final Context mContext;
    public final Bundle mExtras;

    /* loaded from: classes.dex */
    public static class Api16Impl {
        public static Notification build(Notification.Builder builder) {
            return builder.build();
        }

        public static Notification.Builder setPriority(Notification.Builder builder, int r1) {
            return builder.setPriority(r1);
        }

        public static Notification.Builder setSubText(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSubText(charSequence);
        }

        public static Notification.Builder setUsesChronometer(Notification.Builder builder, boolean z) {
            return builder.setUsesChronometer(z);
        }
    }

    /* loaded from: classes.dex */
    public static class Api17Impl {
        public static Notification.Builder setShowWhen(Notification.Builder builder, boolean z) {
            return builder.setShowWhen(z);
        }
    }

    /* loaded from: classes.dex */
    public static class Api19Impl {
        public static Notification.Builder setExtras(Notification.Builder builder, Bundle bundle) {
            return builder.setExtras(bundle);
        }
    }

    /* loaded from: classes.dex */
    public static class Api20Impl {
        public static Notification.Builder addAction(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        public static Notification.Action.Builder addExtras(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        public static Notification.Action.Builder addRemoteInput(Notification.Action.Builder builder, android.app.RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        public static Notification.Action build(Notification.Action.Builder builder) {
            return builder.build();
        }

        public static Notification.Action.Builder createBuilder(int r1, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(r1, charSequence, pendingIntent);
        }

        public static String getGroup(Notification notification) {
            return notification.getGroup();
        }

        public static Notification.Builder setGroup(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        public static Notification.Builder setGroupSummary(Notification.Builder builder, boolean z) {
            return builder.setGroupSummary(z);
        }

        public static Notification.Builder setLocalOnly(Notification.Builder builder, boolean z) {
            return builder.setLocalOnly(z);
        }

        public static Notification.Builder setSortKey(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    /* loaded from: classes.dex */
    public static class Api21Impl {
        public static Notification.Builder addPerson(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        public static Notification.Builder setCategory(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        public static Notification.Builder setColor(Notification.Builder builder, int r1) {
            return builder.setColor(r1);
        }

        public static Notification.Builder setPublicVersion(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        public static Notification.Builder setSound(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        public static Notification.Builder setVisibility(Notification.Builder builder, int r1) {
            return builder.setVisibility(r1);
        }
    }

    /* loaded from: classes.dex */
    public static class Api23Impl {
        public static Notification.Action.Builder createBuilder(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        public static Notification.Builder setLargeIcon(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }

        public static Notification.Builder setSmallIcon(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    /* loaded from: classes.dex */
    public static class Api24Impl {
        public static Notification.Action.Builder setAllowGeneratedReplies(Notification.Action.Builder builder, boolean z) {
            return builder.setAllowGeneratedReplies(z);
        }

        public static Notification.Builder setCustomBigContentView(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        public static Notification.Builder setCustomContentView(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        public static Notification.Builder setCustomHeadsUpContentView(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        public static Notification.Builder setRemoteInputHistory(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }
    }

    /* loaded from: classes.dex */
    public static class Api26Impl {
        public static Notification.Builder createBuilder(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        public static Notification.Builder setBadgeIconType(Notification.Builder builder, int r1) {
            return builder.setBadgeIconType(r1);
        }

        public static Notification.Builder setColorized(Notification.Builder builder, boolean z) {
            return builder.setColorized(z);
        }

        public static Notification.Builder setGroupAlertBehavior(Notification.Builder builder, int r1) {
            return builder.setGroupAlertBehavior(r1);
        }

        public static Notification.Builder setSettingsText(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        public static Notification.Builder setShortcutId(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        public static Notification.Builder setTimeoutAfter(Notification.Builder builder, long j) {
            return builder.setTimeoutAfter(j);
        }
    }

    /* loaded from: classes.dex */
    public static class Api28Impl {
        public static Notification.Builder addPerson(Notification.Builder builder, android.app.Person person) {
            return builder.addPerson(person);
        }

        public static Notification.Action.Builder setSemanticAction(Notification.Action.Builder builder, int r1) {
            return builder.setSemanticAction(r1);
        }
    }

    /* loaded from: classes.dex */
    public static class Api29Impl {
        public static Notification.Builder setAllowSystemGeneratedContextualActions(Notification.Builder builder, boolean z) {
            return builder.setAllowSystemGeneratedContextualActions(z);
        }

        public static Notification.Builder setBubbleMetadata(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        public static Notification.Action.Builder setContextual(Notification.Action.Builder builder, boolean z) {
            return builder.setContextual(z);
        }

        public static Notification.Builder setLocusId(Notification.Builder builder, Object obj) {
            return builder.setLocusId((LocusId) obj);
        }
    }

    /* loaded from: classes.dex */
    public static class Api31Impl {
        public static Notification.Action.Builder setAuthenticationRequired(Notification.Action.Builder builder, boolean z) {
            return builder.setAuthenticationRequired(z);
        }

        public static Notification.Builder setForegroundServiceBehavior(Notification.Builder builder, int r1) {
            return builder.setForegroundServiceBehavior(r1);
        }
    }

    public NotificationCompatBuilder(NotificationCompat$Builder notificationCompat$Builder) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Icon icon;
        ArrayList<Person> arrayList;
        Bundle bundle;
        ArrayList<NotificationCompat$Action> arrayList2;
        String str;
        ArrayList<Person> arrayList3;
        Bundle[] bundleArr;
        int r15;
        ArrayList<String> arrayList4;
        RemoteInput[] remoteInputArr;
        RemoteInput[] remoteInputArr2;
        NotificationCompatBuilder notificationCompatBuilder = this;
        new ArrayList();
        notificationCompatBuilder.mExtras = new Bundle();
        notificationCompatBuilder.mBuilderCompat = notificationCompat$Builder;
        Context context = notificationCompat$Builder.mContext;
        notificationCompatBuilder.mContext = context;
        if (Build.VERSION.SDK_INT >= 26) {
            notificationCompatBuilder.mBuilder = Api26Impl.createBuilder(context, notificationCompat$Builder.mChannelId);
        } else {
            notificationCompatBuilder.mBuilder = new Notification.Builder(notificationCompat$Builder.mContext);
        }
        Notification notification = notificationCompat$Builder.mNotification;
        Resources resources = null;
        Notification.Builder lights = notificationCompatBuilder.mBuilder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        int r7 = 2;
        int r9 = 0;
        if ((notification.flags & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        Notification.Builder ongoing = lights.setOngoing(z);
        if ((notification.flags & 8) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Notification.Builder onlyAlertOnce = ongoing.setOnlyAlertOnce(z2);
        if ((notification.flags & 16) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Notification.Builder deleteIntent = onlyAlertOnce.setAutoCancel(z3).setDefaults(notification.defaults).setContentTitle(notificationCompat$Builder.mContentTitle).setContentText(notificationCompat$Builder.mContentText).setContentInfo(null).setContentIntent(notificationCompat$Builder.mContentIntent).setDeleteIntent(notification.deleteIntent);
        if ((notification.flags & 128) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        deleteIntent.setFullScreenIntent(null, z4).setNumber(notificationCompat$Builder.mNumber).setProgress(notificationCompat$Builder.mProgressMax, notificationCompat$Builder.mProgress, notificationCompat$Builder.mProgressIndeterminate);
        Notification.Builder builder = notificationCompatBuilder.mBuilder;
        IconCompat iconCompat = notificationCompat$Builder.mLargeIcon;
        if (iconCompat == null) {
            icon = null;
        } else {
            icon = IconCompat.Api23Impl.toIcon(iconCompat, context);
        }
        Api23Impl.setLargeIcon(builder, icon);
        Api16Impl.setPriority(Api16Impl.setUsesChronometer(Api16Impl.setSubText(notificationCompatBuilder.mBuilder, null), false), notificationCompat$Builder.mPriority);
        NotificationCompat$Style notificationCompat$Style = notificationCompat$Builder.mStyle;
        if (notificationCompat$Style instanceof NotificationCompat$CallStyle) {
            NotificationCompat$CallStyle notificationCompat$CallStyle = (NotificationCompat$CallStyle) notificationCompat$Style;
            Context context2 = notificationCompat$CallStyle.mBuilder.mContext;
            Object obj = ContextCompat.sLock;
            Integer valueOf = Integer.valueOf(ContextCompat.Api23Impl.getColor(context2, R.color.call_notification_decline_color));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) notificationCompat$CallStyle.mBuilder.mContext.getResources().getString(R.string.call_notification_hang_up_action));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(valueOf.intValue()), 0, spannableStringBuilder.length(), 18);
            Context context3 = notificationCompat$CallStyle.mBuilder.mContext;
            PorterDuff.Mode mode = IconCompat.DEFAULT_TINT_MODE;
            context3.getClass();
            IconCompat createWithResource = IconCompat.createWithResource(context3.getResources(), context3.getPackageName(), R.drawable.ic_call_decline);
            Bundle bundle2 = new Bundle();
            CharSequence limitCharSequenceLength = NotificationCompat$Builder.limitCharSequenceLength(spannableStringBuilder);
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            if (arrayList5.isEmpty()) {
                remoteInputArr = null;
            } else {
                remoteInputArr = (RemoteInput[]) arrayList5.toArray(new RemoteInput[arrayList5.size()]);
            }
            if (arrayList6.isEmpty()) {
                remoteInputArr2 = null;
            } else {
                remoteInputArr2 = (RemoteInput[]) arrayList6.toArray(new RemoteInput[arrayList6.size()]);
            }
            NotificationCompat$Action notificationCompat$Action = new NotificationCompat$Action(createWithResource, limitCharSequenceLength, null, bundle2, remoteInputArr2, remoteInputArr, true, 0, true, false, false);
            notificationCompat$Action.mExtras.putBoolean("key_action_priority", true);
            ArrayList arrayList7 = new ArrayList(3);
            arrayList7.add(notificationCompat$Action);
            ArrayList<NotificationCompat$Action> arrayList8 = notificationCompat$CallStyle.mBuilder.mActions;
            if (arrayList8 != null) {
                Iterator<NotificationCompat$Action> it = arrayList8.iterator();
                while (it.hasNext()) {
                    NotificationCompat$Action next = it.next();
                    if (next.mIsContextual) {
                        arrayList7.add(next);
                    } else if (!next.mExtras.getBoolean("key_action_priority") && r7 > 1) {
                        arrayList7.add(next);
                        r7--;
                    }
                }
            }
            Iterator it2 = arrayList7.iterator();
            while (it2.hasNext()) {
                notificationCompatBuilder.addAction((NotificationCompat$Action) it2.next());
            }
        } else {
            Iterator<NotificationCompat$Action> it3 = notificationCompat$Builder.mActions.iterator();
            while (it3.hasNext()) {
                notificationCompatBuilder.addAction(it3.next());
            }
        }
        Bundle bundle3 = notificationCompat$Builder.mExtras;
        if (bundle3 != null) {
            notificationCompatBuilder.mExtras.putAll(bundle3);
        }
        int r2 = Build.VERSION.SDK_INT;
        Api17Impl.setShowWhen(notificationCompatBuilder.mBuilder, notificationCompat$Builder.mShowWhen);
        Api20Impl.setLocalOnly(notificationCompatBuilder.mBuilder, notificationCompat$Builder.mLocalOnly);
        Api20Impl.setGroup(notificationCompatBuilder.mBuilder, null);
        Api20Impl.setSortKey(notificationCompatBuilder.mBuilder, null);
        Api20Impl.setGroupSummary(notificationCompatBuilder.mBuilder, false);
        Api21Impl.setCategory(notificationCompatBuilder.mBuilder, null);
        Api21Impl.setColor(notificationCompatBuilder.mBuilder, notificationCompat$Builder.mColor);
        Api21Impl.setVisibility(notificationCompatBuilder.mBuilder, notificationCompat$Builder.mVisibility);
        Api21Impl.setPublicVersion(notificationCompatBuilder.mBuilder, null);
        Api21Impl.setSound(notificationCompatBuilder.mBuilder, notification.sound, notification.audioAttributes);
        ArrayList<Person> arrayList9 = notificationCompat$Builder.mPersonList;
        ArrayList<String> arrayList10 = notificationCompat$Builder.mPeople;
        String str2 = "";
        if (r2 < 28) {
            if (arrayList9 == null) {
                arrayList4 = null;
            } else {
                arrayList4 = new ArrayList<>(arrayList9.size());
                Iterator<Person> it4 = arrayList9.iterator();
                while (it4.hasNext()) {
                    Person next2 = it4.next();
                    String str3 = next2.mUri;
                    if (str3 == null) {
                        CharSequence charSequence = next2.mName;
                        if (charSequence == null) {
                            str3 = "";
                        } else {
                            str3 = "name:" + ((Object) charSequence);
                        }
                    }
                    arrayList4.add(str3);
                }
            }
            if (arrayList4 != null) {
                if (arrayList10 != null) {
                    ArraySet arraySet = new ArraySet(arrayList10.size() + arrayList4.size());
                    arraySet.addAll(arrayList4);
                    arraySet.addAll(arrayList10);
                    arrayList4 = new ArrayList<>(arraySet);
                }
                arrayList10 = arrayList4;
            }
        }
        if (arrayList10 != null && !arrayList10.isEmpty()) {
            Iterator<String> it5 = arrayList10.iterator();
            while (it5.hasNext()) {
                Api21Impl.addPerson(notificationCompatBuilder.mBuilder, it5.next());
            }
        }
        ArrayList<NotificationCompat$Action> arrayList11 = notificationCompat$Builder.mInvisibleActions;
        if (arrayList11.size() > 0) {
            if (notificationCompat$Builder.mExtras == null) {
                notificationCompat$Builder.mExtras = new Bundle();
            }
            Bundle bundle4 = notificationCompat$Builder.mExtras.getBundle("android.car.EXTENSIONS");
            bundle4 = bundle4 == null ? new Bundle() : bundle4;
            Bundle bundle5 = new Bundle(bundle4);
            Bundle bundle6 = new Bundle();
            int r11 = 0;
            while (r9 < arrayList11.size()) {
                String num = Integer.toString(r9);
                NotificationCompat$Action notificationCompat$Action2 = arrayList11.get(r9);
                Object obj2 = NotificationCompatJellybean.sExtrasLock;
                Bundle bundle7 = new Bundle();
                if (notificationCompat$Action2.mIcon == null && (r15 = notificationCompat$Action2.icon) != 0) {
                    notificationCompat$Action2.mIcon = IconCompat.createWithResource(resources, str2, r15);
                }
                IconCompat iconCompat2 = notificationCompat$Action2.mIcon;
                bundle7.putInt("icon", iconCompat2 != null ? iconCompat2.getResId() : r11);
                bundle7.putCharSequence(DetailBottomDialog.keyTitle, notificationCompat$Action2.title);
                bundle7.putParcelable("actionIntent", notificationCompat$Action2.actionIntent);
                Bundle bundle8 = notificationCompat$Action2.mExtras;
                if (bundle8 != null) {
                    bundle = new Bundle(bundle8);
                } else {
                    bundle = new Bundle();
                }
                bundle.putBoolean("android.support.allowGeneratedReplies", notificationCompat$Action2.mAllowGeneratedReplies);
                bundle7.putBundle("extras", bundle);
                RemoteInput[] remoteInputArr3 = notificationCompat$Action2.mRemoteInputs;
                if (remoteInputArr3 == null) {
                    bundleArr = null;
                    arrayList2 = arrayList11;
                    arrayList3 = arrayList9;
                    str = str2;
                } else {
                    Bundle[] bundleArr2 = new Bundle[remoteInputArr3.length];
                    arrayList2 = arrayList11;
                    int r22 = 0;
                    str = str2;
                    while (r22 < remoteInputArr3.length) {
                        RemoteInput remoteInput = remoteInputArr3[r22];
                        RemoteInput[] remoteInputArr4 = remoteInputArr3;
                        Bundle bundle9 = new Bundle();
                        remoteInput.getClass();
                        bundle9.putString("resultKey", null);
                        bundle9.putCharSequence("label", null);
                        bundle9.putCharSequenceArray("choices", null);
                        bundle9.putBoolean("allowFreeFormInput", false);
                        bundle9.putBundle("extras", null);
                        bundleArr2[r22] = bundle9;
                        r22++;
                        remoteInputArr3 = remoteInputArr4;
                        arrayList9 = arrayList9;
                    }
                    arrayList3 = arrayList9;
                    bundleArr = bundleArr2;
                }
                bundle7.putParcelableArray("remoteInputs", bundleArr);
                bundle7.putBoolean("showsUserInterface", notificationCompat$Action2.mShowsUserInterface);
                bundle7.putInt("semanticAction", notificationCompat$Action2.mSemanticAction);
                bundle6.putBundle(num, bundle7);
                r9++;
                resources = null;
                r11 = 0;
                str2 = str;
                arrayList11 = arrayList2;
                arrayList9 = arrayList3;
            }
            arrayList = arrayList9;
            bundle4.putBundle("invisible_actions", bundle6);
            bundle5.putBundle("invisible_actions", bundle6);
            if (notificationCompat$Builder.mExtras == null) {
                notificationCompat$Builder.mExtras = new Bundle();
            }
            notificationCompat$Builder.mExtras.putBundle("android.car.EXTENSIONS", bundle4);
            notificationCompatBuilder = this;
            notificationCompatBuilder.mExtras.putBundle("android.car.EXTENSIONS", bundle5);
        } else {
            arrayList = arrayList9;
        }
        int r23 = Build.VERSION.SDK_INT;
        Api19Impl.setExtras(notificationCompatBuilder.mBuilder, notificationCompat$Builder.mExtras);
        Api24Impl.setRemoteInputHistory(notificationCompatBuilder.mBuilder, null);
        if (r23 >= 26) {
            Api26Impl.setBadgeIconType(notificationCompatBuilder.mBuilder, 0);
            Api26Impl.setSettingsText(notificationCompatBuilder.mBuilder, null);
            Api26Impl.setShortcutId(notificationCompatBuilder.mBuilder, null);
            Api26Impl.setTimeoutAfter(notificationCompatBuilder.mBuilder, 0L);
            Api26Impl.setGroupAlertBehavior(notificationCompatBuilder.mBuilder, 0);
            if (!TextUtils.isEmpty(notificationCompat$Builder.mChannelId)) {
                notificationCompatBuilder.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (r23 >= 28) {
            Iterator<Person> it6 = arrayList.iterator();
            while (it6.hasNext()) {
                Person next3 = it6.next();
                Notification.Builder builder2 = notificationCompatBuilder.mBuilder;
                next3.getClass();
                Api28Impl.addPerson(builder2, Person.Api28Impl.toAndroidPerson(next3));
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.setAllowSystemGeneratedContextualActions(notificationCompatBuilder.mBuilder, notificationCompat$Builder.mAllowSystemGeneratedContextualActions);
            Api29Impl.setBubbleMetadata(notificationCompatBuilder.mBuilder, null);
        }
    }

    public final void addAction(NotificationCompat$Action notificationCompat$Action) {
        Bundle bundle;
        int r0;
        Icon icon = null;
        if (notificationCompat$Action.mIcon == null && (r0 = notificationCompat$Action.icon) != 0) {
            notificationCompat$Action.mIcon = IconCompat.createWithResource(null, "", r0);
        }
        IconCompat iconCompat = notificationCompat$Action.mIcon;
        if (iconCompat != null) {
            icon = IconCompat.Api23Impl.toIcon(iconCompat, null);
        }
        Notification.Action.Builder createBuilder = Api23Impl.createBuilder(icon, notificationCompat$Action.title, notificationCompat$Action.actionIntent);
        RemoteInput[] remoteInputArr = notificationCompat$Action.mRemoteInputs;
        if (remoteInputArr != null) {
            android.app.RemoteInput[] remoteInputArr2 = new android.app.RemoteInput[remoteInputArr.length];
            for (int r4 = 0; r4 < remoteInputArr.length; r4++) {
                remoteInputArr2[r4] = RemoteInput.fromCompat(remoteInputArr[r4]);
            }
            for (android.app.RemoteInput remoteInput : remoteInputArr2) {
                Api20Impl.addRemoteInput(createBuilder, remoteInput);
            }
        }
        Bundle bundle2 = notificationCompat$Action.mExtras;
        if (bundle2 != null) {
            bundle = new Bundle(bundle2);
        } else {
            bundle = new Bundle();
        }
        boolean z = notificationCompat$Action.mAllowGeneratedReplies;
        bundle.putBoolean("android.support.allowGeneratedReplies", z);
        int r1 = Build.VERSION.SDK_INT;
        Api24Impl.setAllowGeneratedReplies(createBuilder, z);
        int r42 = notificationCompat$Action.mSemanticAction;
        bundle.putInt("android.support.action.semanticAction", r42);
        if (r1 >= 28) {
            Api28Impl.setSemanticAction(createBuilder, r42);
        }
        if (r1 >= 29) {
            Api29Impl.setContextual(createBuilder, notificationCompat$Action.mIsContextual);
        }
        if (r1 >= 31) {
            Api31Impl.setAuthenticationRequired(createBuilder, notificationCompat$Action.mAuthenticationRequired);
        }
        bundle.putBoolean("android.support.action.showsUserInterface", notificationCompat$Action.mShowsUserInterface);
        Api20Impl.addExtras(createBuilder, bundle);
        Api20Impl.addAction(this.mBuilder, Api20Impl.build(createBuilder));
    }
}
