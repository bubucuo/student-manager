package com.tbl.studentmanager.utils;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.tbl.studentmanager.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SysUtils {

//    private static Map<String, UserInfo> userInfoMap = new ConcurrentHashMap<>();
    private static LoadingCache<String, UserInfo> cache = CacheBuilder.newBuilder()
            .maximumSize(10000)
            .expireAfterWrite(24, TimeUnit.DAYS)
            .build(new CacheLoader<String, UserInfo>() {
                @Override
                public UserInfo load(String key) {
                    // 当缓存中没有对应的key时，通过这个方法加载
                    return null;
                }
            });

    public static final List<Integer> roleIds = Arrays.asList(1,2);

    public static UserInfo getCache(String key){
        try {
            return cache.get(key);
        } catch (Exception e) {
            return null;
        }
    }

    public static UserInfo getUserInfo() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            // 使用request对象
            String auth = request.getHeader("Authorization");
            return getCache(auth);
        }
        return null;
    }

    public static void setUserInfo(UserInfo userInfo) {
        cache.put(userInfo.getSessionId(), userInfo);
        log.info("user {} login success", userInfo.getUserId());
    }

    public static void removeUserInfo() {
        UserInfo userInfo = getUserInfo();
        if (userInfo != null) {
            cache.invalidate(userInfo.getSessionId());
        }
    }

    public static String  encodePwd(String pwd) {
        return DigestUtil.getSHA256Hex(pwd);
    }

    public static void checkAdmin(){
        UserInfo userInfo = getUserInfo();
        if (userInfo == null) {
            throw new ServiceException("请登录");
        }
        if (userInfo.getRollId() == 2) {
            throw new ServiceException("权限不足");
        }
    }

    public static void checkOnline(){
        UserInfo userInfo = getUserInfo();
        if (userInfo == null) {
            throw new ServiceException(401, "请登录");
        }
    }

    public static void checkRole(Integer roleId) {
        if (!roleIds.contains(roleId)){
            throw new ServiceException("roleId is not exist");
        }
    }
}
