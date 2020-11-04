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

  def select_fighter_pilot[A<:FighterAircraft](aircraft: FighterAircraft)(implicit pilots: List[Pilot[A]]): Pilot[FighterAircraft] = {
    val pilot = select_most_capable_pilot(pilots.collect { case p: FighterPilot => p })
    print(s"Selected ")
    Pilot.print_pilot_profile(pilot)
    pilot
  }

  def select_combat_pilot[A<:FighterAircraft](aircraft: CombatAircraft)(implicit pilots: List[Pilot[A]]): Pilot[CombatAircraft] = {
    val pilot = select_most_capable_pilot(pilots.collect { case p: CombatPilot => p })
    print(s"Selected ")
    Pilot.print_pilot_profile(pilot)
    pilot
  }

  def select_generic_pilot[A<:FighterAircraft](aircraft: Aircraft)(implicit pilots: List[Pilot[A]]): Pilot[Aircraft] = { // accept the most generic type, return the most specific type
    val pilot = select_most_capable_pilot(pilots.collect { case p: GenericPilot => p })
    print(s"Selected ")
    Pilot.print_pilot_profile(pilot)
    pilot
  }

  def select_pilot[A<:FighterAircraft](aircraft: Aircraft)(implicit pilots: List[Pilot[A]]): Pilot[A] = {
    var shortListedPilots = pilots
    aircraft match {
      case FighterAircraft => shortListedPilots = pilots.collect { case p: Pilot[FighterAircraft] => p }
      case CombatAircraft => shortListedPilots = pilots.collect { case p: Pilot[CombatAircraft] => p }
      case Aircraft => shortListedPilots = pilots.collect { case p: Pilot[Aircraft] => p }
    }
    shortListedPilots.foreach(Pilot.print_pilot_profile(_))
    val pilot = select_most_capable_pilot(shortListedPilots)
    print(s"Selected ")
    Pilot.print_pilot_profile(pilot)
    pilot
  }

//  def short_list_pilots

  def select_most_capable_pilot[A](pilots: List[Pilot[A]]): Pilot[A] = {
    var candidate = pilots(0)
    for (pilot <- pilots) {
      if (candidate.capability < pilot.capability) {
        candidate = pilot
      }
    }
    candidate
  }


}

