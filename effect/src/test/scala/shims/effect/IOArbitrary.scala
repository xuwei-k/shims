/*
 * Copyright 2019 Daniel Spiewak
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

package shims.effect

import scalaz.effect.IO
import org.scalacheck.{Arbitrary, Gen}, Arbitrary.arbitrary

object IOArbitrary {

  implicit def arbitraryIO[A: Arbitrary]: Arbitrary[IO[A]] =
    Arbitrary(genIO[A])

  def genIO[A: Arbitrary]: Gen[IO[A]] = arbitrary[A].map(IO(_))
}
