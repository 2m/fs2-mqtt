/*
 * Copyright 2014 Frédéric Cabestre
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

package net.sigusr.mqtt.api

import cats.Show
import enumeratum.values._

sealed abstract class QualityOfService(val value: Int) extends IntEnumEntry

object QualityOfService extends IntEnum[QualityOfService] {
  object AtMostOnce extends QualityOfService(0)
  object AtLeastOnce extends QualityOfService(1)
  object ExactlyOnce extends QualityOfService(2)

  val values: IndexedSeq[QualityOfService] = findValues

  implicit val showPerson: Show[QualityOfService] = Show.show {
    case AtMostOnce => "at most once"
    case AtLeastOnce => "at least once"
    case ExactlyOnce => "exactly once"
  }
}