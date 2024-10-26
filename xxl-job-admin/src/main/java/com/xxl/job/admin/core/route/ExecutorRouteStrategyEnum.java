package com.xxl.job.admin.core.route;

import com.xxl.job.admin.core.route.strategy.*;
import com.xxl.job.admin.core.util.I18nUtil;

/**
 * 路由策略
 * http://localhost:8080/docs/scheduler/xxlrouter.html#%E5%BF%99%E7%A2%8C%E8%BD%AC%E7%A7%BB
 */
public enum ExecutorRouteStrategyEnum {

    /**
     * 第一个地址
     */
    FIRST(I18nUtil.getString("jobconf_route_first"), new ExecutorRouteFirst()),
    /**
     * 最后一个地址
     */
    LAST(I18nUtil.getString("jobconf_route_last"), new ExecutorRouteLast()),
    /**
     * 轮询
     */
    ROUND(I18nUtil.getString("jobconf_route_round"), new ExecutorRouteRound()),
    /**
     * 随机
     */
    RANDOM(I18nUtil.getString("jobconf_route_random"), new ExecutorRouteRandom()),
    /**
     * 一致性哈希
     */
    CONSISTENT_HASH(I18nUtil.getString("jobconf_route_consistenthash"), new ExecutorRouteConsistentHash()),
    /**
     * LFU 最不经常使用
     */
    LEAST_FREQUENTLY_USED(I18nUtil.getString("jobconf_route_lfu"), new ExecutorRouteLFU()),
    /**
     * LRU 最近最少使用
     */
    LEAST_RECENTLY_USED(I18nUtil.getString("jobconf_route_lru"), new ExecutorRouteLRU()),
    /**
     * 故障转移
     */
    FAILOVER(I18nUtil.getString("jobconf_route_failover"), new ExecutorRouteFailover()),
    /**
     * 忙碌转移
     */
    BUSYOVER(I18nUtil.getString("jobconf_route_busyover"), new ExecutorRouteBusyover()),
    /**
     * 分片广播
     */
    SHARDING_BROADCAST(I18nUtil.getString("jobconf_route_shard"), null);

    ExecutorRouteStrategyEnum(String title, ExecutorRouter router) {
        this.title = title;
        this.router = router;
    }

    private String title;
    private ExecutorRouter router;

    public String getTitle() {
        return title;
    }
    public ExecutorRouter getRouter() {
        return router;
    }

    public static ExecutorRouteStrategyEnum match(String name, ExecutorRouteStrategyEnum defaultItem){
        if (name != null) {
            for (ExecutorRouteStrategyEnum item: ExecutorRouteStrategyEnum.values()) {
                if (item.name().equals(name)) {
                    return item;
                }
            }
        }
        return defaultItem;
    }

}
