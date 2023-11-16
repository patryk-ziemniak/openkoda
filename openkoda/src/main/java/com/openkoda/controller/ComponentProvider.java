/*
MIT License

Copyright (c) 2016-2023, Openkoda CDX Sp. z o.o. Sp. K. <openkoda.com>

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice
shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR 
A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR 
IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package com.openkoda.controller;

import com.openkoda.controller.common.PageAttributes;
import com.openkoda.core.flow.TransactionalExecutor;
import com.openkoda.core.helper.Messages;
import com.openkoda.core.tracker.LoggingComponentWithRequestId;
import com.openkoda.repository.Repositories;
import com.openkoda.service.Services;
import jakarta.inject.Inject;
import org.springframework.beans.factory.InitializingBean;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * <p>Class that aggregates all Services, Repositories and Controllers so that it can be extended by other
 * Spring components and reduce the need for injecting beans.</p>
 *
 * @author Arkadiusz Drysch (adrysch@stratoflow.com)
 * 
 */
public class ComponentProvider implements PageAttributes, LoggingComponentWithRequestId, InitializingBean {

    @Inject
    public Services services;

    @Inject
    public Repositories repositories;

    @Inject
    public Controllers controllers;

    @Inject
    public Messages messages;

    protected Supplier<TransactionalExecutor> transactional = () -> services.transactionalExecutor;

    public final static Map<String, Object> resources = new HashMap<>();
    private static boolean initialized = false;

    @Override
    public void afterPropertiesSet() throws Exception {
        if(!initialized) {
            initialized = true;
            resources.put("services", services);
            resources.put("repositories", repositories);
        }
    }
}
