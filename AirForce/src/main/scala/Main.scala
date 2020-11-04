package main.scala

object Main extends App {
  val u2 = new ReconnaissanceAircraft("Lockheed U-2")
  val c130 = new CargoAircraft("Lockheed C-130 Hercules")
  val b2 = new BomberAircraft("Northrop Grumman B-2 Spirit")
  val f22 = new FighterAircraft("Lockheed Martin F-22 Raptor")

  // covariance
  println("Covariance examples: ")
  val alpha = GenericWing("alpha", List(c130, c130, u2, b2, b2, f22))
  val bravo = CombatWing("bravo", List(b2, b2, f22, f22))
  val charlie = FighterWing("charlie", List(f22, f22, f22))
  Wing.print_wing_profile(alpha) // if Wing were not covariant, bravo and charlie won't compile
  Wing.print_wing_profile(bravo)
  Wing.print_wing_profile(charlie)

  // contravariance
  println("Contravariance examples: ")
  val tom = new GenericPilot
  val henry = new CombatPilot
  val rose = new FighterPilot

  Pilot.fly_fighter(rose, f22)

  Pilot.fly_combat(henry, b2)
  Pilot.fly_fighter(henry, f22)

  Pilot.fly_generic(tom, u2)
  Pilot.fly_combat(tom, b2)
  Pilot.fly_fighter(tom, f22)

  // invariance
  // if Shift were to be covariant in A, the following illegal operation would be possible:
//  val reconnaissanceDuty: PatrolDuty[ReconnaissanceAircraft] = new PatrolDuty[ReconnaissanceAircraft](u2)
//  val genericDuty: PatrolDuty[Aircraft] = reconnaissanceDuty
//  genericDuty.aircraftOnPatrolDuty = f22
//  val reconnaissanceAircraft: ReconnaissanceAircraft = reconnaissanceDuty.aircraftOnPatrolDuty // the u-2 would become f22

  // function covariant in parameter type, contravariant in return type
  println("Function covariant in parameter type, contravariant in return type examples: ")
  val missionFighterAircraft = f22
  val selectedFighterPilot = MissionAssignment.assign(missionFighterAircraft, MissionAssignment.recommend_best_fighter_pilot)
  Pilot.fly_fighter(selectedFighterPilot, missionFighterAircraft)
  val selectedCombatPilot = MissionAssignment.assign(missionFighterAircraft, MissionAssignment.recommend_best_combat_pilot)
  Pilot.fly_fighter(selectedCombatPilot, missionFighterAircraft)
  var selectedGenericPilot = MissionAssignment.assign(missionFighterAircraft, MissionAssignment.recommend_best_generic_pilot)
  Pilot.fly_fighter(selectedGenericPilot, missionFighterAircraft)

}
