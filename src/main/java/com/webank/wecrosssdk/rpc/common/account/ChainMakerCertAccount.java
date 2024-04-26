package com.webank.wecrosssdk.rpc.common.account;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Objects;
import java.util.HashMap;
import java.util.Map;

public class ChainMakerCertAccount extends ChainAccount {
    private String authType;
    private String orgId;
    private boolean pkcs11Enable;
    private String userSignCert;
    private String userSignKey;
    private String pubKey;
    private String secKey;
    private String ext;

    public ChainMakerCertAccount(
            String type,
            boolean isDefault,
            String orgId,
            boolean pkcs11Enable,
            String userSignCert,
            String userSignKey,
            String userCert,
            String userKey) {
        super(type, isDefault);
        this.authType = "permissionedWithcert";
        this.orgId = orgId;
        this.pkcs11Enable = pkcs11Enable;
        this.userSignCert = userSignCert;
        this.userSignKey = userSignKey;
        this.pubKey = userCert;
        this.secKey = userKey;

        Map<String, String> extMap = new HashMap<>();
        extMap.put("authType", "permissionedWithcert");
        extMap.put("orgId", orgId);
        extMap.put("pkcs11Enable", pkcs11Enable ? "true" : "false");
        extMap.put("userSignCert", userSignCert);
        extMap.put("userSignKey", userSignKey);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.ext = objectMapper.writeValueAsString(extMap);
        } catch (JsonProcessingException e) {
            this.ext = "";
        }
    }

    @JsonGetter("authType")
    public String getAuthType() {
        return this.authType;
    }

    @JsonSetter("authType")
    public void setAuthType(String authType) {
        this.authType = authType;
    }

    @JsonGetter("orgId")
    public String getOrgId() {
        return this.orgId;
    }

    @JsonSetter("orgId")
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    @JsonGetter("pkcs11Enable")
    public boolean getPkcs11Enable() {
        return this.pkcs11Enable;
    }

    @JsonSetter("pubKey")
    public void setPkcs11Enable(boolean pkcs11Enable) {
        this.pkcs11Enable = pkcs11Enable;
    }

    @JsonGetter("pubKey")
    public String getPubKey() {
        return this.pubKey;
    }

    @JsonSetter("pubKey")
    public void setPubKey(String userCert) {
        this.pubKey = userCert;
    }

    @JsonGetter("userSignKey")
    public String getUserSignKey() {
        return this.userSignCert;
    }

    @JsonSetter("userSignKey")
    public void setUserSignKey(String userSignKey) {
        this.userSignCert = userSignCert;
    }

    @JsonGetter("userSignCert")
    public String getUserSignCert() {
        return this.userSignCert;
    }

    @JsonSetter("userSignCert")
    public void setUserSignCert(String userSignCert) {
        this.userSignCert = userSignCert;
    }

    @JsonGetter("secKey")
    public String getSecKey() {
        return this.secKey;
    }

    @JsonSetter("userKey")
    public void setUserKey(String userKey) {
        this.secKey = userKey;
    }

    @JsonGetter("ext")
    public String getExt() {
        return this.ext;
    }

    @JsonSetter("ext")
    public void setExt(String ext) {
        this.ext = ext;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChainMakerCertAccount)) return false;
        ChainMakerCertAccount that = (ChainMakerCertAccount) o;
        return Objects.equal(authType, that.authType)
                && Objects.equal(pkcs11Enable, that.pkcs11Enable)
                && Objects.equal(userSignCert, that.userSignCert)
                && Objects.equal(userSignKey, that.userSignKey)
                && Objects.equal(pubKey, that.pubKey)
                && Objects.equal(secKey, that.secKey)
                && Objects.equal(orgId, that.orgId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(type, authType, pkcs11Enable, userSignCert, pubKey, orgId);
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
                + ", \"userSignCert\":\""
                + userSignCert
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
                + "\tuserSignCert  : "
                + userSignKey
                + "\n"
                + "\tisDefault: "
                + isDefault
                + "\n"
                + "\tchainDefault: "
                + chainDefault
                + "\n\t----------\n";
    }
}
