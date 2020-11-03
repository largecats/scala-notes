package main.scala

trait Pilot[-A] {
  def name: String
  def fly(aircraft: A): Unit
}

case class GenericPilot(val name: String) extends Pilot[Aircraft] {

  def fly(aircraft: Aircraft): Unit = {
    println(s"${name}: I fly ${aircraft.name}")
  }
}

case class MilitaryPilot(val name: String) extends Pilot[MilitaryAircraft] {

  def fly(aircraft: MilitaryAircraft): Unit = {
    println(s"${name}: I fly ${aircraft.name}")
  }
}

case class FighterPilot(val name: String) extends Pilot[FighterAircraft] {

  def fly(aircraft: FighterAircraft): Unit = {
    println(s"${name}: I fly ${aircraft.name}")
  }
}

object Flight {

  def start_flight(pilot: Pilot[Aircraft], aircraft: Aircraft): Unit = {
    pilot.fly(aircraft)
  }
}
