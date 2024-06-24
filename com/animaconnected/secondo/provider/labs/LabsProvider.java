package com.animaconnected.secondo.provider.labs;

import android.content.Context;
import com.animaconnected.cloud.Cloud;
import com.animaconnected.firebase.AppEvents;
import com.animaconnected.future.Future;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.app.RemoteConfigController;
import com.animaconnected.secondo.behaviour.counter.Counter;
import com.animaconnected.secondo.behaviour.habittracker.HabitTracker;
import com.animaconnected.secondo.behaviour.phonebattery.PhoneBattery;
import com.animaconnected.secondo.behaviour.webhook.Webhook;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;
import com.animaconnected.secondo.screens.notification.NotificationDragAndDropProvider;
import com.animaconnected.secondo.utils.AlphabeticSortingHelper;
import com.animaconnected.secondo.utils.customersupport.CustomerSupportMailUtils;
import com.animaconnected.secondo.utils.customersupport.CustomerSupportMailUtilsKt;
import com.animaconnected.watch.behaviour.Behaviours;
import com.animaconnected.watch.behaviour.dice.Dice;
import com.animaconnected.watch.behaviour.stoptime.StopTime;
import com.animaconnected.watch.device.DeviceInfo;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LabsProvider.kt */
/* loaded from: classes3.dex */
public final class LabsProvider {
    private static final String LABS_ANALYTICS_PREFIX = "labs_";
    public static final String LABS_FEEDBACK_NAME = "labs";
    private final Behaviours behaviours;
    private final Cloud cloud;
    private final Context context;
    private final CustomerSupportMailUtils customerSupportMail;
    private List<String> labsBehaviourTypes;
    private final List<Integer> labsNotificationTypes;
    private final Set<LabsListener> listeners;
    private final RemoteConfigController remoteConfigController;
    private final CoroutineScope scope;
    private final LabsStorage storage;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: LabsProvider.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public LabsProvider(Context context, RemoteConfigController remoteConfigController, Cloud cloud) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteConfigController, "remoteConfigController");
        Intrinsics.checkNotNullParameter(cloud, "cloud");
        this.remoteConfigController = remoteConfigController;
        this.cloud = cloud;
        Context context2 = context.getApplicationContext();
        this.context = context2;
        this.customerSupportMail = new CustomerSupportMailUtils(context);
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.storage = new LabsStorage(context2);
        this.listeners = new CopyOnWriteArraySet();
        this.behaviours = ProviderFactory.getWatch().getWatchManager().getBehaviours();
        this.scope = KronabyApplication.Companion.getScope();
        this.labsNotificationTypes = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{11, 12});
        this.labsBehaviourTypes = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Dice.TYPE, Counter.TYPE, StopTime.TYPE, PhoneBattery.TYPE, HabitTracker.TYPE, Webhook.TYPE});
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean isBehaviourTypeEvaluation(String str) {
        if (str instanceof Void) {
            Void element = (Void) str;
            Intrinsics.checkNotNullParameter(element, "element");
            return false;
        }
        return false;
    }

    private final void notifyListeners(boolean z) {
        if (z) {
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                ((LabsListener) it.next()).onJoinedLabs();
            }
        } else {
            Iterator<T> it2 = this.listeners.iterator();
            while (it2.hasNext()) {
                ((LabsListener) it2.next()).onLeftLabs();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object packageFeedbackData(java.lang.String r16, java.lang.String r17, java.lang.String r18, kotlin.coroutines.Continuation<? super com.animaconnected.cloud.amazon.lambda.SendFeedbackParams> r19) {
        /*
            r15 = this;
            r0 = r15
            r1 = r19
            boolean r2 = r1 instanceof com.animaconnected.secondo.provider.labs.LabsProvider$packageFeedbackData$1
            if (r2 == 0) goto L16
            r2 = r1
            com.animaconnected.secondo.provider.labs.LabsProvider$packageFeedbackData$1 r2 = (com.animaconnected.secondo.provider.labs.LabsProvider$packageFeedbackData$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L16
            int r3 = r3 - r4
            r2.label = r3
            goto L1b
        L16:
            com.animaconnected.secondo.provider.labs.LabsProvider$packageFeedbackData$1 r2 = new com.animaconnected.secondo.provider.labs.LabsProvider$packageFeedbackData$1
            r2.<init>(r15, r1)
        L1b:
            java.lang.Object r1 = r2.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L45
            if (r4 != r5) goto L3d
            java.lang.Object r3 = r2.L$3
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r2.L$2
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r2.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r2 = r2.L$0
            com.animaconnected.secondo.provider.labs.LabsProvider r2 = (com.animaconnected.secondo.provider.labs.LabsProvider) r2
            kotlin.ResultKt.throwOnFailure(r1)
            r10 = r3
            r9 = r4
            r8 = r5
            goto L6b
        L3d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L45:
            kotlin.ResultKt.throwOnFailure(r1)
            com.animaconnected.watch.WatchProvider r1 = com.animaconnected.secondo.provider.ProviderFactory.getWatch()
            com.animaconnected.future.Future r1 = r1.getDeviceInformation()
            r2.L$0 = r0
            r4 = r16
            r2.L$1 = r4
            r6 = r17
            r2.L$2 = r6
            r7 = r18
            r2.L$3 = r7
            r2.label = r5
            java.lang.Object r1 = com.animaconnected.future.FutureCoroutineKt.getSuspending(r1, r2)
            if (r1 != r3) goto L67
            return r3
        L67:
            r2 = r0
            r8 = r4
            r9 = r6
            r10 = r7
        L6b:
            java.util.Map r1 = (java.util.Map) r1
            com.animaconnected.cloud.amazon.lambda.SendFeedbackParams r3 = new com.animaconnected.cloud.amazon.lambda.SendFeedbackParams
            com.animaconnected.cloud.amazon.lambda.SendFeedbackParams$Feedback r14 = new com.animaconnected.cloud.amazon.lambda.SendFeedbackParams$Feedback
            com.animaconnected.watch.device.DeviceInfo r4 = com.animaconnected.watch.device.DeviceInfo.SerialNumber
            java.lang.Object r1 = r1.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L7d
            java.lang.String r1 = ""
        L7d:
            r5 = r1
            android.content.Context r1 = r2.context
            java.lang.String r6 = com.animaconnected.secondo.utils.AppUtils.getVersion(r1)
            java.lang.String r1 = "getVersion(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
            java.lang.String r7 = com.animaconnected.secondo.utils.BrandUtils.getAppId()
            java.lang.String r1 = "getAppId(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            r11 = 0
            r12 = 64
            r13 = 0
            r4 = r14
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r3.<init>(r14)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.labs.LabsProvider.packageFeedbackData(java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x001e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0095 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0087 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0079 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object removeLabsBehaviours(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.labs.LabsProvider.removeLabsBehaviours(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Future removeLabsBehaviours$lambda$1(NotificationDragAndDropProvider notificationDragAndDropProvider, Void r1) {
        Intrinsics.checkNotNullParameter(notificationDragAndDropProvider, "$notificationDragAndDropProvider");
        return notificationDragAndDropProvider.updateNotificationsGroups(false);
    }

    public static final void removeLabsBehaviours$lambda$2(Void r0) {
        ProviderFactory.getNotificationProvider().refresh();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object removeLabsItem(com.animaconnected.watch.Slot r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.animaconnected.secondo.provider.labs.LabsProvider$removeLabsItem$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.secondo.provider.labs.LabsProvider$removeLabsItem$1 r0 = (com.animaconnected.secondo.provider.labs.LabsProvider$removeLabsItem$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.provider.labs.LabsProvider$removeLabsItem$1 r0 = new com.animaconnected.secondo.provider.labs.LabsProvider$removeLabsItem$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L88
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            java.lang.Object r6 = r0.L$2
            com.animaconnected.secondo.provider.labs.LabsProvider r6 = (com.animaconnected.secondo.provider.labs.LabsProvider) r6
            java.lang.Object r2 = r0.L$1
            com.animaconnected.watch.Slot r2 = (com.animaconnected.watch.Slot) r2
            java.lang.Object r4 = r0.L$0
            com.animaconnected.secondo.provider.labs.LabsProvider r4 = (com.animaconnected.secondo.provider.labs.LabsProvider) r4
            kotlin.ResultKt.throwOnFailure(r7)
            goto L59
        L42:
            kotlin.ResultKt.throwOnFailure(r7)
            com.animaconnected.watch.behaviour.Behaviours r7 = r5.behaviours
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r5
            r0.label = r4
            java.lang.Object r7 = r7.getBehaviour(r6, r0)
            if (r7 != r1) goto L56
            return r1
        L56:
            r4 = r5
            r2 = r6
            r6 = r4
        L59:
            com.animaconnected.watch.behaviour.Behaviour r7 = (com.animaconnected.watch.behaviour.Behaviour) r7
            java.lang.String r7 = r7.getType()
            boolean r6 = r6.isBehaviourTypeLabs(r7)
            if (r6 == 0) goto L8b
            com.animaconnected.watch.behaviour.Behaviours r6 = r4.behaviours
            com.animaconnected.watch.behaviour.types.Empty r7 = com.animaconnected.watch.behaviour.types.Empty.INSTANCE
            java.lang.String r7 = r7.getType()
            com.animaconnected.watch.behaviour.Behaviour r6 = r6.getBehaviour(r7)
            if (r6 != 0) goto L76
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L76:
            com.animaconnected.watch.behaviour.Behaviours r7 = r4.behaviours
            r4 = 0
            r0.L$0 = r4
            r0.L$1 = r4
            r0.L$2 = r4
            r0.label = r3
            java.lang.Object r6 = r7.setBehaviourForSlot(r2, r6, r0)
            if (r6 != r1) goto L88
            return r1
        L88:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L8b:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.labs.LabsProvider.removeLabsItem(com.animaconnected.watch.Slot, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ void setRating$default(LabsProvider labsProvider, String str, int r2, String str2, int r4, Object obj) {
        if ((r4 & 4) != 0) {
            str2 = "";
        }
        labsProvider.setRating(str, r2, str2);
    }

    public static final void syncMoreNumbersInDatabase$lambda$0(Void r0) {
        ProviderFactory.getNotificationProvider().refresh();
    }

    public final void enableMoreNumbers(boolean z) {
        this.storage.setMoreNumbersEnabled(z);
        syncMoreNumbersInDatabase(z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005d, code lost:            if (isBehaviourTypeLabs(r4.getType()) != false) goto L51;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.animaconnected.secondo.behaviour.BehaviourPlugin<com.animaconnected.watch.behaviour.Behaviour>> getAllBehaviours(java.util.List<? extends com.animaconnected.secondo.behaviour.BehaviourPlugin<com.animaconnected.watch.behaviour.Behaviour>> r13) {
        /*
            r12 = this;
            java.lang.String r0 = "behaviours"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            java.util.Iterator r13 = r13.iterator()
        L10:
            boolean r1 = r13.hasNext()
            java.lang.String r2 = "notLabs"
            java.lang.String r3 = "labs"
            if (r1 == 0) goto L74
            java.lang.Object r1 = r13.next()
            r4 = r1
            com.animaconnected.secondo.behaviour.BehaviourPlugin r4 = (com.animaconnected.secondo.behaviour.BehaviourPlugin) r4
            java.lang.String r5 = r4.getType()
            boolean r5 = r12.isBehaviourTypeEvaluation(r5)
            if (r5 == 0) goto L55
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Evaluation type "
            r2.<init>(r4)
            com.animaconnected.secondo.app.RemoteConfigController r4 = r12.remoteConfigController
            boolean r4 = r4.isEvaluationFeaturesEnabled()
            r2.append(r4)
            java.lang.String r6 = r2.toString()
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 14
            r11 = 0
            r5 = r12
            com.animaconnected.logger.LogKt.err$default(r5, r6, r7, r8, r9, r10, r11)
            com.animaconnected.secondo.app.RemoteConfigController r2 = r12.remoteConfigController
            boolean r2 = r2.isEvaluationFeaturesEnabled()
            if (r2 == 0) goto L52
            goto L5f
        L52:
            java.lang.String r2 = "notUsed"
            goto L60
        L55:
            java.lang.String r4 = r4.getType()
            boolean r4 = r12.isBehaviourTypeLabs(r4)
            if (r4 == 0) goto L60
        L5f:
            r2 = r3
        L60:
            java.lang.Object r3 = r0.get(r2)
            if (r3 != 0) goto L6e
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r0.put(r2, r3)
        L6e:
            java.util.List r3 = (java.util.List) r3
            r3.add(r1)
            goto L10
        L74:
            android.content.Context r13 = r12.context
            java.util.Comparator r13 = com.animaconnected.secondo.utils.AlphabeticSortingHelper.createBehaviourComparator(r13)
            java.lang.Object r1 = r0.get(r2)
            java.util.List r1 = (java.util.List) r1
            kotlin.collections.EmptyList r2 = kotlin.collections.EmptyList.INSTANCE
            if (r1 == 0) goto L8e
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            java.util.List r1 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r1, r13)
            goto L8f
        L8e:
            r1 = r2
        L8f:
            java.lang.Object r3 = r0.get(r3)
            java.util.List r3 = (java.util.List) r3
            if (r3 == 0) goto La1
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            java.util.List r13 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r3, r13)
            goto La2
        La1:
            r13 = r2
        La2:
            java.lang.String r3 = "alwaysLast"
            java.lang.Object r0 = r0.get(r3)
            java.util.List r0 = (java.util.List) r0
            if (r0 != 0) goto Lad
            goto Lae
        Lad:
            r2 = r0
        Lae:
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.Collection r1 = (java.util.Collection) r1
            r0.<init>(r1)
            com.animaconnected.secondo.provider.labs.LabsProvider r1 = com.animaconnected.secondo.provider.ProviderFactory.getLabsProvider()
            boolean r1 = r1.hasJoinedLabs()
            if (r1 == 0) goto Lc4
            java.util.Collection r13 = (java.util.Collection) r13
            r0.addAll(r13)
        Lc4:
            java.util.Collection r2 = (java.util.Collection) r2
            r0.addAll(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.labs.LabsProvider.getAllBehaviours(java.util.List):java.util.List");
    }

    public final List<ConfigurationItem> getAllNotificationItems(List<? extends ConfigurationItem> configurationItems) {
        Intrinsics.checkNotNullParameter(configurationItems, "configurationItems");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (ConfigurationItem configurationItem : configurationItems) {
            if (isNotificationItemTypeLabs(configurationItem.getType())) {
                arrayList3.add(configurationItem);
            } else {
                arrayList2.add(configurationItem);
            }
        }
        Comparator<ConfigurationItem> createConfigurationItemComparator = AlphabeticSortingHelper.createConfigurationItemComparator();
        Intrinsics.checkNotNullExpressionValue(createConfigurationItemComparator, "createConfigurationItemComparator(...)");
        Collections.sort(arrayList2, createConfigurationItemComparator);
        arrayList.addAll(arrayList2);
        if (ProviderFactory.getLabsProvider().hasJoinedLabs()) {
            Collections.sort(arrayList3, createConfigurationItemComparator);
            arrayList.addAll(arrayList3);
        }
        return arrayList;
    }

    public final int getLabsBackgroundDraggedResourceId() {
        return R.drawable.labs_marble_dragged;
    }

    public final int getLabsBackgroundDroppedResourceId() {
        return R.drawable.labs_marble_dropped;
    }

    public final int getRating(String behaviourType) {
        Intrinsics.checkNotNullParameter(behaviourType, "behaviourType");
        return this.storage.getBehaviourRating(behaviourType);
    }

    public final boolean hasJoinedLabs() {
        return this.storage.getJoinedLabs();
    }

    public final boolean hasRating(String behaviourType) {
        Intrinsics.checkNotNullParameter(behaviourType, "behaviourType");
        return this.storage.hasBehaviourRating(behaviourType);
    }

    public final boolean isBehaviourTypeLabs(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (!this.labsBehaviourTypes.contains(type) && !isBehaviourTypeEvaluation(type)) {
            return false;
        }
        return true;
    }

    public final boolean isMoreNumbersEnabled() {
        return this.storage.isMoreNumbersEnabled();
    }

    public final boolean isNotificationItemTypeLabs(int r2) {
        return this.labsNotificationTypes.contains(Integer.valueOf(r2));
    }

    public final void registerListener(LabsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    public final void setJoinedLabs(boolean z) {
        String str;
        this.storage.setJoinedLabs(z);
        notifyListeners(z);
        AppEvents appAnalytics = ProviderFactory.getAppAnalytics();
        if (z) {
            str = "labs_joined";
        } else {
            str = "labs_left";
        }
        appAnalytics.sendAction(str);
        if (!z) {
            BuildersKt.launch$default(this.scope, null, null, new LabsProvider$setJoinedLabs$1(this, null), 3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:            if (r0 != false) goto L23;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setRating(java.lang.String r10, int r11, java.lang.String r12) {
        /*
            r9 = this;
            java.lang.String r0 = "behaviourType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "comment"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            com.animaconnected.secondo.provider.labs.LabsStorage r0 = r9.storage
            int r0 = r0.getBehaviourRatingLastSent(r10)
            if (r11 == 0) goto L14
            if (r0 != r11) goto L1f
        L14:
            int r0 = r12.length()
            if (r0 <= 0) goto L1c
            r0 = 1
            goto L1d
        L1c:
            r0 = 0
        L1d:
            if (r0 == 0) goto L3a
        L1f:
            kotlinx.coroutines.CoroutineScope r0 = r9.scope
            kotlinx.coroutines.scheduling.DefaultScheduler r1 = kotlinx.coroutines.Dispatchers.Default
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.internal.MainDispatcherLoader.dispatcher
            com.animaconnected.secondo.provider.labs.LabsProvider$setRating$1 r8 = new com.animaconnected.secondo.provider.labs.LabsProvider$setRating$1
            r7 = 0
            r2 = r8
            r3 = r10
            r4 = r11
            r5 = r9
            r6 = r12
            r2.<init>(r3, r4, r5, r6, r7)
            r12 = 2
            r2 = 0
            kotlinx.coroutines.BuildersKt.launch$default(r0, r1, r2, r8, r12)
            com.animaconnected.secondo.provider.labs.LabsStorage r12 = r9.storage
            r12.setBehaviourRatingLastSent(r10, r11)
        L3a:
            com.animaconnected.secondo.provider.labs.LabsStorage r12 = r9.storage
            r12.setBehaviourRating(r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.labs.LabsProvider.setRating(java.lang.String, int, java.lang.String):void");
    }

    public final void showGiveFeedbackMail(Context context, Map<DeviceInfo, String> map, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        CustomerSupportMailUtilsKt.showEmailIntent(context, this.customerSupportMail.getContactLabsEmailAddress(), str, this.customerSupportMail.getSupportMsgTechData(map) + this.context.getString(R.string.contact_labs_msg_body_description_feedback));
    }

    public final void syncMoreNumbersInDatabase(boolean z) {
        new NotificationDragAndDropProvider(this.context).updateNotificationsGroups(z).success(new LabsProvider$$ExternalSyntheticLambda2());
    }

    public final void unregisterListener(LabsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }
}
