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

package com.google.devtools.build.skydoc.fakebuildapi;

import com.google.devtools.build.lib.events.Location;
import com.google.devtools.build.lib.skylarkbuildapi.OutputGroupInfoApi;
import com.google.devtools.build.lib.skylarkinterface.SkylarkPrinter;
import com.google.devtools.build.lib.syntax.Dict;
import com.google.devtools.build.lib.syntax.EvalException;

/**
 * Fake implementation of {@link OutputGroupInfoApi}.
 */
public class FakeOutputGroupInfo implements OutputGroupInfoApi {

  @Override
  public String toProto(Location loc) throws EvalException {
    return "";
  }

  @Override
  public String toJson(Location loc) throws EvalException {
    return "";
  }

  @Override
  public void repr(SkylarkPrinter printer) {

  }

  /**
   * Fake implementation of {@link OutputGroupInfoApiProvider}.
   */
  public static class FakeOutputGroupInfoProvider implements OutputGroupInfoApiProvider {

    @Override
    public OutputGroupInfoApi constructor(Dict<?, ?> kwargs, Location loc) throws EvalException {
      return new FakeOutputGroupInfo();
    }

    @Override
    public void repr(SkylarkPrinter printer) {}
  }
}
