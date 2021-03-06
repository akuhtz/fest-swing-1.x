/*
 * Created on Aug 6, 2008
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
package org.fest.swing.driver;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.swing.edt.GuiActionRunner.execute;

import javax.swing.JOptionPane;

import org.fest.swing.annotation.RunsInEDT;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.test.core.*;
import org.junit.Test;

/**
 * Tests for <code>{@link JOptionPaneMessageQuery#messageOf(JOptionPane)}</code>.
 *
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class JOptionPaneMessageQuery_messageOf_Test extends RobotBasedTestCase {

  private static final String MESSAGE = "Hello World";

  private MyOptionPane optionPane;

  @Override protected void onSetUp() {
    optionPane = MyOptionPane.createNew(MESSAGE);
  }

  @Test
  public void should_return_message_of_JOptionPane() {
    optionPane.startRecording();
    assertThat(JOptionPaneMessageQuery.messageOf(optionPane)).isEqualTo(MESSAGE);
    optionPane.requireInvoked("getMessage");
  }

  private static class MyOptionPane extends JOptionPane {
    private static final long serialVersionUID = 1L;

    private boolean recording;
    private final MethodInvocations methodInvocations = new MethodInvocations();

    @RunsInEDT
    static MyOptionPane createNew(final String message) {
      return execute(new GuiQuery<MyOptionPane>() {
        @Override protected MyOptionPane executeInEDT() {
          return new MyOptionPane(message);
        }
      });
    }

    private MyOptionPane(String message) {
      super(message, INFORMATION_MESSAGE);
    }

    @Override public Object getMessage() {
      if (recording) methodInvocations.invoked("getMessage");
      return super.getMessage();
    }

    void startRecording() { recording = true; }

    MethodInvocations requireInvoked(String methodName) {
      return methodInvocations.requireInvoked(methodName);
    }
  }
}
