/*
 * Created on Feb 23, 2008
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2008-2010 the original author or authors.
 */
package org.fest.swing.core;

import static org.fest.swing.core.FocusOwnerFinder.focusOwner;

import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Attaches itself to a <code>{@link Component}</code> and keeps record of when the {@code Component} gains or loses
 * focus.
 *
 * @author Alex Ruiz
 */
final class FocusMonitor implements FocusListener {

  private volatile boolean focused = false;

  static FocusMonitor attachTo(Component c) {
    FocusMonitor monitor = new FocusMonitor(c);
    c.addFocusListener(monitor);
    return monitor;
  }

  private FocusMonitor(Component c) {
    focused = focusOwner() == c;
  }

  public void focusGained(FocusEvent e) {
    focused = true;
  }

  public void focusLost(FocusEvent e) {
    focused = false;
  }

  boolean hasFocus() { return focused; }
}
