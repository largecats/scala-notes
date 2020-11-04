package main.scala

object InvarianceExample extends App {
  val u2 = new ReconnaissanceAircraft("Lockheed U-2")
  val f22 = new FighterAircraft("Lockheed Martin F-22 Raptor")

  val reconnaissanceDuty = new PatrolDuty[ReconnaissanceAircraft](u2)
  reconnaissanceDuty.print_flight_log()

  // if PatrolDuty were to be covariant in A, the following illegal operation would be possible:
  //  val genericDuty: PatrolDuty[Aircraft] = reconnaissanceDuty
  //  genericDuty.aircraftOnPatrolDuty = f22
  //  val reconnaissanceAircraft: ReconnaissanceAircraft = reconnaissanceDuty.aircraftOnPatrolDuty // the u-2 would become f22, which has severe implications in terms of international relations

}
