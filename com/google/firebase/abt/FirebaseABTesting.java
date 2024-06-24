package com.google.firebase.abt;

import android.text.TextUtils;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Provider;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class FirebaseABTesting {
    public final Provider<AnalyticsConnector> analyticsConnector;
    public final String originService = "frc";
    public Integer maxUserProperties = null;

    public FirebaseABTesting(Provider provider) {
        this.analyticsConnector = provider;
    }

    public final List<AnalyticsConnector.ConditionalUserProperty> getAllExperimentsInAnalytics() {
        return this.analyticsConnector.get().getConditionalUserProperties(this.originService);
    }

    public final void replaceAllExperiments(ArrayList arrayList) throws AbtException {
        String str;
        Provider<AnalyticsConnector> provider = this.analyticsConnector;
        if (provider.get() != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Map map = (Map) it.next();
                String[] strArr = AbtExperimentInfo.ALL_REQUIRED_KEYS;
                ArrayList arrayList3 = new ArrayList();
                String[] strArr2 = AbtExperimentInfo.ALL_REQUIRED_KEYS;
                for (int r9 = 0; r9 < 5; r9++) {
                    String str2 = strArr2[r9];
                    if (!map.containsKey(str2)) {
                        arrayList3.add(str2);
                    }
                }
                if (arrayList3.isEmpty()) {
                    try {
                        Date parse = AbtExperimentInfo.protoTimestampStringParser.parse((String) map.get("experimentStartTime"));
                        long parseLong = Long.parseLong((String) map.get("triggerTimeoutMillis"));
                        long parseLong2 = Long.parseLong((String) map.get("timeToLiveMillis"));
                        String str3 = (String) map.get("experimentId");
                        String str4 = (String) map.get("variantId");
                        if (map.containsKey("triggerEvent")) {
                            str = (String) map.get("triggerEvent");
                        } else {
                            str = "";
                        }
                        arrayList2.add(new AbtExperimentInfo(str3, str4, str, parse, parseLong, parseLong2));
                    } catch (NumberFormatException e) {
                        throw new AbtException("Could not process experiment: one of the durations could not be converted into a long.", e);
                    } catch (ParseException e2) {
                        throw new AbtException("Could not process experiment: parsing experiment start time failed.", e2);
                    }
                } else {
                    throw new AbtException(String.format("The following keys are missing from the experiment info map: %s", arrayList3));
                }
            }
            if (arrayList2.isEmpty()) {
                if (provider.get() != null) {
                    Iterator<AnalyticsConnector.ConditionalUserProperty> it2 = getAllExperimentsInAnalytics().iterator();
                    while (it2.hasNext()) {
                        provider.get().clearConditionalUserProperty(it2.next().name);
                    }
                    return;
                }
                throw new AbtException("The Analytics SDK is not available. Please check that the Analytics SDK is included in your app dependencies.");
            }
            HashSet hashSet = new HashSet();
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                hashSet.add(((AbtExperimentInfo) it3.next()).experimentId);
            }
            List<AnalyticsConnector.ConditionalUserProperty> allExperimentsInAnalytics = getAllExperimentsInAnalytics();
            HashSet hashSet2 = new HashSet();
            Iterator<AnalyticsConnector.ConditionalUserProperty> it4 = allExperimentsInAnalytics.iterator();
            while (it4.hasNext()) {
                hashSet2.add(it4.next().name);
            }
            ArrayList arrayList4 = new ArrayList();
            for (AnalyticsConnector.ConditionalUserProperty conditionalUserProperty : allExperimentsInAnalytics) {
                if (!hashSet.contains(conditionalUserProperty.name)) {
                    arrayList4.add(conditionalUserProperty);
                }
            }
            Iterator it5 = arrayList4.iterator();
            while (it5.hasNext()) {
                provider.get().clearConditionalUserProperty(((AnalyticsConnector.ConditionalUserProperty) it5.next()).name);
            }
            ArrayList arrayList5 = new ArrayList();
            Iterator it6 = arrayList2.iterator();
            while (it6.hasNext()) {
                AbtExperimentInfo abtExperimentInfo = (AbtExperimentInfo) it6.next();
                if (!hashSet2.contains(abtExperimentInfo.experimentId)) {
                    arrayList5.add(abtExperimentInfo);
                }
            }
            ArrayDeque arrayDeque = new ArrayDeque(getAllExperimentsInAnalytics());
            Integer num = this.maxUserProperties;
            String str5 = this.originService;
            if (num == null) {
                this.maxUserProperties = Integer.valueOf(provider.get().getMaxUserProperties(str5));
            }
            int intValue = this.maxUserProperties.intValue();
            Iterator it7 = arrayList5.iterator();
            while (it7.hasNext()) {
                AbtExperimentInfo abtExperimentInfo2 = (AbtExperimentInfo) it7.next();
                while (arrayDeque.size() >= intValue) {
                    provider.get().clearConditionalUserProperty(((AnalyticsConnector.ConditionalUserProperty) arrayDeque.pollFirst()).name);
                }
                abtExperimentInfo2.getClass();
                AnalyticsConnector.ConditionalUserProperty conditionalUserProperty2 = new AnalyticsConnector.ConditionalUserProperty();
                conditionalUserProperty2.origin = str5;
                conditionalUserProperty2.creationTimestamp = abtExperimentInfo2.experimentStartTime.getTime();
                conditionalUserProperty2.name = abtExperimentInfo2.experimentId;
                conditionalUserProperty2.value = abtExperimentInfo2.variantId;
                String str6 = abtExperimentInfo2.triggerEventName;
                if (TextUtils.isEmpty(str6)) {
                    str6 = null;
                }
                conditionalUserProperty2.triggerEventName = str6;
                conditionalUserProperty2.triggerTimeout = abtExperimentInfo2.triggerTimeoutInMillis;
                conditionalUserProperty2.timeToLive = abtExperimentInfo2.timeToLiveInMillis;
                provider.get().setConditionalUserProperty(conditionalUserProperty2);
                arrayDeque.offer(conditionalUserProperty2);
            }
            return;
        }
        throw new AbtException("The Analytics SDK is not available. Please check that the Analytics SDK is included in your app dependencies.");
    }
}
