package main.scala

object FunctionVarianceExample extends App {
  // aircraft
  val b2 = new BomberAircraft("Northrop Grumman B-2 Spirit")

  // mission
  val mission = CombatMission(name = "Operation Sunset", aircraft = b2)
  Mission.print_mission_briefing(mission)

  // function covariant in parameter type, contravariant in return type
  //  val trainedFighterPilot = Mission.assign(mission.aircraft, Mission.train_fighter_pilot) // tran_fighter_pilot: FighterAircraft => Pilot[FighterAircraft]
  //  mission.test(trainedFighterPilot) // type error
  val trainedCombatPilot = Mission.assign(mission.aircraft, Mission.train_combat_pilot) // train_combat_pilot: CombatAircraft => Pilot[CombatAircraft]
  mission.test(trainedCombatPilot)
  var trainedGenericPilot = Mission.assign(mission.aircraft, Mission.train_generic_pilot) // train_generic_pilot: Aircraft => Pilot[Aircraft]
  mission.test(trainedGenericPilot)
}
