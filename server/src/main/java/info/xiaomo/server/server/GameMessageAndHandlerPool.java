package info.xiaomo.server.server;

import info.xiaomo.gameCore.network.pool.MessageAndHandlerPool;
import info.xiaomo.server.protocol.UserProto.*;
import info.xiaomo.server.system.user.handler.LoginHandler;

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
 * Date  : 2017/9/11 15:55
 * desc  :
 * Copyright(©) 2017 by xiaomo.
 */

public class GameMessageAndHandlerPool extends MessageAndHandlerPool {

    public GameMessageAndHandlerPool() {
        registerUser();
    }


    public void registerUser() {
        register(101101, LoginRequest.getDefaultInstance(), LoginHandler.class);
        register(101102, LoginResponse.getDefaultInstance());
    }
}
