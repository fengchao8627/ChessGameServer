package info.xiaomo.server.system.role;

import info.xiaomo.gameCore.base.tuple.TwoTuple;
import info.xiaomo.server.entify.Role;
import info.xiaomo.server.system.attribute.AttributeCalculator;
import info.xiaomo.server.system.attribute.entity.Attribute;
import info.xiaomo.server.system.constant.AttributeConst.AttributeType;
import info.xiaomo.server.system.constant.AttributeConst.AttributeType.*;

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
 * Date  : 2017/9/2 17:02
 * desc  :
 * Copyright(©) 2017 by xiaomo.
 */
public class RoleBasicAttributeCalculator implements AttributeCalculator<Role> {
    @Override
    public TwoTuple<Attribute, Attribute> calculator(Role performer) {
        return null;
    }

    @Override
    public void fixAdd(Role performer, Attribute base, Attribute delta) {

    }

    @Override
    public void percentAdd(Role performer, Attribute base, Attribute delta) {

    }

    @Override
    public AttributeType getType() {
        return AttributeType.Role.BASIC;
    }
}
