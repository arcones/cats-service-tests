package simulation

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.core.structure.ScenarioBuilder
import scala.concurrent.duration._

class LoadTestRunner extends Simulation {

  val feature: ScenarioBuilder = scenario("Mad german boy retrieving cats")
    .exec(karateFeature("src/test/java/com/zooplus/cats/load/Load.feature"))

  setUp(feature.inject(rampUsers(100) over (1 seconds)))
    .assertions(global.failedRequests.count.is(0))
}