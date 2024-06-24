package com.animaconnected.secondo.screens.notification;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.profileinstaller.FileSectionType$$ExternalSyntheticOutline0;
import com.animaconnected.draganddrop.provider.BadgeState;
import com.animaconnected.draganddrop.provider.BadgeVisualState;
import com.animaconnected.draganddrop.provider.DragAndDropProvider;
import com.animaconnected.draganddrop.provider.model.DragAndDropDroppableItem;
import com.animaconnected.draganddrop.provider.model.DragAndDropHeaderItem;
import com.animaconnected.draganddrop.provider.model.DragAndDropIconItem;
import com.animaconnected.draganddrop.provider.model.DragAndDropItem;
import com.animaconnected.draganddrop.provider.model.DragAndDropMarbleContactItem;
import com.animaconnected.draganddrop.provider.model.DragAndDropMarbleIconItem;
import com.animaconnected.future.FlatMapCallback;
import com.animaconnected.future.Future;
import com.animaconnected.future.FutureUtils;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.secondo.app.RemoteConfigController;
import com.animaconnected.secondo.notification.model.Contact;
import com.animaconnected.secondo.notification.model.ImportantApp;
import com.animaconnected.secondo.notification.receiver.NotificationUtil;
import com.animaconnected.secondo.provider.PermissionProvider;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.ThemeProviderBase;
import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;
import com.animaconnected.secondo.provider.configuration.database.DatabaseHelper;
import com.animaconnected.secondo.provider.notification.NotificationProvider;
import com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda19;
import com.animaconnected.secondo.provider.notification.configuration.item.NotificationItemConstants;
import com.animaconnected.secondo.provider.notification.configuration.item.NotificationItemsProvider;
import com.animaconnected.secondo.screens.behaviourconfiguration.ConfigurationChecker;
import com.animaconnected.secondo.screens.notification.picker.AppInfo;
import com.animaconnected.watch.behaviour.types.Ifttt;
import com.kronaby.watch.app.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class NotificationDragAndDropProvider extends DragAndDropProvider<ConfigurationItem> {
    private static final int COLUMN_1 = 0;
    private static final int COLUMN_2 = 1;
    private static final int COLUMN_3 = 2;
    private static final String TAG = "NotificationDragAndDropProvider";
    private final Context context;
    private boolean mAnimationCompleted;
    private final Map<Integer, BadgeState> mBadgeStates;
    private List<ConfigurationItem> mConfigurationItems;
    private Map<String, Contact> mContactsMap;
    private final int mDraggedItemResourceId;
    private final int mDroppedItemResourceId;
    private final int mGridDropZoneNotSelectedResourceId;
    private final int mGridDropZoneSelectedResourceId;
    private final int mGroupNotSelectedResourceId;
    private final int mGroupSelectedResourceId;
    private final Map<Integer, DragAndDropItem> mHeaders;
    private Map<String, ImportantApp> mImportantAppsMap;
    private int mIndex;
    private final DatabaseHelper mNotificationItemsDatabaseHelper;
    private final NotificationProvider mNotificationProvider;
    private final PermissionProvider mPermissionProvider;
    private final int mVibrationOneId;
    private final int mVibrationThreeId;
    private final int mVibrationTwoId;

    public NotificationDragAndDropProvider(Context context) {
        super(context);
        this.mHeaders = new HashMap();
        this.mConfigurationItems = new ArrayList();
        this.mBadgeStates = new HashMap();
        this.mIndex = 0;
        this.context = context;
        this.mNotificationItemsDatabaseHelper = NotificationItemsProvider.getInstance(context).getDatabaseHelper();
        this.mNotificationProvider = ProviderFactory.getNotificationProvider();
        this.mPermissionProvider = new PermissionProvider(context);
        this.mGroupNotSelectedResourceId = ThemeProviderBase.getResourceId(context, R.attr.notificationsDropZoneNotSelected);
        this.mGroupSelectedResourceId = ThemeProviderBase.getResourceId(context, R.attr.notificationsDropZoneSelected);
        this.mGridDropZoneNotSelectedResourceId = ThemeProviderBase.getResourceId(context, R.attr.gridDropZoneNotSelected);
        this.mGridDropZoneSelectedResourceId = ThemeProviderBase.getResourceId(context, R.attr.gridDropZoneSelected);
        this.mDraggedItemResourceId = ThemeProviderBase.getResourceId(context, R.attr.draggedItem);
        this.mDroppedItemResourceId = ThemeProviderBase.getResourceId(context, R.attr.droppedItem);
        if (ProviderFactory.getWatch().isAlertComplicationEnabled()) {
            this.mVibrationOneId = R.drawable.ic_exclamation_one;
            this.mVibrationTwoId = R.drawable.ic_exclamation_double;
            this.mVibrationThreeId = R.drawable.ic_exclamation_triple;
        } else {
            this.mVibrationOneId = ThemeProviderBase.getResourceId(context, R.attr.notificationVibrationNoAlertComplication1);
            this.mVibrationTwoId = ThemeProviderBase.getResourceId(context, R.attr.notificationVibrationNoAlertComplication2);
            this.mVibrationThreeId = ThemeProviderBase.getResourceId(context, R.attr.notificationVibrationNoAlertComplication3);
        }
    }

    private boolean canBeShown(ConfigurationItem configurationItem) {
        if (configurationItem.getType() == 12) {
            return ProviderFactory.getWatch().getCapabilities().hasDisconnectAlert();
        }
        return true;
    }

    private void createFakeContactSource() {
        createHeaderIfNeeded(0, R.string.nft_category_people);
        DragAndDropIconItem dragAndDropIconItem = new DragAndDropIconItem(R.drawable.ic_notifications_add, this.context.getString(R.string.nft_people_new), ThemeProviderBase.getResourceId(this.context, R.attr.styleMarbleText));
        dragAndDropIconItem.setType(1);
        this.mutableItems.add(dragAndDropIconItem);
        this.mIndex++;
    }

    private void createHeaderIfNeeded(int r6, int r7) {
        boolean z;
        if (!this.mHeaders.containsKey(Integer.valueOf(r6))) {
            if (r6 == 0) {
                z = true;
            } else {
                z = false;
            }
            DragAndDropHeaderItem dragAndDropHeaderItem = new DragAndDropHeaderItem(this.context.getString(r7), z, ThemeProviderBase.getColor(this.context, R.attr.colorMarbleText));
            this.mHeaders.put(Integer.valueOf(r6), dragAndDropHeaderItem);
            this.mutableItems.add(dragAndDropHeaderItem);
            this.mIndex++;
        }
    }

    private void createItems() {
        if (this.mAnimationCompleted && this.mImportantAppsMap != null) {
            clearData();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (ConfigurationItem configurationItem : this.mConfigurationItems) {
                if (configurationItem.getCategory() == 0) {
                    if (configurationItem.getType() == 1) {
                        handleTypeContacts(this.mContactsMap, configurationItem);
                    } else {
                        arrayList.add(configurationItem);
                    }
                }
            }
            Collections.reverse(arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                handleTypeContacts(this.mContactsMap, (ConfigurationItem) it.next());
            }
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (ConfigurationItem configurationItem2 : this.mConfigurationItems) {
                if (canBeShown(configurationItem2)) {
                    if (configurationItem2.getCategory() == 1) {
                        arrayList3.add(configurationItem2);
                    } else {
                        arrayList4.add(configurationItem2);
                    }
                }
            }
            for (ConfigurationItem configurationItem3 : ProviderFactory.getLabsProvider().getAllNotificationItems(arrayList3)) {
                if (configurationItem3.getCategory() == 1) {
                    handleTypeMisc(configurationItem3);
                }
            }
            Iterator it2 = arrayList4.iterator();
            while (it2.hasNext()) {
                ConfigurationItem configurationItem4 = (ConfigurationItem) it2.next();
                if (configurationItem4.getCategory() == 2) {
                    if (configurationItem4.getType() == 8) {
                        handleTypeImportantApp(this.mImportantAppsMap, configurationItem4);
                    } else {
                        arrayList2.add(configurationItem4);
                    }
                }
            }
            Collections.reverse(arrayList2);
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                handleTypeImportantApp(this.mImportantAppsMap, (ConfigurationItem) it3.next());
            }
            notifyDataChanged();
        }
    }

    private BadgeState getBadgeState(ConfigurationItem configurationItem) {
        if (this.mPermissionProvider.arePermissionsGranted(NotificationItemConstants.requiredPermissions(configurationItem.getType())) && (!NotificationItemConstants.needNotificationAccess(configurationItem.getType()) || NotificationUtil.isEnabled(this.context))) {
            if (NotificationItemConstants.needsConfiguration(configurationItem.getType()) && !ConfigurationChecker.isConfigured(this.context, configurationItem)) {
                return BadgeState.Neutral;
            }
            return BadgeState.Normal;
        }
        return BadgeState.Error;
    }

    private void handleTypeContacts(Map<String, Contact> map, ConfigurationItem configurationItem) {
        String name;
        String str;
        DragAndDropMarbleContactItem dragAndDropMarbleContactItem;
        createHeaderIfNeeded(0, R.string.nft_category_people);
        if (configurationItem.getType() == 1) {
            DragAndDropIconItem dragAndDropIconItem = new DragAndDropIconItem(R.drawable.ic_notifications_add, this.context.getString(R.string.nft_people_new), ThemeProviderBase.getResourceId(this.context, R.attr.styleMarbleText));
            dragAndDropIconItem.setType(1);
            this.mutableItems.add(dragAndDropIconItem);
            this.mIndex++;
            return;
        }
        Contact contact = map.get(configurationItem.getExternalId());
        if (contact == null) {
            name = " ";
        } else {
            name = contact.getName();
        }
        String[] split = name.trim().split(" ");
        if (split.length > 1 && split[0].length() > 1 && split[1].length() > 1) {
            str = split[0].substring(0, 1) + split[1].substring(0, 1);
        } else if (split.length == 1 && split[0].length() > 1) {
            str = split[0].substring(0, 1);
        } else {
            str = "";
        }
        String str2 = str;
        int resourceId = ThemeProviderBase.getResourceId(this.context, R.attr.styleMarbleText);
        int color = ThemeProviderBase.getColor(this.context, R.attr.colorMarbleIcon);
        int resourceId2 = ThemeProviderBase.getResourceId(this.context, R.attr.notificationsContact);
        if (split.length > 1) {
            dragAndDropMarbleContactItem = new DragAndDropMarbleContactItem(configurationItem.getId(), -1, str2, split[0], split[1], this.mDroppedItemResourceId, this.mDraggedItemResourceId, resourceId, resourceId2, color);
        } else {
            dragAndDropMarbleContactItem = new DragAndDropMarbleContactItem(configurationItem.getId(), -1, str2, name, " ", this.mDroppedItemResourceId, this.mDraggedItemResourceId, resourceId, resourceId2, color);
        }
        initDragItem(configurationItem, dragAndDropMarbleContactItem, 2);
    }

    private void handleTypeImportantApp(Map<String, ImportantApp> map, ConfigurationItem configurationItem) {
        Drawable drawable;
        createHeaderIfNeeded(2, R.string.nft_category_important_apps);
        int resourceId = ThemeProviderBase.getResourceId(this.context, R.attr.styleMarbleText);
        int color = ThemeProviderBase.getColor(this.context, R.attr.colorMarbleEmptyIcon);
        if (configurationItem.getType() == 8) {
            DragAndDropIconItem dragAndDropIconItem = new DragAndDropIconItem(R.drawable.ic_notifications_add, this.context.getString(R.string.nft_important_apps_new), resourceId);
            dragAndDropIconItem.setType(8);
            this.mutableItems.add(dragAndDropIconItem);
            this.mIndex++;
            return;
        }
        ImportantApp importantApp = map.get(configurationItem.getExternalId());
        String appName = importantApp.getAppName();
        AppInfo appInfo = ProviderFactory.getImportantAppsProvider().getAppInfo(importantApp.getPackageName());
        if (appInfo != null) {
            drawable = appInfo.getAppIcon();
        } else {
            drawable = null;
        }
        initDragItem(configurationItem, new DragAndDropMarbleIconItem(configurationItem.getId(), -1, drawable, appName, this.mDroppedItemResourceId, this.mDraggedItemResourceId, resourceId, (Integer) null, color), 4);
    }

    private void handleTypeMisc(ConfigurationItem configurationItem) {
        DragAndDropMarbleIconItem dragAndDropMarbleIconItem;
        createHeaderIfNeeded(1, R.string.nft_category_misc);
        int type = configurationItem.getType();
        NotificationInfo fromType = NotificationInfo.getFromType(type);
        int resourceId = ThemeProviderBase.getResourceId(this.context, R.attr.styleMarbleText);
        Integer valueOf = Integer.valueOf(ThemeProviderBase.getColor(this.context, R.attr.colorMarbleIcon));
        int color = ThemeProviderBase.getColor(this.context, R.attr.colorMarbleEmptyIcon);
        if (type == 10 && !RemoteConfigController.getInstance(this.context).isIftttNotificationsEnabled(Ifttt.TYPE)) {
            return;
        }
        if (fromType != null) {
            if (ProviderFactory.getLabsProvider().isNotificationItemTypeLabs(fromType.getType())) {
                dragAndDropMarbleIconItem = new DragAndDropMarbleIconItem(configurationItem.getId(), -1, fromType.getIconResourceId(), this.context.getString(fromType.getName()), ProviderFactory.getLabsProvider().getLabsBackgroundDroppedResourceId(), ProviderFactory.getLabsProvider().getLabsBackgroundDraggedResourceId(), resourceId, (Integer) (-1), color);
            } else {
                dragAndDropMarbleIconItem = new DragAndDropMarbleIconItem(configurationItem.getId(), -1, fromType.getIconResourceId(), this.context.getString(fromType.getName()), this.mDroppedItemResourceId, this.mDraggedItemResourceId, resourceId, valueOf, color);
            }
        } else {
            dragAndDropMarbleIconItem = null;
        }
        initDragItem(configurationItem, dragAndDropMarbleIconItem, type);
    }

    private void initDragItem(ConfigurationItem configurationItem, DragAndDropDroppableItem dragAndDropDroppableItem, int r6) {
        boolean z;
        if (dragAndDropDroppableItem == null) {
            return;
        }
        dragAndDropDroppableItem.setGroup(configurationItem.getGroup());
        dragAndDropDroppableItem.setTargetLayoutPosition(configurationItem.getGroupPriority());
        if (configurationItem.getGroup() != -1) {
            z = true;
        } else {
            z = false;
        }
        dragAndDropDroppableItem.setDropped(z);
        dragAndDropDroppableItem.setType(r6);
        updateBadgeState(configurationItem, dragAndDropDroppableItem);
        this.mutableItems.add(dragAndDropDroppableItem);
        dragAndDropDroppableItem.setSourceGridViewIndex(this.mIndex);
        this.mIndex++;
    }

    public /* synthetic */ Future lambda$initItemData$0(List list, Map map) throws Exception {
        this.mContactsMap = map;
        return this.mNotificationProvider.getImportantAppMap(list);
    }

    public /* synthetic */ void lambda$initItemData$1(Map map) {
        this.mImportantAppsMap = map;
        createItems();
    }

    public /* synthetic */ void lambda$initItemData$2(final List list) {
        this.mConfigurationItems = list;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ConfigurationItem configurationItem = (ConfigurationItem) it.next();
            if (!this.mBadgeStates.containsKey(Integer.valueOf(configurationItem.getId()))) {
                this.mBadgeStates.put(Integer.valueOf(configurationItem.getId()), BadgeState.Normal);
            }
        }
        this.mNotificationProvider.getContactsMap(list).flatMap(new FlatMapCallback() { // from class: com.animaconnected.secondo.screens.notification.NotificationDragAndDropProvider$$ExternalSyntheticLambda2
            @Override // com.animaconnected.future.FlatMapCallback
            public final Future onResult(Object obj) {
                Future lambda$initItemData$0;
                lambda$initItemData$0 = NotificationDragAndDropProvider.this.lambda$initItemData$0(list, (Map) obj);
                return lambda$initItemData$0;
            }
        }).success(new NotificationProvider$$ExternalSyntheticLambda19(1, this));
    }

    public static /* synthetic */ Void lambda$removeLabsItems$10(List list) throws IOException {
        return null;
    }

    public /* synthetic */ Future lambda$removeLabsItems$9(List list) throws Exception {
        this.mConfigurationItems = list;
        ArrayList arrayList = new ArrayList();
        for (ConfigurationItem configurationItem : this.mConfigurationItems) {
            if (ProviderFactory.getLabsProvider().isNotificationItemTypeLabs(configurationItem.getType())) {
                arrayList.add(removeNotificationItem(configurationItem));
            }
        }
        return FutureUtils.merge(arrayList);
    }

    public /* synthetic */ void lambda$setGroupFailed$7(ConfigurationItem configurationItem) {
        initData();
    }

    public static /* synthetic */ void lambda$setGroupFailed$8(Throwable th) {
        Log.e(TAG, th.toString(), th);
    }

    public /* synthetic */ Future lambda$updateItemData$3(DragAndDropDroppableItem dragAndDropDroppableItem, Void r2) throws Exception {
        return this.mNotificationItemsDatabaseHelper.getConfigurationItemInDb(dragAndDropDroppableItem.getId().intValue());
    }

    public /* synthetic */ Future lambda$updateItemData$4(DragAndDropDroppableItem dragAndDropDroppableItem, ConfigurationItem configurationItem) throws Exception {
        configurationItem.setGroupPriority(dragAndDropDroppableItem.getTargetLayoutPosition());
        configurationItem.setGroup(dragAndDropDroppableItem.getGroup());
        updateBadgeState(configurationItem, dragAndDropDroppableItem);
        return this.mNotificationItemsDatabaseHelper.updateConfigurationItemInDb(configurationItem);
    }

    public /* synthetic */ void lambda$updateItemData$5(DragAndDropDroppableItem dragAndDropDroppableItem, ConfigurationItem configurationItem) {
        ProviderFactory.getWatch().sendFilterNotificationAnalytics();
        notifyItemChanged(configurationItem, configurationItem.getGroup(), dragAndDropDroppableItem.getCenterX(), dragAndDropDroppableItem.getCenterY());
    }

    public static /* synthetic */ void lambda$updateItemData$6(Throwable th) {
        Log.e(TAG, th.toString(), th);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0046 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x000d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ com.animaconnected.future.Future lambda$updateNotificationsGroups$11(boolean r7, java.util.List r8) throws java.lang.Exception {
        /*
            r6 = this;
            r6.mConfigurationItems = r8
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.List<com.animaconnected.secondo.provider.configuration.database.ConfigurationItem> r0 = r6.mConfigurationItems
            java.util.Iterator r0 = r0.iterator()
        Ld:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L50
            java.lang.Object r1 = r0.next()
            com.animaconnected.secondo.provider.configuration.database.ConfigurationItem r1 = (com.animaconnected.secondo.provider.configuration.database.ConfigurationItem) r1
            int r2 = r1.getGroupPriority()
            r3 = 3
            r4 = 0
            r5 = 1
            if (r2 == r3) goto L3c
            r3 = 7
            if (r2 == r3) goto L33
            r3 = 11
            if (r2 == r3) goto L2a
            goto L44
        L2a:
            if (r7 == 0) goto L2e
            r2 = 5
            goto L2f
        L2e:
            r2 = 2
        L2f:
            r1.setGroup(r2)
            goto L43
        L33:
            if (r7 == 0) goto L37
            r2 = 4
            goto L38
        L37:
            r2 = r5
        L38:
            r1.setGroup(r2)
            goto L43
        L3c:
            if (r7 == 0) goto L3f
            goto L40
        L3f:
            r3 = r4
        L40:
            r1.setGroup(r3)
        L43:
            r4 = r5
        L44:
            if (r4 == 0) goto Ld
            com.animaconnected.secondo.provider.configuration.database.DatabaseHelper r2 = r6.mNotificationItemsDatabaseHelper
            com.animaconnected.future.Future r1 = r2.updateConfigurationItemInDb(r1)
            r8.add(r1)
            goto Ld
        L50:
            com.animaconnected.future.Future r7 = com.animaconnected.future.FutureUtils.merge(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.notification.NotificationDragAndDropProvider.lambda$updateNotificationsGroups$11(boolean, java.util.List):com.animaconnected.future.Future");
    }

    public static /* synthetic */ Void lambda$updateNotificationsGroups$12(List list) throws IOException {
        return null;
    }

    private Future<ConfigurationItem> removeNotificationItem(ConfigurationItem configurationItem) {
        configurationItem.setGroupPriority(-1);
        configurationItem.setGroup(-1);
        return this.mNotificationItemsDatabaseHelper.updateConfigurationItemInDb(configurationItem);
    }

    private void updateBadgeState(ConfigurationItem configurationItem, DragAndDropDroppableItem dragAndDropDroppableItem) {
        BadgeState badgeState = this.mBadgeStates.get(Integer.valueOf(configurationItem.getId()));
        BadgeState badgeState2 = getBadgeState(configurationItem);
        if (badgeState != badgeState2 && dragAndDropDroppableItem.isDropped()) {
            if (badgeState2 != BadgeState.Normal) {
                dragAndDropDroppableItem.setBadgeVisualState(BadgeVisualState.AnimateIn);
            } else {
                dragAndDropDroppableItem.setBadgeVisualState(BadgeVisualState.AnimateOut);
            }
            this.mBadgeStates.put(Integer.valueOf(configurationItem.getId()), badgeState2);
        } else if (dragAndDropDroppableItem.isDropped() && badgeState2 != BadgeState.Normal) {
            dragAndDropDroppableItem.setBadgeVisualState(BadgeVisualState.Visible);
        } else {
            this.mBadgeStates.put(Integer.valueOf(configurationItem.getId()), BadgeState.Normal);
            dragAndDropDroppableItem.setBadgeVisualState(BadgeVisualState.Invisible);
        }
        dragAndDropDroppableItem.setBadgeState(badgeState2);
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public void clearBadgeState(DragAndDropDroppableItem dragAndDropDroppableItem) {
        clearBadgeState(dragAndDropDroppableItem.getId().intValue());
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public void clearData() {
        this.mHeaders.clear();
        this.mIndex = 0;
        super.clearData();
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public Drawable getBackgroundNotSelectedDrawable(int r3) {
        Context context = this.context;
        int r0 = this.mGroupNotSelectedResourceId;
        Object obj = ContextCompat.sLock;
        return ContextCompat.Api21Impl.getDrawable(context, r0);
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public Drawable getBackgroundSelectedDrawable(int r3) {
        Context context = this.context;
        int r0 = this.mGroupSelectedResourceId;
        Object obj = ContextCompat.sLock;
        return ContextCompat.Api21Impl.getDrawable(context, r0);
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public int getEmptyMarbleColorInt() {
        return ThemeProviderBase.getColor(this.context, R.attr.colorMarbleEmptyIcon);
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public Drawable getGroupDrawable(int r3) {
        if (r3 != 0) {
            if (r3 != 1) {
                if (r3 != 2) {
                    return null;
                }
                Context context = this.context;
                int r0 = this.mVibrationThreeId;
                Object obj = ContextCompat.sLock;
                return ContextCompat.Api21Impl.getDrawable(context, r0);
            }
            Context context2 = this.context;
            int r02 = this.mVibrationTwoId;
            Object obj2 = ContextCompat.sLock;
            return ContextCompat.Api21Impl.getDrawable(context2, r02);
        }
        Context context3 = this.context;
        int r03 = this.mVibrationOneId;
        Object obj3 = ContextCompat.sLock;
        return ContextCompat.Api21Impl.getDrawable(context3, r03);
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public int getHeaderTextStyle() {
        return ThemeProviderBase.getResourceId(this.context, R.attr.headersTextStyle);
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public List<DragAndDropItem> getItems(int r1) {
        return this.mutableItems;
    }

    public int getNumberOfContacts() {
        Iterator<DragAndDropItem> it = this.mutableItems.iterator();
        int r1 = 0;
        while (it.hasNext()) {
            if (it.next() instanceof DragAndDropMarbleContactItem) {
                r1++;
            }
        }
        return r1;
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public Drawable getPanelDropZoneNotSelectedDrawable() {
        Context context = this.context;
        int r1 = this.mGridDropZoneNotSelectedResourceId;
        Object obj = ContextCompat.sLock;
        return ContextCompat.Api21Impl.getDrawable(context, r1);
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public Drawable getPanelDropZoneSelectedDrawable() {
        Context context = this.context;
        int r1 = this.mGridDropZoneSelectedResourceId;
        Object obj = ContextCompat.sLock;
        return ContextCompat.Api21Impl.getDrawable(context, r1);
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public void initItemData() {
        clearData();
        createFakeContactSource();
        this.mNotificationItemsDatabaseHelper.getConfigurationItemsFromDb().success(new SuccessCallback() { // from class: com.animaconnected.secondo.screens.notification.NotificationDragAndDropProvider$$ExternalSyntheticLambda9
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                NotificationDragAndDropProvider.this.lambda$initItemData$2((List) obj);
            }
        });
    }

    public void onAnimationCompleted() {
        if (!this.mAnimationCompleted) {
            this.mAnimationCompleted = true;
            createItems();
        }
    }

    public Future<Void> removeLabsItems() {
        return this.mNotificationItemsDatabaseHelper.getConfigurationItemsFromDb().flatMap(new FlatMapCallback() { // from class: com.animaconnected.secondo.screens.notification.NotificationDragAndDropProvider$$ExternalSyntheticLambda10
            @Override // com.animaconnected.future.FlatMapCallback
            public final Future onResult(Object obj) {
                Future lambda$removeLabsItems$9;
                lambda$removeLabsItems$9 = NotificationDragAndDropProvider.this.lambda$removeLabsItems$9((List) obj);
                return lambda$removeLabsItems$9;
            }
        }).map(new NotificationDragAndDropProvider$$ExternalSyntheticLambda11());
    }

    public void setGroupFailed(ConfigurationItem configurationItem) {
        configurationItem.setGroupPriority(-1);
        configurationItem.setGroup(-1);
        this.mNotificationItemsDatabaseHelper.updateConfigurationItemInDb(configurationItem).success(new SuccessCallback() { // from class: com.animaconnected.secondo.screens.notification.NotificationDragAndDropProvider$$ExternalSyntheticLambda3
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                NotificationDragAndDropProvider.this.lambda$setGroupFailed$7((ConfigurationItem) obj);
            }
        }).fail(new NotificationDragAndDropProvider$$ExternalSyntheticLambda4());
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider
    public void updateItemData(final DragAndDropDroppableItem dragAndDropDroppableItem) {
        this.mNotificationItemsDatabaseHelper.removeItemOnGroupPriority(dragAndDropDroppableItem.getTargetLayoutPosition()).flatMap(new FlatMapCallback() { // from class: com.animaconnected.secondo.screens.notification.NotificationDragAndDropProvider$$ExternalSyntheticLambda5
            @Override // com.animaconnected.future.FlatMapCallback
            public final Future onResult(Object obj) {
                Future lambda$updateItemData$3;
                lambda$updateItemData$3 = NotificationDragAndDropProvider.this.lambda$updateItemData$3(dragAndDropDroppableItem, (Void) obj);
                return lambda$updateItemData$3;
            }
        }).flatMap(new FlatMapCallback() { // from class: com.animaconnected.secondo.screens.notification.NotificationDragAndDropProvider$$ExternalSyntheticLambda6
            @Override // com.animaconnected.future.FlatMapCallback
            public final Future onResult(Object obj) {
                Future lambda$updateItemData$4;
                lambda$updateItemData$4 = NotificationDragAndDropProvider.this.lambda$updateItemData$4(dragAndDropDroppableItem, (ConfigurationItem) obj);
                return lambda$updateItemData$4;
            }
        }).success(new SuccessCallback() { // from class: com.animaconnected.secondo.screens.notification.NotificationDragAndDropProvider$$ExternalSyntheticLambda7
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                NotificationDragAndDropProvider.this.lambda$updateItemData$5(dragAndDropDroppableItem, (ConfigurationItem) obj);
            }
        }).fail(new NotificationDragAndDropProvider$$ExternalSyntheticLambda8());
    }

    public Future<Void> updateNotificationsGroups(final boolean z) {
        return this.mNotificationItemsDatabaseHelper.getConfigurationItemsFromDb().flatMap(new FlatMapCallback() { // from class: com.animaconnected.secondo.screens.notification.NotificationDragAndDropProvider$$ExternalSyntheticLambda0
            @Override // com.animaconnected.future.FlatMapCallback
            public final Future onResult(Object obj) {
                Future lambda$updateNotificationsGroups$11;
                lambda$updateNotificationsGroups$11 = NotificationDragAndDropProvider.this.lambda$updateNotificationsGroups$11(z, (List) obj);
                return lambda$updateNotificationsGroups$11;
            }
        }).map(new FileSectionType$$ExternalSyntheticOutline0());
    }

    public void clearBadgeState(int r3) {
        this.mBadgeStates.put(Integer.valueOf(r3), BadgeState.Normal);
    }
}
