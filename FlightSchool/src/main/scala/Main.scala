package main.scala

import main.scala.Aircraft._

object Main extends App {
  val boeing737 = CivilianAircraft("Boeing 737")
  val u2 = MilitaryAircraft("Lockheed U-2")
  val f22 = FighterAircraft("Lockheed Martin F-22 Raptor")

  val tom = GenericPilot("Tom")
  val henry = MilitaryPilot("Henry")
  val rose = FighterPilot("Rose")


}
