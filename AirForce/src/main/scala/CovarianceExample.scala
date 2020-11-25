package main.scala

object CovarianceExample extends App {
  // aircrafts
  val u2 = new SpyAircraft("Lockheed U-2")
  val c130 = new CargoAircraft("Lockheed C-130 Hercules")
  val b2 = new BomberAircraft("Northrop Grumman B-2 Spirit")
  val f22 = new FighterAircraft("Lockheed Martin F-22 Raptor")

  // wings
  val alpha = GenericWing(List(c130, c130, u2, b2, b2, f22))
  val bravo = CombatWing(List(b2, b2, f22, f22))
  val charlie = FighterWing(List(f22, f22, f22))

  // printing wing profiles
  Wing.print_wing_profile(alpha) // if Wing were not covariant, bravo and charlie won't compile
  Wing.print_wing_profile(bravo)
  Wing.print_wing_profile(charlie)
}
