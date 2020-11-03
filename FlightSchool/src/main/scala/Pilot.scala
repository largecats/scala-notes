package main.scala

trait Pilot[-A] {
  def name: String
  def title: String
}

case class GenericPilot(val name: String) extends Pilot[Aircraft] {
  def title: String = "Generic pilot"
}

case class MilitaryPilot(val name: String) extends Pilot[MilitaryAircraft] {
  def title: String = "Military pilot"
}

case class FighterPilot(val name: String) extends Pilot[FighterAircraft] {
  def title: String = "Fighter pilot"
}

object Pilot {
  def fly_generic(pilot: Pilot[Aircraft], aircraft: Aircraft): Unit = {
    println(s"${pilot.name}: I'm a ${pilot.title}, and I'm flying a ${aircraft.name}")
  }

  def fly_civilian(pilot: Pilot[CivilianAircraft], aircraft: CivilianAircraft): Unit = {
    println(s"${pilot.name}: I'm a ${pilot.title}, and I'm flying a ${aircraft.name}")
  }

  def fly_military(pilot: Pilot[MilitaryAircraft], aircraft: MilitaryAircraft): Unit = {
    println(s"${pilot.name}: I'm a ${pilot.title}, and I'm flying a ${aircraft.name}")
  }

  def fly_fighter(pilot: Pilot[FighterAircraft], aircraft: FighterAircraft): Unit = {
    println(s"${pilot.name}: I'm a ${pilot.title}, and I'm flying a ${aircraft.name}")
  }
}