package info.xiaomo.server.listener;

import info.xiaomo.server.entify.User;
import info.xiaomo.server.event.EventType;
import info.xiaomo.server.event.IEventListener;
import lombok.extern.slf4j.Slf4j;

/**
 * 把今天最好的表现当作明天最新的起点．．～
 * いま 最高の表現 として 明日最新の始発．．～
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * <p>
 * author: xiaomo
 * github: https://github.com/xiaomoinfo
 * email : xiaomo@xiaomo.info
 * QQ    : 83387856
 * Date  : 2017/7/11 19:27
 * desc  :
 * Copyright(©) 2017 by xiaomo.
 */
@Slf4j
public class LoginEventListener implements IEventListener {

    @Override
    public void update(EventType type, Object param) {
        User user = (User) param;
        log.warn("用户 {} 登录游戏", user.getLoginName());
    }
}
