/*
 * Created on Mar 31, 2010
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 * Copyright @2010 the original author or authors.
 */
package org.fest.swing.test.awt;

import static org.easymock.classextension.EasyMock.createMock;

import java.applet.AppletContext;

/**
 * Understands <code>{@link AppletContext}</code>s to be used for testing purposes.
 *
 * @author Alex Ruiz
 */
public final class TestAppletContexts {

  public static AppletContext singletonAppletContextMock() {
    return LazyLoadedSingleton.INSTANCE;
  }

  private static class LazyLoadedSingleton {
    static final AppletContext INSTANCE = appletContextMock();
  }

  public static AppletContext appletContextMock() {
    return createMock(AppletContext.class);
  }

  private TestAppletContexts() {}
}
