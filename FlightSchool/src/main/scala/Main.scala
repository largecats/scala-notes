package main.scala

object Main extends App {
  val boeing737 = new CivilianAircraft("Boeing 737")
  val u2 = new MilitaryAircraft("Lockheed U-2")
  val f22 = new FighterAircraft("Lockheed Martin F-22 Raptor")

  val tom = GenericPilot("Tom")
  val henry = MilitaryPilot("Henry")
  val rose = FighterPilot("Rose")

  rose.fly(f22)

  henry.fly(u2)
  henry.fly(f22)

  tom.fly(boeing737)
  tom.fly(u2)
  tom.fly(f22)
}
