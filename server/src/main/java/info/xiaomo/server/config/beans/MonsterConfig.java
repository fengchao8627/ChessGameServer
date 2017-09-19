package info.xiaomo.server.config.beans;

import info.xiaomo.gameCore.config.IConfig;
import info.xiaomo.gameCore.config.annotation.Config;
import info.xiaomo.gameCore.config.annotation.Table;
import lombok.Data;
import lombok.ToString;

/**
 * 怪物配置
 */
@ToString
@Data
@Config
@Table(name = "cfg_item", primaryKey = {"id", "secondId"})
public class MonsterConfig implements IConfig {

    /**
     * 怪物ID
     */
    private int mid;

    private int type;
    /**
     * 怪物名称
     */
    private String name;
    /**
     * 怪物等级
     */
    private int level;

    /**
     * 血量
     */
    private int hp;

    /**
     * 最小物攻
     */
    private int phyAtt;
    /**
     * 最大物攻
     */
    private int phyAttMax;
    /**
     * 最小魔攻
     */
    private int magicAtt;
    /**
     * 最大魔攻
     */
    private int magicAttMax;
    /**
     * 最小道攻
     */
    private int taoAtt;
    /**
     * 最大道攻
     */
    private int taoAttMax;
    /**
     * 最小物防
     */
    private int phyDef;
    /**
     * 最大物防
     */
    private int phyDefMax;
    /**
     * 最小魔防
     */
    private int magicDef;
    /**
     * 最大魔防
     */
    private int magicDefMax;


    /**
     * 攻速
     */
    private int attackSpeed;


    /**
     * 是否可移动
     */
    private int moveSpeed;

    private int aiType;

    /**
     * 选择目标
     */
    private int[] targetChoose;

    /**
     * 脚本id
     */
    private int scriptId;

    /**
     * 追击范围
     */
    private int toAttackArea;

    /**
     * 攻击范围（最小可攻击距离）
     */
    private int attackArea;

    /**
     * 心跳
     */
    private int heart;

    /**
     * 复活时间间隔
     */
    private int reliveDelay;

    /**
     * 复活类型
     * 1 固定时间
     * 2. 每天定点复活
     */
    private int reliveType;


    /**
     * 尸体清除时间
     */
    private int dieDelay;


    /**
     * 怪物经验
     */
    private int exp;


    /**
     * 移动速度
     */
    private int moveInterval;

    /**
     * 是否可被诱惑
     */
    private int summon;


    /**
     * 所有仇恨列表中的玩家共享杀怪计数
     */
    private int hateShare;

    /**
     * 队伍所有成员共享杀怪计数
     */
    private int teamShare;

    /**
     * 单次步子大小
     */
    private int moveStep;


    /**
     * 战斗自动回复值
     */
    private int fightRecover;

    /**
     * 被攻击时是否只扣固定的伤害（目前为1点血） 为1时扣1点血
     */
    private int fixHurt;

    /**
     * 是否掉落 0无 1有
     */
    private int drop;
}