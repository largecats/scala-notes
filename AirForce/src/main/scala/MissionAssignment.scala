package main.scala

object MissionAssignment {
  def assign[A, B](aircraft: A, recommend: A => Pilot[B]): Pilot[B] = {
    val pilot = recommend(aircraft)
    pilot
  }

  def recommend_best_fighter_pilot(aircraft: Aircraft): Pilot[FighterAircraft] = {
    val pilot = new FighterPilot
    println(s"Mission requires a pilot who can fly the ${aircraft.getClass.getSimpleName} ${aircraft.name}")
    println(s"Selected a ${pilot.getClass.getSimpleName}")
    pilot
  }

  def recommend_best_combat_pilot(aircraft: Aircraft): Pilot[CombatAircraft] = {
    val pilot = new CombatPilot
    println(s"Mission requires a pilot who can fly the ${aircraft.getClass.getSimpleName} ${aircraft.name}")
    println(s"Selected a ${pilot.getClass.getSimpleName}")
    pilot
  }

  def recommend_best_generic_pilot(aircraft: Aircraft): Pilot[Aircraft] = { // accept the most generic type, return the most specific type
    val pilot = new GenericPilot
    println(s"Mission requires a pilot who can fly the ${aircraft.getClass.getSimpleName} ${aircraft.name}")
    println(s"Selected a ${pilot.getClass.getSimpleName}")
    pilot
  }


}

