package com.baizhi.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class MessageUtil {
    public static void getMessage(String phone){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAImFdQcYDwMNnW", "ZuijJWKU0uYsa7oQipJNh8xI6eqoyo");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "小熊饼干网");
        request.putQueryParameter("TemplateCode", "SMS_163432998");
        String vcode = "";
        for (int i = 0; i < 6; i++) {
            vcode = vcode + (int)(Math.random() * 9);
        }
        request.putQueryParameter("TemplateParam", "{'code':'"+vcode+"'}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (
                ServerException e) {
            e.printStackTrace();
        } catch (
                ClientException e) {
            e.printStackTrace();
        }
    }
    }

