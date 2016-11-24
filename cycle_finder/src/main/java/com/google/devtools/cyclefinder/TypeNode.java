/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.devtools.cyclefinder;

import org.eclipse.jdt.core.dom.ITypeBinding;

/**
 * A representation of a Java TypeMirror, condensed for use as a node in the reference graph.
 */
class TypeNode {

  private final String signature;
  private final String name;
  private final ITypeBinding typeBinding;

  TypeNode(ITypeBinding type, String name) {
    signature = type.getKey();
    this.name = name;
    typeBinding = type;
  }

  public String getSignature() {
    return signature;
  }

  public String getName() {
    return name;
  }

  public ITypeBinding getTypeBinding() {
    return typeBinding;
  }

  @Override
  public int hashCode() {
    return signature.hashCode();
  }

  @Override
  public boolean equals(Object other) {
    return other == this
        || (other instanceof TypeNode && signature.equals(((TypeNode) other).signature));
  }

  @Override
  public String toString() {
    return signature;
  }
}
