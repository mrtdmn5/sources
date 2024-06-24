package com.amazonaws.services.securitytoken.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class AssumeRoleWithSAMLResult implements Serializable {
    private AssumedRoleUser assumedRoleUser;
    private String audience;
    private Credentials credentials;
    private String issuer;
    private String nameQualifier;
    private Integer packedPolicySize;
    private String sourceIdentity;
    private String subject;
    private String subjectType;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AssumeRoleWithSAMLResult)) {
            return false;
        }
        AssumeRoleWithSAMLResult assumeRoleWithSAMLResult = (AssumeRoleWithSAMLResult) obj;
        if (assumeRoleWithSAMLResult.getCredentials() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getCredentials() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getCredentials() != null && !assumeRoleWithSAMLResult.getCredentials().equals(getCredentials())) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getAssumedRoleUser() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getAssumedRoleUser() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getAssumedRoleUser() != null && !assumeRoleWithSAMLResult.getAssumedRoleUser().equals(getAssumedRoleUser())) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getPackedPolicySize() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getPackedPolicySize() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getPackedPolicySize() != null && !assumeRoleWithSAMLResult.getPackedPolicySize().equals(getPackedPolicySize())) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getSubject() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (getSubject() == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getSubject() != null && !assumeRoleWithSAMLResult.getSubject().equals(getSubject())) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getSubjectType() == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (getSubjectType() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getSubjectType() != null && !assumeRoleWithSAMLResult.getSubjectType().equals(getSubjectType())) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getIssuer() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (getIssuer() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 ^ z12) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getIssuer() != null && !assumeRoleWithSAMLResult.getIssuer().equals(getIssuer())) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getAudience() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (getAudience() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z13 ^ z14) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getAudience() != null && !assumeRoleWithSAMLResult.getAudience().equals(getAudience())) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getNameQualifier() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (getNameQualifier() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z15 ^ z16) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getNameQualifier() != null && !assumeRoleWithSAMLResult.getNameQualifier().equals(getNameQualifier())) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getSourceIdentity() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (getSourceIdentity() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z17 ^ z18) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getSourceIdentity() == null || assumeRoleWithSAMLResult.getSourceIdentity().equals(getSourceIdentity())) {
            return true;
        }
        return false;
    }

    public AssumedRoleUser getAssumedRoleUser() {
        return this.assumedRoleUser;
    }

    public String getAudience() {
        return this.audience;
    }

    public Credentials getCredentials() {
        return this.credentials;
    }

    public String getIssuer() {
        return this.issuer;
    }

    public String getNameQualifier() {
        return this.nameQualifier;
    }

    public Integer getPackedPolicySize() {
        return this.packedPolicySize;
    }

    public String getSourceIdentity() {
        return this.sourceIdentity;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getSubjectType() {
        return this.subjectType;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int r1 = 0;
        if (getCredentials() == null) {
            hashCode = 0;
        } else {
            hashCode = getCredentials().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getAssumedRoleUser() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getAssumedRoleUser().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getPackedPolicySize() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getPackedPolicySize().hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        if (getSubject() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getSubject().hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        if (getSubjectType() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getSubjectType().hashCode();
        }
        int r05 = (r04 + hashCode5) * 31;
        if (getIssuer() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getIssuer().hashCode();
        }
        int r06 = (r05 + hashCode6) * 31;
        if (getAudience() == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = getAudience().hashCode();
        }
        int r07 = (r06 + hashCode7) * 31;
        if (getNameQualifier() == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = getNameQualifier().hashCode();
        }
        int r08 = (r07 + hashCode8) * 31;
        if (getSourceIdentity() != null) {
            r1 = getSourceIdentity().hashCode();
        }
        return r08 + r1;
    }

    public void setAssumedRoleUser(AssumedRoleUser assumedRoleUser) {
        this.assumedRoleUser = assumedRoleUser;
    }

    public void setAudience(String str) {
        this.audience = str;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public void setIssuer(String str) {
        this.issuer = str;
    }

    public void setNameQualifier(String str) {
        this.nameQualifier = str;
    }

    public void setPackedPolicySize(Integer num) {
        this.packedPolicySize = num;
    }

    public void setSourceIdentity(String str) {
        this.sourceIdentity = str;
    }

    public void setSubject(String str) {
        this.subject = str;
    }

    public void setSubjectType(String str) {
        this.subjectType = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getCredentials() != null) {
            sb.append("Credentials: " + getCredentials() + ",");
        }
        if (getAssumedRoleUser() != null) {
            sb.append("AssumedRoleUser: " + getAssumedRoleUser() + ",");
        }
        if (getPackedPolicySize() != null) {
            sb.append("PackedPolicySize: " + getPackedPolicySize() + ",");
        }
        if (getSubject() != null) {
            sb.append("Subject: " + getSubject() + ",");
        }
        if (getSubjectType() != null) {
            sb.append("SubjectType: " + getSubjectType() + ",");
        }
        if (getIssuer() != null) {
            sb.append("Issuer: " + getIssuer() + ",");
        }
        if (getAudience() != null) {
            sb.append("Audience: " + getAudience() + ",");
        }
        if (getNameQualifier() != null) {
            sb.append("NameQualifier: " + getNameQualifier() + ",");
        }
        if (getSourceIdentity() != null) {
            sb.append("SourceIdentity: " + getSourceIdentity());
        }
        sb.append("}");
        return sb.toString();
    }

    public AssumeRoleWithSAMLResult withAssumedRoleUser(AssumedRoleUser assumedRoleUser) {
        this.assumedRoleUser = assumedRoleUser;
        return this;
    }

    public AssumeRoleWithSAMLResult withAudience(String str) {
        this.audience = str;
        return this;
    }

    public AssumeRoleWithSAMLResult withCredentials(Credentials credentials) {
        this.credentials = credentials;
        return this;
    }

    public AssumeRoleWithSAMLResult withIssuer(String str) {
        this.issuer = str;
        return this;
    }

    public AssumeRoleWithSAMLResult withNameQualifier(String str) {
        this.nameQualifier = str;
        return this;
    }

    public AssumeRoleWithSAMLResult withPackedPolicySize(Integer num) {
        this.packedPolicySize = num;
        return this;
    }

    public AssumeRoleWithSAMLResult withSourceIdentity(String str) {
        this.sourceIdentity = str;
        return this;
    }

    public AssumeRoleWithSAMLResult withSubject(String str) {
        this.subject = str;
        return this;
    }

    public AssumeRoleWithSAMLResult withSubjectType(String str) {
        this.subjectType = str;
        return this;
    }
}
