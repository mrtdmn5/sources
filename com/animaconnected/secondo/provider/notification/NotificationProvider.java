package com.animaconnected.secondo.provider.notification;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;
import com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda2;
import com.amazonaws.services.s3.Headers;
import com.animaconnected.cloud.amazon.AWSLambda$$ExternalSyntheticLambda26;
import com.animaconnected.future.AlwaysCallback;
import com.animaconnected.future.FailCallback;
import com.animaconnected.future.Future;
import com.animaconnected.future.Promise;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.future.runner.BackgroundRunner;
import com.animaconnected.future.runner.SequentialBackgroundRunner;
import com.animaconnected.secondo.notification.CriteriaProvider;
import com.animaconnected.secondo.notification.criteria.BooleanCriteria;
import com.animaconnected.secondo.notification.criteria.EmailCriteria;
import com.animaconnected.secondo.notification.criteria.ImportantAppCriteria;
import com.animaconnected.secondo.notification.criteria.MagicWordCriteria;
import com.animaconnected.secondo.notification.criteria.PhoneNumberCriteria;
import com.animaconnected.secondo.notification.model.Contact;
import com.animaconnected.secondo.notification.model.ImportantApp;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;
import com.animaconnected.secondo.provider.configuration.database.DatabaseHelper;
import com.animaconnected.secondo.provider.notification.NotificationProvider;
import com.animaconnected.secondo.provider.notification.configuration.item.NotificationItemConstants;
import com.animaconnected.secondo.provider.notification.configuration.item.NotificationItemsProvider;
import com.animaconnected.secondo.screens.notification.ContactPresenter$$ExternalSyntheticLambda1;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.stmt.query.In;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public class NotificationProvider {
    private static final String TAG = "NotificationProvider";
    private Dao<Contact, String> mContactDao;
    private final Context mContext;
    private final CriteriaProvider mCriteriaProvider;
    private Dao<ImportantApp, String> mImpAppDao;
    private Dao<ConfigurationItem, Integer> mNotificationItemsDao;
    private DatabaseHelper mNotificationItemsDatabaseHelper;
    private final Object mLock = new Object();
    private final BackgroundRunner mRunner = new SequentialBackgroundRunner();

    /* renamed from: com.animaconnected.secondo.provider.notification.NotificationProvider$1 */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements Callback<Contact> {
        final /* synthetic */ Callback val$callback;

        public AnonymousClass1(Callback callback) {
            r2 = callback;
        }

        @Override // com.animaconnected.secondo.provider.notification.NotificationProvider.Callback
        public void onFail(Throwable th) {
            Log.e(NotificationProvider.TAG, th.toString(), th);
        }

        @Override // com.animaconnected.secondo.provider.notification.NotificationProvider.Callback
        public void onSuccess(Contact contact) {
            r2.onSuccess(contact);
        }
    }

    /* loaded from: classes3.dex */
    public interface Callback<K> {
        void onFail(Throwable th);

        void onSuccess(K k);
    }

    public NotificationProvider(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        com.animaconnected.secondo.notification.model.DatabaseHelper databaseHelper = new com.animaconnected.secondo.notification.model.DatabaseHelper(applicationContext);
        this.mCriteriaProvider = ProviderFactory.getCriteriaProvider();
        try {
            this.mContactDao = databaseHelper.getContactDao();
            this.mImpAppDao = databaseHelper.getImpAppDao();
            this.mNotificationItemsDao = NotificationItemsProvider.getInstance(context).getDatabaseHelper().getDao();
            this.mNotificationItemsDatabaseHelper = NotificationItemsProvider.getInstance(context).getDatabaseHelper();
        } catch (SQLException unused) {
        }
    }

    private void createContactNotificationItem(String str) {
        try {
            this.mNotificationItemsDao.create(new ConfigurationItem(2, 0, str, -1, -1));
        } catch (SQLException e) {
            Log.e(TAG, "Failed to create contact notification item ", e);
        }
    }

    private void createImportantAppNotificationItem(String str) {
        try {
            this.mNotificationItemsDao.create(new ConfigurationItem(4, 2, str, -1, -1));
        } catch (SQLException e) {
            Log.e(TAG, "Failed to create contact important app item ", e);
        }
    }

    private Future<Void> deleteContact(final Contact contact) {
        return this.mRunner.submit(new Callable() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda29
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void lambda$deleteContact$9;
                lambda$deleteContact$9 = NotificationProvider.this.lambda$deleteContact$9(contact);
                return lambda$deleteContact$9;
            }
        }).success(new SuccessCallback() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda30
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                NotificationProvider.this.lambda$deleteContact$10((Void) obj);
            }
        });
    }

    private Future<Void> deleteImportantApp(ImportantApp importantApp) {
        return this.mRunner.submit(new LottieCompositionFactory$$ExternalSyntheticLambda2(this, 1, importantApp)).success(new SuccessCallback() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda27
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                NotificationProvider.this.lambda$deleteImportantApp$12((Void) obj);
            }
        });
    }

    private void getContact(final String str, final Callback<Contact> callback) {
        this.mRunner.submit(new Callable() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Contact lambda$getContact$3;
                lambda$getContact$3 = NotificationProvider.this.lambda$getContact$3(str);
                return lambda$getContact$3;
            }
        }).success(new SuccessCallback() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda9
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                NotificationProvider.this.lambda$getContact$4(callback, (Contact) obj);
            }
        }).fail(new FailCallback() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda10
            @Override // com.animaconnected.future.FailCallback
            public final void onFail(Throwable th) {
                NotificationProvider.lambda$getContact$5(NotificationProvider.Callback.this, th);
            }
        });
    }

    private Future<ImportantApp> getImportantApp(final String str) {
        return this.mRunner.submit(new Callable() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda13
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ImportantApp lambda$getImportantApp$20;
                lambda$getImportantApp$20 = NotificationProvider.this.lambda$getImportantApp$20(str);
                return lambda$getImportantApp$20;
            }
        });
    }

    private Future<List<ImportantApp>> getImportantAppASync() {
        return this.mRunner.submit(new Callable() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda31
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List lambda$getImportantAppASync$16;
                lambda$getImportantAppASync$16 = NotificationProvider.this.lambda$getImportantAppASync$16();
                return lambda$getImportantAppASync$16;
            }
        });
    }

    private ConfigurationItem getNotificationItem(int r3) {
        try {
            List queryForEq = this.mNotificationItemsDao.queryForEq(Integer.valueOf(r3));
            if (queryForEq.isEmpty()) {
                return null;
            }
            return (ConfigurationItem) queryForEq.get(0);
        } catch (SQLException unused) {
            return null;
        }
    }

    public /* synthetic */ ImportantApp lambda$addImportantApp$13(ImportantApp importantApp) throws Exception {
        synchronized (this.mLock) {
            if (this.mImpAppDao.queryForId(importantApp.getPackageName()) == null) {
                this.mImpAppDao.create(importantApp);
                createImportantAppNotificationItem(importantApp.getPackageName());
            }
        }
        return null;
    }

    public /* synthetic */ void lambda$addImportantApp$14(Callback callback, ImportantApp importantApp) {
        if (callback != null) {
            callback.onSuccess(null);
        }
        refresh();
    }

    public static /* synthetic */ void lambda$addImportantApp$15(Callback callback, Throwable th) {
        Log.e(TAG, "Adding Important App:", th);
        if (callback != null) {
            callback.onFail(th);
        }
    }

    public /* synthetic */ Contact lambda$createUpdateContactFromUri$0(String str, Uri uri, Contact contact) throws Exception {
        Cursor cursor;
        Cursor cursor2;
        boolean z;
        Cursor cursor3;
        Cursor cursor4 = null;
        try {
            synchronized (this.mLock) {
                try {
                    Contact queryForId = this.mContactDao.queryForId(str);
                    if (queryForId == null) {
                        queryForId = new Contact();
                        queryForId.setUri(str);
                        z = true;
                    } else {
                        z = false;
                    }
                    String lastPathSegment = uri.getLastPathSegment();
                    ContentResolver contentResolver = this.mContext.getContentResolver();
                    Cursor query = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, "_id=?", new String[]{lastPathSegment}, null);
                    if (query != null) {
                        try {
                            if (query.moveToFirst()) {
                                if (z) {
                                    queryForId.setName(query.getString(query.getColumnIndex("display_name")));
                                    if (Integer.parseInt(query.getString(query.getColumnIndex("has_phone_number"))) > 0) {
                                        Cursor query2 = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id = ?", new String[]{lastPathSegment}, null);
                                        try {
                                            StringBuilder sb = new StringBuilder();
                                            while (query2 != null && query2.moveToNext()) {
                                                sb.append(query2.getString(query2.getColumnIndex("data1")));
                                                sb.append(Contact.PHONE_NUMBERS_DELIMITER);
                                            }
                                            queryForId.setPhoneNumber(sb.toString());
                                            queryForId.setCallsFilterEnabled(true);
                                            queryForId.setMessagesFilterEnabled(true);
                                            queryForId.setEmailFilterEnabled(false);
                                            cursor2 = query2;
                                        } catch (Throwable th) {
                                            th = th;
                                            cursor2 = query2;
                                            cursor = cursor4;
                                            cursor4 = query;
                                            while (true) {
                                                try {
                                                    try {
                                                        break;
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        if (cursor4 != null) {
                                                            cursor4.close();
                                                        }
                                                        if (cursor2 != null) {
                                                            cursor2.close();
                                                        }
                                                        if (cursor != null) {
                                                            cursor.close();
                                                        }
                                                        throw th;
                                                    }
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                }
                                            }
                                            throw th;
                                        }
                                    } else {
                                        cursor2 = null;
                                    }
                                    try {
                                        cursor4 = contentResolver.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, "contact_id = ?", new String[]{lastPathSegment}, null);
                                        while (cursor4 != null) {
                                            if (!cursor4.moveToNext()) {
                                                break;
                                            }
                                            queryForId.setEmail(cursor4.getString(cursor4.getColumnIndex("data1")));
                                        }
                                        Cursor cursor5 = cursor2;
                                        cursor3 = cursor4;
                                        cursor4 = cursor5;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        cursor = cursor4;
                                        cursor4 = query;
                                        while (true) {
                                            break;
                                            break;
                                        }
                                        throw th;
                                    }
                                } else {
                                    if (contact != null) {
                                        queryForId.setCallsFilterEnabled(contact.isCallsFilterEnabled());
                                        queryForId.setMessagesFilterEnabled(contact.isMessagesFilterEnabled());
                                        queryForId.setEmailFilterEnabled(contact.isEmailFilterEnabled());
                                    }
                                    cursor3 = null;
                                }
                                try {
                                    this.mContactDao.createOrUpdate(queryForId);
                                    this.mContactDao.refresh(queryForId);
                                    if (z) {
                                        createContactNotificationItem(queryForId.getUri());
                                    }
                                    query.close();
                                    if (cursor4 != null) {
                                        cursor4.close();
                                    }
                                    if (cursor3 != null) {
                                        cursor3.close();
                                    }
                                    return queryForId;
                                } catch (Throwable th5) {
                                    th = th5;
                                    Cursor cursor6 = cursor3;
                                    cursor2 = cursor4;
                                    cursor4 = cursor6;
                                    cursor = cursor4;
                                    cursor4 = query;
                                    while (true) {
                                        break;
                                        break;
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            cursor2 = null;
                        }
                    }
                    throw new Exception("No contact found!");
                } catch (Throwable th7) {
                    th = th7;
                    cursor = null;
                    cursor2 = null;
                }
            }
        } catch (Throwable th8) {
            th = th8;
            cursor = null;
            cursor2 = null;
        }
    }

    public /* synthetic */ void lambda$createUpdateContactFromUri$1(Callback callback, Contact contact) {
        if (callback != null) {
            callback.onSuccess(contact);
        }
        updateNotificationsCriteria();
    }

    public static /* synthetic */ void lambda$createUpdateContactFromUri$2(Callback callback, Throwable th) {
        Log.e(TAG, "Creating contact:", th);
        if (callback != null) {
            callback.onFail(th);
        }
    }

    public /* synthetic */ void lambda$deleteContact$10(Void r1) {
        updateNotificationsCriteria();
    }

    public /* synthetic */ Void lambda$deleteContact$9(Contact contact) throws Exception {
        this.mContactDao.delete((Dao<Contact, String>) contact);
        return null;
    }

    public static /* synthetic */ void lambda$deleteContactAndConfigurationItem$22(Promise promise, Throwable th) {
        promise.reject(th.getCause());
    }

    public /* synthetic */ void lambda$deleteContactAndConfigurationItem$23(Contact contact, final Promise promise, Integer num) {
        deleteContact(contact).success(new SuccessCallback() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda25
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                Promise.this.resolve(null);
            }
        }).fail(new FailCallback() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda26
            @Override // com.animaconnected.future.FailCallback
            public final void onFail(Throwable th) {
                NotificationProvider.lambda$deleteContactAndConfigurationItem$22(Promise.this, th);
            }
        });
    }

    public static /* synthetic */ void lambda$deleteContactAndConfigurationItem$24(Throwable th) {
        Log.e(TAG, th.toString(), th);
    }

    public /* synthetic */ void lambda$deleteContactAndConfigurationItem$25(final Contact contact, final Promise promise, Integer num) {
        if (num.intValue() != -1) {
            this.mNotificationItemsDatabaseHelper.deleteConfigurationItemInDb(num.intValue()).success(new SuccessCallback() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda1
                @Override // com.animaconnected.future.SuccessCallback
                public final void onSuccess(Object obj) {
                    NotificationProvider.this.lambda$deleteContactAndConfigurationItem$23(contact, promise, (Integer) obj);
                }
            }).fail(new NotificationProvider$$ExternalSyntheticLambda2());
        }
    }

    public /* synthetic */ Void lambda$deleteImportantApp$11(ImportantApp importantApp) throws Exception {
        this.mImpAppDao.delete((Dao<ImportantApp, String>) importantApp);
        return null;
    }

    public /* synthetic */ void lambda$deleteImportantApp$12(Void r1) {
        updateNotificationsCriteria();
    }

    public static /* synthetic */ void lambda$deleteImportantAppAndConfigurationItem$27(Promise promise, Throwable th) {
        promise.reject(th.getCause());
    }

    public /* synthetic */ void lambda$deleteImportantAppAndConfigurationItem$28(ImportantApp importantApp, final Promise promise, Integer num) {
        deleteImportantApp(importantApp).success(new SuccessCallback() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda0
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                Promise.this.resolve(null);
            }
        }).fail(new AWSLambda$$ExternalSyntheticLambda26(1, promise));
    }

    public static /* synthetic */ void lambda$deleteImportantAppAndConfigurationItem$29(Throwable th) {
        Log.e(TAG, th.toString(), th);
    }

    public /* synthetic */ void lambda$deleteImportantAppAndConfigurationItem$30(final ImportantApp importantApp, final Promise promise, Integer num) {
        if (num.intValue() != -1) {
            this.mNotificationItemsDatabaseHelper.deleteConfigurationItemInDb(num.intValue()).success(new SuccessCallback() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda32
                @Override // com.animaconnected.future.SuccessCallback
                public final void onSuccess(Object obj) {
                    NotificationProvider.this.lambda$deleteImportantAppAndConfigurationItem$28(importantApp, promise, (Integer) obj);
                }
            }).fail(new NotificationProvider$$ExternalSyntheticLambda33());
        }
    }

    public /* synthetic */ Contact lambda$getContact$3(String str) throws Exception {
        Contact queryForId;
        synchronized (this.mLock) {
            queryForId = this.mContactDao.queryForId(str);
        }
        return queryForId;
    }

    public /* synthetic */ void lambda$getContact$4(Callback callback, Contact contact) {
        if (callback != null) {
            callback.onSuccess(contact);
        }
        updateNotificationsCriteria();
    }

    public static /* synthetic */ void lambda$getContact$5(Callback callback, Throwable th) {
        Log.e(TAG, "Fetching contact:", th);
        if (callback != null) {
            callback.onFail(th);
        }
    }

    public /* synthetic */ void lambda$getContactFromConfigurationItemId$31(Callback callback, ConfigurationItem configurationItem) {
        getContact(configurationItem.getExternalId(), new Callback<Contact>() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider.1
            final /* synthetic */ Callback val$callback;

            public AnonymousClass1(Callback callback2) {
                r2 = callback2;
            }

            @Override // com.animaconnected.secondo.provider.notification.NotificationProvider.Callback
            public void onFail(Throwable th) {
                Log.e(NotificationProvider.TAG, th.toString(), th);
            }

            @Override // com.animaconnected.secondo.provider.notification.NotificationProvider.Callback
            public void onSuccess(Contact contact) {
                r2.onSuccess(contact);
            }
        });
    }

    public static /* synthetic */ void lambda$getContactFromConfigurationItemId$32(Throwable th) {
        Log.e(TAG, th.toString(), th);
    }

    public /* synthetic */ List lambda$getContacts$6() throws Exception {
        List<Contact> queryForAll;
        synchronized (this.mLock) {
            queryForAll = this.mContactDao.queryForAll();
        }
        return queryForAll;
    }

    public static /* synthetic */ void lambda$getContacts$7(Callback callback, List list) {
        if (callback != null) {
            callback.onSuccess(list);
        }
    }

    public static /* synthetic */ void lambda$getContacts$8(Callback callback, Throwable th) {
        Log.e(TAG, "Fetching contacts:", th);
        if (callback != null) {
            callback.onFail(th);
        }
    }

    public Map lambda$getContactsMap$18(List list) throws Exception {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ConfigurationItem configurationItem = (ConfigurationItem) it.next();
            if (configurationItem.getType() == 2) {
                arrayList.add(configurationItem.getExternalId());
            }
        }
        Where<Contact, String> where = this.mContactDao.queryBuilder().where();
        where.addClause(new In(Contact.FIELD_NAME_URI, where.tableInfo.getFieldTypeByColumnName(Contact.FIELD_NAME_URI), arrayList));
        for (Contact contact : where.query()) {
            hashMap.put(contact.getUri(), contact);
        }
        return hashMap;
    }

    public static /* synthetic */ HashMap lambda$getFilterNotificationConfig$36(List list) throws IOException {
        String externalId;
        HashMap hashMap = new HashMap();
        for (int r1 = 0; r1 < list.size(); r1++) {
            ConfigurationItem configurationItem = (ConfigurationItem) list.get(r1);
            if (configurationItem.getGroup() != -1) {
                if (configurationItem.getType() != 4) {
                    externalId = NotificationItemConstants.getNotificationName(configurationItem.getType());
                } else {
                    externalId = configurationItem.getExternalId();
                }
                hashMap.put(Integer.valueOf(configurationItem.getGroupPriority()), externalId);
            }
        }
        return hashMap;
    }

    public /* synthetic */ ImportantApp lambda$getImportantApp$20(String str) throws Exception {
        Where<ImportantApp, String> where = this.mImpAppDao.queryBuilder().where();
        where.eq(str, "package");
        List<ImportantApp> query = where.query();
        if (query.size() > 0) {
            return query.get(0);
        }
        return null;
    }

    public /* synthetic */ List lambda$getImportantAppASync$16() throws Exception {
        List<ImportantApp> importantAppSync;
        synchronized (this.mLock) {
            importantAppSync = getImportantAppSync();
        }
        return importantAppSync;
    }

    public /* synthetic */ void lambda$getImportantAppFromConfigurationItemId$34(final Callback callback, ConfigurationItem configurationItem) {
        getImportantApp(configurationItem.getExternalId()).success(new SuccessCallback() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda15
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                NotificationProvider.Callback.this.onSuccess((ImportantApp) obj);
            }
        });
    }

    public static /* synthetic */ void lambda$getImportantAppFromConfigurationItemId$35(Throwable th) {
        Log.e(TAG, th.toString(), th);
    }

    public Map lambda$getImportantAppMap$19(List list) throws Exception {
        String externalId;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ConfigurationItem configurationItem = (ConfigurationItem) it.next();
            if (configurationItem.getType() == 4 && (externalId = configurationItem.getExternalId()) != null) {
                arrayList.add(externalId);
            }
        }
        Where<ImportantApp, String> where = this.mImpAppDao.queryBuilder().where();
        where.addClause(new In("package", where.tableInfo.getFieldTypeByColumnName("package"), arrayList));
        for (ImportantApp importantApp : where.query()) {
            hashMap.put(importantApp.getPackageName(), importantApp);
        }
        return hashMap;
    }

    public /* synthetic */ ConfigurationItem lambda$getNotificationItemASync$17(int r2) throws Exception {
        ConfigurationItem notificationItem;
        synchronized (this.mLock) {
            notificationItem = getNotificationItem(r2);
        }
        return notificationItem;
    }

    public static /* synthetic */ void lambda$updateNotificationsCriteria$37(List list, CriteriaProvider.Config config, List list2, Map map) {
        Iterator it = list.iterator();
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
        while (it.hasNext()) {
            ConfigurationItem configurationItem = (ConfigurationItem) it.next();
            int group = configurationItem.getGroup();
            int r7 = group + 1;
            switch (configurationItem.getType()) {
                case 0:
                    BooleanCriteria booleanCriteria = new BooleanCriteria(true);
                    config.allCallsCriteria = booleanCriteria;
                    booleanCriteria.setAction(group);
                    r5 = r7;
                    break;
                case 2:
                    Contact contact = (Contact) map.get(configurationItem.getExternalId());
                    if (contact != null) {
                        if (contact.isCallsFilterEnabled()) {
                            PhoneNumberCriteria phoneNumberCriteria = new PhoneNumberCriteria(contact.getPhoneNumber());
                            phoneNumberCriteria.setAction(group);
                            config.phoneNumberCriterias.add(phoneNumberCriteria);
                        }
                        if (contact.isMessagesFilterEnabled()) {
                            PhoneNumberCriteria phoneNumberCriteria2 = new PhoneNumberCriteria(contact.getPhoneNumber());
                            phoneNumberCriteria2.setAction(group);
                            config.messagesCriterias.add(phoneNumberCriteria2);
                        }
                        if (!contact.isEmailFilterEnabled()) {
                            break;
                        } else {
                            EmailCriteria emailCriteria = new EmailCriteria(contact.getEmail());
                            emailCriteria.setAction(group);
                            config.emailCriterias.add(emailCriteria);
                            break;
                        }
                    } else {
                        Log.w(TAG, "Received contact with no match");
                        break;
                    }
                case 3:
                    BooleanCriteria booleanCriteria2 = new BooleanCriteria(true);
                    config.calendarCriteria = booleanCriteria2;
                    booleanCriteria2.setAction(group);
                    break;
                case 4:
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        ImportantApp importantApp = (ImportantApp) it2.next();
                        if (importantApp.getPackageName().equals(configurationItem.getExternalId())) {
                            ImportantAppCriteria importantAppCriteria = new ImportantAppCriteria(importantApp);
                            importantAppCriteria.setAction(group);
                            config.importantAppCriterias.add(importantAppCriteria);
                        }
                    }
                    break;
                case 5:
                    r2 = r7;
                    break;
                case 6:
                    r3 = r7;
                    break;
                case 7:
                    r4 = r7;
                    break;
                case 9:
                    BooleanCriteria booleanCriteria3 = new BooleanCriteria(true);
                    config.allMessagesCriteria = booleanCriteria3;
                    booleanCriteria3.setAction(group);
                    break;
                case 11:
                    MagicWordCriteria magicWordCriteria = new MagicWordCriteria();
                    magicWordCriteria.setAction(group);
                    config.magicWordCriteria = magicWordCriteria;
                    break;
                case 12:
                    r6 = r7;
                    break;
            }
        }
        ProviderFactory.getWatch().setAlertTypes(r2, r3, r4, r5, r6);
    }

    public /* synthetic */ void lambda$updateNotificationsCriteria$38(CriteriaProvider.Config config) {
        this.mCriteriaProvider.updateASync(config);
    }

    public /* synthetic */ void lambda$updateNotificationsCriteria$39(final CriteriaProvider.Config config, final List list, final List list2) {
        getContactsMap(list2).success(new SuccessCallback() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda23
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                NotificationProvider.lambda$updateNotificationsCriteria$37(list2, config, list, (Map) obj);
            }
        }).always(new AlwaysCallback() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda24
            @Override // com.animaconnected.future.AlwaysCallback
            public final void onFinished() {
                NotificationProvider.this.lambda$updateNotificationsCriteria$38(config);
            }
        });
    }

    public /* synthetic */ void lambda$updateNotificationsCriteria$40(final CriteriaProvider.Config config, final List list) {
        NotificationItemsProvider.getInstance(this.mContext).getDatabaseHelper().getEnabledItems(-1).success(new SuccessCallback() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda7
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                NotificationProvider.this.lambda$updateNotificationsCriteria$39(config, list, (List) obj);
            }
        });
    }

    private void updateNotificationsCriteria() {
        final CriteriaProvider.Config config = new CriteriaProvider.Config();
        config.allCallsCriteria = null;
        config.allMessagesCriteria = null;
        config.calendarCriteria = null;
        config.messagesCriterias = new ArrayList();
        config.phoneNumberCriterias = new ArrayList();
        config.emailCriterias = new ArrayList();
        config.importantAppCriterias = new ArrayList();
        getImportantAppASync().success(new SuccessCallback() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda16
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                NotificationProvider.this.lambda$updateNotificationsCriteria$40(config, (List) obj);
            }
        });
    }

    public void addImportantApp(final ImportantApp importantApp, final Callback<Void> callback) {
        this.mRunner.submit(new Callable() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda35
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ImportantApp lambda$addImportantApp$13;
                lambda$addImportantApp$13 = NotificationProvider.this.lambda$addImportantApp$13(importantApp);
                return lambda$addImportantApp$13;
            }
        }).success(new SuccessCallback() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda36
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                NotificationProvider.this.lambda$addImportantApp$14(callback, (ImportantApp) obj);
            }
        }).fail(new FailCallback() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda37
            @Override // com.animaconnected.future.FailCallback
            public final void onFail(Throwable th) {
                NotificationProvider.lambda$addImportantApp$15(NotificationProvider.Callback.this, th);
            }
        });
    }

    @SuppressLint({Headers.RANGE})
    public void createUpdateContactFromUri(final Uri uri, final Contact contact, final Callback<Contact> callback) {
        final String uri2 = uri.toString();
        this.mRunner.submit(new Callable() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Contact lambda$createUpdateContactFromUri$0;
                lambda$createUpdateContactFromUri$0 = NotificationProvider.this.lambda$createUpdateContactFromUri$0(uri2, uri, contact);
                return lambda$createUpdateContactFromUri$0;
            }
        }).success(new SuccessCallback() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda4
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                NotificationProvider.this.lambda$createUpdateContactFromUri$1(callback, (Contact) obj);
            }
        }).fail(new FailCallback() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda5
            @Override // com.animaconnected.future.FailCallback
            public final void onFail(Throwable th) {
                NotificationProvider.lambda$createUpdateContactFromUri$2(NotificationProvider.Callback.this, th);
            }
        });
    }

    public Future<Void> deleteContactAndConfigurationItem(final Contact contact) {
        final Promise promise = new Promise();
        this.mNotificationItemsDatabaseHelper.getConfigurationItemId(contact.getUri()).success(new SuccessCallback() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda34
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                NotificationProvider.this.lambda$deleteContactAndConfigurationItem$25(contact, promise, (Integer) obj);
            }
        });
        return promise.getFuture();
    }

    public Future<Void> deleteImportantAppAndConfigurationItem(final ImportantApp importantApp) {
        final Promise promise = new Promise();
        this.mNotificationItemsDatabaseHelper.getConfigurationItemId(importantApp.getPackageName()).success(new SuccessCallback() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda17
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                NotificationProvider.this.lambda$deleteImportantAppAndConfigurationItem$30(importantApp, promise, (Integer) obj);
            }
        });
        return promise.getFuture();
    }

    public void getContactFromConfigurationItemId(int r2, final Callback<Contact> callback) {
        this.mNotificationItemsDatabaseHelper.getConfigurationItemInDb(r2).success(new SuccessCallback() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda21
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                NotificationProvider.this.lambda$getContactFromConfigurationItemId$31(callback, (ConfigurationItem) obj);
            }
        }).fail(new NotificationProvider$$ExternalSyntheticLambda22());
    }

    public void getContacts(final Callback<List<Contact>> callback) {
        this.mRunner.submit(new Callable() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda18
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List lambda$getContacts$6;
                lambda$getContacts$6 = NotificationProvider.this.lambda$getContacts$6();
                return lambda$getContacts$6;
            }
        }).success(new NotificationProvider$$ExternalSyntheticLambda19(0, callback)).fail(new FailCallback() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda20
            @Override // com.animaconnected.future.FailCallback
            public final void onFail(Throwable th) {
                NotificationProvider.lambda$getContacts$8(NotificationProvider.Callback.this, th);
            }
        });
    }

    public Future<Map<String, Contact>> getContactsMap(final List<ConfigurationItem> list) {
        return this.mRunner.submit(new Callable() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda14
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Map lambda$getContactsMap$18;
                lambda$getContactsMap$18 = NotificationProvider.this.lambda$getContactsMap$18(list);
                return lambda$getContactsMap$18;
            }
        });
    }

    public Future<HashMap<Integer, String>> getFilterNotificationConfig() {
        return NotificationItemsProvider.getInstance(this.mContext).getDatabaseHelper().getConfigurationItemsFromDb().map(new ConstraintWidget$$ExternalSyntheticOutline0());
    }

    public void getImportantAppFromConfigurationItemId(int r2, final Callback<ImportantApp> callback) {
        this.mNotificationItemsDatabaseHelper.getConfigurationItemInDb(r2).success(new SuccessCallback() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda11
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                NotificationProvider.this.lambda$getImportantAppFromConfigurationItemId$34(callback, (ConfigurationItem) obj);
            }
        }).fail(new ContactPresenter$$ExternalSyntheticLambda1(1));
    }

    public Future<Map<String, ImportantApp>> getImportantAppMap(final List<ConfigurationItem> list) {
        return this.mRunner.submit(new Callable() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda28
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Map lambda$getImportantAppMap$19;
                lambda$getImportantAppMap$19 = NotificationProvider.this.lambda$getImportantAppMap$19(list);
                return lambda$getImportantAppMap$19;
            }
        });
    }

    public List<ImportantApp> getImportantAppSync() {
        try {
            return this.mImpAppDao.queryForAll();
        } catch (SQLException unused) {
            return null;
        }
    }

    public Future<ConfigurationItem> getNotificationItemASync(final int r3) {
        return this.mRunner.submit(new Callable() { // from class: com.animaconnected.secondo.provider.notification.NotificationProvider$$ExternalSyntheticLambda12
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ConfigurationItem lambda$getNotificationItemASync$17;
                lambda$getNotificationItemASync$17 = NotificationProvider.this.lambda$getNotificationItemASync$17(r3);
                return lambda$getNotificationItemASync$17;
            }
        });
    }

    public void refresh() {
        updateNotificationsCriteria();
    }
}
