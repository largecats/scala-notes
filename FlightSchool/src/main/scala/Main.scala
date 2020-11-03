package main.scala

object Main extends App {
  val boeing737 = new PassengerAircraft("Boeing 737")
  val u2 = new MilitaryAircraft("Lockheed U-2")
  val f22 = new FighterAircraft("Lockheed Martin F-22 Raptor")

  val tom = GenericPilot("Tom")
  val henry = MilitaryPilot("Henry")
  val rose = FighterPilot("Rose")

  Pilot.fly_fighter(rose, f22)

  Pilot.fly_military(henry, u2)
  Pilot.fly_fighter(henry, f22)

  Pilot.fly_civilian(tom, boeing737)
  Pilot.fly_military(tom, u2)
  Pilot.fly_fighter(tom, f22)
}
