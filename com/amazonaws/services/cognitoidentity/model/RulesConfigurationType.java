package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class RulesConfigurationType implements Serializable {
    private List<MappingRule> rules;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RulesConfigurationType)) {
            return false;
        }
        RulesConfigurationType rulesConfigurationType = (RulesConfigurationType) obj;
        if (rulesConfigurationType.getRules() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getRules() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (rulesConfigurationType.getRules() == null || rulesConfigurationType.getRules().equals(getRules())) {
            return true;
        }
        return false;
    }

    public List<MappingRule> getRules() {
        return this.rules;
    }

    public int hashCode() {
        int hashCode;
        if (getRules() == null) {
            hashCode = 0;
        } else {
            hashCode = getRules().hashCode();
        }
        return 31 + hashCode;
    }

    public void setRules(Collection<MappingRule> collection) {
        if (collection == null) {
            this.rules = null;
        } else {
            this.rules = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getRules() != null) {
            sb.append("Rules: " + getRules());
        }
        sb.append("}");
        return sb.toString();
    }

    public RulesConfigurationType withRules(MappingRule... mappingRuleArr) {
        if (getRules() == null) {
            this.rules = new ArrayList(mappingRuleArr.length);
        }
        for (MappingRule mappingRule : mappingRuleArr) {
            this.rules.add(mappingRule);
        }
        return this;
    }

    public RulesConfigurationType withRules(Collection<MappingRule> collection) {
        setRules(collection);
        return this;
    }
}
