package main.scala

object InvarianceExample extends App {
  val u2 = new SpyAircraft("Lockheed U-2")
  val f22 = new FighterAircraft("Lockheed Martin F-22 Raptor")

  val spyPatrol = new Patrol[SpyAircraft](u2)
  spyPatrol.print_flight_log()

  // if Patrol were to be covariant in A, the following illegal operation would be possible:
//  val genericPatrol: Patrol[Aircraft] = spyPatrol // can assign because Patrol[SpyAircraft] <: Patrol[Aircraft], and so Patrol[SpyAircraft] can be used when Patrol[Aircraft] is expected
//  genericPatrol.aircraftOnPatrol = f22 // can assign because FighterAircraft <: Aircraft
//  val spyAircraft: SpyAircraft = spyPatrol.aircraftOnPatrol // we'd end up with assigning f22 to a SpyAircraft

}
