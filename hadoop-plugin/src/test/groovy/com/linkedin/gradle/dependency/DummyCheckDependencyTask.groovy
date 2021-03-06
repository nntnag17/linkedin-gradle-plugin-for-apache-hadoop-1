/*
 * Copyright 2015 LinkedIn Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.linkedin.gradle.dependency;

import org.gradle.api.Project;

class DummyCheckDependencyTask extends CheckDependencyTask {

  String dummyDependencyJsonFile;

  /**
   * We should override this method to return the dummyXml file created by the unit tests
   * @param project The gradle project
   * @return The xml file
   */
    @Override
    String getDependencyPatternFile(Project project) {
      return dummyDependencyJsonFile;
    }

  /**
   * Method to set the dummyDependencyJsonFile by the unit tests.
   * @param fileName The filename to set.
   */
  void setDummyDependencyJsonFile(String dummyDependencyJsonFile) {
    this.dummyDependencyJsonFile = dummyDependencyJsonFile;
  }

}
