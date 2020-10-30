package com.df.dtss.common.event;

import com.xy.cola.dto.Response;
import com.xy.cola.event.DomainEventI;
import com.xy.cola.event.EventBusI;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * DomainEventPublisher, this is for demo purpose, the Event is sent to EventBus
 * <p>
 * Normally DomainEvent should be sent to Messaging Middleware
 *
 * @author Frank Zhang
 * @date 2019-01-04 11:05 AM
 */
@Component
public class DomainEventPublisher {

    @Resource
    private EventBusI eventBus;

    /**
     * 发布事件
     * @param domainEvent 事件
     * @return 处理结果
     */
    public Response publish(DomainEventI domainEvent) {
        return eventBus.fireWithResponse(domainEvent);
    }
}