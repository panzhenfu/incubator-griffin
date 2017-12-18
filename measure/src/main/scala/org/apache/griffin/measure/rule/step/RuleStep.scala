/*
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
*/
package org.apache.griffin.measure.rule.step

import java.util.concurrent.atomic.AtomicLong

import org.apache.griffin.measure.rule.dsl._

trait RuleStep extends Serializable {

  val dslType: DslType

  val timeInfo: TimeInfo

  val ruleInfo: RuleInfo

  def name = ruleInfo.name

}

//case class TimeInfo(calcTime: Long, tmst: Long, head: String = "") {
//  def key: String = if (head.nonEmpty) s"${head}${calcTime}" else s"${calcTime}"
//  def setHead(h: String): TimeInfo = TimeInfo(calcTime, tmst, h)
//}





