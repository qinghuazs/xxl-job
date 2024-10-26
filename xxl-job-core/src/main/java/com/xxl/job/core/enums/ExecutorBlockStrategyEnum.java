package com.xxl.job.core.enums;

/**
 * ExecutorBlockStrategyEnum 是 XXL-JOB 中用于处理任务执行阻塞策略的枚举类型，它定义了当执行器节点忙碌时，新任务如何被处理的几种策略。
 * SERIAL_EXECUTION（串行执行）：这是默认的阻塞策略。当任务正在执行或队列中有待执行的任务时，新任务会进入排队等待执行。这意味着相同 jobId 的任务会按照顺序一个接一个地执行，即使有多个任务触发，也会被串行处理。
 * DISCARD_LATER（丢弃后续调度）：如果执行器节点正在忙碌，那么新来的任务将被直接丢弃，不会执行。这种策略适用于那些可以容忍任务丢失的场景，例如日志采集、数据采集等。
 * COVER_EARLY（覆盖之前调度）：如果执行器节点正在忙碌，那么新来的任务会替换掉当前正在执行的任务，立即开始执行新任务。这种策略适用于那些需要尽快获得执行结果的任务，例如实时性要求较高的任务。
 */
public enum ExecutorBlockStrategyEnum {

    SERIAL_EXECUTION("Serial execution"),
    DISCARD_LATER("Discard Later"),
    COVER_EARLY("Cover Early");

    private String title;
    private ExecutorBlockStrategyEnum (String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public static ExecutorBlockStrategyEnum match(String name, ExecutorBlockStrategyEnum defaultItem) {
        if (name != null) {
            for (ExecutorBlockStrategyEnum item:ExecutorBlockStrategyEnum.values()) {
                if (item.name().equals(name)) {
                    return item;
                }
            }
        }
        return defaultItem;
    }
}
