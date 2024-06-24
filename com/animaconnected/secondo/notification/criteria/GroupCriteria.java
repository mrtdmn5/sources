package com.animaconnected.secondo.notification.criteria;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class GroupCriteria extends Criteria {
    final List<Criteria> mCriteriaList = new ArrayList();

    public boolean add(Criteria criteria) {
        return this.mCriteriaList.add(criteria);
    }
}
