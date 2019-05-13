package com.baizhi.service;

import java.util.Map;

public interface FrontService {
    Map<String,Object> getFirstPage(String uid,String type);
   // Map<String,Object> getDetail(String id,String uidc);
    Map<String,Object> getWen(String id,String uid);

}
