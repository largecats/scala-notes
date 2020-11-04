package main.scala

object Main extends App {
  val u2 = new ReconnaissanceAircraft("Lockheed U-2")
  val c130 = new CargoAircraft("Lockheed C-130 Hercules")
  val b2 = new BomberAircraft("Northrop Grumman B-2 Spirit")
  val f22 = new FighterAircraft("Lockheed Martin F-22 Raptor")

  // covariance
  println("Covariance examples: ")
  val alpha = GenericWing(name="alpha", aircrafts=List(c130, c130, u2, b2, b2, f22))
  val bravo = CombatWing(name="bravo", aircrafts=List(b2, b2, f22, f22))
  val charlie = FighterWing(name="charlie", aircrafts=List(f22, f22, f22))
  Wing.print_wing_profile(alpha) // if Wing were not covariant, bravo and charlie won't compile
  Wing.print_wing_profile(bravo)
  Wing.print_wing_profile(charlie)

  // contravariance
  println("Contravariance examples: ")
  val alice = new GenericPilot(name = "Alice", capability = 90)
  val bob = new CombatPilot(name = "Bob", capability = 95)
  val charles = new FighterPilot(name = "Charles", capability = 100)
  val tom = new FighterPilot(name = "Tom", capability = 90)
  val henry = new FighterPilot("Henry", capability = 80)
  val jack = new CombatPilot("Jack", capability = 90)
  implicit val pilots: List[Pilot[FighterAircraft]] = List(alice, bob, charles, tom, henry, jack)
  pilots.foreach(Pilot.print_pilot_profile(_))

  Pilot.fly_fighter(charles, f22)

  Pilot.fly_combat(bob, b2)
  Pilot.fly_fighter(bob, f22)

  Pilot.fly_generic(alice, u2)
  Pilot.fly_combat(alice, b2)
  Pilot.fly_fighter(alice, f22)

  // invariance
  // if PatrolDuty were to be covariant in A, the following illegal operation would be possible:
//  val reconnaissanceDuty: PatrolDuty[ReconnaissanceAircraft] = new PatrolDuty[ReconnaissanceAircraft](u2)
//  val genericDuty: PatrolDuty[Aircraft] = reconnaissanceDuty
//  genericDuty.aircraftOnPatrolDuty = f22
//  val reconnaissanceAircraft: ReconnaissanceAircraft = reconnaissanceDuty.aircraftOnPatrolDuty // the u-2 would become f22, which has severe implications in terms of international relations

  // function covariant in parameter type, contravariant in return type
  println("Function covariant in parameter type, contravariant in return type examples: ")
  val mission = CombatMission(name = "Operation Sunset", aircraft = b2)
  Mission.print_mission_briefing(mission)
//  val selectedFighterPilot = Mission.assign(mission.aircraft, Mission.select_fighter_pilot) // type error
//  mission.test(selectedFighterPilot)
  val selectedCombatPilot = Mission.assign(mission.aircraft, Mission.select_combat_pilot)
  mission.test(selectedCombatPilot)
  var selectedGenericPilot = Mission.assign(mission.aircraft, Mission.select_generic_pilot)
  mission.test(selectedGenericPilot)
  var selectedPilot = Mission.assign(mission.aircraft, Mission.select_pilot)
//  mission.test(selectedPilot)

}
