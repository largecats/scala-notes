package main.scala

object ContravarianceExample extends App {
  // aircrafts
  val u2 = new SpyAircraft("Lockheed U-2")
  val b2 = new BomberAircraft("Northrop Grumman B-2 Spirit")
  val f22 = new FighterAircraft("Lockheed Martin F-22 Raptor")

  // pilots
  val genericPilot = new GenericPilot
  val combatPilot = new CombatPilot
  val fighterPilot = new FighterPilot

  // flying!
  Pilot.fly_fighter(fighterPilot, f22)

  Pilot.fly_combat(combatPilot, b2)
  Pilot.fly_fighter(combatPilot, f22)

  Pilot.fly_generic(genericPilot, u2)
  Pilot.fly_combat(genericPilot, b2)
  Pilot.fly_fighter(genericPilot, f22)
}
