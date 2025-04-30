package com.webank.wecrosssdk.rpc.methods.response;

import com.webank.wecrosssdk.rpc.methods.Response;

public class SubscribeResponse extends Response<Object> {
    public SubscribeResponse() {
        super();
    }

    public Object getResult() {
        return getData();
    }

    public void setResult(Object res) {
        setData(res);
    }
}
