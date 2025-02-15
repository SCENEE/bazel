// Copyright 2018 The Bazel Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.devtools.build.lib.skylarkinterface.processor.testsources;

import com.google.devtools.build.lib.events.Location;
import com.google.devtools.build.lib.skylarkinterface.Param;
import com.google.devtools.build.lib.skylarkinterface.SkylarkCallable;
import com.google.devtools.build.lib.skylarkinterface.SkylarkValue;
import com.google.devtools.build.lib.syntax.Dict;
import com.google.devtools.build.lib.syntax.StarlarkThread;

/**
 * Test case for a SkylarkCallable method which specifies extraKeywords, but specifies the argument
 * out of order.
 */
public class ExtraKeywordsOutOfOrder implements SkylarkValue {

  @SkylarkCallable(
      name = "extra_kwargs_out_of_order",
      documented = false,
      parameters = {@Param(name = "one")},
      extraKeywords = @Param(name = "kwargs"),
      useLocation = true,
      useStarlarkThread = true)
  public String threeArgMethod(
      Dict<?, ?> kwargs, String one, Location location, StarlarkThread thread) {
    return "bar";
  }
}
