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
package org.apache.griffin.measure.rule.adaptor

import org.apache.griffin.measure.process._
import org.apache.griffin.measure.process.temp._
import org.apache.griffin.measure.rule.step.{CalcTimeInfo, TimeInfo}
import org.apache.griffin.measure.utils.JsonUtil
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{BeforeAndAfter, FunSuite, Matchers}
import org.scalamock.scalatest.MockFactory

@RunWith(classOf[JUnitRunner])
class GriffinDslAdaptorTest extends FunSuite with Matchers with BeforeAndAfter with MockFactory {

  test ("profiling groupby") {
//    val adaptor = GriffinDslAdaptor("source" :: Nil, "count" :: Nil, BatchProcessType, RunPhase)
    val adaptor = GriffinDslAdaptor("source" :: Nil, "count" :: Nil)

    val ruleJson =
      """
        |{
        |  "dsl.type": "griffin-dsl",
        |  "dq.type": "profiling",
        |  "name": "prof",
        |  "rule": "count(*)",
        |  "details": {
        |    "source": "source",
        |    "persist.type": "record"
        |  }
        |}
      """.stripMargin

    // rule: Map[String, Any]
    val rule: Map[String, Any] = JsonUtil.toAnyMap(ruleJson)
    println(rule)

//    val dataCheckerMock = mock[DataChecker]
//    dataCheckerMock.existDataSourceName _ expects ("source") returning (true)
//    RuleAdaptorGroup.dataChecker = dataCheckerMock

    val dsTmsts = Map[String, Set[Long]](("source" -> Set[Long](1234)))
//    val steps = adaptor.genConcreteRuleStep(TimeInfo(0, 0), rule, dsTmsts)
//    val steps = adaptor.genConcreteRuleStep(TimeInfo(1, 2), rule)

//    steps.foreach { step =>
//      println(s"${step}")
//    }

    val timeInfo = CalcTimeInfo(123)
    TempTables.registerTempTableNameOnly(timeInfo.key, "source")

    val ris = adaptor.genRuleInfos(rule, timeInfo)
    ris.foreach(println)
  }

  test ("accuracy") {
//    val adaptor = GriffinDslAdaptor("source" :: "target" :: Nil, "count" :: Nil, StreamingProcessType, RunPhase)
//
//    val ruleJson =
//      """
//        |{
//        |  "dsl.type": "griffin-dsl",
//        |  "dq.type": "accuracy",
//        |  "name": "accu",
//        |  "rule": "source.id = target.id and source.name = target.name",
//        |  "details": {
//        |    "source": "source",
//        |    "target": "target",
//        |    "persist.type": "metric"
//        |  }
//        |}
//      """.stripMargin
//
//    // rule: Map[String, Any]
//    val rule: Map[String, Any] = JsonUtil.toAnyMap(ruleJson)
//    println(rule)
//
//    val dataCheckerMock = mock[DataChecker]
//    dataCheckerMock.existDataSourceName _ expects ("source") returns (true)
//    dataCheckerMock.existDataSourceName _ expects ("target") returns (true)
//    RuleAdaptorGroup.dataChecker = dataCheckerMock
//
//    val dsTmsts = Map[String, Set[Long]](("source" -> Set[Long](1234)), ("target" -> Set[Long](1234)))
//    val steps = adaptor.genConcreteRuleStep(TimeInfo(0, 0), rule, dsTmsts)
//
//    steps.foreach { step =>
//      println(s"${step}, ${step.ruleInfo.persistType}")
//    }
  }

}
