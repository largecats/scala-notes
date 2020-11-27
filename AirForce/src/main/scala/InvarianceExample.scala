package main.scala

object InvarianceExample extends App {
  val u2 = new SpyAircraft("Lockheed U-2")
  val f22 = new FighterAircraft("Lockheed Martin F-22 Raptor")

  val SpyPatrol = new Patrol[SpyAircraft](u2)
  SpyPatrol.print_flight_log()

  // if Patrol were to be covariant in A, the following illegal operation would be possible:
  //  val genericDuty: Patrol[Aircraft] = SpyPatrol
  //  genericDuty.aircraftOnPatrol = f22
  //  val SpyAircraft: SpyAircraft = SpyPatrol.aircraftOnPatrol // the u-2 would become f22, which has severe implications in terms of international relations

}
