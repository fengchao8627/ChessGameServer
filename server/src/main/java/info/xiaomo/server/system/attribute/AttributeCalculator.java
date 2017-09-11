package info.xiaomo.server.system.attribute;

import info.xiaomo.gameCore.base.tuple.TwoTuple;
import info.xiaomo.server.system.attribute.entity.Attribute;
import info.xiaomo.server.system.attribute.constant.AttributeConst.AttributeType;

public interface AttributeCalculator<T> {

    /**
     * 计算当前系统的属性
     *
     * @param performer
     * @return
     */
    TwoTuple<Attribute, Attribute> calculator(T performer);

    /**
     * 固定累加
     *
     * @param base  base
     * @param delta delta
     */
    void fixAdd(T performer, Attribute base, Attribute delta);


    /**
     * 百分比累加
     *
     * @param base  base
     * @param delta attribute
     */
    void percentAdd(T performer, Attribute base, Attribute delta);

    /**
     * 属性类型
     *
     * @return AttributeType
     */
    AttributeType getType();

}
