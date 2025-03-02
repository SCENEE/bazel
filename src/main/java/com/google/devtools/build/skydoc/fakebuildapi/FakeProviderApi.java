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

import com.google.devtools.build.lib.skylarkbuildapi.ProviderApi;
import com.google.devtools.build.lib.skylarkinterface.SkylarkPrinter;
import com.google.devtools.build.lib.syntax.BaseFunction;
import com.google.devtools.build.lib.syntax.EvalException;
import com.google.devtools.build.lib.syntax.FuncallExpression;
import com.google.devtools.build.lib.syntax.FunctionSignature;
import com.google.devtools.build.lib.syntax.StarlarkThread;
import javax.annotation.Nullable;

/**
 * Fake implementation of {@link ProviderApi}. This fake is a subclass of {@link BaseFunction},
 * as providers are themselves callable.
 */
public class FakeProviderApi extends BaseFunction implements ProviderApi {

  /**
   * Each fake is constructed with a unique name, controlled by this counter being the name suffix.
   */
  private static int idCounter = 0;

  private final String name = "ProviderIdentifier" + idCounter++;

  public FakeProviderApi() {
    super(FunctionSignature.KWARGS);
  }

  @Override
  protected Object call(Object[] args, @Nullable FuncallExpression ast, StarlarkThread thread)
      throws EvalException, InterruptedException {
    return new FakeStructApi();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void repr(SkylarkPrinter printer) {}
}
