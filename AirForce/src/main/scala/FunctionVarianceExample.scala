package main.scala

object FunctionVarianceExample extends App {
  // aircraft
  val b2 = new BomberAircraft("Northrop Grumman B-2 Spirit")

  // mission
  val mission = CombatMission(name = "Operation Sunset", aircraft = b2)
  Mission.print_mission_briefing(mission)

  // function covariant in parameter type, contravariant in return type
  //  val selectedFighterPilot = Mission.assign(mission.aircraft, Mission.select_fighter_pilot) // tran_fighter_pilot: FighterAircraft => Pilot[FighterAircraft]
  //  mission.test(selectedFighterPilot) // type error
  val selectedCombatPilot = Mission.assign(mission.aircraft, Mission.select_combat_pilot) // select_combat_pilot: CombatAircraft => Pilot[CombatAircraft]
  mission.test(selectedCombatPilot)
  var selectedGenericPilot = Mission.assign(mission.aircraft, Mission.select_generic_pilot) // select_generic_pilot: Aircraft => Pilot[Aircraft]
  mission.test(selectedGenericPilot)
}
