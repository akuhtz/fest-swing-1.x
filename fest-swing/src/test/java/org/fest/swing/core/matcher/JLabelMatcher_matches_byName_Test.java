/*
 * Created on Jul 16, 2008
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
 * Copyright @2008-2010 the original author or authors.
 */
package org.fest.swing.core.matcher;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.swing.test.builder.JLabels.label;

import javax.swing.JLabel;

import org.fest.swing.test.core.EDTSafeTestCase;
import org.junit.Test;

/**
 * Tests for <code>{@link JLabelMatcher#matches(java.awt.Component)}</code>.
 *
 * @author Alex Ruiz
 */
public class JLabelMatcher_matches_byName_Test extends EDTSafeTestCase {

  @Test
  public void should_return_true_if_name_is_equal_to_expected() {
    String name = "label";
    JLabelMatcher matcher = JLabelMatcher.withName(name);
    JLabel label = label().withName(name).createNew();
    assertThat(matcher.matches(label)).isTrue();
  }

  @Test
  public void should_return_false_if_name_is_not_equal_to_expected() {
    JLabelMatcher matcher = JLabelMatcher.withName("label");
    JLabel label = label().withName("button").createNew();
    assertThat(matcher.matches(label)).isFalse();
  }
}
