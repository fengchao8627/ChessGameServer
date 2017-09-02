package info.xiaomo.server.system.attribute;

import info.xiaomo.gameCore.base.tuple.TwoTuple;
import info.xiaomo.server.entify.Role;
import info.xiaomo.server.system.attribute.entity.Attribute;
import info.xiaomo.server.system.constant.AttributeConst.AttributeType;
import info.xiaomo.server.system.role.RoleBasicAttributeCalculator;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;


/**
 * 属性管理类
 *
 * @author zhangli
 * 2017年6月6日 下午9:49:28
 */
@Slf4j
public class AttributeManager {


    private static final AttributeManager INSTANCE = new AttributeManager();

    private final Map<AttributeType, AttributeCalculator<Role>> playerAttributeCalculators = new HashMap<>();


    public static AttributeManager getInstance() {
        return INSTANCE;
    }

    private AttributeManager() {

        // 玩家基础属性
        playerAttributeCalculators.put(AttributeType.Role.BASIC, new RoleBasicAttributeCalculator());


    }

    /**
     * 计算玩家属性
     *
     * @param role 角色
     * @param type 属性计算器类型
     */
    public void countAttribute(Role role, AttributeType type) {


        AttributeCalculator<Role> calculator = playerAttributeCalculators.get(type);
        if (calculator == null) {
            return;
        }
        TwoTuple<Attribute, Attribute> attributeTwoTuple = calculator.calculator(role);
        role.getAttributes().put(type, attributeTwoTuple);


        Attribute newAttribute = playerFinalAttribute(role);
        role.setFinalAttribute(newAttribute);


    }

    /**
     * 创建角色属性
     *
     * @param role 角色
     * @return
     */
    public Attribute createPlayerAttribute(Role role) {

        for (AttributeCalculator<Role> calculator : playerAttributeCalculators.values()) {
            TwoTuple<Attribute, Attribute> attr = calculator.calculator(role);
            role.getAttributes().put(calculator.getType(), attr);
        }
        return playerFinalAttribute(role);
    }


    /**
     * 计算玩家最终属性
     *
     * @param role
     * @return
     */
    public Attribute playerFinalAttribute(Role role) {
        Attribute fix = new Attribute();
        Attribute percent = new Attribute();
        Map<AttributeType, TwoTuple<Attribute, Attribute>> attributes = role.getAttributes();
        for (AttributeType type : AttributeType.Role.values()) {
            TwoTuple<Attribute, Attribute> attr = attributes.get(type);
            if (attr == null) {
                continue;
            }

            AttributeCalculator<Role> calculator = playerAttributeCalculators.get(type);
            if (calculator == null) {
                continue;
            }

            if (attr.first != null) {
                calculator.fixAdd(role, fix, attr.first);
            }
            if (attr.second != null) {
                calculator.percentAdd(role, percent, attr.second);
            }
        }
        fix.percentAdd(percent);
        return fix;
    }


}
