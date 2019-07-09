package com.sinmn.mjar.ext.core;

import com.sinmn.core.utils.constant.ApiResultCode;
import com.sinmn.core.utils.exception.CommonRuntimeException;
import com.sinmn.core.utils.util.FastJsonUtils;
import com.sinmn.core.utils.util.StringUtil;
import com.sinmn.mjar.ext.redis.ExtRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Gensen.Lee
 * @date 2019/7/9 10:08
 */
@Component
public class UserExtCore {

    private static String KEY_TEMPLATE_USER = "SINMN.USER.AUTH.SESSION_KEY:%s";

    private int expireTime = 60*60*2;

    @Autowired
    private ExtRedisDao extRedisDao;

    /**保存用户会话
     * @param sessionKey    登录令牌
     * @param userInfo      登录信息
     */
    public void holdSeesion(String sessionKey, String userInfo){
        String key = String.format(KEY_TEMPLATE_USER, sessionKey);

        extRedisDao.set(key, userInfo, this.expireTime);
    }


    /**获取用户会话信息
     * @param sessionKey    登录令牌
     * @param clazz         用户信息返回类型
     * @param <T>
     * @return
     */
    public <T> T getSession(String sessionKey, Class<T> clazz){
        String key = String.format(KEY_TEMPLATE_USER, sessionKey);

        String userinfo = extRedisDao.get(key, this.expireTime);
        if (StringUtil.isEmpty(userinfo)) {
            throw new CommonRuntimeException(ApiResultCode.SESSION_KEY_ERROR);
        }
        T bean = FastJsonUtils.getBean(userinfo, clazz);
        return bean;
    }


    /**删除会话信息
     * @param sessionKey
     */
    public void removeSession(String sessionKey){
        String key = String.format(KEY_TEMPLATE_USER, sessionKey);
        extRedisDao.delete(key);
    }

}
