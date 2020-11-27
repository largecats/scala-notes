package main.scala

trait Mission[+A] {
  val name: String
  val aircraft: A
  def test[B>:A](pilot: Pilot[B]): Unit = {
    try {
      pilot.fly(aircraft)
      println("Pilot able to perform mission")
    } catch {
      case _: Throwable => println("Pilot not able to perform mission")
    }
  }
}

case class GenericMission(val name: String, val aircraft: Aircraft) extends Mission[Aircraft]

case class CombatMission(val name: String, val aircraft: CombatAircraft) extends Mission[CombatAircraft]

case class FighterMission(val name: String, val aircraft: FighterAircraft) extends Mission[FighterAircraft]


object Mission {
  def print_mission_briefing(mission: Mission[Aircraft]): Unit = {
    println(s"Mission ${mission.name} requires a pilot who can fly the ${mission.aircraft.name} ${mission.aircraft.getClass.getSimpleName}")
  }

  def assign[A, B](aircraft: A, select_pilot: A => Pilot[B]): Pilot[B] = {
    select_pilot(aircraft)
  }

  def select_fighter_pilot[A<:FighterAircraft](aircraft: FighterAircraft): Pilot[FighterAircraft] = {
    val pilot = new FighterPilot
    println(s"Trained a ${pilot.getClass.getSimpleName}")
    pilot
  }

  def select_combat_pilot[A<:FighterAircraft](aircraft: CombatAircraft): Pilot[CombatAircraft] = {
    val pilot = new CombatPilot
    println(s"Trained a ${pilot.getClass.getSimpleName}")
    pilot
  }

  def select_generic_pilot[A<:FighterAircraft](aircraft: Aircraft): Pilot[Aircraft] = { // accept the most generic type, return the most specific type
    val pilot = new GenericPilot
    println(s"Trained a ${pilot.getClass.getSimpleName}")
    pilot
  }

}

