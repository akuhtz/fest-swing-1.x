/*
 * Created on Dec 26, 2009
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
 * Copyright @2009-2010 the original author or authors.
 */
package org.fest.swing.fixture;

import javax.swing.JTree;

import org.fest.swing.exception.ActionFailedException;

/**
 * Understands functional testing of single nodes in <code>{@link JTree}</code>s:
 * <ul>
 * <li>user input simulation</li>
 * <li>state verification</li>
 * <li>property value query</li>
 * </ul>
 *
 * @author Alex Ruiz
 *
 * @since 1.2
 */
public interface JTreeNodeFixture extends ItemFixture {

  /**
   * Simulates a user expanding this fixture's tree node.
   * @return this fixture.
   * @throws IllegalStateException if the {@code JTree} is disabled.
   * @throws IllegalStateException if the {@code JTree} is not showing on the screen.
   * @throws ActionFailedException if this method fails to expand the row.
   */
  JTreeNodeFixture expand();

  /**
   * Simulates a user collapsing this fixture's tree node.
   * @return this fixture.
   * @throws IllegalStateException if the {@code JTree} is disabled.
   * @throws IllegalStateException if the {@code JTree} is not showing on the screen.
   * @throws ActionFailedException if this method fails to collapse the row.
   */
  JTreeNodeFixture collapse();
}
