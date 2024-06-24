package com.animaconnected.secondo.notification;

import android.util.Log;
import com.animaconnected.future.runner.BackgroundRunner;
import com.animaconnected.future.runner.SequentialBackgroundRunner;
import com.animaconnected.secondo.notification.criteria.AndCriteria;
import com.animaconnected.secondo.notification.criteria.BooleanCriteria;
import com.animaconnected.secondo.notification.criteria.Criteria;
import com.animaconnected.secondo.notification.criteria.EmailCriteria;
import com.animaconnected.secondo.notification.criteria.GroupCriteria;
import com.animaconnected.secondo.notification.criteria.ImportantAppCriteria;
import com.animaconnected.secondo.notification.criteria.MagicWordCriteria;
import com.animaconnected.secondo.notification.criteria.OrCriteria;
import com.animaconnected.secondo.notification.criteria.PackageCriteria;
import com.animaconnected.secondo.notification.criteria.PhoneNumberCriteria;
import com.animaconnected.secondo.notification.criteria.TypeCriteria;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public class CriteriaProvider {
    private static final String TAG = "CriteriaProvider";
    private final Object mLock = new Object();
    private final Object mUpdateLock = new Object();
    private GroupCriteria mRootCriteria = new OrCriteria();
    private final BackgroundRunner mRunner = new SequentialBackgroundRunner();

    /* loaded from: classes3.dex */
    public static class Config {
        public BooleanCriteria allCallsCriteria;
        public BooleanCriteria allMessagesCriteria;
        public BooleanCriteria calendarCriteria;
        public List<EmailCriteria> emailCriterias;
        public List<ImportantAppCriteria> importantAppCriterias;
        public MagicWordCriteria magicWordCriteria;
        public List<PhoneNumberCriteria> messagesCriterias;
        public List<PhoneNumberCriteria> phoneNumberCriterias;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void lambda$updateASync$0(Config config) throws Exception {
        updateSync(config);
        return null;
    }

    private void setRootCriteria(OrCriteria orCriteria) {
        Log.i(TAG, "Criterion updated.");
        synchronized (this.mLock) {
            this.mRootCriteria = orCriteria;
        }
    }

    private void updateSync(Config config) {
        synchronized (this.mUpdateLock) {
            OrCriteria orCriteria = new OrCriteria();
            OrCriteria orCriteria2 = new OrCriteria();
            orCriteria.add(orCriteria2);
            Criteria criteria = config.magicWordCriteria;
            if (criteria != null) {
                orCriteria.add(criteria);
            }
            List<PhoneNumberCriteria> list = config.messagesCriterias;
            if (list != null && !list.isEmpty()) {
                AndCriteria andCriteria = new AndCriteria();
                orCriteria2.add(andCriteria);
                andCriteria.add(new TypeCriteria("msg"));
                OrCriteria orCriteria3 = new OrCriteria();
                andCriteria.add(orCriteria3);
                Iterator<PhoneNumberCriteria> it = config.messagesCriterias.iterator();
                while (it.hasNext()) {
                    orCriteria3.add(it.next());
                }
            }
            List<PhoneNumberCriteria> list2 = config.phoneNumberCriterias;
            if (list2 != null && !list2.isEmpty()) {
                AndCriteria andCriteria2 = new AndCriteria();
                orCriteria2.add(andCriteria2);
                andCriteria2.add(new TypeCriteria("call"));
                OrCriteria orCriteria4 = new OrCriteria();
                andCriteria2.add(orCriteria4);
                Iterator<PhoneNumberCriteria> it2 = config.phoneNumberCriterias.iterator();
                while (it2.hasNext()) {
                    orCriteria4.add(it2.next());
                }
            }
            List<EmailCriteria> list3 = config.emailCriterias;
            if (list3 != null && !list3.isEmpty()) {
                AndCriteria andCriteria3 = new AndCriteria();
                orCriteria2.add(andCriteria3);
                andCriteria3.add(new TypeCriteria("email"));
                OrCriteria orCriteria5 = new OrCriteria();
                andCriteria3.add(orCriteria5);
                Iterator<EmailCriteria> it3 = config.emailCriterias.iterator();
                while (it3.hasNext()) {
                    orCriteria5.add(it3.next());
                }
            }
            if (config.calendarCriteria != null) {
                AndCriteria andCriteria4 = new AndCriteria();
                andCriteria4.add(config.calendarCriteria);
                andCriteria4.add(new TypeCriteria("event"));
                orCriteria.add(andCriteria4);
            }
            if (config.allCallsCriteria != null) {
                AndCriteria andCriteria5 = new AndCriteria();
                andCriteria5.add(config.allCallsCriteria);
                andCriteria5.add(new TypeCriteria("call"));
                orCriteria.add(andCriteria5);
            }
            if (config.allMessagesCriteria != null) {
                AndCriteria andCriteria6 = new AndCriteria();
                andCriteria6.add(config.allMessagesCriteria);
                andCriteria6.add(new TypeCriteria("msg"));
                andCriteria6.add(new PackageCriteria(DeviceNotification.SMS_RECEIVER_PACKAGE_NAME));
                orCriteria.add(andCriteria6);
            }
            List<ImportantAppCriteria> list4 = config.importantAppCriterias;
            if (list4 != null && !list4.isEmpty()) {
                Iterator<ImportantAppCriteria> it4 = config.importantAppCriterias.iterator();
                while (it4.hasNext()) {
                    orCriteria.add(it4.next());
                }
            }
            setRootCriteria(orCriteria);
        }
    }

    public GroupCriteria getRootCriteria() {
        GroupCriteria groupCriteria;
        synchronized (this.mLock) {
            groupCriteria = this.mRootCriteria;
        }
        return groupCriteria;
    }

    public void updateASync(final Config config) {
        this.mRunner.submit(new Callable() { // from class: com.animaconnected.secondo.notification.CriteriaProvider$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void lambda$updateASync$0;
                lambda$updateASync$0 = CriteriaProvider.this.lambda$updateASync$0(config);
                return lambda$updateASync$0;
            }
        });
    }
}
