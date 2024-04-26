package com.webank.wecrosssdk.rpc.common.account;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.google.common.base.Objects;

public class ChainMakerPublicAccount extends ChainAccount {
    private String authType;
    private String orgId;
    private String pubKey;
    private String secKey;

    public ChainMakerPublicAccount(
            String type, boolean isDefault, String orgId, String userCert, String userKey) {
        super(type, isDefault);
        this.authType = "public";
        this.pubKey = userCert;
        this.secKey = userKey;
        this.orgId = orgId;
    }

    @JsonGetter("orgId")
    public String getOrgId() {
        return this.orgId;
    }

    @JsonSetter("orgId")
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    @JsonGetter("authType")
    public String getAuthType() {
        return this.authType;
    }

    @JsonSetter("authType")
    public void setAuthType(String authType) {
        this.authType = authType;
    }

    @JsonGetter("pubKey")
    public String getPubKey() {
        return this.pubKey;
    }

    @JsonSetter("pubKey")
    public void setPubKey(String userCert) {
        this.pubKey = userCert;
    }

    @JsonGetter("secKey")
    public String getSecKey() {
        return this.secKey;
    }

    @JsonSetter("userKey")
    public void setUserKey(String userKey) {
        this.secKey = userKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChainMakerPublicAccount)) return false;
        ChainMakerPublicAccount that = (ChainMakerPublicAccount) o;
        return Objects.equal(authType, that.authType)
                && Objects.equal(pubKey, that.pubKey)
                && Objects.equal(secKey, that.secKey)
                && Objects.equal(orgId, that.orgId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(type, authType, pubKey, orgId);
    }

    @Override
    public String toString() {
        return "{"
                + "\"authType\":\""
                + authType
                + "\""
                + ", \"orgId\":\""
                + orgId
                + "\""
                + ", \"keyID\":\""
                + keyID
                + "\""
                + ", \"type\":\""
                + type
                + "\""
                + ", \"userCert\":\""
                + pubKey
                + "\""
                + ", \"isDefault\":\""
                + isDefault
                + "\"}";
    }

    @Override
    public String toFormatString() {
        return "\t"
                + type
                + " Account:\n"
                + "\tkeyID    : "
                + keyID
                + "\n"
                + "\ttype     : "
                + type
                + "\n"
                + "\tisDefault: "
                + isDefault
                + "\n\t----------\n";
    }

    @Override
    public String toDetailString() {
        return "\t"
                + type
                + " Account:\n"
                + "\tkeyID    : "
                + keyID
                + "\n"
                + "\ttype     : "
                + type
                + "\n"
                + "\tuserCert   : "
                + pubKey
                + "\n"
                + "\tisDefault: "
                + isDefault
                + "\n"
                + "\tchainDefault: "
                + chainDefault
                + "\n\t----------\n";
    }
}
