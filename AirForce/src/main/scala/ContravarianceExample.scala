package main.scala

object ContravarianceExample extends App {
  // aircrafts
  val u2 = new ReconnaissanceAircraft("Lockheed U-2")
  val b2 = new BomberAircraft("Northrop Grumman B-2 Spirit")
  val f22 = new FighterAircraft("Lockheed Martin F-22 Raptor")

  // pilots
  val alice = new GenericPilot
  val bob = new CombatPilot
  val charles = new FighterPilot

  // flying!
  Pilot.fly_fighter(charles, f22)

  Pilot.fly_combat(bob, b2)
  Pilot.fly_fighter(bob, f22)

  Pilot.fly_generic(alice, u2)
  Pilot.fly_combat(alice, b2)
  Pilot.fly_fighter(alice, f22)
}
