package com.webank.wecrosssdk.rpc.methods.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webank.wecrosssdk.rpc.common.account.BCOSAccount;
import com.webank.wecrosssdk.rpc.common.account.ChainAccount;
import com.webank.wecrosssdk.rpc.common.account.FabricAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginWithoutPwdRequest {
    private String username;
    private String clientType = "sdk";
    private String authCode = "";
    private ChainAccount chainAccount;

    // sa-token相关
    private String tokenKey;
    private String tokenVal;

    @JsonIgnore private Logger logger = LoggerFactory.getLogger(LoginWithoutPwdRequest.class);

    public LoginWithoutPwdRequest(String username, String tokenKey, String tokenVal, ChainAccount chainAccount) {
        this.username = username;
        this.tokenKey = tokenKey;
        this.tokenVal = tokenVal;
        this.chainAccount = chainAccount;
    }

    public LoginWithoutPwdRequest(String username, String tokenKey, String tokenVal) {
        this.username = username;
        this.tokenKey = tokenKey;
        this.tokenVal = tokenVal;
    }

    public LoginWithoutPwdRequest(String type, ChainAccount chainAccount) {
        switch (type) {
            case "BCOS3.0":
            case "GM_BCOS3.0":
            case "GM_BCOS2.0":
            case "BCOS2.0":
                {
                    this.chainAccount = new BCOSAccount(chainAccount);
                    logger.debug("this.chainAccount is {}", this.chainAccount);
                    break;
                }
            case "Fabric1.4":
            case "Fabric2.0":
                {
                    this.chainAccount = new FabricAccount(chainAccount);
                    logger.debug("this.chainAccount is {}", this.chainAccount);
                    break;
                }
            default:
                {
                    logger.warn("type {} is not support now!", type);
                }
        }
    }

    public LoginWithoutPwdRequest() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public ChainAccount getChainAccount() {
        return chainAccount;
    }

    public void setChainAccount(ChainAccount chainAccount) {
        this.chainAccount = chainAccount;
    }

    public String getTokenKey() {
        return tokenKey;
    }

    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }

    public String getTokenVal() {
        return tokenVal;
    }

    public void setTokenVal(String tokenVal) {
        this.tokenVal = tokenVal;
    }

    @Override
    public String toString() {
        String result =
                "UARequest{"
                        + "username='"
                        + username
                        + '\''
                        + ", tokenKey='"
                        + tokenKey
                        + '\''
                        + ", tokenVal='"
                        + tokenVal
                        + '\''
                        + ", clientType='"
                        + clientType
                        + '\''
                        + ", authCode='"
                        + authCode
                        + '\'';

        result +=
                (chainAccount == null) ? "" : ", chainAccount= '" + chainAccount.toString() + '\'';
        result += "}";
        return result;
    }
}
