/*
 * Copyright 2016 The BigDL Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intel.analytics.bigdl.dllib.utils.tf.loaders

import java.nio.ByteOrder

import com.intel.analytics.bigdl.Module
import com.intel.analytics.bigdl.dllib.nn.ops.{Inv => InvOps}
import com.intel.analytics.bigdl.dllib.tensor.TensorNumericMath.TensorNumeric
import com.intel.analytics.bigdl.dllib.utils.tf.Context
import org.tensorflow.framework.{DataType, NodeDef}

import scala.reflect.ClassTag

class Inv extends TensorflowOpsLoader {

  import Utils._

  override def build[T: ClassTag](nodeDef: NodeDef, byteOrder: ByteOrder, context: Context[T])
    (implicit ev: TensorNumeric[T]): Module[T] = {
    val t = getType(nodeDef.getAttrMap, "T")
    if (t == DataType.DT_FLOAT) {
      InvOps[T, Float]()
    } else if (t == DataType.DT_DOUBLE) {
      InvOps[T, Double]()
    } else {
      throw new UnsupportedOperationException(s"Not support load Inv when type is ${t}")
    }
  }
}
