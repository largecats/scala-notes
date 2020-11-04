package main.scala

object MissionAssignment {
  def assign[A, B](aircraft: A, recommend: A => Pilot[B]): Pilot[B] = {
    recommend(aircraft)
  }

  def select_fighter_pilot(aircraft: FighterAircraft): Pilot[FighterAircraft] = {
    println(s"Mission requires a pilot who can fly the ${aircraft.getClass.getSimpleName} ${aircraft.name}")
    val pilot = new FighterPilot
    println(s"Selected a ${pilot.getClass.getSimpleName}")
    pilot
  }

  def select_combat_pilot(aircraft: CombatAircraft): Pilot[CombatAircraft] = {
    println(s"Mission requires a pilot who can fly the ${aircraft.getClass.getSimpleName} ${aircraft.name}")
    val pilot = new CombatPilot
    println(s"Selected a ${pilot.getClass.getSimpleName}")
    pilot
  }

  def select_generic_pilot(aircraft: Aircraft): Pilot[Aircraft] = { // accept the most generic type, return the most specific type
    println(s"Mission requires a pilot who can fly the ${aircraft.getClass.getSimpleName} ${aircraft.name}")
    val pilot = new GenericPilot
    println(s"Selected a ${pilot.getClass.getSimpleName}")
    pilot
  }


}

