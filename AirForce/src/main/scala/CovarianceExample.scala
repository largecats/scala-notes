package main.scala

object CovarianceExample extends App {
  // aircrafts
  val u2 = new SpyAircraft("Lockheed U-2")
  val c130 = new CargoAircraft("Lockheed C-130 Hercules")
  val b2 = new BomberAircraft("Northrop Grumman B-2 Spirit")
  val f22 = new FighterAircraft("Lockheed Martin F-22 Raptor")

  // formations
  val genericFormation = new GenericFormation(leader=c130, wingman=f22)
  val combatFormation = new CombatFormation(leader=b2, wingman=f22)
  val fighterFormation = new FighterFormation(leader=f22, wingman=f22)

  // print formation profiles
  def print_formation_profile(formation: Formation[Aircraft]): Unit = {
    println(s"A ${formation.getClass.getSimpleName}\nleader: ${formation.leader.name}\nwingman: ${formation.wingman.name}\n")
  }
  print_formation_profile(genericFormation)
  print_formation_profile(combatFormation) // if Formation were not covariant, combatFormation and fighterFormation won't compile
  print_formation_profile(fighterFormation)
}
